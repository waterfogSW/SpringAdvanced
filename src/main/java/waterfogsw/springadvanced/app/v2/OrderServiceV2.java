package waterfogsw.springadvanced.app.v2;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.HelloTraceV1;
import waterfogsw.springadvanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

  private final OrderRepositoryV2 orderRepository;
  private final HelloTraceV1 trace;

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
