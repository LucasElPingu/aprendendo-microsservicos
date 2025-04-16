package com.lucaselpingu.hrpayroll.config;

import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Flux;

@Configuration
public class AppConfig {

	// cria um componente a partir de uma chamada de metodo
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier.builder()
                .withBase(new ServiceInstanceListSupplier() {
                    @Override
                    public String getServiceId() {
                        return "hr-worker";
                    }

                    @Override
                    public Flux<List<ServiceInstance>> get() {
                        return Flux.just(List.of(
                                new DefaultServiceInstance("hr-worker-1", "hr-worker", "localhost", 8004, false),
                                new DefaultServiceInstance("hr-worker-2", "hr-worker", "localhost", 8005, false)
                        ));
                    }
                })
                .build(context);
    }
}
