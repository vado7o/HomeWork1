import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        int num_list[] = {38, 22, 40, 44, 0, -5, 22, 99, 55, 33, 31, 37, 17, 57, 82};

        int size = num_list.length;  // получаем размер массива нашего

        int startIndex = (size / 2) - 1; // находим стартовый индекс

        for (int i = startIndex; i >= 0; i--) {
            movefunc(num_list, size, i);
        }

        for (int i=size-1; i>=0; i--) {          // производим сортировку кучи
            int temp = num_list[0];
            num_list[0] = num_list[i];
            num_list[i] = temp;

            movefunc(num_list, i, 0);
        }

        System.out.println(Arrays.toString(num_list));
    }

    public static void movefunc(int numlist[], int size, int i) {
        int root = i; // находим индекс родителя
        int left = 2 * i + 1; // находим индекс левого потомка
        int right = 2 * i + 2; // находим индекс правого потомка

        if (left < size && numlist[left] > numlist[root])   // если левый потомок больше чем родитель, то индекс родителя приравниваем к индексу левого потомка
            root = left;

        if (right < size && numlist[right] > numlist[root]) // если правый потомок больше чем родитель, то индекс родителя приравниваем к индексу правого потомка
            root = right;

        if (root != i) {                    // если получилось, что индекс родителя поменялся и теперь не равен стартовому индексу, то меняем местами родителя и потомка в массиве
            int temp = numlist[i];
            numlist[i] = numlist[root];
            numlist[root] = temp;

            movefunc(numlist, size, root);  // и продолжаем рекурсию
        }
    }
}