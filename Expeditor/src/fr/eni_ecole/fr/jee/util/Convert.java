package fr.eni_ecole.fr.jee.util;

import java.io.File;
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

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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

	
	public static List<Commande> convertFromXLS() {
		List<Commande> listeCommande = new ArrayList<Commande>();
		List<LigneCommande> listeLigneCommande = new ArrayList<LigneCommande>();

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		try {
			Workbook workbook = Workbook
					.getWorkbook(new File(
							"C:/Users/Administrateur/Downloads/Jeux_de_commandes_clientes_XLS.xls"));
			
			Sheet sheet = workbook.getSheet(0);
			
			//System.out.println("Nombre de colonne : " + sheet.getColumns());
			//System.out.println("Nombre de ligne : " + sheet.getRows());
			
			for(int i = 1; i < sheet.getRows(); i++){
				listeLigneCommande = new ArrayList<LigneCommande>();
				
				Cell cellDate = sheet.getCell(0, i);
				Cell cellNum = sheet.getCell(1, i);
				Cell cellNomClient = sheet.getCell(2, i);
				Cell cellAdresse = sheet.getCell(3, i);
				Cell cellArticles = sheet.getCell(4, i);
				
				Commande c = new Commande();
				
				c.setDateCreation(df.parse(cellDate.getContents()));
				c.setNumCommande(cellNum.getContents());
				c.setNom(cellNomClient.getContents());
				c.setAdresse(cellAdresse.getContents());
				
				String chaineArticle = cellArticles.getContents().trim();
				
				//System.out.println(chaineArticle);
				
				if(chaineArticle.endsWith(";")){
					System.out.println(chaineArticle);
					
					chaineArticle = chaineArticle.substring(0, chaineArticle.length()-1);
				}
				
				String[] tabArticles = cellArticles.getContents().trim().split(";");
				
				int num_ligne = 1;
				for (String s : tabArticles) {
					LigneCommande lc = new LigneCommande();
					lc.setCommande(c);
					lc.setNum_ligne(num_ligne);
					
					String[] article = s.trim().split("\\(");

					String libelleArticle = article[0].trim();
					int qte = Integer.parseInt(article[1].split("\\)")[0]);

					Article a = new Article();

					a.setNom(libelleArticle);

					lc.setArticle(a);
					lc.setQte(qte);
					
					num_ligne++;
					
					listeLigneCommande.add(lc);
				}
				
				c.setLesLigneCommandes(listeLigneCommande);
				
				listeCommande.add(c);
			}

		} catch (BiffException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
            	
            	c.setLesLigneCommandes(listeLigneCommande);
            	
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
