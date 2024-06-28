import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class QuizResultDAO {

   public void saveQuizResult(QuizResult var1) {
      try {
         Connection var2 = DatabaseConnection.getConnection();
         PreparedStatement var3 = var2.prepareStatement("INSERT INTO quiz_results (id,Name,Score) VALUES (?,?,?)");
         var3.setString(1, var1.getId());
         var3.setString(2, var1.getUsername());
         var3.setInt(3, var1.getScore());
         var3.executeUpdate();
      } catch (SQLException var4) {
         var4.printStackTrace();
      }

   }

   public QuizResult getQuizResultById(String var1) {
      try {
         Connection var2 = DatabaseConnection.getConnection();
         PreparedStatement var3 = var2.prepareStatement("SELECT * FROM quiz_results WHERE id = ?");
         var3.setString(1, var1);
         ResultSet var4 = var3.executeQuery();
         if (var4.next()) {
            String var5 = var4.getString("Name");
            int var6 = var4.getInt("Score");
            return new QuizResult(var1, var5, var6);
         }
      } catch (SQLException var7) {
         var7.printStackTrace();
      }

      return null;
   }
}

