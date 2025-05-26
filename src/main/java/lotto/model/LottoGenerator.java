package lotto.model;

import java.util.*;

public class LottoGenerator {
    public static Lotto generate() {
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        while (set.size() < 6) {
            set.add(rand.nextInt(45) + 1);
        }
        return new Lotto(new ArrayList<>(set));
    }

    public static List<Lotto> generateMultiple(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(generate());
        }
        return list;
    }
}
