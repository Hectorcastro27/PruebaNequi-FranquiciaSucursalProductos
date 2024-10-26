# PruebaNequi-FranquiciaSucursalProductos


# Instrucciones para Subir un Proyecto Spring Boot
# este documento ofrece un tutorial detallado 
# para subir un proyecto de Spring Boot que expone 
# un web service en el puerto 8080. ## Prerequisitos Antes de comenzar, 
# asegúrate de tener instalados los siguientes componentes: 1. **Java JDK**: Versión 8 o superior. 
# Puedes verificar la instalación con: ```bash java -versión

# mvn clean install

# mvn spring-boot:run

# BD H2
# http://localhost:8080/h2-console/login.do?jsessionid=91b31300471e8765c4cb45963de03780
# username=sa
# password=password123

# -POST: /api/franquicias para agregar una nueva franquicias.
# -POST: /api/franquicias/franquiciaId}/sucursales para agregar una sucursal a una franquicia.
# -POST: /api/productos/sucursales/{sucursalId} para agregar un producto a una sucursal.
# -DELETE: /api/productos/{sucursalId}/{productoId} para eliminar un producto a una sucursal
# -PUT: /api/productos/{productoId}/{stock}para modificar el stock de un producto.
# -GET: /api/productos//mayor-stock para obtener el producto con mas stock de una surcusal.

# -PUT: /api/franquicias/franquiciasId/nombre?nuevoNombre={nombreacambiar}
# -PUT: /api/sucursal/sucursalId/nombre?nuevNombre={nombreacambiar}
# -PUT: /api/productos/productosId/nombre?nuevoNombr={nombreacambiar}

# Github: https://github.com/Hectorcastro27/PruebaNequi-FranquiciaSucursalProductos/tree/main/src/main/java/com/PruebaNequi/PruebaNequi
