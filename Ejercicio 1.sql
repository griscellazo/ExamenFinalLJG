/*Ejercicio 1
Contar el numero de ingredientes de tipo Vegetable.
 */
SELECT COUNT(foodgroup) AS Vegetables 
FROM restaurant.ingredients 
WHERE foodgroup = 'Vegetable'