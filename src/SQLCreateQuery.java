public interface SQLCreateQuery {
    SQLCreateQuery create(String tableName);
    SQLCreateQuery addIntField(String fieldName);
    SQLCreateQuery addBigIntField(String fieldName);
    SQLCreateQuery addSmallIntField(String fieldName);
    SQLCreateQuery addDoubleField(String fieldName);
    SQLCreateQuery addFloatField(String fieldName);
    SQLCreateQuery addTextField(String fieldName);
    SQLCreateQuery addCharField(String fieldName, int size);
    SQLCreateQuery addVariableCharField(String fieldName, int size);
    SQLCreateQuery addBooleanField(String fieldName);
    SQLCreateQuery addEnumField(String fieldName, String options);
    SQLCreateQuery addJSONField(String fieldName);

    SQLCreateQuery addIntField(String fieldName, boolean isNullable);
    SQLCreateQuery addBigIntField(String fieldName, boolean isNullable);
    SQLCreateQuery addSmallIntField(String fieldName, boolean isNullable);
    SQLCreateQuery addDoubleField(String fieldName, boolean isNullable);
    SQLCreateQuery addFloatField(String fieldName, boolean isNullable);
    SQLCreateQuery addTextField(String fieldName, boolean isNullable);
    SQLCreateQuery addCharField(String fieldName, int size, boolean isNullable);
    SQLCreateQuery addVariableCharField(String fieldName, int size, boolean isNullable);
    SQLCreateQuery addBooleanField(String fieldName, boolean isNullable);
    SQLCreateQuery addEnumField(String fieldName, String options, boolean isNullable);
    SQLCreateQuery addJSONField(String fieldName, boolean isNullable);
    SQLCreateQuery addForeignKey(String tableName);
    SQLCreateQuery addForeignKey(String tableName, boolean isNullable);

    SQLCreateQuery addDateField(String fieldName);
    SQLCreateQuery addTimeField(String fieldName);
    SQLCreateQuery addTimeStampField(String fieldName);
    SQLCreateQuery addDateField(String fieldName, boolean isNullable);
    SQLCreateQuery addTimeField(String fieldName, boolean isNullable);
    SQLCreateQuery addTimeStampField(String fieldName, boolean isNullable);

    String build();


}
