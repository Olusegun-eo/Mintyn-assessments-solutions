package com.devskiller.repository;

import lombok.Data;

@Data(staticConstructor = "of")
public class Pair<X, Y> {

    private final X x;
    private final Y y;
}