package sample;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter @Named @Dependent @Slf4j
public class HelloBean {

  private User user;
  private String msg = "Hello";

  @Inject
  public HelloBean(User user, @Context HttpServletRequest request) {
    HttpSession session = request.getSession();
    Collections.list(session.getAttributeNames()).forEach(key -> log.info(key));
    this.user = (User) request.getSession().getAttribute("user");
    if(log.isInfoEnabled()) log.info("Constract executed {}", user);
  }

  @PostConstruct
  public void init() {
    if(log.isInfoEnabled()) log.info("Post Constract executed {}", user);
    if(null != user && null != user.getName()) msg = msg.concat(user.getName());
  }

  public String send() {
    msg = msg.concat(user.getName());
    return "output.xhtml";
  }
}
