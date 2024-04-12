import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class City {
    private String name;
    private String region;
    private String district;
    private Integer population;
    private Integer foundation;

    public City() {
    }

    public City(String name, String region, String district, Integer population, Integer foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getFoundation() {
        return foundation;
    }

    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
    }

    public static void sortByCityName(List<City> cityList){
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortByCityNameAndRegion(List<City> cityList){
        cityList.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                int result = -(o1.getRegion().compareTo(o2.getRegion()));
                if (result == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
    }

    public static City[] convertCityListToArray(List<City> cityList){
        City[] cities = cityList.toArray(cityList.toArray(new City[0]));
        return cities;
    }

    public static String findMaxPopulation(City[] cities){
        int indexMaxElem = 0;
        Integer maxValue = 0;
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].getPopulation() > maxValue ){
                maxValue = cities[i].getPopulation();
                indexMaxElem = i;
            }
        }
        return String.format("[%d] = %d", indexMaxElem, maxValue);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}


