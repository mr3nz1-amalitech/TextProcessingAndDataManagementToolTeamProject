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
            e.printStackTrace(); // Log the error
            // Optionally: show an error dialog or handle the error appropriately
        }
    }

    public void clearText(ActionEvent actionEvent) {
        textArea.clear();
        textOutput.setText("");
        regexTextInput.clear();
    }

    public void replaceText(ActionEvent actionEvent) {
        Pattern pattern = Pattern.compile(regexTextInput.getText(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(textArea.getText());
        StringBuilder replacedText = new StringBuilder();
        textOutput.setText("");

        while (matcher.find()) {
            textOutput.setText("Value= " + matcher.group());
            matcher.appendReplacement(replacedText, newTextTextField.getText());
        }

        matcher.appendTail(replacedText);

        textOutput.setText(replacedText.toString());
        regexTextInput.clear();
        textArea.clear();
    }

    public void searchText(ActionEvent actionEvent) {
        Pattern pattern = Pattern.compile(regexTextInput.getText(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(textArea.getText());
        boolean matchFound = matcher.find();

        textOutput.setText("");

        if (matchFound) {
            textOutput.setText("Value= " + matcher.group());
        }

        regexTextInput.clear();
        textArea.clear();
    }

    @FXML
    public void goToDataManagementModule(ActionEvent actionEvent) {
        navigateToView(actionEvent, "/com/lab6/textprocessinganddatamanagementtoolteamproject/hello-view.fxml", "Text Processing Tool");
    }
}
