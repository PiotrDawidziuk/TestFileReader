import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static void main(String[] args) {

        ArrayList<String> fruitWithNumbersList = new ArrayList<>();
        ArrayList<String> fruitList = new ArrayList<>();
        ArrayList<String> numbersList = new ArrayList<>();
        fruitWithNumbersList.add("Fruit with numbers:");


        try {
            File myObj = new File("file.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tempData = data.split(";");
                fruitList.add(tempData[0]);
                numbersList.add(tempData[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < fruitList.size(); i++) {
            fruitWithNumbersList.add("The number of "+fruitList.get(i)+" is "+numbersList.get(i));
        }
        for (String str : fruitWithNumbersList) {
            System.out.println(str);
        }

    }
}
