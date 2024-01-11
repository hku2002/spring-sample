package co.kr.sample.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

// @Entity 를 넣어주면 jpa 가 알아서 DB와 매핑시켜줍니다.
@Entity
public class Sample {

    // id 필드가 식별자 역할을 하는 primary key 입니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public LocalDateTime createdAt;

    // 생성자 (자세한건 자바 공부)
    public Sample() {
    }

    // 생성자
    public Sample(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    // getter 입니다. Lombok 을 사용하면 아래 코드도 없앨 수 있습니다. 롬복 사용법: @Getter 를 class 나 필드 위에 적어준다.
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
