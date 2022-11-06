package waterfogsw.springadvanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV1;

@SpringBootTest
class HelloTraceV1Test {

  @Test
  void begin_end() {
    HelloTraceV1 trace = new HelloTraceV1();
    TraceStatus status = trace.begin("hello");
    trace.end(status);
  }

  @Test
  void begin_exception() {
    HelloTraceV1 trace = new HelloTraceV1();
    TraceStatus status = trace.begin("hello");
    trace.exception(status, new IllegalArgumentException());
  }

}
