package com.cdc.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutDemo {
	 public static boolean RIGHT_TO_LEFT = false;
	    
	    private void addComponentsToPane(Container pane) {
	        
	        if (!(pane.getLayout() instanceof BorderLayout)) {
	            pane.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        }
	        
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        }
	        
	        JButton button = new JButton("Button 1 (PAGE_START)");
	        pane.add(button, BorderLayout.PAGE_START);
	        
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        button = new JButton("Button 2 (CENTER)");
	        /**将组件的首选大小设置为常量值。
	         * 对 getPreferredSize 的后续调用总是返回此值。将首选大小设置为 null 可还原默认的行为。
	         */
	        button.setPreferredSize(new Dimension(300, 200));
	        pane.add(button, BorderLayout.CENTER);
	        
	        button = new JButton("Button 3 (LINE_START)");
	        pane.add(button, BorderLayout.LINE_START);
	        
	        button = new JButton("Long-Named Button 4 (PAGE_END)");
	        pane.add(button, BorderLayout.PAGE_END);
	        
	        button = new JButton("5 (LINE_END)");
	        pane.add(button, BorderLayout.LINE_END);
	    }
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event dispatch thread.
	     */
	    private  void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("BorderLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	        //Use the content pane's default BorderLayout. No need for
	        //setLayout(new BorderLayout());
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    public BorderLayoutDemo(){
	    	createAndShowGUI();
	    }

}
