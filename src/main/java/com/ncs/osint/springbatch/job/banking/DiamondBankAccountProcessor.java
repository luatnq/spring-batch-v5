package com.ncs.osint.springbatch.job.banking;

import com.ncs.osint.springbatch.enitity.BankAccount;
import com.ncs.osint.springbatch.enitity.Client;
import com.ncs.osint.springbatch.enums.BankAccountType;
import org.springframework.batch.item.ItemProcessor;

public class DiamondBankAccountProcessor implements ItemProcessor<Client, BankAccount> {
  @Override
  public BankAccount process(Client client) throws Exception {
    BankAccount bankAccount = new BankAccount();
    bankAccount.setClientId(client.getEmail());
    bankAccount.setMaxLimit(5000.0f);
    bankAccount.setBankAccountType(BankAccountType.DIAMANTE);
    return bankAccount;
  }
}
