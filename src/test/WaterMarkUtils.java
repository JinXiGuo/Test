package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class WaterMarkUtils {
	/**
	 * 图片添加水印
	 * @param srcImgPath 需要添加水印的图片的路径
	 * @param outImgPath 添加水印后图片输出路径
	 * @param markContentColor 水印文字的颜色
	 * @param waterMarkContent 水印的文字
	 */
	public void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {
		try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcImgFile);
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印，图片大小
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight+100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            //Font font = new Font("Courier New", Font.PLAIN, 12);
            Font font = new Font("宋体", Font.PLAIN, 50);  
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            
            g.setFont(font);
            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
            int y = srcImgHeight - 3;
            //int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
            //int y = srcImgHeight / 2;
            g.drawString(waterMarkContent, x, y+100);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 获取水印文字总长度
	 * @param waterMarkContent 水印的文字
	 * @param g
	 * @return 水印文字总长度
	 */
    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
    
    public static void main(String[] args) {
    	// 原图位置, 输出图片位置, 水印文字颜色, 水印文字
        new WaterMarkUtils().mark("d:/t/t01.png", "d:/t/t01.png", Color.red, "水印效果测试");
        new WaterMarkUtils().mark("d:/t/t01.png", "d:/t/t01.png", Color.red, "水印效果测试2水印效果测试2水印效果测试2水印效果测试2水印效果测试2");
   }
}
