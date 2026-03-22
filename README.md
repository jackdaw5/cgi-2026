# cgi-2026

Minu lahendus CGI 2026 suvi praktikumi jaoks
---
Lahenduse hilja esitamise põhjus on ülikooli õppimisega tõttu. Mul oli 4+ nädala järjesti suured ja olulised kontrolltööd. Ikka tahan proovida ja lahendada nii palju kui saan.
---

## Ülesanne kirjeldus

Ülesandeks on luua restoranikülastajale laudade broneerimise ja sobiva laua soovitamise veebirakendus.
Külastaja soovib broneerida lauda kindlaks kellaajaks ning peab saama rakendada erinevaid filtreid, mille alusel talle vabu aegu ja laudu soovitatakse. Lisaks peab rakendus soovitama kliendile parimat võimalikku lauda, võttes arvesse seltskonna suurust ja kliendi eelistusi (nt privaatsus, aknakoht, ligipääsetavus).
Laua soovitamine ja valimine peab toimuma restorani saali plaanil. Juba broneeritud lauad tuleks genereerida juhuslikult.
---

### Tehnoloogiad
Ülesande lahendamiseks ei ole ette nähtud kindlat front-end raamistikku. Rakenduse back-endis tuleks kasutada Spring Boot'i ning viimast Java LTS versiooni. Tuleb kasutada versioonikontrolli (Git).
---

### Lahenduse etapid

1. Broneeringu otsing ja filtreerimine Kasutaja peaks alguses nägema restorani saaliplaani või ajakava. Kasutaja peab saama otsingut filtreerida. Näited filtritest (nimekiri ei ole lõplik):
* Kuupäev ja kellaaeg
* Inimeste arv (seltskonna suurus)
* Tsoon (nt terrass, sisesaal, privaatruum)

2. Laua soovitamine ja paigutuse loogika Kui kellaaeg ja inimeste arv on valitud, peab rakendus soovitama kliendile sobivaima laua(d). Soovitused tuleks kuvada restorani plaanil. Algoritm peaks püüdma laudu täita efektiivselt, kuid arvestama kliendi soove.
* Efektiivsus: 2-liikmelist seltskonda ei ole mõistlik paigutada 8-kohalisse lauda, kui saadaval on 2-kohaline laud.
* Eelistused: Võimalus valida eelistusi nagu "Vaikne nurk / Privaatsus", "Akna all", "Laste mängunurga lähedal".
Soovituse loogika on vabalt valitav. Näiteks võib vabadele laudadele omistada skoori, mis põhineb sellel, kui hästi laud vastab seltskonna suurusele (et ei jääks liiga palju tühje toole) ja kliendi eelistustele.

3. Visuaalne plaan Restorani suuruse ja laudade paigutuse võib vabalt valida (võib olla lihtne ruudustik või vabalt paigutatud objektid).
* Hõivatud lauad peavad olema visuaalselt eristatavad.
* Soovitatud laud peaks olema esile tõstetud.

4. "Kui aega jääb üle"
Kui tunned, et tahaksid teha midagi veel, et sinu töö eriliselt silma paistaks, on siin mõned ideed (kuid sinu fantaasia on piiriks)
* Dünaamiline laudade liitmine: Kui suurt seltskonda (nt 10 inimest) ei saa paigutada ühte lauda, soovitab süsteem kahte kõrvuti asuvat lauda, mida saab kokku lükata.
* Arvesta keskmise külastuse ajaga: 2-3h möödudes võiks eeldada, et konkreetne laud on uuesti broneeringuteks saadaval.
* Admin vaade: Lihtne liides restorani omanikule, kus ta saab hiirega lohistades laudade paigutust muuta.

* Väline API: Integreeri rakendus mõne avaliku retsepti- või toiduandmebaasiga (nt TheMealDB), et broneeringu juurde saaks soovitada ka päevapraadi.
* Testid ja Docker: Lisa rakendusele automaattestid ja paiguta rakendus Dockeri konteinerisse.