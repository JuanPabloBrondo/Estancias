
import javax.swing.JOptionPane;

public class PruebaJjoin {

    public static void main(String[] args) {
//JOptionPane.showMessageDialog(Componente padre, mensaje, título, tipo de mensaje, icono);
     JOptionPane.showMessageDialog(null, "Como va?", "Saludo", 3);
//JOptionPane.showConfirmDialog(Componente padre, mensaje, titulo, tipo de seleccion, tipo de mensaje, icono);
System.out.println(JOptionPane.showConfirmDialog(null, "Como va?", "Pregunta", 1, 2));
//JOptionPane.showInputDialog(padre, mensaje, titulo, tipo de seleccion, tipo de mensaje, icono, opciones, valor inicial);
System.out.println(JOptionPane.showInputDialog(null, "Elegí bien","Se viene",1,null ,new Object[] { "Seleccione","Amarillo", "Azul", "Rojo" },"Seleccione"));
  
Object color = JOptionPane.showInputDialog(null,"Seleccione Un Color",
   "COLORES", JOptionPane.QUESTION_MESSAGE, null,
  new Object[] { "Seleccione","Amarillo", "Azul", "Rojo" },"Seleccione");
        System.out.println(color);
        
        //http://www.laurafolgado.es/desarrollointerfaces/2015/10/cuadros-de-dialogo-con-joptionpane/

//https://codejavu.blogspot.com/2013/12/ejemplo-joptionpane.html
    }
}