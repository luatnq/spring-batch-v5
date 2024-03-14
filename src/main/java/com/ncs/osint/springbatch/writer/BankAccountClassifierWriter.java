package com.ncs.osint.springbatch.writer;


import com.ncs.osint.springbatch.enitity.BankAccount;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class BankAccountClassifierWriter {

  @Bean
  public ClassifierCompositeItemWriter<BankAccount> bankAccountClassifier(
        @Qualifier("clientInvalidFileWriter") FlatFileItemWriter<BankAccount> clientInvalidFileWriter,
        CompositeItemWriter<BankAccount> bankAccountGenerateCompositeWriter
  ) {
    return new ClassifierCompositeItemWriterBuilder<BankAccount>()
          .classifier(classifier(clientInvalidFileWriter, bankAccountGenerateCompositeWriter))
          .build();
  }

  private Classifier<BankAccount, ItemWriter<? super BankAccount>> classifier(FlatFileItemWriter<BankAccount> clientInvalidFileWriter, CompositeItemWriter<BankAccount> bankAccountGenerateCompositeWriter) {
    return bankAccount -> {
      if (Objects.isNull(bankAccount.getBankAccountType())) {
        return clientInvalidFileWriter;
      } else {
        return bankAccountGenerateCompositeWriter;
      }
    };
  }
}
