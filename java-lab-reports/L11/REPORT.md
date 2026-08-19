# L11 — Servlet CRUD — District Quiz Game

## 11.1 — Database Schema Design (5 marks)

**Questions Table** (categories: Crops, Geography, Academic Institutions):

| Column | Type |
|---|---|
| question_id | INT (PK) |
| category | VARCHAR(30) |
| question_text | VARCHAR(255) |
| option_a / b / c / d | VARCHAR(100) |
| correct_option | CHAR(1) |

**PlayerScore Table:**

| Column | Type |
|---|---|
| score_id | INT (PK, AUTO_INCREMENT) |
| player_name | VARCHAR(50) |
| final_score | INT |
| played_on | TIMESTAMP |

**Justification:** Separating `Questions` from `PlayerScore` keeps quiz content independent of gameplay results, so questions can be reused across many play sessions without duplication, and scores can be queried/ranked independently.

## 11.2 — Servlet: Save Score (8 marks)

See [`QuizServlet.java`](./QuizServlet.java) — saves the player's name and final score into `PlayerScore` via JDBC/`PreparedStatement`.

## 11.3 — Quiz Logic (7 marks)

See [`Question.java`](./Question.java) and the quiz loop in `QuizServlet.java`'s `runQuiz()` — at least 3 MCQs (one crop, one geography, one institution question), presented one at a time, checked against the correct option, incrementing the score on a match.
