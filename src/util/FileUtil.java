package util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.*;

/**
 * 文件工具类
 * @author Optimist
 */
public class FileUtil {

    //表格导出文件
    public static void tableToFile(JFrame main, JTable table) {
        FileDialog fd = new FileDialog(main, "保存成绩到本地", FileDialog.SAVE);
        fd.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/pictures/file.png"));
        fd.setFont(new Font("楷体", Font.BOLD, 18));
        fd.setLocation(800, 500);
        fd.setVisible(true);
        String stringFile = fd.getDirectory() + fd.getFile() + ".xls";
        exportTable(table, new File(stringFile));
    }

    public static void exportTable(JTable table, File file) {
        TableModel model = table.getModel();
        //第一步 创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二步 在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet();
        //第三步 在sheet表中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //第四步 创建单元格，设置表头
        for (int i = 0; i < model.getColumnCount(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }
        //第五步 写入实体数据
        for (int i = 0; i < model.getRowCount(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                row1.createCell(j).setCellValue(model.getValueAt(i, j).toString());
            }
        }

        try {
            FileOutputStream stream = new FileOutputStream(file);
            workbook.write(stream);
            System.out.println("文件已保存到；" + file);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
