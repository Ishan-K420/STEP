class AppConfig{
    String appName="MyApp";
    static class NetworkConfig{
        String host;int port;
        NetworkConfig(String h,int p){host=h;port=p;}
        void show(){System.out.println(host+":"+port);}
    }
}
public class AppConfigurator{
    public static void main(String[] a){
        AppConfig.NetworkConfig n=new AppConfig.NetworkConfig("localhost",8080);
        n.show();
    }
}
