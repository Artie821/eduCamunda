Aby wywołać normalny przebieg aplikacji należy podać dowolne userName w pierwszym userTasku i surnameForm w userTasku nr 2 o długości conajmniej 3 liter.

Aby wywołać nadpisanie wartości userSurname należy podać dowolne userName w pierwszym userTasku i surnameForm w userTasku nr 2 o długości mniejszej niż 3 litery - wartość userSurname zostanie automatycznie napisana wartością "LongUserSurname".

Aby wywołać ERROR należy podać dowolne userName w pierwszym userTasku i userSurname w userTasku nr 2 o wartości "er"
{"variables":
    {"surnameForm": {"value": "er"}}
}


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

Body:
{"variables":
    {"userName": {"value": "wartosc_zmiennej_userName"}}
}

# 3. Wysłanie wiadomości:
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
