package at.htlgkr.gaert;

import java.util.List;

public class Dashboard implements IDashboard{
    private List<Temperature> temp;
    private float temperature;

    private List<Pressure> pressure;
    private float tempPress;

    private List<Speed> speed;
    private float tempSpeed;

    private List<Time> time;
    private float tempTime;

    int indTemp = 0;
    int indPress = 0;
    int indSpeed = 0;
    int indTime = 0;

    public void addIndTemp(){
        if (indTemp >= temp.size()){
            indTemp = 0;
            return;
        }
        indTemp += 1;
    }

    public void reduceIndTemp(){
        if (indTemp == 0){
            indTemp = temp.size()-1;
            return;
        }
        indTemp -= 1;
    }

    public void addIndPress(){
        if (indPress >= pressure.size()){
            indPress = 0;
            return;
        }
        indPress += 1;
    }

    public void reduceIndPress(){
        if (indPress == 0){
            indPress = pressure.size()-1;
            return;
        }
        indPress -= 1;
    }

    public void addIndSpeed(){
        if (indSpeed >= speed.size()){
            indSpeed = 0;
            return;
        }
        indSpeed += 1;
    }

    public void reduceIndSpeed(){
        if (indSpeed == 0){
            indSpeed = speed.size()-1;
            return;
        }
        indSpeed -= 1;
    }

    public void addIndTime(){
        if (indTime >= time.size()){
            indTime = 0;
            return;
        }
        indTime += 1;
    }

    public void reduceIndTime(){
        if (indTime == 0){
            indTime = time.size()-1;
            return;
        }
        indTime -= 1;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setTempPress(float tempPress) {
        this.tempPress = tempPress;
    }

    public void setTempSpeed(float tempSpeed) {
        this.tempSpeed = tempSpeed;
    }

    public void setTempTime(float tempTime) {
        this.tempTime = tempTime;
    }

    public void addTemperatureConverter(Temperature converter) {
        temp.add(converter);
    }

    @Override
    public String displayableTemperature() {
        return temp.get(indTemp).getTemp(temperature);
    }

    @Override
    public String displayablePressure() {
        return pressure.get(indPress).getPress(tempPress);
    }

    @Override
    public String displayableSpeed() {
        return "";
    }

    @Override
    public String displayableTime() {
        return "";
    }
}
