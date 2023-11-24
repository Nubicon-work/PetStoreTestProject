# PetStoreTestProject.

Это тестовый проект, предназначенный для автоматизации API-тестов для сайта [PetStore](https://petstore.swagger.io/#/).

## Описание проекта.

Как и тестируемые API-методы, тесты в этом проекте разбиты на тестовые группы **pet**, **user** и **store**. 
Те же сьюты запускаются в проекте при прогоне тестов (сами сьюты описаны в файлах [pet_testng.xml](src%2Ftest%2Fjava%2Fapi%2Fpet_testng.xml), [user_testng.xml](src%2Ftest%2Fjava%2Fapi%2Fuser_testng.xml), [store_testng.xml](src%2Ftest%2Fjava%2Fapi%2Fstore_testng.xml) соответственно). 
Запуск всех тестов, равно как и запуск всех сьютов, осуществляется при запуске файла [testng.xml](src%2Ftest%2Fjava%2Fapi%2Ftestng.xml).

В проекте взаимодействие с тестируемым API осуществлялось с помощью фреймворка **RestAssured**. 
Для запуска тестов использовался фреймворк **TestNG**. 
Для формирования отчетов прогонов использовался фреймворк **Allure**. 
Для сборки проекта использовался инструмент **Gradle**. 
В проекте присутствует файлы [Dockerfile](Dockerfile) и [docker-compose.yml](docker-compose.yml) для запуска тестов в **Docker**.
