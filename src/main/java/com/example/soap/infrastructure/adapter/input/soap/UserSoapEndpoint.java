package com.example.soap.infrastructure.adapter.input.soap;

import com.example.soap.domain.entity.User;
import com.example.soap.domain.port.input.GetUserUseCase;
import com.example.soap.users.GetUserRequest;
import com.example.soap.users.GetUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class UserSoapEndpoint {
    
    private static final String NAMESPACE_URI = "http://example.com/soap/users";
    private final GetUserUseCase getUserUseCase;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        User domainUser = getUserUseCase.execute(request.getId());
        return mapToSoapResponse(domainUser);
    }

    private GetUserResponse mapToSoapResponse(User domainUser) {
        GetUserResponse response = new GetUserResponse();
        com.example.soap.users.User soapUser = new com.example.soap.users.User();
        soapUser.setId(domainUser.getId());
        soapUser.setName(domainUser.getName());
        soapUser.setEmail(domainUser.getEmail());
        response.setUser(soapUser);
        return response;
    }
}