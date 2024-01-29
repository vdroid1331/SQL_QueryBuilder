public interface SQLDeleteQuery {
    SQLDeleteQuery where(String condition);
    SQLDeleteQuery delete(String tableName);
    String build();
    void clearQuery();
}
