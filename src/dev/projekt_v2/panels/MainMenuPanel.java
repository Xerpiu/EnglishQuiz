package dev.projekt_v2.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import dev.projekt_v2.core.ApplicationFrame;
import dev.projekt_v2.core.ApplicationOptions;
import dev.projekt_v2.core.OptionsDialog;
import dev.projekt_v2.gfx.ImageStorage;

public class MainMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ApplicationFrame parent;
	private OptionsDialog optionsDialog;
	
	private JButton btnStart;
	private JButton btnAuthors;
	private JButton btnOptions;
	private JButton btnExit;
	
	private JTextArea txtAreaAuthors;
	
	public MainMenuPanel(ApplicationFrame parent) {
		this.parent = parent;
		
		setSize(parent.getSize());
	}
	
	public void create() {
		btnStart = createButton("Rozpocznij Quiz!", 100);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.showDifficultyMenu();
			}
		});
		
		btnAuthors = createButton("Poka� Tw�rc�w", 250);
		btnAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaAuthors.setVisible(!txtAreaAuthors.isVisible());
				btnAuthors.setText( ( txtAreaAuthors.isVisible() ) ? "Ukryj Tw�rc�w" : "Poka� Tw�rc�w" );
			}
		});
		
		btnOptions = createButton("Ustawienia", 400);
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(optionsDialog == null || !optionsDialog.isVisible())
					optionsDialog = new OptionsDialog(parent);
			}
		});
		
		btnExit = createButton("Wyj�cie", 550);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.closeProgram();
			}
		});
		
		txtAreaAuthors = new JTextArea();
		txtAreaAuthors.setVisible(false);
		txtAreaAuthors.setTabSize(2);
		txtAreaAuthors.setLineWrap(true);
		txtAreaAuthors.setText("\tQuiz zosta� stworzony przez:\n\n\t� Patryk Tyliba\n\t� Dominik Karo�\n\t� S�awomir Kwieci�ski"
				+ "\n\n\tPraca nad programem trwa�a niespe�na 2 miesi�ce, rozpocz�ta \nzosta�a 2017.02.13, a zako�czona 2017.03.27.\n\n\t"
				+ "G�ownym celem naszego quizu jest sprawdzenie, oraz mo�liwo�� \npoprawy znajomo�ci j�zyka angielskiego.\n\n\n\n �yczymy powodzenia i jak najlepszych wynik�w w naszym quizie!!!");
		txtAreaAuthors.setBounds(370, 100, 550, 500);
		txtAreaAuthors.setEditable(false);
		
		txtAreaAuthors.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 18));
	
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtAreaAuthors.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		this.add(txtAreaAuthors);
	}
	
	public JButton createButton(String str, int y) {
		JButton btn = new JButton(str);
		btn.setBounds(64, y, 200, 50);
		
		this.add(btn);
		
		return btn;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ImageStorage.getImage(ApplicationOptions.IN_USE_LOOK_AND_FEEL), 0, 0, null);
	}
	
}
