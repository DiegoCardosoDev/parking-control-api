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

   
  ### BONUS SQL PARA POPULAR O BANCO (MYSQL)
   
   ```
     --CARS INSERTS

     INSERT INTO tb_carmodel (BRAND_CAR,  COLOR_CAR,  LICENSE_PLATE_CAR ,  MODEL_CAR) VALUES('VOLKSWAGEN', 'PRETO', 'R2055', 'GOL_2022');
     INSERT INTO tb_carmodel (BRAND_CAR,  COLOR_CAR,  LICENSE_PLATE_CAR ,  MODEL_CAR) VALUES('BMW', 'BRANCO', 'W2055', 'X3');
     INSERT INTO tb_carmodel (BRAND_CAR,  COLOR_CAR,  LICENSE_PLATE_CAR ,  MODEL_CAR) VALUES('HYUNDAY', 'VERMELHO', 'HB5511', 'HB20_2022');
     INSERT INTO tb_carmodel (BRAND_CAR,  COLOR_CAR,  LICENSE_PLATE_CAR ,  MODEL_CAR) VALUES('TOYOTA', 'PRETO', 'TOY2001', 'YARIS_2022');
     INSERT INTO tb_carmodel (BRAND_CAR,  COLOR_CAR,  LICENSE_PLATE_CAR ,  MODEL_CAR) VALUES('JEEP', 'PRETO', 'W2022J', 'WRANGLER');
   
     --PARKINGSPOT INSERTS

     INSERT INTO tb_parkingspot(APARTMENT, BLOCK, PARKING_SPOT_NUMBER, REGISTRATION_DATE,  RESPONSIBLE_NAME ,  CAR_MODEL_ID )
     VALUES('20', '5', '301', '2020-02-01 00:00:00', 'VEGETA', 1);

     INSERT INTO tb_parkingspot(APARTMENT, BLOCK, PARKING_SPOT_NUMBER, REGISTRATION_DATE,  RESPONSIBLE_NAME ,  CAR_MODEL_ID )
     VALUES('22', '18', 'A205', '2022-02-01 13:00:05', 'GOKU SAYADIN', 2);

     INSERT INTO tb_parkingspot(APARTMENT, BLOCK, PARKING_SPOT_NUMBER, REGISTRATION_DATE,  RESPONSIBLE_NAME ,  CAR_MODEL_ID )
     VALUES('101', '30', 'B204', '2022-01-01 22:30:10', 'GOHAN SAYADIN', 3);

     INSERT INTO tb_parkingspot(APARTMENT, BLOCK, PARKING_SPOT_NUMBER, REGISTRATION_DATE,  RESPONSIBLE_NAME ,  CAR_MODEL_ID )
     VALUES('25', '12', 'A501', '2022-01-01 08:30:19', 'KURIRIM ', 4);

     INSERT INTO tb_parkingspot(APARTMENT, BLOCK, PARKING_SPOT_NUMBER, REGISTRATION_DATE,  RESPONSIBLE_NAME ,  CAR_MODEL_ID )
     VALUES('315', '10', 'C401', '2022-02-02 09:37:39', 'MAJINBU', 5);
   ```
