package waterfogsw.springadvanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import waterfogsw.springadvanced.trace.logtrace.FieldLogTrace;
import waterfogsw.springadvanced.trace.logtrace.LogTrace;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new FieldLogTrace();
  }
}
