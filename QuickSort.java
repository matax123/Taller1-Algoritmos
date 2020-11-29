// Java program for implementation of QuickSort 
class QuickSort 
{ 
    int particiones[] = new int[101];
    int mejorCaso = 0;
    int peorCaso = 0;
    int partition(int arr[], int low, int high) 
    {
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) 
    {
        particiones[high - low + 1]++;
        System.out.println("particiones["+(high - low + 1)+"] = "+particiones[high - low +1]);
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); //posicion del pivote
            
            if((high - low + 1)%2 == 0){ //si el largo es par
                if(((high - low + 1)/2) - 1 == pi|| ((high - low + 1)/2) - 1 + 1 == pi){
                    mejorCaso++;
                }
            }
            else{
              if((high - low + 1)/2 - 1 == pi){
                mejorCaso++;
              }
            }
            if((high - low + 1) != 2){
                if((high - low + 1) - 1 - 1 == pi){
                    peorCaso++;
                }
            }
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    /* A utility function to print array of size n */
    public void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) //arreglo final
            System.out.print(arr[i]+" "); 
        System.out.println();
    } 

    public int particiones(int posicion){
        return particiones[posicion];
    }
    public int mejorCaso(){
        return mejorCaso;
    }
    public int peorCaso(){
        return peorCaso;
    }
} 
/*This code is contributed by Rajat Mishra */