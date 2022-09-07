package ru.stqa.pft.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int id=Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String name;

  @Column(name = "lastname")
  private String lastName;

  @Type(type = "text")
  @Column(name = "work")
  private String workPhone;

  @Type(type = "text")
  @Column(name = "mobile")
  private String mobilePhone;

  @Type(type = "text")
  @Column(name = "home")
  private String homePhone;

  @Transient
  private String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastName, email);
  }

  @Transient
  private String phone;

  @Type(type = "text")
  @Column(name = "email")
  private String email;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Type(type = "text")
  @Column(name = "email2")
  private String email2;

  @Type(type = "text")
  @Column(name = "email3")
  private String email3;

  @Type(type = "text")
  @Column(name = "address")
  private String address;

  @Type(type = "text")
  @Column(name = "photo")
  private String photo;

  @Transient
  private String footer;

  @Transient
  private String header;

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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

  public ContactData withHeader(String header) {
    this.header = header;
    return this;
  }

  public ContactData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public File getPhoto() {
    return new File(photo);
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
  public String getFooter() {

    return footer;
  }

  public String getHeader() {

    return header;
  }



  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

}
