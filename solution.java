import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] sort;
    static int[] arra;
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
    
    static int ascend(int[] in, HashMap<Integer, Integer> map)
    {
        int count = 0;
        
        for(int i = 0 ; i < in.length; i++)
        {
            if(in[i] != sort[i])
            {
                count=count+1;
                int targ = (int)map.get(sort[i]);
                int aux = in[targ];                
                in[targ] = in[i];
                in[i] = aux;  
                map.put(in[targ], targ);                
            }
        }
        return count;
    }
    
    static int descend(int[] in, HashMap<Integer, Integer> map)
    {
        int count = 0;
        int num = in.length - 1;
        
        for(int i = 0 ; i < in.length; i++)
        {
            if(in[i] != sort[num-i])
            {
                count=count+1;
                int targ = (int)map.get(sort[num-i]);
                int aux = in[targ];                
                in[targ] = in[i];
                in[i] = aux;
                map.put(in[targ], targ);             
            }
        }    
        return count;
    }
    
    // Complete the lilysHomework function below.
    static int lilysHomework() {
                
        Arrays.sort(sort);
                
        int ascount = ascend(Arrays.copyOf(arra, arra.length), 
        new HashMap<Integer, Integer>(map));
        int descount = descend(Arrays.copyOf(arra, arra.length), 
        new HashMap<Integer, Integer>(map));        
        
        return ascount > descount ? descount : ascount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv 
        ("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        sort = new int[n];
        arra = new int[n];
        
        for(int i = 0 ; i < n; i++)
        {
            int val = scanner.nextInt(); 
            arra[i] = val;
            sort[i] = val;
            map.put(val, i);
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = lilysHomework();
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
