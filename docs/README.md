# Documentatie proiect TSS 2026

## Descriere generala
Tema: T3 Testare unitara in Java.

Acest proiect arata o abordare completa de testare unitara pentru un clasificator de triunghiuri cu:
- clasificare tip triunghi
- clasificare tip unghi
- calcul aria, perimetru, semiperimetru, inaltime
- teste manuale si AI
- raportare JaCoCo si PIT

## Structura proiectului
- `pom.xml` - configuratie Maven pentru compilare, teste, acoperire si analiza mutantilor
- `src/main/java/ro/edu/fmi/tss` - cod sursa aplicatie
- `src/test/java/ro/edu/fmi/tss` - teste unitare
- `docs/diagrams/triangle-classification.drawio` - diagrama de flux si UML
- `docs/ai-report.md` - raport despre utilizarea AI in testare
- `docs/presentation.md` - prezentare proiect in format markdown + remark

## Configuratie software
- Java 17 sau mai nou
- Maven 3.8+
- JUnit 5
- JaCoCo
- PIT

## Tema si evolutie
Tema initiala era o tematica simpla de clasificare triunghiuri. Pentru a demonstra fundamentele testarii unitare am extins proiectul astfel:
- adaugare clasificare unghiuri
- masurare arie si inaltime
- teste pentru partiitionare, frontiera, decizie si conditie
- comparatie intre teste manuale si teste generate de AI
- verificare mutation testing si imbunatatire teste

## Strategii de testare
- Partitionare in clase de echivalenta
- Analiza valorilor de frontiera
- Acoperire la nivel de instructiune si decizie
- Teste circuit independent
- Analiza raportului de mutanti

## Cum se ruleaza
1. Instalati Java 17 si Maven 3.8+
2. Din directorul proiectului rulati:
   - `mvn clean test`
   - `mvn test jacoco:report`
   - `mvn org.pitest:pitest-maven:mutationCoverage`

## Rezultate principale
- **Teste totale**: 17
- **Teste manuale**: 12
- **Teste AI**: 5
- **Status**: toate testele trec
- **Acoperire JaCoCo**: 87%
- **Mutation score PIT**: 87%
- **PIT line coverage**: 95%

## Comparatie manual vs AI
- Testele manuale includ explicite scenarii de frontieră, clase de echivalență și verificări asupra fiecărei decizii
- Testele AI sunt utile pentru prototipare, dar nu acoperă complet valori de frontieră și situații de invaliditate

## Diagrama si capturi ecran
- `docs/diagrams/triangle-classification.drawio` - diagrama fluxului de clasificare și testare
- `docs/screenshots/Test1_jacoco.png` - captură ecran raport JaCoCo (set 1)
- `docs/screenshots/Test1_pit.png` - captură ecran raport PIT (set 1)
- `docs/screenshots/Test2_jacoco.png` - captură ecran raport JaCoCo (set 2)
- `docs/screenshots/Test2_pit.png` - captură ecran raport PIT (set 2)

## Referinte
- JUnit 5: https://junit.org/junit5/
- JaCoCo: https://www.jacoco.org/
- PIT: https://pitest.org/
- GitHub Copilot: https://github.com/features/copilot

> Proiectul este original si foloseste surse oficiale si referinte mentionate in documentatie.
