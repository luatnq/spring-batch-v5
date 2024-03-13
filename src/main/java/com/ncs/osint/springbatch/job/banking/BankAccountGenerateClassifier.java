package com.ncs.osint.springbatch.job.banking;

import com.ncs.osint.springbatch.enitity.BankAccount;
import com.ncs.osint.springbatch.enitity.Client;
import com.ncs.osint.springbatch.enums.BankAccountType;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.EnumMap;
import java.util.Map;

public class BankAccountGenerateClassifier implements Classifier<Client, ItemProcessor<?, ? extends BankAccount>> {

  private static final Map<BankAccountType, ItemProcessor<Client, BankAccount>> processors = new EnumMap<>(BankAccountType.class);

  static {
    processors.put(BankAccountType.SILVER, new SilverBankAccountProcessor());
    processors.put(BankAccountType.GOLD, new GoldBankAccountProcessor());
    processors.put(BankAccountType.PLATINA, new PlatinumBankAccountProcessor());
    processors.put(BankAccountType.DIAMANTE, new DiamondBankAccountProcessor());
    processors.put(BankAccountType.INVALID, new InvalidBankAccountProcessor());
  }

  @Override
  public ItemProcessor<?, ? extends BankAccount> classify(Client client) {
    BankAccountType bankAccountType = BankAccountType.returnFromSalaryRange(client.getSalaryRange());
    return processors.get(bankAccountType);
  }
}
