package nelsonssoares.ecommercegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class EcommerceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceGatewayApplication.class, args);
	}

}
