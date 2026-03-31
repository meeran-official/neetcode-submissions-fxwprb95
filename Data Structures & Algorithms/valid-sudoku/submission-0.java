class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> row = new HashMap<>();
        Map<Character, Integer> col = new HashMap<>();
        Map<Character, Integer> box = new HashMap<>();

        int boxIdx;

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == '.') continue;

                boxIdx = (r / 3) * 3 + (c/3);

                if(row.getOrDefault(board[r][c], -1) == r) return false;
                if(col.getOrDefault(board[r][c], -1) == c) return false;
                if(box.getOrDefault(board[r][c], -1) == boxIdx) return false;
                
                row.put(board[r][c], r);
                col.put(board[r][c], c);
                box.put(board[r][c], boxIdx);
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

00  01  02  03  04  05      0   0   0   1   1   1  
10  11  12  13  14  15      0   0   0   1   1   1   
20  21  22  23  24  25      0   0   0   1   1   1
30  31  32  33  34  35      2   2   2   3   3   3
40  41  42  43  44  45      2   2   2   3   3   3
50  51  52  53  54  55      2   2   2   3   3   3

00  0
01  1/3

*/
