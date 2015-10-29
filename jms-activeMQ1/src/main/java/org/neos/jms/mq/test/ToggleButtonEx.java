package org.neos.jms.mq.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import javax.swing.border.LineBorder;

public class ToggleButtonEx extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JToggleButton redBtn;
	private JToggleButton greenBtn;
	private JToggleButton blueBtn;
	private JPanel display;

	public ToggleButtonEx() {

		initUI();
	}

	private void initUI() {

		redBtn = new JToggleButton("red");
		redBtn.addActionListener(this);

		greenBtn = new JToggleButton("green");
		greenBtn.addActionListener(this);

		blueBtn = new JToggleButton("blue");
		blueBtn.addActionListener(this);

		display = new JPanel();
		display.setPreferredSize(new Dimension(300, 300));
		display.setBorder(LineBorder.createGrayLineBorder());
		display.setBackground(Color.WHITE);

		createLayout(redBtn, greenBtn, blueBtn, display);

		setTitle("JToggleButton");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(
				gl.createSequentialGroup()
						.addGroup(
								gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]).addComponent(arg[2]))
						.addPreferredGap(UNRELATED).addComponent(arg[3]));

		gl.setVerticalGroup(gl.createParallelGroup(CENTER)
				.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]).addComponent(arg[2]))
				.addComponent(arg[3]));

		gl.linkSize(redBtn, greenBtn, blueBtn);

		pack();
	}

	
	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ToggleButtonEx ex = new ToggleButtonEx();
				ex.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	 public void actionPerformed(ActionEvent e) {

		Color color = display.getBackground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();

		if (e.getActionCommand().equals("red")) {
			if (red == 0) {
				red = 255;
			} else {
				red = 0;
			}
		}

		if (e.getActionCommand().equals("green")) {
			if (green == 0) {
				green = 255;
			} else {
				green = 0;
			}
		}

		if (e.getActionCommand().equals("blue")) {
			if (blue == 0) {
				blue = 255;
			} else {
				blue = 0;
			}
		}

		Color setCol = new Color(red, green, blue);
		display.setBackground(setCol);
	}*/
	 
}