import java.sql.SQLException;

public interface StuffDao extends Dao<Stuff, String> {


    boolean update(Stuff stuff) throws SQLException;
}
