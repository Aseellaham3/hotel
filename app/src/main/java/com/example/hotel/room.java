package com.example.hotel;



public class room  {
    private String roomType;
    private Double price;
    private String feature;
    private String floor;
    private int roomNum;
    private int imageID;
    public static final room[] rooms={
            new room("Single room", 400.0," single bed , with AC , Street view , WiFi , with veranda, TV",1, R.drawable.single_room,"7 floor"),
            new room("Double room",64.96," double bed , with AC , pool view , WiFi , with veranda, TV",2, R.drawable.double_room,"5 floor"),
            new room("Twin room",28.47,"two bed , with AC , Street view , WiFi , with veranda, TV",3, R.drawable.twin_room,"8 floor"),
            new room("Suite room",29.99,"room with double bed ,room with  two bed , living room, with AC , pool view , WiFi , with veranda ,TV", 4, R.drawable.suite_room,"10 floor"),
    };
    public room() {
    }

    public room(String roomType, Double price, String feature, int imageID, String floor) {
        this.roomType = roomType;
        this.price = price;
        this.imageID = imageID;
        this.floor = floor;
        this.feature = feature;
    }

    public room(String roomType, Double price,  int imageID ,int roomNum){
        this.roomType = roomType;
        this.price = price;
        this.imageID = imageID;
        this.roomNum = roomNum;
    }

    public room(String roomType, Double price, String feature, int roomNum, int imageID, String floor) {
        this.roomType = roomType;
        this.price = price;
        this.feature = feature;
        this.roomNum = roomNum;
        this.imageID = imageID;
        this.floor = floor;
    }

    public String getFloor() { return floor; }

    public void setFloor(String floor) { this.floor = floor; }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String name) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String rating) {
        this.feature = feature;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int quantity) {
        this.roomNum = roomNum;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }


    @Override
    public String toString() {
        return "room{" +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", feature='" + feature + '\'' +
                ", roomNum=" + roomNum +
                ", imageID=" + imageID +
                ", floor=" + floor +
                '}';
    }
}