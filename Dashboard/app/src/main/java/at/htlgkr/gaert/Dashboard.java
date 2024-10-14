package at.htlgkr.gaert;

import java.util.ArrayList;
import java.util.List;

public class Dashboard implements IDashboard{
    private List<Converter> temp;
    private float temperature;

    private List<Converter> pressure;
    private float tempPress;

    private List<Converter> speed;
    private float tempSpeed;

    private List<Time> time;
    private String tempTime;

    int indTemp = 0;
    int indPress = 0;
    int indSpeed = 0;
    int indTime = 0;

    public Dashboard() {
        this.temp = new ArrayList<>();
        this.temperature = 0;
        this.pressure = new ArrayList<>();
        this.tempPress = 0;
        this.speed = new ArrayList<>();
        this.tempSpeed = 0;
        this.time = new ArrayList<>();
        this.tempTime = "";
    }

    public void addIndTemp(){
        indTemp += 1;
        if (indTemp >= temp.size()){
            indTemp = 0;
        }
    }

    public void reduceIndTemp(){
        if (indTemp == 0){
            indTemp = temp.size()-1;
            return;
        }
        indTemp -= 1;
    }

    public void addIndPress(){
        indPress += 1;
        if (indPress >= pressure.size()){
            indPress = 0;
        }
    }

    public void reduceIndPress(){
        if (indPress == 0){
            indPress = pressure.size()-1;
            return;
        }
        indPress -= 1;
    }

    public void addIndSpeed(){
        indSpeed += 1;
        if (indSpeed >= speed.size()){
            indSpeed = 0;
            return;
        }
    }

    public void reduceIndSpeed(){
        if (indSpeed == 0){
            indSpeed = speed.size()-1;
            return;
        }
        indSpeed -= 1;
    }

    public void addIndTime(){
        indTime += 1;
        if (indTime >= time.size()){
            indTime = 0;
            return;
        }
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

    public void setTempTime(String tempTime) {
        this.tempTime = tempTime;
    }

    public void addTemperatureConverter(Converter converter) {
        temp.add(converter);
    }

    @Override
    public String displayableTemperature() {
        return temp.get(indTemp).getConverter(temperature);
    }

    public void addPressureConverter(Converter converter){
        pressure.add(converter);
    }

    @Override
    public String displayablePressure() {
        return pressure.get(indPress).getConverter(tempPress);
    }

    public void addSpeedConverter(Converter converter){
        speed.add(converter);
    }

    @Override
    public String displayableSpeed() {
        return speed.get(indSpeed).getConverter(tempSpeed);
    }

    public void addTimeConverter(Time converter){
        time.add(converter);
    }

    @Override
    public String displayableTime() {
        return time.get(indTime).getTime(tempTime);
    }
}
