package co.kr.sample.api.controller;

import co.kr.sample.api.dto.AddSampleRequestDto;
import co.kr.sample.api.dto.ChangeSampleRequestDto;
import co.kr.sample.api.dto.SampleResponseDto;
import co.kr.sample.api.service.SampleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /* @GetMapping: Get 방식으로 요청을 받을 수 있도록 처리
       @PostMapping: :Post 방식으로 요청을 받을 수 있도록 처리
       @PatchMapping: Patch 방식으로 요청을 받을 수 있도록 처리
       @PutMapping: Put 방식으로 요청을 받을 수 있도록 처리
       @DeleteMapping: Delete 방식으로 요청을 받을 수 있도록 처리 */


    /* @PathVariable 어노테이션을 사용하면 url path에 있는 id를 가져올 수 있습니다. */
    @GetMapping("/sample/{id}")
    public SampleResponseDto getSample(@PathVariable Long id) {
        return sampleService.getSample(id);
    }

    /* Request 시 Body 필드에 대한 정의는 AddSampleRequestDto.java 파일을 보시면 됩니다.
       @RequestBody 어노테이션을 추가해야 body의 값을 가져올 수 있습니다.
       아래 메소드와 같이 처리를 하시면 Spring이 알아서 Body 값을 AddSampleRequestDto에 처리해줍니다. */
    @PostMapping("/sample")
    public SampleResponseDto postSample(@RequestBody AddSampleRequestDto requestDto) {
        return sampleService.postSample(requestDto);
    }

    @PatchMapping("/sample")
    public SampleResponseDto patchSample(@RequestBody ChangeSampleRequestDto requestDto) {
        return sampleService.patchSample(requestDto);
    }

    @DeleteMapping("/sample/{id}")
    public SampleResponseDto deleteSample(@PathVariable Long id) {
        return sampleService.deleteSample(id);
    }

}
