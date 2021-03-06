package new_package.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  public int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  public String firstName;

  @Expose
  @Column(name = "lastname")
  public String lastName;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  public String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  public String homeTel;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  public String mobile;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  public String work;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  public String email;

  @Transient
  public String email2;

  @Transient
  public String email3;

  @Transient
  public String allPhones;

  @Transient
  public String allEmails;

  // @Column(name = "photo")
 // @Type(type = "text")
 @Transient
  private String photo;


  @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name = "address_in_groups",
         joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
 private Set<GroupData> groups = new HashSet<GroupData>();



  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public File getPhoto() {
    if (photo != null) {
      return new File(photo);
    } else {
      return null;
    }
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getAllEmails() {
    return allEmails;
  }

   public String getAllPhones() {
    return allPhones;
  }

  public String getHomePhone() {
    return homeTel;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
  }

  public int getId() {
    return id;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public Set<GroupData> withGroups(Set<GroupData> groups) {
    this.groups = groups;
    return groups;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

   public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }



  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAllPhones(String AllPhones) {
    this.allPhones = AllPhones;
    return this;
  }

  public ContactData withHomeTel(String homeTel) {
    this.homeTel = homeTel;
    return this;
  }
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
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
  public ContactData withAllEmails(String AllEmails) {
    this.allEmails = AllEmails;
    return this;
  }

   @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", FirstName='" + firstName + '\'' +
            ", LastName='" + lastName + '\'' +
            '}';
  }

}

