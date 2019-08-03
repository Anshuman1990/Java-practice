package com.language.collections.collection;

import com.language.collections.Employee;

import java.util.AbstractCollection;
import java.util.Iterator;

public class MyCollection<Employee> extends AbstractCollection<Employee> {
    @Override
    public Iterator<Employee> iterator() {

        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private class Itr implements Iterator<Employee>{

        @Override
        public boolean hasNext() {

            return false;
        }

        @Override
        public Employee next() {
            return null;
        }
    }
}
