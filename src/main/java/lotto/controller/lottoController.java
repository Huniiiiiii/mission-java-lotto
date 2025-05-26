package lotto.controller;

import lotto.model.*;
import lotto.view.LottoView;

import java.util.*;

public class lottoController {
    private final LottoView view = new LottoView();

    public void run() {
        try {
            int money = view.askMoney();
            List<Lotto> tickets = generateTickets(money / 1000);
            view.printTickets(tickets);

            Set<Integer> winning = view.askWinningNumbers();
            int bonus = view.askBonusNumber(winning);

            LottoResult result = evaluate(tickets, winning, bonus);
            view.printResult(result, money);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }

    private List<Lotto> generateTickets(int count) {
        return LottoGenerator.generateMultiple(count);
    }

    private LottoResult evaluate(List<Lotto> tickets, Set<Integer> win, int bonus) {
        LottoResult result = new LottoResult();
        tickets.forEach(ticket -> result.add(ticket, win, bonus));
        return result;
    }
}