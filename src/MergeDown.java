public class MergeDown {

    public static long sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        long comparisons = sort(a, aux, 0, a.length-1);

        assert isSorted(a);
        return comparisons;
    }
    private static long sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        long comparisons = 0L;

        if (hi <= lo) return comparisons;
        int mid = lo + (hi - lo) / 2;

        comparisons += sort(a, aux, lo, mid);
        comparisons += sort(a, aux, mid + 1, hi);
        comparisons += merge(a, aux, lo, mid, hi);
        return comparisons;
    }
    public static long merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        long comparisons = 0L;

        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++)
            aux[k]=a[k];


        for (int k = lo; k <= hi; k++) {

            comparisons++;
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
        return comparisons;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < (hi - 1); ++i){
            if(!less(a[i], a[i + 1])) return false;
        }
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }
}
