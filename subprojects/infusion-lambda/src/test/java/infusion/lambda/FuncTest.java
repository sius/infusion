package infusion.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import infusion.lambda.Func.Func2;
import infusion.lambda.Func.Func20;
import infusion.lambda.Func.Func3;
import infusion.lambda.Func.Func4;
import infusion.lambda.Func.Func5;

public class FuncTest {
	@Test
	public void curryingF2() {

		Func2<String, Character, String> f2 = (arg0, arg1) -> arg0 + arg1;
		assertEquals("ab", f2.apply("a").apply('b'));
		assertEquals("ab", f2.apply("a", 'b'));
	}
	@Test
	public void curryingF3() {

		Func3<String, Character, Boolean, String> f3 = (arg0, arg1, arg2) ->  arg0 +  arg1 + arg2;
		assertEquals("abtrue", f3.apply("a").apply('b').apply(true));
		assertEquals("abtrue", f3.apply("a").apply('b',true));
		assertEquals("abtrue", f3.apply("a", 'b').apply(true));
		assertEquals("abtrue", f3.apply("a", 'b', true));
	}
	@Test
	public void curryingF4() {
		Func4<String, Character, Boolean, Byte, String> f4 = new Func4<String, Character, Boolean, Byte, String>() {
			@Override public String apply(String arg0, Character arg1, Boolean arg2, Byte arg3) {
				return arg0 + arg1 + arg2 + arg3;
			}
		};
		assertEquals("abtrue127", f4.apply("a", 'b', true, Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a", 'b', true).apply(Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a", 'b').apply(true, Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a", 'b').apply(true).apply(Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a").apply('b',true, Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a").apply('b', true).apply(Byte.MAX_VALUE));
		assertEquals("abtrue127", f4.apply("a").apply('b').apply(true).apply(Byte.MAX_VALUE));
	}
	@Test
	public void curryingF5() {
		Func5<String, Character, Boolean, Byte, Short, String> f5 = new Func5<String, Character, Boolean, Byte, Short, String>() {
			@Override public String apply(String arg0, Character arg1, Boolean arg2, Byte arg3, Short arg4) {
				return arg0 +  arg1 + arg2 + arg3 + arg4;
			}
		};
		assertEquals("abtrue12732767", f5.apply("a", 'b', true, Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b', true, Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b', true).apply(Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b', true).apply(Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b').apply(true, Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b').apply(true, Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b').apply(true).apply(Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a", 'b').apply(true).apply(Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b', true, Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b', true, Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b', true).apply(Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b', true).apply(Byte.MAX_VALUE).apply(Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b').apply(true, Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b').apply(true).apply(Byte.MAX_VALUE, Short.MAX_VALUE));
		assertEquals("abtrue12732767", f5.apply("a").apply('b').apply(true).apply(Byte.MAX_VALUE).apply(Short.MAX_VALUE));
	}
	@Test
	public void curryingF20() {
		Func20<Character, Character, Character, Character, Character,
				Character, Character, Character, Character, Character,
				Character, Character, Character, Character, Character,
				Character, Character, Character, Character, Character, String> f20 =
					new Func20<Character, Character, Character, Character, Character,
								Character, Character, Character, Character, Character,
								Character, Character, Character, Character, Character,
								Character, Character, Character, Character, Character, String>() {

									@Override
									public String apply(
											Character arg0,
											Character arg1,
											Character arg2,
											Character arg3,
											Character arg4,
											Character arg5,
											Character arg6,
											Character arg7,
											Character arg8,
											Character arg9,
											Character arg10,
											Character arg11,
											Character arg12,
											Character arg13,
											Character arg14,
											Character arg15,
											Character arg16,
											Character arg17,
											Character arg18,
											Character arg19) {
										return "" + arg0 + arg1 + arg2 + arg3+ arg4 + arg5 + arg6 + arg7 + arg8+ arg9 + arg10 + arg11 + arg12 + arg13+ arg14 + arg15 + arg16 + arg17 + arg18 + arg19;
									}

		};
		String s = f20.apply('H').apply('e').apply('l').apply('l').apply('o').apply(' ').apply('W').apply('o').apply('r').apply('l').apply('d').apply('!').
			apply(' ').apply(' ').apply('H').apply('e').apply('l').apply('l').apply('o').apply('!');
		assertEquals("Hello World!  Hello!", s);
	}
}
