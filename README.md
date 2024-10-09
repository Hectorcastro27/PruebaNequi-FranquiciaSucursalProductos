# PruebaNequi-FranquiciaSucursalProductos
# PruebaNequi-FranquiciaSucursalProductos

# Instrucciones para Subir un Proyecto Spring Boot
# este documento ofrece un tutorial detallado 
# para subir un proyecto de Spring Boot que expone 
# un web service en el puerto 8080. ## Prerequisitos Antes de comenzar, 
# asegúrate de tener instalados los siguientes componentes: 1. **Java JDK**: Versión 8 o superior. 
# Puedes verificar la instalación con: ```bash java -versión

# mvn clean install

# mvn spring-boot:run

# -POST: /api/franquicias para agregar una nueva franquicias.
# -POST: /api/sucursales/{franquiciasID} para agregar una sucursal a una franquicia.
# -POST: /api/productos/{sucursalID} para agregar un producto a una sucursal.
# -DELETE: /api/productos/{sucursalID} para eliminar un producto a una sucursal
# -PUT: /api/productos/{productoID}/stock?stock ={nuevoStock} para modificar el stock de un        producto.
# -GET: /api/productos/mayor-stock/{sucursalID} para obtener el producto con mas stock de una surcusal.
