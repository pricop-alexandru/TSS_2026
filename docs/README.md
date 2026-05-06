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
- teste pentru partititionare, frontiera, decizie si conditie
- comparatie intre teste manuale si teste generate de AI
- verificare mutation testing si imbunatatire teste

## Strategii de testare detaliate
### 1. Clase de echivalenta
- `INVALID`: `0,5,5`, `-1,4,4`, `1,2,10`, `2,3,5`
- `EQUILATERAL`: `5,5,5`
- `ISOSCELES`: `5,5,7`
- `SCALENE`: `4,5,6`
- `RIGHT_SCALENE`: `3,4,5`, `5,3,4`

### 2. Analiza valorilor de frontiera
- laturi nule si negative: `0`, `-1`
- suma a două laturi egală cu a treia: `2,3,5`
- triungi minime și limite: `1,1,1`, `3,4,5`

### 3. Acoperire decizie și condiție
- acoperire decizie: `INVALID`, `EQUILATERAL`, `RIGHT_SCALENE`, `ISOSCELES`, `SCALENE`
- acoperire unghi: `ACUTE`, `RIGHT`, `OBTUSE`, `INVALID`
- condiții individuale în `isValidTriangle`: `a > 0`, `b > 0`, `c > 0`, `a + b > c`, `a + c > b`, `b + c > a`

### 4. Testare circuit independent
- `isRightTriangle(5,3,4)` acoperă sortarea internă și verificarea teoremei lui Pitagora
- `isObtuseTriangle(2,3,4)` și `isAcuteTriangle(4,5,6)` acoperă clasele de unghiuri
- `semiperimeter` și `height` sunt testate separat pentru calcul geometric

### 5. Analiza mutantilor
- `CONDITIONALS_BOUNDARY`: limite de comparație
- `NEGATE_CONDITIONALS`: inversări de condiții
- `VOID_METHOD_CALLS`: apeluri de metodă eliminate
- `INVERT_NEGS`: semne inverse

### Ce am îmbunătățit între testele inițiale și cele finale
- am adăugat cazuri de frontieră suplimentare pentru `a+b == c`
- am verificat ordinea nesortată a laturilor în triunghiul dreptunghic
- am extins testele cu `semiperimeter` și `height`
- am crescut mutation score de la 72% la 87%
- am documentat diferențele între testele manuale și testele AI

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

