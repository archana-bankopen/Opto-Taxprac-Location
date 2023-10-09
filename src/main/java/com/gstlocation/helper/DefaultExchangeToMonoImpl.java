package com.gstlocation.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Slf4j
public class DefaultExchangeToMonoImpl<T> implements Function<ClientResponse, Mono<T>> {

	final Class<T> typeParamClass;

	@Override
	public Mono<T> apply(ClientResponse t) {
			log.info("Client Response status code :: {}",t.statusCode());
			if(t.statusCode() == HttpStatus.OK)
				return t.bodyToMono(typeParamClass);
			t.bodyToMono(Void.class);
			return t.createException().flatMap(Mono::error);
	}

	public DefaultExchangeToMonoImpl(Class<T> typeParamClass){
		this.typeParamClass = typeParamClass;
	}

}
