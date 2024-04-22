CREATE DATABASE RestaurantManagement;

CREATE TABLE Restaurant (
  RestaurantID INTEGER NOT NULL,
  RestaurantAddress VARCHAR2(100) NOT NULL,
  RestaurantName VARCHAR2(100) NOT NULL,
  RestaurantPhone INTEGER NOT NULL,
  CONSTRAINT Restaurant_PK PRIMARY KEY (RestaurantID)
);

CREATE TABLE Client (
  ClientID INTEGER NOT NULL,
  ClientName VARCHAR2(100) NOT NULL,
  ClientSurname VARCHAR2(100) NOT NULL,
  ClientPhoneNo INTEGER NOT NULL,
  ClientEmail VARCHAR2(100) NOT NULL,
  ClientUsername VARCHAR2(100) NOT NULL,
  ClientPassword VARCHAR2(100) NOT NULL,
  CONSTRAINT Client_PK PRIMARY KEY (ClientID)
);

CREATE TABLE Employee (
  EmployeeID INTEGER NOT NULL,
  EmployeeName VARCHAR2(100) NOT NULL,
  EmployeeSurname VARCHAR2(100) NOT NULL,
  EmployeeRole VARCHAR2(100) NOT NULL,
  EmployeePhoneNo INT NOT NULL,
  EmployeeEmail VARCHAR2(100) NOT NULL,
  EmployeeUsername VARCHAR2(100) NOT NULL,
  EmployeePassword VARCHAR2(100) NOT NULL,
  Salary INTEGER NOT NULL,
  RestaurantID INTEGER NOT NULL,
  CONSTRAINT Employee_PK PRIMARY KEY (EmployeeID),
  CONSTRAINT Employee_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID)
);

CREATE TABLE Meal (
  MealID INTEGER NOT NULL,
  MealName VARCHAR2(100) NOT NULL,
  MealDescription VARCHAR2(250) NOT NULL,
  MealPrice FLOAT NOT NULL,
  CONSTRAINT Meal_PK PRIMARY KEY (MealID)
);

CREATE TABLE Ingredient (
  IngredientID INTEGER NOT NULL,
  IngredientName VARCHAR2(100) NOT NULL,
  CONSTRAINT Ingredient_PK PRIMARY KEY (IngredientID)
);

CREATE TABLE IngredientMeal (
  IMDID INTEGER NOT NULL,
  MealID INTEGER NOT NULL,
  IngredientID INTEGER NOT NULL,
  CONSTRAINT IM_PK PRIMARY KEY (IMDID),
  CONSTRAINT IM_FK_Meal FOREIGN KEY (MealID) REFERENCES Meal(MealID),
  CONSTRAINT IM_FK_Ingredient FOREIGN KEY (IngredientID) REFERENCES Ingredient(IngredientID)
);

CREATE TABLE Orders (
  OrderID INTEGER NOT NULL,
  ClientID INTEGER NOT NULL,
  EmployeeID INTEGER NOT NULL,
  RestaurantID INTEGER NOT NULL,
  OrderDate DATE NOT NULL,
  Status VARCHAR2(100) NOT NULL,
  CONSTRAINT Orders_PK PRIMARY KEY (OrderID),
  CONSTRAINT Orders_FK_Client FOREIGN KEY (ClientID) REFERENCES Client(ClientID),
  CONSTRAINT Orders_FK_Employee FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
  CONSTRAINT Orders_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID)
);

CREATE TABLE OrderItems (
  OrderItemsID INTEGER NOT NULL,
  OrderID INTEGER NOT NULL,
  MealID INTEGER NOT NULL,
  ClientID INTEGER NOT NULL,
  NumberOfPlatesOrder INTEGER NOT NULL,
  CONSTRAINT OrderItems_PK PRIMARY KEY (OrderItemsID),
  CONSTRAINT OrderItems_FK_Order FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  CONSTRAINT OrderItems_FK_Meal FOREIGN KEY (MealID) REFERENCES Meal(MealID), 
  CONSTRAINT OrderItems_FK_Client FOREIGN KEY (ClientID) REFERENCES Client(ClientID)
);

CREATE TABLE RestaurantMeal (
  RestaurantMealID INTEGER NOT NULL,
  MealID INTEGER NOT NULL,
  RestaurantID INTEGER NOT NULL,
  CONSTRAINT RestaurantMeal_PK PRIMARY KEY (RestaurantMealID),
  CONSTRAINT RestaurantMeal_FK_Meal FOREIGN KEY (MealID) REFERENCES Meal(MealID), 
  CONSTRAINT RestaurantMeal_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID)
);

CREATE TABLE OrderRestaurant (
  OrderRestaurantID INTEGER NOT NULL,
  OrderID INTEGER NOT NULL,
  RestaurantID INTEGER NOT NULL,
  CONSTRAINT OrderRestaurant_PK PRIMARY KEY (OrderRestaurantID),
  CONSTRAINT OrderRestaurant_FK_Order FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  CONSTRAINT OrderRestaurant_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID)
);


-- INSERTS

-- Insertar datos en la tabla Restaurant
INSERT INTO Restaurant (RestaurantID, RestaurantAddress, RestaurantName, RestaurantPhone)
VALUES 
  (1, '123 Main St, Cityville', 'Taste of India', 555123456),
  (2, '456 Oak Ave, Townsville', 'Dragon Wok', 555789012),
  (3, '789 Maple Blvd, Villageton', 'La Pizzeria', 555456789),
  (4, '101 Pine Ln, Burgburg', 'Bella Cucina', 555234567),
  (5, '202 Cedar Rd, Hamletown', 'Sushi Delight', 555890123),
  (6, '303 Elm Dr, Boroughburg', 'La Tortilla', 555567890);

-- Insertar datos en la tabla Client
INSERT INTO Client (ClientID, ClientName, ClientSurname, ClientPhoneNo, ClientEmail, ClientUsername, ClientPassword)
VALUES 
  (1, 'John', 'Doe', 111111111, 'john.doe@email.com', 'johndoe', 'passjohn'),
  (2, 'Jane', 'Smith', 222222222, 'jane.smith@email.com', 'janesmith', 'passjane'),
  (3, 'Robert', 'Johnson', 333333333, 'robert.johnson@email.com', 'robertjohnson', 'passrobert'),
  (4, 'Emily', 'Davis', 444444444, 'emily.davis@email.com', 'emilydavis', 'passemily'),
  (5, 'Michael', 'Taylor', 555555555, 'michael.taylor@email.com', 'michaeltaylor', 'passmichael'),
  (6, 'Sophia', 'Brown', 666666666, 'sophia.brown@email.com', 'sophiabrown', 'passsophia'),
  (7, 'William', 'Miller', 777777777, 'william.miller@email.com', 'williammiller', 'passwilliam'),
  (8, 'Olivia', 'Anderson', 888888888, 'olivia.anderson@email.com', 'oliviaanderson', 'passolivia'),
  (9, 'James', 'White', 999999999, 'james.white@email.com', 'jameswhite', 'passjames'),
  (10, 'Emma', 'Harris', 1010101010, 'emma.harris@email.com', 'emmaharris', 'passemma');

-- Insertar datos en la tabla Employee
INSERT INTO Employee (EmployeeID, EmployeeName, EmployeeSurname, EmployeeRole, EmployeePhoneNo, EmployeeEmail, EmployeeUsername, EmployeePassword, Salary, RestaurantID)
VALUES 
  (1, 'Raj', 'Patel', 'Chef', 111111111, 'raj.patel@email.com', 'rajpatel', 'passraj', 30000, 1),
  (2, 'Wei', 'Chen', 'Waiter', 222222222, 'wei.chen@email.com', 'weichen', 'passwei', 25000, 2),
  (3, 'Carlos', 'Rodriguez', 'Cashier', 333333333, 'carlos.rodriguez@email.com', 'carlosrodriguez', 'passcarlos', 28000, 3),
  (4, 'Isabella', 'Ricci', 'Chef', 444444444, 'isabella.ricci@email.com', 'isabellaricci', 'passisabella', 30000, 1),
  (5, 'Hiroshi', 'Tanaka', 'Waiter', 555555555, 'hiroshi.tanaka@email.com', 'hiroshitanaka', 'passhiroshi', 25000, 2),
  (6, 'Elena', 'Gomez', 'Cashier', 666666666, 'elena.gomez@email.com', 'elenagomez', 'passelena', 28000, 3),
  (7, 'Antonio', 'Ferrari', 'Chef', 777777777, 'antonio.ferrari@email.com', 'antonioferrari', 'passantonio', 30000, 4),
  (8, 'Maria', 'Silva', 'Waiter', 888888888, 'maria.silva@email.com', 'mariasilva', 'passmaria', 25000, 5);

-- Insertar datos en la tabla Meal
INSERT INTO Meal (MealID, MealName, MealDescription, MealPrice)
VALUES 
  (1, 'Chicken Tikka Masala', 'Tender chicken in a rich, creamy tomato sauce', 14.99),
  (2, 'Sweet and Sour Chicken', 'Crispy chicken with tangy sweet and sour sauce', 12.99),
  (3, 'Margherita Pizza', 'Classic pizza with tomato, mozzarella, and basil', 10.99),
  (4, 'Spaghetti Bolognese', 'Spaghetti with hearty meat sauce', 16.99),
  (5, 'Sushi Combo', 'Assorted sushi rolls and sashimi', 18.99),
  (6, 'Tacos al Pastor', 'Marinated pork tacos with pineapple', 11.99),
  (7, 'Butter Chicken', 'Creamy and flavorful chicken curry', 15.99),
  (8, 'California Roll', 'Sushi roll with crab, avocado, and cucumber', 13.99),
  (9, 'Paella', 'Spanish rice dish with seafood and chorizo', 19.99),
  (10, 'Penne alla Vodka', 'Penne pasta in a creamy tomato and vodka sauce', 17.99);

-- Insertar datos en la tabla Ingredient
INSERT INTO Ingredient (IngredientID, IngredientName)
VALUES 
  (1, 'Chicken'),
  (2, 'Tomato'),
  (3, 'Onion'),
  (4, 'Bell Pepper'),
  (5, 'Pineapple'),
  (6, 'Rice'),
  (7, 'Beef'),
  (8, 'Cheese'),
  (9, 'Pork'),
  (10, 'Avocado'),
  (11, 'Cilantro'),
  (12, 'Garlic'),
  (13, 'Basil'),
  (14, 'Oregano'),
  (15, 'Soy Sauce'),
  (16, 'Nori'),
  (17, 'Cream'),
  (18, 'Vodka'),
  (19, 'Seafood Mix'),
  (20, 'Chorizo'),
  (21, 'Spaghetti'),
  (22, 'Pizza Dough'),
  (23, 'Crab'),
  (24, 'Mozzarella'),
  (25, 'Penne Pasta');

-- Insertar datos en la tabla IngredientMeal
INSERT INTO IngredientMeal (IMDID, MealID, IngredientID)
VALUES 
  (1, 1, 1),
  (2, 1, 2),
  (3, 1, 3),
  (4, 2, 1),
  (5, 2, 4),
  (6, 2, 5),
  (7, 3, 2),
  (8, 3, 8),
  (9, 3, 13),
  (10, 4, 7),
  (11, 4, 21),
  (12, 4, 2),
  (13, 5, 1),
  (14, 5, 16),
  (15, 5, 15),
  (16, 6, 9),
  (17, 6, 11),
  (18, 6, 5),
  (19, 7, 1),
  (20, 7, 2),
  (21, 7, 17),
  (22, 8, 10),
  (23, 8, 23),
  (24, 8, 8),
  (25, 9, 19),
  (26, 9, 20),
  (27, 9, 6),
  (28, 10, 22),
  (29, 10, 24),
  (30, 10, 25);

-- Insertar datos en la tabla Orders
INSERT INTO Orders (OrderID, ClientID, EmployeeID, OrderDate, Status)
VALUES 
  (1, 1, 1, '2023-01-01', 'In Progress'),
  (2, 2, 2, '2023-02-01', 'Completed'),
  (3, 3, 3, '2023-03-01', 'In Progress'),
  (4, 4, 4, '2023-04-01', 'Completed'),
  (5, 5, 5, '2023-05-01', 'In Progress'),
  (6, 6, 6, '2023-06-01', 'Completed'),
  (7, 7, 7, '2023-07-01', 'In Progress'),
  (8, 8, 8, '2023-08-01', 'Completed'),
  (9, 9, 9, '2023-09-01', 'In Progress'),
  (10, 10, 10, '2023-10-01', 'Completed');

-- Insertar datos en la tabla OrderItems
INSERT INTO OrderItems (OrderItemsID, OrderID, MealID, ClientID, NumberOfPlatesOrder)
VALUES 
  (1, 1, 1, 1, 2),
  (2, 1, 2, 1, 1),
  (3, 2, 3, 2, 3),
  (4, 2, 4, 2, 1),
  (5, 3, 5, 3, 2),
  (6, 3, 6, 3, 2),
  (7, 4, 7, 4, 1),
  (8, 4, 8, 4, 3),
  (9, 5, 9, 5, 2),
  (10, 5, 10, 5, 1),
  (11, 6, 1, 6, 3),
  (12, 6, 2, 6, 1),
  (13, 7, 3, 7, 2),
  (14, 7, 4, 7, 1),
  (15, 8, 5, 8, 3),
  (16, 8, 6, 8, 2),
  (17, 9, 7, 9, 1),
  (18, 9, 8, 9, 3),
  (19, 10, 9, 10, 2),
  (20, 10, 10, 10, 1);

-- Insertar datos en la tabla RestaurantMeal
INSERT INTO RestaurantMeal (RestaurantMealID, MealID, RestaurantID)
VALUES 
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 3),
  (4, 4, 4),
  (5, 5, 5),
  (6, 6, 6),
  (7, 7, 1),
  (8, 8, 2),
  (9, 9, 3),
  (10, 10, 4);


--DUDA:

-- Insertar datos en la tabla Orders_Restaurant (relación faltante en el esquema inicial)
INSERT INTO OrdersRestaurant (OrdersRestaurantID, OrderID, RestaurantID)
VALUES 
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 3),
  (4, 4, 4),
  (5, 5, 5),
  (6, 6, 6),
  (7, 7, 1),
  (8, 8, 2),
  (9, 9, 3),
  (10,10, 4);
