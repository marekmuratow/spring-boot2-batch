package pl.entito.demo;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RecordProcessor<I> implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return "Processed " + item;
	}

}
