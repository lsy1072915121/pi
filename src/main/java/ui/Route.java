package ui;

import java.util.List;

public class Route {

  private String name;
  private List<double[]>path;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<double[]> getPath() {
    return path;
  }

  public void setPath(List<double[]> path) {
    this.path = path;
  }
}
