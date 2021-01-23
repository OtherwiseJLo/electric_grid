package electric_grid;
   
import electric_grid.api.DeviceData;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;

public class DeviceDataTest {
  private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
  private static double testCharging = 100.0;
  private static UUID testRegionId = UUID.fromString("84b4b0e8-348b-4a7b-aca6-1f2218cba88f");
  private static UUID testDeviceId = UUID.fromString("84b4b0e8-348b-4a7b-aca6-1f2218cba88f");

  @Test
  public void serializesToJSON() throws Exception {
    final DeviceData deviceData = new DeviceData(testCharging, testRegionId, testDeviceId);
    final String expected = MAPPER.writeValueAsString(
        MAPPER.readValue(fixture("fixtures/device_data.json"), DeviceData.class));
    assertThat(MAPPER.writeValueAsString(deviceData)).isEqualTo(expected);
  }

  @Test
  public void deserializesFromJson() throws Exception {
    final DeviceData deviceData = new DeviceData(testCharging, testRegionId, testDeviceId);
    final DeviceData expected = MAPPER.readValue(fixture("fixtures/device_data.json"), DeviceData.class);
    assertThat(expected).usingRecursiveComparison().isEqualTo(deviceData);
  }
}
