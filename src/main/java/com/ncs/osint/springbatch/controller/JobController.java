package com.ncs.osint.springbatch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class JobController {
  private final Job bankAccountGenerateJob;

  private final JobLauncher jobLauncher;

  @GetMapping("/load")
  public ResponseEntity<String> productLoad() {
    try {
      JobParameters parameters = new JobParametersBuilder().addLong("Start-At", System.currentTimeMillis())
            .toJobParameters();
      jobLauncher.run(bankAccountGenerateJob, parameters);
      return ResponseEntity.ok("job run");

    } catch (Exception e) {
      return new ResponseEntity<>("job error ", HttpStatus.EXPECTATION_FAILED);
    }
  }
}
