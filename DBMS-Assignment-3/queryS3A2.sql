/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories*/
SELECT product.product_id , product.name , COUNT(product_category.product_id) AS count_categories
FROM product INNER JOIN product_category
ON product_category.product_id = product.product_id
GROUP BY product_category.product_id
HAVING count_categories > 1;

/*Display Count of products as per price range*/
SELECT pnew.rangeofprice , count(*) 
FROM (SELECT CASE
       WHEN price > 0 AND price < 100 THEN '0-100'
       WHEN price > 100 AND price < 500 THEN '100-500'
       ELSE 'Above 500' END AS rangeofprice
   FROM product) pnew
GROUP BY pnew.rangeofprice;

/*Display the Categories along with number of products under each category.*/
SELECT category.category_id , category.name , COUNT(product_category.category_id)
FROM category INNER JOIN product_category
ON category.category_id = product_category.category_id
GROUP BY product_category.category_id;