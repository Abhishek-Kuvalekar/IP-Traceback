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
public class RouterTables {
	int routers;
	public RouterTables(float matrix[][], int routingTable[][], int routers) {
		this.routers = routers;
		//routingTable = new int[routers][routers];
		for(int i = 0; i < routers; i++) {
			for(int j = 0; j < routers; j++) {
				if(matrix[i][j] != 0)
					routingTable[i][j] = 1;
				else 
					routingTable[i][j] = 0;
			}
		}
	}
}
