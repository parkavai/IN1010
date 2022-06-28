 /*

Casting

Anta at vi har:

class Student extends Person{...}
Student stud = new Student();

I dette tilfellet er Person en superklasse og Student er en subklasse

Ved tilordningen 

Person pers;
pers = stud;

Det som skjer her er at, vi har en implisitt konvertering fra student-referanse til person-referanse.
Merk vi kan ikke benytte oss av metodene til student for pers-objektet, da pers objektet er en superklasse 
og har kun tilgang til sin type. Hva jeg mener med den forrige linjen er at person-objektet har en referanse 
student, så vi kan få tilgang til student-metodene gjennom person-objektet. 


Hvis vi nå ønsker å få tak i de spesielle egenskapene til student, må vi foreta en eksplisitt konvertering 
tilbake til Student igjen. 

Student stud2 = (Student) pers;

Her foregår det en sjekk som er identisk til instanceof hvor vi ser om Person objektet "pers" referer til et
student-objekt. Gjør den det, vil det bli lagt et nytt student objekt "stud2". Og denne metoden er kjent som casting.

Casting er det som skjer når vi endrer typer blant variabler, f.eks fra int til double eller string til int osv. 
Casting er meget nyttig for objekter da i dette tilfelle, kunne vi foreta en liten if-sjekk for å sjekke om person
objektet hadde en referanse til student. Skulle ikke dette være tilfellet, ville vi fått en "classcastexception" som 
forteller oss at vi caster et objekt eller en variabel som ikke er av riktig type, i dette tilfellet så hadde ikke 
person en (student)


*/