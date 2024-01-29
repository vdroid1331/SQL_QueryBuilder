public class DBTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testInitializationWithValidDBType();
            testInitializationWithInvalidDBType();
        } catch (Exception e) {
            throw new Exception("DB Test failed.");
        }
    }

    private static void testInitializationWithValidDBType() {
        try {
            DB pgsqlDB = new DB("PGSQL");

            // Check if PGSQL queries are initialized correctly
            assert pgsqlDB.selectQuery instanceof PGSQLSelectQuery : "Test case testInitializationWithValidDBType failed - SelectQuery is not PGSQLSelectQuery";
            assert pgsqlDB.updateQuery instanceof PGSQLUpdateQuery : "Test case testInitializationWithValidDBType failed - UpdateQuery is not PGSQLUpdateQuery";
            assert pgsqlDB.deleteQuery instanceof PGSQLDeleteQuery : "Test case testInitializationWithValidDBType failed - DeleteQuery is not PGSQLDeleteQuery";

            DB mySqlDB = new DB("MySQL");

            // Check if MySQL queries are initialized correctly
            assert mySqlDB.selectQuery instanceof MySQLSelectQuery : "Test case testInitializationWithValidDBType failed - SelectQuery is not MySQLSelectQuery";
            assert mySqlDB.updateQuery instanceof MySQLUpdateQuery : "Test case testInitializationWithValidDBType failed - UpdateQuery is not MySQLUpdateQuery";
            assert mySqlDB.deleteQuery instanceof MySQLDeleteQuery : "Test case testInitializationWithValidDBType failed - DeleteQuery is not MySQLDeleteQuery";

            System.out.println("Test case testInitializationWithValidDBType passed");
        } catch (Exception e) {
            System.out.println("Test case testInitializationWithValidDBType failed - Exception: " + e.getMessage());
        }
    }

    private static void testInitializationWithInvalidDBType() {
        try {
            // Attempt to initialize with an invalid DBType
            DB invalidDB = new DB("InvalidDBType");
            System.out.println("Test case testInitializationWithInvalidDBType failed - Expected an IllegalArgumentException, but no exception occurred.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test case testInitializationWithInvalidDBType passed");
        } catch (Exception e) {
            System.out.println("Test case testInitializationWithInvalidDBType failed - Unexpected exception: " + e.getMessage());
        }
    }
}
