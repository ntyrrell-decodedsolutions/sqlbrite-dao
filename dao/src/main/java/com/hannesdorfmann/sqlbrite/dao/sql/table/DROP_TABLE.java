package com.hannesdorfmann.sqlbrite.dao.sql.table;

import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import com.hannesdorfmann.sqlbrite.dao.sql.SqlExecuteCompileable;
import com.hannesdorfmann.sqlbrite.dao.sql.SqlRootNode;

/**
 * DROP a SQL Table
 *
 * @author Hannes Dorfmann
 */
public class DROP_TABLE extends SqlRootNode implements SqlExecuteCompileable {

  private final String sql;

  public DROP_TABLE(String tableName) {
    if (tableName == null) throw new IllegalArgumentException("The table name is null");

    sql = "DROP TABLE " + tableName;
  }

  @Override public String getSql() {
    return sql;
  }

  @Override public CompileableStatement asCompileableStatement() {
    return new CompileableStatement(sql, null);
  }

  @Override public void execute(SQLiteDatabase database) throws SQLException {
    database.execSQL(asCompileableStatement().sql);
  }
}
