package sustainabilityjavabaremetal;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.lang.Math;
import java.util.Arrays;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Handler implements RequestHandler<Map<String,String>, String>{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static int[] append2Array(int[] elements, int element)
    {
        int[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[elements.length] = element;

        return newArray;
    }
    private static int[] primes_up_to(int n) {
        int[] primes = {};
        for (int i = 2; i< n+1; i++){
            boolean isPrime = true;
            double sqrt_i = Math.sqrt(i);
            for (int p :primes) {
                if(p > sqrt_i) {
                    break;
                }
                if(i%p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime == true) {
                primes = append2Array(primes, i);
            }
        }
        return primes;
    }
     

  public static void main(String []args) {
    
  }
  
  @Override
  public String handleRequest(Map<String,String> event, Context context)
  {
    String response = new String("200 OK");
    int[] nums = primes_up_to(1000000);
    return response;
  }
}