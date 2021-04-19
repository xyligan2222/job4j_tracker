package ru.job4j.tracker;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;


    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public SqlTracker() {
        init();
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = cn.prepareStatement("INSERT INTO items (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.executeUpdate();
            try (ResultSet rsl = st.getGeneratedKeys()) {
                if (rsl.next()) {
                    item.setId(Integer.valueOf(rsl.getString(1)));
                    return item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(item.getName());
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        try (PreparedStatement st = cn.prepareStatement("UPDATE items values SET name = ? WHERE id = ?;")) {
            st.setString(1, item.getName());
            st.setInt(2, Integer.parseInt(id));
            st.execute();
            int row = st.executeUpdate();
            if (row > 0) {
                rsl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        try (PreparedStatement st = cn.prepareStatement("DELETE FROM items WHERE id = ?;")) {
            st.setInt(1, Integer.parseInt(id));
            int row = st.executeUpdate();
            if (row > 0) {
                rsl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Item item = new Item(name);
                item.setId((id));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("SELECT * FROM items WHERE name = ?;")) {
            st.setString(1, key);
            ResultSet rslSet = st.executeQuery();
            while (rslSet.next()) {
                int id = rslSet.getInt("id");
                String name = rslSet.getString("name");
                Item item = new Item(name);
                item.setId(id);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public Item findById(String id) {
        Item rsl = null;
        try (PreparedStatement st = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rslSet = st.executeQuery();
            if (rslSet.next()) {
                int itemId = rslSet.getInt("id");
                String name = rslSet.getString("name");
                rsl = new Item(name);
                rsl.setId(itemId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rsl);
        return rsl;
    }


}
