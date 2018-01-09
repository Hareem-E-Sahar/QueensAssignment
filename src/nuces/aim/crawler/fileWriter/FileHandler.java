package nuces.aim.crawler.fileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import nuces.aim.crawler.jira.Data;


public abstract class FileHandler {

	public static void generateCSV(Data data) /*List<TwitterData> twitterDataList*/ {
		try {
			// Write output.csv
			BufferedWriter outputWriter = null;
			outputWriter = new BufferedWriter(new FileWriter("output.csv"));
			
			{
				outputWriter.write("Type" + "," + "Assignee" + "," + "Created" + "," + "Description"+","+"Comments");		
				outputWriter.newLine();
				outputWriter.write(data.getType().replaceAll("\n", "").replaceAll(",", " ") + ","
						+ data.getAssignee().replaceAll("\n", "").replaceAll(",", " ") + ","
						+ data.getDateCreated().replaceAll("\n", "").replaceAll(",", " ")+ ","
						+ data.getDescription().replaceAll("\n", "").replaceAll(",", " ")+ ","
						+ data.getComments().replaceAll("\n", "").replaceAll(",", " "));
				outputWriter.newLine();
			}
			outputWriter.flush();
			outputWriter.close();
			
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}

}
