package waterfogsw.springadvanced.trace.strategy;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import waterfogsw.springadvanced.trace.strategy.strategy.ContextV2;

@Slf4j
public class ContextV2Tests {

  @Test
  void strategyV2() {
    ContextV2 context1 = new ContextV2();
    context1.execute(() -> log.info("비스니스 로직 1 실행"));

    ContextV2 context2 = new ContextV2();
    context2.execute(() -> log.info("비즈니스 로직 2 실행"));
  }

}
