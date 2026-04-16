# Documentatie proiect TSS 2026

## Descriere generala
Tema: T3 Testare unitara in Java.
Proiectul contine o clasa Java care clasifica triunghiurile si o suita de teste unitare JUnit 5.

## Structura proiectului
- `pom.xml` - configuratie Maven pentru compilare, testare, acoperire si analiza mutantilor.
- `src/main/java/ro/edu/fmi/tss` - cod sursa aplicatie.
- `src/test/java/ro/edu/fmi/tss` - teste unitare manuale si teste autogenerate AI.
- `docs/diagrams/triangle-classification.drawio` - diagrama UML / flux de clasificare.
- `docs/ai-report.md` - raport despre utilizarea tool-ului AI.
- `docs/presentation.md` - prezentare condusa in format Remark.js.

## Configuratie software
- Java 17+ recomandat.
- Maven 3.8+ pentru rulare locala.
- JUnit 5 pentru testare.
- JaCoCo pentru acoperire cod.
- PIT pentru analiza mutantilor.

## Strategii de testare
- **Partitionare in clase de echivalenta**: triunghi valid, triunghi invalid, echilateral, isoscel, scalene, dreptunghic.
- **Analiza valorilor de frontiera**: laturi nule / negative (0, -3), laturi mici valide (1, 1, 1), laturi care incalca inegalitatea triunghiului (1, 2, 10).
- **Acoperire la nivel de instructiune si decizie**: branch-urile `INVALID`, `EQUILATERAL`, `RIGHT_SCALENE`, `ISOSCELES`, `SCALENE`.
- **Analiza mutanti**: plugin PIT configurat pentru mutatori de conditii si returnari. Comenzile recomandate: `mvn test` si `mvn org.pitest:pitest-maven:mutationCoverage`.

## Cum se ruleaza
1. Instalati Maven si Java 17.
2. Din directorul proiectului, rulati:
   - `mvn test`
   - `mvn test jacoco:report`
   - `mvn org.pitest:pitest-maven:mutationCoverage`

## Rezultate testare

### Teste unitare
- **Total teste**: 12 (7 manuale + 5 AI generate)
- **Status**: Toate testele trec ✅
- **Timp executie**: ~0.1 secunde

### Acoperire cod (JaCoCo)
- **Linii acoperite**: 34/39 (87%)
- **Raport generat**: `target/site/jacoco/index.html`

### Analiza mutanti (PIT)
- **Mutanti generati**: 25
- **Mutanti ucisi**: 18 (72%)
- **Putere teste**: 72%
- **Teste per mutant**: 3.44
- **Raport generat**: `target/pit-reports/index.html`

#### Detalii mutatori:
- `CONDITIONALS_BOUNDARY`: 6 mutanti, 0 ucisi (0%)
- `VOID_METHOD_CALLS`: 1 mutant, 0 ucisi (0%)  
- `NEGATE_CONDITIONALS`: 18 mutanti, 18 ucisi (100%)
- `INVERT_NEGS`: Nu au fost generati mutanti

### Comparatie teste manuale vs AI
Testele manuale acopera strategii complete de testare (clase echivalenta, valori frontiera, acoperire decizii), in timp ce testele AI sunt mai simple si functionale. Testele manuale au dus la o acoperire mai buna si detectie mai eficienta a mutantilor.

## Referinte
- JUnit 5: https://junit.org/junit5/
- JaCoCo: https://www.jacoco.org/
- PIT: https://pitest.org/
- GitHub Copilot: https://github.com/features/copilot

> Nota: Proiectul este original si foloseste surse oficiale si noastre pentru documentatie, teste si analiza.
