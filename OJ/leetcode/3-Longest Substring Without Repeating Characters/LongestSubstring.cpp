#include<iostream>
#include<string>
#include<map>
#include<vector>
using namespace std;

int lengthOfLongestSubstring(string s) {
    int rst = 0;
    map<char, int> recordMap;
    int j = 0;
    string rstStr;
    for(int i = 0; i < s.size(); ++i) {
        if(recordMap.count(s[i])) { //map.count() 0»ò1£¬map.find()µü´úÆ÷
            j = max(j, recordMap[s[i]] + 1);
        }
        recordMap[s[i]] = i;
        if(i - j + 1 > rst) {
            rst = i - j + 1;
            rstStr = s.substr(j, rst);
        }
    }
    cout << rstStr << " ";
    return rst;
}

int main() {
    vector<string> v;
    v.push_back("abcabcbb");
    v.push_back("bbbb");
    v.push_back("pwwkew");
    v.push_back("c");
    v.push_back("tmmzuxt");

    for(vector<string>::size_type i = 0; i < v.size(); i++) {
        cout << v[i] << "-- > " << lengthOfLongestSubstring(v[i]) << endl;;
    }
    return 0;
}
