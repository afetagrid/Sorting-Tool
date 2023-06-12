package sorting;

import java.util.*;

public class Main {
    private static void readsLongs() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        long maxNumber = 0;
        int maxNumberCount = 0;
        if (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            count++;
            maxNumber = number;
            maxNumberCount = 1;
        }
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            count++;
            if (number > maxNumber) {
                maxNumber = number;
                maxNumberCount = 1;
            } else if (number == maxNumber) {
                maxNumberCount++;
            }
        }
        System.out.println("Total numbers: " + count + '.');
        System.out.println("The greatest number: " + maxNumber +
                " (" + maxNumberCount + " time(s), " + maxNumberCount * 100 / count  +"%).");
    }
    private static void readsLines() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String maxLengthLine = null;
        int maxLengthLineCount = 0;
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count++;
            maxLengthLine = line;
            maxLengthLineCount = 1;
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count++;
            if (line.length() > maxLengthLine.length()) {
                maxLengthLine = line;
                maxLengthLineCount = 1;
            } else if (line.length() == maxLengthLine.length()) {
                if (line.compareTo(maxLengthLine) < 0) {
                    maxLengthLine = line;
                    maxLengthLineCount = 1;
                } else if (line.compareTo(maxLengthLine) == 0){
                    maxLengthLineCount++;
                }
            }
        }
        System.out.println("Total lines: " + count + '.');
        System.out.println("The longest line:\n" + maxLengthLine +
                "\n(" + maxLengthLineCount + " time(s), " + maxLengthLineCount * 100 / count  +"%).");
    }
    private static void readsWords() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String maxLengthWord = null;
        int maxLengthWordCount = 0;
        if (scanner.hasNext()) {
            String word = scanner.next();
            count++;
            maxLengthWord = word;
            maxLengthWordCount = 1;
        }
        while (scanner.hasNext()) {
            String word = scanner.next();
            count++;
            if (word.length() > maxLengthWord.length()) {
                maxLengthWord = word;
                maxLengthWordCount = 1;
            } else if (word.length() == maxLengthWord.length()) {
                if (word.compareTo(maxLengthWord) < 0) {
                    maxLengthWord = word;
                    maxLengthWordCount = 1;
                } else if (word.compareTo(maxLengthWord) == 0){
                    maxLengthWordCount++;
                }
            }
        }
        System.out.println("Total words: " + count + '.');
        System.out.println("The longest word: " + maxLengthWord +
                " (" + maxLengthWordCount + " time(s), " + maxLengthWordCount * 100 / count  +"%).");
    }


    private static void sortIntegers() {
        Scanner scanner = new Scanner(System.in);
        List<Long> integers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            integers.add(number);
        }
        integers.sort(Comparator.naturalOrder());
        System.out.println("Total numbers: " + integers.size() + '.');
        System.out.print("Sorted data: ");
        integers.forEach(x -> System.out.print(x + " "));
    }


    public static void main(final String[] args) {
        for (String arg : args) {
            if (arg.equals("-sortIntegers")) {
                sortIntegers();
                return;
            }
        }
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-dataType")) {
                switch (args[i + 1]) {
                    case "long":
                        readsLongs();
                        break;
                    case "line":
                        readsLines();
                        break;
                    case "word":
                        readsWords();
                        break;
                    default:
                        System.out.println("Wrong argument");
                }
                return;
            }
        }
        if (args.length == 1 && args[0].equals("-dataType")) {
            readsWords();
        }
    }
}
