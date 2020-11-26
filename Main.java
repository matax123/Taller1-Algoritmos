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
        Row filas[] = new Row[105];
        Cell celdas[][] = new Cell[105][102];
        for(int y=0;y<105;y++){
            filas[y] = hoja.createRow(y);
            for(int x=0;x<102;x++){
                celdas[y][x] = filas[y].createCell(x);
            }
        }
        celdas[0][1].setCellValue("Tamaño de repetición");
        celdas[1][0].setCellValue("N° de ejecución");
        for(int i=1;i<101;i++){//n° de ejecucion
            celdas[i+2][0].setCellValue(i);
        }
        celdas[103][0].setCellValue("Total:");
        celdas[104][0].setCellValue("Promedio:");
        for(int i=0;i<101;i++){//tamaño de repeticion
            celdas[1][i].setCellValue(i);
        }

        for(int i=0;i<100;i++){
            int arr[] = new int[100];
            for(int ii=0;ii<100;ii++){
                Random rand = new Random();
                arr[ii] = rand.nextInt(100);
            }
            int n = arr.length; 

            QuickSort ob = new QuickSort(); 
            ob.sort(arr, 0, n-1);
            for(int ii=0;ii<101;ii++){
                celdas[i+2][ii+1].setCellValue(ob.particiones(ii));
                System.out.println("["+i+"] ["+ii+"] = "+ob.particiones(ii));
            }
        }
        double total[] = new double[100];
        double promedio[] = new double[101];
        for(int i=0;i<100;i++){
            for(int ii=0;ii<100;ii++){
                double valorASumar = Double.parseDouble(celdas[ii+2][i+1].toString());
                total[i] = total[i] + valorASumar;
            }
            System.out.println("total["+i+"] ="+total[i]);
            promedio[i] = total[i]/100;
        }

        for(int i=0;i<100;i++){
            celdas[103][i+1].setCellValue(total[i]);
            celdas[104][i+1].setCellValue(promedio[i]);
        }

        String nombreArchivo = "Reporte.xls";
        try{
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            libro.write(archivo);
            archivo.close();
        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }
  
        System.out.println("Fin"); 
        //ob.printArray(arr); 
    } 
}