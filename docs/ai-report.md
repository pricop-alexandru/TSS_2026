# Raport AI pentru proiectul TSS 2026

## Tool AI folosit
- GitHub Copilot și OpenAI ChatGPT pentru generarea inițială a testelor și pentru extinderea suitei.

## Prompt folosit
```
Please inspect the Java triangle classifier repository structure and generate JUnit 5 tests for TriangleClassifier. Include boundary cases, equivalence classes, angle classification, invalid triangles, unsorted side order, and helper methods such as area, perimeter, semiperimeter, and height. Suggest differences between AI-generated tests and manual tests, and identify additional cases needed to improve mutation testing coverage.
```

## Ce am comparat
- testele manuale din `TriangleClassifierTest.java`
- testele generate de AI din `TriangleClassifierAIGeneratedTest.java`

### Ce acoperă testele manuale
- valori de frontieră: `0`, `-1`, `1`, `2`, `10`
- clase de echivalență pentru tipuri de triunghi
- acoperire pe decizii și condiții
- verificări pentru `area`, `perimeter`, `height` și `semiperimeter`

### Ce acoperă testele AI
- verificări funcționale pentru valori simple
- clasificare echilaterală, invalidă, dreptunghică, perimetru
- nu acoperă complet situații de frontieră și unghiuri obtuze

### Tabel comparativ
| Criteriu | Teste manuale | Teste AI |
|---|---|---|
| Clasa de echivalență | Da | Parțial |
| Frontiera | Da | Nu complet |
| Acoperire decizie | Da | Funcțională |
| Funcții geometrice | Arie, înălțime, semiperimetru | doar perimetru |
| Mutanți | Deteție mai bună | Limitată |

## Observații de testare
- testele AI au fost utile pentru prototipare rapidă
- am extins manual această bază cu teste care să reflecte strategiile învățate la curs
- comparația este importantă: AI oferă un start, dar nu înlocuiește analiza umană

## Rezultate
- **Total teste în proiect**: 17
- **Teste AI**: 5
- **Teste manuale**: 12
- **Acoperire JaCoCo**: 87%
- **Mutation score PIT**: 87%
- **PIT line coverage**: 95%

### Ce s-a îmbunătățit
- Am extins testele manuale pentru a include cazuri de frontieră suplimentare.
- Am adăugat teste cu ordonare nesortată a laturilor pentru a ucide mutantul `VOID_METHOD_CALLS`.
- Am îmbunătățit testarea pentru condițiile de validitate `a+b>c`, `a+c>b`, `b+c>a`.
- Am obținut o creștere a scorului PIT de la 72% la 87%.

## Concluzie
AI poate genera cod și teste utile ca suport, dar în cadrul temei T3 este necesară completarea cu teste manuale care să demonstreze:
- partitionare în clase de echivalență
- analiza valorilor de frontieră
- acoperire pe decizii și condiții
- investigare mutanți

## Referințe
- JUnit 5 documentation
- PIT mutation testing documentation
- GitHub Copilot documentation
