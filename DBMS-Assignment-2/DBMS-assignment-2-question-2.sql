#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT product.product_id, product.name, category.name, price 
FROM product, category, product_category 
WHERE product_category.product_id = product.product_id AND product_category.category_id = category.category_id AND available_stock > 0
ORDER BY product.product_id DESC;

#Display the list of products which don't have any images.
SELECT product.name 
FROM product
WHERE product_id NOT IN (SELECT product_id FROM image);

#Display all Id, Title and Parent Category Title for all the Categories listed,
#sorted by Parent Category Title and then Category Title.
#(If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT child.category_id, child.name, IFNULL(parent.name, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category_id = parent.category_id
ORDER BY parent.name, child.name;

#Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT child.category_id, child.name, IFNULL(parent.name, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category_id = parent.category_id
WHERE child.category_id NOT IN (SELECT parent_category_id FROM category WHERE parent_category_id IS NOT NULL);

#Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT category.name,product.name, product.price, product.description
FROM product, category, product_category
WHERE product_category.product_id = product.product_id AND product_category.category_id = category.category_id AND category.name = "Mobile";

#Display the list of Products whose Quantity on hand (Inventory) is under 50
SELECT name
FROM product
WHERE available_stock < 50;

#Increase the Inventory of all the products by 100.
SET SQL_SAFE_UPDATES = 0;
UPDATE product
SET available_stock = available_stock + 100;
