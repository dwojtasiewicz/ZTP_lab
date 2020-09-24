# Puszek Okruszek
Aplikacja ta będzie pełnić funkcję bazy kotów. Celem tej aplikacji będzie jest udostępnienie narzędzi umożliwiających odnalezienie właściciela oznakowanego kota oraz nie oznakowanego poprzez wyszukiwarkę zaawansowaną. Osoba poszukująca danych o właścicielu zaginionego kota uzyskuje informację o kocie oraz kontakt do jego właściciela.
## Technologie i narzędzia
- Java 11
- Spring Boot 2.3.0
- Spring Security
- h2 database
- CrudRepository
- JWT

## Funkcjonalności
- logowanie oraz rejestracja nowego użytkownika
- każdy użytkownik będzie posiadał określone role 
- zabezpieczenie przed dostępem do wrażliwych danych 
- możliwość rejestracji kota , wyrejestrowania oraz zmiany informacji o kocie 
- możliwość zmienienia danych właściciela 
- wyszukiwanie kotów po kodzie mikro chipa 
- wyszukiwanie kotów po wieku, typie umaszczenia oraz płci 
- możliwość dodania adnotacji ze kot zaginął oraz miejsca ostatniego jego miejsca przebywania w postaci współrzędnych geograficznych.

## Porty 
- PuszekOkruszek : 8080

# Uruchomienie aplikacji
Aplikacja była uruchamiana i testowana za pomocą środowiska Intellij IDEA

Instalacja Java 11 Instalacja H2 database

Wejście do katalogu z projektem