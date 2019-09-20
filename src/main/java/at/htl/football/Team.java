package at.htl.football;

public class Team implements Comparable {
    private String name = "";
    private int points = 0;
    private int wins = 0;
    private int draws = 0;
    private int defeats = 0;
    private int goalsShot = 0;
    private int goalsReceived = 0;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        if (match.getGuestName().equals(this.name)) {
            if (match.getGuestGoals() > match.getHomeGoals()) {
                points = points +3;
                wins++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            } else if (match.getGuestGoals() == match.getHomeGoals()) {
                points = points + 1;
                draws++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            }else {
                defeats++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            }
        } else if (match.getHomeName().equals(this.name)) {
            if (match.getGuestGoals() < match.getHomeGoals()) {
                points = points+3;
                goalsShot += match.getHomeGoals();
                goalsReceived += match.getGuestGoals();
                wins++;
            } else if (match.getGuestGoals() == match.getHomeGoals()) {
                goalsShot += match.getHomeGoals();
                points = points+1;
                draws++;
                goalsReceived += match.getGuestGoals();
            }else {
                defeats++;
                goalsShot += match.getHomeGoals();
                goalsReceived += match.getGuestGoals();
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }


    @Override
    public int compareTo(Object o) {
        Team otherTeam = (Team) o;
        if (otherTeam.points == this.points){
            return ((otherTeam.goalsShot-otherTeam.goalsReceived) - (this.goalsShot-this.goalsReceived));
        }
        return (otherTeam.points - this.points);
    }
}
