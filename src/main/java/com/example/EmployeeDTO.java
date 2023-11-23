package com.example;

public class EmployeeDTO {

  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String country;
  private String state;
  private String salary;
  private String phone1;
  private String phone2;
  private String email;
  private String web;
  private String DateTime;
  private String technology;
  private String filesChanged;

  public EmployeeDTO(Employee employee) {
    this.firstName = employee.getFirstName();
    this.lastName = employee.getLastName();
    this.companyName = employee.getCompany_name();
    this.address = employee.getAddress();
    this.city = employee.getCity();
    this.country = employee.getCountry();
    this.state = employee.getState();
    this.salary = employee.getSalary();
    this.phone1 = employee.getPhone1();
    this.phone2 = employee.getPhone1();
    this.email = employee.getEmail();
    this.web = employee.getWeb();

  }

  public EmployeeDTO(Attendance attendance) {
    this.DateTime = attendance.getDateTime();
    this.technology = attendance.getTechnology();
    this.email = attendance.getEmail();
    this.filesChanged = attendance.getFilesChanged();
  }

  public EmployeeDTO(){

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

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public String getDateTime() {
    return DateTime;
  }

  public void setDateTime(String dateTime) {
    DateTime = dateTime;
  }

  public String getTechnology() {
    return technology;
  }

  public void setTechnology(String technology) {
    this.technology = technology;
  }

  public String getFilesChanged() {
    return filesChanged;
  }

  public void setFilesChanged(String filesChanged) {
    this.filesChanged = filesChanged;
  }
}