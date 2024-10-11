package ru.skyPro.serviceBank.controller;

import org.springframework.web.bind.annotation.*;
import ru.skyPro.serviceBank.model.BankRecommendation;
import ru.skyPro.serviceBank.model.ClientRecommendation;
import ru.skyPro.serviceBank.service.RecommendationsService;
import ru.skyPro.serviceBank.exceptions.RecommendBankException;

import java.util.*;

@RestController
@RequestMapping("/user")
public class RecommendationController {

    public final RecommendationsService service;

    public RecommendationController(RecommendationsService service) {
        this.service = service;
    }

    @GetMapping("/random")
    public int getRecommendations() {
        return service.findRandomUser(UUID.fromString("cd515076-5d8a-44be-930e-8d4fcb79f42d"));
    }

    @GetMapping("/recommend/{id}")
    public ClientRecommendation getRecommendations(@PathVariable("id") String id) {
//        HashMap<UUID, Set<BankRecommendation>> resultRecommendations = new HashMap<>();
//        HashMap<UUID, Set<BankRecommendation>> simpleCredit = new HashMap<>();
//        HashMap<UUID, Set<BankRecommendation>> topSaving = new HashMap<>();

        List<BankRecommendation> recommendations = new ArrayList<>();
        ClientRecommendation client = new ClientRecommendation(id, recommendations);
        if (service.getRecommendedInvest500(UUID.fromString(id)) != 0) {
            recommendations.add(new BankRecommendation("147f6a0f-3b91-413b-ab99-87f081d60d5a", "invest500", " Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС) от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом. Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде. Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. Откройте ИИС сегодня и станьте ближе к финансовой независимости!"));
//                resultRecommendations.put(UUID.fromString(id), recommendations);
            client.setBankRecommendations(recommendations);
            return client;
        }
        if (service.getRecommendedSimpleCredit(UUID.fromString(id)) != 0) {
            recommendations.add(new BankRecommendation("ab138afb-f3ba-4a93-b74f-0fcee86d447f", "Простой кредит",
                    "Откройте мир выгодных кредитов с нами!Ищете способ быстро и без лишних хлопот получить нужную сумму? Тогда наш выгодный кредит — именно то, что вам нужно! Мы предлагаем низкие процентные ставки, гибкие условия и индивидуальный подход к каждому клиенту." +
                            "\n" +
                            "Почему выбирают нас: Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс рассмотрения заявки занимает всего несколько часов." +
                            "\n" +
                            "Удобное оформление. Подать заявку на кредит можно онлайн на нашем сайте или в мобильном приложении.\n" +
                            "Широкий выбор кредитных продуктов. Мы предлагаем кредиты на различные цели: покупку недвижимости, автомобиля, образование, лечение и многое другое.\n" +
                            "Не упустите возможность воспользоваться выгодными условиями кредитования от нашей компании!"));
//                resultRecommendations.put(UUID.fromString(id),recommendations);
            client.setBankRecommendations(recommendations);
            return client;
        }
        if (service.getRecommendedTopSavingService(UUID.fromString(id)) != 0) {
            recommendations.add(new BankRecommendation("59efc529-2fff-41af-baff-90ccd7402925", "Top saving", "Откройте свою собственную «Копилку» с нашим банком! «Копилка» — это уникальный банковский инструмент, который поможет вам легко и удобно накапливать деньги на важные цели. Больше никаких забытых чеков и потерянных квитанций — всё под контролем!\n" +
                    "Преимущества «Копилки»:\n" +
                    "Накопление средств на конкретные цели. Установите лимит и срок накопления, и банк будет автоматически переводить определенную сумму на ваш счет.\n" +
                    "Прозрачность и контроль. Отслеживайте свои доходы и расходы, контролируйте процесс накопления и корректируйте стратегию при необходимости.\n" +
                    "Безопасность и надежность. Ваши средства находятся под защитой банка, а доступ к ним возможен только через мобильное приложение или интернет-банкинг.\n" +
                    "Начните использовать «Копилку» уже сегодня и станьте ближе к своим финансовым целям!"));
//                resultRecommendations.put(UUID.fromString(id),recommendations);
            client.setBankRecommendations(recommendations);
            return client;
        } else
            throw new RecommendBankException();
    }
}
