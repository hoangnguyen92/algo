package problemsolver;

public class DSF {
    public static void main(String[] args) {
        int[][] map = {{-1, 0, 0, 0},
                {0, 0, 0, -2}};

        int[][] result = findPath(map);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findPath(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        dfs(map, 0, 0, 0, visited);
        return map;
    }

    private static void dfs(int[][] map, int row, int col, int depth, boolean[][] visited) {
        if (!isValid(map, row, col)) {
            return;
        }
        if (map[row][col] == -2)
            return;

        if (visited[row][col]) {
            if (map[row][col] > 0) {
                map[row][col] = Math.min(map[row][col], depth);
            }
            return;
        }
        if (map[row][col] == 0) {
            map[row][col] = depth;
            visited[row][col] = true;
        }

        dfs(map, row - 1, col, depth + 1, visited);
        dfs(map, row, col + 1, depth + 1, visited);
        dfs(map, row + 1, col, depth + 1, visited);
        dfs(map, row, col - 1, depth + 1, visited);

        dfs(map, row + 1, col + 1, depth + 1, visited);
        dfs(map, row - 1, col - 1, depth + 1, visited);
        dfs(map, row - 1, col + 1, depth + 1, visited);
        dfs(map, row + 1, col - 1, depth + 1, visited);

    }

    private static boolean isValid(int[][] map, int row, int col) {
        return row < map.length && row > -1 && col > -1 && col < map[0].length;
    }
}
