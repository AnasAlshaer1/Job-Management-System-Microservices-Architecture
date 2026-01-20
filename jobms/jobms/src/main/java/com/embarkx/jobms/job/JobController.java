package com.embarkx.jobms.job;

import com.embarkx.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/jobs")
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll(){
        return  ResponseEntity.ok(jobService.findAll());

    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>( "Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> GetJobByID(@PathVariable Long id){
        JobDTO jobDTO =jobService.getJobByID(id);
        if(jobDTO !=null)
        return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted=jobService.deleteJobByID(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
   public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated=jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

   }

}
