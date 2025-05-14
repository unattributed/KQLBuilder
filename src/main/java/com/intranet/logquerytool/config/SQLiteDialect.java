package com.intranet.logquerytool.config;

import java.sql.Types;

import org.hibernate.dialect.Dialect;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        // Register column types as needed, adjust based on the required column types
        // Example: registerHibernateType(Types.VARCHAR, "string");
    }

    @Override
    public boolean supportsExpectedLobUsagePattern() {
        return true; // SQLite supports LOB usage pattern
    }

    @Override
    public String getTypeName(int code) {
        if (code == Types.VARCHAR) {
            return "text";
        } else if (code == Types.INTEGER) {
            return "integer";
        }
        return super.getTypeName(code); // Default type names
    }

    @Override
    public void registerColumnType(int code, String name) {
        // Example of registering types if needed
        super.registerColumnType(code, name);
    }

    @Override
    public boolean supportsCascadeDelete() {
        return true; // SQLite supports cascading deletes
    }

    public boolean supportsIdentityColumns() {
        return true;
    }

    public String getIdentitySelectString() {
        return "select last_insert_rowid()";
    }

    public String getIdentityColumnString() {
        return "integer primary key autoincrement";
    }

    public boolean hasDataTypeInIdentityColumn() {
        return false;
    }
}
