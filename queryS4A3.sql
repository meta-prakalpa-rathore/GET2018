ALTER TABLE orders ADD INDEX orderTableIndex(order_id);

ALTER TABLE product ADD INDEX productTableIndex(product_id);

ALTER TABLE category ADD INDEX categoryTableIndex(category_id);
