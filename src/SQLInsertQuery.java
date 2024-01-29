public interface SQLInsertQuery {
    SQLInsertQuery insert(String tableName);
    SQLInsertQuery insertFields(String insertFields);
    SQLInsertQuery insertFields(String [] insertFields);
    SQLInsertQuery insertValues(String insertValues);
    SQLInsertQuery insertValue(String [] insertValues);

    String build();
}
