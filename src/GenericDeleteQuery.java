import java.util.Objects;

public class GenericDeleteQuery implements SQLDeleteQuery{

    protected String tableName;
    protected String condition;

    GenericDeleteQuery() {
        this.tableName = "";
        this.condition = "";
    }

    @Override
    public SQLDeleteQuery where(String condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public SQLDeleteQuery delete(String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    public String build() {
        String query = "";
        if (Objects.equals(this.tableName, "")) {
            return "ERROR: NO TABLE NAME PROVIDED TO DROP";
        } else {
            if (Objects.equals(this.condition, "")) {
                query = "DELETE * FROM " + this.tableName + ";";
            } else {
                query = "DELETE FROM " + this.tableName + " WHERE " + this.condition + ";";
            }
        }
        this.clearQuery();
        return query;
    }

    @Override
    public void clearQuery() {
        this.tableName = "";
        this.condition = "";
    }
}
