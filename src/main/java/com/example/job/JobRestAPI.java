package com.example.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobRestAPI {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/{idOrService}")
    public ResponseEntity<Job> getJobByIdOrService(@PathVariable String idOrService) {
        try {
            Integer id = Integer.parseInt(idOrService);
            Optional<Job> job = jobRepository.findByIdOrService(id, null);
            return job.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (NumberFormatException e) {
            Optional<Job> job = jobRepository.findByIdOrService(null, idOrService);
            return job.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    }


    @PutMapping("/{id}/etat")
    public ResponseEntity<String> updateJobEtat(@PathVariable Integer id, @RequestParam Boolean etat) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.setEtat(etat);
            jobRepository.save(job);
            return ResponseEntity.ok("L'état du poste a été mis à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
