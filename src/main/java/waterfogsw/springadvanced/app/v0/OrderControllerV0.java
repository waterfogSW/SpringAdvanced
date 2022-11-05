package waterfogsw.springadvanced.app.v0;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

  private final OrderServiceV0 orderService;

  @GetMapping("/v0/request")
  @ResponseStatus(HttpStatus.OK)
  public String request(String itemId) {
    orderService.orderItem(itemId);
    return "ok";
  }

}
