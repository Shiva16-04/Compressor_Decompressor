package User_Interface;

import Compression_DeCompression.Compressor;
import Compression_DeCompression.deCompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class App_Frame implements ActionListener {
    JFrame frame;
    JButton compress;
    JButton decompress;
    TextField field;
    JLabel label;
    App_Frame(){
        frame =new JFrame("Beetle Compressor_DeCompressor");
        frame.setSize(1000, 500);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(null);
        compress=new JButton("Compress");
        compress.setBounds(300, 250, 200,30);
        frame.add(compress);
        decompress=new JButton("deCompress");
        decompress.setBounds(500, 250, 200,30);
        frame.add(decompress);
        field =new TextField();
        field.setBounds(525, 300, 50, 20);
        frame.add(field);
        label=new JLabel("Decompression File type (eg jpg, pdf...)");
        label.setBounds(300, 300 , 250,20);
        frame.add(label);
        compress.addActionListener(this);
        decompress.addActionListener(this);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compress){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                }catch (Exception error){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        if(e.getSource()==decompress){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    deCompressor.method(file, field.getText());
                }catch (Exception error){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
