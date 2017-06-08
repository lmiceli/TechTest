package xyz.lmiceli.techtest.mosby.components;

import com.hannesdorfmann.mosby.mvp.MvpView;

// View interface
public interface HelloWorldView extends MvpView {

  // displays "Hello" greeting text in red text color
  void showHello(String greetingText);

  // displays "Goodbye" greeting text in blue text color
  void showGoodbye(String greetingText);
}