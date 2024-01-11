package co.kr.sample.api.domain.repository;

import co.kr.sample.api.domain.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Jpa 를 활용하기 위해 JpaRepository 를 상속 받은 인터페이스가 필요합니다.
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
