import java.util.List;

public class PrintGenericList<T> {
    public void printToConsole(List<T> items) {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}
