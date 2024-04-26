# Тестирование веб-сервиса

В рамках проекта требовалось провести автоматизацию тестирования сервиса, взаимодействующего с СУБД и API Банка. Данный веб-сервис предлагает купить тур несколькими способами:

1. Оплата по дебетовой карте
2. Выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей - Payment Gate
* кредитному сервису - Credit Gate

В приложении используются два отдельных сервиса оплаты: 
1. OrdinaryPay
2. CreditPay

Также оно поддерживает две СУБД:
1. MySQL;
2. PostgreSQL.

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

_Подробное описание задания → https://github.com/netology-code/qa-diploma/blob/master/README.md_

## Начало работы

1. Сделать клонирование [проекта](https://github.com/AlexVinograder/Diplom) на ПК:
```
 git clone git@github.com:AlexVinograder/Diplom.git
```

### Prerequisites

Для работы с проектом, на ПК должны быть установлены:

```
1. IntelliJ IDEA
2. Git
3. Docker Desktop
```

### Установка и запуск


1. Установить и запустить IntelliJ IDEA


2. Установить и запустить Docker Desktop


3. Открыть проект в IntelliJ IDEA


4. Запустить контейнеры MySQL, PostgreSQL и NodeJS - `docker compose up`


5. В новой вкладке терминала для запуска сервиса с указанием пути к базе данных ввести:


   **для MySQL**

    java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

   **для PostgreSQL**

    java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

6. Sut открывается по адресу → http://localhost:8080/


7. В новой вкладке терминала для запуска тестов с параметрами, с указанием пути к базе данных ввести:


   **для MySQL**


    ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"

   **для PostgreSQL**


    ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"

8.  В новой вкладке терминала сформировать отчет в Allure, после выполнения тестов ввести:

        ./gradlew allureServe


9. Остановить контейнеры - `docker compose down`


## Лицензия

GPL

## Тестовая документация

1. [План автоматизации](https://github.com/AlexVinograder/Diplom/blob/main/docs/Plan.md)
2. [Итоги тестирования](https://github.com/AlexVinograder/Diplom/blob/main/docs/Report.md)
3. [Итоги автоматизации](https://github.com/AlexVinograder/Diplom/blob/main/docs/Summary.md)