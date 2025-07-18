package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getPatients(){
        List<PatientResponseDto> patients = patientService.getPatient();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }
}
