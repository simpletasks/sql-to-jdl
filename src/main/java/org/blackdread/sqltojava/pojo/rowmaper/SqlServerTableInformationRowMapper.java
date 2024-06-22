package org.blackdread.sqltojava.pojo.rowmaper;

import org.blackdread.sqltojava.pojo.TableInformation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServerTableInformationRowMapper implements RowMapper<TableInformation> {

    @Override
    public TableInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TableInformation(
            rs.getString("table_name"),
            rs.getBoolean("updateable"),
            rs.getString("table_type"),
            rs.getString("comment")
        );
    }
}
