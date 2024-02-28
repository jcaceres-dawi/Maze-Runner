package Dificultad6kyu;

public class MazeRunner {
    public static void main(String[] args) {
        int[][] maze = {
                { 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 3 },
                { 1, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 1 },
                { 1, 2, 1, 0, 1, 0, 1 } };
        System.out
                .println(walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S" }));
    }

    public static String walk(int[][] maze, String[] directions) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        int position = maze[x][y];
        String status = "";

        for (int i = 0; i < directions.length; i++) {
            if (directions[i].equals("N")) {
                if (x > 0) {
                    position = maze[x - 1][y];
                    x--;
                } else {
                    return status = "Dead";
                }
                status = status(position);
                if (status != "") {
                    return status;
                }
            } else if (directions[i].equals("S")) {
                if (x < maze.length - 1) {
                    position = maze[x + 1][y];
                    x++;
                } else {
                    return status = "Dead";
                }
                status = status(position);
                if (status != "") {
                    return status;
                }
            } else if (directions[i].equals("E")) {
                if (y < maze.length - 1) {
                    position = maze[x][y + 1];
                    y++;
                } else {
                    return status = "Dead";
                }
                status = status(position);
                if (status != "") {
                    return status;
                }
            } else if (directions[i].equals("W")) {
                if (y > 0) {
                    position = maze[x][y - 1];
                    y--;
                } else {
                    return status = "Dead";
                }

                status = status(position);
                if (status != "") {
                    return status;
                }
            }
        }
        if (status == "") {
            status = "Lost";
        }
        return status;
    }

    public static String status(int position) {
        if (position == 3) {
            return "Finish";
        } else if (position == 1) {
            return "Dead";
        } else {
            return "";
        }
    }
}
