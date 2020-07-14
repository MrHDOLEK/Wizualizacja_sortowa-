package sortvisualiser.algorithms;

import sortvisualiser.SortArray;

/**
*Sortowanie przez wybieranie
 * Algorytm zaczęrpniety z wikipedi
 */
public class SelectionSort implements ISortAlgorithm {

    private long stepDelay = 120;
    /**

     */
    @Override
    public void runSort(SortArray array) {
        int len = array.arraySize();
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array.getValue(j) < array.getValue(minIndex)) {
                    minIndex = j;
                }
            }
            array.swap(i, minIndex, getDelay(), true);
        }
    }

    @Override
    public String getName() {
        return "Sortowanie przez wybieranie";
    }

    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public void setDelay(long delay) {
        this.stepDelay = delay;
    }
}
