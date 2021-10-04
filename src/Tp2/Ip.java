package Tp2;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class Ip{

   public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean check(String ip) {

        String[] c = ip.split("\\.");

        // forme X.X.X.X
        if (c.length != 4) {
            return false;
        }

        // les points en fin de caractere
        if (ip.endsWith(".")) {
            return false;
        }

        if (c[0].equals("0")) {
            return false;
        }

       // verifie tous les adresses
        for (String s : c) {
            if (!isInteger(s)) {
                return false;
            }

            int value = Integer.parseInt(s);
            if ((value < 0) || (value > 255)) {
                return false;
            }
        }

        return true;
    }

    /*public static void testCheckIP() {

        String[] validIp = {"127.0.0.1",
                "127.231.1.1",
                "1.2.3.4"};

        String[] invalidIp = {"12.2.3",
                "12.3.213.123.123",
                "1231.12.2.3",
                ".1.2.3",
                "1.2.3.",
                "1.2..3",
                "0.1.2.3"};


        for (String ip : validIp) {
            if (!check(ip)) {
                System.out.println("erreur: " + ip);
            }
        }

        for (String ip : invalidIp) {
            if (check(ip)) {
                System.out.println("erreur: " + ip);
            }
        }

    }
    public static HashMap<Character, Character> createKey(int n, String alphabet) {

        HashMap<Character, Character> key = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            key.put(alphabet.charAt(i), alphabet.charAt((i + n) % alphabet.length()));
        }

        return key;
    }

    public static String encode(String text, HashMap<Character, Character> key) {
        String res = "";
        text = text.toLowerCase();
        for (String word : text.split(" ")) {
            for (char c : word.toCharArray()) {
                res += key.get(c);
            }
            res += " ";
        }
        return res.trim();
    }

    public static ArrayList<String> generateAllDecodings(String text, String alphabet) {
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < alphabet.length(); i++) {
            res.add(encode(text, createKey(i, alphabet)));
        }

        return res;
    }

    public static HashMap<String, Double> computeWordProbability(String filename) {

        List<String> lines = readLines(filename);

        HashMap<String, Double> proba = new HashMap<>();
        long nWords = 0;
        for (String line : lines) {

            String word = line.split("\t")[0];
            long count = Long.parseLong(line.split("\t")[1]);
            nWords += count;

            proba.put(word, (double) count);
        }

        for (String word : proba.keySet()) {
            proba.put(word, proba.get(word) / nWords);
        }

        proba.put("UNK", 1.0 / nWords);

        return proba;
    }

    public static ArrayList<String> readLines(String filename) {
        List<String> lines = null;
        try {
           lines = Files.readAllLines(Paths.get(filename), Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture de " + filename);
            System.exit(1);
        }
        return (ArrayList<String>) lines;
    }

    public static String decipher(ArrayList<String> candidates, HashMap<String, Double> wordProbability) {
        String bestSentence = "";
        double bestProba = 0.0;

        for (String hyp : candidates) {
            System.out.println(hyp + "-->" + proba(hyp, wordProbability));
            if (bestProba > proba(hyp, wordProbability)) {
                bestProba = proba(hyp, wordProbability);
                bestSentence = hyp;
            }
        }

        return bestSentence;
    }

    private static double proba(String sentence, HashMap<String, Double> wordProbability) {
        double res = 1.0;
        for (String word : sentence.split(" ")) {
            if (!wordProbability.containsKey(word)) {
                word = "UNK";
            }

            res *= wordProbability.get(word);
        }
        return res;
    }

    public static void main(String[] args) {
        String alphabet = ",abcdefghijklmnopqrstuvwxyz'";
        HashMap<Character, Character> key = createKey(5, alphabet);

        String s = encode("What else ?", key);
        HashMap<String, Double> wordProbability = computeWordProbability("texte_anglais.txt");
        System.out.println(decipher(generateAllDecodings(s, alphabet), wordProbability));
    }
}*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ton adresse ip: ");
        String ip = sc.next();
        System.out.println(check(ip));
    }
}