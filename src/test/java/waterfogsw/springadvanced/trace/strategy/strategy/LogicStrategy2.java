package waterfogsw.springadvanced.trace.strategy.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogicStrategy2 implements LogicStrategy {

  @Override
  public void call() {
    log.info("비즈니스 로직1 실행");
  }

}
