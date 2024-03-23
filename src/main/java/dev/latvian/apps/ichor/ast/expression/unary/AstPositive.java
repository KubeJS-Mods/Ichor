package dev.latvian.apps.ichor.ast.expression.unary;

import dev.latvian.apps.ichor.Parser;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.ast.AstStringBuilder;

public class AstPositive extends AstUnary {
	@Override
	public void append(AstStringBuilder builder) {
		builder.append('+');
		builder.appendValue(node);
	}

	@Override
	public Object eval(Scope scope) {
		return evalDouble(scope);
	}

	@Override
	public double evalDouble(Scope scope) {
		return scope.asDouble(node);
	}

	@Override
	public int evalInt(Scope scope) {
		return scope.asInt(node);
	}

	@Override
	public Object optimize(Parser parser) {
		if (node instanceof Number) {
			return node;
		}

		return parser.optimize(node);
	}
}
