package Utilidades;

import Modelo.Alumnos;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                    ? cell.getLocalDateTimeCellValue().toLocalDate().toString()
                    : String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }

    
    public List<Alumnos> leerExcel(File excelFile) throws Exception {
        List<Alumnos> listaAlumnos = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFile); 
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); 

          
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
                Row row = sheet.getRow(i);
                if (row == null) continue;

                // Mapear la fila del Excel a un objeto Alumnos
                Alumnos a = new Alumnos();
                a.setCodigo(getCellValue(row.getCell(0)));
                a.setDni(getCellValue(row.getCell(1)));
                a.setTelefono(getCellValue(row.getCell(2)));
                a.setNombres(getCellValue(row.getCell(3)));
                a.setApellidos(getCellValue(row.getCell(4)));
                a.setCarrera(getCellValue(row.getCell(5)));
                a.setCiclo(getCellValue(row.getCell(6)));
                a.setEmail(getCellValue(row.getCell(7)));
                a.setPromedio(row.getCell(8).getNumericCellValue());
                a.setEstado(getCellValue(row.getCell(9)));
                a.setFecha_ingreso(getCellValue(row.getCell(10)));
                a.setId_sede((int) row.getCell(11).getNumericCellValue());

                listaAlumnos.add(a);
            }
            return listaAlumnos;

        } catch (Exception e) {
            throw new Exception("Error al leer el archivo Excel. Verifique el formato de las columnas.", e);
        }
    }
}
