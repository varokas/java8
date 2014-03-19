package com.varokas.java8.lambda;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

  private Calculator calculator;

  @Before
  public void setUp() throws Exception {
    calculator = new Calculator();
  }

  @Test
  public void testLambda() throws Exception {
    assertEquals(3, Calculator.ADD.op(1, 2));
    assertEquals(6, Calculator.SUBTRACT.op(10, 4));
    assertEquals(8, Calculator.MULTIPLY.op(4, 2));
    assertEquals(2, Calculator.DIVIDE.op(6, 3));
  }

  @Test
  public void testCalculate() throws Exception {
    Calculator.Operator mockOperator = Mockito.mock(Calculator.Operator.class);

    int a = RandomUtils.nextInt();
    int b = RandomUtils.nextInt();
    int result = RandomUtils.nextInt();

    Mockito.when(mockOperator.op(a, b)).thenReturn(result);

    assertEquals(result, calculator.calculate(a, b, mockOperator));
  }
}
