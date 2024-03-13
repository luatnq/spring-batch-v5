package com.ncs.osint.springbatch.enitity;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  private String id;
  private String description;
  private float value;
}
