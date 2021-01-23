package electric_grid.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jackson.JsonSnakeCase;

import java.util.UUID;

@JsonSnakeCase
public class DeviceData {
  private double charging;
  private UUID regionId;
  private UUID deviceId;


  public DeviceData() {
    // Jackson deserialization
  }

  public DeviceData(double charging, UUID regionId, UUID deviceId) {
    this.charging = charging;
    this.regionId = regionId;
    this.deviceId = deviceId;
  }

  @JsonProperty
  public double getCharging() {
    return charging;
  }

  @JsonProperty
  public void setCharging(double charging) {
    this.charging =  charging;
  }

  @JsonProperty
  public UUID getregionId() {
    return regionId;
  }

  @JsonProperty
  public void setregionId(UUID regionId) {
    this.regionId =  regionId;
  }

  @JsonProperty
  public UUID getDeviceId() {
    return deviceId;
  }

  @JsonProperty
  public void setDeviceId(UUID deviceId) {
    this.deviceId =  deviceId;
  }

}
