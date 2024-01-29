public class PGSQLSelectQueryTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {

        testBuildWithoutJoin();
        testBuildWithInnerJoin();
        } catch (Exception e) {
            throw new Exception("PGSQL Test failed.");
        }
    }

    private static void testBuildWithoutJoin() {
        PGSQLSelectQuery query = new PGSQLSelectQuery();
        query.select("column1, column2").from("table1").where("column1 > 10").build();

        // Check if the build method without INNER JOIN is correct
        assert "SELECT column1, column2 FROM table1 WHERE column1 > 10;".equals(query.build()) : "Test case testBuildWithoutJoin failed";
    }

    private static void testBuildWithInnerJoin() {
        PGSQLSelectQuery query = new PGSQLSelectQuery();
        query.select("column1, column2").fromAndJoin("table1", "table2", "column1", "column2").build();

        // Check if the build method with INNER JOIN is corrected to JOIN
        assert "SELECT column1, column2 FROM table1 JOIN table2 ON table1.column1 = table2.column2 ERROR: GROUP BY ARGUMENT NOT SELECTED;".equals(query.build()) : "Test case testBuildWithInnerJoin failed";
    }
}
