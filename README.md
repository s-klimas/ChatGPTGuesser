# ChatGPTGuesser
Program wykorzystujący ChatGPT API. Gra wysyła pierwsze prompt do API chatu brzmiący
```java
String fp = "Rozpocznij grę w zgadywanie. Wymyśl słowo, a ja spróbuje odgadnąć, co to jest, zadając Ci pytania. Odpowiadaj 'tak' lub 'nie'.";
```
Potem cała gra polega na prowadzeniu spójnej konwersacji z Chatem i odgadnięcie wylosowanego przez niego słowa.
Nie jest jednak to idealne, ponieważ zdążą się przypadki w których Chat zwraca nam w odpowiedzi wylosowane słowo i każe je zgadywać, lub sam zaczyna zgadywanie.

Projekt korzysta z mojego API_KEY i dlatego gdy klucz zostanie wykorzystany do końca program przestanie działać i trzeba będzie wpisać własny klucz.
