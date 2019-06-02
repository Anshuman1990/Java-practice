
import java.util.Random;

public class CSVeditor {
	private Random random = new Random();

//	public static void main(String[] args) throws IOException {
//		String path = "D://" + File.separator + "Dataset" + File.separator + "dataset.csv";
//		CSVeditor csv = new CSVeditor();
//		csv.updateCSV(path);
//	}
//
//	private void updateCSV(String path) throws IOException {
//
//		File inputFile = new File(path);
//		@SuppressWarnings("deprecation")
//		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
//		List<String[]> csvBody = reader.readAll();
//		for (int i = 1; i < csvBody.size(); i++) {
//			String StageID = csvBody.get(i)[3];
//			switch (StageID) {
//			case "lowerlevel":
//				int num_low_raised = random.nextInt((40-10)+1)+10;
//				int num_low_visit = random.nextInt((40-10)+1)+10;
//				int num_low_announcements = random.nextInt((40-10)+1)+10;
//				int num_low_discussion = random.nextInt((40-10)+1)+10;
//
//				csvBody.get(i)[9] = String.valueOf(num_low_raised);
//				csvBody.get(i)[10] = String.valueOf(num_low_visit);
//				csvBody.get(i)[11] = String.valueOf(num_low_announcements);
//				csvBody.get(i)[12] = String.valueOf(num_low_discussion);
//				break;
//			case "MiddleSchool":
//				int num_mid_raised = random.nextInt((60-40)+1)+40;
//				int num_mid_visit = random.nextInt((60-40)+1)+40;
//				int num_mid_announcements = random.nextInt((60-40)+1)+40;
//				int num_mid_discussion = random.nextInt((60-40)+1)+40;
//
//				csvBody.get(i)[9] = String.valueOf(num_mid_raised);
//				csvBody.get(i)[10] = String.valueOf(num_mid_visit);
//				csvBody.get(i)[11] = String.valueOf(num_mid_announcements);
//				csvBody.get(i)[12] = String.valueOf(num_mid_discussion);
//				break;
//			case "HighSchool":
//				int num_high_raised = random.nextInt((100-60)+1)+60;
//				int num_high_visit = random.nextInt((100-60)+1)+60;
//				int num_high_announcements = random.nextInt((100-60)+1)+60;
//				int num_high_discussion = random.nextInt((100-60)+1)+60;
//
//				csvBody.get(i)[9] = String.valueOf(num_high_raised);
//				csvBody.get(i)[10] = String.valueOf(num_high_visit);
//				csvBody.get(i)[11] = String.valueOf(num_high_announcements);
//				csvBody.get(i)[12] = String.valueOf(num_high_discussion);
//				break;
//			}
//
//		}
//		reader.close();
//		 @SuppressWarnings("deprecation")
//		CSVWriter writer = new CSVWriter(new FileWriter(path), ',');
//		 writer.writeAll(csvBody);
//		 writer.flush();
//		 writer.close();
//	}

}
