# Plan proiect TSS 2026 - Testare unitară în Java

## Obiectiv general
Să transformăm tema simplă de clasificare triunghiuri într-un proiect care demonstrează fundamentele testării unitare prezentate la curs.

## Ce trebuie să includă proiectul
1. Tema proiectului descrisă clar în README:
   - ce se testează
   - ce strategii de testare sunt folosite
   - ce instrumente sunt folosite
2. Cod sursă funcțional extins:
   - clasificare tip triunghi
   - clasificare tip unghi
   - calcul arie, perimetru, semiperimetru, înălțime
3. Teste unitare:
   - manuale cu strategii de curs
   - teste generate de AI pentru comparație
4. Analiză de acoperire și mutant testing:
   - JaCoCo
   - PIT
5. Documentație și prezentare:
   - README cu explicații și rezultate
   - prezentare Markdown/Remark
   - diagramă realizată cu app.diagrams.net sau alt tool dedicat
6. Raport AI:
   - prompt folosit
   - comparație testele manuale vs AI
   - interpretări și concluzii

## Fundamentele de testare care trebuie acoperite
- partitionare în clase de echivalență
- analiză de frontieră
- acoperire la nivel de instrucțiune și decizie
- acoperire condițională
- circuite independente / path coverage
- analiza mutantilor

## Pași realizați
- codul a fost extins pentru clasificare unghiuri și calcule geometrice
- README principal și doc-uri au fost actualizate cu temă clară
- prezentarea a fost actualizată pentru a reflecta fundamentele
- raport AI comparativ a fost actualizat

## Pași rămași
1. Actualizare diagramă `docs/diagrams/triangle-classification.drawio`
   - include clasificarea triunghiului și fluxul de testare
2. Adăugare capturi de ecran în README/docs:
   - rulare `mvn test`
   - raport JaCoCo
   - raport PIT
3. Completare prezentare cu imagini/diagrame și rezultatele obținute
4. Documentare finală despre configurare hardware/software și tool-uri folosite
5. Verificare finală a raportului de testare și a cerințelor temei

## Priorități
- Prioritatea 1: documentație clară a temei și strategiei de testare
- Prioritatea 2: comparație manual vs AI, cu exemple concrete
- Prioritatea 3: rapoarte de testare și rezultate numerice
- Prioritatea 4: prezentare scurtă și structurată

## Ce poate fi făcut imediat
- Generare raport JaCoCo și salvare locații în README
- Generare raport PIT și salvare locații în README
- Adăugare tabel comparativ detaliat între teste manuale și AI
- Adăugare slide cu „Cursuri consultate / fundament”
