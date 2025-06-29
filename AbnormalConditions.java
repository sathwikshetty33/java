import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AbnormalConditions {
public static void main(String[] args) {
try {
generateNumberFormatException();
} catch (NumberFormatException e) {
System.out.println("Caught NumberFormatException");
// e.printStackTrace();
}
try {
generateStackOverflowError(1);
} catch (StackOverflowError e) {
System.out.println("Caught StackOverflowError");
// e.printStackTrace();
}
try {
generateOutOfMemoryError();
} catch (OutOfMemoryError e) {
System.out.println("Caught OutOfMemoryError");
// e.printStackTrace();
}
try{
    generateClassCastException();
}
catch(ClassCastException e){
    System.out.println("Caught class cast exception");
}
try {
    generateFileNotFoundException();
}
catch(FileNotFoundException e){
    System.out.println("File not found");
}
}
private static void generateNumberFormatException() {
// This will throw NumberFormatException
String invalidNumber = "abc";
int number = Integer.parseInt(invalidNumber);
}
private static void generateStackOverflowError(int depth) {
// This recursive call will eventually throw StackOverflowError
generateStackOverflowError(depth + 1);
}
private static void generateOutOfMemoryError() {
// This will throw OutOfMemoryError
Object[] array = new Object[1000000];
for (int i = 0; i < array.length; i++) {
array[i] = new byte[1024 * 1024]; 
}
}
private static void generateClassCastException(){
    Object obj = "helllo";
    Integer i = (Integer) obj;
}
private static void generateFileNotFoundException()throws FileNotFoundException{
    File file = new File("does_not_exist.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                continue;
            }
}
}