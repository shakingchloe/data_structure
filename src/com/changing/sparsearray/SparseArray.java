package com.changing.sparsearray;



import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author changing
 * @create 2021-08-18 19:31
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建原数组
        int[][] chessArr1 = new int[11][11];
        int sum = 0;
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原来的二维数组：");
        for (int[] arr : chessArr1) {
            for (int row : arr) {
                System.out.print(row + "\t");
            }
            System.out.println();
        }

        //遍历数组，得到数组中的有效值
        int row = 0;
        int column = 0;
        for (int[] arr : chessArr1) {
            for (int td : arr) {
                if (td != 0) {
                    sum++;
                    int r1;
                    int l1;
                }
                column++;
            }
            row++;
        }
        //创建稀疏数组
        int[][] SparseArray = new int[sum + 1][3];

        //给稀疏数组的第一行赋值
        SparseArray[0][0] = row;
        SparseArray[0][1] = column / row;
        SparseArray[0][2] = sum;


        int row1 = 1;
        //遍历数组，得到有效值的位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column / row; j++) {
                if (chessArr1[i][j] != 0) {
                    SparseArray[row1][0] = i;
                    SparseArray[row1][1] = j;
                    SparseArray[row1++][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("对应的稀疏数组为：");
        for (int[] arr : SparseArray) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        FileWriter fw = null;
        try {
            File file = new File("map.data");
            fw = new FileWriter(file);
            for (int i = 0; i < SparseArray.length; i++) {
                if (i != SparseArray.length - 1) {
                    fw.write(SparseArray[i][0] + "," + SparseArray[i][1] + "," + SparseArray[i][2] + ",");
                } else {
                    fw.write(SparseArray[i][0] + "," + SparseArray[i][1] + "," + SparseArray[i][2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        FileReader fr = null;
        StringBuffer sbf = new StringBuffer();
        try {
            fr = new FileReader("map.data");
            int len;
            while ((len = (fr.read())) != -1) {
                sbf.append((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] str = sbf.toString().split(",");

        int[][] sparseArray2 = new int[str.length / 3][3];
        for (int i = 0, sum2 = 0; i < sparseArray2.length; i++) {
            for (int j = 0; j < 3; j++) {
                sparseArray2[i][j] = Integer.parseInt(str[sum2]);
                sum2++;
            }
        }

        System.out.println("文件读出的稀疏数组为：");
        for (int[] arr : sparseArray2) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }


//        /**
//         * 将稀疏数组恢复为对应数组
//         */
//        //得到对应原数组的行和列
//        int r = sparseArr[0][0];
//        int l = sparseArr[0][1];
//        int s = sparseArr[0][2];
//        int[][] chessArray2 = new int[r][l];
//        for(int i = 0;i < s;i++){
//            int r1 = sparseArr[i+1][0];
//            int l1 = sparseArr[i+1][1];
//            int val = sparseArr[i+1][2];
//            chessArray2[r1][l1] = val;
//        }
//        //输出恢复后的数组
//        System.out.println("恢复后的二维数组为：");
//        for(int[] arr : chessArray2){
//            for(int r1 : arr){
//                System.out.print(r1 + "\t");
//            }
//            System.out.println();
//        }
//
//    }


    }
}
