package lotto.view;

import lotto.model.*;

import java.util.*;

public class LottoView {
    private final Scanner sc = new Scanner(System.in);

    public int askMoney() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(sc.nextLine());
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        return money;
    }

    public void printTickets(List<Lotto> tickets) {
        System.out.printf("%n%d개를 구매했습니다.%n", tickets.size());
        tickets.forEach(System.out::println);
    }

    public Set<Integer> askWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] tokens = sc.nextLine().split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String token : tokens) {
            int n = Integer.parseInt(token.trim());
            if (n < 1 || n > 45) throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
            if (!numbers.add(n)) throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
        }
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        return numbers;
    }

    public int askBonusNumber(Set<Integer> winning) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(sc.nextLine());
        if (bonus < 1 || bonus > 45 || winning.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위이며 당첨 번호와 중복되지 않아야 합니다.");
        return bonus;
    }

    public void printResult(LottoResult result, int money) {
        System.out.println("\n당첨 통계\n---");
        result.printStats();
        double rate = ((double) result.getTotalPrize() / money) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    public void printError(String msg) {
        System.out.println(msg);
    }
}
