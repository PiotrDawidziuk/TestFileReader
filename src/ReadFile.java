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

        String splitter = ";";

        Scanner input  = new Scanner(System.in);
        System.out.println("What is the delimiter of your CSV file? ; or , (; being the default value)");
        splitter = input.next();
        if (!splitter.equals(",")){
            splitter = ";";
        }
        System.out.println("What file do you want to open? Include extension (.csv, .txt etc.)");
        String fileName = input.next();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.replace("\"", "");
                String[] tempData = data.split(splitter);
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
