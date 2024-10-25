import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ans = 0;
        String user = ""; // Cambia aqui el usuario de tu systema operativo linux
        try {
            String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            File myObj = new File(String.format("/home/%s/Documents/GitHub/AdventOfCode/src/input.txt", user));
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();  // Lee la línea solo una vez
                String first = null;
                String last = null;

                
                // Encontrar el primer número en la línea
                for (int i = 0; i < line.length(); i++) {  
                    String currentChar = line.substring(i, i + 1);
                    for (String number : numbers) {
                        if (currentChar.equals(number)) {
                            first = currentChar;
                            break;
                        }
                    }
                    if (first != null) break;  // Sale del ciclo si ya encontró el primer número
                }

                // Encontrar el último número en la línea
                for (int i = line.length() - 1; i >= 0; i--) {  
                    String currentChar = line.substring(i, i + 1);
                    for (String number : numbers) {
                        if (currentChar.equals(number)) {
                            last = currentChar;
                            break;
                        }
                    }
                    if (last != null) break;  // Sale del ciclo si ya encontró el último número
                }
                
                String temp = (first != null && last != null) ? first + last : "No numbers found";
                System.out.println(temp);
                ans += Integer.parseInt(temp);
                System.out.println("ans: " + ans);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
