package main;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<String> asciiLetters = new ArrayList<String>();
        ArrayList<Integer> pass = new ArrayList<Integer>();
        String msg;

        System.out.println("Escreva uma mensagem a ser criptografada: ");
        msg = sc.nextLine();

        System.out.println();
        for(int i=1; i <= 5; i++) {
            System.out.print("Digite um digito ("+ i + "/5): ");
            pass.add(sc.nextInt());
        }

        for(int i = 0; i < msg.length(); i++) {
            letters.add(String.valueOf(msg.charAt(i)));
        }

        int counter = 0;

        for(int i = 0 ; i < letters.size(); i++) {
            if(counter == 5) {
                counter = 0;
            }
            if( i == letters.size() - 1 && (i+1) % 5 != 0) {
                asciiLetters.add(String.valueOf((char)(pass.get(counter) + (int)letters.get(i).charAt(0))));
                for(int j = 0; j < (5 - letters.size() % 5); j++) {
                    if(counter == 5)
                        counter = 0;
                    asciiLetters.add(String.valueOf((char)(pass.get(counter) + (int)" ".charAt(0))));
                    counter++;
                }
            } else {
                asciiLetters.add(String.valueOf((char)(pass.get(counter) + (int)letters.get(i).charAt(0))));
            }
            counter++;
        }

        System.out.println();
        System.out.println("Mensagem criptografada: " + String.join("", asciiLetters));
    }

}