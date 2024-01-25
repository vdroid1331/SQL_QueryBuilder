public interface SQLSelectQuery {
    SQLSelectQuery select(String fields);
    SQLSelectQuery select(String[] fields);
    SQLSelectQuery from(String fields);
    SQLSelectQuery where(String condition);
    SQLSelectQuery orderBy(String condition);
    SQLSelectQuery orderBy(String condition, boolean orderByAscending);
    SQLSelectQuery orderBy(String condition, String orderByModifier);
    SQLSelectQuery groupBy(String fields);
    SQLSelectQuery groupBy(String[] fields);

    // for usage without the from method
    SQLSelectQuery fromAndJoin(String joinTableOne, String joinTableTwo, String firstTableField, String secondTableField);

    // to be used with the from method
    SQLSelectQuery joinOn(String joinTableTwo, String firstTableField, String secondTableField);

    String build();
}
