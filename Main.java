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
        Row filas[] = new Row[103];
        Cell celdas[][] = new Cell[103][102];
        for(int y=0;y<103;y++){
            filas[y] = hoja.createRow(y);
            for(int x=0;x<102;x++){
                celdas[y][x] = filas[y].createCell(x);
            }
        }
        celdas[0][1].setCellValue("Tamaño de repetición");
        celdas[1][0].setCellValue("N° de ejecución");
        for(int i=0;i<101;i++){//n° de ejecucion
            celdas[i+2][0].setCellValue(i);
        }
        for(int i=1;i<101;i++){//tamaño de repeticion
            celdas[1][i].setCellValue(i);
        }

        String nombreArchivo = "Reporte.xls";
        try{
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            libro.write(archivo);
            archivo.close();
        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }

        for(int i=0;i<100;i++){
            int arr[] = new int[100];
            for(int ii=0;ii<100;ii++){
                Random rand = new Random();
                arr[i] = rand.nextInt(100);
            }
            int n = arr.length; 

            QuickSort ob = new QuickSort(); 
            ob.sort(arr, 0, n-1);
            for(int ii=0;ii<100;ii++){
                celdas[i+2][ii+1].setCellValue(ob.repeticiones(ii));
                System.out.println("["+i+"] ["+ii+"] = "+ob.repeticiones(ii));
            }
        }
  
        System.out.println("Fin"); 
        //ob.printArray(arr); 
    } 
}