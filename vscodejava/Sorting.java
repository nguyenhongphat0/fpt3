public class Sorting {
    static int[] a = {8, 1, 7, 6, 5};
    
    static void insertionSort() {
        int n = a.length;
        for (int i=1; i<n; i++) {
            int j = i-1;
            int t = a[i];
            while (j >= 0)
            if (t < a[j]) {
                a[j+1] = a[j];
                j--;
            } else break;
            a[j+1] = t;
        }
    }

    static void quickSort(int a[], int from, int to) {
        int pivot = (from + to)/2;
        int i = from, j = to, t;
        while (i <= j) {
            while (a[i] < a[pivot]) i++;
            while (a[j] > a[pivot]) j--;
            if (i <= j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        if (i < to) quickSort(a, i, to);
        if (from < j) quickSort(a, from, j);
    }

    static void printa() {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        printa();

        // sorting
        // insertionSort();
        quickSort(a, 0, a.length-1);

        printa();
    }   
}