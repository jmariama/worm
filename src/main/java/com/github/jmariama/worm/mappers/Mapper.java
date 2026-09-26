package com.github.jmariama.worm.mappers;

//transforms one datatype to another
public interface Mapper<A, B> {
    B mapTo(A a);

    A mapFrom(B b);
}
