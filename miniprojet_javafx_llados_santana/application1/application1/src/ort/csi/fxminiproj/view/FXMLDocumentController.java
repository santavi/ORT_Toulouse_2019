package ort.csi.fxminiproj.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ort.csi.fxminiproj.model.DBModelConnector;
import ort.csi.fxminiproj.model.Model;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Label mw;
    
    @FXML
    private Label add;
    
    @FXML
    private Label Cid;
    
    @FXML
    private Label fn;
    
    @FXML
    private Label gend;
    
    @FXML
    private Label ph;
    
    @FXML 
    private Label mail;
    
    @FXML
    private Label adres;
    
    @FXML 
    private Label age;
    
    @FXML
    private Button Envoyer;
    
    @FXML
    private Button Afficher;
    
    @FXML 
    private Button Window2;
    
    @FXML
    private TextField cid;
    
    @FXML
    private TextField prenom;
    
    @FXML
    private TextField nom;
    
    @FXML
    private TextField addresse;
    
    @FXML
    private TextField mail;
    
    @FXML
    private TextField telephone;
    
    @FXML
    private TextField sexe;
    
    @FXML
    private TextField Ages;
    
    
    
    @FXML
    private TableView<Model> Table;
    
    @FXML
    private TableColumn<Model,Integer> CustomerID;
    
    @FXML
    private TableColumn<Model,Integer> QuoteID;
    
    @FXML
    private TableColumn<Model,Integer> ProductID;
    
    @FXML
    private TableColumn<Model,String> Date;
    
    @FXML
    private TableColumn<Model,Integer> Quantity;
    
    ObservableList<Model> list=FXCollections.observableArrayList();
    
    
    public void AfficherAction(ActionEvent event)
    {
        try {
            Connection con=DBModelConnector.getConnection();
            Statement st=null;
            ResultSet yu=null;
            
            st=con.createStatement();
            String query="select * from devis";
            yu=st.executeQuery(query);
            
            while(yu.next())
            {
                list.add(new Model(yu.getInt("idDevis"),yu.getInt("idProd"),yu.getInt("idCli"),yu.getString("dateDevis"),yu.getInt("Quantite")));
                
            }
            QuoteID.setCellValueFactory(new PropertyValueFactory<>("iddevis"));
            ProductID.setCellValueFactory(new PropertyValueFactory<>("idproduit"));
            CustomerID.setCellValueFactory(new PropertyValueFactory<>("idclient"));
            Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
            
            Table.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void InsertAction(ActionEvent event)
    {
        try {
            Connection dn=DBModelConnector.getConnection();
            PreparedStatement sy=null;
            ResultSet sm=null;
            Statement su=null;
            
            sy=dn.prepareStatement("insert into client values (?,?,?,?,?,?,?,?)");
            sy.setInt(1, Integer.parseInt(cid.getText()));
            System.out.println(cid.getText());
            sy.setString(2, nom.getText());
            sy.setString(3, prenom.getText());
            sy.setString(4, addresse.getText());
            sy.setString(5, mail.getText());
            sy.setString(6, telephone.getText());
            sy.setString(7, sexe.getText());
            sy.setString(8, Ages.getText());
            
            su=dn.createStatement();
            String q="select * from client where idClient="+Integer.parseInt(cid.getText())+"";
            sm=su.executeQuery(q);
            if(sm.next())
            {
                System.out.println("La même entrée existe déjà");
            }
            else
            {
                System.out.println("Entrée réussie");
                sy.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void AfficherNextWindow(ActionEvent event) throws IOException
    {
         Parent r = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        
        Scene scene = new Scene(r);
        
       Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
       win.setScene(scene);
       win.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Afficher.setOnAction((ActionEvent event) ->
        {
            AfficherAction(event);
        });
        
         Envoyer.setOnAction((ActionEvent event) ->
        {
            InsertAction(event);
        });
         Window2.setOnAction((ActionEvent event) ->
        {
           
            try {
                AfficherNextWindow(event);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
       
        
    }    

    
}
