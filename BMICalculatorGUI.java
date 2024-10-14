import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {
    private JTextField weightField;
    private JTextField heightField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        new BMICalculatorGUI().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Kalkulator BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(null);

        JLabel weightLabel = new JLabel("Waga (kg):");
        weightLabel.setBounds(20, 20, 100, 25);
        frame.add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(120, 20, 150, 25);
        frame.add(weightField);

        JLabel heightLabel = new JLabel("Wzrost (m):");
        heightLabel.setBounds(20, 60, 100, 25);
        frame.add(heightLabel);

        heightField = new JTextField();
        heightField.setBounds(120, 60, 150, 25);
        frame.add(heightField);

        JButton calculateButton = new JButton("Oblicz BMI");
        calculateButton.setBounds(80, 100, 120, 30);
        frame.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 140, 250, 100);
        resultArea.setEditable(false);
        frame.add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        frame.setVisible(true);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height * height);
            String category = getBMICategory(bmi);
            resultArea.setText(String.format("Twoje BMI wynosi: %.2f\n%s", bmi, category));
        } catch (NumberFormatException e) {
            resultArea.setText("Proszę podać poprawne liczby!");
        }
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Niedowaga. Zaleca się konsultację z dietetykiem.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Waga prawidłowa. Świetnie!";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Nadwaga. Zaleca się zdrową dietę i aktywność fizyczną.";
        } else {
            return "Otyłość. Zaleca się konsultację z lekarzem.";
        }
    }
}
