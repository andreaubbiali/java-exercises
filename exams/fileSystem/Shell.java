import java.util.Scanner;
import java.util.Iterator;

public class Shell {

    private Path pathCorrente;
    private final FileSystem fileSystem;

    public Shell(){
        this.pathCorrente = new Path(":");
        fileSystem = new FileSystem();
    }

    public void startShell(){
        Scanner sc = new Scanner(System.in);

        try{
            
            while(true){
                String s = sc.nextLine();
                String[] splitted = s.split(" ");
                switch(splitted[0]){
                    case "ls":

                    // ls [path] che elenca il contenuto della directory indicata dal path, o della directory corrente,
                        Iterator<Entry> it;
                        if (splitted.length == 1){
                            it = fileSystem.elencaContenuto(pathCorrente);
                        } else {
                            it = fileSystem.elencaContenuto(new Path(splitted[1]));
                        }
                        
                        while(it.hasNext()){
                            System.out.println(">>> " + it.toString());
                        }

                    case "size":

                    // size [path] che riporta la dimensione della entry indicata dal path, o della directory corrente,
                        if (splitted.length == 1){
                            System.out.println(">>> " + fileSystem.dimensione(pathCorrente));
                        } else {
                            System.out.println(">>> " +fileSystem.dimensione(new Path(splitted[1])));
                        }

                    case "mkdir":

                    // mkdir path che crea la directory indicata dal path,
                        fileSystem.creaDirectoryByPath(new Path(splitted[1]));

                    case "mkfile":

                    // mkfile path size che crea il file indicato dal path con la dimensione specificata,
                        fileSystem.creaFile(Integer.parseInt(splitted[2]), new Path(splitted[1]));

                    case "cd":

                    // cd [path] che modifica la directory corrente in quella indicata dal path, o nella radice del filesystem,
                        if (splitted.length == 1){
                            pathCorrente = new Path(":");
                        } else {
                            pathCorrente = new Path(splitted[1]);
                        }

                    case "pwd":

                    // pwd che stampa il nome della directory corrente;
                        System.out.println(pathCorrente.toString());
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }
}















