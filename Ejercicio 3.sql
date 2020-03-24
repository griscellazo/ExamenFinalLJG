/*Ejercicio 3
Mostrar las tiendas que tienen ordenes por encima del promedio del precio.
 */
SELECT AVG(price) AS Promedio FROM restaurant.orders;
SELECT storeid 
FROM restaurant.orders
 WHERE price > (SELECT AVG(price) AS Promedio FROM restaurant.orders)