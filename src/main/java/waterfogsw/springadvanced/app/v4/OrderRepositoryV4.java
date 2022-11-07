package waterfogsw.springadvanced.app.v4;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;
import waterfogsw.springadvanced.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

  private final LogTrace trace;

  public void save(String itemId) {

    AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
      @Override
      protected Void call() {
        //저장 로직
        if (itemId.equals("ex")) {
          throw new IllegalArgumentException("예외 발생");
        }
        sleep(1000);
        return null;
      }
    };

    template.execute("OrderRepository.request()");
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
