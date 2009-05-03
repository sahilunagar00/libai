package demos.nn;

import net.sf.libai.common.*;
import net.sf.libai.nn.*;
import net.sf.libai.nn.supervised.*;

/**
 *
 * @author kronenthaler
 */
public class MPLPanel extends javax.swing.JPanel {
	static double f(double x){
		return Math.sin(x) + Math.cos(x);
	}
	
    /** Creates new form MPLPPanel */
    public MPLPanel() {
		initComponents();
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jProgressBar1.setString("training");
        jProgressBar1.setStringPainted(true);

        jButton1.setText("Train");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextPane1.setText("Train an MLP network to learn the equation: sin(x) + cos(x) for x in [1, 41) using an spacing of 0.1 for training and 0.33 for test.\nThe network has 3 layers of 1, 4 and 1 neurons and functions, identity, sigmoid and identity respectevely\n\n");
        jScrollPane1.setViewportView(jTextPane1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jProgressBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		jTextPane1.setText("");
		new Thread(new Runnable(){
			public void run(){
				int n=40;
				int m=1;
				int l=1;
				int test=12;
				Matrix []p=new Matrix[n+test];
				Matrix []t=new Matrix[n+test];
				double delta=0.1;
				double x=0;
				for(int i=0;i<n;i++,x+=delta){
					p[i]=new Matrix(m,1);
					t[i]=new Matrix(l,1);

					p[i].position(0,0,x);
					t[i].position(0,0,f(x));
				}

				delta=0.33;
				x=0;
				for(int i=n;i<n+test && x<4;i++,x+=delta){
					p[i]=new Matrix(m,1);
					t[i]=new Matrix(l,1);

					p[i].position(0,0,x);
					t[i].position(0,0,f(x));
				}

				int nperlayer[]={m,4,l};
				MLP net = new MLP(nperlayer,
									new Function[]{NeuralNetwork.identity,NeuralNetwork.sigmoid,NeuralNetwork.identity},
									-0.4);
				net.setProgressBar(jProgressBar1);
				net.train(p, t, 0.2, 50000, 0, n);

				jTextPane1.setText(jTextPane1.getText()+"Error for training set: "+net.error(p, t,0,n));
				jTextPane1.setText(jTextPane1.getText()+"\nError for test set: "+net.error(p, t, n,test));

				jTextPane1.setText(jTextPane1.getText()+"\n\nValues for the test set:");
				for(int i=n;i<p.length;i++){
					jTextPane1.setText(jTextPane1.getText()+"\nexp: "+t[i].position(0, 0)+" vs "+net.simulate(p[i]).position(0,0));
				}
			}
		}).start();
	}//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
