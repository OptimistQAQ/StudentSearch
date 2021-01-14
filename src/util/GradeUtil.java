package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Optimist
 */
public class GradeUtil {

    private static Connection connect;
    private static PreparedStatement statement;

    static {
        connect = DBHelper.getConnect();
    }

    private static String gradeSQL = "select distinct Student.Sno,Student.Sname,Course.Cno,Course.Cname,Csgrade.Grade,Ccredit " +
            "from Student,Course,Csgrade,classcourse " +
            "where Student.Sno=Csgrade.Sno and " +
            "Csgrade.Cno = Course.Cno and Student.Sclass = classcourse.CLno and " +
            "course.Cno = classcourse.Cno and Student.Sno = ? and " +
            "classcourse.Cyear=? and classcourse.Cterm=?;";

    private static String gradeSQLByClass =  "select distinct Student.Sno,Student.Sname,Course.Cno,Course.Cname,Csgrade.Grade,Ccredit " +
            "from Student,Course,Csgrade,classcourse " +
            "where Student.Sno=Csgrade.Sno and " +
            "Csgrade.Cno=Course.Cno and Student.Sclass = classcourse.CLno and " +
            "Student.Sclass=? and course.Cno = classcourse.Cno and " +
            "classcourse.Cyear=? and classcourse.Cterm=?;";

    private static String gradeChartSQL = "select Course.Cname,Csgrade.Grade,Course.Ccredit,Course.Cperiod " +
            "from Student,Csgrade,Course,classcourse " +
            "where Student.Sno=Csgrade.Sno and " +
            "Csgrade.Cno=Course.Cno and Course.Cno=classcourse.Cno and Student.Sclass=classcourse.CLno and " +
            "Student.Sno=? and classcourse.Cyear=? and classcourse.Cterm=?;";

    public static String[][] getGradeBySno(String Sno,String year,String term){
        String[][] result = new String[0][];
        ResultSet resultSet  = null;
        int count = 0;
        try{
            statement = connect.prepareStatement(gradeSQL);
            statement.setString(1,Sno);
            statement.setString(2,year);
            statement.setString(3,term);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                count ++;
            }
            result = new String[count][7];
            count = 0;
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result[count][0] = resultSet.getString(1);
                result[count][1] = resultSet.getString(2);
                result[count][2] = resultSet.getString(3);
                result[count][3] = resultSet.getString(4);
                result[count][4] = String.valueOf(resultSet.getDouble(5));
                result[count][5] = String.valueOf(resultSet.getDouble(6));
                count ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] getGradeToChart(String Sno,String year,String term){
        String[][] result = new String[0][];
        ResultSet resultSet  = null;
        PreparedStatement statement = null;
        int count = 0;
        try{
            connect = DBHelper.getConnect();
            statement = connect.prepareStatement(gradeChartSQL);
            statement.setString(1,Sno);
            statement.setString(2,year);
            statement.setString(3,term);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                count ++;
            }
            result = new String[count][4];
            count = 0;
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result[count][0] = resultSet.getString(1);
                result[count][1] = resultSet.getString(2);
                result[count][2] = resultSet.getString(3);
                result[count][3] = resultSet.getString(4);
                count ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] getGradeByClass(String Sclass,String cYear,String cTerm){
        String[][] result = new String[0][];
        ResultSet resultSet  = null;
        int count = 0;
        try{
            statement = connect.prepareStatement(gradeSQLByClass);
            statement.setString(1,Sclass);
            statement.setString(2,cYear);
            statement.setString(3,cTerm);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                count ++;
            }
            result = new String[count][7];
            count = 0;
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result[count][0] = resultSet.getString(1);
                result[count][1] = resultSet.getString(2);
                result[count][2] = resultSet.getString(3);
                result[count][3] = resultSet.getString(4);
                result[count][4] = String.valueOf(resultSet.getInt(5));
                result[count][5] = resultSet.getString(6);
                count ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
