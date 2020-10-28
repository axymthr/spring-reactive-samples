package com.mechanitis.demo.stockclient;

import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.io.IOException;
import java.time.Duration;

@Log4j2
public class RSocketStockClient implements StockClient {

    private RSocketRequester rSocketRequester;

    public RSocketStockClient(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @Override
    public Flux<StockPrice> pricesFor(String symbol) {
        return rSocketRequester.route("stockPrices")
                .data(symbol)
                .retrieveFlux(StockPrice.class)
                .retryWhen(Retry.backoff(5, Duration.ofSeconds(1)).maxBackoff(Duration.ofSeconds(20)))
                .doOnError(IOException.class, e -> log.error(e.getMessage()));
    }
}
