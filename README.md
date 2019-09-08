# USDRateDownloader

Program wykonywany z konsoli.

1. W przypadku nie podania parametrów podczas wykonywania program zwraca ceny sprzedaży i skupu dolara
z ostatniego dnia pracy NBP.

Przykładowe wykonanie: 

java -jar USDRateDownloader-1.0.0.jar

2. W przypadku podania jednego parametru program zwraca ceny sprzedaży i skupu dolara
z podanego dnia pracy NBP.

Przykładowe wykonanie: 

java -jar USDRateDownloader-1.0.0.jar 2019-09-05

3. W przypadku podania dwóch parametrów program przedstawia notowania kursu kupna i sprzedaży USD od 
podanej daty do bieżącej daty wraz z różnicą wartości (kupna i sprzedaży) pomiędzy dniami.

Przykładowe wykonanie: 

java -jar USDRateDownloader-1.0.0.jar 2019-08-05 2019-09-05

4. W przypadku podania danych w nieprawidłowym formacie program zwróci wyniki jak dla punktu pierwszego.
