import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {

    public Excel(ArrayList<String> BMW) throws IOException {

        Workbook wb = new HSSFWorkbook(); // создали книгу
        Sheet cars = wb.createSheet("BMW"); // создали вкладку и ее имя
        int rowNum= 0;
        Row row = cars.createRow(rowNum); // строка
            row.createCell(0).setCellValue("Марка и модель");
            row.createCell(1).setCellValue("Цена");
            row.createCell(2).setCellValue("Регион");
            row.createCell(3).setCellValue("Краткие характеристики");
            row.createCell(4).setCellValue("Год и пробег");
            row = cars.createRow(++rowNum); // устанавливаем номер следующей строки в excel файле и переходим на эту строку

        int j = 0; // счетчик количества ячеек в строке
        for (String s: BMW) {
            row.createCell(j).setCellValue(s); // записываем очередной элемент списка в Excel
            row = cars.createRow(++rowNum); // если строка закончилась переходим на следующую строку
            if (rowNum == 31) {
                j++;
                rowNum = 0;
                rowNum++;
            }
            rowNum++;
        }

        for (int i = 0; i < 5; i++) { cars.autoSizeColumn(i); } //выравнивание столбцов в таблице Excel по ширине

       try (FileOutputStream fos = new FileOutputStream("BMW.xls")) { // создали поток, для создания файла
           wb.write(fos);
       } catch (FileNotFoundException e) {
            e.printStackTrace();
       } catch (IOException e) {
            e.printStackTrace();
       }
       wb.close(); // закрываем файловый поток
    }
}
