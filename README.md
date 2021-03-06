# parking-control-api
<div>
   <img align="center" alt="Diego-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
   <img align="center" alt="Diego-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
 <div/>

#### A aplicação tem como objetivo Associar vagas de estacionamento de um condomío ao carro cadastrado no sistema.
##### REGRAS DE NEGÓCIO
* Uma vaga pode ter um carro somente, e um apartamento śo pode ter uma vaga de estacionamento.
* Caso a vaga ja esteja sendo uasada o sistema impedirá o cadastro,
* o sistema também impedirá o cadastro na existência do apartamento e carro.
* para cadsatro da vaga é preciso informar o carro (ID).
* para ter uma vaga o usuário precisa ter um carro.
 
   ### TECNOLOGIAS USADAS:
  * [JAVA 17](https://www.azul.com/downloads/)  
  * [SPRING](https://start.spring.io/)
  * [MAVEN]( https://mvnrepository.com/)
  * [H2 DATABASE]( https://www.h2database.com/html/main.html)
  * [MYSQL ](  https://www.mysql.com/downloads/)
  * [POSTMAN PARA REQUISIÇÕES HTTP ](https://www.postman.com/downloads/)
   
### CLONE PROJECT
   ```
   git clone https://github.com/DiegoCardosoDev/parking-control-api.git
   
   ```
  
### ENDPOINT CREATE CAR
   * method POST: 
   ```
      https://localhost:8080/parking-spot-car
   ```
   
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
   https://localhost:8080/parking-spot/1
   ```
* DELETE method DELETAR POR ID :
   ```
   https://localhost:8080/parking-spot/1
   ```

### CRIAR BANCO
   ```
   CREATE DATABASE PARKINGSPOT_BD;
   USE PARKING_CAR_DB;
   ```
   
  ### SQL PARA POPULAR O BANCO (MYSQL)
   
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
   ### CONECT-ME!
    <div>
      <a href=https://www.linkedin.com/in/diego-cardoso-8023b31b3" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-              badge&logo=linkedin&logoColor=white" target="_blank"></a> 
       <a href = "mailto:diegocardososacramento@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white"          target="_blank"></a>
        <a href=https://api.whatsapp.com/send/?phone=5511952238924&text&app_absent=0" target="_blank"><img src="https://img.shields.io/badge/WhatsApp-25D366?            style=for-the-badge&logo=whatsapp&logoColor=white" target="_blank"></a>                                                                                                                        
  </div>

