package lotto.model;

import java.util.*;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        if (new HashSet<>(numbers).size() != SIZE)
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 번호여야 합니다.");
        if (!numbers.stream().allMatch(n -> n >= MIN && n <= MAX))
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 사이여야 합니다.");
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int matchCount(Set<Integer> winning) {
        return (int) numbers.stream().filter(winning::contains).count();
    }

    public boolean hasBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
