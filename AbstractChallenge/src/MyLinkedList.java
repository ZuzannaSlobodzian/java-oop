public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addValue(ListItem item) {
        if(root == null) {
            root = item;
            return true;
        }

        ListItem currentItem = root;
        while(currentItem!=null){
            int comparsion = currentItem.compareToItem(item);
            if(comparsion<0){
                if(currentItem.next()!=null){
                    currentItem = currentItem.next();
                }else {
                    item.setPreviousValue(currentItem);
                    currentItem.setNextValue(item);
                    return true;
                }
            }else if(comparsion > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNextValue(item);
                    item.setPreviousValue(currentItem.previous());
                    item.setNextValue(currentItem);
                    currentItem.setPreviousValue(item);
                } else {
                    root = item;
                    root.setNextValue(currentItem);
                    currentItem.setPreviousValue(root);

//                    probably the same as:

//                    item.setNextValue(root);
//                    root.setPreviousValue(item);
//                    root = item;
                }
                return true;
            }else{
                System.out.println("The item is duplicated, so has not been added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeValue(ListItem item) {
        if (root == null){
            System.out.println("The list is already empty");
        }
        else {
            ListItem currentItem = root;
            while (currentItem != null) {
                int comparsion = currentItem.compareToItem(item);
                if (comparsion == 0) {
                    if (currentItem == root) {
                        root = currentItem.next();
                    } else {
                        currentItem.previous().setNextValue(currentItem.next());
                        if (currentItem.next() != null)
                            currentItem.next().setPreviousValue(currentItem.previous());
                    }
                    return true;
                } else if (comparsion < 0) {
                    currentItem = currentItem.next();
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null)
            System.out.println("The list is empty");
        else {
            ListItem currentItem = root;
            while (currentItem != null) {
                System.out.println((String) currentItem.getValue());
                currentItem = currentItem.next();
            }
        }
    }
}
