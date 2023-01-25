package dev.latvian.apps.ichor.js;

import dev.latvian.apps.ichor.Context;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.ast.expression.binary.AstBinaryBoolean;

public class AstIn extends AstBinaryBoolean {
	@Override
	public void appendSymbol(StringBuilder builder) {
		builder.append(" in ");
	}

	@Override
	public boolean evalBoolean(Context cx, Scope scope) {
		//TODO: Implement
		return false;
	}
}