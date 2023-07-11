package Compression_DeCompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file)throws IOException {
        String parentPath=file.getParent();
        //taking input with the help of input file reader
        FileInputStream fis=new FileInputStream(file);
        //converting to output with the help of output reader
        FileOutputStream fos=new FileOutputStream(parentPath+"/CompressedFile.gz");
        //compressing the output and writing it in .gz file format
        GZIPOutputStream gZip=new GZIPOutputStream(fos);

        //creating byte array to store bits from input stream
        byte []buffer=new byte[1024];
        int len=0;

        //reading io bits to array and writing it to
        while((len=fis.read(buffer))!=-1){
            gZip.write(buffer,0, len);
        }
        gZip.close();
        fis.close();
        fos.close();
    }
}
