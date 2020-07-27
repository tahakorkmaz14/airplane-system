
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.airline.ticketing.ticketer.TicketerApplication` class from your IDE.

from your terminal in root directory simply run :
```shell
mvn clean install
java -jar flight-management-0.0.1-SNAPSHOT.jar
```

swagger url: 

you can check all endpoints from this address
```http://localhost:5555/swagger-ui.html#/ ```


## Operations :
###Airline Controller
--adding Airline Company
```shell
curl -X POST "http://localhost:5555/api/airline" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"companyName\": \"THY- TEST\", \"created\": \"2020-06-15T07:44:38.362Z\", \"updated\": \"2020-06-15T07:44:38.362Z\"}"
{
  "companyName": "THY- TEST",
  "created": "2020-06-15T07:44:38.362Z",
  "updated": "2020-06-15T07:44:38.362Z"
}
```
--Update Airline Company

```shell
curl -X PUT "http://localhost:5555/api/airline/2" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"companyName\": \"Anadolu Jet -TEST\", \"created\": \"2020-06-15T07:46:19.713Z\", \"updated\": \"2020-06-15T07:46:19.713Z\"}"
{
  "companyName": "Anadolu Jet -TEST",
  "created": "2020-06-15T07:46:19.713Z",
  "updated": "2020-06-15T07:46:19.713Z"
}
```

--Delete Airline Company

```shell
curl -X DELETE "http://localhost:5555/api/airline/2" -H "accept: */*"
```

--Get All Airline Company
```shell
curl -X GET "http://localhost:5555/api/airline/get-all" -H "accept: */*"
```
--Get Airline Company ById
```shell
curl -X GET "http://localhost:5555/api/airline/id/1" -H "accept: */*"
```

## Airport Controller

--Adding Airport

```shell
curl -X POST "http://localhost:5555/api/airport" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"airportName\": \"Sabiha Gökçen\", \"city\": \"İstanbul\", \"country\": \"Türkiye\", \"created\": \"2020-06-15T07:50:35.503Z\", \"updated\": \"2020-06-15T07:50:35.503Z\"}"
{
  "airportName": "Sabiha Gökçen",
  "city": "İstanbul",
  "country": "Türkiye",
  "created": "2020-06-15T07:50:35.503Z",
  "updated": "2020-06-15T07:50:35.503Z"
}
```

--Update Airport

```shell
curl -X PUT "http://localhost:5555/api/airport/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"airportName\": \"Çarşamba Havaalanı\", \"city\": \"Samsun\", \"country\": \"Türkiye\", \"created\": \"2020-06-15T07:52:25.965Z\", \"updated\": \"2020-06-15T07:52:25.965Z\"}"
{
  "airportName": "Çarşamba Havaalanı",
  "city": "Samsun",
  "country": "Türkiye",
  "created": "2020-06-15T07:52:25.965Z",
  "updated": "2020-06-15T07:52:25.965Z"
}
```
--Delete Airport
```shell
curl -X DELETE "http://localhost:5555/api/airport/3" -H "accept: */*"
```

--Get all Airport
```shell
curl -X GET "http://localhost:5555/api/airport/get-all" -H "accept: */*"
```

--Get Airport ById
```shell
curl -X GET "http://localhost:5555/api/airport/id/2" -H "accept: */*"
```

## Flight Controller

--Adding Flight
```shell
curl -X POST "http://localhost:5555/api/flight" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"airlineId\": 1, \"created\": \"2020-06-15T08:01:41.209Z\", \"date\": \"2020-06-15T08:01:41.209Z\", \"routesId\": 1, \"seats\": 100, \"ticketPrice\": 120, \"updated\": \"2020-06-15T08:01:41.209Z\"}"
{
  "airlineId": 1,
  "created": "2020-06-15T08:01:41.209Z",
  "date": "2020-06-15T08:01:41.209Z",
  "routesId": 1,
  "seats": 100,
  "ticketPrice": 120,
  "updated": "2020-06-15T08:01:41.209Z"
}
```

--Update Flight
```shell
curl -X PUT "http://localhost:5555/api/flight/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"airlineId\": 1, \"created\": \"2020-06-15T08:02:58.711Z\", \"date\": \"2020-06-15T08:02:58.712Z\", \"routesId\": 1, \"seats\": 100, \"ticketPrice\": 100, \"updated\": \"2020-06-15T08:02:58.712Z\"}"
{
  "airlineId": 1,
  "created": "2020-06-15T08:02:58.711Z",
  "date": "2020-06-15T08:02:58.712Z",
  "routesId": 1,
  "seats": 100,
  "ticketPrice": 100,
  "updated": "2020-06-15T08:02:58.712Z"
}
```

--Delete Flight
```shell
curl -X DELETE "http://localhost:5555/api/flight/3" -H "accept: */*"
```

-GelAll Flight

```shell
curl -X GET "http://localhost:5555/api/flight/get-all" -H "accept: */*"
```

-Get Flight ById
```shell
curl -X GET "http://localhost:5555/api/flight/id/1" -H "accept: */*"
```

##Routes Controller

--Add Route
```shell
curl -X POST "http://localhost:5555/api/routes" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"arrTime\": \"2020-06-15T08:07:37.151Z\", \"created\": \"2020-06-15T08:07:37.151Z\", \"depTime\": \"2020-06-15T08:07:37.151Z\", \"deptAirportId\": 1, \"destAirportId\": 2, \"updated\": \"2020-06-15T08:07:37.151Z\"}"
{
  "arrTime": "2020-06-15T08:07:37.151Z",
  "created": "2020-06-15T08:07:37.151Z",
  "depTime": "2020-06-15T08:07:37.151Z",
  "deptAirportId": 1,
  "destAirportId": 2,
  "updated": "2020-06-15T08:07:37.151Z"
}
 ```

--Update Route
```shell
curl -X PUT "http://localhost:5555/api/routes/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"arrTime\": \"2020-06-15T08:12:53.782Z\", \"created\": \"2020-06-15T08:12:53.782Z\", \"depTime\": \"2020-06-15T08:12:53.782Z\", \"deptAirportId\": 1, \"destAirportId\": 2, \"updated\": \"2020-06-15T08:12:53.782Z\"}"
{
  "arrTime": "2020-06-15T08:12:53.782Z",
  "created": "2020-06-15T08:12:53.782Z",
  "depTime": "2020-06-15T08:12:53.782Z",
  "deptAirportId": 1,
  "destAirportId": 2,
  "updated": "2020-06-15T08:12:53.782Z"
}
 ```

--Delete Route

```shell
curl -X DELETE "http://localhost:5555/api/routes/2" -H "accept: */*"
 ```

--Get All Route
```shell
curl -X GET "http://localhost:5555/api/routes/get-all" -H "accept: */*"
 ```

--Get ById
```shell
curl -X GET "http://localhost:5555/api/routes/id/1" -H "accept: */*"
 ```

##Ticket Controller

--Buying Ticket


When purchasing tickets, the ticket price field is not included. The price of the ticket is calculated based on the base price of the selected flight. If the number of tickets for that flight covers 10% or more of the quota of the flight, the ticket price will be 10% more than the base price.



Fields other than the first 4 digits and the last 4 digits of the entered card number will be masked using *. 
Card number must be 16 digits. Foreign characters entered in the card number will be replaced.

```shell
curl -X POST "http://localhost:5555/api/ticket" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"cardNumber\": \"4321987312348765\", \"created\": \"2020-06-15T08:17:27.500Z\", \"flightId\": 1, \"number\": \"123129482\", \"updated\": \"2020-06-15T08:17:27.500Z\"}"
{
  "cardNumber": "4321987312348765",
  "created": "2020-06-15T08:17:27.500Z",
  "flightId": 1,
  "number": "123129482",
  "updated": "2020-06-15T08:17:27.500Z"
}
```

The same scenario in ticket purchase applies here.

--Update Ticket

```shell
curl -X PUT "http://localhost:5555/api/ticket/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"cardNumber\": \"1111111111111,1,1,1\", \"created\": \"2020-06-15T08:23:49.120Z\", \"flightId\": 1, \"number\": \"124124124\", \"updated\": \"2020-06-15T08:23:49.120Z\"}"
{
  "cardNumber": "1111111111111,1,1,1",
  "created": "2020-06-15T08:23:49.120Z",
  "flightId": 1,
  "number": "124124124",
  "updated": "2020-06-15T08:23:49.120Z"
}

```

--Delete Ticket

```shell
curl -X DELETE "http://localhost:5555/api/ticket/2" -H "accept: */*"
```

--Get All
```shell
curl -X GET "http://localhost:5555/api/ticket/get-all" -H "accept: */*"
```

--Get By Id
```shell
curl -X GET "http://localhost:5555/api/ticket/id/1" -H "accept: *
```

--Get By Ticket Number

The ticket number is uniq, so you can use the ticket numbers that I created in the initialize service. These ticket numbers are generated randomly for testing purposes.

```shell
 curl -X GET "http://localhost:5555/api/ticket/ticket-number/2964" -H "accept: */*"
```
--- 

--Delete By Ticket Number

```shell
curl -X DELETE "http://localhost:5555/api/ticket/ticket-number/2964" -H "accept: */*"
```
--- 
*The number of tickets after the ticket sale will increase by 10% for every 10% of the flight quota.

*By removing spaces from the card number entered and input card number removes non numeric characters and hides 6 digits

*Swagger support added



