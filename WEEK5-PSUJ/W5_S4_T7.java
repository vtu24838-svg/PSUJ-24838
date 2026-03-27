//Task7:https://leetcode.com/problems/longest-substring-without-repeating-characters


class W5_S4_T7 {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> st;
        int i = 0, j = 0, maxLen = 0;

        while (j < s.size()) {
            if (!st.count(s[j])) {
                st.insert(s[j]);
                maxLen = max(maxLen, j - i + 1);
                j++;
            } else {
                st.erase(s[i]);
                i++;
            }
        }

        return maxLen;
    }
};
