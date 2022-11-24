package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLogicTask {
        public static int[][] getAnswer(int [][] arr){
        List<Integer> list1 = new ArrayList<Integer>();
        for (int elememt : arr[0]) {
            list1.add(elememt);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for (int elememt : arr[1]) {
            list1.add(elememt);
        }
        int [][] array = new int [3][Math.max(Math.max(arr[0].length, inList1XorInList2(list1,list2).toArray().length), arr[1].length)];
        int i = 0;
        int j = 0;
        int k = 0;
        for (int element : arr[0]){
            array[0][i] = element;
            i++;
        }
        for (int element : arr[1]){
            array[1][j] = element;
            j++;
        }
        for (int element : inList1XorInList2(list1,list2)){
            array[2][k] = element;
            k++;
        }
        return array;
    }
    public static List<Integer> inList1XorInList2(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new ArrayList<Integer>();
        for (int elememt1 : inList1NotInList2(list1, list2)){
            list.add(elememt1);
        }
        for (int elememt2 : inList2NotInList1(list1, list2)){
            list.add(elememt2);
        }
        return list;
    }
    public static List<Integer> inList1NotInList2(List<Integer> list1, List<Integer> list2){
        boolean flag = true;
        List<Integer> list = new ArrayList<Integer>();
        for (int elememt1 : list1){
            for (int elememt2 : list2){
                if (elememt1 != elememt2){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(elememt1);
            }
        }
        return list;
    }
    public static List<Integer> inList2NotInList1(List<Integer> list1, List<Integer> list2){
        boolean flag = true;
        List<Integer> list = new ArrayList<Integer>();
        for (int elememt2 : list2){
            for (int elememt1 : list1){
                if (elememt2 != elememt1){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(elememt2);
            }
        }
        return list;
    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    //метод для чтения и записи результата
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
