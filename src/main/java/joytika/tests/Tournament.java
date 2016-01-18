package joytika.tests;


import org.openqa.selenium.WebElement;

public class Tournament {
    private int tour_id;
    private int prize;
    private int points;
    private WebElement playButton;

    private WebElement tourIdLabel;

    public void pressPlayButton() {
        playButton.click();
    }

    public int getTour_id() {
        return tour_id;
    }

    public Tournament(WebElement tourIdLabel, WebElement pointFlag, WebElement playButton) {
        this.tourIdLabel = tourIdLabel;
        String tourIdLabelText = tourIdLabel.getText();
        tourIdLabelText = tourIdLabelText.substring(1);
        this.tour_id = Integer.parseInt(tourIdLabelText);
        this.points = Integer.parseInt(pointFlag.getText());
        this.playButton = playButton;
    }

}
