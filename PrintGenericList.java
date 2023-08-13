import java.util.List;

public class PrintGenericList<T> {
    public void printList(List<T> items) {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}
