package lotto.model;

import java.util.*;

public class LottoResult {
    private final Map<PrizeTier, Integer> results = new LinkedHashMap<>();
    private int totalPrize = 0;

    public LottoResult() {
        for (PrizeTier tier : PrizeTier.values()) {
            results.put(tier, 0);
        }
    }

    public void add(Lotto lotto, Set<Integer> winning, int bonus) {
        int match = lotto.matchCount(winning);
        boolean hasBonus = lotto.hasBonus(bonus);
        PrizeTier tier = PrizeTier.valueOf(match, hasBonus);
        if (tier == null) return;

        results.put(tier, results.get(tier) + 1);
        totalPrize += tier.getPrize();
    }

    public void printStats() {
        results.forEach((tier, count) ->
                System.out.printf("%s - %d개%n", tier.getLabel(), count)
        );
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
