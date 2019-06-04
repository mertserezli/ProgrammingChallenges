public class TemperatureConverter {

    public static double fahrenheitToCelcius(double fahrenheit){
        return (fahrenheit - 32)/1.8;
    }

    public static double celciusToFahrenheit(double celcius){
        return (celcius * 1.8) + 32;
    }
}
