import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private int hitPoints;
    private String weapon;

    public Player(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.weapon = "sword";
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return  "name = " + name +
                ", hitPoints = " + hitPoints +
                ", weapon = " + weapon;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, ""+hitPoints);
        values.add(2, weapon);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues!=null && savedValues.size()>0){
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            weapon = savedValues.get(2);
        }
    }
}
