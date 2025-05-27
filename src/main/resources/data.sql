-- Insertar franquicias
INSERT INTO franchise (id, name) VALUES (1, 'Franquicia Uno');
INSERT INTO franchise (id, name) VALUES (2, 'Franquicia Dos');

-- Insertar sucursales
INSERT INTO branch (id, name, franchise_id) VALUES (1, 'Sucursal A', 1);
INSERT INTO branch (id, name, franchise_id) VALUES (2, 'Sucursal B', 1);
INSERT INTO branch (id, name, franchise_id) VALUES (3, 'Sucursal C', 2);

-- Insertar productos
INSERT INTO product (id, name, stock, branch_id) VALUES (1, 'Producto 1', 50, 1);
INSERT INTO product (id, name, stock, branch_id) VALUES (2, 'Producto 2', 75, 1);
INSERT INTO product (id, name, stock, branch_id) VALUES (3, 'Producto 3', 30, 2);
INSERT INTO product (id, name, stock, branch_id) VALUES (4, 'Producto 4', 100, 2);
INSERT INTO product (id, name, stock, branch_id) VALUES (5, 'Producto 5', 60, 3);
INSERT INTO product (id, name, stock, branch_id) VALUES (6, 'Producto 6', 90, 3);
