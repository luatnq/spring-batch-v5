package com.ncs.osint.springbatch.enitity;


import com.ncs.osint.springbatch.enums.BankAccountType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankAccount {

  @NotNull
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull
  private BankAccountType bankAccountType;
  @NotNull
  private float maxLimit;
  @NotBlank
  private String clientId;
}
