// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:
// string convert(string s, int numRows);

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) { return s; }
        int cycleStep = 2 * numRows - 2;
        int n = s.length();
        char[] res = new char[n];
        int count = 0;
        for(int i = 0; i < numRows; i++){
            for(int j = 0;j+i < n; j += cycleStep){
                res[count++] = s.charAt(i+j);

                if(i != 0 && i != numRows-1){
                    int diagonalIndex = j + cycleStep - i;
                    if (diagonalIndex < n) { res[count++] = s.charAt(diagonalIndex); }
                }
            }
        }
        return new String(res);
    }
}