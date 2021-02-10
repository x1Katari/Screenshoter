import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyThread extends Thread  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private DbxClientV2 clientV2;
    private BufferedImage image;
    public MyThread(DbxClientV2 clientV2, BufferedImage image) {
        this.image = image;
        this.clientV2 = clientV2;
    }
    @Override
    public void run() {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            clientV2.files().uploadBuilder("/" + formatter.format(new Date()) + ".png").uploadAndFinish(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
