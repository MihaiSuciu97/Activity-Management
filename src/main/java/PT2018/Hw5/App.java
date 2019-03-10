package PT2018.Hw5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import file.FileReader;
import models.MonitoredData;

public class App {
	public static void main(String[] args) throws ParseException {
		System.out.println("Started");

		// Create list
		ArrayList<MonitoredData> list = new ArrayList<MonitoredData>();
		list = FileReader.createList();
		// Print in file
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("output.txt"));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.setOut(out);
		// EX.1
		Date date1 = list.get(0).getStartTime();
		Date date2 = list.get(list.size() - 1).getStartTime();
		// System.out.println(date1 +" "+date2);
		int days = MonitoredData.daysBetween(date1, date2);
		System.out.println("How many days of monitored data appears in the log: " + days);
		// EX.2
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting()));
		// System.out.println(map);
		map.entrySet().forEach(e -> {
			System.out.println(e.getKey().toString() + " : " + e.getValue());
		});

	}
}
