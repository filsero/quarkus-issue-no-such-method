package com.example.nosuchmethodexception;

import java.io.IOException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import lombok.extern.java.Log;

/**
 * The type Jakarta rest workflow tracker.
 */
@Log
@Provider
@ApplicationScoped
public class JakartaRestInterceptor implements ReaderInterceptor, WriterInterceptor {

  @Override
  public void aroundWriteTo(WriterInterceptorContext context)
      throws IOException, WebApplicationException {
    log.info("Before writing " + context.getEntity());
    context.proceed();
    log.info("After writing " + context.getEntity());
  }

  @Override
  public Object aroundReadFrom(ReaderInterceptorContext context)
      throws IOException, WebApplicationException {
    log.info("Before reading " + context.getGenericType());
    Object entity = context.proceed();
    log.info("After reading " + entity);
    return entity;
  }
}
