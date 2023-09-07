package model;

import java.util.List;

public class Villa {
    private List<String> img;
    private List<Integer> imgId;
    private int price;
    private int level;
    private double area;
    private double width;
    private double deep;
    private String map;
    private int bedroom;
    private int kitchen;
    private int living;
    private int toilet;
    private int relax;
    private int gym;
    private int garage;
    private int capacity;
    private int villaId;

    public Villa(int villaId, List<String> img, int price, int level, double area, double width, double deep, String map, int bedroom, int kitchen, int living, int toilet, int relax, int gym, int garage, int capacity, List<Integer> imgId) {
        this.img = img;
        this.price = price;
        this.level = level;
        this.area = area;
        this.width = width;
        this.deep = deep;
        this.map = map;
        this.bedroom = bedroom;
        this.kitchen = kitchen;
        this.living = living;
        this.toilet = toilet;
        this.relax = relax;
        this.gym = gym;
        this.garage = garage;
        this.capacity = capacity;
        this.villaId = villaId;
        this.imgId = imgId;
    }
    public List<Integer> getImgId() {
        return imgId;
    }

    public void setImgId(List<Integer> imgId) {
        this.imgId = imgId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getVillaId() {
        return villaId;
    }

    public void setVillaId(int villaId) {
        this.villaId = villaId;
    }

    public Villa(int villaId, int price, int level, double area, double width, double deep, int bedroom, int kitchen, int living, int toilet, int relax, int gym, int garage) {
        this.price = price;
        this.level = level;
        this.area = area;
        this.width = width;
        this.deep = deep;
        this.bedroom = bedroom;
        this.kitchen = kitchen;
        this.living = living;
        this.toilet = toilet;
        this.relax = relax;
        this.gym = gym;
        this.garage = garage;
        this.villaId = villaId;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDeep() {
        return deep;
    }

    public void setDeep(double deep) {
        this.deep = deep;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getLiving() {
        return living;
    }

    public void setLiving(int living) {
        this.living = living;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getRelax() {
        return relax;
    }

    public void setRelax(int relax) {
        this.relax = relax;
    }

    public int getGym() {
        return gym;
    }

    public void setGym(int gym) {
        this.gym = gym;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

}
