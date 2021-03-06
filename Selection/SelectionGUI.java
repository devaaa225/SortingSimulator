package Selection;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ganesh
 */
public class SelectionGUI extends javax.swing.JFrame {

    int top_limit = 270;
	    int bottom_limit = 420;
	    int current_position = 347;
	    Thread t;
	    boolean runStatus=false;
	    Map<Integer,Point> coordinates;
	    Map<Integer,JTextField> elements;
	    int sortprogress=0;
	    int[] original_Array;
   
    public SelectionGUI() {
                initComponents();
		loadCoordinates();
		loadElements();
	jButton3.setEnabled(false);
	jProgressBar1.setStringPainted(true);
        jProgressBar2.setStringPainted(true);
        jProgressBar3.setStringPainted(true);
        jProgressBar5.setStringPainted(true);
         jProgressBar1.setFont(new java.awt.Font("TlwgMono", 1, 16));
        
           jProgressBar5.setFont(new java.awt.Font("TlwgMono", 1, 16));
        jProgressBar2.setBackground(Color.ORANGE);
        jProgressBar3.setBackground(Color.PINK);
	jProgressBar5.setBackground(Color.WHITE);
    }

     public void loadCoordinates(){
               coordinates = new HashMap<>();
        coordinates.put(0, new Point(30,351));
        coordinates.put(1, new Point(102,351));
        coordinates.put(2, new Point(174,351));
        coordinates.put(3, new Point(244,349));
        coordinates.put(4, new Point(316,349));
        coordinates.put(5, new Point(388,349));
        coordinates.put(6, new Point(460,349));
    }
    
    public void loadElements(){
        elements = new HashMap<>();
        elements.put(0, element0);
        elements.put(1, element1);
        elements.put(2, element2);
        elements.put(3, element3);
        elements.put(4, element4);
        elements.put(5, element5);
        elements.put(6, element6);
    }
    
    public boolean loadArray(){
        original_Array = new int[7];
	try{
        original_Array[0] = Integer.parseInt(txtInput0.getText());
        original_Array[1] = Integer.parseInt(txtInput1.getText());
        original_Array[2] = Integer.parseInt(txtInput2.getText());
        original_Array[3] = Integer.parseInt(txtInput3.getText());
        original_Array[4] = Integer.parseInt(txtInput4.getText());
        original_Array[5] = Integer.parseInt(txtInput5.getText());
        original_Array[6] = Integer.parseInt(txtInput6.getText());
        }
	catch(NumberFormatException exception){
		JOptionPane.showMessageDialog(jPanel1,"Numbers are INVALID! Enter Integer Value!!");
	return false;
	}
	
        for(int i=0;i<7;i++){
            elements.get(i).setText(String.valueOf(original_Array[i]));
        }
	return true;
    }
    
    
     public void moveFirst(JTextField src, Point destination) {
        MoveUp_First(src, destination);
        MoveRight_First(src, destination);
        MoveDown_First(src, destination);
      }
     
     public void moveSecond(JTextField src, Point destination) {
        MoveDown_Second(src, destination);
        MoveLeft_Second(src, destination);
        MoveUp_Second(src, destination);
      }
    public void MoveUp_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        source.setBackground(Color.ORANGE);
        while (source_y != top_limit && source_x != destination_x) {
            source_y--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
               
            }
        }

    }
    
    public void MoveRight_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_x != destination_x && source_y == top_limit) {
            source_x++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
        }

    }
    
    public void MoveDown_First(JTextField source, Point destination) {

        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        while (source_y != current_position && source_x == destination_x) {
            source_y++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
        }
        source.setBackground(Color.WHITE);

    }
    
    public void MoveDown_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;
        source.setBackground(Color.GREEN);
        while (source_y != bottom_limit && source_x != destination_x) {
            source_y++;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
               
            }
    }
    }
    
    public void MoveLeft_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_x != destination_x && source_y == bottom_limit) {
            source_x--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    public void MoveUp_Second(JTextField source, Point destination) {
        int source_x = source.getBounds().x;
        int source_y = source.getBounds().y;

        int destination_x = destination.x;
        int destination_y = destination.y;

        while (source_y != current_position && source_x == destination_x) {
            source_y--;
            source.setBounds(source_x, source_y, source.getBounds().width, source.getBounds().height);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
    public void performSelection(int[] list) 
	{
		jProgressBar1.setMaximum(6);
	        for (int i = 0; i < list.length - 1; i++) 
		{
			int progress=i+1;
			jProgressBar1.setValue(progress);
			jProgressBar1.setString("PASS "+progress+" / 6");
		        int minPos = i;
		        for (int j = i + 1; j < list.length; j++) 
			{
		        	elements.get(i).setBackground(Color.ORANGE);
			        try 
				{
					jProgressBar2.setValue(0);
                    
                    			jProgressBar2.setString("input[minPos] =  "+list[minPos]);
					    jProgressBar3.setValue(0);
					    jProgressBar3.setString("input[j] =  "+list[j]);
					    
					     jProgressBar5.setValue(0);
					     if(list[j] < list[minPos])
					     {
						 jProgressBar5.setString(" > ");
					     }
					     else if(list[j] > list[minPos])
					     {
						 jProgressBar5.setString(" < ");
					     }
	     	                	resetElements(j);
					Thread.sleep(500);
				        elements.get(j).setBackground(Color.PINK);
				        Thread.sleep(1000);
			         }
				catch (InterruptedException ex)
				{
                    
                		}
                		if (list[j] < list[minPos]) 
				{
                    				minPos = j;
               			}
                 jProgressBar2.setValue(0);
                    
                    			jProgressBar2.setString("input[minPos] =  "+list[minPos]);
					    jProgressBar3.setValue(0);
					    jProgressBar3.setString("input[j] =  "+list[j]);
					    
					     jProgressBar5.setValue(0);
					     if(list[j] < list[minPos])
					     {
						 jProgressBar5.setString(" > ");
					     }
					     else if(list[j] > list[minPos])
					     {
						 jProgressBar5.setString(" < ");
					     }
            		}
           			elements.get(minPos).setBackground(Color.PINK);
          			swap(list, minPos, i);
				
		 }
        
        	elements.get(6).setBackground(Color.GREEN);
   		jProgressBar1.setString("Sorting Completed!");
        	//SortSuccess();
    
    }

    
    
    
    public void resetElements(int start){
        for(int i=start+1;i<7;i++){
            elements.get(i).setBackground(Color.WHITE);
        }
    }
    
	private void swap(int[] a, int i, int j) {
        JTextField jTemp = elements.get(j);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        if(i!=j){
            moveFirst(elements.get(j), coordinates.get(i));
            moveSecond(elements.get(i), coordinates.get(j));
        }
        else {
                elements.get(j).setBackground(Color.GREEN);
        }
        
        elements.put(j, elements.get(i));
        elements.put(i, jTemp);
    }
 	/*public void SortSuccess(){
        for(int i=0;i<7;i++){
            elements.get(i).setBackground(Color.GREEN);
        }
    }*/
    

    
    
    @SuppressWarnings("unchecked")
                           
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtInput0 = new javax.swing.JTextField();
        txtInput1 = new javax.swing.JTextField();
        txtInput2 = new javax.swing.JTextField();
        txtInput3 = new javax.swing.JTextField();
        txtInput4 = new javax.swing.JTextField();
        txtInput5 = new javax.swing.JTextField();
        txtInput6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        element0 = new javax.swing.JTextField();
        element1 = new javax.swing.JTextField();
        element2 = new javax.swing.JTextField();
        element3 = new javax.swing.JTextField();
        element4 = new javax.swing.JTextField();
        element5 = new javax.swing.JTextField();
        element6 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selection Sort");
        setBackground(new java.awt.Color(229, 229, 123));

        jLabel1.setFont(new java.awt.Font("TlwgMono", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 98, 129));
        jLabel1.setText("Selection Sort");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 170, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 130));

        txtInput0.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput0.setToolTipText("");
       

        txtInput1.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput1.setToolTipText("");

        txtInput2.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput2.setToolTipText("");

        txtInput3.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput3.setToolTipText("");

        txtInput4.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput4.setToolTipText("");

        txtInput5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput5.setToolTipText("");

        txtInput6.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        txtInput6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput6.setToolTipText("");

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtInput0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(243, 234, 227), new java.awt.Color(255, 148, 0)));
        jPanel2.setFocusCycleRoot(true);
        jPanel2.setFont(new java.awt.Font("Tlwg Typist", 1, 18)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(530, 100));

        jProgressBar2.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        jProgressBar2.setString("minPos index value");
        jProgressBar3.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        jProgressBar3.setString("j index value");

        jProgressBar5.setString("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Start Selection Sort");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel2.setFont(new java.awt.Font("Nimbus Mono L", 1, 22)); // NOI18N
        jLabel2.setText("Pseudo Code ");

        element0.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element0.setToolTipText("");
        element0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 16, 16)));
        

        element1.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element1.setToolTipText("");
        element1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        element2.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element2.setToolTipText("");
        element2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        

        element3.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element3.setToolTipText("");
        element3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
       

        element4.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element4.setToolTipText("");
        element4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        element5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element5.setToolTipText("");
        element5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        element6.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        element6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        element6.setToolTipText("");
        element6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 140, 0)));

        jLabel7.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel7.setText("for(int i = 0; i < n-1; i++)");

        jLabel8.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel8.setText("{");

        jLabel9.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel9.setText("int minPos = i;");

        jLabel10.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel10.setText("for(int j = i+1 ; j < n ; j++)");

        jLabel11.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel11.setText("{");

        jLabel12.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel12.setText("if(input[minPos] > input[j])");

        jLabel13.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel13.setText("{");

        jLabel14.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel14.setText("minPos = j;");

        jLabel15.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel15.setText("}");

        jLabel16.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel16.setText("}");

        jLabel17.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel17.setText("swap(list, minPos, i);");

        jLabel18.setFont(new java.awt.Font("TlwgMono", 1, 17)); // NOI18N
        jLabel18.setText("}");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(50, 50, 50))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(element0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(element1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(element2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(element3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(element4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(element5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(element6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(element0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(element6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void txtInput0ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here: 
        if(loadArray())
	{/*
          Thread t = new Thread(()->{
              donewInsertion(original_Array);
          });*/
	jButton3.setEnabled(true);
	jButton1.setEnabled(false);
	t=new Thread(new Runnable(){
		@Override
		public void run(){
				performSelection(original_Array);
			}
		});
          
          t.start();

	}
    }                                        

                            

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       dispose();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        SelectionGUI myform=new SelectionGUI();
		myform.jButton3.setEnabled(false);
		myform.setVisible(true);
		this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionGUI().setVisible(true);
            }
        });
    }

               
    public javax.swing.JTextField element0;
    public javax.swing.JTextField element1;
    private javax.swing.JTextField element2;
    private javax.swing.JTextField element3;
    private javax.swing.JTextField element4;
    private javax.swing.JTextField element5;
    private javax.swing.JTextField element6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JTextField txtInput0;
    private javax.swing.JTextField txtInput1;
    private javax.swing.JTextField txtInput2;
    private javax.swing.JTextField txtInput3;
    private javax.swing.JTextField txtInput4;
    private javax.swing.JTextField txtInput5;
    private javax.swing.JTextField txtInput6;
    // End of variables declaration                   
}

