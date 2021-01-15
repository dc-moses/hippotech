package com.hippotech.approval;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ApprovalRequest {
    private @Id
    @GeneratedValue
    Long id;
    private String propertyPostCode;
    private int propertyValue;
    private int amountToBorrow;
    private String about;
    private String firstName;
    private String lastName;
    private String nationalInsuranceNumber;
    private String country;
    private String streetAddress;
    private String city;
    private String postCode;
    private Boolean approvalNotifications;
    private Boolean changeNotifications;
    private Boolean offerNotifications;
    private String pushNotifications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyPostCode() {
        return propertyPostCode;
    }

    public void setPropertyPostCode(String propertyPostCode) {
        this.propertyPostCode = propertyPostCode;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }

    public int getAmountToBorrow() {
        return amountToBorrow;
    }

    public void setAmountToBorrow(int amountToBorrow) {
        this.amountToBorrow = amountToBorrow;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getApprovalNotifications() {
        return approvalNotifications;
    }

    public void setApprovalNotifications(Boolean approvalNotifications) {
        this.approvalNotifications = approvalNotifications;
    }

    public Boolean getChangeNotifications() {
        return changeNotifications;
    }

    public void setChangeNotifications(Boolean changeNotifications) {
        this.changeNotifications = changeNotifications;
    }

    public Boolean getOfferNotifications() {
        return offerNotifications;
    }

    public void setOfferNotifications(Boolean offerNotifications) {
        this.offerNotifications = offerNotifications;
    }

    public String getPushNotifications() {
        return pushNotifications;
    }

    public void setPushNotifications(String pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprovalRequest that = (ApprovalRequest) o;
        return propertyValue == that.propertyValue &&
                amountToBorrow == that.amountToBorrow &&
                Objects.equals(id, that.id) &&
                Objects.equals(propertyPostCode, that.propertyPostCode) &&
                Objects.equals(about, that.about) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nationalInsuranceNumber, that.nationalInsuranceNumber) &&
                Objects.equals(country, that.country) &&
                Objects.equals(streetAddress, that.streetAddress) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(approvalNotifications, that.approvalNotifications) &&
                Objects.equals(changeNotifications, that.changeNotifications) &&
                Objects.equals(offerNotifications, that.offerNotifications) &&
                Objects.equals(pushNotifications, that.pushNotifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyPostCode, propertyValue, amountToBorrow, about, firstName, lastName, nationalInsuranceNumber, country, streetAddress, city, postCode, approvalNotifications, changeNotifications, offerNotifications, pushNotifications);
    }

    @Override
    public String toString() {
        return "ApprovalRequest{" +
                "id=" + id +
                ", propertyPostCode='" + propertyPostCode + '\'' +
                ", propertyValue=" + propertyValue +
                ", amountToBorrow=" + amountToBorrow +
                ", about='" + about + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\'' +
                ", country='" + country + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", approvalNotifications=" + approvalNotifications +
                ", changeNotifications=" + changeNotifications +
                ", offerNotifications=" + offerNotifications +
                ", pushNotifications='" + pushNotifications + '\'' +
                '}';
    }
}
