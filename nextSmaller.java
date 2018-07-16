import java.util.Arrays;

public class Kata
{
  public static long nextSmaller(long n){
    long l=0;
    int[] myArray;
    int mark = 0;
    int[] reMain;
    int[] sortIt; 
    int[] combine;
    int element;
    long finalNumber=0;
    int candidate;
    System.out.println("plese print bignumber in: " + n);
    
    String numberToString = Long.toString(n);
      
    System.out.println("this is then the string: " + numberToString);
      
    int sizeOfString = numberToString.length();
    myArray = new int[sizeOfString]; 

      // this step is to turn the number into array.
    for (int i = 0; i < sizeOfString; i++) {
          
          char myChar = numberToString.charAt(i);
          int result = Character.getNumericValue(myChar);
          myArray[i]= result;
    }

      System.out.println("this is my array:" +Arrays.toString(myArray));
      int size = myArray.length;

    for(int i= size-1; i>=0; i--){
       if((myArray.length == 1) || (myArray.length==2 && myArray[i] >= myArray[i-1])){
          l=-1;
          System.out.println("Excuting the first condtion");
          break;
       } else if(myArray[i]<myArray[i-1]){
          System.out.println("I am inside of the offcial loop");
          mark=i;
          element = myArray[i-1];
          
          int tem = myArray[i];
          myArray[i]=myArray[i-1];
          myArray[i-1]=tem;
          
          int remainSize = mark;
          System.out.println(remainSize);
          int sortSize = size - remainSize;
          reMain= new int[remainSize];
          sortIt = new int[sortSize];
          System.out.println("before spliting arrays");
          
          for(int x = 0; x < remainSize ; x++){
              reMain[x]=myArray[x];
          }
          
          System.out.println("What remain: " +Arrays.toString(reMain));
    
          for(int y= 0; y < sortSize; y++ ){
              sortIt[y] = myArray[mark+y];
          }

          sortingThem(sortIt);
          System.out.println("First sorting: " +Arrays.toString(sortIt));
          System.out.println("my element: " + element);
//           if (element <= sortIt[sortIt.length-1]){
//             l =-1;
//             break;
//           }
          
          for(int q=0; q<sortIt.length; q++){
              if (sortIt[q]<element){
                  int temp = sortIt[q];
                  System.out.println("plsease print here ; ");
                  System.out.println("print this shit " + temp);
                  sortIt[q]= reMain[remainSize-1];
                  reMain[remainSize-1]=temp;
                  break;
              } 
          }
          
          sortingThem(sortIt);
          
          
          int aLen = reMain.length;
          int bLen = sortIt.length;
          combine = new int[aLen + bLen];
       

          System.arraycopy(reMain, 0, combine, 0, aLen);
          System.arraycopy(sortIt, 0, combine, aLen, bLen);
          
          if (combine[0]==0){
              l=-1;
              break;
          }
      
          System.out.println("this is my final: " +Arrays.toString(combine));

//           for (int y =0; y < combine.length; y++){
//              int x=combine.length-1-y;
//              System.out.println("this is the x :"+x);
//              System.out.println("this is my combine[i]: " +combine[y]);
//              finalNumber= finalNumber + combine[y]* (int)Math.pow(10, x);
//              System.out.println("final NUMBER processing: " +finalNumber);
//          } 
            StringBuilder builder = new StringBuilder();
              for (int w =0; w<combine.length; w++){
                builder.append(combine[w]);
              }
              
            finalNumber= Long.parseLong(builder.toString());
            System.out.println("Give me my number: " +finalNumber);
            System.out.println("This is the input n: "+n);
            System.out.println("Please print the length of combine: "+combine.length);
            if(finalNumber > n){
                l = -1; 
                break; 
            }
    
          System.out.println("this is my final NUMBER: " +finalNumber);
    
          l = Long.valueOf(finalNumber);
          
          
          System.out.println("this is my long: "+ l);
          System.out.println("  ");
    
          break;  
        }else if((i==1) &&(myArray[i]>=myArray[i-1])) {
            l= -1;
            break;
         }  
     } 
     
     return l;
  }
  public static int[] sortingThem(int[] array){
    // this is the method to return a decending array always. 
    int key ; 
    int size=array.length;
    for (int i=1; i<array.length; i++){
      key = array[i];
      int j = i -1; 
      while (j >= 0 && array[j]<key){
        array[j+1]= array[j];
        j = j-1;
      }
      array[j+1]=key ; 
     }
    return array; 
  }

}

