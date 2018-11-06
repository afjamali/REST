package com.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class QuoteOfDay
implements Serializable {
  private String quote;

  public QuoteOfDay() {}
  
  public QuoteOfDay(final String quote) {
    this.quote = quote;
  }

  public String getQuote() {
    return quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }
}
