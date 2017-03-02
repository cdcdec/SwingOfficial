package com.cdc.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BoxAlignmentDemo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2668500458281041870L;

	public BoxAlignmentDemo() {
		super(new BorderLayout());
		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel buttonRow = new JPanel();
		// Use default FlowLayout.
		buttonRow.add(createButtonRow(false));
		buttonRow.add(createButtonRow(true));
		tabbedPane.addTab("Altering alignments", buttonRow);

		JPanel labelAndComponent = new JPanel();
		// Use default FlowLayout.
		labelAndComponent.add(createLabelAndComponent(false));
		labelAndComponent.add(createLabelAndComponent(true));
		tabbedPane.addTab("X alignment mismatch", labelAndComponent);

		JPanel buttonAndComponent = new JPanel();
		// Use default FlowLayout.
		buttonAndComponent.add(createYAlignmentExample(false));
		buttonAndComponent.add(createYAlignmentExample(true));
		tabbedPane.addTab("Y alignment mismatch", buttonAndComponent);

		// Add tabbedPane to this panel.
		add(tabbedPane, BorderLayout.CENTER);

		createAndShowGUI();
	}

	private JPanel createButtonRow(boolean changeAlignment) {
		JButton button1 = new JButton("A JButton",
				createImageIcon("images/middle.gif"));
		button1.setVerticalTextPosition(AbstractButton.BOTTOM);
		button1.setHorizontalTextPosition(AbstractButton.CENTER);

		JButton button2 = new JButton("Another JButton",
				createImageIcon("images/geek-cght.gif"));
		button2.setVerticalTextPosition(AbstractButton.BOTTOM);
		button2.setHorizontalTextPosition(AbstractButton.CENTER);

		String title;
		if (changeAlignment) {
			title = "Desired";
			button1.setAlignmentY(BOTTOM_ALIGNMENT);
			button2.setAlignmentY(BOTTOM_ALIGNMENT);
		} else {
			title = "Default";
		}

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createTitledBorder(title));
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		pane.add(button1);
		pane.add(button2);
		return pane;
	}

	private JPanel createLabelAndComponent(boolean doItRight) {
		JPanel pane = new JPanel();

		JComponent component = new JPanel();
		Dimension size = new Dimension(150, 100);
		component.setMaximumSize(size);
		component.setPreferredSize(size);
		component.setMinimumSize(size);
		TitledBorder border = new TitledBorder(new LineBorder(Color.black),
				"A JPanel", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component.setBorder(border);

		JLabel label = new JLabel("This is a JLabel");
		String title;
		if (doItRight) {
			title = "Matched";
			label.setAlignmentX(CENTER_ALIGNMENT);
		} else {
			title = "Mismatched";
		}

		pane.setBorder(BorderFactory.createTitledBorder(title));
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(label);
		pane.add(component);
		return pane;
	}

	private JPanel createYAlignmentExample(boolean doItRight) {
		JPanel pane = new JPanel();
		String title;

		JComponent component1 = new JPanel();
		Dimension size = new Dimension(100, 50);
		component1.setMaximumSize(size);
		component1.setPreferredSize(size);
		component1.setMinimumSize(size);
		TitledBorder border = new TitledBorder(new LineBorder(Color.black),
				"A JPanel", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component1.setBorder(border);

		JComponent component2 = new JPanel();
		size = new Dimension(100, 50);
		component2.setMaximumSize(size);
		component2.setPreferredSize(size);
		component2.setMinimumSize(size);
		border = new TitledBorder(new LineBorder(Color.black), "A JPanel",
				TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component2.setBorder(border);

		if (doItRight) {
			title = "Matched";
		} else {
			component1.setAlignmentY(TOP_ALIGNMENT);
			title = "Mismatched";
		}

		pane.setBorder(BorderFactory.createTitledBorder(title));
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		pane.add(component1);
		pane.add(component2);
		return pane;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	private ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = BoxAlignmentDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("BoxAlignmentDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		this.setOpaque(true); // content panes must be opaque
		frame.setContentPane(this);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
