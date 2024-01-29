public class GenericDeleteQueryTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testEmptyDelete();
            testDeleteWithCondition();
            testClearQuery();
        } catch (Exception e) {
            throw new Exception("Generic Delete Query Test failed.");
        }
    }

    private static void testEmptyDelete() {
        GenericDeleteQuery query = new GenericDeleteQuery();
        String result = query.delete("users").build();

        // Check if the query is correct for an empty condition
        assert "DELETE * FROM users;".equals(result) : "Test case testEmptyDelete failed";

        // Check if the query is cleared after build
        assert "".equals(query.tableName) : "Test case testEmptyDelete failed - Table name not cleared";
        assert "".equals(query.condition) : "Test case testEmptyDelete failed - Condition not cleared";
    }

    private static void testDeleteWithCondition() {
        GenericDeleteQuery query = new GenericDeleteQuery();
        String result = query.delete("orders").where("status = 'completed'").build();

        // Check if the query is correct with a condition
        assert "DELETE FROM orders WHERE status = 'completed';".equals(result) : "Test case testDeleteWithCondition failed";

        // Check if the query is cleared after build
        assert "".equals(query.tableName) : "Test case testDeleteWithCondition failed - Table name not cleared";
        assert "".equals(query.condition) : "Test case testDeleteWithCondition failed - Condition not cleared";
    }

    private static void testClearQuery() {
        GenericDeleteQuery query = new GenericDeleteQuery();
        query.delete("products").where("price > 100").build();

        // Check if clearQuery method resets the query
        query.clearQuery();
        assert "".equals(query.tableName) : "Test case testClearQuery failed - Table name not cleared";
        assert "".equals(query.condition) : "Test case testClearQuery failed - Condition not cleared";
    }
}
