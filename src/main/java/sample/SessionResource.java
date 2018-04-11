package sample;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

@Path("session") @Stateless  @Slf4j
public class SessionResource {

  @GET @Path("put/{name}") @Produces(MediaType.APPLICATION_JSON)
  public User put(@PathParam("name") String name, @QueryParam("age") int age, @Context HttpServletRequest request) {
    User user = new User(name, age);
    request.getSession().setAttribute("user", user);
    if(log.isInfoEnabled()) log.info("create user session : {}",user);
    return user;
  }

  @GET @Path("update/{name}") @Produces(MediaType.APPLICATION_JSON)
  public User update(@PathParam("name") String name, @QueryParam("age") int age, @Context HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    if(null == user) user = new User(name, age);
    user.setAge(age);
    if(log.isInfoEnabled()) log.info("update user session : {}",user);
    return user;
  }

  @GET @Path("get/{name}") @Produces(MediaType.APPLICATION_JSON)
  public User get(@PathParam("name") String name, @Context HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    if(log.isInfoEnabled()) log.info("get user session : {}",user);
    return user;
  }
}
