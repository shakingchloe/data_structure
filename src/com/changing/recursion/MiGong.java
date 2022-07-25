package com.changing.recursion;

/**
 * @author changing
 * @create 2021-08-23 18:44
 */
public class MiGong {
    public static void main(String[] args) {
//        Map.printMap();
        int[][] maze = Maze.getMaze();
        System.out.println("原迷宫：");
        Maze.printMap();
        System.out.println("迷宫通路：");
        MazePath.setWay(maze,1,1);
        Maze.printMap();
    }
}

class MazePath{
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i + 1,j)){
                    return true;
                }else if(setWay(map,i,j + 1)){
                    return true;
                }else if(setWay(map,i - 1,j)){
                    return true;
                }else if(setWay(map,i,j- 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}

class Maze{
    private static int[][] maze = new int[8][7];

    public static int[][] getMaze(){
        return maze;
    }
    static{
        for(int i = 0;i < maze[1].length;i++){
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        for(int i = 0;i < maze.length;i++){
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        maze[3][1] = 1;
        maze[3][2] = 1;
    }

    public static void printMap(){
        for(int[] i : maze){
            for(int n : i){
                System.out.print(n + "   ");
            }
            System.out.println();
        }
    }

}