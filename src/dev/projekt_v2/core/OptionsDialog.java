package dev.projekt_v2.core;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class OptionsDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private ButtonGroup btnGroup;
	
	private JLabel lblLookAndFeel;
	private JRadioButton btnDefaultLookAndFeel;
	private JRadioButton btnNimbusLookAndFeel;
	
	private JButton btnApplySettings;
	
	public OptionsDialog(JFrame parent) {
		super(parent);
	
		this.setTitle("Ustawienia");
		this.setSize(400, 200);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setLayout(null);
		
		lblLookAndFeel = new JLabel("Wybierz \"Look And Feel\" kt�ry ci si� podoba:");
		lblLookAndFeel.setBounds(30, 5, 300, 30);
		
		btnGroup = new ButtonGroup();
		
		btnDefaultLookAndFeel = new JRadioButton("Domy�lny \"Look and Feel\"");
		btnDefaultLookAndFeel.setBounds(30, 40, 250, 30);
		btnDefaultLookAndFeel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application.applyLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

				SwingUtilities.updateComponentTreeUI(getContentPane());

				ApplicationOptions.IN_USE_LOOK_AND_FEEL = ApplicationOptions.USE_DEFAULT;
			}
		});
		
		btnNimbusLookAndFeel = new JRadioButton("Nimbus \"Look and Feel\"");
		btnNimbusLookAndFeel.setBounds(30, 75, 250, 30);
		btnNimbusLookAndFeel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application.applyLookAndFeel("Nimbus");
				
				SwingUtilities.updateComponentTreeUI(getContentPane());
				
				ApplicationOptions.IN_USE_LOOK_AND_FEEL = ApplicationOptions.USE_NIMBUS;
			}
		});
		
		btnGroup.add(btnDefaultLookAndFeel);
		btnGroup.add(btnNimbusLookAndFeel);
		
		if(ApplicationOptions.IN_USE_LOOK_AND_FEEL == ApplicationOptions.USE_DEFAULT)
			btnGroup.setSelected(btnDefaultLookAndFeel.getModel(), true);
		else
			btnGroup.setSelected(btnNimbusLookAndFeel.getModel(), true);
		
		btnApplySettings = new JButton("OK");
		btnApplySettings.setBounds(270, 110, 100, 30);
		btnApplySettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add(lblLookAndFeel);
		
		this.add(btnDefaultLookAndFeel);
		this.add(btnNimbusLookAndFeel);
		this.add(btnApplySettings);
		
		this.setVisible(true);
	}
	
}
