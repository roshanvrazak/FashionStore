
INSERT INTO `fashionstore`.`categories`
(`category_id`,
`name`)
VALUES
(1, 'Shirts'),
(2, 'Pants'),
(3, 'Accessories');



INSERT INTO `fashionstore`.`customers`
(`customer_id`,
`address`,
`email`,
`first_name`,
`last_name`,
`password_hash`,
`phone_number`,
`registration_date`,
`username`)
VALUES
(1, '123 Main St', 'john@example.com', 'John', 'Doe', 'hashed_password', '123-456-7890', '2024-01-11', 'john_doe'),
(2, '456 Elm St', 'jane@example.com', 'Jane', 'Smith', 'hashed_password', '987-654-3210', '2024-01-11', 'jane_smith');

INSERT INTO `fashionstore`.`products`
(`product_id`,
`color`,
`description`,
`image_url`,
`name`,
`price`,
`size`,
`stock_quantity`,
`category_id`)
VALUES
(1, 'Blue', 'A comfortable cotton T-shirt', 'image_url1.jpg', 'Cotton T-Shirt', 19.99, 'M', 100, 1),
(2, 'Black', 'Slim fit jeans for men', 'image_url2.jpg', 'Slim Fit Jeans', 29.99, '32x32', 50, 2),
(3, NULL, 'Elegant silver necklace', 'image_url3.jpg', 'Silver Necklace', 9.99, NULL, 30, 3);


INSERT INTO `fashionstore`.`orders`
(`order_id`,
`order_date`,
`order_status`,
`total_amount`,
`customer_id`)
VALUES
(1, '2024-01-11', 'Pending', 49.97, 1),
(2, '2024-01-12', 'Completed', 29.99, 2);


INSERT INTO `fashionstore`.`order_items`
(`order_item_id`,
`quantity`,
`subtotal`,
`order_id`,
`product_id`)
VALUES
(1, 2, 39.98, 1, 1),
(2, 1, 29.99, 1, 2),
(3, 1, 9.99, 2, 3);


