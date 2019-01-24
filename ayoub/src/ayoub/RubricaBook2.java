package ayoub;

import java.util.Scanner;

public class RubricaBook2 {
	
    public static void main(String[] args){
    	
        Scanner s = new Scanner(System.in);
        
        System.out.print("quanti rubriche vorresti creare? ");
        
        int quantiRubrice;
        
        int quantiContatti;

       Rubrica[] library = new Rubrica[0];


        while(true){
        	
        	quantiRubrice = s.nextInt();
            
            if (quantiRubrice>0){
            	
                library = new Rubrica[quantiRubrice];
                
     //Questo codice decide quanti libri ci sono nella serie di libri / la biblioteca
                
                break;
            }
            
            else System.out.print("You must create at least 1 book.");
            
            }


        for (int i=0;i<library.length;i++){


            library[i] = new Rubrica(); 
            
            //Corretto il riferimento a null perché ogni libro nella libreria non era ancora stato inizializzato.

            while(true){
            	
                System.out.print("quanti contatti in Rubrica "+i+"? ");
                
                quantiContatti = s.nextInt();
                
                if (quantiContatti>0) {
                	
                    library[i].initEntries(quantiContatti); 
                    
                   // Questo codice decide quante voci ci sono in ogni libro nella libreria
                    
                    break;
                }
                
                else System.out.println("Devi creare almeno 1 Entry caro mio grazie.");
                
                }


        }
        
        boolean done = false;
        
        int selectionaRubrica = 0;
        
        int seleziona;
        
        while (done==false){
        	
            System.out.println("Rubrica "+selectionaRubrica+" è attualmente selezionato.");
            

            for (int i = 0;i<library[selectionaRubrica].getEntries();i++){
            	
                System.out.println("===========Entry "+i+" ===========");
                
                library[selectionaRubrica].contents[i].readEntry();
                
                
                // Accesso alla matrice di voci ALL'INTERNO della serie di libri / la libreria
                
                
                System.out.println("================================");
            }


            System.out.println("Seleziona un'opzione!");
            System.out.println("1. Aggiungi  contatto ");
            System.out.println("2. cancella  contatto");
            System.out.println("3. modifica contatto");
            System.out.println("4. mostra tutti contatti");
            System.out.println("5. seleziona un altra Rubrica");
            //System.out.println("6. Move entry across books");
            System.out.println("7. Exit the menu");
            System.out.print("> ");
            seleziona = s.nextInt();
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            String nome, cognome, indirizzo, email;
            
            switch(seleziona){
            case 1: 
                System.out.print("Nome? ");
                
                nome = s.next();
                
                System.out.print("Cognome? ");
                cognome = s.next();
                System.out.print("Indirizzo? ");
                indirizzo = s.next();
                
                System.out.print("Email? ");
                
                email = s.next();
                library[selectionaRubrica].add(nome,cognome , indirizzo, email);
                break;
            case 2: 
                System.out.print("cancelli  contatto? ");
                
                int entry = s.nextInt();
                
                library[selectionaRubrica].remove(entry);
                break;
            case 3:
                System.out.print("modifica contatto?");
                
                int whichEntry = s.nextInt();
                
                System.out.print("Nome? ");
                
                nome = s.next();
                
                System.out.print("Cognome? ");
                
                cognome = s.next();
                
                System.out.print("Indirizzo? ");
                
                indirizzo = s.next();
                
                System.out.print("Email? ");
                
                email = s.next();
                
                library[selectionaRubrica].edit(nome, cognome, indirizzo, email, whichEntry);
                break;
            case 4: 
                System.out.println("Sort alphabetically by which field?");
                System.out.println("1. ordina Nome");
                System.out.println("2. ordina Cognome");
                System.out.println("3. ordina indirizzo");
                System.out.println("4. ordina email");
                library[selectionaRubrica].sort(s.nextInt());
                break;
            case 5: 
            	
                System.out.print("Seleziona con quale contatto?");
                
                selectionaRubrica = s.nextInt();
                
                break;
                
            case 6:
            	
                System.out.print("cancella contatto? ");
                
                int entryNo = s.nextInt();
                
                Rubrica.Entry entryToMove = library[selectionaRubrica].contents[entryNo];
                
                library[selectionaRubrica].remove(entryNo);
                
                System.out.print("To which book? ");
                
                int whichBook = s.nextInt();
                
                library[whichBook].addFromCopy(entryToMove);
                
                break;
                
            case 7:
            	
                done = true;
                
                break;
                
            default:
            	
                System.out.print("Please choose a valid menu number");


            }

        }
    }
}