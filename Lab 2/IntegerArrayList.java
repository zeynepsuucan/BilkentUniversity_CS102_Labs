import java.util.Arrays;
import static java.util.Arrays.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class IntegerArrayList {

    ArrayList<IntegerArray> numbers = new ArrayList<IntegerArray>();

    public IntegerArrayList(ArrayList<String> numbersString) {
        for (int i = 0; i < numbersString.size(); i++) {
            IntegerArray newInt = new IntegerArray(numbersString.get(i));
            numbers.add(newInt);
        }
    }

    public int getSize() {
        return numbers.size();
    }

    public IntegerArray getIntegerArrayAt(int index) {
        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr) {
        numbers.set(index, intArr);
    }

    public void addIntegerArray(String number) {
        IntegerArray add2 = new IntegerArray(number);
        numbers.add(add2);
    }

    public void removeIntegerArray(String number) {
        IntegerArray add3 = new IntegerArray(number);
        numbers.remove(add3);
    }

    public void removeIntegerArray(IntegerArray intArr) {
        numbers.remove(intArr);
    }

    public IntegerArray min(int start, int end) {
        ArrayList<IntegerArray> numbers2 = new ArrayList<IntegerArray>();

        for (int i = start; i < end; i++) {
            numbers2.add(numbers.get(i));
        }

        Collections.sort(numbers2);
        return numbers2.get(0);
    }
}
