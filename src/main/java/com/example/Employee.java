package com.example;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Document("employee")
public class Employee implements Serializable {

  @Id
  private String id;

  @Field("first_name")
  @NotBlank(message = "First Name cannot be blank ")
  @Length(min = 2, max = 20, message = "First Name should be in between 2 and 20 ")
  private String firstName;

  @Field("last_name")
  @NotBlank(message = "Last Name cannot be blank ")
  @Length(min = 2, max = 20, message = "Last Name should be in between 2 and 20 ")
  private String lastName;

  private String company_name;
  private String address;
  private String city;
  @Field("county")
  private String country;
  private String state;
  @Field("zip")
  private String salary;
  private String phone1;
  private String phone2;

  @NotBlank(message = "Email is alias for user name and thus cannot be blank ")
  private String email;
  private String web;

//    public Employee(EmployeeDTO employee) {
//        this.first_name = employee.getFirst_name();
//        this.last_name = employee.getLast_name();
//        this.company_name = employee.getCompany_name();
//        this.address = employee.getAddress();
//        this.city = employee.getCity();
//        this.country = employee.getCountry();
//        this.state = employee.getState();
//        this.zip = employee.getZip();
//        this.phone1 = employee.getPhone1();
//        this.phone2 = employee.getPhone1();
//        this.email = employee.getUser_name();
//        this.web = employee.getWeb();
//    }

//    public Employee(){
//
//    }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }
}