package waterfogsw.springadvanced.app.v4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;
import waterfogsw.springadvanced.trace.template.AbstractTemplate;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

  private final OrderServiceV4 orderService;
  private final LogTrace trace;

  @GetMapping("/v4/request")
  @ResponseStatus(HttpStatus.OK)
  public String request(String itemId) {
    AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
      @Override
      protected String call() {
        orderService.orderItem(itemId);
        return "ok";
      }
    };

    return template.execute("orderService.orderItem()");
  }

}
