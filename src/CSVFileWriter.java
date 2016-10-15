import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File writer for CSV data
 * 1 x-axis array and 2 y-axis arrays
 * 
 * @author Isaac Addis
 * @author Ronan Konishi
 * 
 * Modified by tedfoodlin
 * 
 */
public class CSVFileWriter {
	
	private static double m_maxIterations;
	private static ArrayList<Double>  m_xAxisArray;
	private static ArrayList<Double>  m_yAxisArray1;
	private static ArrayList<Double>  m_yAxisArray2;
	private static double m_finalValue;
	private static double m_dist;
	
	/**
	 * File writer constructor
	 * 
	 * @param maxIterations
	 * @param xAxisArray
	 * @param yAxisArray1
	 * @param yAxisArray2
	 * @param finalValue
	 * @param dist
	 * 
	 * For use with motion profiling:
	 * 	xAxisArray = time
	 *  yAxisArray1 = velocity
	 *  yAxisArray2 = distance
	 *  finalValue and dist for tolerance at the end
	 * 
	 */
	public CSVFileWriter(double maxIterations, ArrayList<Double> xAxisArray, ArrayList<Double> yAxisArray1, ArrayList<Double> yAxisArray2, double finalValue, double dist) {
		m_maxIterations = maxIterations;
		m_xAxisArray = xAxisArray;
		m_yAxisArray1 = yAxisArray1;
		m_yAxisArray2 = yAxisArray2;
		m_finalValue = finalValue;
		m_dist = dist;
	}
	
	public void writeToFile(){
		try {
			FileWriter writer = new FileWriter("MotionProfilingData.csv");
			
			//Headings
			writer.append("Time");
			writer.append(",");
			writer.append("Velocity");
			writer.append(",");
			writer.append("Distance");
			writer.append("\r");
			
			//Start for loop
			for(int j = 0; j <= m_maxIterations-1; j++){
				//Rows
				writer.append(String.valueOf(m_xAxisArray.get(j)));
				writer.append(",");
				writer.append(String.valueOf(m_yAxisArray1.get(j)));
				writer.append(",");
				writer.append(String.valueOf(m_yAxisArray2.get(j)));
				writer.append("\r");
			}
			
			writer.append(String.valueOf(m_finalValue));
			writer.append(",");
			writer.append(""+ 0);
			writer.append(",");
			writer.append(""+ m_dist);
			writer.append("\r");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
