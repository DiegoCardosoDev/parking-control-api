# parking-control-api
<div>
   <img align="center" alt="Diego-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
  <img align="center" alt="Diego-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
 <div/>



### ENDPOINTS

* ->CREATE CARS 

* method POST: https://localhost:8080/parking-spot-car/create
* JSON FORMAT:

{
    "licensePlateCar": "w2022",
    "brandCar": "BMW",
    "modelCar": "AUDI Q7",
    "colorCar": "preto"
}

* ->CREATE PARKINGSPOT

#### * OBS: PASSAR O ID DO CARRO CRIADO ANTERIORMENTE


* method POST: https://localhost:8080/parking-spot/create

*JSON FORMAT:

   * {
    "parkingSpotNumber": "339",
    "responsibleName": "vegeta",
    "apartment": "223",
    "block": "18",
    "carModel": {
        "id": 1
    }
} 

* method LISTAR TODOS GET: https://localhost:8080/parking-spot/list-all
* method procurar por ID GET: https://localhost:8080/parking-spot/list-all/1 
