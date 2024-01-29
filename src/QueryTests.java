public class QueryTests {
    public static void main(String[] args) throws Exception {
        try {
            PGSQLSelectQueryTest.runTests();
            GenericUpdateQueryTest.runTests();
            GenericDeleteQueryTest.runTests();
            GenericSelectQueryTest.runTests();
            DBTest.runTests();
        } catch (Exception e) {
            throw new Exception("Tests failed.");
        }
    }
}
