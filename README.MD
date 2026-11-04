# Biblioteka grada

Spring Boot aplikacija za upravljanje članovima, knjigama i pozajmicama. Podaci se čuvaju u MySQL bazi preko Spring Data JPA, a aplikacija nudi Thymeleaf stranice i REST JSON endpoint-e.

## Modeli

### Member

- `id` (`Long`)
- `name` (`String`)
- `surname` (`String`)
- `cash` (`int`)

### Book

- `id` (`Long`)
- `title` (`String`)
- `author` (`String`)
- `price` (`int`)

### Pozajmica

- `id` (`Long`)
- `datumPozajmljivanja` (`LocalDate`)
- `member` (`Member`)
- `book` (`Book`)

`Member` i `Book` su u N:N vezi koja je modelovana entitetom `Pozajmica`. Jedan član može imati više pozajmica, a jedna knjiga može biti pozajmljena u više evidencija.

## Thymeleaf stranice

- `/members` - prikaz svih članova
- `/members/{amount}` - članovi čiji je novac najmanje zadati iznos
- `/books` - prikaz svih knjiga
- `/loans` - prikaz pozajmica i forma za dodavanje nove pozajmice
- `/` - preusmjerenje na `/loans`

Sve stranice koriste zajednički navbar i zajednički CSS (`src/main/resources/static/css/style.css`) radi ujednačenog izgleda.
Forma za pozajmicu prima člana, knjigu i datum pozajmljivanja.

## REST API

- `GET /api/members` - članovi u JSON formatu
- `GET /api/books` - knjige u JSON formatu
- `GET /api/loans` - pozajmice sa članom, knjigom i datumom

## Baza podataka

Podrazumevana konfiguracija u `src/main/resources/application.properties` koristi:

- URL: `jdbc:mysql://localhost:3306/biblioteka`
- korisnik: `root`
- lozinka: `0000`

MySQL server mora biti pokrenut. Baza `biblioteka` se kreira automatski ako korisnik ima potrebne privilegije, a Hibernate ažurira šemu (`ddl-auto=update`).

SQL inicijalizacija je omogućena (`spring.sql.init.mode=always`), a `src/main/resources/schema.sql` kreira tabele i dodaje inicijalne (dummy) zapise za članove, knjige i pozajmice ako već ne postoje.

## Pokretanje

```bash
./mvnw spring-boot:run
```

Nakon pokretanja otvoriti `http://localhost:8080/loans` ili pozvati REST endpoint-e preko `/api`.

Autori: Tajra Tašić (556), Samer Kolasevic (529).
**KORIŠTEN INTEGRISANI AI UNUTAR JETBRAINS ALATA (github copilot sa edu packom)**
