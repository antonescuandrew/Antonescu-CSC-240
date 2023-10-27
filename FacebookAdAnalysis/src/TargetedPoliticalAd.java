public class TargetedPoliticalAd extends PoliticalAd{
    private String targets, advertiser;
    String format(){
        return "targeted-political" + "," + super.getTitle() + "," + getPolitical_probability() + "," + getPaid_for_by() + "," +
                targets + "," + advertiser;
    }
    public TargetedPoliticalAd(String title, double political_probability, String paid_for_by, String targets, String advertiser) {
        super(title, political_probability, paid_for_by);
        this.targets = targets;
        this.advertiser = advertiser;
    }
}
