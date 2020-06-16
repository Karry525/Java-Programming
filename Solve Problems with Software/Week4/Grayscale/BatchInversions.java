
/**
 * 在这里给出对类 BatchInversions 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions {
    ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		
		for (Pixel pixel: outImage.pixels()) {
			
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			pixel.setRed(255-inPixel.getRed());
		
			pixel.setGreen(255-inPixel.getGreen());
			
			pixel.setBlue(255-inPixel.getBlue());
		}
		
		return outImage;
    }
    void selectAndConvert(){
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource inversion = makeInversion(inImage);
            String fname=inImage.getFileName();
            String newName="inverted-"+fname;
            inversion.setFileName(newName);
            inversion.draw();
            inversion.save();
        }
    }
}
