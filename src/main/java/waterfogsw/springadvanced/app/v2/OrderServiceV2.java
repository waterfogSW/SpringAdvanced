package waterfogsw.springadvanced.app.v2;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV2;
import waterfogsw.springadvanced.trace.TraceId;
import waterfogsw.springadvanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

  private final OrderRepositoryV2 orderRepository;
  private final HelloTraceV2 trace;

  public void orderItem(
      TraceId traceId,
      String itemId
  ) {
    TraceStatus status = null;

    try {
      status = trace.beginSync(traceId, "OrderService.request()");
      orderRepository.save(status.getTraceId(), itemId);
      trace.end(status);
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }
  }

}
