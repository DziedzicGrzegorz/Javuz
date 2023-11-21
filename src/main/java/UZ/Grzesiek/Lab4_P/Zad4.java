package UZ.Grzesiek.Lab4_P;

public class Zad4 extends Zad1 {
    public static void main(String[] args) {
        Zad4 test1 = new Zad4(30,99, 150);
        test1.bubbleSort();
        test1.displayArray();
        Zad4 test2 = new Zad4(30,99, 150);
        test2.quickSort();
        test2.displayArray();

    }
    Zad4(int size, int lowerBoundIncluded,int upperBoundIncluded){
        super(size, lowerBoundIncluded, upperBoundIncluded);
    }

    public void bubbleSort(){
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length-1; j++) {
                if(randomArray[j]>randomArray[j+1]){
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j+1];
                    randomArray[j+1] = temp;
                }
            }
        }
    }
    public void quickSort(){
        quickSort(randomArray, 0, randomArray.length-1);
    }
    private void quickSort(Integer[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = arr[(left+right)/2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index-1);
        quickSort(arr, index, right);
    }
    private int partition(Integer[] arr, int left, int right, int pivot){
        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }
            while(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }
        return left;
    }



}
