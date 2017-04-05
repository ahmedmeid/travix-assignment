# BusyFlights
Flights search solution which aggregates flight search results from different suppliers

##  Technologies

Java 8
Maven 3
Spring Boot 1.5
Wiremock 2.5

##Notes:
CrazyAir and ToughJet web services have been mocked using Wiremock.
Solution allows adding more suppliers easily by creating the request, response, and mapper classes then to configure them in the class: App.java with the supplier's web service URL.


