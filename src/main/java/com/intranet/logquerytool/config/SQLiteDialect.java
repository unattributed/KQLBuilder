package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.engine.jdbc.dialect.internal.StandardAnsiSqlAggregationFunctions;
import org.hibernate.sql.ast.spi.SqlAstTranslator;
import org.hibernate.type.StandardSQLFunction;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    // Constructor
    public SQLiteDialect() {
        super();
    }

    // Overriding method for SQLite-specific identity column handling
    @Override
    public boolean supportsIdentityColumns() {
        return true; // SQLite supports identity columns
    }

    @Override
    public boolean hasDataTypeInIdentityColumn() {
        return false; // SQLite does not have data types in identity columns
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()"; // SQLite syntax for getting last inserted row id
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer primary key autoincrement"; // SQLite column definition for auto-increment
    }

    @Override
    public boolean supportsLimit() {
        return true; // SQLite supports LIMIT
    }

    @Override
    public String getLimitString(String query, boolean hasOffset) {
        return query + (hasOffset ? " limit ? offset ?" : " limit ?");
    }

    @Override
    public boolean supportsTransactionIsolationLevel(int level) {
        return level == TRANSACTION_READ_COMMITTED;
    }

    @Override
    public boolean supportsSavepoints() {
        return true; // SQLite supports savepoints
    }

    @Override
    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists"; // SQLite temporary table creation
    }

    @Override
    public boolean supportsDropTableIfExists() {
        return true; // SQLite supports 'DROP TABLE IF EXISTS'
    }

    @Override
    public void registerColumnType(int code, String name) {
        if (code == Types.BIT) {
            registerColumnType(code, "boolean");
        } else {
            super.registerColumnType(code, name); // Let Hibernate handle other types
        }
    }

    // SQL Function handling
    @Override
    public SQLFunction getFunction(String functionName) {
        // Example of adding custom functions for SQLite, replace with actual functions
        if ("my_custom_function".equalsIgnoreCase(functionName)) {
            return new StandardSQLFunction(functionName, Types.INTEGER);
        }
        return super.getFunction(functionName); // Fallback to default
    }

    @Override
    public String getDropTableString() {
        return "drop table if exists"; // SQLite drop table syntax
    }

    @Override
    public boolean isReadOnly() {
        return false; // SQLite is not necessarily read-only
    }

    // Other necessary overrides...
}
