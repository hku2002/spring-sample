package co.kr.sample.api.service;

import co.kr.sample.api.domain.entity.Sample;
import co.kr.sample.api.domain.repository.SampleRepository;
import co.kr.sample.api.dto.AddSampleRequestDto;
import co.kr.sample.api.dto.ChangeSampleRequestDto;
import co.kr.sample.api.dto.SampleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Transactional(readOnly = true) // -> 트랜젝션을 관리하는 어노테이션입니다. (그런것이 있다. 정도만 이해하시면 됩니다.)
    public SampleResponseDto getSample(Long id) {
        // 전달받은 id를 기준으로 데이터를 DB 에서 조회한다.
        Sample sample = sampleRepository.findById(id).orElseThrow();

        // 응답 구조가 정리되어 있는 SampleResponseDto 객체를 만들어(메모리에 올린다.) return
        return new SampleResponseDto(sample.getId(), sample.getName());
    }

    @Transactional
    public SampleResponseDto postSample(AddSampleRequestDto requestDto) {
        // 전달 받은 name 값으로 Sample 객체를 생성합니다.(데이터를 만들어 메모리에 올린다.)
        Sample sample = new Sample(requestDto.getName());

        // 만들어진 Sample 객체를 DB에 저장합니다.
        sampleRepository.save(sample);

        // 응답 구조가 정리되어 있는 SampleResponseDto 객체를 만들어(메모리에 올린다.) return
        return new SampleResponseDto(sample.getId(), sample.getName());
    }

    @Transactional
    public SampleResponseDto patchSample(ChangeSampleRequestDto requestDto) {
        // 전달받은 id를 기준으로 데이터를 DB 에서 조회한다.
        Sample sample = sampleRepository.findById(requestDto.getId()).orElseThrow();

        // 조회한 데이터의 이름값을 변경한다.
        sample.changeName(requestDto.getName());

        // 응답 구조가 정리되어 있는 SampleResponseDto 객체를 만들어(메모리에 올린다.) return
        return new SampleResponseDto(sample.getId(), sample.getName());
    }

    @Transactional
    public SampleResponseDto deleteSample(Long id) {
        // 전달받은 id를 기준으로 데이터를 DB 에서 삭제한다.
        sampleRepository.deleteById(id);

        // 응답 구조가 정리되어 있는 SampleResponseDto 객체를 만들어(메모리에 올린다.) return
        return new SampleResponseDto(id, "");
    }

}
