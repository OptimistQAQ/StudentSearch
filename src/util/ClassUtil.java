package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Optimist
 */
public class ClassUtil {

    private static Connection connect;
    private static String searchSQL = "select class.CLno from class;";

    private static String searchDeptSQL = "select distinct class.CLdept from class;";
    private static String searchMajorSQL = "select distinct class.CLmajor " +
            "from class " +
            "where class.CLdept=?;";
    private static String cMajorLnoSQL = "select class.CLno " +
            "from class " +
            "where class.CLmajor=?;";

    static {
        connect = DBHelper.getConnect();
    }


    private static String[] getDeptMajorClass(PreparedStatement statement) {
        int count = 0;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count++;
            }
            String[] CLnoList = new String[count];
            resultSet = statement.executeQuery();
            count = 0;
            while (resultSet.next()) {
                CLnoList[count] = resultSet.getString(1);
                count++;
            }
            return CLnoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[1];
    }

    //获取所有学院
    public static String[] getAllDept() {
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement(searchDeptSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] CLnoList = getDeptMajorClass(statement);
        return CLnoList;
    }

    //通过学院查找专业
    public static String[] getMajorByDept(String dept) {
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement(searchMajorSQL);
            statement.setString(1, dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] resultList = getDeptMajorClass(statement);
        return resultList;
    }

    //查专业班号
    public static String[] getClassByMajor(String Major) {
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement(cMajorLnoSQL);
            statement.setString(1, Major);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] resultList = getDeptMajorClass(statement);
        return resultList;
    }

    //获取所有班级
    public static String[] getAllClass() {
        try {
            PreparedStatement statement = connect.prepareStatement(searchSQL);
            String[] CLnoList = getAll(statement);
            return CLnoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[1];
    }

    private static String[] getAll(PreparedStatement statement){
        int index = 0;
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                index++;
            }
            String[] CLnoList = new String[index];
            resultSet = statement.executeQuery();
            index = 0;
            while (resultSet.next()) {
                CLnoList[index] = resultSet.getString(1);
                index++;
            }
            return CLnoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[1];
    }

}
