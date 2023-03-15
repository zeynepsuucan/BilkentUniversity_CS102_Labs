import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class IntegerArrayTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the filename: ");
        String file = in.next();
        IntegerArrayList test = readArrayList(file);

        System.out.println("start index = 0 ");
        System.out.println("middle index = " + test.getSize() / 2);
        System.out.println("end index = " + (test.getSize() - 1));

        System.out.println("Minimum of all numbers: " + test.min(0, test.getSize() - 1));
        System.out.println("Minimum of the first half: " + test.min(0, (test.getSize() / 2) - 1));
        System.out.println("Minimum of the second half: " + test.min((test.getSize() / 2) - 1, test.getSize() - 1));

    }

    public static IntegerArrayList readArrayList(String fileName) {
        ArrayList<String> data2 = new ArrayList<String>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data2.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        IntegerArrayList numbers = new IntegerArrayList(data2);
        return numbers;
    }

}
