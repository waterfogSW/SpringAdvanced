package waterfogsw.springadvanced.app.v3;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV1;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

  private final OrderRepositoryV3 orderRepository;
  private final LogTrace trace;

  public void orderItem(String itemId) {
    TraceStatus status = null;

    try {
      status = trace.begin("OrderService.request()");
      orderRepository.save(itemId);
      trace.end(status);
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }
  }

}
