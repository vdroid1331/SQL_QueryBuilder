public class MySQLCreateQuery extends GenericCreateQuery {
    @Override
    public String build() {
        String genericQuery = super.build();
        this.clearQuery();
        return genericQuery;
    }
}
