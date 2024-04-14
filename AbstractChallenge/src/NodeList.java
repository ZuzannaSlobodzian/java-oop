public interface NodeList {
    ListItem getRoot();
    boolean addValue(ListItem item);
    boolean removeValue(ListItem item);
    void traverse(ListItem root);
}
