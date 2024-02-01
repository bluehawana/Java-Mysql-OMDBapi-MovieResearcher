# Skapa en Filmhanteringsapplikation med Java och MySQL

## Beskrivning

I denna uppgift kommer ni att skapa en enkel konsolapplikation i Java för att hantera filmdata. Applikationen kommer att
interagera med OMDB Movie API för att hämta information om filmer och sedan lagra denna information i en MySQL-databas.
Applikationen kommer att erbjuda funktionaliteter för att söka efter filmer baserat på titel, skådespelare, år och
regissör.

## Mål

* Att lära sig att integrera en Java-applikation med en extern API-tjänst (OMDB Movie API).
* Att utveckla färdigheter i att hantera och lagra data i en MySQL-databas.
* Att följa Clean Code-principer och skapa kod som är lätt att testa och underhålla.

## Förkunskaper

* Grundläggande förståelse för Java och Objektorienterad Programmering (OOP).
* Grundläggande kännedom om SQL och databaser, speciellt MySQL.
* Erfarenhet av att arbeta med externa API:er är en fördel men inte ett krav.

## Färdigheter som utvecklas

* Integration av Java-applikationer med externa API:er.
* Datahantering och manipulation med MySQL.
* Förståelse för miljövariabler och säker hantering av känslig information.
* Utveckling av användargränssnitt i en kommandotolksapplikation (CLI).

## Steg-för-Steg Instruktioner

1. **API-integration:** Implementera en klass som kommunicerar med OMDB Movie API för att hämta filmdata.
2. **Databashantering:** Skapa en MySQL-databas och tabeller för att lagra filmer. Implementera funktioner för att lägga
   till, hämta, och söka efter filmer i databasen.
3. **Sökfunktionalitet:** Utveckla funktioner för att söka efter filmer baserat på olika kriterier såsom titel,
   skådespelare, år och regissör.
4. **Java CLI-gränssnitt:** Skapa ett enkelt textbaserat gränssnitt där användare kan välja olika operationer för att
   söka och visa filmdata.
5. **Miljökonfiguration:** Använd en `.env`-fil för att hantera API-nycklar och databasanslutningsuppgifter.

## Ni ska leverera

* Fullständigt implementerad och fungerande Java-konsolapplikation.
* Strukturerad och dokumenterad kod enligt Clean Code-principer.
* `.env`-fil för konfigurationsdata (exempelvis i en `.env.example`-fil).

## Bedömningskriterier

* **Funktionalitet:** Applikationen ska korrekt hämta data från OMDB Movie API och hantera den i MySQL-databasen.
* **Kodkvalitet:** Koden ska vara välstrukturerad, följa SRP och DRY-principerna, och vara lätt att förstå och
  underhålla.
* **Gränssnittet:** Användargränssnittet ska vara tydligt och användarvänligt.
* **Säkerhet:** Säker hantering av känslig information som API-nycklar och databasuppgifter.
* **Dokumentation:** Klar och tydlig dokumentation av kod och dess funktioner.

Lycka till och ha kul med uppgiften!
