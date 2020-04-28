package cn.ecnu.edu.leetcode.April2020;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 递归实现
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int m = n;//m,n分别表示左右括号剩余数量
        if (n <= 0) {
            return list;
        }
        get(list, m - 1, n, "(");
        return list;
    }

    public void get(List<String> list, int m, int n, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (m <= 0) {
            while (n-- > 0) {
                sb.append(")");
            }
            list.add(sb.toString());
            return;
        } else {
            sb.append("(");
            get(list, m - 1, n, sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            if (n > m) {
                sb.append(")");
                n--;
                get(list, m, n, sb.toString());
            } else {
                return;
            }

        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp=new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }
}
