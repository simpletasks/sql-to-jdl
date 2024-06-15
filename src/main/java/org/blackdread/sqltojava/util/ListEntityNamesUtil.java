package org.blackdread.sqltojava.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListEntityNamesUtil {

    public List<String> listEntityNames(String jdlFilePath) {
        List<String> entityNames = new ArrayList<>();
        Pattern entityPattern = Pattern.compile("^(?!//)\\s*entity\\s+(\\w+)");

        try (BufferedReader reader = new BufferedReader(new FileReader(jdlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = entityPattern.matcher(line);
                if (matcher.find()) {
                    entityNames.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entityNames;
    }
}
