package homeworkdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)

public class OrderPetDto {
    private long petId;
    private int quantity;
    private String status;
    private boolean complete;

}
