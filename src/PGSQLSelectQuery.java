public class PGSQLSelectQuery extends GenericSelectQuery {
    @Override
    public String build() {
        String genericQuery = super.build();
        if (genericQuery.contains("INNER JOIN")) {
            return genericQuery.replace("INNER JOIN", "JOIN");
        } else {
            return genericQuery;
        }
    }
}
