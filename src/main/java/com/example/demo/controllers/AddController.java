package com.example.demo.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import com.example.demo.objects.Human;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnCancel;

    @FXML
    private Button BtnSave;

    @FXML
    private TextField age_field;

    @FXML
    private DatePicker birthday_field;

    @FXML
    private TextField name_field;

    @FXML
    void initialize() {}}
       /* BtnSave.setOnAction(actionEvent -> {
            String nameText = name_field.getText().trim();
            String ageText = age_field.getText().trim();
            DatePicker birthdayText = (DatePicker) birthday_field.getUserData();*/

           // if(!nameText.equals("")  && !ageText.equals("") && !birthdayText.equals(""))
           //     saveUser(nameText, ageText, birthdayText);
            //    else
             //   System.out.println("jhh");
       /* DatabaseHandler dbHandler = new DatabaseHandler();
        BtnSave.setOnAction(actionEvent -> {
            dbHandler.saveUser(name_field.getText(), age_field.getText(), (java.sql.Date) birthday_field.getUserData());


        });

    }

   private void saveUser(String nameText, String ageText, DatePicker birthdayText) {
   }


   //<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.8.2</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>15.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>15.0.1</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>15</source>
                    <target>15</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <executions>
                    <execution>
                        <!-- Default configuration for running with: mvn clean javafx:run -->
                        <id>default-cli</id>
                        <configuration>
                            <mainClass>com.example.demo/com.example.demo.HelloApplication</mainClass>
                            <launcher>app</launcher>
                            <jlinkZipName>app</jlinkZipName>
                            <jlinkImageName>app</jlinkImageName>
                            <noManPages>true</noManPages>
                            <stripDebug>true</stripDebug>
                            <noHeaderFiles>true</noHeaderFiles>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>*/


