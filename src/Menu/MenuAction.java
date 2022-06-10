package Menu;

import java.sql.SQLException;

public interface MenuAction {
    void execute() throws SQLException;
    String getOptionName();
}
