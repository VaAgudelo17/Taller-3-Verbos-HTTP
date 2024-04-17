# VERBOS HTTP

Este README proporciona una descripción de los verbos HTTP más comunes utilizados en el desarrollo web.

## GET

El verbo GET se utiliza para solicitar datos de un recurso específico en un servidor. No debe tener efectos secundarios en el servidor y solo debe recuperar información.

Ejemplo de solicitud GET para mostrar todos los productos disponibles:

<img width="983" alt="Captura de Pantalla 2024-04-16 a la(s) 19 36 54" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/9d4eb9b3-775a-494d-8c93-3578c64eb981">

Otro ejemplo de solicitud GET para mostrar un producto por id:

<img width="931" alt="Captura de Pantalla 2024-04-16 a la(s) 19 37 25" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/8c22bd21-4b5a-4216-ba5e-7db962b2b96f">

## POST

El verbo POST se utiliza para enviar datos al servidor y crear un nuevo recurso. Puede tener efectos secundarios en el servidor, como la creación de un nuevo registro en una base de datos.

Ejemplo de solicitud POST para mostrar todos los productos disponibles:
<img width="937" alt="Captura de Pantalla 2024-04-16 a la(s) 19 52 15" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/7594b5a0-50a4-4a03-8e8a-94d5abea8c15">

Asi se mira en la base de datos, como vemos, ya esta el nuevo producto agregado:
<img width="1330" alt="Captura de Pantalla 2024-04-16 a la(s) 19 44 57" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/35453170-0c04-4cee-807f-c6ed4e494831">

##  PUT 

El método PUT se utiliza para enviar datos a un servidor para actualizar un recurso existente. Requiere que se incluya el estado completo del recurso en la solicitud.

Ejemplo de solicitud PUT para actualizar la información del producto, en este caso se actualizo el nombre, la descripción y el precio:
<img width="1104" alt="Captura de Pantalla 2024-04-16 a la(s) 19 56 50" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/47c6231c-a760-4132-8b35-8f9a9bc537ef">

Aqui vemos, como se actualizo el producto en la base de datos:
<img width="981" alt="Captura de Pantalla 2024-04-16 a la(s) 20 03 01" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/85b97b87-ff2a-4714-9058-68b705215f6c">

## PATCH
El método PATCH se utiliza para aplicar actualizaciones parciales a un recurso. A diferencia del PUT, el método PATCH no necesita contener el estado completo del recurso.

Ejemplo de solicitud PATCH para actualizar solamente el precio del producto:
<img width="1039" alt="Captura de Pantalla 2024-04-16 a la(s) 20 05 20" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/0dce3cde-0768-42b2-80ef-85474b01d969">

Precio actualizado en la base de datos:
<img width="962" alt="Captura de Pantalla 2024-04-16 a la(s) 20 10 54" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/8ef4c97a-99ff-4236-8a7e-4c67a62d62ac">

No se puede actualizar algo más a parte del precio:
<img width="985" alt="Captura de Pantalla 2024-04-16 a la(s) 20 09 38" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/82874f7c-a1b8-424f-a8b7-3bdeccd274b4">

## DELETE
El método DELETE se utiliza para eliminar un recurso especificado.

Ejemplo de solicitud DELETE para eliminar un producto por id:
<img width="1006" alt="Captura de Pantalla 2024-04-16 a la(s) 20 13 38" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/7580440f-dbd8-4d90-b4d6-bae1d9e4f450">

Aqui vemos como el producto ya no esta disponible en la base de datos:
<img width="1430" alt="Captura de Pantalla 2024-04-16 a la(s) 20 15 02" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/33a81866-84f1-4445-866f-1c816f19d366">

## HEAD
El método HEAD es similar al GET, pero se usa para obtener los encabezados de respuesta sin el cuerpo de respuesta. Es útil para verificar lo que un GET devolvería sin descargar todo el cuerpo.

Por ejemplo, vamos a buscar un producto que no este disponible:
<img width="1055" alt="Captura de Pantalla 2024-04-16 a la(s) 20 25 09" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/046bb821-8953-49e5-ac91-f6bf08d2e2c3">

Vamos a mirar, el mensaje correspondiente, el producto no se encuentra:
<img width="1328" alt="Captura de Pantalla 2024-04-16 a la(s) 20 26 02" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/c7b056d3-ebc8-49eb-87a2-866e0add9e24">

## OPTIONS
El método OPTIONS se utiliza para describir las opciones de comunicación para el recurso de destino. Permite al cliente conocer qué métodos HTTP están disponibles para un URL en particular.

En este caso, estas son las opciones de comunicación que estamos manejando (GET, POST, PUT, DELETE, PATCH):
<img width="1142" alt="Captura de Pantalla 2024-04-16 a la(s) 20 28 37" src="https://github.com/VaAgudelo17/Taller-3-Verbos-HTTP/assets/114451968/bbdf8e04-86ff-4eef-8e4e-c918a29079fb">








