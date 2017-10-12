package sample;

import com.intellij.openapi.util.Pass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.*;

/*@author : nitinkgp23 */

public class Sample extends Application {

    static void writeToFile(String data, String filename){

        try {
            File targetFile = new File(filename);
            // if file doesnt exists, then create it
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            FileWriter fw = new FileWriter(targetFile.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
            bw.close();
            System.out.println("Writing to file :" + filename + " is done.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    static String readFromFile(String filename){
        try {
            File targetFile = new File(filename);
            FileReader fr = new FileReader(targetFile);
            char [] c = new char[1000];
            fr.read(c);
            System.out.println("Reading from file :" + filename + " is done.");
            String content = new String(c);
            return content;
        }
        catch(IOException e){
            e.printStackTrace();
            return "";
        }
    }

    public static HBox titleGenerator(String message){
        Text title = new Text(message);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(title);
        return header;
    }

    public void registerCandidate(){
        /*Candidate registration

         * This function opens up the candidate registration portal, wherein the candidate
         * registers himself. */

        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        HBox header = Sample.titleGenerator("Candidate Registration");
        layout.setTop(header);

        Label l1 = new Label("Name");
        Label l2 = new Label("Roll number");
        Label l3 = new Label("Current CGPA");
        Label l4 = new Label("Expected Salary");
        Label l5 = new Label("Passphrase");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        PasswordField tf5 = new PasswordField();

        HBox i1 = new HBox();
        HBox i2 = new HBox();
        HBox i3 = new HBox();
        HBox i4 = new HBox();
        HBox i5 = new HBox();

        i1.setSpacing(10);
        i2.setSpacing(10);
        i3.setSpacing(10);
        i4.setSpacing(10);
        i5.setSpacing(10);
        i1.setPadding(new Insets(10));
        i2.setPadding(new Insets(10));
        i3.setPadding(new Insets(10));
        i4.setPadding(new Insets(10));
        i5.setPadding(new Insets(10));
        i1.setAlignment(Pos.CENTER_LEFT);
        i2.setAlignment(Pos.CENTER_LEFT);
        i3.setAlignment(Pos.CENTER_LEFT);
        i4.setAlignment(Pos.CENTER_LEFT);
        i5.setAlignment(Pos.CENTER_LEFT);

        i1.getChildren().addAll(l1, tf1);
        i2.getChildren().addAll(l2, tf2);
        i3.getChildren().addAll(l3, tf3);
        i4.getChildren().addAll(l4, tf4);
        i5.getChildren().addAll(l5, tf5);

        Button okay = new Button("Confirm");
        Button cancel = new Button("Cancel");
        okay.setOnAction(e -> {
            CharSequence nR = tf1.getText();
            CharSequence nI = tf2.getText();
            double nM = Double.parseDouble(tf3.getText());
            int nT = Integer.parseInt(tf4.getText());
            CharSequence nP = tf5.getText();

            String candidateData = String.join(":", nR, nP, nI,
                    (CharSequence)(tf3.getText()), (CharSequence)(tf4.getText()));
            Sample.writeToFile(candidateData, "candidate_list.txt");
            window.close();
        });
        cancel.setOnAction(e -> window.close());

        HBox confirmation = new HBox();
        confirmation.setAlignment(Pos.CENTER_RIGHT);
        confirmation.getChildren().addAll(okay, cancel);

        VBox content = new VBox();
        content.getChildren().addAll(i1, i2, i3, i4, i5, confirmation);
        layout.setCenter(content);

        Scene registerCandidate = new Scene(layout, 600, 400);
        window.setTitle("Candidate Registration");
        window.setScene(registerCandidate);
        window.show();

    }

    public void registerCompany(){
        /*Company Registration*/
        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        HBox header = Sample.titleGenerator("Company Registration");
        layout.setTop(header);

        Label l1 = new Label("Name");
        Label l2 = new Label("Location");
        Label l3 = new Label("Profile");
        Label l4 = new Label("Vacancy");
        Label l5 = new Label(("Offered Salary"));
        Label l6 = new Label(("Passphrase"));

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        PasswordField tf6 = new PasswordField();
        TextField tf5 = new TextField();

        HBox i1 = new HBox();
        HBox i2 = new HBox();
        HBox i3 = new HBox();
        HBox i4 = new HBox();
        HBox i5 = new HBox();
        HBox i6 = new HBox();

        i1.setSpacing(10);
        i2.setSpacing(10);
        i3.setSpacing(10);
        i4.setSpacing(10);
        i5.setSpacing(10);
        i6.setSpacing(10);

        i1.setPadding(new Insets(10));
        i2.setPadding(new Insets(10));
        i3.setPadding(new Insets(10));
        i4.setPadding(new Insets(10));
        i5.setPadding(new Insets(10));
        i6.setPadding(new Insets(10));

        i1.setAlignment(Pos.CENTER_LEFT);
        i2.setAlignment(Pos.CENTER_LEFT);
        i3.setAlignment(Pos.CENTER_LEFT);
        i4.setAlignment(Pos.CENTER_LEFT);
        i5.setAlignment(Pos.CENTER_LEFT);
        i6.setAlignment(Pos.CENTER_LEFT);

        i1.getChildren().addAll(l1, tf1);
        i2.getChildren().addAll(l2, tf2);
        i3.getChildren().addAll(l3, tf3);
        i4.getChildren().addAll(l4, tf4);
        i5.getChildren().addAll(l5, tf5);
        i6.getChildren().addAll(l6, tf6);

        Button okay = new Button("Confirm");
        Button cancel = new Button("Cancel");
        okay.setOnAction(e -> {
            CharSequence nR = tf1.getText();
            CharSequence nI = tf2.getText();
            CharSequence nM = tf3.getText();
            int nV = Integer.parseInt(tf4.getText());
            CharSequence nP = tf6.getText();
            int nT = Integer.parseInt(tf5.getText());

            String candidateData = String.join(":", nR, nP, nI, nM, (CharSequence)(tf4.getText()), (CharSequence)(tf5.getText()));
            Sample.writeToFile(candidateData, "company_list.txt");
            window.close();
        });
        cancel.setOnAction(e -> window.close());

        HBox confirmation = new HBox();
        confirmation.setAlignment(Pos.CENTER_RIGHT);
        confirmation.getChildren().addAll(okay, cancel);

        VBox content = new VBox();
        content.getChildren().addAll(i1, i2, i3, i4, i5, i6, confirmation);
        layout.setCenter(content);

        Scene registerCompany = new Scene(layout, 600, 400);
        window.setTitle("Company Registration");
        window.setScene(registerCompany);
        window.show();
    }

    public void loginCandidate(){
        /*Login Candidate*/
        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        HBox header = Sample.titleGenerator("Candidate Login");
        layout.setTop(header);

        Label l1 = new Label("Name");
        Label l2 = new Label("Passphrase");

        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();

        HBox i1 = new HBox();
        HBox i2 = new HBox();
        i1.setSpacing(10);
        i2.setSpacing(10);

        i1.setPadding(new Insets(10));
        i2.setPadding(new Insets(10));

        i1.setAlignment(Pos.CENTER_LEFT);
        i2.setAlignment(Pos.CENTER_LEFT);

        i1.getChildren().addAll(l1, tf1);
        i2.getChildren().addAll(l2, tf2);


        Button okay = new Button("Login");
        Button cancel = new Button("Cancel");
        okay.setOnAction(e -> {
            String nR = tf1.getText();
            String nI = tf2.getText();

            try{
                FileReader fr = new FileReader("candidate_list.txt");
                BufferedReader bufr = new BufferedReader(fr);
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");

                    Candidate can = new Candidate(items[0], items[2], Double.parseDouble(items[3]), Integer.parseInt(items[4]));
                    line = bufr.readLine();
                    can.openPortal();
                }
                bufr.close();
            }
            catch(IOException e1){
                System.out.println("Error while reading file.");
            }
            window.close();
        });
        cancel.setOnAction(e -> window.close());

        HBox confirmation = new HBox();
        confirmation.setAlignment(Pos.CENTER_RIGHT);
        confirmation.getChildren().addAll(okay, cancel);

        VBox content = new VBox();
        content.getChildren().addAll(i1, i2, confirmation);
        layout.setCenter(content);

        Scene registerCompany = new Scene(layout, 400, 250);
        window.setTitle("Candidate Login");
        window.setScene(registerCompany);
        window.show();

    }

    public void loginCompany(){
        /*Login company*/
        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        HBox header = Sample.titleGenerator("Company Login");
        layout.setTop(header);

        Label l1 = new Label("Name");
        Label l2 = new Label("Passphrase");

        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();

        HBox i1 = new HBox();
        HBox i2 = new HBox();
        i1.setSpacing(10);
        i2.setSpacing(10);

        i1.setPadding(new Insets(10));
        i2.setPadding(new Insets(10));

        i1.setAlignment(Pos.CENTER_LEFT);
        i2.setAlignment(Pos.CENTER_LEFT);

        i1.getChildren().addAll(l1, tf1);
        i2.getChildren().addAll(l2, tf2);


        Button okay = new Button("Login");
        Button cancel = new Button("Cancel");
        okay.setOnAction(e -> {
                    String nR = tf1.getText();
                    String nI = tf2.getText();

                    try {
                        FileReader fr = new FileReader("company_list.txt");
                        BufferedReader bufr = new BufferedReader(fr);
                        String line = bufr.readLine();
                        while (line != null) {
                            String[] data = line.split(":");

                            Company com = new Company(data[0], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                            line = bufr.readLine();
                            com.openPortal();
                        }
                        bufr.close();
                    } catch (IOException e1) {
                        System.out.println("Error while reading file.");
                    }
                    window.close();
                });
        cancel.setOnAction(e -> window.close());

        HBox confirmation = new HBox();
        confirmation.setAlignment(Pos.CENTER_RIGHT);
        confirmation.getChildren().addAll(okay, cancel);

        VBox content = new VBox();
        content.getChildren().addAll(i1, i2, confirmation);
        layout.setCenter(content);

        Scene registerCompany = new Scene(layout, 400, 250);
        window.setTitle("Company Login");
        window.setScene(registerCompany);
        window.show();
    }

    @Override
    public void start(Stage primaryStage) {

        Stage window = primaryStage;

        VBox vbox = new VBox();

        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();

        button1.setText("Candidate Registration");
        button2.setText("Company Registration");
        button3.setText("Candidate Login");
        button4.setText("Company Login");
        button5.setText("Exit");

        button1.setLayoutX(60);
        button1.setLayoutY(80);
        button2.setLayoutX(330);
        button2.setLayoutY(80);
        button3.setLayoutX(80);
        button3.setLayoutY(140);
        button4.setLayoutX(350);
        button4.setLayoutY(140);
        button5.setLayoutX(280);
        button5.setLayoutY(270);


        Line left = new Line(10,30,10,220);
        Line right = new Line(590,30,590,220);
        Line top = new Line(10,30,590,30);
        Line bottom = new Line(10,220,590,220);
        Line mid = new Line(300,30,300,220);

        button1.setOnAction(e -> registerCandidate());

        button2.setOnAction(e -> registerCompany());

        button3.setOnAction(e -> loginCandidate());

        button4.setOnAction(e -> loginCompany());

        button5.setOnAction(e -> window.close());

        Group layout = new Group(button1,button2,button3,button4, button5, left, right, top, bottom, mid);
        Scene scene = new Scene(layout, 600, 400);

        window.setTitle("Placement Portal");
        window.setScene(scene);
        window.show();
    }
    public int isValidChoice(String input){
        int choice;
        try{
            choice = Integer.parseInt(input);
            if((choice > 0) && (choice <= 5))
                return choice;
            else
                return 0;
        }
        catch(NumberFormatException e){
            return 0;
        }
    }

    public void makeChoice(int choice){
        switch(choice){

            case 1:
                //Recipe.addRecipe();
                break;

            case 2:
                //Recipe.editRecipe();
                break;

            case 3:
                //Recipe.browseRecipeDB(false);
                break;

            case 4:
                //Meal.preparePlan();
                break;

            case 5:
                //Meal.editPlan();
                break;

            default:
                System.out.println("No Choice");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
