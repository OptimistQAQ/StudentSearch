package util;

import bean.OrderDAO;

import javax.swing.*;
import java.awt.*;
import java.io.*;

//文件工具类
public class FileUtil {

    //表格导出文件
    public static void tableToFile(JFrame main, JTable table) {
        FileDialog fd = new FileDialog(main, "保存成绩到本地", FileDialog.SAVE);
        fd.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/pictures/file.png"));
        fd.setFont(new Font("楷体", Font.BOLD, 18));
        fd.setLocation(800, 500);
        fd.setVisible(true);
        String stringFile = fd.getDirectory() + fd.getFile() + ".xls";
        OrderDAO oDao = new OrderDAO();
        oDao.exportTable(table, new File(stringFile));
    }

}
