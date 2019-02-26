/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Arista;
import Modelo.Aristas;
import Modelo.Puntos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Asus
 */
public class VentanaPuntos extends JFrame{
    private Puntos puntos = new Puntos();
    private Aristas aristas = new Aristas();
    
    private JButton bAñadeAristas = new JButton("Añade Aristas");
    private PanelPuntos panelPuntos = new PanelPuntos(puntos, aristas);
    
    private DialogAñadeArista dialogoAñadeArista = new DialogAñadeArista(this);
    
    public VentanaPuntos(){
        super("Une Puntos");
        
        add(panelPuntos, BorderLayout.CENTER);
        
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAñadeAristas);
        add(pB, BorderLayout.SOUTH);
        
        bAñadeAristas.addActionListener(new manejadorBotonAñade());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private class manejadorBotonAñade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int[] ptos = dialogoAñadeArista.muestra();
            
            if(ptos != null){
                for(int i=0; i<ptos.length-1; i++)
                    
                    aristas.añade(new Arista(puntos.punto(ptos[i]),puntos.punto(ptos[i+1])));
                
                panelPuntos.repaint();
            }
        }
    }
    
}
