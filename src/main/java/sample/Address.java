package sample;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Address implements Serializable {

  private String zipCode;
  private String address1;
  private String address2;
  private String address3;
}
