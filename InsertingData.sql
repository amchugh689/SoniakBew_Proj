USE Cappuccino_CormacF;
DELIMITER $$
DROP PROCEDURE IF EXISTS InsertingData $$
CREATE PROCEDURE InsertingData()
BEGIN
  START TRANSACTION;

-- Adding test data to Sales_Employee
INSERT INTO Sales_Employee (Sales_Fname, Sales_Lname, Sales_Salary, Sales_BankAcc, Sales_NINum, Sales_CommRate)
VALUES
    ('John', 'Doe', 55000.00, '12345678901234', 'ABC123456', 5.0),
    ('Jane', 'Smith', 60000.00, '98765432101234', 'XYZ987654', 4.5),
    ('Michael', 'Johnson', 48000.00, '56789012340123', 'PQR567890', 6.0),
    ('Emily', 'Davis', 52000.00, '98765401230123', 'LMN987654', 5.5),
    ('David', 'Wilson', 58000.00, '56789012345678', 'DEF567890', 4.0),
    ('Sarah', 'Lee', 51000.00, '12345678901234', 'GHI123456', 5.2),
    ('Robert', 'Martinez', 59000.00, '56789012340123', 'JKL567890', 4.8),
    ('Jennifer', 'Taylor', 53000.00, '98765401230123', 'UVW987654', 5.3),
    ('William', 'Harris', 56000.00, '98765432101234', 'STU987654', 4.9),
    ('Linda', 'Clark', 54000.00, '12345678901234', 'MNO123456', 5.4);

-- Adding test data to Delivery_Employee
INSERT INTO Delivery_Employee (Delivery_Fname, Delivery_Lname, Delivery_Salary, Delivery_BankAcc, Delivery_NINum)
VALUES
        ('Daniel', 'Brown', 45000.00, '12345678901234', 'ABC123456'),
        ('Olivia', 'Garcia', 42000.00, '98765432101234', 'XYZ987654'),
        ('James', 'Anderson', 47000.00, '56789012340123', 'PQR567890'),
        ('Sophia', 'White', 43000.00, '98765401230123', 'LMN987654'),
        ('Benjamin', 'Hall', 46000.00, '56789012345678', 'DEF567890'),
        ('Ava', 'Lewis', 44000.00, '12345678901234', 'GHI123456'),
        ('Logan', 'Jackson', 48000.00, '56789012340123', 'JKL567890'),
        ('Mia', 'Smith', 42000.00, '98765401230123', 'UVW987654'),
        ('Elijah', 'Miller', 49000.00, '98765432101234', 'STU987654'),
        ('Emma', 'Moore', 43000.00, '12345678901234', 'MNO123456');

-- Adding test data to Client
INSERT INTO Client (Client_Fname, Client_Lname, Client_Address, Client_Phone)
VALUES
            ('Robert', 'Johnson', '123 Main St, New York, NY', '555-123-4567'),
            ('Sarah', 'Davis', '456 Oak Ave, Los Angeles, CA', '555-234-5678'),
            ('Michael', 'Smith', '789 Pine Rd, Chicago, IL', '555-345-6789'),
            ('Emily', 'Wilson', '321 Elm Dr, Houston, TX', '555-456-7890'),
            ('David', 'Brown', '654 Cedar Ln, Miami, FL', '555-567-8901'),
            ('Linda', 'Taylor', '987 Maple Rd, San Francisco, CA', '555-678-9012'),
            ('William', 'Martinez', '234 Birch Ave, Boston, MA', '555-789-0123'),
            ('Jennifer', 'Jones', '567 Cherry Dr, Dallas, TX', '555-890-1234'),
            ('Daniel', 'Lee', '890 Willow Ln, Seattle, WA', '555-901-2345'),
            ('Olivia', 'Clark', '432 Birch Rd, Denver, CO', '555-012-3456');

-- Adding test data to Project
INSERT INTO Project (Project_Name, Project_Value, Client_ID, Sales_ID, Tech_Lead, Project_Start_Date, Project_End_Date, Project_Completed)
VALUES
    ('Project A', 100000.00, 1, 1, 1, '2023-01-15', '2023-04-30', 1),
    ('Project B', 85000.00, 2, 2, 2, '2023-02-10', '2023-05-20', 0),
    ('Project C', 120000.00, 3, 3, 3, '2023-03-05', '2023-06-15', 1),
    ('Project D', 95000.00, 4, 4, 4, '2023-04-20', '2023-07-10', 0),
    ('Project E', 110000.00, 5, 5, 5, '2023-05-10', '2023-08-25', 1),
    ('Project F', 90000.00, 6, 6, 6, '2023-06-15', '2023-09-30', 0),
    ('Project G', 115000.00, 7, 7, 7, '2023-07-20', '2023-10-05', 1),
    ('Project H', 98000.00, 8, 8, 8, '2023-08-05', '2023-11-15', 0),
    ('Project I', 105000.00, 9, 9, 9, '2023-09-10', '2023-12-20', 1),
    ('Project J', 93000.00, 10, 10, 10, '2023-10-15', '2023-01-25', 0);

-- Adding test data to Project_Delivery
INSERT INTO Project_Delivery (Project_ID, Delivery_ID, Actively_Working)
VALUES
    (1, 1, 1),
    (2, 2, 0),
    (3, 3, 1),
    (4, 4, 0),
    (5, 5, 1),
    (6, 6, 0),
    (7, 7, 1),
    (8, 8, 0),
    (9, 9, 1),
    (10, 10, 0);

-- Adding test data to Technology
INSERT INTO Technology (Technology_Name)
VALUES
    ('Java'),
    ('Python'),
    ('C++'),
    ('JavaScript'),
    ('SQL'),
    ('HTML/CSS'),
    ('Ruby'),
    ('PHP'),
    ('Swift'),
    ('C#');

-- Adding test data to Project_Technology
INSERT INTO Project_Technology (Project_ID, Technology_ID)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3),
    (3, 3),
    (3, 4),
    (4, 4),
    (4, 5),
    (5, 5),
    (5, 6),
    (6, 6),
    (6, 7),
    (7, 7),
    (7, 8),
    (8, 8),
    (8, 9),
    (9, 9),
    (9, 10),
    (10, 10),
    (10, 1);

# Check the number of affected rows
GET DIAGNOSTICS @rows = ROW_COUNT;
IF @rows = 0 THEN
  # If an error has occurred, rollback the transaction
  ROLLBACK;
  SELECT 'Transaction rolled back due to error.';
ELSE
  # If no error has occurred, commit the transaction
  COMMIT;
  SELECT 'Transaction has committed successfully.';
END IF;
END $$
DELIMITER ;
CALL InsertingData();
