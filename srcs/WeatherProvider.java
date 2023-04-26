public class WeatherProvider {
    // Private attributes
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    // Constructor method (Private)
    private WeatherProvider() {}

    // Public methods
    public String getCurrentWeather(Coordinates p_coordinates) {
        // To do...
        return weather[0];
    }

    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }
}