package Tp6.comprendre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Ville {
    private static HashMap<String, Ville> listeVilles = new HashMap<>();

    private String nom;
    private double latitude;
    private double longitude;
    private double altitude;

    public Ville(String nom, double latitude, double longitude, double altitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        listeVilles.put(nom, this);
    }


    public ArrayList<Ville> proches(int km){
        ArrayList<Ville> res = new ArrayList<>();
        for (Ville v : listeVilles.values()){
            if (distance(this.latitude, v.latitude, this.longitude, v.longitude, this.altitude, v.altitude) <= 1000*km){
                res.add(v);
            }
        }
        return res;
    }

    public static void init(){
        new Ville("Orsay", 48.7, 2.18333, 90);
        new Ville("Gif-sur-Yvette", 48.701844, 2.134078, 61);
        new Ville("Anthony", 48.759255, 2.302553, 0);
        new Ville("Paris", 48.8534, 2.3488, 35);
        new Ville("Marseille", 43.299999,5.4, 0);
        new Ville("Tours", 47.383333, 0.683333, 77);
        new Ville("JouÃ©-les-Tours", 47.351861, 0.6613099, 50);
        new Ville("Grenoble", 45.188529, 5.724524, 204);
        new Ville("GenÃ¨ve", 46.2043907, 6.1431577, 375);
        new Ville("Palaiseau", 48.714509, 2.245748, 0);
        new Ville("Massy", 48.730756, 2.27137, 0);
        new Ville("Agadir",30.427755, -9.598107, 0);
    }

    public static Ville getVille(String nom){
        return listeVilles.get(nom);
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return Double.compare(ville.latitude, latitude) == 0 && Double.compare(ville.longitude, longitude) == 0 && Objects.equals(nom, ville.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, latitude, longitude);
    }


    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     *
     * source : https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
     *
     * @returns Distance in Meters
     */
    private static double distance(double lat1, double lat2, double lon1,
                                   double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public static void main(String[] args) {
        init();
        for(Ville v : getVille("Orsay").proches(7)){
            System.out.println(v);
        }
    }
}