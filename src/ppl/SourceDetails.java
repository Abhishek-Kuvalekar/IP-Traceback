/*****************************************************************************
 * Copyright (C) Kuvalekar Abhishek Vijay kuvalekarav15.it@coep.ac.in
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *****************************************************************************/
package ppl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
public class  SourceDetails{
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JTextField ip;
	public JTextField browse;
	public JFrame frame;
	public ImageIcon image;
	public JButton ok,file;
	public String filename1;

	SourceDetails(String filename) {
		frame = new JFrame("SourceDetails");
		frame.setSize(600, 600);
		frame.setLayout(null);
		label1 = new JLabel("Source Details");
		label1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC ,32));
		label1.setLocation(150,50);
		label1.setSize(300,35);
		frame.add(label1);
		label3 = new JLabel("Choose File");
		label3.setFont(new Font("Arial",Font.PLAIN,20));
		label3.setLocation(150,250);
		label3.setSize(150,24);
		frame.add(label3);
		browse = new JTextField(50);
		browse.setLocation(300,250);
		browse.setSize(150,24);
		frame.add(browse);
		ok = new JButton("OK");
		ok.setLocation(230,320);
		ok.setSize(90,26);
		ok.setBackground(Color.MAGENTA);
		frame.add(ok);
		image = new ImageIcon("/home/dell/eclipse/eclipse_workspace/ppl/folder.png");
		file = new JButton(image);
		file.setLocation(470,250);
		file.setSize(30,30);
		file.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == file){
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(file);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    filename1 = selectedFile.getAbsolutePath();
				    AbsoluteWindow.filename = filename1;
				    browse.setText(selectedFile.getAbsolutePath());
				}
			}
		}
		});
		frame.add(file);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
