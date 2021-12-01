package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        initFile();
        List<Integer> depths = initFile();

        // Part one
        int positiveChanges = part_one(depths);
        System.out.println("Part One: " + positiveChanges);

        // Part two
        positiveChanges = part_two(depths);
        System.out.println("Part Two: " + positiveChanges);

        // 74 MS @ 4770K
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }

    public static List<Integer> initFile() {
        List<Integer> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream("src/day1/input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int part_one(List<Integer> list) {
        int depthsIncrease = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                depthsIncrease++;
            }
        }
        return depthsIncrease;
    }

    public static int part_two(List<Integer> list) {
        int depthsIncrease = 0;
        for (int i = 0; i < list.size() - 3; i++) {
            if (list.get(i) + list.get(i + 1) + list.get(i + 2) < list.get(i + 1) + list.get(i + 2) + list.get(i + 3)) {
                depthsIncrease++;
            }
        }
        return depthsIncrease;
    }
}

