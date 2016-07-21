package fr.eni_ecole.fr.jee.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.csvreader.CsvReader;

import fr.eni_ecole.fr.jee.bean.Article;
import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.bean.LigneCommande;

public class Convert {

	
	public static  List<Commande> convertFromXLS (){
		POIFSFileSystem fs;
		HSSFWorkbook wb = null;
		
		try {
			fs = new POIFSFileSystem(new FileInputStream("C:/Users/Administrateur/Downloads/Jeux_de_commandes_clientes_XLS.xls"));
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	    HSSFSheet sheet = wb.getSheetAt(0);
	    HSSFRow row;
	    HSSFCell cell;
	    
	    int numberOfRow = sheet.getPhysicalNumberOfRows();
	    
	    List<Commande> listeCommande = new ArrayList<Commande>();
	    
	    for (int i = 1 ; i < numberOfRow ; i++){
	    	Commande c = new Commande();
	    	row = sheet.getRow(i);
	    	
	    	cell = row.getCell(0);
	    	c.setDateCreation(new Date(cell.getDateCellValue().getTime()));
	    	
	    	cell = row.getCell(1);
	    	c.setNumCommande(cell.getStringCellValue());
	    	
	    	cell = row.getCell(2);
	    	c.setNom(cell.getStringCellValue());
	    	
	    	cell = row.getCell(3);
	    	c.setAdresse(cell.getStringCellValue());
	    	
	    	cell = row.getCell(4);
	    	String[] tableau = cell.getStringCellValue().split(";");
	    	
	    	int nb = 0;
	    	do{
	    		String ligne = tableau[nb]; 
	    		String[] separation = ligne.split("(");
	    		
	    		Article a = new Article();
	    		LigneCommande lc = new LigneCommande();
	    		a.setNom(separation[0]);
	    		
	    		lc.setNum_ligne(nb);
	    		lc.setQte(Integer.parseInt(separation[1].substring(0, 2)));
	    		lc.setArticle(a);
	    		
	    		//c.getLigneCommandes().add(lc);
	    		
	    	}while(tableau[nb + 1] != null);
	    	listeCommande.add(c);
	    }
	    return listeCommande;
	}
	
	public static  List<Commande> convertFromCSV (){
		
		try {

            CsvReader products = new CsvReader("C:/Users/Administrateur/Downloads/Jeux_de_commandes_clientes_CSV.csv");

            products.readHeaders();

            while (products.readRecord())
            {
                String productID = products.get("Date de commande");

                // perform program logic here
                System.out.println(productID + ":" + productID);
            }

            products.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	    List<Commande> listeCommande = new ArrayList<Commande>();
	    
	    
	    return listeCommande;
	}
	
	
	
}
