package waterfogsw.springadvanced.app.v2;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.HelloTraceV2;
import waterfogsw.springadvanced.trace.TraceId;
import waterfogsw.springadvanced.trace.TraceStatus;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

  private final HelloTraceV2 trace;

  public void save(
      TraceId traceId,
      String itemId
  ) {
    TraceStatus status = null;
    try {
      status = trace.beginSync(traceId, "OrderRepository.request()");

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
