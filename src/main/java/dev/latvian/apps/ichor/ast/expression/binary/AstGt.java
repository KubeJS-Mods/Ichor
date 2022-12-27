package dev.latvian.apps.ichor.ast.expression.binary;

import dev.latvian.apps.ichor.Context;
import dev.latvian.apps.ichor.Scope;

public class AstGt extends AstBinaryBoolean {
	@Override
	public void appendSymbol(StringBuilder builder) {
		builder.append('>');
	}

	@Override
	public boolean evalBoolean(Context cx, Scope scope) {
		return cx.compareTo(scope, cx.eval(scope, left), cx.eval(scope, right)) > 0;
	}
}
