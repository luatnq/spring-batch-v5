package com.ncs.osint.springbatch.job.banking;

import com.ncs.osint.springbatch.enitity.BankAccount;
import com.ncs.osint.springbatch.enitity.Client;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountGenerateProcessorConfig {

  @Bean
  public ItemProcessor<Client, BankAccount> bankAccountGenerateProcessor() {
    return new ClassifierCompositeItemProcessorBuilder<Client, BankAccount>()
          .classifier(new BankAccountGenerateClassifier())
          .build();
  }
}
