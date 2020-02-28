package j.adt;

import java.util.function.Function;

public abstract class Option<A> {
    public static class Some<A> extends Option<A> {
        private final A a;
        public Some(A a) {
            this.a = a;
        }

        public A getValue() {
            return this.a;
        }
    }

    public static class None<A> extends Option<A> {
        public None() {

        }
    }

    public <B> B combine(Function<Some<A>, B> ifSome, Function<None<A>, B> ifNone) {
        if (this instanceof Some) {
            return ifSome.apply((Some<A>) this);
        } else if (this instanceof None) {
            return ifNone.apply((None<A>) this);
        }
        throw new RuntimeException("match arm failure");
    }

}