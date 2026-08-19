import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {

    private TextField loanAmountField = new TextField();
    private TextField rateField = new TextField();
    private TextField yearsField = new TextField();
    private Label monthlyLabel = new Label();
    private Label totalLabel = new Label();
    private Label diffLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Loan Amount:"), 0, 0);
        grid.add(loanAmountField, 1, 0);

        grid.add(new Label("Annual Rate (%):"), 0, 1);
        grid.add(rateField, 1, 1);

        grid.add(new Label("Number of Years:"), 0, 2);
        grid.add(yearsField, 1, 2);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(e -> handleCalculate());
        grid.add(calculateBtn, 1, 3);

        grid.add(new Label("Monthly Installment:"), 0, 4);
        grid.add(monthlyLabel, 1, 4);
        grid.add(new Label("Total Payment:"), 0, 5);
        grid.add(totalLabel, 1, 5);
        grid.add(new Label("Difference:"), 0, 6);
        grid.add(diffLabel, 1, 6);

        primaryStage.setScene(new Scene(grid, 350, 300));
        primaryStage.setTitle("House Loan Calculator");
        primaryStage.show();
    }

    private void handleCalculate() {
        double loanAmount = Double.parseDouble(loanAmountField.getText());
        double annualRate = Double.parseDouble(rateField.getText());
        int years = Integer.parseInt(yearsField.getText());

        double monthlyRate = annualRate / 12 / 100;
        int months = years * 12;

        double monthlyInstallment = loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
        double totalPayment = monthlyInstallment * months;
        double difference = totalPayment - loanAmount;

        monthlyLabel.setText(String.format("%.2f", monthlyInstallment));
        totalLabel.setText(String.format("%.2f", totalPayment));
        diffLabel.setText(String.format("%.2f", difference));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
