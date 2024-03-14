package com.ncs.osint.springbatch.step;


import com.ncs.osint.springbatch.enitity.BankAccount;
import com.ncs.osint.springbatch.enitity.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BankAccountGenerateStep {

  @Bean
  public Step bankAccountGenerateStep(
        ItemReader<Client> bankAccountGenerateReader,
        ItemProcessor<Client, BankAccount> bankAccountGenerateProcessor,
        ClassifierCompositeItemWriter<BankAccount> bankAccountClassifier,
        @Qualifier("clientInvalidFileWriter") FlatFileItemWriter<BankAccount> clientInvalidFileWriter,
        @Qualifier("bankAccountGenerateFileWriter") FlatFileItemWriter<BankAccount> bankAccountGenerateFileWriter,
        JobRepository jobRepository,
        PlatformTransactionManager transactionManager
  ) {
    return new StepBuilder("bankAccountGenerateStep", jobRepository)
          .<Client, BankAccount>chunk(1, transactionManager)
          .reader(bankAccountGenerateReader)
          .processor(bankAccountGenerateProcessor)
          .writer(bankAccountClassifier)
          .stream(clientInvalidFileWriter)
          .stream(bankAccountGenerateFileWriter)
          .build();
  }
}
