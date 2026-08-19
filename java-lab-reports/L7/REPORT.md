# L7 — JavaFX: House Loan Calculator

## 7.1 — JavaFX Application Structure (5 marks)

- **`Application`:** The base class every JavaFX app extends; its `start(Stage)` method is the entry point launched by `Application.launch()`.
- **`Stage`:** The top-level window (like a JFrame in Swing).
- **`Scene`:** The container holding all visual content displayed inside a `Stage`.
- **`GridPane` / `VBox`:** Layout managers that arrange child nodes (labels, text fields, buttons) in a grid or vertical stack respectively.

**Role of `start()`:** It's called automatically by the JavaFX runtime after `launch()`, and is where the UI (Scene, layout, controls) is constructed and attached to the primary `Stage`.

## 7.2 — GridPane Layout (10 marks)

The layout places three input rows (Loan Amount, Annual Rate, Number of Years) with `TextField`s, a "Calculate" button, and result `Label`s below. See [`LoanCalculator.java`](./LoanCalculator.java).

## 7.3 — Event Handler & Formula (5 marks)

**Amortization formula** for Monthly Installment (M):

```
M = P × r × (1 + r)^n / ((1 + r)^n − 1)
```
where `P` = loan amount, `r` = monthly interest rate (annual rate / 12 / 100), `n` = number of months (years × 12).

- **Total Payment** = M × n
- **Difference** = Total Payment − Loan Amount

See the `handleCalculate()` event handler in [`LoanCalculator.java`](./LoanCalculator.java).
