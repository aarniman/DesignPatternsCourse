package org.example;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Enter Name");
        Checkbox checkbox = factory.createCheckbox("I Agree");

        button.display();
        textField.display();
        checkbox.display();

        button.setText("Submit");
        button.display();

        UIFactory factory2 = new BFactory();

        Button button2 = factory2.createButton("OB");
        TextField textField2 = factory2.createTextField("Enter B");
        Checkbox checkbox2 = factory2.createCheckbox("I Agree B");

        button2.display();
        textField2.display();
        checkbox2.display();
    }
}