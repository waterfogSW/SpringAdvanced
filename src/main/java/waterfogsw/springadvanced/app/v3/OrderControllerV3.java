package waterfogsw.springadvanced.app.v3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV1;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

  private final OrderServiceV3 orderService;
  private final LogTrace trace;

  @GetMapping("/v3/request")
  @ResponseStatus(HttpStatus.OK)
  public String request(String itemId) {
    TraceStatus status = null;

    try {
      status = trace.begin("OrderController.request()");
      orderService.orderItem(itemId);
      trace.end(status);
      return "ok";
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }
  }

}
