package org.blackdread.sqltojava.service;

import static java.util.Map.entry;
import static org.blackdread.sqltojava.entity.JdlFieldEnum.*;
import static org.blackdread.sqltojava.entity.JdlFieldEnum.UUID;

import java.util.Map;
import org.blackdread.sqltojava.config.ApplicationProperties;
import org.blackdread.sqltojava.entity.JdlFieldEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sqlserver")
public class MsSqlJdlTypeService implements SqlJdlTypeService {

    private static final Logger log = LoggerFactory.getLogger(MsSqlJdlTypeService.class);

    private final ApplicationProperties properties;

    public MsSqlJdlTypeService(ApplicationProperties properties) {
        this.properties = properties;
    }

    //    private final Map<String, JdlFieldEnum> typeMap = Map.ofEntries(
    //        entry("boolean", BOOLEAN),
    //        entry("date", LOCAL_DATE),
    //        entry("time without time zone", TIME_AS_TEXT),
    //        entry("time with time zone", TIME_AS_TEXT),
    //        entry("timestamp without time zone", INSTANT),
    //        entry("timestamp with time zone", ZONED_DATE_TIME),
    //        entry("real", FLOAT),
    //        entry("double precision", DOUBLE),
    //        entry("smallint", INTEGER),
    //        entry("integer", INTEGER),
    //        entry("int", INTEGER),
    //        entry("bigint", LONG),
    //        entry("money", BIG_DECIMAL),
    //        entry("numeric", BIG_DECIMAL),
    //        entry("character", STRING),
    //        entry("character varying", STRING),
    //        entry("text", STRING_UNBOUNDED),
    //        entry("bytea", BLOB),
    //        entry("json", JSON_AS_TEXT),
    //        entry("uuid", UUID)
    //        //Map.entry("interval", null),
    //        //Map.entry("jsonb", null),
    //        //Map.entry("jsonpath", null),
    //        //Map.entry("macaddr", STRING),
    //        //Map.entry("macaddr8", STRING),
    //        //Map.entry("xml", STRING)
    //    );

    private final Map<String, JdlFieldEnum> typeMap = Map.ofEntries(
        entry("bit", BOOLEAN),
        entry("date", LOCAL_DATE),
        entry("time", TIME_AS_TEXT),
        entry("datetime", ZONED_DATE_TIME),
        entry("datetime2", ZONED_DATE_TIME),
        entry("smalldatetime", ZONED_DATE_TIME), // Added conversion for smalldatetime
        entry("real", FLOAT),
        entry("float", DOUBLE),
        entry("smallint", INTEGER),
        entry("int", INTEGER),
        entry("bigint", LONG),
        entry("tinyint", INTEGER), // Added conversion for tinyint
        entry("money", BIG_DECIMAL),
        entry("numeric", BIG_DECIMAL),
        entry("decimal", BIG_DECIMAL), // Added conversion for decimal
        entry("char", STRING),
        entry("varchar", STRING),
        entry("nvarchar", STRING), // Added conversion for nvarchar
        entry("nchar", STRING), // Added conversion for nchar
        entry("text", STRING_UNBOUNDED),
        entry("ntext", STRING_UNBOUNDED), // Added conversion for ntext (deprecated)
        entry("binary", BLOB),
        entry("varbinary", BLOB),
        entry("image", IMAGE_BLOB),
        entry("uniqueidentifier", UUID)
    );

    @Override
    public Map<String, JdlFieldEnum> getTypeMap() {
        return mergeOverrides(this.typeMap, properties.getJdlTypeOverrides());
    }
}
