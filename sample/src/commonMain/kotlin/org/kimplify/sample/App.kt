package org.kimplify.sample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.kimplify.countries.Countries
import org.kimplify.countries.extensions.getDisplayName
import org.kimplify.countries.extensions.toCountry
import org.kimplify.countries.i18n.Locale
import org.kimplify.countries.i18n.extensions.getLocalizedName
import org.kimplify.countries.model.Country

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CountriesScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf<Country?>(null) }
    var selectedLocale by remember { mutableStateOf(Locale.EN) }
    var showLocaleMenu by remember { mutableStateOf(false) }

    val filteredCountries by remember(searchQuery) {
        derivedStateOf {
            if (searchQuery.isBlank()) {
                Countries.repository.getAll()
            } else {
                val byCode = searchQuery.toCountry()
                if (byCode != null) {
                    listOf(byCode)
                } else {
                    Countries.repository.searchByName(searchQuery)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("KCountries Demo") },
                actions = {
                    Box {
                        TextButton(
                            onClick = { showLocaleMenu = true }
                        ) {
                            Text(
                                selectedLocale.code.uppercase(),
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        DropdownMenu(
                            expanded = showLocaleMenu,
                            onDismissRequest = { showLocaleMenu = false }
                        ) {
                            listOf(
                                Locale.EN to "English",
                                Locale.ES to "Español",
                                Locale.FR to "Français",
                                Locale.DE to "Deutsch",
                                Locale.AR to "العربية",
                                Locale.ZH to "中文",
                                Locale.RU to "Русский"
                            ).forEach { (locale, name) ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            name,
                                            fontWeight = if (locale == selectedLocale) FontWeight.Bold else FontWeight.Normal
                                        )
                                    },
                                    onClick = {
                                        selectedLocale = locale
                                        showLocaleMenu = false
                                    }
                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search by name or code (e.g., 'US', 'France')") },
                singleLine = true
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Library Info",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        InfoItem("Version", Countries.VERSION)
                        InfoItem("Total", Countries.TOTAL_COUNTRIES.toString())
                        InfoItem("Shown", filteredCountries.size.toString())
                        InfoItem("Languages", "7")
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(filteredCountries) { country ->
                    CountryCard(
                        country = country,
                        locale = selectedLocale,
                        onClick = { selectedCountry = country }
                    )
                }
                if (filteredCountries.isEmpty()) {
                    item {
                        Text(
                            "No matching countries",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        selectedCountry?.let { country ->
            CountryDetailsDialog(
                country = country,
                locale = selectedLocale,
                onDismiss = { selectedCountry = null }
            )
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun CountryCard(
    country: Country,
    locale: Locale,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                country.flag.value,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(end = 16.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    country.getLocalizedName(locale),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        country.alpha2.value,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (country.native != null && country.native != country.getDisplayName()) {
                        Text(
                            "•",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            country.native!!,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CountryDetailsDialog(
    country: Country,
    locale: Locale,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    country.flag.value,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Column {
                    Text(
                        country.getLocalizedName(locale),
                        style = MaterialTheme.typography.titleLarge
                    )
                    if (country.getLocalizedName(locale) != country.name.value) {
                        Text(
                            country.name.value,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                HorizontalDivider()

                DetailRow("ISO Alpha-2", country.alpha2.value)
                DetailRow("ISO Alpha-3", country.alpha3.value)
                DetailRow("Numeric Code", country.numeric.value)

                if (country.displayName != null) {
                    DetailRow("Display Name", country.displayName!!)
                }

                if (country.native != null) {
                    DetailRow("Native Name", country.native!!)
                }

                HorizontalDivider()

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        "Translations",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        "🇬🇧 ${country.getLocalizedName(Locale.EN)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇪🇸 ${country.getLocalizedName(Locale.ES)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇫🇷 ${country.getLocalizedName(Locale.FR)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇩🇪 ${country.getLocalizedName(Locale.DE)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇸🇦 ${country.getLocalizedName(Locale.AR)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇨🇳 ${country.getLocalizedName(Locale.ZH)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "🇷🇺 ${country.getLocalizedName(Locale.RU)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

@Composable
fun DetailRow(label: String, value: String) {
    Column {
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}
