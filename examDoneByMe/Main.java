import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;

public class Main {

   static Scanner scan;
   static List<Album> album;
   static List<Playlist> playlist;
    
    public static void main(String[] args){
        scan = new Scanner(System.in);
        album = new ArrayList<>();
        playlist = new ArrayList<>();
        
        while(scan.hasNext()){
            String parola = scan.next();
            switch(parola){
                case "ALBUM":
    
                    Album alb = readAlbum();
    
                    album.add(alb);
                    break;

                case "PLAYLIST":
    
                    Playlist pl = readPlaylist();
    
                    playlist.add(pl);
                    break;
    
                default:
                    throw new IllegalArgumentException("non riconosciuto");
            }
        }

        for(int i = 0; i < album.size(); i++){
            System.out.println(album.get(i));
        }
        
        for(int i = 0; i < playlist.size(); i++){
            System.out.println(playlist.get(i));
        }

        Playlist fusa = new Playlist("fusa");
        for(int i = 0; i < playlist.size(); i++){
            fusa = new Playlist("fusa", fusa, playlist.get(i));
        }
        System.out.println(fusa);

    }

    public static Album readAlbum(){
        Map<String, Integer> titolo2durata = new LinkedHashMap<>();

        String nomeAlbum = scan.nextLine();
        String line = scan.nextLine();

        while(!line.equals(".")){
            String[] splitted = line.split("-"); 
            Durata dur = new Durata(splitted[0]);

            titolo2durata.put(splitted[1], dur.durata);

            line = scan.nextLine();
        }

        return new Album(nomeAlbum, titolo2durata);

    }

    public static Playlist readPlaylist(){
        
        String nome = scan.nextLine();
        Playlist pl = new Playlist(nome);

        int num1;
        int num2;

        String line = scan.nextLine();


        while(!line.equals(".")){
            String[] splitted = line.split(" "); 

            num1 = Integer.parseInt(splitted[0]);
            num2 = Integer.parseInt(splitted[1]);

            Album alb = album.get(num1-1);
            Album.Brano br = alb.getBranoByPositionInAlbum(num2-1);

            pl.aggiungiBrano(br);

            line = scan.nextLine();
        }

        return pl;

    }
}
