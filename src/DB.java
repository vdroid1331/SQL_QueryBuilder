public class DB {

    enum DBType {
        PGSQL, MySQL
    }

    private DBType type;
    public GenericSelectQuery selectQuery;
    public GenericUpdateQuery updateQuery;
    public GenericDeleteQuery deleteQuery;
    public  GenericCreateQuery createQuery;
    public GenericInsertQuery insertQuery;
    public GenericDropQuery dropQuery;

    public DB(String DBType) {
        if (isValidDBType(DBType)) {
            this.type = DB.DBType.valueOf(String.valueOf(DBType));
            // Perform logic based on the DBType
            initializeDatabase();
        } else {
            throw new IllegalArgumentException("Invalid DBType: " + DBType);
        }
    }

    private boolean isValidDBType(String dbType) {
        for (DBType validType : DBType.values()) {
            if (validType.name().equalsIgnoreCase(dbType)) {
                return true;
            }
        }
        return false;
    }

    private void initializeDatabase() {
        switch (type) {
            case PGSQL:
                this.updateQuery = new PGSQLUpdateQuery();
                this.selectQuery = new PGSQLSelectQuery();
                this.deleteQuery = new PGSQLDeleteQuery();
                this.createQuery = new PGSQLCreateQuery();
                this.insertQuery = new PGSQLInsertQuery();
                this.dropQuery = new PGSQLDropQuery();

                System.out.println("Initializing PostgreSQL database");
                break;
            case MySQL:
                this.updateQuery = new MySQLUpdateQuery();
                this.selectQuery = new MySQLSelectQuery();
                this.deleteQuery = new MySQLDeleteQuery();
                this.createQuery = new MySQLCreateQuery();
                this.insertQuery = new MySQLInsertQuery();
                this.dropQuery = new MySQLDropQuery();

                System.out.println("Initializing MySQL database");
                break;
            default:
                throw new UnsupportedOperationException("Unsupported DBType: " + type);
        }
    }
}
