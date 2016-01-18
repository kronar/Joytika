package joytika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class TournamentHelper {
    private static WebDriver driver;
    private static List<Tournament> currentTournaments = new ArrayList<Tournament>();

    public TournamentHelper(WebDriver driver) {
        TournamentHelper.driver = driver;
    }

    @Nullable
    public static Tournament getCurrentTournament(int tour_id) {
        initCurrentTournament();
        for (Tournament tournament : currentTournaments) {
            if (tournament.getTour_id() == tour_id) {
                return tournament;
            }
        }
        return null;
    }

// TODO передалать на поиск по классу в объекте
    private static void initCurrentTournament() {
        currentTournaments.clear();

        currentTournaments.add(new Tournament(
                driver.findElement(By.xpath(XPath.TournamentCard.tour_id_label_1)),
                driver.findElement(By.xpath(XPath.TournamentCard.point_flag_1)),
                driver.findElement(By.xpath(XPath.TournamentCard.play_button_1))
        ));

        currentTournaments.add(new Tournament(
                driver.findElement(By.xpath(XPath.TournamentCard.tour_id_label_2)),
                driver.findElement(By.xpath(XPath.TournamentCard.point_flag_2)),
                driver.findElement(By.xpath(XPath.TournamentCard.play_button_2))
        ));

        currentTournaments.add(new Tournament(
                driver.findElement(By.xpath(XPath.TournamentCard.tour_id_label_3)),
                driver.findElement(By.xpath(XPath.TournamentCard.point_flag_3)),
                driver.findElement(By.xpath(XPath.TournamentCard.play_button_3))
        ));

        currentTournaments.add(new Tournament(
                driver.findElement(By.xpath(XPath.TournamentCard.tour_id_label_4)),
                driver.findElement(By.xpath(XPath.TournamentCard.point_flag_4)),
                driver.findElement(By.xpath(XPath.TournamentCard.play_button_4))
        ));

    }
}
