/*Ejercicio 2
Obtener los ingredientes de los proveedores que fueron recomendados 
 */
 SELECT name FROM restaurant.ingredients 
 INNER JOIN restaurant.vendors ON ingredients.vendorid = vendors.vendorid 
 WHERE vendors.referredby IS NOT NULL