package dev.latvian.apps.ichor.parser.expression.binary;

import dev.latvian.apps.ichor.Scope;

public class AstSub extends AstBinary {
	@Override
	public void appendSymbol(StringBuilder builder) {
		builder.append('-');
	}

	@Override
	public Object eval(Scope scope) {
		return evalDouble(scope);
	}

	@Override
	public double evalDouble(Scope scope) {
		return scope.getContext().asDouble(scope, left) - scope.getContext().asDouble(scope, right);
	}

	@Override
	public int evalInt(Scope scope) {
		return scope.getContext().asInt(scope, left) - scope.getContext().asInt(scope, right);
	}
}