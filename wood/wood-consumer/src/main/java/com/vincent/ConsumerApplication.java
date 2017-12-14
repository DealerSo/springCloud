package com.vincent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @SpringBootApplication注解由以下3个注解组合而成
 * 1、 @Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源。@Bean注解告诉Spring，
 * 	   一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean
 * 2、@EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置
 * 3、@ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller
 */
@SpringBootApplication
// 表示是一个Eureka客户端
@EnableDiscoveryClient
// 声明式服务调用
@EnableFeignClients(basePackages = "com.vincent.api")
// 解决容错问题
@EnableCircuitBreaker
public class ConsumerApplication {

	@Bean
	// 该注解能够让RestTemplate启用客户端负载均衡
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
