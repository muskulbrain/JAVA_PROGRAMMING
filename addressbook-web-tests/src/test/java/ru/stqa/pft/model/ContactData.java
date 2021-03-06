package ru.stqa.pft.model;

import java.util.Objects;

public class ContactData {
  private final String name;
  private final String lastName;
  private final String phone;
  private final String email;
  private int id;

  public ContactData(int id, String name, String lastName, String phone, String email) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.id = id;
  }

  public ContactData(String name, String lastName, String phone, String email) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.id = Integer.MAX_VALUE;
  }

  public String getName() {

    return name;
  }

  public String getLastName() {

    return lastName;
  }

  public String getPhone() {

    return phone;
  }

  public String getEmail() {

    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {

    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName);
  }
}
