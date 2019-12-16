package ru.epam.javacore.homework_6_repos_and_services.carrier.domain;


import ru.epam.javacore.homework_6_repos_and_services.common.domain.BaseEntity;
import ru.epam.javacore.homework_6_repos_and_services.transportation.domain.Transportation;

public class Carrier extends BaseEntity {

  private String name;
  private String address;
  private CarrierType carrierType;
  private Transportation[] transportations;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CarrierType getCarrierType() {
    return carrierType;
  }

  public void setCarrierType(CarrierType carrierType) {
    this.carrierType = carrierType;
  }

  public Transportation[] getTransportations() {
    return transportations;
  }

  public void setTransportations(Transportation[] transportations) {
    this.transportations = transportations;
  }

  @Override
  public String toString() {
    return "Carrier{" +
            "id='" + id + '\'' +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", carrierType=" + carrierType +
            '}';
  }
}
