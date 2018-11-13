package pl.entito.demo;


import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordReader implements ItemReader<String> {

	ReadRepository repo;

	@Autowired
	public RecordReader(ReadRepository repo) {
		this.repo = repo;
	}

	@Override
	public String read() {
		return repo.readNext();
	}

}
