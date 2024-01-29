package com.practice.java8_17.language.lambda;

import java.util.Spliterator;
import java.util.function.Consumer;

public class ArraySpliterator implements Spliterator<String> {
    @Override
    public boolean tryAdvance(Consumer<? super String> consumer) {
        return false;
    }

    @Override
    public void forEachRemaining(Consumer<? super String> consumer) {
        
    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
