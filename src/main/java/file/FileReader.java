package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Stream;

import models.MonitoredData;

public class FileReader {
	static MonitoredData aux = new MonitoredData();
	static String fileName = "D:/Stuff/Faculta/PT/eclipse-workspace/Hw5/Activities.txt";
	static ArrayList<MonitoredData> list = new ArrayList<MonitoredData>();

	public static ArrayList<MonitoredData> createList() {

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(a -> {
				try {
					aux = new MonitoredData(a.split("\t\t")[0], a.split("\t\t")[1], a.split("\t\t")[2]);
					list.add(aux);
					// System.out.println(aux.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
