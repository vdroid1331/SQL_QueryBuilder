public class GenericInsertQuery implements  SQLInsertQuery {
    protected String tableName;
    protected String insertFields;
    protected String insertValues;

    GenericInsertQuery() {
        this.insertFields = "";
        this.insertValues = "";
        this.tableName = "";
    }

    protected void clearQuery() {
        this.insertFields = "";
        this.insertValues = "";
        this.tableName = "";
    }


    @Override
    public SQLInsertQuery insert(String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    public SQLInsertQuery insertFields(String insertFields) {
        this.insertFields = insertFields;
        return this;
    }

    @Override
    public SQLInsertQuery insertFields(String[] insertFields) {
        this.insertFields = "(" +  String.join(", ", insertFields) + ")";
        return this;
    }

    @Override
    public SQLInsertQuery insertValues(String insertValues) {
        this.insertValues = insertValues;
        return this;
    }

    @Override
    public SQLInsertQuery insertValue(String[] insertValues) {
        this.insertValues = "(" +  String.join(", ",  insertValues) + ")";
        return this;
    }

    @Override
    public String build() {
        if (this.tableName == null) {
            return "ERROR: NO TABLE PROVIDED TO INSERT INTO";
        }
        if (this.insertFields == null) {
            return "ERROR: NO FIELDS PROVIDED TO INSERT INTO";
        }
        if (this.insertValues == null) {
            return "ERROR: NO VALUES PROVIDED TO INSERT INTO";
        }
        if (this.insertValues.split(", ").length != this.insertFields.split(", ").length) {
            return "ERROR: NUMBER OF FIELDS AND NUMBER OF VALUES PROVIDED DO NOT MATCH";
        }
        String query =  "INSERT INTO " + this.tableName + " " + this.insertFields + " VALUES " + this.insertValues + ";";
        this.clearQuery();
        return query;
    }
}
