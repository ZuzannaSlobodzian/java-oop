public class Node extends ListItem{


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return nextValue;
    }

    @Override
    ListItem previous() {
        return previousValue;
    }

    @Override
    ListItem setNextValue(ListItem item) {
        nextValue = item;
        return nextValue;
    }

    @Override
    ListItem setPreviousValue(ListItem item) {
        previousValue = item;
        return previousValue;
    }

    @Override
    int compareToItem(ListItem item){
        if(item!=null){
            return ((String)super.getValue()).compareTo((String)item.getValue());
        }
        else{
            return -1;
        }
    }
}
