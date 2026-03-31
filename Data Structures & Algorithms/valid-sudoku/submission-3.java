class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> sq = new HashMap<>();
        String b;

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;

                b = r/3 + "," + c/3;

                if (row.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                    || col.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || sq.computeIfAbsent(b, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                    }

                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);
                sq.get(b).add(board[r][c]);
            }
        }

        return true;
    }
}

/*

map {1, [[1,1], [2,2]]}

1 = R,C     ->  R,X     X,C

5 = 1,3     ->  1,X     X,3
    

1   (0,0) (1,2)

x   (3,2) (4,3)
y   (3,1) (4,2)
z   (3,1) (4,3)

00  01  02  03  04  05      0   0   0   1   1   1   2   2   2   
10  11  12  13  14  15      0   0   0   1   1   1   2   2   2   
20  21  22  23  24  25      0   0   0   1   1   1   2   2   2   
30  31  32  33  34  35      3   3   3
40  41  42  43  44  45      3   3   3
50  51  52  53  54  55      3   3   3

00  0
01  1/3

*/
