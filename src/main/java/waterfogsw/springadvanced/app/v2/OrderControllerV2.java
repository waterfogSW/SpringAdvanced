package waterfogsw.springadvanced.app.v2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.HelloTraceV2;
import waterfogsw.springadvanced.trace.TraceStatus;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

  private final OrderServiceV2 orderService;
  private final HelloTraceV2 trace;

  @GetMapping("/v2/request")
  @ResponseStatus(HttpStatus.OK)
  public String request(String itemId) {
    TraceStatus status = null;

    try {
      status = trace.begin("OrderController.request()");
      orderService.orderItem(status.getTraceId(), itemId);
      trace.end(status);
      return "ok";
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }
  }

}
