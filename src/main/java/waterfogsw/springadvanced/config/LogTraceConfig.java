package waterfogsw.springadvanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import waterfogsw.springadvanced.trace.logtrace.LogTrace;
import waterfogsw.springadvanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new ThreadLocalLogTrace();
  }

}
