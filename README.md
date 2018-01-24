# Infusion for the Java World

Things I miss in the Java World.

## Overview

- infusion-lambda: An OO approach of the lambda calculus that includes currying

### infusion-lambda


**Example**

```java
// infusion-lambda/src/test/java/FuncTest.java

Func4<String, Character, Boolean, Byte, String> f4 = (arg0, arg1, arg2, arg3) -> arg0 + arg1 + arg2 + arg3;

assertEquals("abtrue127", f4.apply("a", 'b', true, Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a", 'b', true).apply(Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a", 'b').apply(true, Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a", 'b').apply(true).apply(Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a").apply('b',true, Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a").apply('b', true).apply(Byte.MAX_VALUE));
assertEquals("abtrue127", f4.apply("a").apply('b').apply(true).apply(Byte.MAX_VALUE));

```