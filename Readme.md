StatisticalAnalysis

REST сервис обрабатывающий CSV файл содержащий записи по данным стримингового сервиса Spotify за 2000-2019 
годы. Сервис принимает запрос клиента по HTTP API, разбирает csv файл и отдает результат в виде JSON.
В результате будет рассчитана статистика полей по децилям.

Пример запроса сервису:

http://localhost:8080/?colname=duration_ms&year=2014

Сервису обязательно нужно указать один из следующих параметров "colname":

* duration_ms
* year
* popularity
* danceability
* energy
* key

Параметр "year" указывать не обязательно, но можно указать с 2000 по 2019. 

CSV файл содержится в папке resources/songs_normalize.csv

Запустить приложение можно через класс StatisticalAnalysisApplication

Можно собрать Docker контейнер, находясь в папке проекта и набрав в терминале:

* sudo docker build . --tag statistical

и затем:

* sudo docker run -p 8080:8080 statistical
