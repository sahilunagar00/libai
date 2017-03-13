package demos;

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

/**
 * @author kronenthaler
 */
public class Examples extends javax.swing.JFrame {
	/**
	 * Creates new form Examples
	 */
	public Examples() {
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

		jTabbedPane2 = new javax.swing.JTabbedPane();
		fuzzyPanel1 = new demos.fuzzy.FuzzyPanel();
		jTabbedPane3 = new javax.swing.JTabbedPane();
		binaryPanel1 = new demos.genetic.BinaryPanel();
		permutation1 = new demos.genetic.Permutation();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		perceptronPanel1 = new demos.nn.PerceptronPanel();
		mPLPanel1 = new demos.nn.MPLPanel();
		rBFPanel1 = new demos.nn.RBFPanel();
		lVQPanel1 = new demos.nn.LVQPanel();
		sVMPanel1 = new demos.nn.SVMPanel();
		kohonenPanel1 = new demos.nn.KohonenPanel();
		competitivePanel1 = new demos.nn.CompetitivePanel();
		hebbPanel1 = new demos.nn.HopfieldPanel();
		jTabbedPane4 = new javax.swing.JTabbedPane();
		bFSPanel1 = new demos.search.BFSPanel();
		dFSPanel1 = new demos.search.DFSPanel();
		aStarPanel1 = new demos.search.AStarPanel();
		treesPanel1 = new demos.trees.TreesPanel();
		jTabbedPane5 = new javax.swing.JTabbedPane();
		antSystemPanel1 = new demos.ants.AntSystemPanel();
		antColonySystemPanel1 = new demos.ants.AntColonySystemPanel();
		antSystemRankPanel1 = new demos.ants.AntSystemRankPanel();
		elitistAntSystemPanel1 = new demos.ants.ElitistAntSystemPanel();
		antQPanel1 = new demos.ants.AntQPanel();
		mMASPanel1 = new demos.ants.MMASPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Examples libai");

		jTabbedPane2.addTab("Fuzzy", fuzzyPanel1);

		jTabbedPane3.addTab("Binary", binaryPanel1);
		jTabbedPane3.addTab("Permutation", permutation1);

		jTabbedPane2.addTab("Genetic", jTabbedPane3);

		jTabbedPane1.addTab("Adaline", perceptronPanel1);
		jTabbedPane1.addTab("MultiLayerPerceptron", mPLPanel1);
		jTabbedPane1.addTab("RadialBasisFunction", rBFPanel1);
		jTabbedPane1.addTab("LearningVectorQuantization", lVQPanel1);
		jTabbedPane1.addTab("SupportVectorMachine", sVMPanel1);
		jTabbedPane1.addTab("Kohonen", kohonenPanel1);
		jTabbedPane1.addTab("Competitive", competitivePanel1);
		jTabbedPane1.addTab("Hopfield", hebbPanel1);

		jTabbedPane2.addTab("Neural Networks", jTabbedPane1);

		jTabbedPane4.addTab("BreadthFirstSearch", bFSPanel1);
		jTabbedPane4.addTab("DepthFirstSearch", dFSPanel1);
		jTabbedPane4.addTab("A*", aStarPanel1);

		jTabbedPane2.addTab("Search", jTabbedPane4);

		treesPanel1.setEnabled(false);

		javax.swing.GroupLayout treesPanel1Layout = new javax.swing.GroupLayout(treesPanel1);
		treesPanel1.setLayout(treesPanel1Layout);
		treesPanel1Layout.setHorizontalGroup(
				treesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 634, Short.MAX_VALUE)
		);
		treesPanel1Layout.setVerticalGroup(
				treesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 491, Short.MAX_VALUE)
		);

		jTabbedPane2.addTab("Decision Trees", treesPanel1);

		jTabbedPane5.addTab("AntSystem", antSystemPanel1);
		jTabbedPane5.addTab("AntColonySystem", antColonySystemPanel1);
		jTabbedPane5.addTab("AntSystemRank", antSystemRankPanel1);
		jTabbedPane5.addTab("ElististAntSystem", elitistAntSystemPanel1);
		jTabbedPane5.addTab("AntQ", antQPanel1);
		jTabbedPane5.addTab("MMAS", mMASPanel1);

		jTabbedPane2.addTab("Ants", jTabbedPane5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jTabbedPane2)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jTabbedPane2)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Examples().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private demos.search.AStarPanel aStarPanel1;
	private demos.ants.AntColonySystemPanel antColonySystemPanel1;
	private demos.ants.AntQPanel antQPanel1;
	private demos.ants.AntSystemPanel antSystemPanel1;
	private demos.ants.AntSystemRankPanel antSystemRankPanel1;
	private demos.search.BFSPanel bFSPanel1;
	private demos.genetic.BinaryPanel binaryPanel1;
	private demos.nn.CompetitivePanel competitivePanel1;
	private demos.search.DFSPanel dFSPanel1;
	private demos.ants.ElitistAntSystemPanel elitistAntSystemPanel1;
	private demos.fuzzy.FuzzyPanel fuzzyPanel1;
	private demos.nn.HopfieldPanel hebbPanel1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private javax.swing.JTabbedPane jTabbedPane3;
	private javax.swing.JTabbedPane jTabbedPane4;
	private javax.swing.JTabbedPane jTabbedPane5;
	private demos.nn.KohonenPanel kohonenPanel1;
	private demos.nn.LVQPanel lVQPanel1;
	private demos.ants.MMASPanel mMASPanel1;
	private demos.nn.MPLPanel mPLPanel1;
	private demos.nn.PerceptronPanel perceptronPanel1;
	private demos.genetic.Permutation permutation1;
	private demos.nn.RBFPanel rBFPanel1;
	private demos.nn.SVMPanel sVMPanel1;
	private demos.trees.TreesPanel treesPanel1;
	// End of variables declaration//GEN-END:variables
}
