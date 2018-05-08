package com.zone.androidtest.algorithm;

import java.util.Stack;

public class SearchTest {
    public int [] inputs = new int[]{10, 8, 7, 1, 2, 4, 3, 5, 6, 9};

    private static final int MAX = Integer.MAX_VALUE; //不存在比该输入值大的值，设置最大值
    public static int[] calculate(int [] inputs) {
        if (inputs == null || inputs.length == 0) {
            return null;
        }

        int inputSize = inputs.length;

        int[] outputs = new int[inputSize];

        Stack<Integer> stackVal = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>(); // 单独用一个栈来保存索引，或者使用HashMap也可以，O(n)

        stackVal.push(inputs[0]);
        stackIndex.push(0);

        for (int i = 1; i < inputSize; i++) {
            int curVal = inputs[i];
            if (curVal > stackVal.peek()) {
                stackVal.pop();
                int index = stackIndex.pop();
                outputs[index] = curVal;
                i--;
            } else {
                stackVal.push(curVal);
                stackIndex.push(i);
            }
        }

        /**
         * 此时栈里面的元素，都是不存在比自身值大的元素
         */
        while(!stackVal.isEmpty()) {
            stackVal.pop();
            int index = stackIndex.pop();
            outputs[index] = MAX;
        }

        return outputs;
    }
}
