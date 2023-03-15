
public class IntegerArray implements Comparable<IntegerArray> {

    int a = 0;
    boolean isNeg = true;
    boolean b = true;
    public int[] array;
    String print = "";
    boolean isZero;
    boolean resultisZero = false;

    public IntegerArray(String a) {
        int num = 0;
        String a2;

        if (a.substring(0, 1).equals("-")) {
            isNeg = true;
            a = a.substring(1);
        }

        else
            isNeg = false;

        for (int i = 0; i < a.length(); i++) {
            if (a.substring(i, i + 1).equals("0")) {
                num++;

            }

            else
                break;
        }

        a2 = a.substring(num);

        if (a2.length() == 0) {
            array = new int[1];
            array[0] = 0;
            isZero = true;
        } else {

            array = new int[a2.length()];
            for (int i = 0; i < a2.length(); i++) {
                array[i] = Integer.parseInt(a2.substring(i, i + 1));
            }
        }

    }

    public int numberOfDigits() {
        return this.array.length;
    }

    public void makePositive() {
        isNeg = false;

    }

    public boolean getIsNeg() {
        return isNeg;
    }

    public int MID() {
        return this.array[0];
    }

    public int LID() {
        return this.array[numberOfDigits() - 1];
    }

    public int getDigit(int index) {
        return this.array[index];
    }

    public void setDigit(int num, int digit) {
        this.array[digit] = num;
    }

    public IntegerArray getNewArray(int a, int b) {
        String str = "";
        for (int i = a; i < b; i++) {
            str += this.getDigit(i);
        }
        IntegerArray newArray = new IntegerArray(str);
        return newArray;

    }

    public IntegerArray add(IntegerArray other) {
        if (this.isZero == true && other.isZero == true) {
            IntegerArray zero = new IntegerArray("0");
            resultisZero = true;
            return zero;
        }

        if (this.compareTo(other) == 0) {
            IntegerArray zero = new IntegerArray("0");
            resultisZero = true;
            return zero;
        }

        // adds the two arrays (without turning them to integers)
        if ((this.getIsNeg() == true && other.getIsNeg() == false
                || this.getIsNeg() == false && this.getIsNeg() == true) && b == true) {
            b = false;
            return this.substract(other);
        }

        else {
            if (this.getIsNeg() == true)
                print += "-";

            if (this.numberOfDigits() >= other.numberOfDigits()) { // if the original array is longer than the other
                                                                   // array

                String StringAdded = ""; // using an empty string to create an integer array containing the added
                                         // numbers

                int digit = 0;

                for (int i = this.numberOfDigits() + 1, t = this.numberOfDigits(),
                        o = other.numberOfDigits(); i > 0; i--, t--, o--) { // for putting each added number from right
                                                                            // to
                                                                            // left
                    int addedDigit = 0;

                    if (o > 0)
                        addedDigit = this.getNewArray(0, t).LID() + other.getNewArray(0, o).LID();

                    else {
                        if (t > 0)
                            addedDigit = this.getNewArray(0, t).LID();
                        else
                            addedDigit = 0;
                    }

                    if (addedDigit + digit < 10) {
                        StringAdded += "" + (digit + addedDigit);
                        digit = 0;
                    } else if (addedDigit + digit == 10) {
                        StringAdded += "" + "0";
                        digit = 1;
                    } else {
                        StringAdded += "" + (digit + addedDigit % 10);
                        digit = addedDigit / 10;
                    }

                }
                String strAddedRvs = "";
                for (int i = StringAdded.length() - 1; i >= 0; i--) {
                    strAddedRvs += StringAdded.charAt(i);
                }

                IntegerArray addedArray = new IntegerArray(strAddedRvs);

                // creating the empty added array
                return addedArray;

            }

            else {
                return other.add(this);
            }
        }
    }

    public IntegerArray substract(IntegerArray other) { // adds the two arrays (without turning them to integers)

        if ((this.getIsNeg() == true && other.getIsNeg() == false
                || this.getIsNeg() == false && this.getIsNeg() == true) && b == true) {
            b = false;
            return this.add(other);
        } else {
            if (this.compareTo(other) > 0) {
                print += "-";
            }

            if (this.numberOfDigits() > other.numberOfDigits()) { // if the original array is longer than the other
                                                                  // array
                String StringSubstracted = ""; // using an empty string to create an integer array containing the
                                               // substracted numbers

                int digit = 0;

                for (int t = this.numberOfDigits(), o = other.numberOfDigits(); t > 0; t--, o--) { // for putting each
                                                                                                   // substracted
                                                                                                   // number from
                    // right to left
                    int substractedDigit = 0;

                    if (o > 0)
                        substractedDigit = this.getNewArray(0, t).LID() - other.getNewArray(0, o).LID();

                    else
                        substractedDigit = this.getNewArray(0, t).LID();

                    if (substractedDigit - digit >= 0) {
                        StringSubstracted += (substractedDigit - digit);
                        digit = 0;
                    } else {
                        StringSubstracted += (substractedDigit + 10 - digit);
                        digit = 1;
                    }

                }
                String strRvs = "";
                for (int i = StringSubstracted.length() - 1; i >= 0; i--) {
                    strRvs += StringSubstracted.charAt(i);
                }

                IntegerArray substracted = new IntegerArray(strRvs);

                // creating the empty added array
                return substracted;
            }

            {
                if (other.numberOfDigits() > this.numberOfDigits()) {
                    print += "-";
                    resultisZero = true;

                    return other.substract(this);
                }

                else {

                    int i = 0;
                    while (this.getDigit(i) == other.getDigit(i) && i < this.numberOfDigits()) {
                        i++;
                    }
                    if (i == this.numberOfDigits()) {
                        IntegerArray zero = new IntegerArray("0");
                        return zero;
                    }

                    if (this.getDigit(i) > other.getDigit(i)) {

                        String StringSubstracted = ""; // using an empty string to create an integer array containing
                                                       // the
                        // substracted numbers

                        int digit = 0;

                        for (int t = this.numberOfDigits(), o = other.numberOfDigits(); t > 0; t--, o--) { // for
                                                                                                           // putting
                                                                                                           // each
                            // substracted
                            // number from
                            // right to left
                            int substractedDigit = 0;

                            if (o > 0)
                                substractedDigit = this.getNewArray(0, t).LID() - other.getNewArray(0, o).LID();

                            else
                                substractedDigit = this.getNewArray(0, t).LID();

                            if (substractedDigit - digit >= 0) {
                                StringSubstracted += (substractedDigit - digit);
                                digit = 0;
                            } else {
                                StringSubstracted += (substractedDigit + 10 - digit);
                                digit = 1;
                            }

                        }
                        String strRvs = "";
                        for (int j = StringSubstracted.length() - 1; j >= 0; j--) {
                            strRvs += StringSubstracted.charAt(j);
                        }

                        IntegerArray substracted = new IntegerArray(strRvs);

                        // creating the empty added array
                        return substracted;
                    }

                    else {
                        print += "-";
                        String StringSubstracted = ""; // using an empty string to create an integer array containing
                                                       // the
                        // substracted numbers

                        int digit = 0;

                        for (int t = other.numberOfDigits(), o = this.numberOfDigits(); t > 0; t--, o--) { // for
                                                                                                           // putting
                                                                                                           // each
                            // substracted
                            // number from
                            // right to left
                            int substractedDigit = 0;

                            if (o > 0)
                                substractedDigit = other.getNewArray(0, t).LID() - this.getNewArray(0, o).LID();

                            else
                                substractedDigit = other.getNewArray(0, t).LID();

                            if (substractedDigit - digit >= 0) {
                                StringSubstracted += (substractedDigit - digit);
                                digit = 0;
                            } else {
                                StringSubstracted += (substractedDigit + 10 - digit);
                                digit = 1;
                            }

                        }
                        String strRvs = "";
                        for (int j = StringSubstracted.length() - 1; j >= 0; j--) {
                            strRvs += StringSubstracted.charAt(j);
                        }

                        IntegerArray substracted = new IntegerArray(strRvs);

                        // creating the empty added array
                        return substracted;

                    }
                }
            }
        }

    }

    public boolean equals(IntegerArray other) {
        return true;
    }

    public String toString() {
        // if (resultisZero = true)
        // return "0";
        print = "";

        for (int i = 0; i < numberOfDigits(); i++) {

            print += getDigit(i);
        }

        return print;
    }

    @Override
    public int compareTo(IntegerArray o) {
        if (this.numberOfDigits() < o.numberOfDigits())
            return -1;
        if (this.numberOfDigits() > o.numberOfDigits())
            return 1;
        else {
            int i = 0;
            while (i < this.numberOfDigits() && this.getDigit(i) == o.getDigit(i)) {
                i++;
            }
            if (i == this.numberOfDigits()) {
                return 0;
            }
            if (this.getDigit(i) > o.getDigit(i)) {
                return 1;
            } else
                return -1;
        }
    }

}
