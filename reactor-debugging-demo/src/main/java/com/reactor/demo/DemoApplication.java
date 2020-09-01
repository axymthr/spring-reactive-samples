package com.reactor.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Hooks.onOperatorDebug();
		ReactorDebugAgent.init();
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class DemoController {
	@GetMapping("/hello")
	public Mono<String> hello() {
		return Flux.just("Hello", "World")
				.single()
				.checkpoint("afterSingle")
				.subscribeOn(Schedulers.parallel());
	}
}
