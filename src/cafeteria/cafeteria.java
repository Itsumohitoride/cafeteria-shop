package cafeteria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class cafeteria {
	
	public static Double[] age;
	public final static String SEPARATOR = " ";
	public final static Double ONEHUNDRED = 100.0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		String s = br.readLine();
		String[] listAges;
		String message = "";
		double promChanges = 0.0;
		
		if(!s.isEmpty()) {
			
			double numList = Double.parseDouble(s);
			
			int i = 0;
			
			while(i<numList) {
				
				promChanges = 0.0;
				message = "";
				
				String ages = br.readLine();
				
				if(!ages.isEmpty()) {		
					
					listAges = ages.split(SEPARATOR);
					age = new Double[listAges.length];
					
					for (int j = 0; j < listAges.length; j++) {
						double ageOneByOne = Double.parseDouble(listAges[j]);
						
						age[j] = ageOneByOne;
					}
					promChanges = bubbleSort();
				}
				
				for (int j = 0; j < age.length; j++) {
					if(j == age.length-1) {
						message += age[j]+"\n";
					}
					else if(j != age.length-1) {
						message += age[j]+" ";
					}
				}
				
				promChanges = promChanges*ONEHUNDRED;
				
				promChanges = (int)promChanges;
				
				promChanges = promChanges/ONEHUNDRED;
				
				bw.write(promChanges+"-"+message);
				i++;
			}
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static double bubbleSort() {
		
		double changes = 0;
		double promChanges = 0;
		double cont = 0;
		int i = 1;
		
		while( i < age.length){

			for(int j = 0; j<age.length-i; j++) {
				if(age[j] > age[j+1]) {

					double temp = age[j];

					age[j] = age[j+1];
					age[j+1] = temp;
					changes++;			
				}
			}	

			i++;
			cont++;
		}
		
		promChanges = (changes/cont);
		return promChanges;
	}

}
