package com.mechanitis.demo.stockclient;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

class WebClientStockClientIntegrationTest {
    private final WebClient webClient = WebClient.builder().build();

    @Test
    void shouldRetrieveStockPricesFromTheService() {
        //given
        var webClientStockClient = new WebClientStockClient(webClient);

        //when
        Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");

        //then
        assertNotNull(prices);
        var fivePrices = prices.take(5);
        assertEquals(5, fivePrices.count().block());
        assertEquals("SYMBOL", fivePrices. blockFirst().getSymbol());
    }
}