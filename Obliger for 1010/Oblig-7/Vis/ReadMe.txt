Kommentarer for main-klassen:
Jeg har tatt insiprasjon fra Dag Langmyhr sin tripptrapptresko 
når det gjelder strukturen og klassene siden det ble lettere 
for meg å implementere labyrintløseren fra oblig 6 i gui-programmet 
mitt. 

Kommentarer for RuteBrett-klassen:
Lager brettet av knapper, hvor jeg differensierer mellom knappene 
som blant annet teksten til knappen som representerer sort,hvit eller åpningsrute. 
Har en boolean metode som sjekker tilfelle hvis bruker har trykket på en hvit-rute 
og oppgitt stien i programmet, da skal nullstill()-metoden nullstille brettet 
og det gjør den ved å endre teksten på alle rutene til det den opprinnelig var 
samt en statustekst som sier "Brettet er nullstillt" slik at bruker vet at 
den er nullstillt.

Kommentarer for RuteKnapp-klassen:
En klasse som arver JButton med ansvar for å lage knappen til ruteBrettet. 
Gjennom trykk av knappen så skal man få visualisert stien i brettet fra 
den knappen man trykket fra og bare hvis denne knappen er av hvit rute. 
Ellers vil man få beskjed om å trykke på ruter med tegn '.'(punktum) som er hvite ruter. 


