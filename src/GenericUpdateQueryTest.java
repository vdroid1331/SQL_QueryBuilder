public class GenericUpdateQueryTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testBasicUpdate();
            testUpdateWithSet();
            testUpdateWithWhere();
            testClearQuery();
        } catch (Exception e) {
            throw new Exception("Generic Update Query Test failed.");
        }
    }

    private static void testBasicUpdate() {
        GenericUpdateQuery query = new GenericUpdateQuery();
        String result = query.update("table1").build();

        // Check if the basic UPDATE query is correct
        assert "UPDATE table1 SET ERROR: NOTHING PROVIDED TO BE UPDATED;".equals(result) : "Test case testBasicUpdate failed";
    }

    private static void testUpdateWithSet() {
        GenericUpdateQuery query = new GenericUpdateQuery();
        String result = query.update("table1").set("column1 = 10, column2 = 'updated'").build();

        // Check if the UPDATE query with SET clause is correct
        assert "UPDATE table1 SET column1 = 10, column2 = 'updated' ;".equals(result) : "Test case testUpdateWithSet failed";
    }

    private static void testUpdateWithWhere() {
        GenericUpdateQuery query = new GenericUpdateQuery();
        String result = query.update("table1").set("column1 = 10").where("column2 = 'old'").build();

        // Check if the UPDATE query with WHERE clause is correct
        assert "UPDATE table1 SET column1 = 10 WHERE column2 = 'old' ;".equals(result) : "Test case testUpdateWithWhere failed";
    }

    private static void testClearQuery() {
        GenericUpdateQuery query = new GenericUpdateQuery();
        query.update("table1").set("column1 = 10").where("column2 = 'old'").build();

        // Check if clearQuery method resets the query
        query.clearQuery();
        assert "".equals(query.updateClause) : "Test case testClearQuery failed - Update clause not cleared";
        assert "".equals(query.setClause) : "Test case testClearQuery failed - Set clause not cleared";
        assert "".equals(query.whereCondition) : "Test case testClearQuery failed - Where condition not cleared";
    }
}
