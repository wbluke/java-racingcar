package racingcar.error;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private Validator() {}

    public static void checkAccuracyOfCarNames(String[] inputs) {
        if (isSmallNumOfCars(inputs)) {
            throw new IllegalArgumentException("자동차 게임을 위한 차의 이름을 2개 이상 입력해주세요.");
        }
        if (isDuplicate(inputs)) {
            throw new IllegalArgumentException("서로 다른 이름을 입력해주세요.");
        }
    }

    private static boolean isSmallNumOfCars(String[] inputs) {
        return (inputs.length <= 1);
    }

    private static boolean isDuplicate(String[] inputs) {
        Set<String> set = Arrays.stream(inputs).collect(Collectors.toSet());
        return (inputs.length != set.size());
    }

    public static void checkAccuracyOfGameCount(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("게임 횟수는 1 이상의 정수로 입력해 주세요.");
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}