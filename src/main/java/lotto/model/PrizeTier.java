package lotto.model;

public enum PrizeTier {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)");

    private final int match;
    private final boolean bonus;
    private final int prize;
    private final String label;

    PrizeTier(int match, boolean bonus, int prize, String label) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
        this.label = label;
    }

    public static PrizeTier valueOf(int match, boolean hasBonus) {
        for (PrizeTier tier : values()) {
            if (tier.match == match && tier.bonus == hasBonus) return tier;
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    public int getPrize() {
        return prize;
    }
}
