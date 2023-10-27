public class PoliticalAd extends Ad {
    private double political_probability;
    private String paid_for_by;
    String format(){
        String formattedPolitical_probability = String.format("%.6f", political_probability);
        return "political" + "," + getTitle() + "," + formattedPolitical_probability + "," + paid_for_by;
    }
    public PoliticalAd(String title, double political_probability, String paid_for_by) {
        super(title);
        this.political_probability = political_probability;
        this.paid_for_by = paid_for_by;
    }

    public String getPolitical_probability() {
        String formattedPolitical_probability = String.format("%.6f", political_probability);
        return formattedPolitical_probability;
    }

    public String getPaid_for_by() {
        return paid_for_by;
    }
}
