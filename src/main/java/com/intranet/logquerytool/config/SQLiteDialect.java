package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
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
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsCascadeDelete() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        return "";
    }

    @Override
    public boolean qualifyIndexName() {
        return false;
    }

    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }

    @Override
    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    @Override
    public boolean dropTemporaryTableAfterUse() {
        return false;
    }
}
