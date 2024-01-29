import java.util.Objects;

public class GenericDropQuery implements SQLDropQuery {

    protected String entityType;
    protected String entity;

    GenericDropQuery () {
        this.entityType = "";
        this.entity = "";
    }


    protected void clearQuery() {
        this.entity = "";
        this.entityType = "";
    }

    @Override
    public SQLDropQuery dropDatabase() {
        this.entityType = "DATABASE";
        return this;
    }

    @Override
    public SQLDropQuery dropTable() {
        this.entityType = "TABLE";
        return this;
    }

    @Override
    public SQLDropQuery drop(String entity) {
        this.entity = entity;
        return this;
    }

    @Override
    public String build() {
        if (Objects.equals(this.entityType, "")) {
            return "ERROR: NO ENTITY TYPE PROVIDED TO DROP";
        }
        if (Objects.equals(this.entity, "")) {
            return "ERROR: NO " + this.entityType + " PROVIDED TO DROP";
        }
        String query = "DROP " + this.entityType + " " + this.entity + ";";
        this.clearQuery();
        return query;
    }
}
