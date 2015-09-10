import java.io.IOException;

/**
 * Created by mtackes on 9/8/15.
 */
public class FindAndReplaceDriver {
    public static void main(String[] args) {
        String homeDirectory = System.getProperty("user.home");
        String replacementsFile = homeDirectory + "/Documents/javaEnterprise/Week1/findandreplace.txt";
        String textToReplaceFile = homeDirectory + "/Documents/javaEnterprise/Week1/input.txt";

        FindAndReplace replacer = new FindAndReplace(replacementsFile, textToReplaceFile);

        try {
            replacer.parseReplacements();
        } catch (IOException error){
            System.out.println("ioexception");
        }
    }
}
