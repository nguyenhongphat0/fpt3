/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatbookingsystem;

import java.util.Scanner;

/**
 *
 * @author Phat
 */

public class Reader // read data from stdin
{
    public static Scanner sc = new Scanner(System.in);

    public static String readAString(String prompt)
    {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    
    public static String readAString(String prompt, String regex) {
        String s;
        while (true) {
            System.out.print(prompt);
            s = sc.nextLine().trim();
            if (!s.matches(regex)) System.out.println("Invalid input. Re-input");
            else break;            
        }
        return s;
    }

    public static int readANumber(String prompt)
    {
        int x;
        while (true) 
        {
            try 
            {
                System.out.print(prompt);
                x = Integer.parseInt(sc.nextLine());
                break;
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input! Re-input");
            }
        }
        return x;
    }

    public static int readANumber(String prompt, int min)
    {
        int x;
        while (true) 
        {
            try 
            {
                System.out.print(prompt);
                x = Integer.parseInt(sc.nextLine());
                if (x >= min)
                {
                    break;
                }
                else
                {
                    System.out.println("Input can't be less than " + min +"! Re-input");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input! Re-input");
            }
        }
        return x;
    }

    public static int readANumber(String prompt, int min, int max)
    {
        int x;
        while (true) 
        {
            try 
            {
                System.out.print(prompt);
                x = Integer.parseInt(sc.nextLine());
                if (x >= min && x <= max)
                {
                    break;
                }
                else if (x < min)
                {
                    System.out.println("Input can't be less than " + min +"! Re-input");
                }
                else
                {
                    System.out.println("Input can't be greater than " + max + "! Re-input");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input! Re-input");
            }
        }
        return x;
    }

    public static double readARealNumber(String prompt, double min, double max)
    {
        double x;
        while (true) 
        {
            try 
            {
                System.out.print(prompt);
                x = Double.parseDouble(sc.nextLine());
                if (x > min && x < max)
                {
                    break;
                }
                else if (x <= min)
                {
                    System.out.println("Input must be greater than " + min +"! Re-input");
                }
                else
                {
                    System.out.println("Input must be less than " + max + "! Re-input");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input! Re-input");
            }
        }
        return x;
    }
}