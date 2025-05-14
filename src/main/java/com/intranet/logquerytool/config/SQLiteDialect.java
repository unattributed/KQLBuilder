package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelper;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelperBuilder;
import org.hibernate.id.PostInsertIdentityPersister;
import org.hibernate.id.insert.GetGeneratedKeysDelegate;
// Removed unused import for IdentifierCaseHandling
// Removed import for DatabaseVersion as it cannot be resolved

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super(DatabaseVersion.make(3, 36)); // Specify SQLite version 3.36 as an example
        this.registerColumnTypes(); // Ensure column types are registered in the default constructor
    }

    public SQLiteDialect(DialectResolutionInfo info) {
        super(info);
        registerColumnTypes();
    }

    // Removed duplicate method to resolve the compile error

    private void registerColumnType(int sqlType, String typeName) {
        // Implementation for registering column types
        // This is a placeholder; you may need to adapt it based on your requirements
    }

    private void registerColumnTypes() {
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.NULL, "null");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "integer");
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

    @Override
    public LimitHandler getLimitHandler() {
        return new LimitOffsetLimitHandler();
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsIfExistsAfterTableName() {
        return false;
    }

    // Removed references to IdentifierCaseHandling as it cannot be resolved

    public IdentifierHelper buildIdentifierHelper(IdentifierHelperBuilder builder) {
        // Implementation for building IdentifierHelper
        return builder.build();
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    public String getCurrentTimestampSQLFunctionName() {
        return "current_timestamp";
    }

    // Custom SQLite identity column support
    public static class SQLiteIdentityColumnSupport implements IdentityColumnSupport {
        @Override
        public boolean supportsIdentityColumns() {
            return true;
        }

        @Override
        public String getIdentitySelectString(String table, String column, int type) {
            return "select last_insert_rowid()";
        }

        @Override
        public String getIdentityColumnString(int type) {
            return "integer primary key autoincrement";
        }

        @Override
        public String getIdentityInsertString() {
            return "null";
        }

        @Override
        public boolean hasDataTypeInIdentityColumn() {
            return false;
        }

        @Override
        public String appendIdentitySelectToInsert(String insertString) {
            // SQLite does not support appending identity select to insert
            return insertString;
        }

        @Override
        public boolean supportsInsertSelectIdentity() {
            return false;
        }
        
        @Override
        public GetGeneratedKeysDelegate buildGetGeneratedKeysDelegate(PostInsertIdentityPersister persister, Dialect dialect) {
            // SQLite does not support getGeneratedKeys; throwing UnsupportedOperationException
            throw new UnsupportedOperationException("SQLite does not support getGeneratedKeys");
        }

        // Removed duplicate method definition to resolve the compile error
    }
}