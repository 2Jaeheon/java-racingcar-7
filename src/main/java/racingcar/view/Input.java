package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> getCarNames() {
        String[] carNamesInput = Console.readLine().split(",");
        List<String> carNames = new ArrayList<>();

        Arrays.stream(carNamesInput).forEach(carName -> {
            carName = carName.trim();

            if (carName.equals("null")) {
                throw new IllegalArgumentException("자동차 이름에 null이 포함되어 있습니다.");
            } else if (carName.isEmpty() || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
            } else if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            carNames.add(carName);
        });

        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum = 0;
        try {
            tryNum = Integer.parseInt(Console.readLine());
            if (tryNum <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 숫자가 입력되었습니다.", e);
        }

        return tryNum;
    }
}
