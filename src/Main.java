import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static List<City> cities = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".\\Task_ВС_Java.csv");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] city = scanner.nextLine().split(";");
            cities.add(stringToObjectCity(city));
        }

        City[] citiesArray = City.convertCityListToArray(cities);
        System.out.println(City.findMaxPopulation(citiesArray));
    }
    private static City stringToObjectCity(String[] city){
        Integer foundation = null;

        if (city.length == 6) {
            foundation = convertFoundation(city[5]);
        }
        String name = city[1];
        String region = city[2];
        String district = city[3];
        Integer population = Integer.parseInt(city[4]);

        return new City(name, region, district, population, foundation);
    }

    public static Integer convertFoundation(String foundation){
        Pattern patternForYears = Pattern.compile("^\\d{3,4}");
        Matcher matcherForYears = patternForYears.matcher(foundation);

        Pattern patternForTwoCentury = Pattern.compile("^(\\d+)[—-](\\d+)\\sвека");
        Matcher matcherForTwoCentury = patternForTwoCentury.matcher(foundation);

        Pattern patternForCentury = Pattern.compile("^\\d{1,2}\\sвек");
        Matcher matcherForCentury = patternForCentury.matcher(foundation);

        Integer foundationYear = null;

        if(matcherForYears.find()){
            String yearString = matcherForYears.group();
            foundationYear = Integer.parseInt(yearString);
        }

        if(matcherForTwoCentury.find()){
            String[] centuries = matcherForTwoCentury.group().split("[—-]");
            foundationYear = Integer.parseInt(centuries[0]);
            foundationYear = (foundationYear - 1) + 50;
        }

        if(matcherForCentury.find()){
            String centurySting = matcherForCentury.group().split(" ")[0];
            foundationYear = Integer.parseInt(centurySting);
            foundationYear = (foundationYear - 1) * 100;
        }

        return foundationYear;
    }
}