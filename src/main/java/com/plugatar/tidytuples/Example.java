package com.plugatar.tidytuples;

import com.plugatar.tidytuples.tuple.TupleOf;
import com.plugatar.tidytuples.tuple.TupleOf3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example {

    public static void methodOf3(Integer var1, Long var2, Double var3) {
        System.out.println("methodOf3");
    }

    public static String secondMethodOf3(Integer var1, Long var2, Double var3) {
        return "";
    }

    public static void main(String[] args) {
        // 1
        Tuple3<Integer, Long, Double> tuple3 = new TupleOf3<>(1, 2L, 3.0);

        tuple3.supplyTo(Example::methodOf3);
        String secondMethodResult = tuple3.applyTo(Example::secondMethodOf3);

        // 2
        List<Number> listOfNumbers = tuple3.applyTo(Arrays::asList);
        Stream<Number> streamOfNumbers = tuple3.applyTo(Stream::of);

        // 3
        Tuple<Number> tupleOfNumbers = tuple3.applyTo(TupleOf<Number>::new);
        Number[] arrayOfNumbers = tupleOfNumbers.asArray();

        // 4
        boolean equals = tupleOfNumbers.equals(tuple3); // true
    }
}
