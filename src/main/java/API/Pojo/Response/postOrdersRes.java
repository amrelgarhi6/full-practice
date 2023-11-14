package API.Pojo.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class postOrdersRes {

    private boolean created;
    private String orderId;
}
