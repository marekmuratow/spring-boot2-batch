package pl.entito.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public Step recordsStep(StepBuilderFactory stepBuilderFactory, RecordReader recordReader,
			RecordProcessor<String> recordProcessor, RecordWriter recordWriter) {
		return stepBuilderFactory.get("recordsSetp").<String, String>chunk(10).reader(recordReader)
				.processor(recordProcessor).writer(recordWriter).build();
	}

	@Bean
	public Job recordsJob(JobBuilderFactory jobBuilderFactory, Step recordsStep) {
		return jobBuilderFactory.get("recordsJob").start(recordsStep).build();
	}

}
