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

public class FinalWindow {
	private int count1, count2;
	private JFrame frame;
	private JPanel panel;
	private JTable router, digest;
	private Object data1[][], data2[][];
	private JScrollPane sp1, sp2;
	private String[] columns1 = {"Router Number", "Incoming Port", "Destination ID", "Outgoing Port"};
	private String[] columns2 = {"Router Number", "Incoming ID", "Stored ID"};
	private JLabel rtable, dtable;
	public FinalWindow(int routingTable[][], int path[], int routers) {
		//System.out.println("Hello final");
		for(int i = 0; i < routers; i++) {
			for(int j = 0; j < routers; j++) {
				System.out.print(routingTable[i][j] + " ");
			}
			System.out.println(" ");
		}
		for(int i = 0; i < routers; i++)
			System.out.println(path[i]);
		frame = new JFrame("IP Traceback");
		frame.setSize(new Dimension(1366, 768));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		rtable = new JLabel("Router Table");
		rtable.setFont(new Font("Arial", Font.BOLD, 24));
		rtable.setBounds(550, 20, 500, 80);
		dtable = new JLabel("Digest Table");
		dtable.setFont(new Font("Arial", Font.BOLD, 24));
		dtable.setBounds(550, 320, 500, 80);
		panel.add(rtable);
		panel.add(dtable);
		data1 = new Object[routers][4];
		data2 = new Object[routers][3];
		count1 = count2 = 0;
		for(int i = routers - 1; i >= 0; i--) {
			if(path[i] != -1) {
				data1[count1][0] = "R" + Integer.toString(path[i] + 1);
				data2[count2][0] = "R" + Integer.toString(path[i] + 1);
				if(count1 == 0) {
					data1[count1][1] = "None";
				}
				else {
					int port = 0;
					for(int j = 0; j < routers; j++) {
						if(routingTable[path[i]][j] != 0) {
							port++;
						}
				
					}
					data1[count1][1] = port;
				}
				if(i == 0) {
					data1[count1][2] = "None";
					data1[count1][3] = "None";
				}
				else {
					data1[count1][2] = path[i - 1] + 1;
					int port = 0;
					for(int j = 0; j < routers; j++) {
						try {
							if(routingTable[path[i - 1]][j] != 0) {
								port++;
							}
						}catch(ArrayIndexOutOfBoundsException e) {
							port++;
						}
					}
					data1[count1][3] = port + 1;
				}
				if(count2 == 0) {
					data2[count2][1] = "None";
				}
				else {
					if(path[i] != AbsoluteWindow.attackedRouter) {
						data2[count2][1] = path[i + 1] + 1;
					}
					else {
						data2[count2][1] = Integer.toString(routers + 1);
					}
				}
				data2[count2][2] = "";
				for(int j = 0; j < routers; j++) {
					if(routingTable[path[i]][j] != 0) {
						data2[count2][2] += Integer.toString(j + 1);
						data2[count2][2] += ", ";
					}
				}
				router = new JTable(data1, columns1);
				digest = new JTable(data2, columns2);
				sp1 = new JScrollPane(router);
				sp1.setBounds(400, 100,500,200);
				sp1.setBorder(BorderFactory.createLineBorder(Color.PINK, 25));
				router.setFillsViewportHeight(true);
				sp2 = new JScrollPane(digest);
				sp2.setBounds(400, 400, 500, 200);
				sp2.setBorder(BorderFactory.createLineBorder(Color.PINK, 25));
				digest.setFillsViewportHeight(true);
				panel.add(sp1);
				panel.add(sp2);
				count1++;
				count2++;
			}	
		}
		frame.add(panel);
		frame.setVisible(true);	
	}	
}
