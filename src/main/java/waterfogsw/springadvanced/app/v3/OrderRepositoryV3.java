package waterfogsw.springadvanced.app.v3;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV1;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

  private final LogTrace trace;

  public void save(String itemId) {

    TraceStatus status = null;
    try {
      status = trace.begin("OrderRepository.request()");

      //저장 로직
      if (itemId.equals("ex")) {
        throw new IllegalArgumentException("예외 발생");
      }
      sleep(1000);

      trace.end(status);
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }

  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
