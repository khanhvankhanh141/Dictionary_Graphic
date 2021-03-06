package com.example.dictionary_graphic;
import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;

public class DictionaryManager {
    public static java.sql.Connection connection;
    public static java.sql.PreparedStatement preparedness;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amitdb", "root", "khanhminh123@");
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches detail of word in the database.
     */
    public static String searchWord(String word) throws SQLException {
        final String sqlSearchDetail = "select detail from dictionary where word=?";
        preparedness = connection.prepareStatement(sqlSearchDetail);
        preparedness.setString( 1, word);
        ResultSet rs = preparedness.executeQuery();
        System.out.println("Searched already!");

        if (!rs.next()) {
            return "";
        } else {
            System.out.println(rs.getString("detail"));
            return rs.getString("detail");
        }
    }

    /**
     * Inserts word to the database.
     */
    public static void insertWord(final String word, final String detail) throws SQLException {
        final String sqlInsertData = "insert into dictionary (word, detail) value (?, ?)";

        preparedness = connection.prepareStatement(sqlInsertData);
        preparedness.setString(1,word);
        preparedness.setString(2,detail);
        preparedness.executeUpdate();

        System.out.println("Inserted successfully");
    }

    /**
     * Deletes a word from the database.
     */
    public static void deleteWord(String word) throws SQLException {
        String sqlDeleteData = "delete from dictionary where word = ?";
        preparedness = connection.prepareStatement(sqlDeleteData);

        preparedness.setString(1,word);
        preparedness.executeUpdate();
        System.out.println("Deleted successfully");
    }

    /**
     * Fixes a Word's detail.
     */
    public static void fixWord(String word, String detail) throws SQLException {
        String sqlFixData = "update dictionary set detail = ? where word = ? ";
        preparedness = connection.prepareStatement(sqlFixData);

        preparedness.setString(1, detail);
        preparedness.setString(2, word);

        preparedness.executeUpdate();
    }

    /**
     * Takes words from database to word list.
     */
    public static void getAllWord() throws SQLException {
        String sqlGetAllWord = "SELECT * FROM amitdb.dictionary ORDER BY word";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sqlGetAllWord);
        while (resultSet.next()) {
            String word = resultSet.getString("word");
            String detail = resultSet.getString("detail");
            Word w = new Word(word,detail);
            Dictionary.addWordFromDb(w);
        }
        st.close();
    }
}
