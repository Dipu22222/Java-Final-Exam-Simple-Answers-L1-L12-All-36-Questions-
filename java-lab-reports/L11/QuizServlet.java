import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/quiz_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String playerName = request.getParameter("playerName");
        int finalScore = Integer.parseInt(request.getParameter("finalScore"));

        String sql = "INSERT INTO PlayerScore (player_name, final_score) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, playerName);
            ps.setInt(2, finalScore);
            ps.executeUpdate();

            response.getWriter().println("Score saved for " + playerName + ": " + finalScore);
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Standalone quiz logic (can also be run outside the servlet for testing)
    public static int runQuiz() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Crops", "Which crop is Tangail region known for?",
                "Jute", "Rice", "Tea", "Cotton", 'A'));
        questions.add(new Question("Geography", "Which river flows near Tangail?",
                "Padma", "Jamuna", "Meghna", "Karnaphuli", 'B'));
        questions.add(new Question("Academic Institutions", "Which university is located in Tangail?",
                "DU", "BUET", "MBSTU", "RU", 'C'));

        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (A/B/C/D): ");
            char answer = sc.next().charAt(0);
            if (q.isCorrect(answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
        return score;
    }
}
