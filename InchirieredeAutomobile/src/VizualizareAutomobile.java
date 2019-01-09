
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stroescu Andrei
 */
public class VizualizareAutomobile extends javax.swing.JFrame {

    /**
     * Creates new form VizualizareAutomobile
     */
    public VizualizareAutomobile() {
        initComponents();
        Show_Products_In_JTable();
        AdaugareFisierTxt1();
    }
    String ImgPath=null;
    int pos =0;
    
     public Connection getConnection(){
        Connection conn=null;
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/masini","root","");
            //JOptionPane.showMessageDialog(null,"Conectat!");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(AdaugatiAutomobil.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null,"Deconectat!");
            return null;
        }
    }
     
     //Adaugare in fisier
    public void AdaugareFisierTxt1(){
        String filePath="C:\\Users\\stroe\\Documents\\NetBeansProjects\\InchirieredeAutomobile\\masini.txt";
        File file=new File(filePath);
        try {
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for(int i=0;i<masini.getRowCount();i++){//linie
                for(int j=0;j<masini.getColumnCount()-1;j++){//coloana
                    bw.write(masini.getValueAt(i, j).toString()+" ");
                }
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(AdaugatiAutomobil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     //resetare campuri 
     public void clearFields(){
        ID.setText(null);
        marca.setText(null);
        model.setText(null);
        anfabricatie.setText(null);
        culoare.setText(null);
        descriere.setText(null);
        tractiune.setText(null);
        pretzi.setText(null);
        consum.setText(null);
        imagine.setIcon(null);
    }
     
     //Verificati campurile de intrare
    
    public boolean checkInputs(){
        if(        
                   marca.getText()==null
                || model.getText()==null
                || anfabricatie.getText()==null
                || culoare.getText()==null
                || descriere.getText()==null
                || pretzi.getText()==null
                || tractiune.getText()==null
                || consum.getText()==null
                ){
                    return false;
              }else{
                    try{
                        Float.parseFloat(pretzi.getText());
                        return true;
                    }catch(Exception ex){
                        return false;
                    }
        }   
        
    }
     
     //Afisarea datelor in Tabla
     //         1 -- Umplerea listei cu datele
     public ArrayList<Masini> getMasiniList(){
        
            ArrayList<Masini> masiniList=new ArrayList<Masini>();
            Connection conn=getConnection();
            String query="SELECT * FROM masini";
            
            Statement st;
            ResultSet rs;
            try {
            st=conn.createStatement();
            rs=st.executeQuery(query);
            Masini product;
            
            while(rs.next())
            {
                product=new Masini(rs.getInt("ID"),rs.getString("Marca"),rs.getString("Model"),rs.getInt("AnFabricatie"),rs.getString("Culoare"),rs.getString("Descriere"),Float.parseFloat(rs.getString("Pretzi")),rs.getString("Tractiune"),rs.getString("Consum"),rs.getBytes("Poza"));
                masiniList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VizualizareAutomobile.class.getName()).log(Level.SEVERE, null, ex);
        }
         return masiniList;
     }
     //         2 -- Popularea Tablei
     public void Show_Products_In_JTable(){
         ArrayList<Masini> list=getMasiniList();
         DefaultTableModel model=(DefaultTableModel)masini.getModel();
         
         
         model.setRowCount(0);
         Object[] row=new Object[10];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getmarca();
            row[2]=list.get(i).getmodel();
            row[3]=list.get(i).getanFabricatie();
            row[4]=list.get(i).getculoare();
            row[5]=list.get(i).getdescriere();
            row[6]=list.get(i).getpretZi();
            row[7]=list.get(i).gettractiune();
            row[8]=list.get(i).getconsum();
            
            model.addRow(row);
        }  
         
     }
     public ImageIcon ResizeImage(String ImgPath,byte[] pic){
        ImageIcon myImage=null;
        
        if(ImgPath!=null){
            myImage=new ImageIcon(ImgPath);
        }else{
            myImage=new ImageIcon(pic);
        }
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(imagine.getWidth(), imagine.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
     
     public void ShowItem(int index){
         ID.setText(Integer.toString(getMasiniList().get(index).getID()));
         marca.setText(getMasiniList().get(index).getmarca());
         model.setText(getMasiniList().get(index).getmodel());
         anfabricatie.setText(Integer.toString(getMasiniList().get(index).getanFabricatie()));
         culoare.setText(getMasiniList().get(index).getculoare());
         descriere.setText(getMasiniList().get(index).getdescriere());
         pretzi.setText(Float.toString(getMasiniList().get(index).getpretZi()));
         tractiune.setText(getMasiniList().get(index).gettractiune());
         consum.setText(getMasiniList().get(index).getconsum());
         imagine.setIcon(ResizeImage(null,getMasiniList().get(index).getimagine())); 
          
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        poza = new javax.swing.JLabel();
        imagine = new javax.swing.JLabel();
        consum = new javax.swing.JTextField();
        tractiune = new javax.swing.JTextField();
        pretzi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriere = new javax.swing.JTextArea();
        culoare = new javax.swing.JTextField();
        anfabricatie = new javax.swing.JTextField();
        model = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        masini = new javax.swing.JTable();
        urmatorul = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        inapoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        actualizati = new javax.swing.JButton();
        sterge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID Masina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Marca");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Model");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("An Fabricatie");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Culoare");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Descriere");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Pret/zi");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tracțiune");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Consum/100km");

        poza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        poza.setText("Poza");

        imagine.setBackground(new java.awt.Color(255, 255, 0));
        imagine.setForeground(new java.awt.Color(153, 204, 0));
        imagine.setOpaque(true);

        consum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        consum.setPreferredSize(new java.awt.Dimension(6, 25));

        tractiune.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        pretzi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pretzi.setPreferredSize(new java.awt.Dimension(6, 25));

        descriere.setColumns(20);
        descriere.setRows(5);
        jScrollPane1.setViewportView(descriere);

        culoare.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        culoare.setPreferredSize(new java.awt.Dimension(6, 25));

        anfabricatie.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        anfabricatie.setPreferredSize(new java.awt.Dimension(6, 25));

        model.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        model.setPreferredSize(new java.awt.Dimension(6, 25));

        marca.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        marca.setPreferredSize(new java.awt.Dimension(6, 25));

        ID.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ID.setEnabled(false);
        ID.setPreferredSize(new java.awt.Dimension(6, 25));

        masini.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Masina", "Marca", "Model", "AnFabricatie", "Culoare", "Descriere", "Pret/zi", "Tractiune", "Consum/100km", "Imagine"
            }
        ));
        masini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masiniMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(masini);

        urmatorul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        urmatorul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Forward_20px.png"))); // NOI18N
        urmatorul.setText("Urmatorul");
        urmatorul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urmatorulActionPerformed(evt);
            }
        });

        anterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Back_20px.png"))); // NOI18N
        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        inapoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inapoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Back_20px.png"))); // NOI18N
        inapoi.setText("Inapoi");
        inapoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 204));
        jLabel12.setText("Vizualizare Automobile Și Gestiune");

        actualizati.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        actualizati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Update_20px.png"))); // NOI18N
        actualizati.setText("Actualizare");
        actualizati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizatiActionPerformed(evt);
            }
        });

        sterge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sterge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Delete_20px.png"))); // NOI18N
        sterge.setText("Ștergere");
        sterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poza, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inapoi)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(actualizati)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sterge))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anfabricatie, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pretzi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(culoare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(tractiune)
                            .addComponent(consum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(urmatorul)
                        .addGap(146, 146, 146))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(anfabricatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(culoare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pretzi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tractiune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(consum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagine, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poza)))
                    .addComponent(jScrollPane2))
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inapoi)
                    .addComponent(actualizati)
                    .addComponent(sterge)
                    .addComponent(urmatorul)
                    .addComponent(anterior))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
        pos--;
        if(pos<0){
            pos=0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_anteriorActionPerformed

    private void urmatorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urmatorulActionPerformed
        // TODO add your handling code here:
        pos++;

        if(pos>=getMasiniList().size()){
            pos=getMasiniList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_urmatorulActionPerformed

    private void masiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masiniMouseClicked
        // TODO add your handling code here:
        int index=masini.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_masiniMouseClicked

    private void inapoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inapoiActionPerformed
        // TODO add your handling code here:
        this.hide();
        Meniu frm=new Meniu();
        frm.setVisible(true);
    }//GEN-LAST:event_inapoiActionPerformed

    private void actualizatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizatiActionPerformed
        // TODO add your handling code here:
        if(checkInputs() && ID.getText()!=null){
            String UptadeQuery=null;
            PreparedStatement ps=null;
            Connection conn=getConnection();

            //actualizare fara imagine
            if(ImgPath==null){
                try {
                    UptadeQuery="UPDATE masini SET Marca=?, Model=?, AnFabricatie=?, Culoare=?, Descriere=?, Pretzi=?, Tractiune=?, Consum=? WHERE ID=?";
                    ps=conn.prepareStatement(UptadeQuery);
                    ps.setString(1, marca.getText());
                    ps.setString(2, model.getText());
                    ps.setString(3, anfabricatie.getText());
                    ps.setString(4, culoare.getText());
                    ps.setString(5, descriere.getText());
                    ps.setString(6, pretzi.getText());
                    ps.setString(7, tractiune.getText());
                    ps.setString(8, consum.getText());
                    ps.setInt(9,Integer.parseInt(ID.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Masina A Fost Actualizata!");
                    clearFields();
                } catch (Exception ex) {
                    Logger.getLogger(AdaugatiAutomobil.class.getName()).log(Level.SEVERE, null, ex);
                }

                //update cu imagine
            }else{
                try{
                    InputStream img=new FileInputStream(new File(ImgPath));
                    UptadeQuery="UPDATE masini SET Marca=?, Model=?, AnFabricatie=?, Culoare=?, Descriere=?, Pretzi=?, Tractiune=?, Consum=?, Poza=? WHERE ID=?";
                    ps=conn.prepareStatement(UptadeQuery);
                    ps.setString(1, marca.getText());
                    ps.setString(2, model.getText());
                    ps.setString(3, anfabricatie.getText());
                    ps.setString(4, culoare.getText());
                    ps.setString(5, descriere.getText());
                    ps.setString(6, pretzi.getText());
                    ps.setString(7, tractiune.getText());
                    ps.setString(8, consum.getText());
                    ps.setBlob(9, img);
                    ps.setInt(10,Integer.parseInt(ID.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Masina A Fost Actualizata!");
                   
                    clearFields();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }

        }else
        {
            JOptionPane.showMessageDialog(null,"Unul sau mau multe câmpuri sunt goale!");
        }
    }//GEN-LAST:event_actualizatiActionPerformed

    private void stergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeActionPerformed
        // TODO add your handling code here:
        if(!ID.getText().equals(""))
        {
            try {
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement("DELETE FROM masini WHERE ID=?");
                int id=Integer.parseInt(ID.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null,"Masina a fost stersă!");
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(AdaugatiAutomobil.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Masina nu a fost stearsă!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Masina nu a fost stearsă : Nu se șterge id-ul!");
        }
             
    }//GEN-LAST:event_stergeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VizualizareAutomobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VizualizareAutomobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VizualizareAutomobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VizualizareAutomobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VizualizareAutomobile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton actualizati;
    private javax.swing.JTextField anfabricatie;
    private javax.swing.JButton anterior;
    private javax.swing.JTextField consum;
    private javax.swing.JTextField culoare;
    private javax.swing.JTextArea descriere;
    private javax.swing.JLabel imagine;
    private javax.swing.JButton inapoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField marca;
    private javax.swing.JTable masini;
    private javax.swing.JTextField model;
    private javax.swing.JLabel poza;
    private javax.swing.JTextField pretzi;
    private javax.swing.JButton sterge;
    private javax.swing.JTextField tractiune;
    private javax.swing.JButton urmatorul;
    // End of variables declaration//GEN-END:variables
}
