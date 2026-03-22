# cgi-2026

<p>Minu lahendus CGI 2026 suvi praktikumi jaoks</p>

---

>Lahenduse hilja esitamise põhjus on ülikooli õppimisega tõttu. Mul oli 4+ nädala järjesti suured ja olulised kontrolltööd. Ikka tahan proovida ja lahendada nii palju kui saan.

---

## Ülesanne kirjeldus

<p>Ülesandeks on luua restoranikülastajale laudade broneerimise ja sobiva laua soovitamise veebirakendus.<br>
Külastaja soovib broneerida lauda kindlaks kellaajaks ning peab saama rakendada erinevaid filtreid, mille alusel talle vabu aegu ja laudu soovitatakse. Lisaks peab rakendus soovitama kliendile parimat võimalikku lauda, võttes arvesse seltskonna suurust ja kliendi eelistusi (nt privaatsus, aknakoht, ligipääsetavus).<br>
Laua soovitamine ja valimine peab toimuma restorani saali plaanil. Juba broneeritud lauad tuleks genereerida juhuslikult.</p>

---

### Tehnoloogiad
<p>Ülesande lahendamiseks ei ole ette nähtud kindlat front-end raamistikku. Rakenduse back-endis tuleks kasutada Spring Boot'i ning viimast Java LTS versiooni. Tuleb kasutada versioonikontrolli (Git).</p><br>

---

### Lahenduse etapid

1. <p>Broneeringu otsing ja filtreerimine Kasutaja peaks alguses nägema restorani saaliplaani või ajakava. Kasutaja peab saama otsingut filtreerida. Näited filtritest (nimekiri ei ole lõplik):</p><br>
* Kuupäev ja kellaaeg
* Inimeste arv (seltskonna suurus)
* Tsoon (nt terrass, sisesaal, privaatruum)<br>

2. <p> Laua soovitamine ja paigutuse loogika Kui kellaaeg ja inimeste arv on valitud, peab rakendus soovitama kliendile sobivaima laua(d). Soovitused tuleks kuvada restorani plaanil. Algoritm peaks püüdma laudu täita efektiivselt, kuid arvestama kliendi soove.</p><br>
* Efektiivsus: 2-liikmelist seltskonda ei ole mõistlik paigutada 8-kohalisse lauda, kui saadaval on 2-kohaline laud.
* Eelistused: Võimalus valida eelistusi nagu "Vaikne nurk / Privaatsus", "Akna all", "Laste mängunurga lähedal".<br>
<p>Soovituse loogika on vabalt valitav. Näiteks võib vabadele laudadele omistada skoori, mis põhineb sellel, kui hästi laud vastab seltskonna suurusele (et ei jääks liiga palju tühje toole) ja kliendi eelistustele.</p><br>

3. <p>Visuaalne plaan Restorani suuruse ja laudade paigutuse võib vabalt valida (võib olla lihtne ruudustik või vabalt paigutatud objektid).</p><br>
* Hõivatud lauad peavad olema visuaalselt eristatavad.
* Soovitatud laud peaks olema esile tõstetud.<br>

4. "Kui aega jääb üle"
Kui tunned, et tahaksid teha midagi veel, et sinu töö eriliselt silma paistaks, on siin mõned ideed (kuid sinu fantaasia on piiriks)<br>
* Dünaamiline laudade liitmine: Kui suurt seltskonda (nt 10 inimest) ei saa paigutada ühte lauda, soovitab süsteem kahte kõrvuti asuvat lauda, mida saab kokku lükata.
* Arvesta keskmise külastuse ajaga: 2-3h möödudes võiks eeldada, et konkreetne laud on uuesti broneeringuteks saadaval.
* Admin vaade: Lihtne liides restorani omanikule, kus ta saab hiirega lohistades laudade paigutust muuta.

* Väline API: Integreeri rakendus mõne avaliku retsepti- või toiduandmebaasiga (nt TheMealDB), et broneeringu juurde saaks soovitada ka päevapraadi.
* Testid ja Docker: Lisa rakendusele automaattestid ja paiguta rakendus Dockeri konteinerisse.

### Komentaarid lahenduse kaigu kohta
<p>Kuna aega oli vahe puudsin teha minimalselt tootav prototuupi. Selleparast et endal pole suurt kogemust tapselt Boot Springi kohta pidin ka samuti palju umberkontrollida ja kiiresti aru saada kuidas mis tootab. </p>

### Kasutatud alikkad:
1) https://spring.io/
2) https://www.geeksforgeeks.org/
3) layout genereerimine ja sanity check - DeepSeek
4) https://quickref.me/java 

## KUIDAS KAIVITADA