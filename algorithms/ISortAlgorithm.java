package sortvisualiser.algorithms;

import sortvisualiser.SortArray;

/**
 * Obiekt stanowi bufor opoznienia miedzy algorytmami a ui.
 *
 *
 */
public interface ISortAlgorithm {
    public String getName();

    public long getDelay();

    public void setDelay(long delay);

    public void runSort(SortArray array);
}
