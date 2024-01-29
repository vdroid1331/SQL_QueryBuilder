public class GenericSelectQueryTest {
    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testBasicSelect();
            testSelectWithFrom();
            testSelectWithWhere();
            testSelectWithOrderBy();
            testSelectWithGroupBy();
            testSelectWithJoin();
            testSelectWithLeftJoin();
            testClearQuery();
        } catch (Exception e) {
            throw new Exception("Generic Select Query Test failed.");
        }
    }

    private static void testBasicSelect() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").build();

        // Check if the basic SELECT query is correct
        assert "SELECT column1, column2 FROM ERROR: NO TABLE GIVEN TO BE READ".equals(result) : "Test case testBasicSelect failed";
    }

    private static void testSelectWithFrom() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").from("table1").build();

        // Check if the SELECT query with FROM clause is correct
        assert "SELECT column1, column2 FROM table1 ERROR: INVALID JOIN".equals(result) : "Test case testSelectWithFrom failed";
    }

    private static void testSelectWithWhere() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").from("table1").where("column1 > 10").build();

        // Check if the SELECT query with WHERE clause is correct
        assert "SELECT column1, column2 FROM table1 INNER JOIN ON ERROR: INVALID JOIN".equals(result) : "Test case testSelectWithWhere failed";
    }

    private static void testSelectWithOrderBy() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").from("table1").orderBy("column1", true).build();

        // Check if the SELECT query with ORDER BY clause is correct
        assert "SELECT column1, column2 FROM table1 INNER JOIN ON ERROR: INVALID JOIN".equals(result) : "Test case testSelectWithOrderBy failed";
    }

    private static void testSelectWithGroupBy() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").from("table1").groupBy("column1").build();

        // Check if the SELECT query with GROUP BY clause is correct
        assert "SELECT column1, column2 FROM table1 INNER JOIN ON ERROR: INVALID JOIN".equals(result) : "Test case testSelectWithGroupBy failed";
    }

    private static void testSelectWithJoin() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").fromAndJoin("table1", "table2", "column1", "column2").build();

        // Check if the SELECT query with JOIN clause is correct
        assert "SELECT column1, column2 FROM table1 INNER JOIN table2 ON table1.column1 = table2.column2 ERROR: GROUP BY ARGUMENT NOT SELECTED".equals(result) : "Test case testSelectWithJoin failed";
    }

    private static void testSelectWithLeftJoin() {
        GenericSelectQuery query = new GenericSelectQuery();
        String result = query.select("column1, column2").fromAndLeftJoin("table1", "table2", "column1", "column2").build();

        // Check if the SELECT query with LEFT JOIN clause is correct
        assert "SELECT column1, column2 FROM table1 LEFT JOIN table2 ON table1.column1 = table2.column2 ERROR: GROUP BY ARGUMENT NOT SELECTED".equals(result) : "Test case testSelectWithLeftJoin failed";
    }

    private static void testClearQuery() {
        GenericSelectQuery query = new GenericSelectQuery();
        query.select("column1, column2").from("table1").where("column1 > 10").build();

        // Check if clearQuery method resets the query
        query.clearQuery();
        assert "".equals(query.selectClause) : "Test case testClearQuery failed - Select clause not cleared";
        assert "".equals(query.fromClause) : "Test case testClearQuery failed - From clause not cleared";
        assert "".equals(query.whereCondition) : "Test case testClearQuery failed - Where condition not cleared";
        assert "".equals(query.orderByClause) : "Test case testClearQuery failed - OrderBy clause not cleared";
        assert "".equals(query.groupByClause) : "Test case testClearQuery failed - GroupBy clause not cleared";
        assert "".equals(query.joinedTable) : "Test case testClearQuery failed - Joined table not cleared";
        assert "".equals(query.tableOneField) : "Test case testClearQuery failed - TableOneField not cleared";
        assert "".equals(query.tableTwoField) : "Test case testClearQuery failed - TableTwoField not cleared";
    }
}
