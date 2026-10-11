class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rMap = new HashMap<>();
        Map<Integer, Set<Character>> cMap = new HashMap<>();
        Map<Integer, Set<Character>> sqMap = new HashMap<>();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                int sq = (r / 3) * 3 + (c / 3);
                if(rMap.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                    || cMap.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || sqMap.computeIfAbsent(sq, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                    }
                rMap.get(r).add(board[r][c]);
                cMap.get(c).add(board[r][c]);
                sqMap.get(sq).add(board[r][c]);
            }
        }
        return true;
    }
}
