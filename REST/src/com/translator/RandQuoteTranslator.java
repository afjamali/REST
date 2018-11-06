package com.RandQuotetranslator;

import com.model.QuoteOfDay;
import com.owlike.genson.Genson;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

public class RandQuoteTranslator {
  public static String toJSON(final QuoteOfDay quote) {
    String json = "If you see this, there's a JSON problem.";
    try {
      Genson genson = new Genson();
      json = genson.serialize(quote);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return json;  }

  public static String toXML(final QuoteOfDay quote) {
    String xml = "If you see this, there's an XML problem.";
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      XMLEncoder encoder = new XMLEncoder(out);
      encoder.writeObject(quote);
      encoder.close();
      xml = out.toString();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return xml;  }
}
