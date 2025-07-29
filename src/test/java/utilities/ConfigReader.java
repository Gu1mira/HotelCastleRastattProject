package utilities;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();
    static Faker faker = new Faker(new Locale("en-US"));
    private static final String configFilePath = "configuration.properties";

    static {
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static void updateProperty(String keyword) {
        switch (keyword){
            case "firstname":
                String firstname="Test"+faker.name().firstName();
                properties.setProperty(keyword,firstname);
                break;
            case "lastname":
                String lastname="Test"+faker.name().lastName();
                properties.setProperty(keyword,lastname);
                break;
            case "email":
                String email="Test"+faker.internet().emailAddress();
                properties.setProperty(keyword,email);
                break;
            case "phone":
                String phone="Test"+faker.phoneNumber().phoneNumber();
                properties.setProperty(keyword,phone);
                break;
            case "postalCode":
                String postalCode = faker.number().digits(4);
                properties.setProperty(keyword, postalCode);
                break;
            case "address1":
                String address1 = faker.address().fullAddress();
                properties.setProperty(keyword, address1);
                break;
            case "address2":
                String address2 = faker.address().secondaryAddress();
                properties.setProperty(keyword, address2);
                break;
            case "city":
                String city = faker.address().city();
                properties.setProperty(keyword, city);
                break;
            case "gastName":
                String gastName = "Test" + faker.name().fullName();
                properties.setProperty(keyword, gastName);
                break;
            case "orderNumber":
                String orderNumber = faker.number().digits(10);
                properties.setProperty(keyword, orderNumber);
                break;
            case "vatID":
                String vatID = faker.idNumber().valid();
                properties.setProperty(keyword, vatID);
                break;
            case "costCenter":
                String costCenter = faker.company().industry();
                properties.setProperty(keyword, costCenter);
                break;
            case "reference":
                String reference = faker.lorem().word();
                properties.setProperty(keyword, reference);
                break;


        }


    }
}
