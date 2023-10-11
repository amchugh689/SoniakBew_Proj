USE Cappuccino_CormacF;
DELIMITER $$
DROP PROCEDURE IF EXISTS CreateTables $$
CREATE PROCEDURE CreateTables()
BEGIN
  START TRANSACTION;

  -- Creating the table of Sales Employees
CREATE TABLE Sales_Employee(
 Sales_ID INT AUTO_INCREMENT PRIMARY KEY,
 Sales_Fname varchar(20),
 Sales_Lname varchar(30),
 Sales_Salary decimal(11,2),
 Sales_BankAcc varchar(14),
 Sales_NINum varchar(9),
 Sales_CommRate decimal(11,2)
);

-- Creating the table of Delivery Employees
CREATE TABLE Delivery_Employee(
 Delivery_ID INT AUTO_INCREMENT PRIMARY KEY,
 Delivery_Fname varchar(20),
 Delivery_Lname varchar(30),
 Delivery_Salary decimal(11,2),
 Delivery_BankAcc varchar(14),
 Delivery_NINum varchar(9)
);

-- Creating the table of Clients
CREATE TABLE Client(
 Client_ID INT AUTO_INCREMENT PRIMARY KEY,
 Client_Fname varchar(20),
 Client_Lname varchar(30),
 Client_Address varchar(100),
 Client_Phone varchar(15)
);

-- Creating the table of Projects
CREATE TABLE Project(
	Project_ID INT PRIMARY KEY AUTO_INCREMENT,
    Project_Name VARCHAR(100) NOT NULL,
    Project_Value DECIMAL(10,2),
    Client_ID INT,
    Sales_ID INT,
    Tech_Lead INT,
    FOREIGN KEY (Client_ID) REFERENCES Client(Client_ID),
    FOREIGN KEY (Sales_ID) REFERENCES Sales_Employee(Sales_ID),

    FOREIGN KEY (Tech_Lead) REFERENCES Delivery_Employee(Delivery_ID),

    Project_Start_Date DATE,
    Project_End_Date DATE,
    Project_Completed BOOLEAN
);

-- Creating a join table between Project and Delivery
CREATE TABLE Project_Delivery (
    Project_ID INT,
    Delivery_ID INT,
    Actively_Working boolean,
    PRIMARY KEY (Project_ID, Delivery_ID),
    FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID),
    FOREIGN KEY (Delivery_ID) REFERENCES Delivery_Employee(Delivery_ID)
);

-- Creating the table of Technologies
CREATE TABLE Technology(
	Technology_ID INT PRIMARY KEY AUTO_INCREMENT,
    Technology_Name VARCHAR(100) NOT NULL
);

-- Creating a join table between Project and Technology
CREATE TABLE Project_Technology (
    Project_ID INT,
    Technology_ID INT,
    PRIMARY KEY (Project_ID, Technology_ID),
    FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID),
    FOREIGN KEY (Technology_ID) REFERENCES Technology(Technology_ID)
);

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
CALL CreateTables();