package dev.fabianromero.functionalprogramming.genericexamples.nonreifiabletypes;

import java.lang.reflect.Array;
import java.util.List;

public class ArrayStuff {

    @SuppressWarnings("unchecked") //Because there is no generic version of Array.newInstance()
    public <E> E[] getAsArray(List<E> strings, Class<? super E> type) {
        //Not possible because E is a non reifiable type, you can't instantiate. E is type-erased
        //return new E[]{};
        E[] array = (E[]) Array.newInstance(type, strings.size());
        for (int i = 0; i < strings.size(); i++) {
            array[i] = strings.get(i);
        }
        return array;
    }

    //Leaving this here as an option
//    public <F, E extends F> F[] getAsArray(List<E> strings, Class<F> type) {
//        //Not possible because E is a non reifiable type, you can't instantiate. E is type-erased
//        //return new E[]{};
//        F[] array = (F[]) Array.newInstance(type, strings.size());
//        for (int i = 0; i < strings.size(); i++) {
//            array[i] = strings.get(i);
//        }
//        return array;
//    }
}
