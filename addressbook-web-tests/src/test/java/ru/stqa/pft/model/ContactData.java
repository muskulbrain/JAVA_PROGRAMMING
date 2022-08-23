package ru.stqa.pft.model;

import java.util.Objects;

public class ContactData {
  private String name;
  private String lastName;
  private String phone;
  private  String email;

  private int id=Integer.MAX_VALUE;

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
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
