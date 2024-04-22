package dao;
import javax.swing.JOptionPane;
/**
 *
 * @author Paula Labandeira, Maria Pizarro, Gonzalo Azcarate, Dedeepya Parvathaneni
 */
public class Tables {
    public static void main(String[] args) {
        try {
            String Restaurant = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='RESTAURANT';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE Restaurant ("
                    + "RestaurantID INTEGER NOT NULL,"
                    + "RestaurantAddress VARCHAR2(100) NOT NULL,"
                    + "RestaurantName VARCHAR2(100) NOT NULL,"
                    + "RestaurantPhone INTEGER NOT NULL,"
                    + "CONSTRAINT Restaurant_PK PRIMARY KEY (RestaurantID))'; "
                    + "END IF;"
                    + "END;";

            String adminDetails = "INSERT INTO Restaurant("
                    + "Name,"
                    + "Surname,"
                    + "Role"
                    + "PhoneNo,"
                    + "Email,"
                    + "Username"
                    + "Password,"
                    + "SecurityQuestion,"
                    + "Answer," 
                    + "Status)" 
                    + "VALUES ("
                    + "'Admin',"
                    + "'Admin',"
                    + "'Admin',"
                    + "'1235758373',"
                    + "'admin@gmail.com',"
                    + "'Admin'"
                    + "'Spain',"
                    + "'What is your favorite food?',"
                    + "'pizza',"
                    + "'true')";

            String Client = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='CLIENT';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE Client ("
                    + "ClientID INTEGER NOT NULL,"
                    + "ClientName VARCHAR2(100) NOT NULL,"
                    + "ClientSurname VARCHAR2(100) NOT NULL,"
                    + "ClientPhoneNo INTEGER NOT NULL,"
                    + "ClientEmail VARCHAR2(100) NOT NULL,"
                    + "ClientUsername VARCHAR2(100) NOT NULL,"
                    + "ClientPassword VARCHAR2(100) NOT NULL,"
                    + "CONSTRAINT Client_PK PRIMARY KEY (ClientID))'; "
                    + "END IF;"
                    + "END;";

            String Meal = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='MEAL';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE Meal ("
                    + "MealID INTEGER NOT NULL,"
                    + "MealName VARCHAR2(100) NOT NULL,"
                    + "MealDescription VARCHAR2(250) NOT NULL,"
                    + "MealPrice FLOAT NOT NULL,"
                    + "CONSTRAINT Meal_PK PRIMARY KEY (MealID))'; "
                    + "END IF;"
                    + "END;";


            String Orders = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='ORDERS';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE Orders ("
                    + "OrderID INTEGER NOT NULL,"
                    + "ClientID INTEGER NOT NULL,"
                    + "RestaurantID INTEGER NOT NULL,"
                    + "Date DATE NOT NULL,"
                    + "Status VARCHAR2(100) NOT NULL,"
                    + "CONSTRAINT Orders_PK PRIMARY KEY (OrderID),"
                    + "CONSTRAINT Orders_FK_Client FOREIGN KEY (ClientID) REFERENCES Client(ClientID),"
                    + "CONSTRAINT Orders_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID))'; "
                    + "END IF;"
                    + "END;";

            String OrderItems = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='ORDERITEMS';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE OrderItems ("
                    + "OrderItemsID INTEGER NOT NULL,"
                    + "OrderID INTEGER NOT NULL,"
                    + "MealID INTEGER NOT NULL,"
                    + "ClientID INTEGER NOT NULL,"
                    + "NumberOfPlatesOrder INTEGER NOT NULL,"
                    + "CONSTRAINT OrderItems_PK PRIMARY KEY (OrderItemsID),"
                    + "CONSTRAINT OrderItems_FK_Order FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),"
                    + "CONSTRAINT OrderItems_FK_Meal FOREIGN KEY (MealID) REFERENCES Meal(MealID),"
                    + "CONSTRAINT OrderItems_FK_Client FOREIGN KEY (ClientID) REFERENCES Client(ClientID))'; "
                    + "END IF;"
                    + "END;";

            String RestaurantMeal = "DECLARE COUNT_NUM INT:=0; BEGIN SELECT COUNT(TABLE_NAME) INTO COUNT_NUM FROM USER_TABLES WHERE TABLE_NAME='RESTAURANTMEAL';"
                    + "IF COUNT_NUM <= 0 THEN EXECUTE IMMEDIATE 'CREATE TABLE RestaurantMeal ("
                    + "RestaurantMealID INTEGER NOT NULL,"
                    + "MealID INTEGER NOT NULL,"
                    + "RestaurantID INTEGER NOT NULL,"
                    + "CONSTRAINT RestaurantMeal_PK PRIMARY KEY (RestaurantMealID),"
                    + "CONSTRAINT RestaurantMeal_FK_Meal FOREIGN KEY (MealID) REFERENCES Meal(MealID),"
                    + "CONSTRAINT RestaurantMeal_FK_Restaurant FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID))'; "
                    + "END IF;"
                    + "END;";

            // Execute the statements for each table
            DbOperations.setDataorDelete(Restaurant, "Restaurant Table Created Successfully");
            DbOperations.setDataorDelete(Client, "Client Table Created Successfully");
            DbOperations.setDataorDelete(Meal, "Meal Table Created Successfully");
            DbOperations.setDataorDelete(Ingredient, "Ingredient Table Created Successfully");
            DbOperations.setDataorDelete(IngredientMeal, "IngredientMeal Table Created Successfully");
            DbOperations.setDataorDelete(Orders, "Orders Table Created Successfully");
            DbOperations.setDataorDelete(OrderItems, "OrderItems Table Created Successfully");
            DbOperations.setDataorDelete(RestaurantMeal, "RestaurantMeal Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
