public class GenericInsertQueryTest {

    public static void main(String[] args) throws Exception {
        try {
            runTests();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests() throws Exception {
        try {
            testBasicInsert();
            testInsertWithFieldsAndValues();
            testInsertWithArrayFieldsAndValues();
            testInsertWithNullTableName();
            testInsertWithNullFields();
            testInsertWithNullValues();
            testInsertWithMismatchedFieldsAndValues();
        } catch (Exception e) {
            throw new Exception("Generic Select Query Test failed.");
        }
    }

    private static void testBasicInsert() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertFields("column1, column2")
                .insertValues("value1, value2")
                .build();

        // Check if the basic INSERT query is correct
        assert "INSERT INTO table1 (column1, column2) (column1, column2);".equals(result) : "Test case testBasicInsert failed";
    }

    private static void testInsertWithFieldsAndValues() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertFields("column1, column2")
                .insertValues("value1, value2")
                .build();

        // Check if the INSERT query with specified fields and values is correct
        assert "INSERT INTO table1 (column1, column2) (value1, value2);".equals(result) : "Test case testInsertWithFieldsAndValues failed";
    }

    private static void testInsertWithArrayFieldsAndValues() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertFields(new String[]{"column1", "column2"})
                .insertValue(new String[]{"value1", "value2"})
                .build();

        // Check if the INSERT query with array of fields and values is correct
        assert "INSERT INTO table1 (column1, column2) (value1, value2);".equals(result) : "Test case testInsertWithArrayFieldsAndValues failed";
    }

    private static void testInsertWithNullTableName() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insertFields("column1, column2")
                .insertValues("value1, value2")
                .build();

        // Check if the INSERT query returns an error for null table name
        assert "ERROR: NO TABLE PROVIDED TO INSERT INTO".equals(result) : "Test case testInsertWithNullTableName failed";
    }

    private static void testInsertWithNullFields() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertValues("value1, value2")
                .build();

        // Check if the INSERT query returns an error for null fields
        assert "ERROR: NO FIELDS PROVIDED TO INSERT INTO".equals(result) : "Test case testInsertWithNullFields failed";
    }

    private static void testInsertWithNullValues() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertFields("column1, column2")
                .build();

        // Check if the INSERT query returns an error for null values
        assert "ERROR: NO VALUES PROVIDED TO INSERT INTO".equals(result) : "Test case testInsertWithNullValues failed";
    }

    private static void testInsertWithMismatchedFieldsAndValues() {
        GenericInsertQuery query = new GenericInsertQuery();
        String result = query.insert("table1")
                .insertFields("column1, column2")
                .insertValues("value1, value2, value3")
                .build();

        // Check if the INSERT query returns an error for mismatched fields and values
        assert "ERROR: NUMBER OF FIELDS AND NUMBER OF VALUES PROVIDED DO NOT MATCH".equals(result) : "Test case testInsertWithMismatchedFieldsAndValues failed";
    }
}
