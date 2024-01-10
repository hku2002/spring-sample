package co.kr.sample.api.controller;

import co.kr.sample.api.dto.SampleResponseDto;
import co.kr.sample.api.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample/{id}")
    public SampleResponseDto getSample(@PathVariable Long id) {
        return sampleService.getSample(id);
    }

}
