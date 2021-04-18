package com.luo.leetcode.binary;

/**
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class ValidUtf8 {

    public static void main(String[] args) {
        System.out.println(new ValidUtf8().validUtf8(new int[]{197, 130, 1}));
        System.out.println(new ValidUtf8().validUtf8(new int[]{235, 140, 4}));
        System.out.println(new ValidUtf8().validUtf8(new int[]{145}));
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            String bs = toBinary(data[i]);
            if (bs.charAt(0) == '0') {
                i++;
                continue;
            }

            int cnt = bs.indexOf("0");
            if (cnt <= 1 || cnt > 4 || (i + cnt) > data.length) {
                // 长度不合法
                return false;
            }

            for (int j = 1; j < cnt; j++) {
                // 前缀校验
                if (!toBinary(data[i + j]).startsWith("10")) {
                    return false;
                }
            }
            i += cnt;
        }

        return true;
    }

    // 二进制高步补0
    private String toBinary(int num) {
        String cover = Integer.toBinaryString(1 << 8).substring(1);
        String bs = Integer.toBinaryString(num);
        return bs.length() < 8 ? cover.substring(bs.length()) + bs : bs;
    }
}
