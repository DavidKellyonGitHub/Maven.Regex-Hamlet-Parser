import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeHamletToLeon(String hamlet){
        Pattern hamPat = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher hamMatch = hamPat.matcher(hamlet);
        return hamMatch.replaceAll("Leon");
    }

    public String changeHoratioToTariq(String hamlet){
        Pattern horPat = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher horMatch = horPat.matcher(hamlet);
        return horMatch.replaceAll("Tariq");
    };

    public Boolean findHoratio(String hamlet){
        Pattern horPat = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        return horPat.matcher(hamlet).find();
    };

    public Boolean findHamlet(String hamlet){
        Pattern hamPat = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        return hamPat.matcher(hamlet).find();
    }

}
