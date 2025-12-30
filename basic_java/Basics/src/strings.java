import java.util.*;

//this contains string related codes:
// hashmap || palindrome || anagram || Longest and shortest word || Alphanumeric check ||

public class strings {
    public static void main(String[] args) {

        System.out.println("_______________________________________________________________!");

        //I was asked to code find the all occurance of the letters of string given - ' AMBASAMUDRAM '

        String input = "AMBASAMUDRAM";
        Map<Character, Integer> mapped = new HashMap<>();
        for (char c : input.toCharArray()){
            mapped.put(c,mapped.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> outie : mapped.entrySet()){
            System.out.println(outie.getKey() + "->"+ outie.getValue());
        }

        System.out.println("_______________________________________________________________!");
        System.out.println("!");

        // find whether the given string is palindrome or not ||
        //REVERSE THE GIVEN STRING

        String given = "MADAM";
        String reverse ="";
        for(int i = given.length() -1; i>=0;i--){
            reverse+=given.charAt(i);
        }
        System.out.println("Reverse word :"  + reverse);
        if (given.equals(reverse)){
            System.out.println("It is palindrome");
        }else{
            System.out.println("It is not palindrome");
        }

        System.out.println("_______________________________________________________________!");
        System.out.println("!");

        // Find the given two string is ANAGRAM or not

        String s1="Debit card";
        String s2="bad credit";

        s1=s1.replaceAll("\\s","").toLowerCase();
        s2=s2.replaceAll("\\s","").toLowerCase();

        char[] s1Arry=s1.toCharArray();
        char[] s2Arry=s2.toCharArray();
        Arrays.sort(s1Arry);
        Arrays.sort(s2Arry);
        if(Arrays.equals(s1Arry, s2Arry)){
            System.out.println("It is Anagram");
        }else{
            System.out.println("Not Anagram");
        }


        System.out.println("_______________________________________________________________!");
        System.out.println("!");

        //Find the smallest and largest word in sentence given :

        String sentence1 = "Ias love languages Java i ";
        System.out.println("Given sentence is : " + sentence1);
        String[] wordsarr = sentence1.split("\s");
        String longWord="";
        String smallWord=wordsarr[0];
        for(String word : wordsarr) {
            if (word.length() > longWord.length()) {
                longWord = word;
            }
            if(word.length() < smallWord.length()){
                smallWord=word;
            }
        }
        System.out.println("Longest word: " + longWord);
        System.out.println("Smallest word:" + smallWord);

        System.out.println("_______________________________________________________________!");
        System.out.println("!");

        //to check the given string is alpanumeric or not

        String alphanum = "Arun23ksuk23";
        boolean alpha_yes = true;
        for (char c : alphanum.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                alpha_yes = false;
                break;
            }
        }
        System.out.println("Given is - " + alphanum + " - It is " + alpha_yes);

        System.out.println("_______________________________________________________________!");
        System.out.println("!");

    }
}