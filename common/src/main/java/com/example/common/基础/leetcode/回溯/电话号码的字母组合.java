package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        for (String letterCombination : letterCombinations("23")) {
            //System.out.printf("%s%n", letterCombination);
        }

        for (String letterCombination : letterCombinations1("23")) {
            System.out.printf("%s%n", letterCombination);
        }
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        combine(result, digits, 0, map, new StringBuilder());
        return result;
    }

    /*
    核心递归实现，核心逻辑是通过回溯法遍历所有可能的字母组 index 是数字串的索引
    index 是数字串的索引（比如 digits="23"，index=0 对应 '2'，index=1 对应 '3'），
    和 sb 的长度无关，用 index 会导致删除错误位置的字符，最终结果完全错误。
     * 递归回溯生成组合
     * @param combinations 最终存储所有组合的列表
     * @param digits 输入的数字串（如"23"）
     * @param index 当前处理到数字串的第几个字符（从0开始）
     * @param map 数字-字母映射表
     * @param sb 临时存储当前拼接的字符（回溯核心）
     */
    public static void combine(List<String> combinations, String digits, int index, Map<Character, String> map, StringBuilder sb) {
        if (index == digits.length()) {// 递归终止条件：处理完所有数字（index等于数字串长度）
            combinations.add(sb.toString());
        } else {
            char currentDigit = digits.charAt(index);
            String character = map.get(currentDigit);
            for (int i = 0; i < character.length(); i++) {
                // 选择：追加当前字母到临时字符串
                sb.append(character.charAt(i));
                // 递归：处理下一个数字
                combine(combinations, digits, index + 1, map, sb);
                // sb.deleteCharAt(index);//必须清除不然会出现多个
                // 回溯：删除最后追加的字母（关键！恢复状态）
                sb.deleteCharAt(sb.length() - 1);//sb 是逐步追加字符的（比如先加 'a'，再加 'd'），递归返回后需要删除最后追加的那个字符（即 “回退一步”）；
            }
        }
    }

    //solution2  深度快速搜索法
    public static List<String> letterCombinations1(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> rs = new ArrayList<>();
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int length = digits.length();
        char[] path = new char[length];
        char[] chars = digits.toCharArray();
        dfs(0, rs, path, chars, mapping);
        return rs;
    }

    //深度快速搜索
    public static void dfs(int i, List<String> rs, char[] path, char[] digits, String[] mapping) {
        if (i == digits.length) {
            rs.add(new String(path));
            return;
        }
        int index = digits[i] - '0';
        String letter = mapping[index];
        for (char c : letter.toCharArray()) {
            path[i] = c;
            dfs(i + 1, rs, path, digits, mapping);
        }
    }
}
