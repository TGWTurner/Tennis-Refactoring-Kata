import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    private int P1point = 0;
    private int P2point = 0;

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {

        if (checkForWin(P1point, P2point)) {
            return "Win for player1";
        }

        if (checkForWin(P2point, P1point)) {
            return "Win for player2";
        }

        if (P1point == P2point) {
            return getEqualScoreText(P1point);
        }

        if (checkForAdvantage(P1point, P2point)) {
            return "Advantage player1";
        }

        if (checkForAdvantage(P2point, P1point)) {
            return "Advantage player2";
        }

        return getScoreText(P1point) + "-" + getScoreText(P2point);
    }

    private String getScoreText(int score) {
        return switch(score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private String getEqualScoreText(int score) {
        if (score < 3) {
            return getScoreText(score) + "-All";
        }

        return "Deuce";
    }

    private boolean checkForAdvantage(int score1, int score2) {
        return score1 > score2 && score2 >= 3;
    }

    private boolean checkForWin(int score1, int score2) {
        return (score1 >= 4 && score2 >= 0 && (score1-score2) >= 2);
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            P1Score();
        else
            P2Score();
    }
}