/**
 *
 */
package sample;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hideki
 *
 */
@Data @AllArgsConstructor @SessionScoped
public class User implements Serializable {
  private String name;
  private int age;
  public User() {}
}
