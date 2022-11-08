package waterfogsw.springadvanced.trace.strategy;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import waterfogsw.springadvanced.trace.strategy.template.TimeLogTemplate;

@Slf4j
public class TemplateV1Tests {

  @Test
  void templateV1() {
    TimeLogTemplate context1 = new TimeLogTemplate();
    context1.execute(() -> log.info("비스니스 로직 1 실행"));

    TimeLogTemplate context2 = new TimeLogTemplate();
    context2.execute(() -> log.info("비즈니스 로직 2 실행"));
  }

}
