package API.Pojo.Response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class getOrders {


        private String id;
        private int bookId;
        private String customerName;
        private String createdBy;
        private int quantity;
        private String timestamp;

}
