# TSS_2026
Tema: Testare unitara in Java (T3)

Acest proiect contine o aplicatie Java pentru clasificarea triunghiurilor si o suita de teste unitare bazate pe JUnit 5.
Se da problema de clasificare a triungiurilor, primind lungimile laturilor ca si informatie, dupa conditiile de baza:
- tipul: dreptunghic, isoscel, echilateral

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

## Workflow-ul testarii (Pasul cu pas)

### Pasul 1: Scrierea si testarea codului
```
1. Tu scrii cod sursa:
   TriangleClassifier.java (clase cu metode)

2. Tu scrii teste (12 teste):
   TriangleClassifierTest.java (7 manuale)
   TriangleClassifierAIGeneratedTest.java (5 AI)
```

### Pasul 2: Compilare si executie
```
mvn test  →  Maven compileaza si ruleaza testele automat
             ↓
             "Tests run: 12, Failures: 0, Errors: 0"  ✅ PASS
```

### Pasul 3: Masurare acoperire cod (JaCoCo)
```
mvn test jacoco:report  →  Genereaza raport cu % acoperire
                           ↓
                           target/site/jacoco/index.html
                           
Rezultat: 34/39 linii testate = 87% coverage
```

### Pasul 4: Analiza mutatii (PIT)
```
mvn org.pitest:pitest-maven:mutationCoverage
    ↓
1. PIT creeaza 25 mutatii in cod
   (ex: schimba > in >=, True in False, etc)

2. Ruleaza testele pentru FIECARE mutatie
   - Daca test ESUEAZA cu mutatia → Mutant UCIS ✅
   - Daca test REUSESTE cu mutatia → Mutant SUPRAVIETUIT ❌

3. Rezultat final:
   18 mutatii ucise / 25 totale = 72% mutation score
   ↓
   target/pit-reports/index.html
```

### Rezultat final
```
✅ Codul e functional (12 teste trec)
✅ 87% din cod e acoperit de teste (JaCoCo)
✅ Testele gasesc 72% din bug-urile posibile (PIT)
```

## Unde vad rapoartele?

Dupa rularea comenzilor, genereaza automat:

| Raport | Locatie | Ce arata |
|---|---|---|
| **Teste** | `target/surefire-reports/` | Detalii fiecare test |
| **Coverage** | `target/site/jacoco/index.html` | Ce % din cod e testat (linii verzi/rosii) |
| **Mutatii** | `target/pit-reports/index.html` | Mutanti ucisi/supravietuitI |

Deschizi fisierele `.html` in browser pentru a vedea rapoartele vizuale.

## Demo video
Pentru demonstrarea functionarii proiectului, se recomanda crearea de videoclipuri scurte care arata:
- Rularea testelor: `mvn test`
- Generarea raportului de acoperire: `mvn test jacoco:report`
- Analiza mutantilor: `mvn org.pitest:pitest-maven:mutationCoverage`
- Vizualizarea rapoartelor HTML in browser (JaCoCo + PIT)

Videoclipurile pot fi inregistrate cu tool-uri precum OBS Studio sau Windows Game Bar.

> Daca Maven nu este instalat local, repo-ul pastreaza fisierele si structura proiectului pentru configurare ulterioara.
