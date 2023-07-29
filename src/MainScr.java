
import javax.swing.*;
import java.awt.*;

public class MainScr {
        
    JFrame frame;
    JLabel text=new JLabel("Electricity Management System");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    MainScr() {
        createGUI();
        addText();
        addProgressBar();
        runningPBar();
    }
    
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null); 
        frame.setUndecorated(true);
      //  frame.setSize(600,600); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen

        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK); 
        frame.setVisible(true);
    }

    
    public void addText()
    {
        text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(460,50,600,600);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);

        text.setForeground(Color.ORANGE);
        frame.add(text);
    }
    
    /*public void addProgressBar(){
        progressBar.setBounds(100,380,400,30); 
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.black);
        progressBar.setForeground(Color.ORANGE);
        progressBar.setValue(0);
       
        frame.add(progressBar);
    }*/
    public void addProgressBar(){
        progressBar.setPreferredSize(new Dimension(400, 30)); 
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.black);
        progressBar.setForeground(Color.ORANGE);
        progressBar.setValue(0);
        progressBar.setBounds((frame.getWidth() - progressBar.getPreferredSize().width) / 2, frame.getHeight() / 2, progressBar.getPreferredSize().width, progressBar.getPreferredSize().height);
        frame.add(progressBar);
    }
    
    public void runningPBar(){
        int i=0;
        while( i<=100)
        {
            try{
                Thread.sleep(40);   
                progressBar.setValue(i);    
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
   
    
    public static void main(String[] args) {
        new MainScr();
        new Login();
        
    }
}


