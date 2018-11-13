package pl.entito.demo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WriteRepository {

	public void writeRecords(List<? extends String> items) {
		if (items != null)
			items.stream().forEach(System.out::println);
	}

}
