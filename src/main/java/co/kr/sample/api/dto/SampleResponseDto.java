package co.kr.sample.api.dto;

public class SampleResponseDto {

    private final Long id;
    private final String name;

    public SampleResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
