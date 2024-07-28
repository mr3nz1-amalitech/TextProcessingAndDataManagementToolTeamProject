package com.lab6.textprocessinganddatamanagementtoolteamproject.controller;

import com.lab6.textprocessinganddatamanagementtoolteamproject.HelloApplication;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.BookModel;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.CarModel;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.PersonModel;
import com.lab6.textprocessinganddatamanagementtoolteamproject.service.BookService;
import com.lab6.textprocessinganddatamanagementtoolteamproject.service.CarService;
import com.lab6.textprocessinganddatamanagementtoolteamproject.service.PersonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataModuleController {
    public ComboBox selectDataStructureComboBox;
    public ComboBox selectValueComboBox;
    public Text dataStructureValue;
    public TextField valueTextField;
    @FXML
    private Label welcomeText;

    CarService carService = new CarService();
    PersonService personService = new PersonService();
    BookService bookService = new BookService();

    public void handleSelectDataStructure(ActionEvent actionEvent) {
        try {
            selectValueComboBox.getItems().clear();
            if (selectDataStructureComboBox.getValue().equals("ArrayList")) {
                populateArrayListValues();
            } else if (selectDataStructureComboBox.getValue().equals("HashMap")) {
                populateHashMapValues();
            } else if (selectDataStructureComboBox.getValue().equals("Set")) {
                populateHashSetValues();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateArrayListValues() {
        try {
            selectValueComboBox.getItems().addAll(personService.getAllPersons().stream().map(personModel -> personModel.getId() + " # " + personModel.getName()).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateHashMapValues() {
        try {
            selectValueComboBox.getItems().addAll(carService.findAllCars().keySet().stream().map(key -> {
                CarModel car = carService.getCar(key);
                return "Name: " + car.getName() + ", price: $" + car.getPrice();
            }).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateHashSetValues() {
        try {
            selectValueComboBox.getItems().addAll(bookService.getAll().stream().map(book -> book.getBookID() + " # " + book.getBookName()).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void initialize() {
        try {
            selectDataStructureComboBox.getItems().addAll("ArrayList", "HashMap", "Set");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleSelectValue(ActionEvent actionEvent) {
        try {
            dataStructureValue.setText(selectValueComboBox.getSelectionModel().getSelectedItem().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void handleAddValue(ActionEvent actionEvent) {
        try {
            selectValueComboBox.getItems().clear();
            if (selectDataStructureComboBox.getValue().equals("ArrayList")) {
                handleAddToArrayList();
            } else if (selectDataStructureComboBox.getValue().equals("HashMap")) {
                handleAddHashMap();
            } else {
                handleAddHashSet();
            }

            valueTextField.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleAddToArrayList() {
        try {
            personService.addPerson(new PersonModel(0, valueTextField.getText()));
            selectValueComboBox.getItems().clear();
            selectValueComboBox.getItems().addAll(personService.getAllPersons().stream().map(personModel -> personModel.getId() + " # " + personModel.getName()).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleAddHashMap() {
        try {
            carService.add(new CarModel(valueTextField.getText(), (int) Math.floor(Math.random() * 100000)));
            selectValueComboBox.getItems().clear();

            selectValueComboBox.getItems().addAll(carService.findAllCars().keySet().stream().map(key -> {
                CarModel car = carService.getCar(key);
                return "Name: " + car.getName() + ", price: $" + car.getPrice();
            }).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleAddHashSet() {
        try {
            bookService.addBook(new BookModel(0, valueTextField.getText()));

            selectValueComboBox.getItems().addAll(bookService.getAll().stream().map(val -> val.getBookID() + " # " + val.getBookName()).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDelete(ActionEvent actionEvent) {
        try {
            if (selectDataStructureComboBox.getValue().equals("ArrayList")) {
                handleDeleteInArrayList();
            } else if (selectDataStructureComboBox.getValue().equals("HashMap")) {
                handleDeleteInHashMap();
            } else if (selectDataStructureComboBox.getValue().equals("Set")) {
                handleDeleteInHashSet();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDeleteInArrayList() {
        try {

            String selection = selectValueComboBox.getSelectionModel().getSelectedItem().toString();
            int selectionId = Integer.parseInt(String.valueOf(Arrays.stream(selection.split(" # ")).toArray()[0]));
            selectValueComboBox.getItems().

                    remove(selection);
            personService.deletePerson(selectionId);
        } catch (
                Exception e) {
            System.out.

                    println(e.getMessage());
        }
    }

    public void handleDeleteInHashMap() {
        try {
            String selection = selectValueComboBox.getSelectionModel().getSelectedItem().toString();
            String selectionKey = Arrays.stream(selection.split(", ")).toArray()[0].toString().split(": ")[1];
            selectValueComboBox.getItems().remove(selection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDeleteInHashSet() {
        try {
            String selection = selectValueComboBox.getSelectionModel().getSelectedItem().toString();
            String[] selectionArr = selection.split(" # ");
            BookModel book = new BookModel(Integer.parseInt(String.valueOf(selectionArr[0])), selectionArr[1]);
            selectValueComboBox.getItems().remove(selection);
            bookService.deleteBook(book);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleEdit(ActionEvent actionEvent) {
        try {
            if (selectDataStructureComboBox.getValue().equals("ArrayList")) {
                handleEditInArrayList();
            } else if (selectDataStructureComboBox.getValue().equals("HashMap")) {
                handleEditInHashMap();
            } else if (selectDataStructureComboBox.getValue().equals("Set")) {
                handleEditInHashSet();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleEditInArrayList() {
        try {
            List<String> list = personService.getAllPersons().stream().map(val -> {
                if (selectValueComboBox.getSelectionModel().getSelectedItem().toString().equals(val.getId() + " # " + val.getName())) {
                    return val.getId() + " # " + valueTextField.getText();
                }
                return val.getId() + " # " + val.getName();
            }).toList();
            selectValueComboBox.getItems().clear();
            selectValueComboBox.getItems().addAll(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleEditInHashMap() {
        try {

            String selection = selectValueComboBox.getSelectionModel().getSelectedItem().toString();
            String selectionKey = Arrays.stream(selection.split(", ")).toArray()[0].toString().split(": ")[1];

            List<String> carsList = carService.findAllCars().keySet().stream().map(key -> {
                CarModel car = carService.getCar(key);
                if (valueTextField.getText().equals(selectionKey)) {
                    return "Name: " + valueTextField.getText() + ", price: $" + car.getPrice();
                }
                return "Name: " + car.getName() + ", price: $" + car.getPrice();
            }).toList();
            selectValueComboBox.getItems().clear();
            selectValueComboBox.getItems().addAll(carsList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleEditInHashSet() {
        try {
            String selection = selectValueComboBox.getSelectionModel().getSelectedItem().toString();
            int id = Integer.parseInt(String.valueOf(Arrays.stream(selection.split(" # ")).toArray()[0]));

            List<String> books = bookService.getAll().stream().map(book -> {
                if (book.getBookID() == id) {
                    return id + " # " + valueTextField.getText();
                }

                return book.getBookID() + " # " + book.getBookName();
            }).toList();

            selectValueComboBox.getItems().clear();
            selectValueComboBox.getItems().addAll(books);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void goToTextProcessingTool(ActionEvent actionEvent) throws IOException {
        try {
            navigateToView(actionEvent, "/com/lab6/textprocessinganddatamanagementtoolteamproject/text-processing-tool-view.fxml", "Text Processing Tool");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
            System.out.println(e.getMessage());
        }
    }
}