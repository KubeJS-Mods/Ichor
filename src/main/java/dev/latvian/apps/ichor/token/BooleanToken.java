package dev.latvian.apps.ichor.token;

import dev.latvian.apps.ichor.Evaluable;
import dev.latvian.apps.ichor.EvaluableType;
import dev.latvian.apps.ichor.Parser;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.ast.AppendableAst;
import dev.latvian.apps.ichor.ast.AstStringBuilder;

public class BooleanToken implements Token, Evaluable, AppendableAst {
	public static final BooleanToken TRUE = new BooleanToken(true);
	public static final BooleanToken FALSE = new BooleanToken(false);

	public static Evaluable of(boolean value) {
		return value ? TRUE : FALSE;
	}

	public final boolean value;
	public final Boolean valueObj;

	private BooleanToken(boolean v) {
		value = v;
		valueObj = v;
	}

	@Override
	public String toString() {
		return value ? "true" : "false";
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof BooleanToken t && t.value == value;
	}

	@Override
	public Evaluable toEvaluable(Parser parser, TokenPos pos) {
		return this;
	}

	@Override
	public EvaluableType getType(Scope scope) {
		return EvaluableType.BOOLEAN;
	}

	@Override
	public Object eval(Scope scope) {
		return valueObj;
	}

	@Override
	public boolean evalBoolean(Scope scope) {
		return value;
	}

	@Override
	public void evalString(Scope scope, StringBuilder builder) {
		builder.append(value);
	}

	@Override
	public double evalDouble(Scope scope) {
		return value ? 1D : 0D;
	}

	@Override
	public int evalInt(Scope scope) {
		return value ? 1 : 0;
	}

	@Override
	public void append(AstStringBuilder builder) {
		builder.builder.append(value);
	}

	@Override
	public boolean equals(Scope scope, Evaluable right, boolean shallow) {
		return value == right.evalBoolean(scope);
	}

	@Override
	public int compareTo(Scope scope, Evaluable right) {
		return Boolean.compare(value, right.evalBoolean(scope));
	}
}
