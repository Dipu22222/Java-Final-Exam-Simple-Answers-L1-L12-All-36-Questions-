public class Question {
    private String category;
    private String text;
    private String optionA, optionB, optionC, optionD;
    private char correctOption;

    public Question(String category, String text, String a, String b, String c, String d, char correct) {
        this.category = category;
        this.text = text;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctOption = correct;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctOption;
    }

    public void display() {
        System.out.println("[" + category + "] " + text);
        System.out.println("A) " + optionA + "  B) " + optionB + "  C) " + optionC + "  D) " + optionD);
    }
}
