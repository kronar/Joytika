package joytika.tests.Logic;




public class Tournament {
    private String tour_id;
    private String tour_type;
    private String tour_points;
    private String title;

    public Tournament(String tourid, String tourtype, String tourpoints, String title) {
        this.tour_id = tourid;
        this.tour_type = tourtype;
        this.tour_points = tourpoints;
        this.title = title;
    }

    public String getTour_id() {
        return tour_id;
    }

    public String getTour_type() {
        return tour_type;
    }

    public String getTour_points() {
        return tour_points;
    }

    public String getTitle() {
        return title;
    }
}
