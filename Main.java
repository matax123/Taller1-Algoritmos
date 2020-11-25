import java.util.Random;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

class Main {
      public static void main(String args[]) 
    { 
        //creando el archivo excel
        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("Hoja");
        Row filas[] = new Row[101];
        Cell celdas[][] = new Cell[101][101];
        for(int y=0;y<100;y++){
            filas[y] = hoja.createRow(y);
            for(int x=0;x<100;x++){
                celdas[x][y] = filas[y].createCell(x);
            }
        }
        celdas[0][0].setCellValue("Tamaño de repetición");

        String nombreArchivo = "Reporte.xls";
        try{
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            libro.write(archivo);
            archivo.close();
        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }

        int arr[] = new int[100];
        for(int i=0;i<100;i++){
            Random rand = new Random();
            arr[i] = rand.nextInt(100);
        }
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1);
  
        System.out.println("Arreglo ordenado:"); 
        ob.printArray(arr); 
    } 
}