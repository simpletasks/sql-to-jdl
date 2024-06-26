-- create sqlserver-getAllTableRelationInformation.sql for mssql server database using example file postgresql-getAllTableRelationInformation.sql as for postregsql database
SELECT
    FK.TABLE_SCHEMA AS table_schema,
    FK.TABLE_NAME AS table_name,
    CU.COLUMN_NAME AS column_name,
    PK.TABLE_SCHEMA AS foreign_table_schema,
    PK.TABLE_NAME AS foreign_table_name,
    PT.COLUMN_NAME AS foreign_column_name
FROM
    INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS C
INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS FK
    ON C.CONSTRAINT_NAME = FK.CONSTRAINT_NAME
INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS PK
    ON C.UNIQUE_CONSTRAINT_NAME = PK.CONSTRAINT_NAME
INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE CU
    ON C.CONSTRAINT_NAME = CU.CONSTRAINT_NAME
INNER JOIN (
    SELECT
        i1.TABLE_NAME,
        i2.COLUMN_NAME
    FROM
        INFORMATION_SCHEMA.TABLE_CONSTRAINTS i1
    INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE i2
        ON i1.CONSTRAINT_NAME = i2.CONSTRAINT_NAME
    WHERE
        i1.CONSTRAINT_TYPE = 'PRIMARY KEY'
) PT
ON PT.TABLE_NAME = PK.TABLE_NAME
WHERE
    FK.TABLE_SCHEMA = :schemaName
--ORDER BY
--    FK.TABLE_SCHEMA,
--    FK.TABLE_NAME;
