package at.htl.football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class League {
    List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match) {
        Team homeTeam = findOrCreateTeam(match.getHomeName());
        Team guestTeam = findOrCreateTeam(match.getGuestName());

        homeTeam.addMatch(match);
        guestTeam.addMatch(match);

    }

    private Team findOrCreateTeam(String teamName) {
        for (int i = 0; i < this.teams.size(); i++) {
            if (this.teams.get(i).getName().equals(teamName)) {
                return this.teams.get(i);
            }
        }

        this.teams.add(new Team(teamName));
        return this.teams.get(this.teams.size()-1);
    }

    public List<Team> getTable() {
        Collections.sort(teams);
        System.out.println("Team                Pts  W  D  L  GF  GA  GD");
        for (int i = 0; i < teams.size(); i++) {
            Team o = teams.get(i);
            int space = 20- o.getName().length();
            System.out.print(o.getName());
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            System.out.printf(" %2d %2d %2d %2d  %2d  %2d  %2d\n",o.getPoints(),o.getWins(),o.getDraws(), o.getDefeats(),o.getGoalsShot(),o.getGoalsReceived(),(o.getGoalsShot()-o.getGoalsReceived()));
        }
        System.out.println("\nPts...Points, W...Won, D...Draw, L...Lost");
        System.out.println("GF...Goals for, GA...Goals against, GD...Goal difference");

        return null;
    }
}
