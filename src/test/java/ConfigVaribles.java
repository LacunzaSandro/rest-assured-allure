import java.util.Optional;

public class ConfigVaribles {
    public static  String getHost() {
        return Optional.ofNullable(System.getenv("host"))
                .orElse(String.valueOf(ApplicationProperties.getInstance().get("host")));
    }

    public static  String getPath() {
        return Optional.ofNullable(System.getenv("path-api"))
                .orElse(String.valueOf(ApplicationProperties.getInstance().get("path-api")));
    }
}
