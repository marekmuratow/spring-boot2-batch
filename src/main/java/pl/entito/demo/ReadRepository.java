package pl.entito.demo;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ReadRepository {

	private Iterator<String> iterator;

	public String readNext() {
		return iterator.hasNext() ? iterator.next() : null;
	}

	@PostConstruct
	private void populateRecords() {
		iterator = IntStream.range(0, 100).mapToObj(i -> String.valueOf(i)).collect(Collectors.toList()).iterator();
	}
}
