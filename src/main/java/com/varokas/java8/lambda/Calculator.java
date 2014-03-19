package com.varokas.java8.lambda;

public class Calculator {
  public static Operator ADD = (a, b) -> a + b;
  public static Operator SUBTRACT = (a, b) -> a - b;
  public static Operator MULTIPLY = (a, b) -> a * b;
  public static Operator DIVIDE = (a, b) -> a / b;

  public int calculate(int a, int b, Operator op) {
    return op.op(a, b);
  }

  interface Operator {
    int op(int a, int b);
  }
}
