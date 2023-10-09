package com.gstlocation.helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodosService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private ObjectMapper objectMapper;

	private static final String baseURL = "https://services.gst.gov.in/services/api/search/gstp";

	public Flux<Todos> getAllTodos()  {
		System.out.println("Hai");

		WebClient client = WebClient.create("https://services.gst.gov.in/services/api/search/gstp");

		Mono<ClientResponse> result = client.get()
				.uri("https://services.gst.gov.in/services/api/search/gstp")
				.accept(MediaType.TEXT_PLAIN)
				.exchange();

		System.out.println("Web client inititated");
		Flux<Todos> todos = webClientBuilder.build().get().uri(baseURL).retrieve().bodyToFlux(Todos.class);
		System.out.println("Print ++"+todos);
		return  todos;
	}
}