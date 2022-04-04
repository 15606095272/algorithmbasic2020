package com.mashibing.algorithmbasic2020.class_07;

import java.util.*;

public class HeapGreater<T> {

    private ArrayList<T> heap;

    private Map<T, Integer> indexMap;

    private int heapSize;

    private Comparator<T> comparator;

    public HeapGreater(Comparator<T> comparator) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T value) {
        return indexMap.containsKey(value);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T value) {
        heap.add(value);
        indexMap.put(value, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T value) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(value);
        indexMap.remove(value);
        heap.remove(--heapSize);
        if (value != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T value) {
        heapInsert(indexMap.get(value));
        heapify(indexMap.get(value));
    }

    public List<T> getElements() {
        List<T> ans = new ArrayList<>();
        for (T value : heap) {
            ans.add(value);
        }
        return ans;
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int best = (left + 1) < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0
                    ? left + 1 : left;

            if (comparator.compare(heap.get(best), heap.get(index)) > 0) {
                break;
            }
            swap(best, index);
            index = best;
            left = index * 2 + 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }
}
