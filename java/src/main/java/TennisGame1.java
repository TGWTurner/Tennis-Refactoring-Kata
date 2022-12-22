import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
        //dont actually use the players names so we dont need those
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";

        if (m_score1 == m_score2)
        {
            score = setEqualScoreText();
        }
        else if (m_score1 >= 4 || m_score2 >= 4)
        {
            score = checkForAdvantageAndWinText();
        }
        else
        {
            score += setBaseScoreStringText(m_score1);
            score += "-";
            score += setBaseScoreStringText(m_score2);
        }
        return score;
    }

    private String setBaseScoreStringText(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private String checkForAdvantageAndWinText() {
        int minusResult = m_score1 - m_score2;

        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String setEqualScoreText() {
        return switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
