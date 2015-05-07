Market trade Processor

This is a spring boot application which exposes a secure RESTful service to accept data in the format

{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}

It stores this data in an in memory store. The UI component calls a simple Market Statistics calculator to display the number of transactions and a bar chart of the amount of currency sold against the 5 main currencies (EUR, GBP, AUS, USD, YEN, OTHER). If a currency is submitted that isnt one of the 5 currencies then the OTHER currency is updated.

The UI uses Chart.js and spring web sockets to display and communicate with the server.
