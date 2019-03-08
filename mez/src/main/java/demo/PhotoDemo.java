package demo;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/2/12 下午 6:26
 * @author xiechongyang
 */
public class PhotoDemo {

    public static void main(String[] arg) throws IOException {
        Thumbnails.of("G:\\test\\花.jpeg")
                .scale(0.1f)
                .outputQuality(0.1f)
                .toFile("G:\\test\\花2.jpeg");
        System.out.println(FileUtils.sizeOf(new File("G:\\test\\花.jpeg")));
        System.out.println(FileUtils.sizeOf(new File("G:\\test\\花2.jpeg")));
    }
}
