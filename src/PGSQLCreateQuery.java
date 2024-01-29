public class PGSQLCreateQuery extends GenericCreateQuery {
    @Override
    public String build() {
        String genericQuery = super.build();

        genericQuery = genericQuery.replace("id INT NOT NULL AUTO_INCREMENT", "id SERIAL PRIMARY KEY");
        if (this.foreignKeys == null) return genericQuery;
        for (String reference: this.foreignKeys) {
            String foreignKeyId = "";
            if (reference.contains(" NOT NULL")) {
                foreignKeyId = reference.split("\\s+")[0];
            } else {
                foreignKeyId = reference;
            }
            String toSearch = "FOREIGN KEY (" + foreignKeyId + "_id) REFERENCES " + foreignKeyId + "(" + foreignKeyId + ")";
            String toReplace = foreignKeyId + "_id INT REFERENCES " + foreignKeyId + "(" + foreignKeyId + ")";
            genericQuery = genericQuery.replace(toSearch, toReplace);
        }
        this.clearQuery();

        return genericQuery;
    }
}
