package com.ncs.osint.springbatch.job.banking;

import com.ncs.osint.springbatch.enitity.BankAccount;
import com.ncs.osint.springbatch.enitity.Client;
import org.springframework.batch.item.ItemProcessor;

public class InvalidBankAccountProcessor implements ItemProcessor<Client, BankAccount> {
  @Override
  public BankAccount process(Client client) throws Exception {
    BankAccount bankAccount = new BankAccount();
    bankAccount.setClientId(client.getEmail());
    return bankAccount;
  }
}
