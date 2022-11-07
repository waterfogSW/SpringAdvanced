package waterfogsw.springadvanced.trace.template;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTests {

  @Test
  void templateMethodV0() {
    logic1();
    logic2();
  }

  @Test
  void templateMethodV1() {
    AbstractTemplate logicTemplate1 = new LogicTemplate1();
    AbstractTemplate logicTemplate2 = new LogicTemplate2();

    logicTemplate1.execute();
    logicTemplate2.execute();
  }

  @Test
  void templateMethodV2() {
    AbstractTemplate template1 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비즈니스 로직1 실행");
      }
    };

    template1.execute();
    log.info("클래스 이름 = {}", template1.getClass());

    AbstractTemplate template2 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비즈니스 로직2 실행");
      }
    };
    template2.execute();
    log.info("클래스 이름 = {}", template2.getClass());
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
