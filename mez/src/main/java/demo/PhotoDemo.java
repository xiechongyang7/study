package demo;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/12 下午 6:26
 * @since JDK1.8
 */
public class PhotoDemo {

    public static void main(String[] arg) throws IOException {
        Thumbnails.of("G:\\test\\微信图片_20190403195730.png")
                .scale(0.2f)
                .outputQuality(1f)
                .toFile("G:\\test\\新安印章.png");
        System.out.println(FileUtils.sizeOf(new File("G:\\test\\花.png")));
        System.out.println(FileUtils.sizeOf(new File("G:\\test\\花2.png")));
    }
}
