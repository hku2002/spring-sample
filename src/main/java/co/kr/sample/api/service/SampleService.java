package co.kr.sample.api.service;

import co.kr.sample.api.domain.entity.Sample;
import co.kr.sample.api.domain.repository.SampleRepository;
import co.kr.sample.api.dto.SampleResponseDto;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public SampleResponseDto getSample(Long id) {
        Sample sample = sampleRepository.findById(id).orElseThrow();
        return new SampleResponseDto(sample.getId(), sample.getName());
    }

}
