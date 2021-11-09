# CAMUNDA EDU

![alt text](https://github.com/Artie821/ONL_JEE_S_03_Projekt_koncowy/blob/master/src/main/webapp/images/screencapture-bookexchangeapp-herokuapp-2021-06-29-12_59_22.jpg)

Aby wywołać normalny przebieg aplikacji należy podać dowolne userName w pierwszym userTasku i surnameForm w userTasku nr 2 o długości conajmniej 3 liter.

Aby wywołać nadpisanie wartości userSurname należy podać dowolne userName w pierwszym userTasku i surnameForm w userTasku nr 2 o długości mniejszej niż 3 litery - wartość userSurname zostanie automatycznie napisana wartością "LongUserSurname".

Aby wywołać ERROR należy podać dowolne userName w pierwszym userTasku i userSurname w userTasku nr 2 o wartości "er"
{"variables":
    {"surnameForm": {"value": "er"}}
}

Dla user Task 1 zaimplementowano timer wypisujący log co określoną w logice biznesowej wartośc czasu, 
jeśli instancja rozpoczęła się o niepoarzystej minucie - logger odpali się co 5 minut,
w przeciwnym razie odpali się co 2 minuty.

Dla user Task 2 zaimplementowano boundary event oczekujący na wiadomość o nazwie: DataChange
"messageName" : "DataChanged" 

# REST endpoints:

# 1. Tworzenie nowej instacji z kluczem biznesowym:

POST
http://localhost:8080/engine-rest/process-definition/key/eduDiagram/start
Content-Type: application/json

Body:
{
    "businessKey":"nazwa_klucza"
}

# 2. Wypełnienie user taska:
POST
http://localhost:8080/engine-rest/task/{ID_TASKA}/complete
Content-Type: application/json

dla user Task1:

Body:
{"variables":
    {"userName": {"value": "wartosc_zmiennej_userName"}}
}

dla userTask2:
{"variables":
{"surnameForm": {"value": "wartosc_zmiennej_surnameForm"}}
}

# 3. Wysłanie wiadomości dla userTask2:
POST
http://localhost:8080/rest-engine/message
Content-Type: application/json

Body:

{
  "messageName" : "DataChanged",
  "businessKey" : "{buisness_key}",
  "processVariables" : {
    "name" : {"value" : "IMIE", "type": "String"}
                  }
  }