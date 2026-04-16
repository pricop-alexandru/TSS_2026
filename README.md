# TSS_2026
Tema: Testare unitara in Java (T3)

Acest proiect contine o aplicatie Java pentru clasificarea triunghiurilor si o suita de teste unitare bazate pe JUnit 5.

## Continut
- `src/main/java/ro/edu/fmi/tss` - cod sursa aplicatie
- `src/test/java/ro/edu/fmi/tss` - teste unitare
- `docs/` - documentatie, raport AI, prezentare si diagrama
- `pom.xml` - configuratie Maven pentru compilare si testare

## Cum se ruleaza
1. Instalati Java 17 si Maven 3.8+
2. Din directorul proiectului, rulati:
   - `mvn test`
   - `mvn test jacoco:report`
   - `mvn org.pitest:pitest-maven:mutationCoverage`

## Demo video
Pentru demonstrarea functionarii proiectului, se recomanda crearea de videoclipuri scurte care arata:
- Rularea testelor: `mvn test`
- Generarea raportului de acoperire: `mvn test jacoco:report`
- Analiza mutantilor: `mvn org.pitest:pitest-maven:mutationCoverage`
- Vizualizarea rapoartelor HTML in browser

Videoclipurile pot fi inregistrate cu tool-uri precum OBS Studio sau Windows Game Bar.

> Daca Maven nu este instalat local, repo-ul pastreaza fisierele si structura proiectului pentru configurare ulterioara.
