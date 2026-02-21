package com.example.taskmgmt.infrastructure.config;

import com.example.taskmgmt.infrastructure.adapter.out.client.user.invoker.ApiClient;
import com.example.taskmgmt.infrastructure.adapter.out.client.user.api.UserManagementApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Value("${services.user-mgmt.base-url:http://localhost:8081}")
    private String userMgmtUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UserManagementApi userManagementApi(RestTemplate restTemplate) {
        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath(userMgmtUrl);
        return new UserManagementApi(apiClient);
    }
}
