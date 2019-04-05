/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kickstart2019;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author FAITH.A
 */
public class Training {
    
    public static int getTestHours(int studentNo, Map<Integer, Integer> students, int teamNo) {
        
        LinkedHashMap<Integer, Integer> sortedStudents = new LinkedHashMap<>();
        students.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(x -> sortedStudents.put(x.getKey(), x.getValue()));
        
        System.out.println(sortedStudents.toString());
        
        for (int score : sortedStudents.keySet()) {
            int number = sortedStudents.get(score);
            if(number >= teamNo) {
                return 0;
            }
                
            // int tempSum2 = S[i] + number;
            // sumIsFactor = (tempSum2 % k) == 0;

            // if(sumIsFactor == true) break here;

        }
        return teamNo;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        
        for(int i = 0; i < testCase; i++) {
            int studentNo = scanner.nextInt();
            int teamNo = scanner.nextInt();
            
            Map<Integer, Integer> students = new HashMap<Integer, Integer>();
            
            for(int j = 0; j < studentNo; j++) {
                int value = scanner.nextInt();
                int count = 0;
                if(students.containsKey(value)) {
                    count = students.get(value);
                    count++;
                } else {
                    count = 1;
                }
                students.put(value, count);
            }
            int noOfHours = getTestHours(studentNo, students, teamNo);
            System.out.println("Case #" + (i+1) + ": " + noOfHours);
        }
    }
}
