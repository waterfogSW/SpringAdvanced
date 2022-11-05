package waterfogsw.springadvanced.app.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.HelloTraceV1;
import waterfogsw.springadvanced.trace.TraceStatus;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

  private final OrderServiceV1 orderService;
  private final HelloTraceV1 trace;

  @GetMapping("/v1/request")
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
