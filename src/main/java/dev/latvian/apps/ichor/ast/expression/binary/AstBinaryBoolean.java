package dev.latvian.apps.ichor.ast.expression.binary;

import dev.latvian.apps.ichor.Scope;

public abstract class AstBinaryBoolean extends AstBinary {
	@Override
	public Object eval(Scope scope) {
		return evalBoolean(scope);
	}

	@Override
	public abstract boolean evalBoolean(Scope scope);

	@Override
	public int evalInt(Scope scope) {
		return evalBoolean(scope) ? 1 : 0;
	}

	@Override
	public double evalDouble(Scope scope) {
		return evalBoolean(scope) ? 1D : 0D;
	}

	@Override
	public String evalString(Scope scope) {
		return evalBoolean(scope) ? "true" : "false";
	}
}