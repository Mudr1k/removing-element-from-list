import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class RemoveFromListExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        currentStateList(list);
        removeWithFori(list);

        currentStateList(list);
        removeWithIter(list);

        currentStateList(list);
        removeWithOwnIterator(list);

        currentStateList(list);
    }

    private static void removeWithFori(ArrayList<Integer> list) {
        System.out.println("пробую удалять все элементы листа кратные 2 с помощью метода remove() в цикле fori ");
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if (curr % 2 == 0) {
                System.out.println(curr + " % 2 == 0 -> remove done");
                list.remove(i--);
            }
        }
        completeTask();
    }

    private static void removeWithIter(ArrayList<Integer> list) {
        System.out.println("пробую удалять все элементы листа кратные 3 с помощью метода remove() в цикле iter ");
        try {
            for (Integer integer : list) {
                if (integer % 3 == 0) {
                    System.out.println(integer + " % 3 == 0 -> remove done");
                    list.remove(integer);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException -> exit from iter");
        }
        completeTask();
    }

    private static void removeWithOwnIterator(ArrayList<Integer> list) {
        System.out.println("пробую удалять все элементы листа равные 1 или 7 с помощью метода remove() в новом созданном итераторе ");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == 1 || next == 7) {
                System.out.println(next + " == " + next + " -> remove done");
                iterator.remove();
            }
        }
        completeTask();
    }

    private static void currentStateList(ArrayList<Integer> list) {
        System.out.println("---------------------------");
        System.out.println("текущее состояние листа: " + list);
        System.out.println("---------------------------");
    }

    private static void completeTask() {
        System.out.println("done!");
    }
}
