package com.ncs.osint.springbatch.writer;

import com.ncs.osint.springbatch.enitity.BankAccount;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

@Configuration
public class ClientInvalidWriter {
  @StepScope
  @Bean
  public FlatFileItemWriter<BankAccount> clientInvalidFileWriter(
        @Value("file:${spring-batch-learning.output-folder}invalidClients.txt") Resource output
  ) {
    return new FlatFileItemWriterBuilder<BankAccount>()
          .name("clientInvalidFileWriter")
          .resource((WritableResource) output)
          .delimited()
          .names("clientId")
          .build();
  }
}
