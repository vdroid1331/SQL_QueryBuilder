public class GenericDropQueryTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testDropDatabase();
            testDropTable();
            testDropEntity();
            testBuildWithNoEntityType();
            testBuildWithNoEntity();
        } catch (Exception e) {
            throw new Exception("Generic Select Query Test failed.");
        }
    }

    private static void testDropDatabase() {
        GenericDropQuery query = new GenericDropQuery();
        String result = query.dropDatabase().build();

        // Check if the DROP DATABASE query is correct
        assert "DROP DATABASE ;".equals(result) : "Test case testDropDatabase failed";
    }

    private static void testDropTable() {
        GenericDropQuery query = new GenericDropQuery();
        String result = query.dropTable().build();

        // Check if the DROP TABLE query is correct
        assert "DROP TABLE ;".equals(result) : "Test case testDropTable failed";
    }

    private static void testDropEntity() {
        GenericDropQuery query = new GenericDropQuery();
        String result = query.drop("exampleEntity").build();

        // Check if the DROP query with specified entity is correct
        assert "DROP exampleEntity ;".equals(result) : "Test case testDropEntity failed";
    }

    private static void testBuildWithNoEntityType() {
        GenericDropQuery query = new GenericDropQuery();
        query.drop("exampleEntity");
        String result = query.build();

        // Check if the BUILD method returns an error for no entity type
        assert "ERROR: NO ENTITY TYPE PROVIDED TO DROP".equals(result) : "Test case testBuildWithNoEntityType failed";
    }

    private static void testBuildWithNoEntity() {
        GenericDropQuery query = new GenericDropQuery();
        query.dropTable();
        String result = query.build();

        // Check if the BUILD method returns an error for no entity
        assert "ERROR: NO TABLE PROVIDED TO DROP".equals(result) : "Test case testBuildWithNoEntity failed";
    }
}
