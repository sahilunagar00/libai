/*
 * MIT License
 *
 * Copyright (c) 2009-2016 Ignacio Calderon <https://github.com/kronenthaler>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package demos.search;

import libai.search.State;
import libai.search.DFS;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author kronenthaler
 */
public class DFSPanel extends javax.swing.JPanel {
	/**
	 * Creates new form DFSPanel
	 */
	public DFSPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerTxt = new javax.swing.JTextArea();
        inputTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Bread First Search or BFS, is a determinist way to find solutions to certain problems. The BFS search always gives the best solution possible if exists.\nFor instance, the 8-puzzle. The 8-puzzle consist in a board with 3 rows and columns, in each cell thereis a token with a number in {1,8} and an empty space. The goal of the puzzle is move some of the tokens up, down, left or right to the empty space many times as necessary to sort the tokens in decreasing order leaving the empty space in the third row and third column.\n\nFor example, let the following board:\n1 2 3\n4 5 6\n   7 8\nYou need 2 moves to the right to complete the solution. In the textfield below you can introduce a configuration for the board. Use a dot (.) for the empty space. In the panel below will show the sequence of steps to obtain the solution (if exist).");
        jScrollPane1.setViewportView(jTextArea1);

        answerTxt.setColumns(20);
        answerTxt.setRows(5);
        jScrollPane2.setViewportView(answerTxt);

        inputTxt.setText(".87654321");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(inputTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		DFS bfs = new DFS();
		for (int i = 1; i <= 8; i++) {
			if (inputTxt.getText().indexOf('0' + i) == -1 || inputTxt.getText().length() < 8 || inputTxt.getText().indexOf('.') == -1) {
				JOptionPane.showMessageDialog(this, "Invalid input");
				return;
			}
		}

		State init = new Node(inputTxt.getText(), null, '\0');
		Node ans = (Node) bfs.search(init);
		if (ans != null) {
			answerTxt.setText("");
			ans.printSolution(answerTxt);
		} else
			answerTxt.setText("No solution");
}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerTxt;
    private javax.swing.JTextField inputTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
	static Node target = new Node("12345678.", null, '\0');

	static class Node extends State {
		String table = "";
		Node parent = null;
		char move = ' ';
		int point = 0;
		static int stepsx[] = {0, 0, 1, -1};
		static int stepsy[] = {1, -1, 0, 0};
		static char dir[] = {'u', 'd', 'l', 'r'};
		//down, up, right, left

		Node(String t, Node p, char m) {
			table = t;
			parent = p;
			move = m;
			point = table.indexOf('.');
		}

		public void printSolution(JTextArea out) {
			if (parent != null)
				parent.printSolution(out);
			out.append(table.substring(0, 3) + "\n" + table.substring(3, 6) + "\n" + table.substring(6) + "\n\n");
		}

		@Override
		public double getHeuristicCost() {
			return 0;
		}

		@Override
		public double getCost() {
			Node current = this.parent;
			int cont = 0;
			while (current != null) {
				cont++;
				current = current.parent;
			}
			return cont;
		}

		@Override
		public ArrayList<State> getCandidates() {
			//do until 4 moves.
			ArrayList<State> candidates = new ArrayList<>();
			int row = point / 3;
			int col = point % 3;
			for (int i = 0; i < 4; i++) {
				if (i == 0 && row == 2)
					continue;
				if (i == 1 && row == 0)
					continue;
				if (i == 3 && col == 0)
					continue;
				if (i == 2 && col == 2)
					continue;
				char t = table.charAt((row + stepsy[i]) * 3 + (col + stepsx[i]));
				String newstate = table.replace('.', '#').replace(t, '.');
				newstate = newstate.replace('#', t);
				candidates.add(new Node(newstate, this, dir[i]));
			}
			return candidates;
		}

		@Override
		public int compareTo(State o) {
			return table.compareTo(((Node) o).table);
		}

		@Override
		public String toString() {
			return table;
		}

		@Override
		public int hashCode() {
			return table.hashCode();
		}

		@Override
		public boolean equals(Object o){
			return o != null && o instanceof Node && table.equals(((Node)o).table);
		}

		@Override
		public boolean isSolution() {
			return table.equals(target.table);
		}
	}
}
