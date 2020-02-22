package Model;

public class ExampleItem {
    private String mtextview;
    private String mimageview;
    private String mrelease;
    private String moverview;

    public ExampleItem(String mtextview, String mimageview, String mrelease, String moverview) {
        this.mtextview = mtextview;
        this.mimageview = mimageview;
        this.mrelease = mrelease;
        this.moverview = moverview;
    }

    public String getMtextview() {
        return mtextview;
    }

    public void setMtextview(String mtextview) {
        this.mtextview = mtextview;
    }

    public String getMimageview() {
        return mimageview;
    }

    public void setMimageview(String mimageview) {
        this.mimageview = mimageview;
    }

    public String getMrelease() {
        return mrelease;
    }

    public void setMrelease(String mrelease) {
        this.mrelease = mrelease;
    }

    public String getMoverview () {
        return moverview;
    }

    public void setMoverview (String moverview) {
        this.moverview = moverview;
    }
}
