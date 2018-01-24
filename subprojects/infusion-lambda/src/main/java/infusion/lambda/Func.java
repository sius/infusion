package infusion.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An OO approach of the lambda calculus that includes currying
 */
public interface Func {

	/** () -&gt; b */
	@FunctionalInterface public interface Func0<B> {
		B apply() ;
	}
	/** (a0) -&gt; b */
	@FunctionalInterface public interface Func1<A0, B> extends Function<A0, B> {
		default public Func1<A0, B> andThen(Func1<B, B> next) {
			return (A0 arg0) -> next.apply(this.apply(arg0));
		}
		default public Func1<A0, B> compose(Func1<A0, A0> next) {
			return (A0 arg0) -> this.apply(next.apply(arg0));
		}
		default public Func1<A0, B> apply() { return this; }
		B apply(A0 arg0);
		
	}
	/** (a0, a1) -&gt; b */
	@FunctionalInterface public interface Func2<A0, A1, B> extends BiFunction<A0, A1, B> {
		default public Func2<A0, A1, B> apply() { return this; }
		default public Func1<A1, B> apply(final A0 arg0) {
			return (arg1) -> this.apply(arg0, arg1); 
		}
		B apply(A0 arg0, A1 arg1);
	}
	/** (a0, a1, a2) -&gt; b */
	@FunctionalInterface public interface Func3<A0, A1, A2, B> {
		default public Func3<A0, A1, A2, B> apply() { return this; }
		default public Func2<A1, A2, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2) -> this.apply(arg0, arg1, arg2);
		}
		default public Func1<A2, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2) ->  this.apply(arg0, arg1, arg2);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2);
	}
	/** (a0, a1, a2, a3) -&gt; b */
	@FunctionalInterface public interface Func4<A0, A1, A2, A3, B> {
		default public Func4<A0, A1, A2, A3, B> apply() { return this; }
		default public Func3<A1, A2, A3, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3) -> this.apply(arg0, arg1, arg2, arg3);
		}
		default public Func2<A2, A3, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3) -> this.apply(arg0, arg1, arg2, arg3);
		}
		default public Func1<A3, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3) -> this.apply(arg0, arg1, arg2, arg3);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3);
	}
	/** (a0, a1, a2, a3, a4) -&gt; b */
	@FunctionalInterface public interface Func5<A0, A1, A2, A3, A4, B> {
		default public Func5<A0, A1, A2, A3, A4, B> apply() { return this; }
		default public Func4<A1, A2, A3, A4, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4) -> this.apply(arg0, arg1, arg2, arg3, arg4);
		}
		default public Func3<A2, A3, A4, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4) -> this.apply(arg0, arg1, arg2, arg3, arg4);
		}
		default public Func2<A3, A4, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4) -> this.apply(arg0, arg1, arg2, arg3, arg4);
		}
		default public Func1<A4, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4) -> this.apply(arg0, arg1, arg2, arg3, arg4);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4);
	}
	/** (a0, a1, a2, a3, a4, a5) -&gt; b */
	@FunctionalInterface public interface Func6<A0, A1, A2, A3, A4, A5, B> {
		default public Func6<A0, A1, A2, A3, A4, A5, B> apply() { return this; }
		default public Func5<A1, A2, A3, A4, A5, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		default public Func4<A2, A3, A4, A5, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		default public Func3<A3, A4, A5, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		default public Func2<A4, A5, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		default public Func1<A5, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5);
	}
	/** (a0, a1, a2, a3, a4, a5, a6) -&gt; b */
	@FunctionalInterface public interface Func7<A0, A1, A2, A3, A4, A5, A6, B> {
		
		default public Func7<A0, A1, A2, A3, A4, A5, A6, B> apply() { return this; }
		default public Func6<A1, A2, A3, A4, A5, A6, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		default public Func5<A2, A3, A4, A5, A6, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		default public Func4<A3, A4, A5, A6, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		default public Func3<A4, A5, A6, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		default public Func2<A5, A6, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		default public Func1<A6, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7) -&gt; b */
	@FunctionalInterface public interface Func8<A0, A1, A2, A3, A4, A5, A6, A7, B> {
		default public Func8<A0, A1, A2, A3, A4, A5, A6, A7, B> apply() { return this; }
		default public Func7<A1, A2, A3, A4, A5, A6, A7, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		default public Func6<A2, A3, A4, A5, A6, A7, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		default public Func5<A3, A4, A5, A6, A7, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		default public Func4<A4, A5, A6, A7, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		default public Func3<A5, A6, A7, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		default public Func2<A6, A7, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7); 
		}
		default public Func1<A7, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8) -&gt; b */
	@FunctionalInterface public interface Func9<A0, A1, A2, A3, A4, A5, A6, A7, A8, B> {
		default public Func9<A0, A1, A2, A3, A4, A5, A6, A7, A8, B> apply() { return this; }
		default public Func8<A1, A2, A3, A4, A5, A6, A7, A8, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func7<A2, A3, A4, A5, A6, A7, A8, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func6<A3, A4, A5, A6, A7, A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func5<A4, A5, A6, A7, A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func4<A5, A6, A7, A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func3<A6, A7, A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func2<A7, A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		default public Func1<A8, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9) -&gt; b */
	@FunctionalInterface public interface Func10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, B> {
		default public Func10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, B> apply() { return this; }
		default public Func9<A1, A2, A3, A4, A5, A6, A7, A8, A9, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func8<A2, A3, A4, A5, A6, A7, A8, A9, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func7<A3, A4, A5, A6, A7, A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func6<A4, A5, A6, A7, A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func5<A5, A6, A7, A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func4<A6, A7, A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func3<A7, A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func2<A8, A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		default public Func1<A9, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10) -&gt; b */
	@FunctionalInterface public interface Func11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B> {
		default public Func11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B> apply() { return this; }
		default public Func10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func9<A2, A3, A4, A5, A6, A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func8<A3, A4, A5, A6, A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func7<A4, A5, A6, A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func6<A5, A6, A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func5<A6, A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func4<A7, A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func3<A8, A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func2<A9, A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		default public Func1<A10, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) -&gt; b */
	@FunctionalInterface public interface Func12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, B> {
		default public Func12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, B> apply() { return this; }
		default public Func11<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func10<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func9<A3, A4, A5, A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func8<A4, A5, A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func7<A5, A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public Func6<A6, A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func5<A7, A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func4<A8, A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func3<A9, A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func2<A10, A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		default public  Func1<A11, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) -&gt; b */
	@FunctionalInterface public interface Func13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, B> {
		default public Func13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, B> apply() { return this; }
		default public Func12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func11<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func10<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func9<A4, A5, A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func8<A5, A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func7<A6, A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func6<A7, A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func5<A8, A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func4<A9, A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func3<A10, A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func2<A11, A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		default public Func1<A12, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13) -&gt; b */
	@FunctionalInterface public interface Func14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> {
		default public Func14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply() { return this; }
		default public Func13<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func12<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func11<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func10<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func9<A5, A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func8<A6, A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func7<A7, A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func6<A8, A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func5<A9, A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func4<A10, A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func3<A11, A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func2<A12, A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		default public Func1<A13, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14) -&gt; b */
	@FunctionalInterface public interface Func15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> {
		default public Func15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply() { return this; }
		default public Func14<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func13<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func12<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func11<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func10<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func9<A6, A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func8<A7, A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func7<A8, A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func6<A9, A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func5<A10, A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func4<A11, A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func3<A12, A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		default public Func2<A13, A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14); 
		}
		default public Func1<A14, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) -&gt; b */
	@FunctionalInterface public interface Func16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> {
		default public Func16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply() { return this; }
		default public Func15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func14<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func13<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func12<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func11<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func10<A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func9<A7, A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func8<A8, A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func7<A9, A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func6<A10, A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func5<A11, A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func4<A12, A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func3<A13, A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func2<A14, A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14, A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		default public Func1<A15, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14) {
			return (A15 arg15) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16) -&gt; b */
	@FunctionalInterface public interface Func17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> {
		default public Func17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply() { return this; }
		default public Func16<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func15<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func14<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func13<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func12<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func11<A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func10<A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func9<A8, A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func8<A9, A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func7<A10, A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func6<A11, A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func5<A12, A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func4<A13, A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func3<A14, A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14, A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func2<A15, A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14) {
			return (A15 arg15, A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		default public Func1<A16, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15) {
			return (A16 arg16) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17) -&gt; b */
	@FunctionalInterface public interface Func18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> {
		default public Func18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply() { return this; }
		default public Func17<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func16<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func15<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func14<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func13<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func12<A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func11<A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func10<A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17); 
		}
		default public Func9<A9, A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func8<A10, A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func7<A11, A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func6<A12, A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func5<A13, A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func4<A14, A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14, A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func3<A15, A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14) {
			return (A15 arg15, A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func2<A16, A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15) {
			return (A16 arg16, A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		default public Func1<A17, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16) {
			return (A17 arg17) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18) -&gt; b */
	@FunctionalInterface public interface Func19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> {
		default public Func19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply() { return this; }
		default public Func18<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func17<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func16<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func15<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func14<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func13<A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func12<A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func11<A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func10<A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func9<A10, A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func8<A11, A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func7<A12, A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func6<A13, A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func5<A14, A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func4<A15, A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14) {
			return (A15 arg15, A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func3<A16, A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15) {
			return (A16 arg16, A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func2<A17, A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16) {
			return (A17 arg17, A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		default public Func1<A18, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16, final A17 arg17) {
			return (A18 arg18) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18);
	}
	/** (a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19) -&gt; b */
	@FunctionalInterface public interface Func20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> {
		default public Func20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply() { return this; }
		default public Func19<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0) {
			return (A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func18<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1) {
			return (A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func17<A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2) {
			return (A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func16<A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3) {
			return (A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func15<A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4) {
			return (A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func14<A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5) {
			return (A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func13<A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6) {
			return (A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func12<A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7) {
			return (A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func11<A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8) {
			return (A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func10<A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9) {
			return (A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func9<A11, A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10) {
			return (A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func8<A12, A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11) {
			return (A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func7<A13, A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12) {
			return (A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func6<A14, A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13) {
			return (A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19); 
		}
		default public Func5<A15, A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14) {
			return (A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func4<A16, A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15) {
			return (A16 arg16, A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func3<A17, A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16) {
			return (A17 arg17, A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func2<A18, A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16, final A17 arg17) {
			return (A18 arg18, A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		default public Func1<A19, B> apply(final A0 arg0, final A1 arg1, final A2 arg2, final A3 arg3, final A4 arg4, final A5 arg5, final A6 arg6, final A7 arg7, final A8 arg8, final A9 arg9, final A10 arg10, final A11 arg11, final A12 arg12, final A13 arg13, final A14 arg14, final A15 arg15, final A16 arg16, final A17 arg17, final A18 arg18) {
			return (A19 arg19) -> this.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
		}
		B apply(A0 arg0, A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12, A13 arg13, A14 arg14, A15 arg15, A16 arg16, A17 arg17, A18 arg18, A19 arg19);
	}
}