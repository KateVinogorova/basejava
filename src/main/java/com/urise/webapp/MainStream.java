package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {

    /* если сумма всех чисел нечетная - удалить все нечетные, если четная - удалить все четные.
    Сложность алгоритма должна быть O(N). Optional - решение в один стрим */
    public static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum = " + sum);
        if (sum % 2 == 0) {
            integers = integers.stream().filter(x -> x % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            integers = integers.stream().filter(x -> x % 2 != 0)
                    .collect(Collectors.toList());
        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new ArrayList<>(Arrays.asList(1, 5, 8, 3, 6, 3, 7))));
    }
}
