package waterfogsw.springadvanced.trace.strategy;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import waterfogsw.springadvanced.trace.strategy.strategy.ContextV1;
import waterfogsw.springadvanced.trace.strategy.strategy.ContextV2;
import waterfogsw.springadvanced.trace.strategy.strategy.LogicStrategy1;
import waterfogsw.springadvanced.trace.strategy.strategy.LogicStrategy2;

@Slf4j
public class ContextV1Tests {


  @Test
  void strategyV0() {
    logic1();
    logic2();
  }

  @Test
  void strategyV1() {
    ContextV1 context1 = new ContextV1(new LogicStrategy1());
    context1.execute();
    ContextV1 context2 = new ContextV1(new LogicStrategy2());
    context2.execute();
  }

  @Test
  void strategyV2() {
    ContextV1 context1 = new ContextV1(() -> log.info("비스니스 로직 1 실행"));
    context1.execute();

    ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직 2 실행"));
    context2.execute();
  }

  @Test
  void strategyV3() {
    ContextV2 context1 = new ContextV2();
    context1.execute(() -> log.info("비스니스 로직 1 실행"));

    ContextV2 context2 = new ContextV2();
    context2.execute(() -> log.info("비즈니스 로직 2 실행"));
  }


  private void logic1() {
    long startTime = System.currentTimeMillis();
    // 비즈니스 로직 실행
    log.info("비즈니스 로직1 실행");
    // 비즈니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }

  private void logic2() {
    long startTime = System.currentTimeMillis();
    // 비즈니스 로직 실행
    log.info("비즈니스 로직2 실행");
    // 비즈니스 로직 종료
    long endTime = System.currentTimeMillis();

    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }

}
