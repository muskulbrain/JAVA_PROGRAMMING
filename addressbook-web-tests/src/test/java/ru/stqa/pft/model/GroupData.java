package ru.stqa.pft.model;

import java.util.Objects;

public class GroupData {
  private int id;
  private final String name;
  private final String footer;
  private final String header;

  public GroupData(int id, String name, String footer, String header) {
    this.name = name;
    this.footer = footer;
    this.header = header;
    this.id = id;
  }

  public GroupData(String name, String footer, String header) {
    this.name = name;
    this.footer = footer;
    this.header = header;
    this.id = Integer.MAX_VALUE;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {

    return id;
  }

  public String getName() {

    return name;
  }

  public String getFooter() {

    return footer;
  }

  public String getHeader() {

    return header;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
