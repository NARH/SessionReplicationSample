/**
 *
 */
package sample;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hideki
 *
 */
@Data @NoArgsConstructor @AllArgsConstructor @SessionScoped
public class User implements Serializable {
  private String name;
  private int age;
  private Address address;
}
