package waterfogsw.springadvanced.trace.hellotrace;

import org.junit.jupiter.api.Test;

import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.hellotrace.HelloTraceV2;

class HelloTraceV2Test {

  @Test
  void begin_end() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatus status1 = trace.begin("hello");
    TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
    trace.end(status2);
    trace.end(status1);
  }

  @Test
  void begin_exception() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatus status1 = trace.begin("hello");
    TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
    trace.exception(status2, new IllegalArgumentException());
    trace.exception(status1, new IllegalArgumentException());

  }

}
