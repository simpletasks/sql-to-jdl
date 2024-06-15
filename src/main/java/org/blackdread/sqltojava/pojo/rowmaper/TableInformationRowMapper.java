package org.blackdread.sqltojava.pojo.rowmaper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.blackdread.sqltojava.pojo.TableInformation;
import org.springframework.jdbc.core.RowMapper;

public class TableInformationRowMapper implements RowMapper<TableInformation> {

    @Override
    public TableInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TableInformation(
            rs.getString("table_name"),
            rs.getBoolean("updateable"),
            /*
            However, the derived column 'is_insertable_into' is a string type ('YES' or 'NO'), not a boolean type. The rs.getBoolean("is_insertable_into") method in the TableInformationRowMapper class is expecting a boolean type, which is causing the error.
             */
            //            rs.getBoolean("is_insertable_into"),
            //            rs.getString("is_insertable_into").equalsIgnoreCase("YES"),
            rs.getString("table_type"),
            rs.getString("comment")
        );
    }
}
