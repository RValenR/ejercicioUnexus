# ejercicioUnexus
Ejercicio unexus


##Metodo para guardar clientes
http://localhost:8080/api/public/demo/saveClient
JSON ejemplo de entrada

{
  "tipoIdentificacion": null,
  "numeroIdentificacion": 123456789,
  "nombre": "Juan",
  "apellido": "Pérez",
  "correo": "juan@example.com",
  "numeroCelular": "123-456-7890",
  "provincia": "Ciudad de Buenos Aires",
  "ciudad": "Buenos Aires",
  "direccion": "123 Calle Principal",
  "tipoDireccion": "Casa"
}


Metodo para obtener una lista de cleintes de acuerdo a su numero de identificacion
http://localhost:8080/api/public/demo/findDireccionesByNumeroIdentificacion/123456789


Metodo para agregar direcciones a los cleintes
http://localhost:8080/api/public/demo/saveDirection
JSON EJEMPLO de entrada (Usa el mismo que el guardado pero solo se toma en cuenta la nueva direccion)

{
  "tipoIdentificacion": "DNI",
  "numeroIdentificacion": 123456789,
  "nombre": "Juan",
  "apellido": "Pérez",
  "correo": "juan@example.com",
  "numeroCelular": "123-456-7890",
  "provincia": "Pichincha",
  "ciudad": "Quito",
  "direccion": "123 Calle 2",
  "tipoDireccion": "SEC"
}


Metodo para actualizar un cliente ya existente
http://localhost:8080/api/public/demo/updateClient
JSON ejemplo

{
  "tipoIdentificacion": "CD",
  "numeroIdentificacion": 123456789,
  "nombre": "Juan333",
  "apellido": "Pérez",
  "correo": "juan@example.com",
  "numeroCelular": "123-456-7890",
  "provincia": "Ciudad de Buenos Aires",
  "ciudad": "Buenos Aires",
  "direccion": "123 Calle Principal",
  "tipoDireccion": "Casa"
}


Metodo para eliminar clientes mediante id
http://localhost:8080/api/public/demo/deleteClienteByNumeroIdentificacion/1


