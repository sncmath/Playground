package Model;

public class ListItem {
    private String date;
    private String weatherstate;
    private String speed;
    private String humidity;
    private String temp;
    private String mintemp;
    private String maxtemp;
    private String direction;
    private String predict;


    public ListItem(String date, String weatherstate, String speed, String humidity, String temp, String mintemp, String maxtemp, String direction, String predict) {
        this.date = date;
        this.weatherstate = weatherstate;
        this.speed = speed;
        this.humidity = humidity;
        this.temp = temp;
        this.mintemp = mintemp;
        this.maxtemp = maxtemp;
        this.direction = direction;
        this.predict = predict;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeatherstate() {
        return weatherstate;
    }

    public void setWeatherstate(String weatherstate) {
        this.weatherstate = weatherstate;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPredict() { return predict; }

    public void setPredict(String predict) {
        this.predict = predict;
    }}



