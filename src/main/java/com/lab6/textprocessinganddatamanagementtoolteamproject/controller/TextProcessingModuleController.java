package com.lab6.textprocessinganddatamanagementtoolteamproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessingModuleController {
    public TextField regexTextInput;
    public Text textOutput;
    public TextField newTextTextField;
    public TextArea textArea;

    private void navigateToView(ActionEvent actionEvent, String fxmlPath, String title) {
        try {
            // Use the fxmlPath provided as a parameter
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearText(ActionEvent actionEvent) {
        try {
            textArea.clear();
            textOutput.setText("");
            regexTextInput.clear();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceText(ActionEvent actionEvent) {
        try {
            Pattern pattern = Pattern.compile(regexTextInput.getText(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textArea.getText());
            StringBuilder replacedText = new StringBuilder();
            StringBuilder matchedValues = new StringBuilder();

            while (matcher.find()) {
                matchedValues.append(matcher.group());
                matcher.appendReplacement(replacedText, newTextTextField.getText());
            }
            matcher.appendTail(replacedText);

            // Set the output text
            textOutput.setText("Replaced text:\n" + replacedText.toString());

            // Clear input fields
            regexTextInput.clear();

            textArea.clear();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchText(ActionEvent actionEvent) {
        try {
            Pattern pattern = Pattern.compile(regexTextInput.getText(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textArea.getText());

            textOutput.setText("");

            while (matcher.find()) {
                textOutput.setText(wrapMatchingString(textArea.getText(), matcher.group()));
            }

            if (matcher.find()) {
                textOutput.setText("Value= " + matcher.group());
            } else {
                textOutput.setText("No match found");
            }

            regexTextInput.clear();
            textArea.clear();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String wrapMatchingString(String text, String searchString) {
        try {
            if (text == null || searchString == null || text.isEmpty() || searchString.isEmpty()) {
                return text;
            }

            return text.replaceAll(Pattern.quote(searchString), "\"" + searchString + "\"");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    public void goToDataManagementModule(ActionEvent actionEvent) {
        try {
            navigateToView(actionEvent, "/com/lab6/textprocessinganddatamanagementtoolteamproject/hello-view.fxml", "Text Processing Tool");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
