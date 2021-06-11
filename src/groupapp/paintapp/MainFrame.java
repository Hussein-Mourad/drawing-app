/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupapp.paintapp;

//import groupapp.model.DrawingPanel;
import javax.swing.JFrame;
import java.awt.Point;


public class MainFrame extends JFrame {
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
                
		setLocation(new Point(80, 50));		
		setTitle("Painter");
		
		DrawingPanel pnl  =  new DrawingPanel();
		getContentPane().add(pnl);
		pnl.setVisible(true);

	}
}
