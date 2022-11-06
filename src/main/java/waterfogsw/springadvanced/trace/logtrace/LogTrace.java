package waterfogsw.springadvanced.trace.logtrace;

import waterfogsw.springadvanced.trace.TraceStatus;

public interface LogTrace {

  TraceStatus begin(String message);

  void end(TraceStatus status);

  void exception(
      TraceStatus status,
      Exception e
  );

}
