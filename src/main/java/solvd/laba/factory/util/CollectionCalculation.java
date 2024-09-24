package solvd.laba.factory.util;

import java.util.Collection;

@FunctionalInterface
public interface CollectionCalculation<T extends Collection> {
    int calculate(T collection);
}
