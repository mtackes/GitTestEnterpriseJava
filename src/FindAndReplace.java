import java.util.regex.*;

import java.io.*;

/**
 * Created by mtackes on 9/7/15.
 */
public class FindAndReplace {
    private String replacementSource;
    private String textSource;


    public FindAndReplace(String replacementSource, String textSource) {
        this.replacementSource = replacementSource;
        this.textSource = textSource;
    }

    boolean parseReplacements() throws IOException {
        Pattern replacementPattern = Pattern.compile("([^:]+):([^,\r\n]*)(:?,|$)");

        try (BufferedReader replacementFile = new BufferedReader(new FileReader(replacementSource))) {
            String replacementsLine;
            while ((replacementsLine = replacementFile.readLine()) != null) {
                Matcher rawReplacements = replacementPattern.matcher(replacementsLine);
                while (rawReplacements.find()) {
                    String findText = rawReplacements.group(1);
                    String replaceText = rawReplacements.group(2);

                    System.out.println("findText = " + findText);
                    System.out.println("replaceText = " + replaceText);
                }
            }
        }

        return true;
    }
}
