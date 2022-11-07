package waterfogsw.springadvanced.trace.template;

import lombok.RequiredArgsConstructor;
import waterfogsw.springadvanced.trace.TraceStatus;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

  private final LogTrace trace;

  public T execute(String message) {
    TraceStatus status = null;

    try {
      status = trace.begin(message);
      T result = call();
      trace.end(status);
      return result;
    } catch (RuntimeException ex) {
      trace.exception(status, ex);
      throw ex;
    }
  }

  protected abstract T call();

}
