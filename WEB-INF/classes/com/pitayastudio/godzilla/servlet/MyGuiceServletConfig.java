package com.pitayastudio.godzilla.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import com.pitayastudio.godzilla.game.GameModule;

public class MyGuiceServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(
        new MyServletModule(),
        new GameModule());
  }

  private static class MyServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
      serve("/HelloWorld").with(HelloWorldServlet.class);
    }
  }
}