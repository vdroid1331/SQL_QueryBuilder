import java.util.ArrayList;
import java.util.Arrays;

public class GenericCreateQuery implements SQLCreateQuery {
    protected String tableName;
    protected ArrayList<String> intFields;
    protected ArrayList<String> bigIntFields;
    protected ArrayList<String> smallIntFields;
    protected ArrayList<String> doubleFields;
    protected ArrayList<String> floatFields;
    protected ArrayList<String> textFields;
    protected ArrayList<String> charFields;
    protected ArrayList<String> varCharFields;
    protected ArrayList<String> booleanFields;
    protected ArrayList<String> enumFields;
    protected ArrayList<String> JSONFields;
    protected ArrayList<String> foreignKeys;
    protected ArrayList<String> dateFields;
    protected ArrayList<String> timeFields;
    protected ArrayList<String> timestampFields;



    @Override
    public SQLCreateQuery create(String tableName) {
        if (this.tableName == null) {
            this.tableName = tableName;
        }
        return this;
    }

    @Override
    public SQLCreateQuery addIntField(String fieldName) {
        if (this.intFields == null) {
            this.intFields = new ArrayList<>();
        }
        this.intFields.add(fieldName + " INT");
        return this;
    }

    @Override
    public SQLCreateQuery addBigIntField(String fieldName) {
        if (this.bigIntFields == null) {
            this.bigIntFields = new ArrayList<>();
        }
        this.bigIntFields.add(fieldName + " BIGINT");
        return this;
    }

    @Override
    public SQLCreateQuery addSmallIntField(String fieldName) {
        if (this.smallIntFields == null) {
            this.smallIntFields = new ArrayList<>();
        }
        this.smallIntFields.add(fieldName + " SMALLINT");
        return this;
    }

    @Override
    public SQLCreateQuery addDoubleField(String fieldName) {
        if (this.doubleFields == null) {
            this.doubleFields = new ArrayList<>();
        }
        this.doubleFields.add(fieldName + " DOUBLE");
        return this;
    }

    @Override
    public SQLCreateQuery addFloatField(String fieldName) {
        if (this.floatFields == null) {
            this.floatFields = new ArrayList<>();
        }
        this.floatFields.add(fieldName + " FLOAT");
        return this;
    }

    @Override
    public SQLCreateQuery addTextField(String fieldName) {
        if (this.textFields == null) {
            this.textFields = new ArrayList<>();
        }
        this.textFields.add(fieldName + " TEXT");
        return this;
    }

    @Override
    public SQLCreateQuery addCharField(String fieldName, int size) {
        if (this.charFields == null) {
            this.charFields = new ArrayList<>();
        }
        this.charFields.add(fieldName + " CHAR" + "(" + size + ")");
        return this;
    }

    @Override
    public SQLCreateQuery addVariableCharField(String fieldName, int size) {
        if (this.varCharFields == null) {
            this.varCharFields = new ArrayList<>();
        }
        this.varCharFields.add(fieldName + " VARCHAR" + "(" + size + ")");
        return this;
    }

    @Override
    public SQLCreateQuery addBooleanField(String fieldName) {
        if (this.booleanFields == null) {
            this.booleanFields = new ArrayList<>();
        }
        this.booleanFields.add(fieldName + " BOOLEAN");
        return this;
    }

    @Override
    public SQLCreateQuery addEnumField(String fieldName, String options) {
        if (this.enumFields == null) {
            this.enumFields = new ArrayList<>();
        }
        this.enumFields.add(fieldName + " ENUM" + options);
        return this;
    }

    @Override
    public SQLCreateQuery addJSONField(String fieldName) {
        if (this.JSONFields == null) {
            this.JSONFields = new ArrayList<>();
        }
        this.JSONFields.add(fieldName + " JSON");
        return this;
    }

    @Override
    public SQLCreateQuery addIntField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.intFields == null) {
            this.intFields = new ArrayList<>();
        }
        this.intFields.add(fieldName + " INT" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addBigIntField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.bigIntFields == null) {
            this.bigIntFields = new ArrayList<>();
        }
        this.bigIntFields.add(fieldName + " BIGINT" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addSmallIntField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.smallIntFields == null) {
            this.smallIntFields = new ArrayList<>();
        }
        this.smallIntFields.add(fieldName + " SMALLINT" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addDoubleField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.doubleFields == null) {
            this.doubleFields = new ArrayList<>();
        }
        this.doubleFields.add(fieldName + " DOUBLE" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addFloatField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.floatFields == null) {
            this.floatFields = new ArrayList<>();
        }
        this.floatFields.add(fieldName + " FLOAT" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addTextField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.textFields == null) {
            this.textFields = new ArrayList<>();
        }
        this.textFields.add(fieldName + " TEXT" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addCharField(String fieldName, int size, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.charFields == null) {
            this.charFields = new ArrayList<>();
        }
        this.charFields.add(fieldName + " CHAR" + "(" + size + ")" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addVariableCharField(String fieldName, int size, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.varCharFields == null) {
            this.varCharFields = new ArrayList<>();
        }
        this.varCharFields.add(fieldName + " VARCHAR" + "(" + size + ")" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addBooleanField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.booleanFields == null) {
            this.booleanFields = new ArrayList<>();
        }
        this.booleanFields.add(fieldName + " BOOLEAN" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addEnumField(String fieldName, String options, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.enumFields == null) {
            this.enumFields = new ArrayList<>();
        }
        this.enumFields.add(fieldName + " ENUM" + options + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addJSONField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.JSONFields == null) {
            this.JSONFields = new ArrayList<>();
        }
        this.JSONFields.add(fieldName + " JSON" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addForeignKey(String tableName) {
        if (this.foreignKeys == null) {
            this.foreignKeys = new ArrayList<>();
        }
        this.foreignKeys.add(tableName);
        return this;
    }

    @Override
    public SQLCreateQuery addForeignKey(String tableName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.foreignKeys == null) {
            this.foreignKeys = new ArrayList<>();
        }
        this.foreignKeys.add(tableName + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addDateField(String fieldName) {
        if (this.dateFields == null) {
            this.dateFields = new ArrayList<>();
        }
        this.dateFields.add(fieldName + " DATE");
        return this;
    }

    @Override
    public SQLCreateQuery addTimeField(String fieldName) {
        if (this.timeFields == null) {
            this.timeFields = new ArrayList<>();
        }
        this.timeFields.add(fieldName + " TIME");
        return this;
    }

    @Override
    public SQLCreateQuery addTimeStampField(String fieldName) {
        if (this.timestampFields == null) {
            this.timestampFields = new ArrayList<>();
        }
        this.timestampFields.add(fieldName + " TIMESTAMP");
        return this;
    }

    @Override
    public SQLCreateQuery addDateField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.dateFields == null) {
            this.dateFields = new ArrayList<>();
        }
        this.dateFields.add(fieldName + " DATE" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addTimeField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.timeFields == null) {
            this.timeFields = new ArrayList<>();
        }
        this.timeFields.add(fieldName + " TIME" + nullableBehaviour);
        return this;
    }

    @Override
    public SQLCreateQuery addTimeStampField(String fieldName, boolean isNullable) {
        String nullableBehaviour = isNullable ? "" : " NOT NULL";
        if (this.timestampFields == null) {
            this.timestampFields = new ArrayList<>();
        }
        this.timestampFields.add(fieldName + " TIMESTAMP" + nullableBehaviour);
        return this;
    }

    @Override
    public String build() {
        if (this.tableName == null) {
            return "ERROR: NO TABLE NAME PROVIDED, CANNOT CREATE A TABLE WITHOUT NAME";
        }

        StringBuilder query = new StringBuilder("CREATE TABLE " + this.tableName + " (\n\tid INT NOT NULL AUTO_INCREMENT,");

        // Add INTEGER fields
        appendFieldsToQuery(query, this.intFields);

        // Add BIGINT fields
        appendFieldsToQuery(query, this.bigIntFields);

        // Add SMALLINT fields
        appendFieldsToQuery(query, this.smallIntFields);

        // Add DOUBLE fields
        appendFieldsToQuery(query, this.doubleFields);

        // Add FLOAT fields
        appendFieldsToQuery(query, this.floatFields);

        // Add TEXT fields
        appendFieldsToQuery(query, this.textFields);

        // Add CHAR fields
        appendFieldsToQuery(query, this.charFields);

        // Add VARCHAR fields
        appendFieldsToQuery(query, this.varCharFields);

        // Add BOOLEAN fields
        appendFieldsToQuery(query, this.booleanFields);

        // Add ENUM fields
        appendFieldsToQuery(query, this.enumFields);

        // Add JSON fields
        appendFieldsToQuery(query, this.JSONFields);

        // Add DATE fields
        appendFieldsToQuery(query, this.dateFields);

        // Add TIME fields
        appendFieldsToQuery(query, this.timeFields);

        // Add TIMESTAMP fields
        appendFieldsToQuery(query, this.timestampFields);

        if (this.foreignKeys != null) {
            for (String reference : this.foreignKeys) {
                String foreignKeyId = "";
                if (reference.contains(" NOT NULL")) {
                    foreignKeyId = reference.split("\\s+")[0];
                } else {
                    foreignKeyId = reference;
                }

                query.append("    ").append("FOREIGN KEY ").append("(").append(foreignKeyId).append("_id) REFERENCES ").append(foreignKeyId).append("(").append(foreignKeyId).append("_id)").append(",\n");
            }
        }

        query.append("\n);");
        return query.toString();
    }

    // Helper method to append fields to the query
    protected void appendFieldsToQuery(StringBuilder query, ArrayList<String> fields) {
        if (fields != null) {
            for (String field : fields) {
                query.append("    ").append(field).append(",\n");
            }
        }
    }
}
