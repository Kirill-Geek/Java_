import java.util.Arrays;
public class DZ_1_1 {
    
    public static void main(String[] args) {
        int[] A = new int[] { 1, 5, 9, 4, 3, 8, 7, 3, 10, 9, 2, 0 };
        heapsort(A);
        System.out.println(Arrays.toString(A));
    }

    // Функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapsort(int[] A) {
        // строим приоритетную очередь и инициализируем ее заданным массивом
        int n = A.length;

        // Build-heap: вызывать heapify, начиная с последнего внутреннего
        // узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(A, i--, n);
        }

        // несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            A[n - 1] = pop(A, n);
            n--;
        }
    }

    // Рекурсивный алгоритм heapify.
    private static void heapify(int[] A, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);

        int largest = i;
        // сравниваем `A[i]` с его левым и правым дочерними элементами
        // и находим наибольшее значение
        if (left < size && A[left] > A[i]) {
            largest = left;
        }

        if (right < size && A[right] > A[largest]) {
            largest = right;
        }

        // поменяться местами с потомком, имеющим большее значение и
        // вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }

    // вернуть левого потомка `A[i]`
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    // вернуть правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    // Вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] A, int size) {
        // если в куче нет элементов
        if (size <= 0) {
            return -1;
        }

        int top = A[0];

        // заменяем корень кучи последним элементом
        // массива
        A[0] = A[size - 1];

        // вызовите heapify на корневом узле
        heapify(A, 0, size - 1);

        return top;
    }
}

