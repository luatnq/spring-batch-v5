package com.ncs.osint.springbatch.enums;

public enum BankAccountType {
  SILVER,
  GOLD,
  PLATINA,
  DIAMANTE,
  INVALID;

  public static BankAccountType returnFromSalaryRange(Double salaryRange) {
    if (salaryRange == null) {
      return INVALID;
    } else if (salaryRange <= 3000) {
      return SILVER;
    } else if (salaryRange >= 3001 && salaryRange <= 5000) {
      return GOLD;
    } else if (salaryRange >= 5000 && salaryRange <= 10000) {
      return PLATINA;
    } else {
      return DIAMANTE;
    }
  }
}
