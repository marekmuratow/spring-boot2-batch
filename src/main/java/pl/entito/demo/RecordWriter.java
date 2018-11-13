package pl.entito.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordWriter implements ItemWriter<String> {

	private WriteRepository repo;

	@Autowired
	public RecordWriter(WriteRepository repo) {
		this.repo = repo;
	}

	@Override
	public void write(List<? extends String> items) throws Exception {
		repo.writeRecords(items);
	}

}
