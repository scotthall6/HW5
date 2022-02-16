/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author bobgils
 */
public class StringConverterTest {
    public static void main(String[] args)throws Exception{

        File numFile = new File("NumberStrings.txt");
        Scanner inp = new Scanner(numFile);
        PrintWriter outp = new PrintWriter("NumberStringsConverted.txt");
        int ival;

        String numString;
        while (inp.hasNext()){
            numString = inp.next();
            try{
                ival = StringConverter.convert(numString);
                outp.printf("Value of \"%s\" is %d %n", numString, ival);
            }
            catch (RuntimeException ex){
                outp.println(ex.getMessage());
            }
        }
        outp.close();

    }
}