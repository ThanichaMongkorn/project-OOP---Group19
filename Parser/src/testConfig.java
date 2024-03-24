import config.ReadConfig;

public class testConfig {
    public static void main(String[] args) {
        ReadConfig r = new ReadConfig();
        r.read();
        System.out.println(ReadConfig.m);
    }
}