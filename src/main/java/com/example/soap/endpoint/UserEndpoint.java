package com.example.soap.endpoint;

import com.example.soap.users.GetUserRequest;
import com.example.soap.users.GetUserResponse;
import com.example.soap.users.User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/users";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = new User();
        user.setId(request.getId());
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        response.setUser(user);
        return response;
    }
}