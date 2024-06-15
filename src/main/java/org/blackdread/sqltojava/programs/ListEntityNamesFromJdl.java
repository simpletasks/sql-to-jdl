package org.blackdread.sqltojava.programs;

import java.util.List;
import java.util.StringJoiner;
import org.blackdread.sqltojava.util.ListEntityNamesUtil;

public class ListEntityNamesFromJdl {

    public static void main(String[] args) {
        ListEntityNamesUtil jdlEntityLister = new ListEntityNamesUtil();
        List<String> entityNames = jdlEntityLister.listEntityNames("my-project-jdl.jh");
        String result = String.join(", ", entityNames);
        System.out.println("entities " + result);
    }
}
