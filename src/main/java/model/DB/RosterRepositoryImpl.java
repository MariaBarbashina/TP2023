package model.DB;

import model.Roster;
import model.RosterRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RosterRepositoryImpl implements RosterRepository {
    private Connection connection;

    public RosterRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Roster find(Long id) {
        try (Statement statement =
                     connection.createStatement()) {
            ResultSet resultSet =
                    statement.executeQuery("select * from boxes.boxes where id = " + id);
            List<Roster> rosters = new ArrayList<>();
            while (resultSet.next()) {
                long uid = resultSet.getLong("id");
                String title = resultSet.getString("title");
                Roster roster = new Roster(uid, title, null);
                rosters.add(roster);
            }
            return rosters.get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        }
    }

    @Override
    public List<Roster> list() {
        try (Statement statement =
                     connection.createStatement()) {
            ResultSet resultSet =
                    statement.executeQuery("select * from boxes.boxes");
            List<Roster> rosters = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                Roster roster = new Roster(id, title, null);
                rosters.add(roster);
            }
            return rosters;
        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        }
    }

    @Override
    public void save(Roster roster) {

    }

    @Override
    public void remove(Roster roster) {

    }
}
