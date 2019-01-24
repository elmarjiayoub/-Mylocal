package ayoub;

import java.util.Scanner;

class Rubrica{
	
    Scanner s = new Scanner(System.in);
    
    //Nested class for each entry
    
    class Entry{
    	
        private String Nome;
        private String Cognome;
        private String indirizzo;
        private String email;
        
        Entry(String Nome, String Cognome, String indirizzo, String email){
        	
            this.Nome = Nome;
            this.Cognome = Cognome;
            this.indirizzo= indirizzo;
            this.email = email;
        }
        
        Entry(){
        	
            Nome = "";
            Cognome = "";
            indirizzo = "";
            email = "";
        }
        
        public void readEntry(){
        	
            System.out.println("Nome:"+ Nome );
            System.out.println("Cognome:"+ Cognome );
			System.out.println("indirizzo:"+indirizzo);
            System.out.println("Email:"+ email );
        }
    }


    //Tiene traccia di quante voci ci sono nel libro
    
    private int entries = 0;
    
    Entry[] contents;
    
    public void initEntries(int e){
    	
        contents = new Entry[e];
        
        for (int i = 0;i<contents.length;i++){  
        											//Initializes an array of entries, then loops through to initialize each individual entry
            contents[i] = new Entry();
        }
    }
    
    
    public int getEntries(){
    	
        return contents.length;
    }
    
    //Adds an entry to the book
    
    public void add(String Nome, String Cognome, String indirizzo, String email){
    	
        if (entries<contents.length){
        	
        contents[entries] = new Entry(Nome, Cognome, indirizzo, email);
        
        entries++;
        
        }
        
        else System.out.println("Error: rubrica è piena ");
        
    }

    //Removes an entry from the book
    
    public void remove(int entry){
    	
        if (entries>0){
        	
            contents[entry] = new Entry();
            
            for (int i = 0;i<entries-entry;i++){
            	
                if (entry+1==entries) contents[entry] = new Entry();
                
                else{
                	
                    Entry temp = contents[entry+i];
                    
                    contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards.
                    
                    contents[entry+i+1] = temp;
                }
            }
            
            entries--;
            
            }
        
            else System.out.println("Error: rubrica è vuota .");
    }

    //Changes the values of an entry
    
    
    public void edit(String Nome, String Cognome, String indirizzo, String email, int selection){
    	
        contents[selection].Nome = Nome;
        
        contents[selection].Cognome = Cognome;
        
        contents[selection].indirizzo = indirizzo;
        
        contents[selection].email = email;
    }

    
    
    //ordinare//
    
    public void sort(int n){
    	
        for(int i = 0;i<contents.length;i++){
        	
            for (int j = 0;j<contents.length;j++){
            	
                switch(n){
                
                    case 1:
                    	
                        if (contents[i].Nome.compareTo(contents[j].Nome)<0){
                        	
                            Entry temp = contents[i];
                            
                            contents[i] = contents[j];
                            
                            contents[j] = temp;
                        }
                        
                        break;
                        
                    case 2:
                    	
                        if (contents[i].Cognome.compareTo(contents[j].Cognome)<0){
                        	
                            Entry temp = contents[i];
                            
                            contents[i] = contents[j];
                            
                            contents[j] = temp;
                        }
                        
                        break;
                        
                    case 3:
                    	
                        if (contents[i].indirizzo.compareTo(contents[j].indirizzo)<0){
                        	
                            Entry temp = contents[i];
                            
                            contents[i] = contents[j];
                            
                            contents[j] = temp;
                        }
                        
                        break
                        ;
                    case 4:
                    	
                        if (contents[i].email.compareTo(contents[j].email)<0){
                        	
                            Entry temp = contents[i];
                            
                            contents[i] = contents[j];
                            
                            contents[j] = temp;
                        }
                        
                        break;
                        
                    default: 
                    	
                        System.out.println("Error: invalid field");
                        
                        break;
                }
            }
        }
    }
    public void addFromCopy(Entry e){
    	
    	
        if (entries<contents.length){
        	
        	
            contents[entries] = e;
            
            
            entries++;
            
            }
        
            else System.out.println("Error:rubrica è piena");
    }

}