/**
 * Overview:
 * The Main class is the entry point of the Bank Account Application. This class is responsible for 
 * initializing and displaying the primary stage (window) of the application, handling user interactions,
 * and delegating tasks to the Manager and Customer classes based on user inputs. The Main class is mutable 
 * as it reacts and updates the GUI in response to user interactions.
 *
 * Abstraction Function:
 * Represents the graphical user interface of the bank account application, where users can login as either
 * a manager or a customer, and perform actions based on their role.
 *
 * Representation Invariant:
 * The username and password fields must not be null.
 */


package coe528.project;

import java.io.BufferedReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    
    

    @Override
    /**
     * Starts and initializes the primary stage of the application.
     * 
     * @param primaryStage The primary stage for this application, onto which
     * the application scene can be set.
     * @effects Initializes and shows the main GUI of the bank account application.
     */
    public void start(Stage primaryStage) {
        // Manager login fields
        Label managerLabel = new Label("Manager Login");
        TextField managerUsername = new TextField();
        managerUsername.setPromptText("Username");
        PasswordField managerPassword = new PasswordField();
        managerPassword.setPromptText("Password");
        Button managerLoginButton = new Button("Login as Manager");
        
        // Customer login fields
        Label customerLabel = new Label("Customer Login");
        TextField customerUsername = new TextField();
        customerUsername.setPromptText("Username");
        PasswordField customerPassword = new PasswordField();
        customerPassword.setPromptText("Password");
        Button customerLoginButton = new Button("Login as Customer");

        // Login message label
        Label loginMessage = new Label();

        // Event Handler for Manager Login Button
        managerLoginButton.setOnAction(event -> {
            String username = managerUsername.getText();
            String password = managerPassword.getText();

            if ("admin".equals(username) && "admin".equals(password)) {
                openManagerWindow();
            } else {
                loginMessage.setText("Manager Login Failed");
                loginMessage.setTextFill(javafx.scene.paint.Color.RED);
            }
        });
        
        // Event Handler for Customer Login Button
        customerLoginButton.setOnAction(event -> {
            String username = customerUsername.getText();
            String password = customerPassword.getText();

            File customerFile = new File(getCustomerFilePath(username));
            if (customerFile.exists()) {
                try {
                    Map<String, String> customerInfo = readCustomerInfo(customerFile);
                    if (password.equals(customerInfo.get("password"))) {
                        openCustomerWindow(username);
                    } else {
                        loginMessage.setText("Incorrect password");
                        loginMessage.setTextFill(javafx.scene.paint.Color.RED);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    loginMessage.setText("Error reading customer file");
                    loginMessage.setTextFill(javafx.scene.paint.Color.RED);
                }
            } else {
                loginMessage.setText("Customer does not exist");
                loginMessage.setTextFill(javafx.scene.paint.Color.RED);
            }
        });

        // Layout for Main Window
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(
            managerLabel, managerUsername, managerPassword, managerLoginButton,
            customerLabel, customerUsername, customerPassword, customerLoginButton,
            loginMessage
        );
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15, 15, 15, 15));

        // Scene and Stage for Main Window
        Scene scene = new Scene(vBox, 300, 400);
        primaryStage.setTitle("Bank Account Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
        /**
     * Opens the customer window interface for a specific user.
     * 
     * @param username The username of the customer for whom the window is being opened.
     * @effects Displays the customer window with options to deposit, withdraw, make purchases, view balance, and logout.
     * @requires username must correspond to an existing customer.
     */
    private void openCustomerWindow(String username) {
    Stage customerStage = new Stage();
    customerStage.setTitle("Customer Account");

    // Deposit Section
    TextField depositAmountField = new TextField();
    depositAmountField.setPromptText("Amount to Deposit");
    Button depositButton = new Button("Deposit");
    depositButton.setOnAction(e -> updateBalance(username, Double.parseDouble(depositAmountField.getText()), true));

    // Withdraw Section
    TextField withdrawAmountField = new TextField();
    withdrawAmountField.setPromptText("Amount to Withdraw");
    Button withdrawButton = new Button("Withdraw");
    withdrawButton.setOnAction(e -> updateBalance(username, Double.parseDouble(withdrawAmountField.getText()), false));

    // Purchase Section
    TextField purchaseAmountField = new TextField();
    purchaseAmountField.setPromptText("Purchase Amount");
    Button purchaseButton = new Button("Purchase");
    purchaseButton.setOnAction(e -> makePurchase(username, Double.parseDouble(purchaseAmountField.getText())));

    // Bank Balance Display
    Label bankBalanceLabel = new Label("Bank Balance: $" + getBalance(username));

    // Logout Button
    Button logoutButton = new Button("Logout");
    logoutButton.setOnAction(e -> customerStage.close());

    VBox customerBox = new VBox(10,
        depositAmountField, depositButton,
        withdrawAmountField, withdrawButton,
        purchaseAmountField, purchaseButton,
        bankBalanceLabel,
        logoutButton);
    customerBox.setAlignment(Pos.CENTER);
    customerBox.setPadding(new Insets(15));

    Scene customerScene = new Scene(customerBox, 300, 400);
    customerStage.setScene(customerScene);
    customerStage.show();
}
    
    /**
     * Updates the balance of a customer's account.
     * 
     * @param username The username of the customer whose balance is being updated.
     * @param amount The amount to deposit or withdraw.
     * @param isDeposit Indicates whether the amount is to be deposited (true) or withdrawn (false).
     * @effects Updates the balance of the customer's account based on the deposit or withdrawal.
     * @modifies Modifies the file corresponding to the customer, updating the balance.
     * @throws Exception if the file operation fails or if insufficient funds for withdrawal.
     */
private void updateBalance(String username, double amount, boolean isDeposit) {
    File customerFile = new File(getCustomerFilePath(username));
    if (!customerFile.exists()) {
        showAlert("Customer file not found.");
        return;
    }

    try {
        Map<String, String> customerInfo = readCustomerInfo(customerFile);
        double currentBalance = Double.parseDouble(customerInfo.get("bankBalance"));
        double newBalance = isDeposit ? currentBalance + amount : currentBalance - amount;

        if (newBalance < 0) {
            showAlert("Insufficient funds.");
            return;
        }

        customerInfo.put("bankBalance", String.valueOf(newBalance));
        customerInfo.put("level", determineLevel(newBalance));
        updateCustomerFile(customerInfo, customerFile);
    } catch (Exception e) {
        showAlert("Error updating balance.");
    }
}

    /**
     * Processes a purchase transaction for a customer.
     * 
     * @param username The username of the customer making the purchase.
     * @param amount The amount of the purchase.
     * @effects Processes a purchase, deducting the purchase amount and any applicable fees from the customer's account.
     * @modifies Modifies the customer's file to update the balance after the purchase.
     * @throws Exception if the file operation fails, if insufficient funds, or if the purchase amount is below the minimum required.
     */
private void makePurchase(String username, double amount) {
    File customerFile = new File(getCustomerFilePath(username));
    if (!customerFile.exists()) {
        showAlert("Customer file not found.");
        return;
    }

    try {
        Map<String, String> customerInfo = readCustomerInfo(customerFile);
        double currentBalance = Double.parseDouble(customerInfo.get("bankBalance"));

        if (amount < 50) {
            showAlert("Minimum purchase amount is $50.");
            return;
        }

        double fee = calculatePurchaseFee(customerInfo.get("level"));
        double totalCost = amount + fee;

        if (currentBalance < totalCost) {
            showAlert("Insufficient funds for this purchase.");
            return;
        }

        double newBalance = currentBalance - totalCost;
        customerInfo.put("bankBalance", String.valueOf(newBalance));
        customerInfo.put("level", determineLevel(newBalance));
        updateCustomerFile(customerInfo, customerFile);
    } catch (Exception e) {
        showAlert("Error processing purchase.");
    }
}

    /**
     * Calculates the purchase fee based on the customer's level.
     * 
     * @param level The level of the customer.
     * @return double The fee associated with the customer's level.
     */
private double calculatePurchaseFee(String level) {
    switch (level) {
        case "silver":
            return 20.0; // Fee for silver level customers
        case "gold":
            return 10.0; // Fee for gold level customers
        case "platinum":
            return 0.0; // No fee for platinum level customers
        default:
            return 0.0; // Default case, can be adjusted as needed
    }
}

    /**
     * Determines the customer's level based on their account balance.
     * 
     * @param balance The balance of the customer's account.
     * @return String The level of the customer based on the balance.
     */
private String determineLevel(double balance) {
    if (balance < 10000) {
        return "silver";
    } else if (balance < 20000) {
        return "gold";
    } else {
        return "platinum";
    }
}

private double calculateFee(String level) {
    switch (level) {
        case "silver":
            return 20;
        case "gold":
            return 10;
        default:
            return 0;
    }
}
    /**
     * Retrieves the balance of a customer's account.
     * 
     * @param username The username of the customer whose balance is to be retrieved.
     * @return double The balance of the customer's account.
     * @throws Exception if the file operation fails or the customer file does not exist.
     */
        private double getBalance(String username) {
        File customerFile = new File(getCustomerFilePath(username));
        if (customerFile.exists()) {
            try {
                Map<String, String> customerInfo = readCustomerInfo(customerFile);
                return Double.parseDouble(customerInfo.get("bankBalance"));
            } catch (Exception e) {
                showAlert("Error reading balance.");
            }
        }
        return 0;
    }

            /**
     * Generates the file path for a customer's data file.
     * 
     * @param username The username of the customer.
     * @return String The file path for the customer's data file.
     */
    private String getCustomerFilePath(String username) {
        String currentDir = System.getProperty("user.dir");
        return currentDir + "/src/coe528/project/customers/" + username + ".txt";
    }
    
        /**
     * Displays an alert with a specified message.
     * 
     * @param message The message to be displayed in the alert.
     * @effects Shows a dialog box with the provided message.
     */
private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Notification");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
    
    /**
     * Opens the manager window interface.
     * 
     * @effects Displays the manager window with options to create and delete customers, and logout.
     */
    private void openManagerWindow() {
        Stage managerStage = new Stage();
        managerStage.setTitle("Manager");

        // Create Customer Section
        TextField createUsernameField = new TextField();
        createUsernameField.setPromptText("Username");
        TextField createPasswordField = new TextField();
        createPasswordField.setPromptText("Password");
        Button createCustomerButton = new Button("Create Customer");
        createCustomerButton.setOnAction(e -> createCustomer(createUsernameField.getText(), createPasswordField.getText()));

        // Delete Customer Section
        TextField deleteUsernameField = new TextField();
        deleteUsernameField.setPromptText("Customer Username");
        Button deleteCustomerButton = new Button("Delete Customer");
        deleteCustomerButton.setOnAction(e -> deleteCustomer(deleteUsernameField.getText()));

        // Logout Button
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> managerStage.close());

        VBox managerBox = new VBox(10, 
            createUsernameField, createPasswordField, createCustomerButton, 
            deleteUsernameField, deleteCustomerButton, 
            logoutButton);
        managerBox.setAlignment(Pos.CENTER);
        managerBox.setPadding(new Insets(15));

        Scene managerScene = new Scene(managerBox, 300, 300);
        managerStage.setScene(managerScene);
        managerStage.show();
    }
    
    /**
 * Creates a new customer with the provided username and password. It creates a new file to store 
 * customer information, setting the initial bank balance to 100 and the level to silver.
 *
 * @param username the username of the new customer
 * @param password the password of the new customer
 * @effects Creates a new customer file with initial values.
 * @modifies This method modifies the file system by adding a new file for the customer.
 * @throws IOException if an error occurs during file operations.
 * @requires username and password to be non-null and the customer file does not already exist.
 */
    private void createCustomer(String username, String password) {
        String currentDir = System.getProperty("user.dir");
        File customerFile = new File(currentDir + "/src/coe528/project/customers/" + username + ".txt");

        if (!customerFile.exists()) {
            try {
                customerFile.createNewFile();
                PrintWriter writer = new PrintWriter(customerFile);
                writer.println("username: " + username);
                writer.println("password: " + password);
                writer.println("bankBalance: 100");
                writer.println("level: silver");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
 * Deletes the file corresponding to a customer, effectively removing the customer's data from the system.
 *
 * @param username The username of the customer whose file is to be deleted.
 * @effects Deletes the customer's file from the filesystem.
 * @modifies The filesystem where the customer files are stored.
 * @requires The file corresponding to the username must exist.
 */
    private void deleteCustomer(String username) {
        String currentDir = System.getProperty("user.dir");
        File customerFile = new File(currentDir + "/src/coe528/project/customers/" + username + ".txt");

        if (customerFile.exists()) {
            customerFile.delete();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
 * Reads customer information from a specified file and returns it as a map.
 *
 * @param customerFile The file from which customer information is to be read.
 * @return A Map where each key-value pair corresponds to an attribute and its value for the customer.
 * @throws IOException If an error occurs during reading the file.
 * @effects Reads the customer's data from the file.
 * @requires customerFile to be a valid, accessible file.
 */
    private Map<String, String> readCustomerInfo(File customerFile) throws IOException {
        Map<String, String> customerInfo = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(customerFile.getPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    customerInfo.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
        return customerInfo;
    }

    /**
 * Updates the customer's information file with the given information.
 *
 * @param customerInfo The customer information to be written to the file.
 * @param customerFile The file where the customer information is to be saved.
 * @throws IOException If an error occurs during writing to the file.
 * @effects Writes the updated customer's data to the file.
 * @modifies The customerFile is modified with the new information provided in customerInfo.
 * @requires customerInfo to be non-null and customerFile to be a valid, writable file.
 */
    private void updateCustomerFile(Map<String, String> customerInfo, File customerFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(customerFile)) {
            for (Map.Entry<String, String> entry : customerInfo.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}