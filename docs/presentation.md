---
title: "TSS 2026 — Testare unitara in Java"
author: "Echipa TSS"
---

# Tema proiectului

- Testare unitara in Java pentru o componenta de clasificare triunghiuri
- Tema extinsa: clasificare tip triunghi si tip unghi, calcul arie, perimetru, inaltime
- Obiectiv: demonstram fundamentele testarii unitare vazute la curs

---

# Fundamente corelate cursului

- Partitionare in clase de echivalenta
- Analiza valorilor de frontiera
- Acoperire la nivel de instructiune, decizie, conditie
- Circuite independente / path coverage
- Analiza mutantilor pentru calitatea suitei de teste

---

# Arhitectura solutiei

- `TriangleClassifier` - logica principala de validare si clasificare
- `TriangleType` si `AngleType` - tipuri de clasificare
- `TriangleClassifierTest` - teste manuale pe strategii de curs
- `TriangleClassifierAIGeneratedTest` - teste generate de AI pentru comparatie

---

# Strategii de testare aplicate

- Clase de echivalenta: invalid, echilateral, isoscel, scalene, dreptunghic
- Frontiera: 0, negativ, incalcarea inegalitatii, triunghiuri minime
- Acoperire: INVALID, EQUILATERAL, RIGHT_SCALENE, ISOSCELES, SCALENE
- Analiza unghi: ACUTE, RIGHT, OBTUSE

---

# Acoperire si mutanti

- JaCoCo: masurare acoperire de linii si instructiuni
- PIT: analiza mutantilor pentru a masura puterea suitei
- Scop: sa extindem codul si testele pentru a ucide cat mai multi mutanti

---

# Comparatie manual vs AI

- Teste manuale: strategii de curs, boundary, decizie, conditie, geometrie
- Teste AI: prototip rapid, verificari functionale, cazuri simple
- Rezultat: AI ajuta generarea initiala, dar testele manuale dovedesc robustetea

---

# Rezultate reale

- Total teste: 17
- Teste manuale: 12
- Teste AI: 5
- JaCoCo: 87%
- Mutation score PIT: 87%
- PIT line coverage: 95%

---

# Comparatie om vs AI

- AI a generat un set inițial de teste rapide
- Omul a completat cu:
  - cazuri de frontieră
  - verificări nesortate de ordonare
  - validări geometry helper methods
  - testare mutațiilor boundary

---

# Prompt AI

```
Please inspect the Java triangle classifier repository structure and generate JUnit 5 tests for TriangleClassifier. Include boundary cases, equivalence classes, angle classification, invalid triangles, unsorted side order, and helper methods such as area, perimeter, semiperimeter, and height.
```

---

# Concluzii

- Testele manuale asigura acoperire mai bogată
- Testele AI accelerează prototiparea
- Analiza mutantilor crește încrederea în suită
