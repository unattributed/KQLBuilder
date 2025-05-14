package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;


public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
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
            public boolean hasDataTypeInIdentityColumn() {
                return false;
            }
        };
    }

        /**
         * This method is not part of the Dialect class in Hibernate 6.x, 
         * so the @Override annotation causes compilation to fail.
         */
        // @Override
        // public boolean supportsCascadeDelete() {
        //     return true;
        // }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsIfExistsAfterTableName() {
        return false;
    }

    @Override
    public boolean supportsExpectedLobUsagePattern() {
        return true;
    }

    @Override
    public boolean supportsCommentOn() {
        return false;
    }

    @Override
    public boolean supportsTupleDistinctCounts() {
        return false;
    }

    @Override
    public boolean supportsValuesList() {
        return true;
    }
}
