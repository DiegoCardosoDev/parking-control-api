# parking-control-api
<div>
   <img align="center" alt="Diego-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
  <img align="center" alt="Diego-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
 <div/>
   
   ### TECNOLOGIAS USADAS:
   * JAVA 17
   * SPRING
   * MAVEN
   * H2 DATABASE
   * MYSQL 
   
   ### CLONE PROJECT
   ```
   git clone https://github.com/DiegoCardosoDev/parking-control-api.git
   
   ```
   
   ### CRIAR BANCO
   ```
   CREATE DATABASE PARKINGSPOT_BD;
   ```
  
### ENDPOINT CREATE CAR
   * method POST: https://localhost:8080/parking-spot-car/create
   
   * JSON FORMAT:
  
```
{
    "licensePlateCar": "COUP33",
    "brandCar": "BMW",
    "modelCar": "GRAN COUPÉ_2022",
    "colorCar": "CINZA"
}
```
### ENDPOINT CREATE PARKINGSPOT
   * method POST: https://localhost:8080/parking-spot/create
   
   * JSON FORMAT:

```
{
    "parkingSpotNumber": "880",
    "responsibleName": "TRUNKS",
    "apartment": "544",
    "block": "19",
    "carModel": {
        "id": 1
    }
}
```
* GET- method LISTAR TODOS :
   ```
    https://localhost:8080/parking-spot/list-all
   ```
* GET- method ATUALIZAR : 
   ```
   https://localhost:8080/parking-spot/update/1
   ```
* GET method procurar por ID:
   ```
   https://localhost:8080/parking-spot/search/1
   ```
* DELETE method DELETAR POR ID :
   ```
   https://localhost:8080/parking-spot/delete/1
   ```
