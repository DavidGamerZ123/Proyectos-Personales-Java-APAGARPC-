import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextField;
public class Principal extends JFrame implements ActionListener {
    private JTextField textField;
    private String texto = "";
 public Principal(){
  setLayout(new FlowLayout());
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  JButton bapagar=new JButton("Apagar");
  textField=new JTextField();
  textField.setColumns(10);
  add(textField);
  textField.addActionListener(this);
  setTitle("Para mi ale");
  getContentPane().setBackground(new Color(0,0,0));
  bapagar.addActionListener(new ActionListener(){
       @Override
   public void actionPerformed(ActionEvent e) {
    Runtime r=Runtime.getRuntime();
    textField.setBackground(new Color(255,255,255));
    textField.setForeground(new Color(0,0,0));
    textField.setFont(new Font("Bell MT" , 3 , 14));
    texto+= textField.getText();
    Integer.parseInt(texto);
    //parsear el texto a int
    int numero=Integer.parseInt(texto);
    numero = numero*60;
    try {
     r.exec("shutdown -s -t "+numero);
    } catch (IOException ex) {
     ex.printStackTrace();
    }
   }
  });
  JButton breiniciar=new JButton("Reiniciar");
  breiniciar.addActionListener(new ActionListener(){
   @Override
     public void actionPerformed(ActionEvent e) {
    Runtime r=Runtime.getRuntime();
    texto+= textField.getText();
    Integer.parseInt(texto);
    //parsear el texto a int
    int numero=Integer.parseInt(texto);
    numero = numero*60;
     //texfield indica cuando se reiniciar√° el computador
    try {
        r.exec("shutdown -r -t "+numero);
        } catch (IOException ex) {
        ex.printStackTrace();
    }
   } 
  });
  add(bapagar);
  add(breiniciar);
 }
 public static void main(String arg[]){
  Principal p=new Principal();
  p.setBounds(0, 0, 400, 80);
  p.setVisible(true);
  p.setLocationRelativeTo(null);
  p.setResizable(false);
 }
@Override
public void actionPerformed(ActionEvent e) {
  System.out.println("Funciona");
  
}
}