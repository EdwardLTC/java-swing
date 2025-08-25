-- Brands Table
CREATE TABLE brands
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT NOT NULL UNIQUE,
    description TEXT
);

-- Categories Table
CREATE TABLE categories
(
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    name      TEXT NOT NULL UNIQUE,
    parent_id INTEGER,
    FOREIGN KEY (parent_id) REFERENCES categories (id)
);

-- Colors Table
CREATE TABLE colors
(
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    name     TEXT NOT NULL UNIQUE,
    hex_code TEXT
);

-- Products Table (Shoes)
CREATE TABLE products
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT    NOT NULL,
    description TEXT,
    price       REAL    NOT NULL CHECK (price >= 0),
    brand_id    INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at  DATETIME,
    FOREIGN KEY (brand_id) REFERENCES brands (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

-- Sizes Table
CREATE TABLE sizes
(
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    us_size REAL NOT NULL UNIQUE,
    eu_size REAL NOT NULL,
    gender  CHAR(1) CHECK (gender IN ('M', 'F', 'U'))
);

-- Variants Table
CREATE TABLE variants
(
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    product_id INTEGER NOT NULL,
    color_id   INTEGER NOT NULL,
    size_id    INTEGER NOT NULL,
    quantity   INTEGER NOT NULL CHECK (quantity >= 0) DEFAULT 0,
    sku        TEXT    NOT NULL UNIQUE,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (color_id) REFERENCES colors (id),
    FOREIGN KEY (size_id) REFERENCES sizes (id),
    UNIQUE (product_id, color_id, size_id) -- Composite unique constraint
);

-- Customers Table
CREATE TABLE customers
(
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,
    email      TEXT NOT NULL UNIQUE,
    phone      TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Orders Table
CREATE TABLE orders
(
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    customer_id  INTEGER NOT NULL,
    order_date   DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount REAL    NOT NULL CHECK (total_amount >= 0),
    status       TEXT    NOT NULL CHECK (status IN ('PENDING', 'PAID', 'SHIPPED', 'DELIVERED', 'CANCELLED')),
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);

-- Order Items Table
CREATE TABLE order_items
(
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    order_id     INTEGER NOT NULL,
    variant_id INTEGER NOT NULL,
    quantity     INTEGER NOT NULL CHECK (quantity > 0),
    unit_price   REAL    NOT NULL CHECK (unit_price >= 0),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (variant_id) REFERENCES variants (id)
);

-- Indexes for Performance
CREATE INDEX idx_products_brand ON products (brand_id);
CREATE INDEX idx_variants_product ON variants (product_id);
CREATE INDEX idx_orders_customer ON orders (customer_id);
CREATE INDEX idx_order_items_order ON order_items (order_id);