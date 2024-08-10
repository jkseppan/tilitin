# Tilitin

Tilitin on ilmainen kirjanpito-ohjelma. Ohjelman teki Tommi Helineva, ja sen dokumentaatio on hänen
sivuillaan: https://helineva.net/tilitin/

Ohjelmaan on vuonna 2024 tehnyt pieniä ajanmukaistuksia ja korjauksia Jouni Seppänen.

## Asennus

1. Asenna Java 21 tai uudempi. Suosittelen OpenJDK-versiota, joka on saatavailla ilmaiseksi ja
   avoimella lisenssillä. Esimerkiksi [Azulin](https://www.azul.com/downloads/#zulu) tai
   [Adoptiumin](https://adoptium.net/) jakelut ovat hyviä. (Oraclen Javaa en suosittele, koska
   vaikka uusia versioita saakin ilmaiseksi, sillä on ollut kummallisia lisenssitemppuja
   menneisyydessä.)
2. Lataa jar-tiedosto GitHubista ja kopioi sopivaan hakemistoon.
3. Tuplaklikkaa jar-tiedostoa. Jos sinulla on Mac, tämä johtaa luultavasti valitukseen
   epäilyttävästä ohjelmistosta. Jos uskallat käyttää sitä, voit ohittaa valituksen klikkaamalla
   jar-tiedostoa hiiren oikealla painikkeella (ohjauslevyllä käytä kahta sormea, tai paina
   ctrl-näppäintä klikatessa) ja valitsemalla "Avaa".

## Muutokset

- Tilittimen pitäisi nyt toimia uusillakin Maceilla, joissa on ARM-siru.
- Korjattu Macilla esiintynyt bugi, jossa tekstikentän ensimmäinen merkki katosi usein.
- Tilikartat ovat nyt jar-paketin sisällä, joten niitä ei tarvitse kopioida erikseen oikeaan
  hakemistoon.
- Uusi tilikartta alv-prosentilla 25,5%
- Pieniä teknisiä ajanmukaistuksia
- Käytetyt kirjastot on päivitetty ja niiden lisenssiehdot luetellaan ikkunassa
  "Tietoja ohjelmasta Tilitin".

## Lisenssi

Tämä on vapaa ohjelma: tätä ohjelmaa saa levittää edelleen ja muuttaa Free Software Foundationin
julkaiseman GNU General Public Licensen (GPL-lisenssi) version 3 ehtojen mukaisesti.

Tätä ohjelmaa levitetään siinä toivossa, että se olisi hyödyllinen mutta ilman mitään takuuta; edes
hiljaista takuuta kaupallisesti hyväksyttävästä laadusta tai soveltuvuudesta tiettyyn tarkoitukseen.
Katso GPL-lisenssistä lisää yksityiskohtia.

Tämän ohjelman mukana pitäisi tulla kopio GPL-lisenssistä tiedostossa COPYING. Jos näin ei ole,
katso <http://www.gnu.org/licenses/>.

Komponenttien lisenssit ja niihin sisältyvät ehdot ovat tiedostossa LISENSSIT.html.
