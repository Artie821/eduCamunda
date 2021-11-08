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

