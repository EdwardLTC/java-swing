-- =====================================
-- Shoe Shop Seed Data
-- =====================================

-- Brands
INSERT INTO brands (name, description) VALUES
                                           ('Nike', 'Performance and lifestyle footwear'),
                                           ('Adidas', 'Shoes and sportswear'),
                                           ('Puma', 'Sport-inspired shoes'),
                                           ('Converse', 'Casual sneakers and classics');

-- Categories
INSERT INTO categories (name, parent_id) VALUES
                                             ('Shoes', NULL),
                                             ('Running', 1),
                                             ('Casual', 1),
                                             ('Basketball', 1);

-- Colors
INSERT INTO colors (name, hex_code) VALUES
                                        ('Black', '#000000'),
                                        ('White', '#FFFFFF'),
                                        ('Red', '#FF0000'),
                                        ('Blue', '#0000FF');

-- Sizes (common for shoe shop)
INSERT INTO sizes (us_size, eu_size, gender) VALUES
                                                 (7.0, 40.0, 'M'),
                                                 (8.5, 42.0, 'M'),
                                                 (6.0, 38.0, 'F'),
                                                 (9.0, 43.0, 'U');

-- Products (Shoes only)
INSERT INTO products (name, description, price, brand_id, category_id) VALUES
                                                                           ('Nike Air Zoom Pegasus', 'Nike running shoes for daily training', 130.0, 1, 2),
                                                                           ('Adidas Ultraboost 22', 'Responsive running sneakers with boost', 180.0, 2, 2),
                                                                           ('Puma Suede Classic', 'Casual lifestyle sneakers', 85.0, 3, 3),
                                                                           ('Converse Chuck Taylor', 'Classic canvas high-top sneakers', 65.0, 4, 3),
                                                                           ('Nike LeBron 20', 'Basketball shoes for performance', 200.0, 1, 4);

-- Variants (per product with colors & sizes)
INSERT INTO variants (product_id, color_id, size_id, quantity, sku) VALUES
                                                                        -- Nike Pegasus
                                                                        (1, 1, 1, 10, 'NIKE-PEG-BLACK-7'),
                                                                        (1, 2, 2, 8,  'NIKE-PEG-WHITE-8.5'),
                                                                        -- Adidas Ultraboost
                                                                        (2, 2, 2, 5,  'ADIDAS-UB-WHITE-8.5'),
                                                                        (2, 4, 4, 6,  'ADIDAS-UB-BLUE-9'),
                                                                        -- Puma Suede
                                                                        (3, 3, 3, 7,  'PUMA-SUEDE-RED-6'),
                                                                        (3, 1, 1, 5,  'PUMA-SUEDE-BLACK-7'),
                                                                        -- Converse Chuck
                                                                        (4, 2, 1, 12, 'CONV-CHUCK-WHITE-7'),
                                                                        (4, 1, 4, 9,  'CONV-CHUCK-BLACK-9'),
                                                                        -- Nike LeBron
                                                                        (5, 1, 2, 4,  'NIKE-LEBRON-BLACK-8.5'),
                                                                        (5, 3, 4, 3,  'NIKE-LEBRON-RED-9');

-- Customers
INSERT INTO customers (first_name, last_name, email, phone) VALUES
                                                                ('John', 'Doe', 'john.doe@example.com', '+123456789'),
                                                                ('Alice', 'Nguyen', 'alice.nguyen@example.com', '+84912345678');

-- Orders
INSERT INTO orders (customer_id, total_amount, status) VALUES
                                                           (1, 215.0, 'PAID'),
                                                           (2, 200.0, 'PENDING');

-- Order Items (shoe variants)
INSERT INTO order_items (order_id, variant_id, quantity, unit_price) VALUES
                                                                           (1, 1, 1, 130.0), -- John bought Nike Pegasus
                                                                           (1, 6, 1, 85.0),  -- John bought Puma Suede
                                                                           (2, 9, 1, 200.0); -- Alice ordered Nike LeBron
