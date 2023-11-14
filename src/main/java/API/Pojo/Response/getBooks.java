package API.Pojo.Response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class getBooks {


    private int id;
    private String  name;
    private String type;
    private boolean available;
}
