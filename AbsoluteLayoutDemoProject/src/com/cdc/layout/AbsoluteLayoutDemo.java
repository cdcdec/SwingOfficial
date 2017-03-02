package com.cdc.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteLayoutDemo {
	   private  void addComponentsToPane(Container pane) {
		   /**设置此容器的布局管理器。
		    *JPanel 缺省布局使用的是流式布局管理器(FlowLayout)
		    */
	        pane.setLayout(null);
	        JButton b1 = new JButton("one");
	        JButton b2 = new JButton("two");
	        JButton b3 = new JButton("three");

	        pane.add(b1);
	        pane.add(b2);
	        pane.add(b3);
	        /**
	         * Insets对象是容器边界的表示形式。
	         * 它指定容器必须在其各个边缘留出的空间。这个空间可以是边界、空白空间或标题。
	         */
	        Insets insets = pane.getInsets();
	        //获得组件的首选大小。
	        Dimension size = b1.getPreferredSize();
	        /**移动组件并调整其大小。由 x和 y指定左上角的新位置，由 width和 height指定新的大小。
	         * (int x,int y,int width,int height)
	         * x - 组件的新 x 坐标
	         * y - 组件的新 y 坐标
	         * width - 组件的新 width
	         * height - 组件的新 height
	        */
	        b1.setBounds(25 + insets.left, 5 + insets.top,
	                     size.width, size.height);
	        size = b2.getPreferredSize();
	        b2.setBounds(55 + insets.left, 40 + insets.top,
	                     size.width, size.height);
	        size = b3.getPreferredSize();
	        b3.setBounds(150 + insets.left, 15 + insets.top,
	                     size.width + 50, size.height + 20);
	    }

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	   private  void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("AbsoluteLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	        //Size and display the window.
	        Insets insets = frame.getInsets();
	        frame.setSize(300 + insets.left + insets.right,
	                      125 + insets.top + insets.bottom);
	        frame.setVisible(true);
	    }
	    
	    
	    public AbsoluteLayoutDemo(){
	    	createAndShowGUI();
	    }

}
