package ru.stqa.pft.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private String name;
  private String lastName;
  private String phone;
  private String email;
  private String allPhones;
  private String workPhone;
  private String mobilePhone;
  private String homePhone;
  private String allEmails;
  private String email2;
  private String email3;
  private String address;
  private int id=Integer.MAX_VALUE;
  private File photo;

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhonePhone) {
    this.mobilePhone = mobilePhonePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhonePhone) {
    this.workPhone = workPhonePhone;
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
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public File getPhoto() {
    return photo;
  }

  public  String getEmail2() {
    return email2;
  }

  public  String getEmail3() {
    return email3;
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
  public String getAllPhones() {

    return allPhones;
  }
  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {

    return email;
  }

  public int getId() {

    return id;
  }

  public String getAllEmails() {
    return allEmails;
  }
  public String getAddress() {
    return address;
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
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName, phone, email, id);
  }

}
