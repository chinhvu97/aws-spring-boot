package co.jp.hotel.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogEnvConfig implements ApplicationListener<ContextRefreshedEvent> {
  @Autowired
  private Environment env;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("{}:{}", "SERVER_HOST", env.getProperty("SERVER_HOST"));
  }
}
