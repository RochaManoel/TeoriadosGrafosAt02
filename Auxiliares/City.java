package Auxiliares;

public class City {
    private String name;
    private String growth;
    private double latitude;
    private double longitude;
    private int population;
    private int rank;
    private String state;

    public City(String name, String growth, double latitude, double longitude, int population, int rank, String state){
        this.name = name;
        this.growth = growth;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.rank = rank;
        this.state = state;
    }

    public String getName() {
        return name;
    }
    public String getGrowth() {
        return growth;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public int getPopulation() {
        return population;
    }
    public int getRank() {
        return rank;
    }
    public String getState() {
        return state;
    }
}
