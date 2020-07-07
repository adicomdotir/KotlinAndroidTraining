package ir.adicom.app.beginneridea.quiz

val countries = listOf(
    "Afghanistan", "Kabul",
    "Albania", "Tirana",
    "Algeria", "Algiers",
    "Andorra", "Andorra la Vella",
    "Angola", "Luanda",
    "Argentina", "Buenos Aires",
    "Armenia", "Yerevan",
    "Australia", "Canberra",
    "Austria", "Vienna",
    "Azerbaijan", "Baku",
    "Bahamas", "Nassau",
    "Bahrain", "Manama",
    "Bangladesh", "Dhaka",
    "Barbados", "Bridgetown",
    "Belarus", "Minsk",
    "Belgium", "Brussels",
    "Benin", "Porto-Novo",
    "Bermuda", "Hamilton",
    "Bhutan", "Thimphu",
    "Bolivia", "Sucre",
    "Bosnia and Herzegovina", "Sarajevo",
    "Botswana", "Gaborone",
    "Brazil", "Brasília",
    "Brunei", "Bandar Seri Begawan",
    "Bulgaria", "Sofia",
    "Burkina Faso", "Ouagadougou",
    "Burundi", "Bujumbura",
    "Cambodia", "Phnom Penh",
    "Cameroon", "Yaoundé",
    "Canada", "Ottawa",
    "Chad", "N'Djamena",
    "Chile", "Santiago",
    "China", "Beijing",
    "Colombia", "Bogotá",
    "Costa Rica", "San José",
    "Croatia", "Zagreb",
    "Cuba", "Havana",
    "Cyprus", "Nicosia",
    "Czech Republic", "Prague",
    "Côte d'Ivoire", "Yamoussoukro",
    "Democratic Republic of the Congo", "Kinshasa",
    "Denmark", "Copenhagen",
    "Djibouti", "Djibouti",
    "Dominican Republic", "Santo Domingo",
    "Ecuador", "Quito",
    "Egypt", "Cairo",
    "El Salvador", "San Salvador",
    "Estonia", "Tallinn",
    "Ethiopia", "Addis Ababa",
    "Faroe Islands", "Tórshavn",
    "Fiji", "Suva", "countryCapital",
    "Finland", "Helsinki",
    "France", "Paris",
    "Gabon", "Libreville",
    "Gambia", "Banjul",
    "Georgia", "Tbilisi",
    "Germany", "Berlin",
    "Ghana", "Accra",
    "Gibraltar", "Gibraltar",
    "Greece", "Athens",
    "Greenland", "Nuuk",
    "Grenada", "St. George's",
    "Guam", "Hagåtña",
    "Guatemala", "Guatemala City",
    "Guernsey", "St. Peter Port",
    "Guinea", "Conakry",
    "Guinea-Bissau", "Bissau",
    "Guyana", "Georgetown",
    "Haiti", "Port-au-Prince",
    "Honduras", "Tegucigalpa",
    "Hungary", "Budapest",
    "Iceland", "Reykjavík",
    "India", "New Delhi",
    "Indonesia", "Jakarta",
    "Iran", "Tehran",
    "Iraq", "Baghdad",
    "Ireland", "Dublin",
    "Isle of Man", "Douglas",
    "Israel", "Jerusalem",
    "Italy", "Rome",
    "Jamaica", "Kingston",
    "Japan", "Tokyo",
    "Jersey", "St. Helier",
    "Jordan", "Amman",
    "Kazakhstan", "Astana",
    "Kenya", "Nairobi",
    "Kiribati", "Tarawa",
    "Kosovo", "Pristina",
    "Kuwait", "Kuwait City",
    "Kyrgyzstan", "Bishkek",
    "Laos", "Vientiane",
    "Latvia", "Riga",
    "Lebanon", "Beirut",
    "Lesotho", "Maseru",
    "Liberia", "Monrovia",
    "Libya", "Tripoli",
    "Liechtenstein", "Vaduz",
    "Lithuania", "Vilnius",
    "Luxembourg", "Luxembourg",
    "Macedonia", "Skopje",
    "Madagascar", "Antananarivo",
    "Malawi", "Lilongwe",
    "Malaysia", "Kuala Lumpur",
    "Maldives", "Malé",
    "Mali", "Bamako",
    "Malta", "Valletta",
    "Marshall Islands", "Majuro",
    "Mauritania", "Nouakchott",
    "Mauritius", "Port Louis",
    "Mexico", "Mexico City",
    "Moldova", "Chisinau",
    "Monaco", "Monaco",
    "Mongolia", "Ulaanbaatar",
    "Montenegro", "Podgorica",
    "Montserrat", "Plymouth",
    "Morocco", "Rabat",
    "Mozambique", "Maputo",
    "Myanmar", "Naypyidaw",
    "Nagorno-Karabakh Republic", "Stepanakert",
    "Namibia", "Windhoek",
    "Nauru", "Yaren",
    "Nepal", "Kathmandu",
    "Netherlands", "Amsterdam",
    "New Caledonia", "Nouméa",
    "New Zealand", "Wellington",
    "Nicaragua", "Managua",
    "Niger", "Niamey",
    "Nigeria", "Abuja",
    "Niue", "Alofi",
    "Norfolk Island", "Kingston",
    "North Korea", "Pyongyang",
    "Northern Cyprus", "Nicosia",
    "United Kingdom Northern Ireland", "Belfast",
    "Northern Mariana Islands", "Saipan",
    "Norway", "Oslo",
    "Oman", "Muscat",
    "Pakistan", "Islamabad",
    "Palestine", "Jerusalem",
    "Panama", "Panama City",
    "Paraguay", "Asunción",
    "Peru", "Lima", "countryCapital",
    "Philippines", "Manila",
    "Poland", "Warsaw",
    "Portugal", "Lisbon",
    "Puerto Rico", "San Juan",
    "Qatar", "Doha",
    "Republic of China (Taiwan)", "Taipei",
    "Republic of the Congo", "Brazzaville",
    "Romania", "Bucharest",
    "Russia", "Moscow",
    "Rwanda", "Kigali",
    "Samoa", "Apia",
    "San Marino", "San Marino",
    "Saudi Arabia", "Riyadh",
    "Scotland", "Edinburgh",
    "Senegal", "Dakar",
    "Serbia", "Belgrade",
    "Sierra Leone", "Freetown",
    "Singapore", "Singapore",
    "Slovakia", "Bratislava",
    "Slovenia", "Ljubljana",
    "Solomon Islands", "Honiara",
    "Somalia", "Mogadishu",
    "South Africa", "Pretoria",
    "South Korea", "Seoul",
    "Spain", "Madrid",
    "Sri Lanka", "Sri Jayawardenapura Kotte",
    "Sudan", "Khartoum",
    "Suriname", "Paramaribo",
    "Swaziland", "Mbabane",
    "Sweden", "Stockholm",
    "Switzerland", "Bern",
    "Syria", "Damascus",
    "Tajikistan", "Dushanbe",
    "Tanzania", "Dodoma",
    "Thailand", "Bangkok",
    "Togo", "Lomé", "countryCapital",
    "Tonga", "Nukuʻalofa",
    "Trinidad and Tobago", "Port of Spain",
    "Tunisia", "Tunis",
    "Turkey", "Ankara",
    "Turkmenistan", "Ashgabat",
    "Uganda", "Kampala",
    "Ukraine", "Kiev",
    "United Arab Emirates", "Abu Dhabi",
    "United Kingdom; England", "London",
    "United States", "Washington, D.C.",
    "Uruguay", "Montevideo",
    "Uzbekistan", "Tashkent",
    "Vatican City", "Vatican City",
    "Venezuela", "Caracas",
    "Vietnam", "Hanoi",
    "Wales", "Cardiff",
    "Yemen", "Sanaá",
    "Zambia", "Lusaka",
    "Zimbabwe", "Harare"
)