package org.kimplify.countries.data

import org.kimplify.countries.model.*

/**
 * Generated data source containing all 249 countries from ISO 3166-1.
 *
 * Generation date: 2025-01-26
 * ISO 3166-1 version: 2020
 * Total entries: 249
 */
internal object CountriesData {
    val countries: List<Country> = listOf(
        Country(
            alpha2 = Alpha2Code("AD"), alpha3 = Alpha3Code("AND"), numeric = NumericCode("020"),
            name = CountryName("Andorra"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDE9"),
            native = "Andorra",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+376"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Andorra")
        ),
        Country(
            alpha2 = Alpha2Code("AE"), alpha3 = Alpha3Code("ARE"), numeric = NumericCode("784"),
            name = CountryName("United Arab Emirates (the)"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDEA"),
            displayName = "United Arab Emirates", native = "\u0627\u0644\u0625\u0645\u0627\u0631\u0627\u062A \u0627\u0644\u0639\u0631\u0628\u064A\u0629 \u0627\u0644\u0645\u062A\u062D\u062F\u0629",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+971"), currency = CurrencyCode("AED"), timezone = TimezoneId("Asia/Dubai")
        ),
        Country(
            alpha2 = Alpha2Code("AF"), alpha3 = Alpha3Code("AFG"), numeric = NumericCode("004"),
            name = CountryName("Afghanistan"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDEB"),
            native = "\u0627\u0641\u063A\u0627\u0646\u0633\u062A\u0627\u0646",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+93"), currency = CurrencyCode("AFN"), timezone = TimezoneId("Asia/Kabul")
        ),
        Country(
            alpha2 = Alpha2Code("AG"), alpha3 = Alpha3Code("ATG"), numeric = NumericCode("028"),
            name = CountryName("Antigua and Barbuda"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDEC"),
            native = "Antigua and Barbuda",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/Antigua")
        ),
        Country(
            alpha2 = Alpha2Code("AI"), alpha3 = Alpha3Code("AIA"), numeric = NumericCode("660"),
            name = CountryName("Anguilla"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDEE"),
            native = "Anguilla",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/Anguilla")
        ),
        Country(
            alpha2 = Alpha2Code("AL"), alpha3 = Alpha3Code("ALB"), numeric = NumericCode("008"),
            name = CountryName("Albania"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF1"),
            native = "Shqip\u00EBria",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+355"), currency = CurrencyCode("ALL"), timezone = TimezoneId("Europe/Tirane")
        ),
        Country(
            alpha2 = Alpha2Code("AM"), alpha3 = Alpha3Code("ARM"), numeric = NumericCode("051"),
            name = CountryName("Armenia"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF2"),
            native = "\u0540\u0561\u0575\u0561\u057D\u057F\u0561\u0576",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+374"), currency = CurrencyCode("AMD"), timezone = TimezoneId("Asia/Yerevan")
        ),
        Country(
            alpha2 = Alpha2Code("AO"), alpha3 = Alpha3Code("AGO"), numeric = NumericCode("024"),
            name = CountryName("Angola"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF4"),
            native = "Angola",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+244"), currency = CurrencyCode("AOA"), timezone = TimezoneId("Africa/Luanda")
        ),
        Country(
            alpha2 = Alpha2Code("AQ"), alpha3 = Alpha3Code("ATA"), numeric = NumericCode("010"),
            name = CountryName("Antarctica"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF6"),
            native = "Antarctica",
            continent = Continent.ANTARCTICA, region = Region.ANTARCTICA,
            callingCode = CallingCode("+672"), currency = CurrencyCode("USD"), timezone = TimezoneId("Antarctica/Palmer")
        ),
        Country(
            alpha2 = Alpha2Code("AR"), alpha3 = Alpha3Code("ARG"), numeric = NumericCode("032"),
            name = CountryName("Argentina"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF7"),
            native = "Argentina",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+54"), currency = CurrencyCode("ARS"), timezone = TimezoneId("America/Argentina/Buenos_Aires")
        ),
        Country(
            alpha2 = Alpha2Code("AS"), alpha3 = Alpha3Code("ASM"), numeric = NumericCode("016"),
            name = CountryName("American Samoa"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF8"),
            native = "American Samoa",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Pago_Pago")
        ),
        Country(
            alpha2 = Alpha2Code("AT"), alpha3 = Alpha3Code("AUT"), numeric = NumericCode("040"),
            name = CountryName("Austria"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDF9"),
            native = "\u00D6sterreich",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+43"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Vienna")
        ),
        Country(
            alpha2 = Alpha2Code("AU"), alpha3 = Alpha3Code("AUS"), numeric = NumericCode("036"),
            name = CountryName("Australia"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDFA"),
            native = "Australia",
            continent = Continent.OCEANIA, region = Region.AUSTRALIA_AND_NEW_ZEALAND,
            callingCode = CallingCode("+61"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Australia/Sydney")
        ),
        Country(
            alpha2 = Alpha2Code("AW"), alpha3 = Alpha3Code("ABW"), numeric = NumericCode("533"),
            name = CountryName("Aruba"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDFC"),
            native = "Aruba",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+297"), currency = CurrencyCode("AWG"), timezone = TimezoneId("America/Aruba")
        ),
        Country(
            alpha2 = Alpha2Code("AX"), alpha3 = Alpha3Code("ALA"), numeric = NumericCode("248"),
            name = CountryName("\u00C5land Islands"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDFD"),
            native = "\u00C5land",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+358"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Mariehamn")
        ),
        Country(
            alpha2 = Alpha2Code("AZ"), alpha3 = Alpha3Code("AZE"), numeric = NumericCode("031"),
            name = CountryName("Azerbaijan"), flag = FlagEmoji("\uD83C\uDDE6\uD83C\uDDFF"),
            native = "Az\u0259rbaycan",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+994"), currency = CurrencyCode("AZN"), timezone = TimezoneId("Asia/Baku")
        ),
        Country(
            alpha2 = Alpha2Code("BA"), alpha3 = Alpha3Code("BIH"), numeric = NumericCode("070"),
            name = CountryName("Bosnia and Herzegovina"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDE6"),
            native = "Bosna i Hercegovina",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+387"), currency = CurrencyCode("BAM"), timezone = TimezoneId("Europe/Sarajevo")
        ),
        Country(
            alpha2 = Alpha2Code("BB"), alpha3 = Alpha3Code("BRB"), numeric = NumericCode("052"),
            name = CountryName("Barbados"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDE7"),
            native = "Barbados",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("BBD"), timezone = TimezoneId("America/Barbados")
        ),
        Country(
            alpha2 = Alpha2Code("BD"), alpha3 = Alpha3Code("BGD"), numeric = NumericCode("050"),
            name = CountryName("Bangladesh"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDE9"),
            native = "\u09AC\u09BE\u0982\u09B2\u09BE\u09A6\u09C7\u09B6",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+880"), currency = CurrencyCode("BDT"), timezone = TimezoneId("Asia/Dhaka")
        ),
        Country(
            alpha2 = Alpha2Code("BE"), alpha3 = Alpha3Code("BEL"), numeric = NumericCode("056"),
            name = CountryName("Belgium"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDEA"),
            native = "Belgi\u00EB / Belgique",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+32"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Brussels")
        ),
        Country(
            alpha2 = Alpha2Code("BF"), alpha3 = Alpha3Code("BFA"), numeric = NumericCode("854"),
            name = CountryName("Burkina Faso"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDEB"),
            native = "Burkina Faso",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+226"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Ouagadougou")
        ),
        Country(
            alpha2 = Alpha2Code("BG"), alpha3 = Alpha3Code("BGR"), numeric = NumericCode("100"),
            name = CountryName("Bulgaria"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDEC"),
            native = "\u0411\u044A\u043B\u0433\u0430\u0440\u0438\u044F",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+359"), currency = CurrencyCode("BGN"), timezone = TimezoneId("Europe/Sofia")
        ),
        Country(
            alpha2 = Alpha2Code("BH"), alpha3 = Alpha3Code("BHR"), numeric = NumericCode("048"),
            name = CountryName("Bahrain"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDED"),
            native = "\u200F\u0627\u0644\u0628\u062D\u0631\u064A\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+973"), currency = CurrencyCode("BHD"), timezone = TimezoneId("Asia/Bahrain")
        ),
        Country(
            alpha2 = Alpha2Code("BI"), alpha3 = Alpha3Code("BDI"), numeric = NumericCode("108"),
            name = CountryName("Burundi"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDEE"),
            native = "Burundi",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+257"), currency = CurrencyCode("BIF"), timezone = TimezoneId("Africa/Bujumbura")
        ),
        Country(
            alpha2 = Alpha2Code("BJ"), alpha3 = Alpha3Code("BEN"), numeric = NumericCode("204"),
            name = CountryName("Benin"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDEF"),
            native = "B\u00E9nin",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+229"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Porto-Novo")
        ),
        Country(
            alpha2 = Alpha2Code("BL"), alpha3 = Alpha3Code("BLM"), numeric = NumericCode("652"),
            name = CountryName("Saint Barth\u00E9lemy"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF1"),
            native = "Saint-Barth\u00E9lemy",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+590"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/St_Barthelemy")
        ),
        Country(
            alpha2 = Alpha2Code("BM"), alpha3 = Alpha3Code("BMU"), numeric = NumericCode("060"),
            name = CountryName("Bermuda"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF2"),
            native = "Bermuda",
            continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("BMD"), timezone = TimezoneId("Atlantic/Bermuda")
        ),
        Country(
            alpha2 = Alpha2Code("BN"), alpha3 = Alpha3Code("BRN"), numeric = NumericCode("096"),
            name = CountryName("Brunei Darussalam"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF3"),
            displayName = "Brunei", native = "Brunei",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+673"), currency = CurrencyCode("BND"), timezone = TimezoneId("Asia/Brunei")
        ),
        Country(
            alpha2 = Alpha2Code("BO"), alpha3 = Alpha3Code("BOL"), numeric = NumericCode("068"),
            name = CountryName("Bolivia (Plurinational State of)"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF4"),
            displayName = "Bolivia", native = "Bolivia",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+591"), currency = CurrencyCode("BOB"), timezone = TimezoneId("America/La_Paz")
        ),
        Country(
            alpha2 = Alpha2Code("BQ"), alpha3 = Alpha3Code("BES"), numeric = NumericCode("535"),
            name = CountryName("Bonaire, Sint Eustatius and Saba"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF6"),
            native = "Caribisch Nederland",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+599"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Kralendijk")
        ),
        Country(
            alpha2 = Alpha2Code("BR"), alpha3 = Alpha3Code("BRA"), numeric = NumericCode("076"),
            name = CountryName("Brazil"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF7"),
            native = "Brasil",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+55"), currency = CurrencyCode("BRL"), timezone = TimezoneId("America/Sao_Paulo")
        ),
        Country(
            alpha2 = Alpha2Code("BS"), alpha3 = Alpha3Code("BHS"), numeric = NumericCode("044"),
            name = CountryName("Bahamas (the)"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF8"),
            displayName = "Bahamas", native = "Bahamas",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("BSD"), timezone = TimezoneId("America/Nassau")
        ),
        Country(
            alpha2 = Alpha2Code("BT"), alpha3 = Alpha3Code("BTN"), numeric = NumericCode("064"),
            name = CountryName("Bhutan"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDF9"),
            native = "\u0F60\u0F56\u0FB2\u0F74\u0F42\u0F0B\u0F61\u0F74\u0F63\u0F0B",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+975"), currency = CurrencyCode("BTN"), timezone = TimezoneId("Asia/Thimphu")
        ),
        Country(
            alpha2 = Alpha2Code("BV"), alpha3 = Alpha3Code("BVT"), numeric = NumericCode("074"),
            name = CountryName("Bouvet Island"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDFB"),
            native = "Bouvet\u00F8ya",
            continent = Continent.ANTARCTICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+47"), currency = CurrencyCode("NOK"), timezone = TimezoneId("UTC")
        ),
        Country(
            alpha2 = Alpha2Code("BW"), alpha3 = Alpha3Code("BWA"), numeric = NumericCode("072"),
            name = CountryName("Botswana"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDFC"),
            native = "Botswana",
            continent = Continent.AFRICA, region = Region.SOUTHERN_AFRICA,
            callingCode = CallingCode("+267"), currency = CurrencyCode("BWP"), timezone = TimezoneId("Africa/Gaborone")
        ),
        Country(
            alpha2 = Alpha2Code("BY"), alpha3 = Alpha3Code("BLR"), numeric = NumericCode("112"),
            name = CountryName("Belarus"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDFE"),
            native = "\u0411\u0435\u043B\u0430\u0440\u0443\u0301\u0441\u044C",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+375"), currency = CurrencyCode("BYN"), timezone = TimezoneId("Europe/Minsk")
        ),
        Country(
            alpha2 = Alpha2Code("BZ"), alpha3 = Alpha3Code("BLZ"), numeric = NumericCode("084"),
            name = CountryName("Belize"), flag = FlagEmoji("\uD83C\uDDE7\uD83C\uDDFF"),
            native = "Belize",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+501"), currency = CurrencyCode("BZD"), timezone = TimezoneId("America/Belize")
        ),
        Country(
            alpha2 = Alpha2Code("CA"), alpha3 = Alpha3Code("CAN"), numeric = NumericCode("124"),
            name = CountryName("Canada"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDE6"),
            native = "Canada",
            continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("CAD"), timezone = TimezoneId("America/Toronto")
        ),
        Country(
            alpha2 = Alpha2Code("CC"), alpha3 = Alpha3Code("CCK"), numeric = NumericCode("166"),
            name = CountryName("Cocos (Keeling) Islands (the)"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDE8"),
            displayName = "Cocos (Keeling) Islands", native = "Cocos (Keeling) Islands",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+61"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Indian/Cocos")
        ),
        Country(
            alpha2 = Alpha2Code("CD"), alpha3 = Alpha3Code("COD"), numeric = NumericCode("180"),
            name = CountryName("Congo (the Democratic Republic of the)"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDE9"),
            displayName = "Democratic Republic of the Congo", native = "R\u00E9publique d\u00E9mocratique du Congo",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+243"), currency = CurrencyCode("CDF"), timezone = TimezoneId("Africa/Kinshasa")
        ),
        Country(
            alpha2 = Alpha2Code("CF"), alpha3 = Alpha3Code("CAF"), numeric = NumericCode("140"),
            name = CountryName("Central African Republic (the)"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDEB"),
            displayName = "Central African Republic", native = "R\u00E9publique centrafricaine",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+236"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Bangui")
        ),
        Country(
            alpha2 = Alpha2Code("CG"), alpha3 = Alpha3Code("COG"), numeric = NumericCode("178"),
            name = CountryName("Congo (the)"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDEC"),
            displayName = "Republic of the Congo", native = "R\u00E9publique du Congo",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+242"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Brazzaville")
        ),
        Country(
            alpha2 = Alpha2Code("CH"), alpha3 = Alpha3Code("CHE"), numeric = NumericCode("756"),
            name = CountryName("Switzerland"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDED"),
            native = "Suisse",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+41"), currency = CurrencyCode("CHF"), timezone = TimezoneId("Europe/Zurich")
        ),
        Country(
            alpha2 = Alpha2Code("CI"), alpha3 = Alpha3Code("CIV"), numeric = NumericCode("384"),
            name = CountryName("C\u00F4te d\u2019Ivoire"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDEE"),
            native = "C\u00F4te d\u2019Ivoire",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+225"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Abidjan")
        ),
        Country(
            alpha2 = Alpha2Code("CK"), alpha3 = Alpha3Code("COK"), numeric = NumericCode("184"),
            name = CountryName("Cook Islands (the)"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF0"),
            displayName = "Cook Islands", native = "Cook Islands",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+682"), currency = CurrencyCode("NZD"), timezone = TimezoneId("Pacific/Rarotonga")
        ),
        Country(
            alpha2 = Alpha2Code("CL"), alpha3 = Alpha3Code("CHL"), numeric = NumericCode("152"),
            name = CountryName("Chile"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF1"),
            native = "Chile",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+56"), currency = CurrencyCode("CLP"), timezone = TimezoneId("America/Santiago")
        ),
        Country(
            alpha2 = Alpha2Code("CM"), alpha3 = Alpha3Code("CMR"), numeric = NumericCode("120"),
            name = CountryName("Cameroon"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF2"),
            native = "Cameroon",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+237"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Douala")
        ),
        Country(
            alpha2 = Alpha2Code("CN"), alpha3 = Alpha3Code("CHN"), numeric = NumericCode("156"),
            name = CountryName("China"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF3"),
            native = "\u4E2D\u56FD",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+86"), currency = CurrencyCode("CNY"), timezone = TimezoneId("Asia/Shanghai")
        ),
        Country(
            alpha2 = Alpha2Code("CO"), alpha3 = Alpha3Code("COL"), numeric = NumericCode("170"),
            name = CountryName("Colombia"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF4"),
            native = "Colombia",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+57"), currency = CurrencyCode("COP"), timezone = TimezoneId("America/Bogota")
        ),
        Country(
            alpha2 = Alpha2Code("CR"), alpha3 = Alpha3Code("CRI"), numeric = NumericCode("188"),
            name = CountryName("Costa Rica"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDF7"),
            native = "Costa Rica",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+506"), currency = CurrencyCode("CRC"), timezone = TimezoneId("America/Costa_Rica")
        ),
        Country(
            alpha2 = Alpha2Code("CU"), alpha3 = Alpha3Code("CUB"), numeric = NumericCode("192"),
            name = CountryName("Cuba"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFA"),
            native = "Cuba",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+53"), currency = CurrencyCode("CUP"), timezone = TimezoneId("America/Havana")
        ),
        Country(
            alpha2 = Alpha2Code("CV"), alpha3 = Alpha3Code("CPV"), numeric = NumericCode("132"),
            name = CountryName("Cabo Verde"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFB"),
            native = "Cabo Verde",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+238"), currency = CurrencyCode("CVE"), timezone = TimezoneId("Atlantic/Cape_Verde")
        ),
        Country(
            alpha2 = Alpha2Code("CW"), alpha3 = Alpha3Code("CUW"), numeric = NumericCode("531"),
            name = CountryName("Cura\u00E7ao"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFC"),
            native = "Cura\u00E7ao",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+599"), currency = CurrencyCode("ANG"), timezone = TimezoneId("America/Curacao")
        ),
        Country(
            alpha2 = Alpha2Code("CX"), alpha3 = Alpha3Code("CXR"), numeric = NumericCode("162"),
            name = CountryName("Christmas Island"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFD"),
            native = "Christmas Island",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+61"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Indian/Christmas")
        ),
        Country(
            alpha2 = Alpha2Code("CY"), alpha3 = Alpha3Code("CYP"), numeric = NumericCode("196"),
            name = CountryName("Cyprus"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFE"),
            native = "\u039A\u03CD\u03C0\u03C1\u03BF\u03C2",
            continent = Continent.EUROPE, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+357"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Asia/Nicosia")
        ),
        Country(
            alpha2 = Alpha2Code("CZ"), alpha3 = Alpha3Code("CZE"), numeric = NumericCode("203"),
            name = CountryName("Czechia"), flag = FlagEmoji("\uD83C\uDDE8\uD83C\uDDFF"),
            native = "\u010Cesko",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+420"), currency = CurrencyCode("CZK"), timezone = TimezoneId("Europe/Prague")
        ),
        Country(
            alpha2 = Alpha2Code("DE"), alpha3 = Alpha3Code("DEU"), numeric = NumericCode("276"),
            name = CountryName("Germany"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDEA"),
            native = "Deutschland",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+49"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Berlin")
        ),
        Country(
            alpha2 = Alpha2Code("DJ"), alpha3 = Alpha3Code("DJI"), numeric = NumericCode("262"),
            name = CountryName("Djibouti"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDEF"),
            native = "\u062C\u064A\u0628\u0648\u062A\u064A\u200E",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+253"), currency = CurrencyCode("DJF"), timezone = TimezoneId("Africa/Djibouti")
        ),
        Country(
            alpha2 = Alpha2Code("DK"), alpha3 = Alpha3Code("DNK"), numeric = NumericCode("208"),
            name = CountryName("Denmark"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDF0"),
            native = "Danmark",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+45"), currency = CurrencyCode("DKK"), timezone = TimezoneId("Europe/Copenhagen")
        ),
        Country(
            alpha2 = Alpha2Code("DM"), alpha3 = Alpha3Code("DMA"), numeric = NumericCode("212"),
            name = CountryName("Dominica"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDF2"),
            native = "Dominica",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/Dominica")
        ),
        Country(
            alpha2 = Alpha2Code("DO"), alpha3 = Alpha3Code("DOM"), numeric = NumericCode("214"),
            name = CountryName("Dominican Republic (the)"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDF4"),
            displayName = "Dominican Republic", native = "Rep\u00FAblica Dominicana",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("DOP"), timezone = TimezoneId("America/Santo_Domingo")
        ),
        Country(
            alpha2 = Alpha2Code("DZ"), alpha3 = Alpha3Code("DZA"), numeric = NumericCode("012"),
            name = CountryName("Algeria"), flag = FlagEmoji("\uD83C\uDDE9\uD83C\uDDFF"),
            native = "\u0627\u0644\u062C\u0632\u0627\u0626\u0631",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+213"), currency = CurrencyCode("DZD"), timezone = TimezoneId("Africa/Algiers")
        ),
        Country(
            alpha2 = Alpha2Code("EC"), alpha3 = Alpha3Code("ECU"), numeric = NumericCode("218"),
            name = CountryName("Ecuador"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDE8"),
            native = "Ecuador",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+593"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Guayaquil")
        ),
        Country(
            alpha2 = Alpha2Code("EE"), alpha3 = Alpha3Code("EST"), numeric = NumericCode("233"),
            name = CountryName("Estonia"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDEA"),
            native = "Eesti",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+372"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Tallinn")
        ),
        Country(
            alpha2 = Alpha2Code("EG"), alpha3 = Alpha3Code("EGY"), numeric = NumericCode("818"),
            name = CountryName("Egypt"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDEC"),
            native = "\u0645\u0635\u0631",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+20"), currency = CurrencyCode("EGP"), timezone = TimezoneId("Africa/Cairo")
        ),
        Country(
            alpha2 = Alpha2Code("EH"), alpha3 = Alpha3Code("ESH"), numeric = NumericCode("732"),
            name = CountryName("Western Sahara"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDED"),
            native = "Western Sahara",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+212"), currency = CurrencyCode("MAD"), timezone = TimezoneId("Africa/El_Aaiun")
        ),
        Country(
            alpha2 = Alpha2Code("ER"), alpha3 = Alpha3Code("ERI"), numeric = NumericCode("232"),
            name = CountryName("Eritrea"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDF7"),
            native = "\u0625\u0631\u062A\u0631\u064A\u0627\u200E",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+291"), currency = CurrencyCode("ERN"), timezone = TimezoneId("Africa/Asmara")
        ),
        Country(
            alpha2 = Alpha2Code("ES"), alpha3 = Alpha3Code("ESP"), numeric = NumericCode("724"),
            name = CountryName("Spain"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDF8"),
            native = "Espa\u00F1a",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+34"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Madrid")
        ),
        Country(
            alpha2 = Alpha2Code("ET"), alpha3 = Alpha3Code("ETH"), numeric = NumericCode("231"),
            name = CountryName("Ethiopia"), flag = FlagEmoji("\uD83C\uDDEA\uD83C\uDDF9"),
            native = "\u12A2\u1275\u12EE\u1335\u12EB",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+251"), currency = CurrencyCode("ETB"), timezone = TimezoneId("Africa/Addis_Ababa")
        ),
        Country(
            alpha2 = Alpha2Code("FI"), alpha3 = Alpha3Code("FIN"), numeric = NumericCode("246"),
            name = CountryName("Finland"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDEE"),
            native = "Suomi",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+358"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Helsinki")
        ),
        Country(
            alpha2 = Alpha2Code("FJ"), alpha3 = Alpha3Code("FJI"), numeric = NumericCode("242"),
            name = CountryName("Fiji"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDEF"),
            native = "Fiji",
            continent = Continent.OCEANIA, region = Region.MELANESIA,
            callingCode = CallingCode("+679"), currency = CurrencyCode("FJD"), timezone = TimezoneId("Pacific/Fiji")
        ),
        Country(
            alpha2 = Alpha2Code("FK"), alpha3 = Alpha3Code("FLK"), numeric = NumericCode("238"),
            name = CountryName("Falkland Islands (the) [Malvinas]"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF0"),
            displayName = "Falkland Islands (Malvinas)", native = "Falkland Islands",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+500"), currency = CurrencyCode("FKP"), timezone = TimezoneId("Atlantic/Stanley")
        ),
        Country(
            alpha2 = Alpha2Code("FM"), alpha3 = Alpha3Code("FSM"), numeric = NumericCode("583"),
            name = CountryName("Micronesia (Federated States of)"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF2"),
            displayName = "Micronesia", native = "Micronesia",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+691"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Pohnpei")
        ),
        Country(
            alpha2 = Alpha2Code("FO"), alpha3 = Alpha3Code("FRO"), numeric = NumericCode("234"),
            name = CountryName("Faroe Islands (the)"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF4"),
            displayName = "Faroe Islands", native = "F\u00F8royar",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+298"), currency = CurrencyCode("DKK"), timezone = TimezoneId("Atlantic/Faroe")
        ),
        Country(
            alpha2 = Alpha2Code("FR"), alpha3 = Alpha3Code("FRA"), numeric = NumericCode("250"),
            name = CountryName("France"), flag = FlagEmoji("\uD83C\uDDEB\uD83C\uDDF7"),
            native = "France",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+33"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Paris")
        ),
        Country(
            alpha2 = Alpha2Code("GA"), alpha3 = Alpha3Code("GAB"), numeric = NumericCode("266"),
            name = CountryName("Gabon"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDE6"),
            native = "Gabon",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+241"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Libreville")
        ),
        Country(
            alpha2 = Alpha2Code("GB"), alpha3 = Alpha3Code("GBR"), numeric = NumericCode("826"),
            name = CountryName("United Kingdom of Great Britain and Northern Ireland (the)"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDE7"),
            displayName = "United Kingdom", native = "United Kingdom",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+44"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Europe/London")
        ),
        Country(
            alpha2 = Alpha2Code("GD"), alpha3 = Alpha3Code("GRD"), numeric = NumericCode("308"),
            name = CountryName("Grenada"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDE9"),
            native = "Grenada",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/Grenada")
        ),
        Country(
            alpha2 = Alpha2Code("GE"), alpha3 = Alpha3Code("GEO"), numeric = NumericCode("268"),
            name = CountryName("Georgia"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDEA"),
            native = "\u10E1\u10D0\u10E5\u10D0\u10E0\u10D7\u10D5\u10D4\u10DA\u10DD",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+995"), currency = CurrencyCode("GEL"), timezone = TimezoneId("Asia/Tbilisi")
        ),
        Country(
            alpha2 = Alpha2Code("GF"), alpha3 = Alpha3Code("GUF"), numeric = NumericCode("254"),
            name = CountryName("French Guiana"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDEB"),
            native = "Guyane fran\u00E7aise",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+594"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/Cayenne")
        ),
        Country(
            alpha2 = Alpha2Code("GG"), alpha3 = Alpha3Code("GGY"), numeric = NumericCode("831"),
            name = CountryName("Guernsey"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDEC"),
            native = "Guernsey",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+44"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Europe/Guernsey")
        ),
        Country(
            alpha2 = Alpha2Code("GH"), alpha3 = Alpha3Code("GHA"), numeric = NumericCode("288"),
            name = CountryName("Ghana"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDED"),
            native = "Ghana",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+233"), currency = CurrencyCode("GHS"), timezone = TimezoneId("Africa/Accra")
        ),
        Country(
            alpha2 = Alpha2Code("GI"), alpha3 = Alpha3Code("GIB"), numeric = NumericCode("292"),
            name = CountryName("Gibraltar"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDEE"),
            native = "Gibraltar",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+350"), currency = CurrencyCode("GIP"), timezone = TimezoneId("Europe/Gibraltar")
        ),
        Country(
            alpha2 = Alpha2Code("GL"), alpha3 = Alpha3Code("GRL"), numeric = NumericCode("304"),
            name = CountryName("Greenland"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF1"),
            native = "Kalaallit Nunaat",
            continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
            callingCode = CallingCode("+299"), currency = CurrencyCode("DKK"), timezone = TimezoneId("America/Nuuk")
        ),
        Country(
            alpha2 = Alpha2Code("GM"), alpha3 = Alpha3Code("GMB"), numeric = NumericCode("270"),
            name = CountryName("Gambia (the)"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF2"),
            displayName = "Gambia", native = "Gambia",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+220"), currency = CurrencyCode("GMD"), timezone = TimezoneId("Africa/Banjul")
        ),
        Country(
            alpha2 = Alpha2Code("GN"), alpha3 = Alpha3Code("GIN"), numeric = NumericCode("324"),
            name = CountryName("Guinea"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF3"),
            native = "Guin\u00E9e",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+224"), currency = CurrencyCode("GNF"), timezone = TimezoneId("Africa/Conakry")
        ),
        Country(
            alpha2 = Alpha2Code("GP"), alpha3 = Alpha3Code("GLP"), numeric = NumericCode("312"),
            name = CountryName("Guadeloupe"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF5"),
            native = "Guadeloupe",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+590"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/Guadeloupe")
        ),
        Country(
            alpha2 = Alpha2Code("GQ"), alpha3 = Alpha3Code("GNQ"), numeric = NumericCode("226"),
            name = CountryName("Equatorial Guinea"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF6"),
            native = "Guin\u00E9e \u00E9quatoriale",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+240"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Malabo")
        ),
        Country(
            alpha2 = Alpha2Code("GR"), alpha3 = Alpha3Code("GRC"), numeric = NumericCode("300"),
            name = CountryName("Greece"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF7"),
            native = "\u0395\u03BB\u03BB\u03AC\u03B4\u03B1",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+30"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Athens")
        ),
        Country(
            alpha2 = Alpha2Code("GS"), alpha3 = Alpha3Code("SGS"), numeric = NumericCode("239"),
            name = CountryName("South Georgia and the South Sandwich Islands"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF8"),
            native = "South Georgia",
            continent = Continent.ANTARCTICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+500"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Atlantic/South_Georgia")
        ),
        Country(
            alpha2 = Alpha2Code("GT"), alpha3 = Alpha3Code("GTM"), numeric = NumericCode("320"),
            name = CountryName("Guatemala"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDF9"),
            native = "Guatemala",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+502"), currency = CurrencyCode("GTQ"), timezone = TimezoneId("America/Guatemala")
        ),
        Country(
            alpha2 = Alpha2Code("GU"), alpha3 = Alpha3Code("GUM"), numeric = NumericCode("316"),
            name = CountryName("Guam"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDFA"),
            native = "Gu\u00E5h\u00E5n",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Guam")
        ),
        Country(
            alpha2 = Alpha2Code("GW"), alpha3 = Alpha3Code("GNB"), numeric = NumericCode("624"),
            name = CountryName("Guinea-Bissau"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDFC"),
            native = "Guin\u00E9-Bissau",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+245"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Bissau")
        ),
        Country(
            alpha2 = Alpha2Code("GY"), alpha3 = Alpha3Code("GUY"), numeric = NumericCode("328"),
            name = CountryName("Guyana"), flag = FlagEmoji("\uD83C\uDDEC\uD83C\uDDFE"),
            native = "Guyana",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+592"), currency = CurrencyCode("GYD"), timezone = TimezoneId("America/Guyana")
        ),
        Country(
            alpha2 = Alpha2Code("HK"), alpha3 = Alpha3Code("HKG"), numeric = NumericCode("344"),
            name = CountryName("Hong Kong"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDF0"),
            native = "Hong Kong",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+852"), currency = CurrencyCode("HKD"), timezone = TimezoneId("Asia/Hong_Kong")
        ),
        Country(
            alpha2 = Alpha2Code("HM"), alpha3 = Alpha3Code("HMD"), numeric = NumericCode("334"),
            name = CountryName("Heard Island and McDonald Islands"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDF2"),
            native = "Heard Island and McDonald Islands",
            continent = Continent.ANTARCTICA, region = Region.AUSTRALIA_AND_NEW_ZEALAND,
            callingCode = CallingCode("+672"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Indian/Kerguelen")
        ),
        Country(
            alpha2 = Alpha2Code("HN"), alpha3 = Alpha3Code("HND"), numeric = NumericCode("340"),
            name = CountryName("Honduras"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDF3"),
            native = "Honduras",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+504"), currency = CurrencyCode("HNL"), timezone = TimezoneId("America/Tegucigalpa")
        ),
        Country(
            alpha2 = Alpha2Code("HR"), alpha3 = Alpha3Code("HRV"), numeric = NumericCode("191"),
            name = CountryName("Croatia"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDF7"),
            native = "Hrvatska",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+385"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Zagreb")
        ),
        Country(
            alpha2 = Alpha2Code("HT"), alpha3 = Alpha3Code("HTI"), numeric = NumericCode("332"),
            name = CountryName("Haiti"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDF9"),
            native = "Ha\u00EFti",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+509"), currency = CurrencyCode("HTG"), timezone = TimezoneId("America/Port-au-Prince")
        ),
        Country(
            alpha2 = Alpha2Code("HU"), alpha3 = Alpha3Code("HUN"), numeric = NumericCode("348"),
            name = CountryName("Hungary"), flag = FlagEmoji("\uD83C\uDDED\uD83C\uDDFA"),
            native = "Magyarorsz\u00E1g",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+36"), currency = CurrencyCode("HUF"), timezone = TimezoneId("Europe/Budapest")
        ),
        Country(
            alpha2 = Alpha2Code("ID"), alpha3 = Alpha3Code("IDN"), numeric = NumericCode("360"),
            name = CountryName("Indonesia"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDE9"),
            native = "Indonesia",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+62"), currency = CurrencyCode("IDR"), timezone = TimezoneId("Asia/Jakarta")
        ),
        Country(
            alpha2 = Alpha2Code("IE"), alpha3 = Alpha3Code("IRL"), numeric = NumericCode("372"),
            name = CountryName("Ireland"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDEA"),
            native = "Ireland",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+353"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Dublin")
        ),
        Country(
            alpha2 = Alpha2Code("IL"), alpha3 = Alpha3Code("ISR"), numeric = NumericCode("376"),
            name = CountryName("Israel"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF1"),
            native = "\u0625\u0633\u0631\u0627\u0626\u064A\u0644",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+972"), currency = CurrencyCode("ILS"), timezone = TimezoneId("Asia/Jerusalem")
        ),
        Country(
            alpha2 = Alpha2Code("IM"), alpha3 = Alpha3Code("IMN"), numeric = NumericCode("833"),
            name = CountryName("Isle of Man"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF2"),
            native = "Isle of Man",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+44"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Europe/Isle_of_Man")
        ),
        Country(
            alpha2 = Alpha2Code("IN"), alpha3 = Alpha3Code("IND"), numeric = NumericCode("356"),
            name = CountryName("India"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF3"),
            native = "India",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+91"), currency = CurrencyCode("INR"), timezone = TimezoneId("Asia/Kolkata")
        ),
        Country(
            alpha2 = Alpha2Code("IO"), alpha3 = Alpha3Code("IOT"), numeric = NumericCode("086"),
            name = CountryName("British Indian Ocean Territory (the)"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF4"),
            displayName = "British Indian Ocean Territory", native = "British Indian Ocean Territory",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+246"), currency = CurrencyCode("USD"), timezone = TimezoneId("Indian/Chagos")
        ),
        Country(
            alpha2 = Alpha2Code("IQ"), alpha3 = Alpha3Code("IRQ"), numeric = NumericCode("368"),
            name = CountryName("Iraq"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF6"),
            native = "\u0627\u0644\u0639\u0631\u0627\u0642",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+964"), currency = CurrencyCode("IQD"), timezone = TimezoneId("Asia/Baghdad")
        ),
        Country(
            alpha2 = Alpha2Code("IR"), alpha3 = Alpha3Code("IRN"), numeric = NumericCode("364"),
            name = CountryName("Iran (Islamic Republic of)"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF7"),
            displayName = "Iran", native = "\u0627\u06CC\u0631\u0627\u0646",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+98"), currency = CurrencyCode("IRR"), timezone = TimezoneId("Asia/Tehran")
        ),
        Country(
            alpha2 = Alpha2Code("IS"), alpha3 = Alpha3Code("ISL"), numeric = NumericCode("352"),
            name = CountryName("Iceland"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF8"),
            native = "\u00CDsland",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+354"), currency = CurrencyCode("ISK"), timezone = TimezoneId("Atlantic/Reykjavik")
        ),
        Country(
            alpha2 = Alpha2Code("IT"), alpha3 = Alpha3Code("ITA"), numeric = NumericCode("380"),
            name = CountryName("Italy"), flag = FlagEmoji("\uD83C\uDDEE\uD83C\uDDF9"),
            native = "Italia",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+39"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Rome")
        ),
        Country(
            alpha2 = Alpha2Code("JE"), alpha3 = Alpha3Code("JEY"), numeric = NumericCode("832"),
            name = CountryName("Jersey"), flag = FlagEmoji("\uD83C\uDDEF\uD83C\uDDEA"),
            native = "Jersey",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+44"), currency = CurrencyCode("GBP"), timezone = TimezoneId("Europe/Jersey")
        ),
        Country(
            alpha2 = Alpha2Code("JM"), alpha3 = Alpha3Code("JAM"), numeric = NumericCode("388"),
            name = CountryName("Jamaica"), flag = FlagEmoji("\uD83C\uDDEF\uD83C\uDDF2"),
            native = "Jamaica",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("JMD"), timezone = TimezoneId("America/Jamaica")
        ),
        Country(
            alpha2 = Alpha2Code("JO"), alpha3 = Alpha3Code("JOR"), numeric = NumericCode("400"),
            name = CountryName("Jordan"), flag = FlagEmoji("\uD83C\uDDEF\uD83C\uDDF4"),
            native = "\u0627\u0644\u0623\u0631\u062F\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+962"), currency = CurrencyCode("JOD"), timezone = TimezoneId("Asia/Amman")
        ),
        Country(
            alpha2 = Alpha2Code("JP"), alpha3 = Alpha3Code("JPN"), numeric = NumericCode("392"),
            name = CountryName("Japan"), flag = FlagEmoji("\uD83C\uDDEF\uD83C\uDDF5"),
            native = "\u65E5\u672C",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+81"), currency = CurrencyCode("JPY"), timezone = TimezoneId("Asia/Tokyo")
        ),
        Country(
            alpha2 = Alpha2Code("KE"), alpha3 = Alpha3Code("KEN"), numeric = NumericCode("404"),
            name = CountryName("Kenya"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDEA"),
            native = "Kenya",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+254"), currency = CurrencyCode("KES"), timezone = TimezoneId("Africa/Nairobi")
        ),
        Country(
            alpha2 = Alpha2Code("KG"), alpha3 = Alpha3Code("KGZ"), numeric = NumericCode("417"),
            name = CountryName("Kyrgyzstan"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDEC"),
            native = "\u041A\u044B\u0440\u0433\u044B\u0437\u0441\u0442\u0430\u043D",
            continent = Continent.ASIA, region = Region.CENTRAL_ASIA,
            callingCode = CallingCode("+996"), currency = CurrencyCode("KGS"), timezone = TimezoneId("Asia/Bishkek")
        ),
        Country(
            alpha2 = Alpha2Code("KH"), alpha3 = Alpha3Code("KHM"), numeric = NumericCode("116"),
            name = CountryName("Cambodia"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDED"),
            native = "K\u00E2mp\u016Dch\u00E9a",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+855"), currency = CurrencyCode("KHR"), timezone = TimezoneId("Asia/Phnom_Penh")
        ),
        Country(
            alpha2 = Alpha2Code("KI"), alpha3 = Alpha3Code("KIR"), numeric = NumericCode("296"),
            name = CountryName("Kiribati"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDEE"),
            native = "Kiribati",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+686"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Pacific/Tarawa")
        ),
        Country(
            alpha2 = Alpha2Code("KM"), alpha3 = Alpha3Code("COM"), numeric = NumericCode("174"),
            name = CountryName("Comoros (the)"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDF2"),
            displayName = "Comoros", native = "Komori",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+269"), currency = CurrencyCode("KMF"), timezone = TimezoneId("Indian/Comoro")
        ),
        Country(
            alpha2 = Alpha2Code("KN"), alpha3 = Alpha3Code("KNA"), numeric = NumericCode("659"),
            name = CountryName("Saint Kitts and Nevis"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDF3"),
            native = "Saint Kitts and Nevis",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/St_Kitts")
        ),
        Country(
            alpha2 = Alpha2Code("KP"), alpha3 = Alpha3Code("PRK"), numeric = NumericCode("408"),
            name = CountryName("Korea (the Democratic People's Republic of)"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDF5"),
            displayName = "North Korea", native = "\uC870\uC120\uBBFC\uC8FC\uC8FC\uC758\uC778\uBBFC\uACF5\uD654\uAD6D",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+850"), currency = CurrencyCode("KPW"), timezone = TimezoneId("Asia/Pyongyang")
        ),
        Country(
            alpha2 = Alpha2Code("KR"), alpha3 = Alpha3Code("KOR"), numeric = NumericCode("410"),
            name = CountryName("Korea (the Republic of)"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDF7"),
            displayName = "South Korea", native = "\uB300\uD55C\uBBFC\uAD6D",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+82"), currency = CurrencyCode("KRW"), timezone = TimezoneId("Asia/Seoul")
        ),
        Country(
            alpha2 = Alpha2Code("KW"), alpha3 = Alpha3Code("KWT"), numeric = NumericCode("414"),
            name = CountryName("Kuwait"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDFC"),
            native = "\u0627\u0644\u0643\u0648\u064A\u062A",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+965"), currency = CurrencyCode("KWD"), timezone = TimezoneId("Asia/Kuwait")
        ),
        Country(
            alpha2 = Alpha2Code("KY"), alpha3 = Alpha3Code("CYM"), numeric = NumericCode("136"),
            name = CountryName("Cayman Islands (the)"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDFE"),
            displayName = "Cayman Islands", native = "Cayman Islands",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("KYD"), timezone = TimezoneId("America/Cayman")
        ),
        Country(
            alpha2 = Alpha2Code("KZ"), alpha3 = Alpha3Code("KAZ"), numeric = NumericCode("398"),
            name = CountryName("Kazakhstan"), flag = FlagEmoji("\uD83C\uDDF0\uD83C\uDDFF"),
            native = "\u049A\u0430\u0437\u0430\u049B\u0441\u0442\u0430\u043D",
            continent = Continent.ASIA, region = Region.CENTRAL_ASIA,
            callingCode = CallingCode("+7"), currency = CurrencyCode("KZT"), timezone = TimezoneId("Asia/Almaty")
        ),
        Country(
            alpha2 = Alpha2Code("LA"), alpha3 = Alpha3Code("LAO"), numeric = NumericCode("418"),
            name = CountryName("Lao People's Democratic Republic (the)"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDE6"),
            displayName = "Laos", native = "\u0EA5\u0EB2\u0EA7",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+856"), currency = CurrencyCode("LAK"), timezone = TimezoneId("Asia/Vientiane")
        ),
        Country(
            alpha2 = Alpha2Code("LB"), alpha3 = Alpha3Code("LBN"), numeric = NumericCode("422"),
            name = CountryName("Lebanon"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDE7"),
            native = "\u0644\u0628\u0646\u0627\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+961"), currency = CurrencyCode("LBP"), timezone = TimezoneId("Asia/Beirut")
        ),
        Country(
            alpha2 = Alpha2Code("LC"), alpha3 = Alpha3Code("LCA"), numeric = NumericCode("662"),
            name = CountryName("Saint Lucia"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDE8"),
            native = "Saint Lucia",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/St_Lucia")
        ),
        Country(
            alpha2 = Alpha2Code("LI"), alpha3 = Alpha3Code("LIE"), numeric = NumericCode("438"),
            name = CountryName("Liechtenstein"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDEE"),
            native = "Liechtenstein",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+423"), currency = CurrencyCode("CHF"), timezone = TimezoneId("Europe/Vaduz")
        ),
        Country(
            alpha2 = Alpha2Code("LK"), alpha3 = Alpha3Code("LKA"), numeric = NumericCode("144"),
            name = CountryName("Sri Lanka"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDF0"),
            native = "\u0DC1\u0DCA\u200D\u0DBB\u0DD3 \u0DBD\u0D82\u0D9A\u0DCF\u0DC0",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+94"), currency = CurrencyCode("LKR"), timezone = TimezoneId("Asia/Colombo")
        ),
        Country(
            alpha2 = Alpha2Code("LR"), alpha3 = Alpha3Code("LBR"), numeric = NumericCode("430"),
            name = CountryName("Liberia"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDF7"),
            native = "Liberia",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+231"), currency = CurrencyCode("LRD"), timezone = TimezoneId("Africa/Monrovia")
        ),
        Country(
            alpha2 = Alpha2Code("LS"), alpha3 = Alpha3Code("LSO"), numeric = NumericCode("426"),
            name = CountryName("Lesotho"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDF8"),
            native = "Lesotho",
            continent = Continent.AFRICA, region = Region.SOUTHERN_AFRICA,
            callingCode = CallingCode("+266"), currency = CurrencyCode("LSL"), timezone = TimezoneId("Africa/Maseru")
        ),
        Country(
            alpha2 = Alpha2Code("LT"), alpha3 = Alpha3Code("LTU"), numeric = NumericCode("440"),
            name = CountryName("Lithuania"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDF9"),
            native = "Lietuva",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+370"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Vilnius")
        ),
        Country(
            alpha2 = Alpha2Code("LU"), alpha3 = Alpha3Code("LUX"), numeric = NumericCode("442"),
            name = CountryName("Luxembourg"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDFA"),
            native = "Luxemburg",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+352"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Luxembourg")
        ),
        Country(
            alpha2 = Alpha2Code("LV"), alpha3 = Alpha3Code("LVA"), numeric = NumericCode("428"),
            name = CountryName("Latvia"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDFB"),
            native = "Latvija",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+371"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Riga")
        ),
        Country(
            alpha2 = Alpha2Code("LY"), alpha3 = Alpha3Code("LBY"), numeric = NumericCode("434"),
            name = CountryName("Libya"), flag = FlagEmoji("\uD83C\uDDF1\uD83C\uDDFE"),
            native = "\u200F\u0644\u064A\u0628\u064A\u0627",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+218"), currency = CurrencyCode("LYD"), timezone = TimezoneId("Africa/Tripoli")
        ),
        Country(
            alpha2 = Alpha2Code("MA"), alpha3 = Alpha3Code("MAR"), numeric = NumericCode("504"),
            name = CountryName("Morocco"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDE6"),
            native = "\u0627\u0644\u0645\u063A\u0631\u0628",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+212"), currency = CurrencyCode("MAD"), timezone = TimezoneId("Africa/Casablanca")
        ),
        Country(
            alpha2 = Alpha2Code("MC"), alpha3 = Alpha3Code("MCO"), numeric = NumericCode("492"),
            name = CountryName("Monaco"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDE8"),
            native = "Monaco",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+377"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Monaco")
        ),
        Country(
            alpha2 = Alpha2Code("MD"), alpha3 = Alpha3Code("MDA"), numeric = NumericCode("498"),
            name = CountryName("Moldova (the Republic of)"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDE9"),
            displayName = "Moldova", native = "Moldova",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+373"), currency = CurrencyCode("MDL"), timezone = TimezoneId("Europe/Chisinau")
        ),
        Country(
            alpha2 = Alpha2Code("ME"), alpha3 = Alpha3Code("MNE"), numeric = NumericCode("499"),
            name = CountryName("Montenegro"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDEA"),
            native = "\u0426\u0440\u043D\u0430 \u0413\u043E\u0440\u0430",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+382"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Podgorica")
        ),
        Country(
            alpha2 = Alpha2Code("MF"), alpha3 = Alpha3Code("MAF"), numeric = NumericCode("663"),
            name = CountryName("Saint Martin (French part)"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDEB"),
            native = "Saint-Martin",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+590"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/Marigot")
        ),
        Country(
            alpha2 = Alpha2Code("MG"), alpha3 = Alpha3Code("MDG"), numeric = NumericCode("450"),
            name = CountryName("Madagascar"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDEC"),
            native = "Madagascar",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+261"), currency = CurrencyCode("MGA"), timezone = TimezoneId("Indian/Antananarivo")
        ),
        Country(
            alpha2 = Alpha2Code("MH"), alpha3 = Alpha3Code("MHL"), numeric = NumericCode("584"),
            name = CountryName("Marshall Islands (the)"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDED"),
            displayName = "Marshall Islands", native = "Marshall Islands",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+692"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Majuro")
        ),
        Country(
            alpha2 = Alpha2Code("MK"), alpha3 = Alpha3Code("MKD"), numeric = NumericCode("807"),
            name = CountryName("Republic of North Macedonia"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF0"),
            native = "\u041C\u0430\u043A\u0435\u0434\u043E\u043D\u0438\u0458\u0430",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+389"), currency = CurrencyCode("MKD"), timezone = TimezoneId("Europe/Skopje")
        ),
        Country(
            alpha2 = Alpha2Code("ML"), alpha3 = Alpha3Code("MLI"), numeric = NumericCode("466"),
            name = CountryName("Mali"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF1"),
            native = "Mali",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+223"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Bamako")
        ),
        Country(
            alpha2 = Alpha2Code("MM"), alpha3 = Alpha3Code("MMR"), numeric = NumericCode("104"),
            name = CountryName("Myanmar"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF2"),
            native = "\u1019\u103C\u1014\u103A\u1019\u102C",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+95"), currency = CurrencyCode("MMK"), timezone = TimezoneId("Asia/Yangon")
        ),
        Country(
            alpha2 = Alpha2Code("MN"), alpha3 = Alpha3Code("MNG"), numeric = NumericCode("496"),
            name = CountryName("Mongolia"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF3"),
            native = "\u041C\u043E\u043D\u0433\u043E\u043B \u0443\u043B\u0441",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+976"), currency = CurrencyCode("MNT"), timezone = TimezoneId("Asia/Ulaanbaatar")
        ),
        Country(
            alpha2 = Alpha2Code("MO"), alpha3 = Alpha3Code("MAC"), numeric = NumericCode("446"),
            name = CountryName("Macao"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF4"),
            native = "Macau",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+853"), currency = CurrencyCode("MOP"), timezone = TimezoneId("Asia/Macau")
        ),
        Country(
            alpha2 = Alpha2Code("MP"), alpha3 = Alpha3Code("MNP"), numeric = NumericCode("580"),
            name = CountryName("Northern Mariana Islands (the)"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF5"),
            displayName = "Northern Mariana Islands", native = "Northern Mariana Islands",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Guam")
        ),
        Country(
            alpha2 = Alpha2Code("MQ"), alpha3 = Alpha3Code("MTQ"), numeric = NumericCode("474"),
            name = CountryName("Martinique"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF6"),
            native = "Martinique",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+596"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/Martinique")
        ),
        Country(
            alpha2 = Alpha2Code("MR"), alpha3 = Alpha3Code("MRT"), numeric = NumericCode("478"),
            name = CountryName("Mauritania"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF7"),
            native = "\u0645\u0648\u0631\u064A\u062A\u0627\u0646\u064A\u0627",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+222"), currency = CurrencyCode("MRU"), timezone = TimezoneId("Africa/Nouakchott")
        ),
        Country(
            alpha2 = Alpha2Code("MS"), alpha3 = Alpha3Code("MSR"), numeric = NumericCode("500"),
            name = CountryName("Montserrat"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF8"),
            native = "Montserrat",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/Montserrat")
        ),
        Country(
            alpha2 = Alpha2Code("MT"), alpha3 = Alpha3Code("MLT"), numeric = NumericCode("470"),
            name = CountryName("Malta"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDF9"),
            native = "Malta",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+356"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Malta")
        ),
        Country(
            alpha2 = Alpha2Code("MU"), alpha3 = Alpha3Code("MUS"), numeric = NumericCode("480"),
            name = CountryName("Mauritius"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFA"),
            native = "Mauritius",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+230"), currency = CurrencyCode("MUR"), timezone = TimezoneId("Indian/Mauritius")
        ),
        Country(
            alpha2 = Alpha2Code("MV"), alpha3 = Alpha3Code("MDV"), numeric = NumericCode("462"),
            name = CountryName("Maldives"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFB"),
            native = "\u078B\u07A8\u0788\u07AC\u0780\u07A8\u0783\u07A7\u0787\u07B0\u0796\u07AD\u078E\u07AC",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+960"), currency = CurrencyCode("MVR"), timezone = TimezoneId("Indian/Maldives")
        ),
        Country(
            alpha2 = Alpha2Code("MW"), alpha3 = Alpha3Code("MWI"), numeric = NumericCode("454"),
            name = CountryName("Malawi"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFC"),
            native = "Malawi",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+265"), currency = CurrencyCode("MWK"), timezone = TimezoneId("Africa/Blantyre")
        ),
        Country(
            alpha2 = Alpha2Code("MX"), alpha3 = Alpha3Code("MEX"), numeric = NumericCode("484"),
            name = CountryName("Mexico"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFD"),
            native = "M\u00E9xico",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+52"), currency = CurrencyCode("MXN"), timezone = TimezoneId("America/Mexico_City")
        ),
        Country(
            alpha2 = Alpha2Code("MY"), alpha3 = Alpha3Code("MYS"), numeric = NumericCode("458"),
            name = CountryName("Malaysia"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFE"),
            native = "Malaysia",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+60"), currency = CurrencyCode("MYR"), timezone = TimezoneId("Asia/Kuala_Lumpur")
        ),
        Country(
            alpha2 = Alpha2Code("MZ"), alpha3 = Alpha3Code("MOZ"), numeric = NumericCode("508"),
            name = CountryName("Mozambique"), flag = FlagEmoji("\uD83C\uDDF2\uD83C\uDDFF"),
            native = "Mo\u00E7ambique",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+258"), currency = CurrencyCode("MZN"), timezone = TimezoneId("Africa/Maputo")
        ),
        Country(
            alpha2 = Alpha2Code("NA"), alpha3 = Alpha3Code("NAM"), numeric = NumericCode("516"),
            name = CountryName("Namibia"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDE6"),
            native = "Namibi\u00EB",
            continent = Continent.AFRICA, region = Region.SOUTHERN_AFRICA,
            callingCode = CallingCode("+264"), currency = CurrencyCode("NAD"), timezone = TimezoneId("Africa/Windhoek")
        ),
        Country(
            alpha2 = Alpha2Code("NC"), alpha3 = Alpha3Code("NCL"), numeric = NumericCode("540"),
            name = CountryName("New Caledonia"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDE8"),
            native = "Nouvelle-Cal\u00E9donie",
            continent = Continent.OCEANIA, region = Region.MELANESIA,
            callingCode = CallingCode("+687"), currency = CurrencyCode("XPF"), timezone = TimezoneId("Pacific/Noumea")
        ),
        Country(
            alpha2 = Alpha2Code("NE"), alpha3 = Alpha3Code("NER"), numeric = NumericCode("562"),
            name = CountryName("Niger (the)"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDEA"),
            displayName = "Niger", native = "Niger",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+227"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Niamey")
        ),
        Country(
            alpha2 = Alpha2Code("NF"), alpha3 = Alpha3Code("NFK"), numeric = NumericCode("574"),
            name = CountryName("Norfolk Island"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDEB"),
            native = "Norfolk Island",
            continent = Continent.OCEANIA, region = Region.AUSTRALIA_AND_NEW_ZEALAND,
            callingCode = CallingCode("+672"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Pacific/Norfolk")
        ),
        Country(
            alpha2 = Alpha2Code("NG"), alpha3 = Alpha3Code("NGA"), numeric = NumericCode("566"),
            name = CountryName("Nigeria"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDEC"),
            native = "Nigeria",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+234"), currency = CurrencyCode("NGN"), timezone = TimezoneId("Africa/Lagos")
        ),
        Country(
            alpha2 = Alpha2Code("NI"), alpha3 = Alpha3Code("NIC"), numeric = NumericCode("558"),
            name = CountryName("Nicaragua"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDEE"),
            native = "Nicaragua",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+505"), currency = CurrencyCode("NIO"), timezone = TimezoneId("America/Managua")
        ),
        Country(
            alpha2 = Alpha2Code("NL"), alpha3 = Alpha3Code("NLD"), numeric = NumericCode("528"),
            name = CountryName("Netherlands (the)"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDF1"),
            displayName = "Netherlands", native = "Nederland",
            continent = Continent.EUROPE, region = Region.WESTERN_EUROPE,
            callingCode = CallingCode("+31"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Amsterdam")
        ),
        Country(
            alpha2 = Alpha2Code("NO"), alpha3 = Alpha3Code("NOR"), numeric = NumericCode("578"),
            name = CountryName("Norway"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDF4"),
            native = "Noreg",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+47"), currency = CurrencyCode("NOK"), timezone = TimezoneId("Europe/Oslo")
        ),
        Country(
            alpha2 = Alpha2Code("NP"), alpha3 = Alpha3Code("NPL"), numeric = NumericCode("524"),
            name = CountryName("Nepal"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDF5"),
            native = "\u0928\u0947\u092A\u093E\u0932",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+977"), currency = CurrencyCode("NPR"), timezone = TimezoneId("Asia/Kathmandu")
        ),
        Country(
            alpha2 = Alpha2Code("NR"), alpha3 = Alpha3Code("NRU"), numeric = NumericCode("520"),
            name = CountryName("Nauru"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDF7"),
            native = "Nauru",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+674"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Pacific/Nauru")
        ),
        Country(
            alpha2 = Alpha2Code("NU"), alpha3 = Alpha3Code("NIU"), numeric = NumericCode("570"),
            name = CountryName("Niue"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDFA"),
            native = "Niue",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+683"), currency = CurrencyCode("NZD"), timezone = TimezoneId("Pacific/Niue")
        ),
        Country(
            alpha2 = Alpha2Code("NZ"), alpha3 = Alpha3Code("NZL"), numeric = NumericCode("554"),
            name = CountryName("New Zealand"), flag = FlagEmoji("\uD83C\uDDF3\uD83C\uDDFF"),
            native = "New Zealand",
            continent = Continent.OCEANIA, region = Region.AUSTRALIA_AND_NEW_ZEALAND,
            callingCode = CallingCode("+64"), currency = CurrencyCode("NZD"), timezone = TimezoneId("Pacific/Auckland")
        ),
        Country(
            alpha2 = Alpha2Code("OM"), alpha3 = Alpha3Code("OMN"), numeric = NumericCode("512"),
            name = CountryName("Oman"), flag = FlagEmoji("\uD83C\uDDF4\uD83C\uDDF2"),
            native = "\u0639\u0645\u0627\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+968"), currency = CurrencyCode("OMR"), timezone = TimezoneId("Asia/Muscat")
        ),
        Country(
            alpha2 = Alpha2Code("PA"), alpha3 = Alpha3Code("PAN"), numeric = NumericCode("591"),
            name = CountryName("Panama"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDE6"),
            native = "Panam\u00E1",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+507"), currency = CurrencyCode("PAB"), timezone = TimezoneId("America/Panama")
        ),
        Country(
            alpha2 = Alpha2Code("PE"), alpha3 = Alpha3Code("PER"), numeric = NumericCode("604"),
            name = CountryName("Peru"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDEA"),
            native = "Per\u00FA",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+51"), currency = CurrencyCode("PEN"), timezone = TimezoneId("America/Lima")
        ),
        Country(
            alpha2 = Alpha2Code("PF"), alpha3 = Alpha3Code("PYF"), numeric = NumericCode("258"),
            name = CountryName("French Polynesia"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDEB"),
            native = "Polyn\u00E9sie fran\u00E7aise",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+689"), currency = CurrencyCode("XPF"), timezone = TimezoneId("Pacific/Tahiti")
        ),
        Country(
            alpha2 = Alpha2Code("PG"), alpha3 = Alpha3Code("PNG"), numeric = NumericCode("598"),
            name = CountryName("Papua New Guinea"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDEC"),
            native = "Papua New Guinea",
            continent = Continent.OCEANIA, region = Region.MELANESIA,
            callingCode = CallingCode("+675"), currency = CurrencyCode("PGK"), timezone = TimezoneId("Pacific/Port_Moresby")
        ),
        Country(
            alpha2 = Alpha2Code("PH"), alpha3 = Alpha3Code("PHL"), numeric = NumericCode("608"),
            name = CountryName("Philippines (the)"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDED"),
            displayName = "Philippines", native = "Pilipinas",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+63"), currency = CurrencyCode("PHP"), timezone = TimezoneId("Asia/Manila")
        ),
        Country(
            alpha2 = Alpha2Code("PK"), alpha3 = Alpha3Code("PAK"), numeric = NumericCode("586"),
            name = CountryName("Pakistan"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF0"),
            native = "Pakistan",
            continent = Continent.ASIA, region = Region.SOUTHERN_ASIA,
            callingCode = CallingCode("+92"), currency = CurrencyCode("PKR"), timezone = TimezoneId("Asia/Karachi")
        ),
        Country(
            alpha2 = Alpha2Code("PL"), alpha3 = Alpha3Code("POL"), numeric = NumericCode("616"),
            name = CountryName("Poland"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF1"),
            native = "Polska",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+48"), currency = CurrencyCode("PLN"), timezone = TimezoneId("Europe/Warsaw")
        ),
        Country(
            alpha2 = Alpha2Code("PM"), alpha3 = Alpha3Code("SPM"), numeric = NumericCode("666"),
            name = CountryName("Saint Pierre and Miquelon"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF2"),
            native = "Saint-Pierre-et-Miquelon",
            continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
            callingCode = CallingCode("+508"), currency = CurrencyCode("EUR"), timezone = TimezoneId("America/Miquelon")
        ),
        Country(
            alpha2 = Alpha2Code("PN"), alpha3 = Alpha3Code("PCN"), numeric = NumericCode("612"),
            name = CountryName("Pitcairn"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF3"),
            native = "Pitcairn Islands",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+64"), currency = CurrencyCode("NZD"), timezone = TimezoneId("Pacific/Pitcairn")
        ),
        Country(
            alpha2 = Alpha2Code("PR"), alpha3 = Alpha3Code("PRI"), numeric = NumericCode("630"),
            name = CountryName("Puerto Rico"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF7"),
            native = "Puerto Rico",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Puerto_Rico")
        ),
        Country(
            alpha2 = Alpha2Code("PS"), alpha3 = Alpha3Code("PSE"), numeric = NumericCode("275"),
            name = CountryName("Palestine, State of"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF8"),
            displayName = "Palestine", native = "\u0641\u0644\u0633\u0637\u064A\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+970"), currency = CurrencyCode("ILS"), timezone = TimezoneId("Asia/Hebron")
        ),
        Country(
            alpha2 = Alpha2Code("PT"), alpha3 = Alpha3Code("PRT"), numeric = NumericCode("620"),
            name = CountryName("Portugal"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDF9"),
            native = "Portugal",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+351"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Lisbon")
        ),
        Country(
            alpha2 = Alpha2Code("PW"), alpha3 = Alpha3Code("PLW"), numeric = NumericCode("585"),
            name = CountryName("Palau"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDFC"),
            native = "Palau",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+680"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Palau")
        ),
        Country(
            alpha2 = Alpha2Code("PY"), alpha3 = Alpha3Code("PRY"), numeric = NumericCode("600"),
            name = CountryName("Paraguay"), flag = FlagEmoji("\uD83C\uDDF5\uD83C\uDDFE"),
            native = "Paragua\u00ED",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+595"), currency = CurrencyCode("PYG"), timezone = TimezoneId("America/Asuncion")
        ),
        Country(
            alpha2 = Alpha2Code("QA"), alpha3 = Alpha3Code("QAT"), numeric = NumericCode("634"),
            name = CountryName("Qatar"), flag = FlagEmoji("\uD83C\uDDF6\uD83C\uDDE6"),
            native = "\u0642\u0637\u0631",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+974"), currency = CurrencyCode("QAR"), timezone = TimezoneId("Asia/Qatar")
        ),
        Country(
            alpha2 = Alpha2Code("RE"), alpha3 = Alpha3Code("REU"), numeric = NumericCode("638"),
            name = CountryName("R\u00E9union"), flag = FlagEmoji("\uD83C\uDDF7\uD83C\uDDEA"),
            native = "La R\u00E9union",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+262"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Indian/Reunion")
        ),
        Country(
            alpha2 = Alpha2Code("RO"), alpha3 = Alpha3Code("ROU"), numeric = NumericCode("642"),
            name = CountryName("Romania"), flag = FlagEmoji("\uD83C\uDDF7\uD83C\uDDF4"),
            native = "Rom\u00E2nia",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+40"), currency = CurrencyCode("RON"), timezone = TimezoneId("Europe/Bucharest")
        ),
        Country(
            alpha2 = Alpha2Code("RS"), alpha3 = Alpha3Code("SRB"), numeric = NumericCode("688"),
            name = CountryName("Serbia"), flag = FlagEmoji("\uD83C\uDDF7\uD83C\uDDF8"),
            native = "\u0421\u0440\u0431\u0438\u0458\u0430",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+381"), currency = CurrencyCode("RSD"), timezone = TimezoneId("Europe/Belgrade")
        ),
        Country(
            alpha2 = Alpha2Code("RU"), alpha3 = Alpha3Code("RUS"), numeric = NumericCode("643"),
            name = CountryName("Russian Federation (the)"), flag = FlagEmoji("\uD83C\uDDF7\uD83C\uDDFA"),
            displayName = "Russia", native = "\u0420\u043E\u0441\u0441\u0438\u044F",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+7"), currency = CurrencyCode("RUB"), timezone = TimezoneId("Europe/Moscow")
        ),
        Country(
            alpha2 = Alpha2Code("RW"), alpha3 = Alpha3Code("RWA"), numeric = NumericCode("646"),
            name = CountryName("Rwanda"), flag = FlagEmoji("\uD83C\uDDF7\uD83C\uDDFC"),
            native = "Rwanda",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+250"), currency = CurrencyCode("RWF"), timezone = TimezoneId("Africa/Kigali")
        ),
        Country(
            alpha2 = Alpha2Code("SA"), alpha3 = Alpha3Code("SAU"), numeric = NumericCode("682"),
            name = CountryName("Saudi Arabia"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDE6"),
            native = "\u0627\u0644\u0639\u0631\u0628\u064A\u0629 \u0627\u0644\u0633\u0639\u0648\u062F\u064A\u0629",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+966"), currency = CurrencyCode("SAR"), timezone = TimezoneId("Asia/Riyadh")
        ),
        Country(
            alpha2 = Alpha2Code("SB"), alpha3 = Alpha3Code("SLB"), numeric = NumericCode("090"),
            name = CountryName("Solomon Islands"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDE7"),
            native = "Solomon Islands",
            continent = Continent.OCEANIA, region = Region.MELANESIA,
            callingCode = CallingCode("+677"), currency = CurrencyCode("SBD"), timezone = TimezoneId("Pacific/Guadalcanal")
        ),
        Country(
            alpha2 = Alpha2Code("SC"), alpha3 = Alpha3Code("SYC"), numeric = NumericCode("690"),
            name = CountryName("Seychelles"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDE8"),
            native = "Sesel",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+248"), currency = CurrencyCode("SCR"), timezone = TimezoneId("Indian/Mahe")
        ),
        Country(
            alpha2 = Alpha2Code("SD"), alpha3 = Alpha3Code("SDN"), numeric = NumericCode("729"),
            name = CountryName("Sudan (the)"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDE9"),
            displayName = "Sudan", native = "\u0627\u0644\u0633\u0648\u062F\u0627\u0646",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+249"), currency = CurrencyCode("SDG"), timezone = TimezoneId("Africa/Khartoum")
        ),
        Country(
            alpha2 = Alpha2Code("SE"), alpha3 = Alpha3Code("SWE"), numeric = NumericCode("752"),
            name = CountryName("Sweden"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDEA"),
            native = "Sverige",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+46"), currency = CurrencyCode("SEK"), timezone = TimezoneId("Europe/Stockholm")
        ),
        Country(
            alpha2 = Alpha2Code("SG"), alpha3 = Alpha3Code("SGP"), numeric = NumericCode("702"),
            name = CountryName("Singapore"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDEC"),
            native = "Singapore",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+65"), currency = CurrencyCode("SGD"), timezone = TimezoneId("Asia/Singapore")
        ),
        Country(
            alpha2 = Alpha2Code("SH"), alpha3 = Alpha3Code("SHN"), numeric = NumericCode("654"),
            name = CountryName("Saint Helena, Ascension and Tristan da Cunha"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDED"),
            native = "Saint Helena, Ascension and Tristan da Cunha",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+290"), currency = CurrencyCode("SHP"), timezone = TimezoneId("Atlantic/St_Helena")
        ),
        Country(
            alpha2 = Alpha2Code("SI"), alpha3 = Alpha3Code("SVN"), numeric = NumericCode("705"),
            name = CountryName("Slovenia"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDEE"),
            native = "Slovenija",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+386"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Ljubljana")
        ),
        Country(
            alpha2 = Alpha2Code("SJ"), alpha3 = Alpha3Code("SJM"), numeric = NumericCode("744"),
            name = CountryName("Svalbard and Jan Mayen"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDEF"),
            native = "Svalbard og Jan Mayen",
            continent = Continent.EUROPE, region = Region.NORTHERN_EUROPE,
            callingCode = CallingCode("+47"), currency = CurrencyCode("NOK"), timezone = TimezoneId("Arctic/Longyearbyen")
        ),
        Country(
            alpha2 = Alpha2Code("SK"), alpha3 = Alpha3Code("SVK"), numeric = NumericCode("703"),
            name = CountryName("Slovakia"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF0"),
            native = "Slovensko",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+421"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Bratislava")
        ),
        Country(
            alpha2 = Alpha2Code("SL"), alpha3 = Alpha3Code("SLE"), numeric = NumericCode("694"),
            name = CountryName("Sierra Leone"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF1"),
            native = "Sierra Leone",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+232"), currency = CurrencyCode("SLE"), timezone = TimezoneId("Africa/Freetown")
        ),
        Country(
            alpha2 = Alpha2Code("SM"), alpha3 = Alpha3Code("SMR"), numeric = NumericCode("674"),
            name = CountryName("San Marino"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF2"),
            native = "San Marino",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+378"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/San_Marino")
        ),
        Country(
            alpha2 = Alpha2Code("SN"), alpha3 = Alpha3Code("SEN"), numeric = NumericCode("686"),
            name = CountryName("Senegal"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF3"),
            native = "S\u00E9n\u00E9gal",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+221"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Dakar")
        ),
        Country(
            alpha2 = Alpha2Code("SO"), alpha3 = Alpha3Code("SOM"), numeric = NumericCode("706"),
            name = CountryName("Somalia"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF4"),
            native = "\u0627\u0644\u0635\u0648\u0645\u0627\u0644\u200E\u200E",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+252"), currency = CurrencyCode("SOS"), timezone = TimezoneId("Africa/Mogadishu")
        ),
        Country(
            alpha2 = Alpha2Code("SR"), alpha3 = Alpha3Code("SUR"), numeric = NumericCode("740"),
            name = CountryName("Suriname"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF7"),
            native = "Suriname",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+597"), currency = CurrencyCode("SRD"), timezone = TimezoneId("America/Paramaribo")
        ),
        Country(
            alpha2 = Alpha2Code("SS"), alpha3 = Alpha3Code("SSD"), numeric = NumericCode("728"),
            name = CountryName("South Sudan"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF8"),
            native = "South Sudan",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+211"), currency = CurrencyCode("SSP"), timezone = TimezoneId("Africa/Juba")
        ),
        Country(
            alpha2 = Alpha2Code("ST"), alpha3 = Alpha3Code("STP"), numeric = NumericCode("678"),
            name = CountryName("Sao Tome and Principe"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDF9"),
            displayName = "S\u00E3o Tom\u00E9 and Pr\u00EDncipe", native = "S\u00E3o Tom\u00E9 e Pr\u00EDncipe",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+239"), currency = CurrencyCode("STN"), timezone = TimezoneId("Africa/Sao_Tome")
        ),
        Country(
            alpha2 = Alpha2Code("SV"), alpha3 = Alpha3Code("SLV"), numeric = NumericCode("222"),
            name = CountryName("El Salvador"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDFB"),
            native = "El Salvador",
            continent = Continent.NORTH_AMERICA, region = Region.CENTRAL_AMERICA,
            callingCode = CallingCode("+503"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/El_Salvador")
        ),
        Country(
            alpha2 = Alpha2Code("SX"), alpha3 = Alpha3Code("SXM"), numeric = NumericCode("534"),
            name = CountryName("Sint Maarten (Dutch part)"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDFD"),
            native = "Sint Maarten",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("ANG"), timezone = TimezoneId("America/Lower_Princes")
        ),
        Country(
            alpha2 = Alpha2Code("SY"), alpha3 = Alpha3Code("SYR"), numeric = NumericCode("760"),
            name = CountryName("Syrian Arab Republic"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDFE"),
            displayName = "Syria", native = "\u0633\u0648\u0631\u064A\u0627",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+963"), currency = CurrencyCode("SYP"), timezone = TimezoneId("Asia/Damascus")
        ),
        Country(
            alpha2 = Alpha2Code("SZ"), alpha3 = Alpha3Code("SWZ"), numeric = NumericCode("748"),
            name = CountryName("Eswatini"), flag = FlagEmoji("\uD83C\uDDF8\uD83C\uDDFF"),
            native = "Eswatini",
            continent = Continent.AFRICA, region = Region.SOUTHERN_AFRICA,
            callingCode = CallingCode("+268"), currency = CurrencyCode("SZL"), timezone = TimezoneId("Africa/Mbabane")
        ),
        Country(
            alpha2 = Alpha2Code("TC"), alpha3 = Alpha3Code("TCA"), numeric = NumericCode("796"),
            name = CountryName("Turks and Caicos Islands (the)"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDE8"),
            displayName = "Turks and Caicos Islands", native = "Turks and Caicos Islands",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Grand_Turk")
        ),
        Country(
            alpha2 = Alpha2Code("TD"), alpha3 = Alpha3Code("TCD"), numeric = NumericCode("148"),
            name = CountryName("Chad"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDE9"),
            native = "\u062A\u0634\u0627\u062F\u200E",
            continent = Continent.AFRICA, region = Region.MIDDLE_AFRICA,
            callingCode = CallingCode("+235"), currency = CurrencyCode("XAF"), timezone = TimezoneId("Africa/Ndjamena")
        ),
        Country(
            alpha2 = Alpha2Code("TF"), alpha3 = Alpha3Code("ATF"), numeric = NumericCode("260"),
            name = CountryName("French Southern Territories (the)"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDEB"),
            displayName = "French Southern Territories", native = "Terres australes fran\u00E7aises",
            continent = Continent.ANTARCTICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+262"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Indian/Kerguelen")
        ),
        Country(
            alpha2 = Alpha2Code("TG"), alpha3 = Alpha3Code("TGO"), numeric = NumericCode("768"),
            name = CountryName("Togo"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDEC"),
            native = "Togo",
            continent = Continent.AFRICA, region = Region.WESTERN_AFRICA,
            callingCode = CallingCode("+228"), currency = CurrencyCode("XOF"), timezone = TimezoneId("Africa/Lome")
        ),
        Country(
            alpha2 = Alpha2Code("TH"), alpha3 = Alpha3Code("THA"), numeric = NumericCode("764"),
            name = CountryName("Thailand"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDED"),
            native = "\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28\u0E44\u0E17\u0E22",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+66"), currency = CurrencyCode("THB"), timezone = TimezoneId("Asia/Bangkok")
        ),
        Country(
            alpha2 = Alpha2Code("TJ"), alpha3 = Alpha3Code("TJK"), numeric = NumericCode("762"),
            name = CountryName("Tajikistan"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDEF"),
            native = "\u0422\u0430\u0434\u0436\u0438\u043A\u0438\u0441\u0442\u0430\u043D",
            continent = Continent.ASIA, region = Region.CENTRAL_ASIA,
            callingCode = CallingCode("+992"), currency = CurrencyCode("TJS"), timezone = TimezoneId("Asia/Dushanbe")
        ),
        Country(
            alpha2 = Alpha2Code("TK"), alpha3 = Alpha3Code("TKL"), numeric = NumericCode("772"),
            name = CountryName("Tokelau"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF0"),
            native = "Tokelau",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+690"), currency = CurrencyCode("NZD"), timezone = TimezoneId("Pacific/Fakaofo")
        ),
        Country(
            alpha2 = Alpha2Code("TL"), alpha3 = Alpha3Code("TLS"), numeric = NumericCode("626"),
            name = CountryName("Timor-Leste"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF1"),
            native = "Timor-Leste",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+670"), currency = CurrencyCode("USD"), timezone = TimezoneId("Asia/Dili")
        ),
        Country(
            alpha2 = Alpha2Code("TM"), alpha3 = Alpha3Code("TKM"), numeric = NumericCode("795"),
            name = CountryName("Turkmenistan"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF2"),
            native = "\u0422\u0443\u0440\u043A\u043C\u0435\u043D\u0438\u044F",
            continent = Continent.ASIA, region = Region.CENTRAL_ASIA,
            callingCode = CallingCode("+993"), currency = CurrencyCode("TMT"), timezone = TimezoneId("Asia/Ashgabat")
        ),
        Country(
            alpha2 = Alpha2Code("TN"), alpha3 = Alpha3Code("TUN"), numeric = NumericCode("788"),
            name = CountryName("Tunisia"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF3"),
            native = "\u062A\u0648\u0646\u0633",
            continent = Continent.AFRICA, region = Region.NORTHERN_AFRICA,
            callingCode = CallingCode("+216"), currency = CurrencyCode("TND"), timezone = TimezoneId("Africa/Tunis")
        ),
        Country(
            alpha2 = Alpha2Code("TO"), alpha3 = Alpha3Code("TON"), numeric = NumericCode("776"),
            name = CountryName("Tonga"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF4"),
            native = "Tonga",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+676"), currency = CurrencyCode("TOP"), timezone = TimezoneId("Pacific/Tongatapu")
        ),
        Country(
            alpha2 = Alpha2Code("TR"), alpha3 = Alpha3Code("TUR"), numeric = NumericCode("792"),
            name = CountryName("T\u00FCrkiye"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF7"),
            displayName = "T\u00FCrkiye", native = "T\u00FCrkiye",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+90"), currency = CurrencyCode("TRY"), timezone = TimezoneId("Europe/Istanbul")
        ),
        Country(
            alpha2 = Alpha2Code("TT"), alpha3 = Alpha3Code("TTO"), numeric = NumericCode("780"),
            name = CountryName("Trinidad and Tobago"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDF9"),
            native = "Trinidad and Tobago",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("TTD"), timezone = TimezoneId("America/Port_of_Spain")
        ),
        Country(
            alpha2 = Alpha2Code("TV"), alpha3 = Alpha3Code("TUV"), numeric = NumericCode("798"),
            name = CountryName("Tuvalu"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDFB"),
            native = "Tuvalu",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+688"), currency = CurrencyCode("AUD"), timezone = TimezoneId("Pacific/Funafuti")
        ),
        Country(
            alpha2 = Alpha2Code("TW"), alpha3 = Alpha3Code("TWN"), numeric = NumericCode("158"),
            name = CountryName("Taiwan (Province of China)"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDFC"),
            native = "\u53F0\u7063",
            continent = Continent.ASIA, region = Region.EASTERN_ASIA,
            callingCode = CallingCode("+886"), currency = CurrencyCode("TWD"), timezone = TimezoneId("Asia/Taipei")
        ),
        Country(
            alpha2 = Alpha2Code("TZ"), alpha3 = Alpha3Code("TZA"), numeric = NumericCode("834"),
            name = CountryName("Tanzania, United Republic of"), flag = FlagEmoji("\uD83C\uDDF9\uD83C\uDDFF"),
            displayName = "Tanzania", native = "Tanzania",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+255"), currency = CurrencyCode("TZS"), timezone = TimezoneId("Africa/Dar_es_Salaam")
        ),
        Country(
            alpha2 = Alpha2Code("UA"), alpha3 = Alpha3Code("UKR"), numeric = NumericCode("804"),
            name = CountryName("Ukraine"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDE6"),
            native = "\u0423\u043A\u0440\u0430\u0457\u043D\u0430",
            continent = Continent.EUROPE, region = Region.EASTERN_EUROPE,
            callingCode = CallingCode("+380"), currency = CurrencyCode("UAH"), timezone = TimezoneId("Europe/Kyiv")
        ),
        Country(
            alpha2 = Alpha2Code("UG"), alpha3 = Alpha3Code("UGA"), numeric = NumericCode("800"),
            name = CountryName("Uganda"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDEC"),
            native = "Uganda",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+256"), currency = CurrencyCode("UGX"), timezone = TimezoneId("Africa/Kampala")
        ),
        Country(
            alpha2 = Alpha2Code("UM"), alpha3 = Alpha3Code("UMI"), numeric = NumericCode("581"),
            name = CountryName("United States Minor Outlying Islands (the)"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDF2"),
            displayName = "United States Minor Outlying Islands", native = "United States Minor Outlying Islands",
            continent = Continent.OCEANIA, region = Region.MICRONESIA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("Pacific/Wake")
        ),
        Country(
            alpha2 = Alpha2Code("US"), alpha3 = Alpha3Code("USA"), numeric = NumericCode("840"),
            name = CountryName("United States of America (the)"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDF8"),
            displayName = "United States", native = "United States",
            continent = Continent.NORTH_AMERICA, region = Region.NORTHERN_AMERICA,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/New_York")
        ),
        Country(
            alpha2 = Alpha2Code("UY"), alpha3 = Alpha3Code("URY"), numeric = NumericCode("858"),
            name = CountryName("Uruguay"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDFE"),
            native = "Uruguay",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+598"), currency = CurrencyCode("UYU"), timezone = TimezoneId("America/Montevideo")
        ),
        Country(
            alpha2 = Alpha2Code("UZ"), alpha3 = Alpha3Code("UZB"), numeric = NumericCode("860"),
            name = CountryName("Uzbekistan"), flag = FlagEmoji("\uD83C\uDDFA\uD83C\uDDFF"),
            native = "\u0423\u0437\u0431\u0435\u043A\u0438\u0441\u0442\u0430\u043D",
            continent = Continent.ASIA, region = Region.CENTRAL_ASIA,
            callingCode = CallingCode("+998"), currency = CurrencyCode("UZS"), timezone = TimezoneId("Asia/Tashkent")
        ),
        Country(
            alpha2 = Alpha2Code("VA"), alpha3 = Alpha3Code("VAT"), numeric = NumericCode("336"),
            name = CountryName("Holy See (the)"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDE6"),
            displayName = "Holy See", native = "Santa Sede",
            continent = Continent.EUROPE, region = Region.SOUTHERN_EUROPE,
            callingCode = CallingCode("+379"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Europe/Vatican")
        ),
        Country(
            alpha2 = Alpha2Code("VC"), alpha3 = Alpha3Code("VCT"), numeric = NumericCode("670"),
            name = CountryName("Saint Vincent and the Grenadines"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDE8"),
            native = "Saint Vincent and the Grenadines",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("XCD"), timezone = TimezoneId("America/St_Vincent")
        ),
        Country(
            alpha2 = Alpha2Code("VE"), alpha3 = Alpha3Code("VEN"), numeric = NumericCode("862"),
            name = CountryName("Venezuela (Bolivarian Republic of)"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDEA"),
            displayName = "Venezuela", native = "Venezuela",
            continent = Continent.SOUTH_AMERICA, region = Region.SOUTH_AMERICA,
            callingCode = CallingCode("+58"), currency = CurrencyCode("VES"), timezone = TimezoneId("America/Caracas")
        ),
        Country(
            alpha2 = Alpha2Code("VG"), alpha3 = Alpha3Code("VGB"), numeric = NumericCode("092"),
            name = CountryName("Virgin Islands (British)"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDEC"),
            native = "British Virgin Islands",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Tortola")
        ),
        Country(
            alpha2 = Alpha2Code("VI"), alpha3 = Alpha3Code("VIR"), numeric = NumericCode("850"),
            name = CountryName("Virgin Islands (U.S.)"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDEE"),
            native = "United States Virgin Islands",
            continent = Continent.NORTH_AMERICA, region = Region.CARIBBEAN,
            callingCode = CallingCode("+1"), currency = CurrencyCode("USD"), timezone = TimezoneId("America/Virgin")
        ),
        Country(
            alpha2 = Alpha2Code("VN"), alpha3 = Alpha3Code("VNM"), numeric = NumericCode("704"),
            name = CountryName("Viet Nam"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDF3"),
            displayName = "Vietnam", native = "Vi\u1EC7t Nam",
            continent = Continent.ASIA, region = Region.SOUTHEASTERN_ASIA,
            callingCode = CallingCode("+84"), currency = CurrencyCode("VND"), timezone = TimezoneId("Asia/Ho_Chi_Minh")
        ),
        Country(
            alpha2 = Alpha2Code("VU"), alpha3 = Alpha3Code("VUT"), numeric = NumericCode("548"),
            name = CountryName("Vanuatu"), flag = FlagEmoji("\uD83C\uDDFB\uD83C\uDDFA"),
            native = "Vanuatu",
            continent = Continent.OCEANIA, region = Region.MELANESIA,
            callingCode = CallingCode("+678"), currency = CurrencyCode("VUV"), timezone = TimezoneId("Pacific/Efate")
        ),
        Country(
            alpha2 = Alpha2Code("WF"), alpha3 = Alpha3Code("WLF"), numeric = NumericCode("876"),
            name = CountryName("Wallis and Futuna"), flag = FlagEmoji("\uD83C\uDDFC\uD83C\uDDEB"),
            native = "Wallis et Futuna",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+681"), currency = CurrencyCode("XPF"), timezone = TimezoneId("Pacific/Wallis")
        ),
        Country(
            alpha2 = Alpha2Code("WS"), alpha3 = Alpha3Code("WSM"), numeric = NumericCode("882"),
            name = CountryName("Samoa"), flag = FlagEmoji("\uD83C\uDDFC\uD83C\uDDF8"),
            native = "Samoa",
            continent = Continent.OCEANIA, region = Region.POLYNESIA,
            callingCode = CallingCode("+685"), currency = CurrencyCode("WST"), timezone = TimezoneId("Pacific/Apia")
        ),
        Country(
            alpha2 = Alpha2Code("YE"), alpha3 = Alpha3Code("YEM"), numeric = NumericCode("887"),
            name = CountryName("Yemen"), flag = FlagEmoji("\uD83C\uDDFE\uD83C\uDDEA"),
            native = "\u0627\u0644\u064A\u064E\u0645\u064E\u0646",
            continent = Continent.ASIA, region = Region.WESTERN_ASIA,
            callingCode = CallingCode("+967"), currency = CurrencyCode("YER"), timezone = TimezoneId("Asia/Aden")
        ),
        Country(
            alpha2 = Alpha2Code("YT"), alpha3 = Alpha3Code("MYT"), numeric = NumericCode("175"),
            name = CountryName("Mayotte"), flag = FlagEmoji("\uD83C\uDDFE\uD83C\uDDF9"),
            native = "Mayotte",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+262"), currency = CurrencyCode("EUR"), timezone = TimezoneId("Indian/Mayotte")
        ),
        Country(
            alpha2 = Alpha2Code("ZA"), alpha3 = Alpha3Code("ZAF"), numeric = NumericCode("710"),
            name = CountryName("South Africa"), flag = FlagEmoji("\uD83C\uDDFF\uD83C\uDDE6"),
            native = "South Africa",
            continent = Continent.AFRICA, region = Region.SOUTHERN_AFRICA,
            callingCode = CallingCode("+27"), currency = CurrencyCode("ZAR"), timezone = TimezoneId("Africa/Johannesburg")
        ),
        Country(
            alpha2 = Alpha2Code("ZM"), alpha3 = Alpha3Code("ZMB"), numeric = NumericCode("894"),
            name = CountryName("Zambia"), flag = FlagEmoji("\uD83C\uDDFF\uD83C\uDDF2"),
            native = "Zambia",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+260"), currency = CurrencyCode("ZMW"), timezone = TimezoneId("Africa/Lusaka")
        ),
        Country(
            alpha2 = Alpha2Code("ZW"), alpha3 = Alpha3Code("ZWE"), numeric = NumericCode("716"),
            name = CountryName("Zimbabwe"), flag = FlagEmoji("\uD83C\uDDFF\uD83C\uDDFC"),
            native = "Zimbabwe",
            continent = Continent.AFRICA, region = Region.EASTERN_AFRICA,
            callingCode = CallingCode("+263"), currency = CurrencyCode("ZWL"), timezone = TimezoneId("Africa/Harare")
        )
    )
}
