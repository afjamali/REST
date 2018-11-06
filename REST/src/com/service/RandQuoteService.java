package com.service;

import com.model.QuoteOfDay;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/quotes")
public class RandQuoteService {
  private static List<QuoteOfDay> quotes = null;
  private static int maxRands = 4;

  static {
    // allocate the array
	RandQuoteService.quotes = new ArrayList<QuoteOfDay>();
	
    RandQuoteService.quotes.add(new QuoteOfDay("Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill"));
	RandQuoteService.quotes.add(new QuoteOfDay("Every strike brings me closer to the next home run. –Babe Ruth"));
	RandQuoteService.quotes.add(new QuoteOfDay("Life is what happens to you while you’re busy making other plans. –John Lennon"));
	RandQuoteService.quotes.add(new QuoteOfDay("We become what we think about. –Earl Nightingale"));
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("/q")
  public QuoteOfDay readAll() {
    return RandQuoteService.quotes.get(new Random().nextInt(RandQuoteService.maxRands));
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/json")
  public QuoteOfDay readAsJSON(@PathParam("id") final int id) {
    return RandQuoteService.quotes.get(new Random().nextInt(RandQuoteService.maxRands));
  }

  @POST
  @Produces(MediaType.APPLICATION_XML)
  @Path("{quote}")
  public QuoteOfDay update(@PathParam("quote") final String quote) {
	RandQuoteService.quotes.add(new QuoteOfDay(quote));
	RandQuoteService.maxRands++;
    return RandQuoteService.quotes.get(RandQuoteService.maxRands-1);
  }
}
