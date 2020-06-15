package ort.csi.fxminiproj.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ort.csi.fxminiproj.model.DBModelConnector;
import ort.csi.fxminiproj.model.Model;


public class FXML2Controller implements Initializable {

    @FXML
    private TextField qid;
    
    @FXML
    private ComboBox pi;
    
    @FXML
    private ComboBox ci;
    
    @FXML
    private TextField qn;
    
    @FXML
    private Button addquote;
    
    @FXML
    private ComboBox proid;
    
    @FXML
    private Label name;
    
    @FXML
    private TextField price;
    
    @FXML
    private Button updateprice;
    
    @FXML
    private Label dt;
    
    @FXML
    private TextField produ;
    
    @FXML
    private TextField nm;
    
    @FXML
    private TextField qun;
    
    @FXML
    private TextField pr;
    
    @FXML
    private Button addproduct;
    
    @FXML
    private Button na;
    
    @FXML
    private Label cna;
    
    @FXML
    private Button displayc;
    
    public void InsertQuote(ActionEvent event)
    {
        try {
            Connection c=DBModelConnector.getConnection();
            PreparedStatement st=null;
            PreparedStatement fg=null;
            Statement g=null;
            Statement i=null;
            ResultSet ym=null;
            ResultSet rt=null;
            
            st=c.prepareStatement("insert into devis values(?,?,?,?,?)");
            st.setInt(1,Integer.parseInt(qid.getText()));
            java.sql.Timestamp current=new java.sql.Timestamp(new java.util.Date().getTime());
            st.setTimestamp(2, current);
            String y=pi.getSelectionModel().getSelectedItem().toString();
            st.setInt(3,Integer.parseInt(qn.getText()));
            String m=ci.getSelectionModel().getSelectedItem().toString();
            st.setInt(4, Integer.parseInt(m));
            st.setInt(5,Integer.parseInt(y));
            
            g=c.createStatement();
            String n="select * from produit where idProduit ="+Integer.parseInt(y)+"";
            ym=g.executeQuery(n);
            if(ym.next())
            {
                int p=ym.getInt("produitQte");
                int l=Integer.parseInt(qn.getText());
                int u=p-l;
                String h="Update produit set produitQte ="+u+" where idProduit ="+Integer.parseInt(y);
                fg=c.prepareStatement(h);
                
                
            }
            i=c.createStatement();
            String k="select * from devis where idDevis ="+Integer.parseInt(qid.getText());
            rt=i.executeQuery(k);
            if(rt.next())
            {
                System.out.println("erreur la même entrée existe déjà");
            }
            else
            {
                st.executeUpdate();
                fg.executeUpdate();
                System.out.println("Inséré dans le devis avec succès");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
    
    public void UpdatePrice(ActionEvent event)
    {
        try {
            Connection bn=DBModelConnector.getConnection();
            PreparedStatement yt=null;
            Statement re=null;
            
            
            int m=Integer.parseInt(proid.getSelectionModel().getSelectedItem().toString());
            
            int rw=Integer.parseInt(price.getText());
            
            yt=bn.prepareStatement("Update produit set prix ="+rw+" where idProduit ="+m);
            
            yt.executeUpdate();
            System.out.println("Mise à jour réussie");
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setPname(ActionEvent event)
    {
        
        try {
            Connection y=DBModelConnector.getConnection();
            Statement m=null;
            ResultSet r=null;
            
            int re=Integer.parseInt(proid.getSelectionModel().getSelectedItem().toString());
            m=y.createStatement();
            String l="select * from produit where idProduit ="+re;
            r=m.executeQuery(l);
            if(r.next())
            {
                name.setText(r.getString("nomProduit"));
            }   } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AddProduct(ActionEvent event)
    {
        try {
            Connection yf=DBModelConnector.getConnection();
            PreparedStatement tb=null;
            Statement bv=null;
            ResultSet rg=null;
            
            tb=yf.prepareStatement("insert into produit values(?,?,?,?)");
            tb.setInt(1,Integer.parseInt(produ.getText()));
            tb.setString(2,nm.getText());
            tb.setInt(3,Integer.parseInt(qun.getText()));
            tb.setInt(4,Integer.parseInt(pr.getText()));
            
            bv=yf.createStatement();
            String j="select * from produit where idProduit="+Integer.parseInt(produ.getText());
            rg=bv.executeQuery(j);
            
            if(rg.next())
            {
                System.out.println("erreur la même entrée existe déjà");
            }
            else
            {
                tb.executeUpdate();
                System.out.println("Produit ajouté avec succès");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DisplayName(ActionEvent event)
    {
        try {
            Statement rm=null;
            Connection ui=DBModelConnector.getConnection();
            ResultSet ye=null;
            rm=ui.createStatement();
            String yh="select * from client where idClient ="+Integer.parseInt(ci.getSelectionModel().getSelectedItem().toString());
            ye=rm.executeQuery(yh);
            if(ye.next())
            {
                String f=ye.getString("prenom");
                String g=ye.getString("nom");
                String h=f+g;
                cna.setText(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    /**
     * Initialise la classe controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Statement sp=null;
            Statement sn=null;
            Statement tr=null;
            
            ResultSet bn=null;
            ResultSet by=null;
            ResultSet gh=null;
            
            
            Connection conn=DBModelConnector.getConnection();
            sp=conn.createStatement();
            sn=conn.createStatement();
            String q1="select * from client";
            String q2="select * from produit";
            
            ObservableList<String>ln=FXCollections.observableArrayList();
            ObservableList<String>ly=FXCollections.observableArrayList();
            ObservableList<String>lo=FXCollections.observableArrayList();
            bn=sp.executeQuery(q1);
            by=sn.executeQuery(q2);
            while(bn.next())
            {
                String u=bn.getString("idClient");
                
                ln.add(u);
                
            }
            ci.setItems(ln);
            while(by.next())
            {
                String y=by.getString("idProduit");
                ly.add(y);
                
                
            }
            pi.setItems(ly);
            
            tr=conn.createStatement();
            String t="select * from produit";
            gh=tr.executeQuery(t);
            while(gh.next())
            {
                String e=gh.getString("idProduit");
                lo.add(e);
            }
            proid.setItems(lo);
            
            
            DateTimeFormatter dtime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");            
            LocalDateTime now = LocalDateTime.now();
            dt.setText(dtime.format(now));
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         addquote.setOnAction((ActionEvent event) ->
        {
            InsertQuote(event);
        });
         
          updateprice.setOnAction((ActionEvent event) ->
        {
            UpdatePrice(event);
        });
           na.setOnAction((ActionEvent event) ->
        {
            setPname(event);
        });
            addproduct.setOnAction((ActionEvent event) ->
        {
            AddProduct(event);
        });
              displayc.setOnAction((ActionEvent event) ->
        {
            DisplayName(event);
        });
    }    
    
}
