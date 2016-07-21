package fr.eni_ecole.fr.jee.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		List<Commande> liste = new ArrayList<Commande>();
		List<LigneCommande> listeLigneCommande = new ArrayList<LigneCommande>();
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		try {

            CsvReader products = new CsvReader("C:/Users/Administrateur/Downloads/Jeux_de_commandes_clientes_CSV.csv");
            
            products.readHeaders();
            
            while (products.readRecord())
            {
            	Commande c = new Commande();
            	
            	listeLigneCommande = new ArrayList<LigneCommande>();
            	
            	String chaine = products.get(0);
            	String[] ligne = chaine.split("\t");
            	
            	String dateCommande = ligne[0];
            	String numCommande = ligne[1];
            	String nomClient = ligne[2];
            	String adresse = ligne[3];
            	
            	//Affichage des infos de la commande
            	/*
            	 System.out.println(dateCommande + " / " + numCommande + " / " + nomClient
            			+ " / " + adresse);
            	*/            	
            	
            	try {
					c.setDateCreation(df.parse(dateCommande));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	c.setNumCommande(numCommande);
            	c.setNom(nomClient);
            	c.setAdresse(adresse);
            	
            	for(int i = 4; i < ligne.length - 1; i++){
            		LigneCommande lc = new LigneCommande();
            		lc.setNum_ligne(i-3);
            		lc.setCommande(c);
            		
            		String article = new String(ligne[i].trim().getBytes(), Charset.forName("UTF-8"));
            		
            		String[] tabArticle = article.split("\\(");
            		
            		String libelleArticle = tabArticle[0].trim();
            		int qte = Integer.parseInt(tabArticle[1].split("\\)")[0]);
            		
            		Article a = new Article();
            		
            		a.setNom(libelleArticle);
            		
            		lc.setArticle(a);
            		lc.setQte(qte);            		
            		
            		//System.out.println(ligne[i].trim());
            		//System.out.println(article);
            		System.out.println(libelleArticle + " / " + qte);
            		
            		listeLigneCommande.add(lc);
            	}
            	
            	//c.setLigneCommandes(listeLigneCommande);
            	
            	liste.add(c);
            }

            products.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	    
	    
	    return liste;
	}

	
}
