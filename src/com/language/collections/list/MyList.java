package com.language.collections.list;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyList<E> extends AbstractList<E> implements  List<E>{
    public static void main(String[] args) {
        System.out.println("Test");

    }


    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> consumer) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean removeIf(Predicate<? super E> predicate) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> unaryOperator) {

    }

    @Override
    public void sort(Comparator<? super E> comparator) {

    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }
}
