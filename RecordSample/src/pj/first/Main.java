package pj.first;

interface Player{
    String name();
}

record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position)implements Player{}
record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + "in" + countryCode + ")";
    }
}
public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, Pa", "US");
        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Huston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        Team<FootballPlayer, Affiliation> afc = new Team<>("Adeline Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
    }

    public static void scoreResult(Team team1, int t1Score,
                                   Team team2, int t2Score){

        String message = team1.setScore(t1Score, t2Score);
        // useless, but as per Tim
        // team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}