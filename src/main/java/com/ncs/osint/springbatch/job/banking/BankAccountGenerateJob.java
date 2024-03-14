package com.ncs.osint.springbatch.job.banking;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountGenerateJob {
  @Bean
  public Job bankAccountGenerateJob(
        JobRepository jobRepository,
        @Qualifier("bankAccountGenerateStep") Step bankAccountGenerateStep
  ) {
    return new JobBuilder("bankAccountGenerateJob", jobRepository)
          .incrementer(new RunIdIncrementer())
          .start(bankAccountGenerateStep)
          .build();
  }
}
