package waterfogsw.springadvanced.trace.strategy.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ContextV1 {

  private final LogicStrategy logicStrategy;

  public void execute() {
    long startTime = System.currentTimeMillis();
    // 비즈니스 로직 실행
    logicStrategy.call();
    // 비즈니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }

}
