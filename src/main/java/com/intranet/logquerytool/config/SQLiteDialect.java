package com.intranet.logquerytool.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.query.spi.Limit;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super(null); // Pass null or a DialectResolutionInfo instance if required
    }

    public boolean supportsLimit() {
        return true;  // SQLite supports LIMIT
    }

    @Override
    public LimitHandler getLimitHandler() {
        return new LimitHandler() {
            @Override
            public boolean supportsLimit() {
                return true;
            }

            @Override
            public boolean supportsLimitOffset() {
                return true;
            }

            @Override
            public boolean supportsOffset() {
                return true; // SQLite supports OFFSET
            }

            @Override
            public String processSql(String sql, Limit limit) {
                if (limit.getFirstRow() > 0) {
                    return sql + " LIMIT " + limit.getMaxRows() + " OFFSET " + limit.getFirstRow();
                } else {
                    return sql + " LIMIT " + limit.getMaxRows();
                }
            }

            @Override
            public int bindLimitParametersAtStartOfQuery(Limit limit, PreparedStatement statement, int index) throws SQLException {
                statement.setInt(index, limit.getMaxRows());
                return index + 1;
            }

            @Override
            public int bindLimitParametersAtEndOfQuery(Limit limit, PreparedStatement statement, int index) throws SQLException {
                if (limit.getFirstRow() > 0) {
                    statement.setInt(index, limit.getFirstRow());
                    return index + 1;
                }
                return index;
            }

            @Override
            public void setMaxRows(Limit limit, PreparedStatement statement) throws SQLException {
                statement.setMaxRows(limit.getMaxRows());
            }
        };
    }

    public String getCreateTemporaryTableString() {
        return "CREATE TEMPORARY TABLE";  // SQLite's temporary table creation
    }

    public boolean supportsDropTableIfExists() {
        return true;  // SQLite supports DROP IF EXISTS
    }

    public String getFunction(String functionName) {
        // Return the function name for SQLite
        return functionName;
    }

    public String getDropTableString() {
        return "DROP TABLE IF EXISTS";  // SQLite's DROP table statement
    }

    public boolean isReadOnly() {
        return false;  // SQLite is not read-only by default
    }
}
