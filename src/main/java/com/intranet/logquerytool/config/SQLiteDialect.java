package com.intranet.logquerytool.config;

import java.sql.Types;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.hibernate.type.descriptor.jdbc.IntegerJdbcType;
import org.hibernate.type.SqlTypes;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();

        // Register standard types
        registerColumnType(SqlTypes.INTEGER, "integer");
        registerColumnType(SqlTypes.VARCHAR, "varchar");
        registerColumnType(SqlTypes.FLOAT, "float");
        registerColumnType(SqlTypes.DOUBLE, "double");
        registerColumnType(SqlTypes.BOOLEAN, "boolean");
        registerColumnType(SqlTypes.DATE, "date");
        registerColumnType(SqlTypes.TIMESTAMP, "datetime");

        // Register SQL functions (basic example)
        this.getFunctionRegistry().register("lower", StandardAnsiSqlAggregationFunctions.LOWER);
        this.getFunctionRegistry().register("upper", StandardAnsiSqlAggregationFunctions.UPPER);
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public boolean supportsInsertReturning() {
        return false;
    }

    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsCascadeDelete() {
        return false;
    }

    @Override
    public String getIdentityColumnString(int type) {
        // For SQLite, identity column is always AUTOINCREMENT
        return "integer";
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }
}
