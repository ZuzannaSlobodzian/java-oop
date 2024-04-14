public abstract class ListItem {

    protected ListItem nextValue = null;
    protected ListItem previousValue = null;

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem previous();
    abstract ListItem setNextValue(ListItem item);
    abstract ListItem setPreviousValue(ListItem item);

    abstract int compareToItem(ListItem item);


}
