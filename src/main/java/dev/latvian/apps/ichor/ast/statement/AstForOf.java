package dev.latvian.apps.ichor.ast.statement;

import dev.latvian.apps.ichor.Evaluable;
import dev.latvian.apps.ichor.Interpretable;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.ast.AstStringBuilder;
import dev.latvian.apps.ichor.prototype.Prototype;
import dev.latvian.apps.ichor.util.AssignType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class AstForOf extends AstStatement {
	public final String name;
	public final Evaluable from;
	public final Interpretable body;
	public final String label;

	public AstForOf(String name, Evaluable from, @Nullable Interpretable body, String label) {
		this.name = name;
		this.from = from;
		this.body = body;
		this.label = label;
	}

	protected String appendKeyword() {
		return " of ";
	}

	@Override
	public void append(AstStringBuilder builder) {
		builder.append("for(");
		builder.append(name);
		builder.append(appendKeyword());
		builder.append(from);

		builder.append(')');

		if (body != null) {
			builder.append(body);
		} else {
			builder.append(';');
		}
	}

	@Override
	public void interpret(Scope scope) {
		var f = from.eval(scope);
		var p = scope.getContext().getPrototype(f);
		var itr = getIterable(scope, p, f);

		if (itr.isEmpty()) {
			return;
		}

		for (var it : itr) {
			var s = scope.push();
			s.declareMember(name, it, AssignType.MUTABLE);
			body.interpret(s);
		}
	}

	protected Collection<?> getIterable(Scope scope, Prototype prototype, Object from) {
		return prototype.values(scope, from);
	}
}