import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {
    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        // nie działa dla doubli co mają takiego samego inigera
        //return (int) (o1.getPercentComplete() - o2.getPercentComplete());
        if (o1.getPercentComplete() < o2.getPercentComplete()) {
            return -1;
        } else if (o1.getPercentComplete() > o2.getPercentComplete()) {
            return 1;
        } else {
            return 0;
        }
    }
}
