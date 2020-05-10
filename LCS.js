// As an example of how straightforward these recursive relationships can be, 
//consider the longest common subsequence problem.
// You are given two strings, S and T, 
//and want to find the longest subsequence that appears in both strings, 
//where the characters of the subsequence do not have to appear consecutively in the original strings.
// For example, given the strings "ABCDE" and "DACACBE", the longest common subsequence is "ACE". 
//The straightforward recursive algorithm can be written in pseudocode as

// function LCS(S, T) is
// if S is empty or T is empty then return empty string
// if first char of S == first char of T then
// return (first char of S) + LCS(S - first char, T - first char)
// otherwise // first chars are different
// return longer of LCS(S - first char, T) and LCS(S, T - first char)

function LCS(s1, s2, n1, n2) {

    if (n1 === 0 || n2 === 0) {
        return 0;
    }
    if (s1.charAt(n1 - 1) === s2.charAt(n2 - 1)) {
        return 1 + LCS(s1, s2, n1 - 1, n2 - 1);
    }
    else
        return Math.max(LCS(s1, s2, n1 - 1, n1), LCS(s1, s2, n1, n2 - 1));

}
const str1 = 'ABCDE', str2 = 'DACACBE';
console.log(LCS(str1, str2, str1.length, str2.length));
