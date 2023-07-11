package Compression_DeCompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


public class deCompressor {
    public static void method(File file, String extension)throws IOException {

        String parentPath= file.getParent();
        //taking input with the help of input file reader
        FileInputStream fis=new FileInputStream(file);
        //decompressing the input and writing it in .gz file format
        GZIPInputStream gZip=new GZIPInputStream(fis);
        //writing the converted output stream
        FileOutputStream fos=new FileOutputStream(parentPath+"/deCompressedFile."+extension);

        //creating byte array to store bits from input stream
        byte []buffer=new byte[1024];
        int len;

        //reading io bits to array and writing it to
        while((len=gZip.read(buffer))!=-1) {
            fos.write(buffer, 0, len);
        }
        gZip.close();
        fos.close();
        fis.close();
    }
}
