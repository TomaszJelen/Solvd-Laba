package solvd.laba.factory.organisation;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface DataSending {
    public default void sendData(Consumer<String> sendingFunction, Supplier<String> createData) {
        sendingFunction.accept(createData.get());
    }
}
