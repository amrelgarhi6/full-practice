package API.Endpoints;

import lombok.Getter;

@Getter
public enum BasePath {



    AUTHENTICATION_TOKEN("/api-clients/"),
    GET_BOOKS("/books"),
    POST_ORDER("/orders"),
    GET_ORDER("/orders/"),
    PATCH_ORDER("/orders/"),
    DELETE_ORDER("/orders/");






    public final String basePath;
    BasePath(String basePath) {
        this.basePath = basePath;
    }

}