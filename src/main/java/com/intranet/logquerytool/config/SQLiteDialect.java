package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.query.sqm.FetchClauseType;
import org.hibernate.type.SqlTypes;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.BasicTypeRegistry;
import org.hibernate.type.spi.TypeConfiguration;

import java.sql.Types;

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

    @Override
    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
        BasicTypeRegistry registry = typeContributions.getTypeConfiguration().getBasicTypeRegistry();
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.INTEGER, "integer"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.VARCHAR, "text"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.BOOLEAN, "boolean"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.DOUBLE, "double"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.FLOAT, "float"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.BIGINT, "bigint"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.TIMESTAMP, "datetime"));
        registry.register(new org.hibernate.type.descriptor.jdbc.internal.StandardSqlTypeDescriptor(SqlTypes.BINARY, "blob"));
    }

    @Override
    public boolean supportsCascadeDelete() {
        return true;
    }

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
// Note: The above code is a custom SQLite dialect for Hibernate ORM.