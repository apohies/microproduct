[prueba minas.postman_collection.json](https://github.com/user-attachments/files/18754312/prueba.minas.postman_collection.json)la prueba esta los 3 repositorios
# video
[video de youtube](https://www.youtube.com/watch?v=HmhTPLw7Pus)

# producto micro
[producto](https://github.com/apohies/microproduct)
puerto 8081
# inventario micro
[inventario](https://github.com/apohies/micro-inventory)
puerto 8080

# front angular
[front-angular](https://github.com/apohies/inventory-frontend)
bajar dependencia npm .
npm install
- ng serve

[Uploading{
	"info": {
		"_postman_id": "f932d5de-c9f8-4fdd-92e1-70469b3639ce",
		"name": "prueba minas",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "7531251",
		"_collection_link": "https://wise99-6067.postman.co/workspace/minas~0ac14d66-212d-45e1-bf13-547b8b6a36a2/collection/7531251-f932d5de-c9f8-4fdd-92e1-70469b3639ce?action=share&source=collection_link&creator=7531251"
	},
	"item": [
		{
			"name": "Crear producto",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"name\": \"Laptop hp\",\n    \"description\": \"hp general\",\n    \"price\": 1299.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8081/api/products",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"products"
					]
				}
			},
			"response": []
		},
		{
			"name": "Listar Producto",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/api/products",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"products"
					]
				}
			},
			"response": []
		},
		{
			"name": "Actualizar Inventario",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"productId\": \"67ab6beac079f453d72c6344\",\n    \"quantity\": 91\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/inventory/update-quantity",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"inventory",
						"update-quantity"
					]
				}
			},
			"response": []
		},
		{
			"name": "listar inventory",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/inventory",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"inventory"
					]
				}
			},
			"response": []
		},
		{
			"name": "Crear Iventario",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"productId\": \"67ab6beac079f453d72c6344\",\n    \"quantity\": 90\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/inventory",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"inventory"
					]
				}
			},
			"response": []
		},
		{
			"name": "deleteProduct",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8081/api/products/67ab6beac079f453d72c6344",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"products",
						"67ab6beac079f453d72c6344"
					]
				}
			},
			"response": []
		},
		{
			"name": "New Request",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/inventory/56",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"inventory",
						"56"
					]
				}
			},
			"response": []
		}
	]
} prueba minas.postman_collection.json…]()


# docker bases de datos 

docker run -d \
--name mongodb \
-p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=admin \
-e MONGO_INITDB_ROOT_PASSWORD=password123 \
mongo

docker run -d \
--name postgres-inventory \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=password123 \
-e POSTGRES_DB=inventorydb \
-p 5432:5432 \
postgres:latest
