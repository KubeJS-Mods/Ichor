package dev.latvian.apps.ichor.parser.statement;

import dev.latvian.apps.ichor.Evaluable;
import dev.latvian.apps.ichor.Interpretable;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.parser.AstStringBuilder;

public class AstIf extends AstStatement {
	public final Evaluable condition;
	public final Interpretable trueBody;
	public final Interpretable falseBody;

	public AstIf(Evaluable condition, Interpretable ifTrue, Interpretable ifFalse) {
		this.condition = condition;
		this.trueBody = ifTrue;
		this.falseBody = ifFalse;
	}

	@Override
	public void append(AstStringBuilder builder) {
		builder.append("if (");
		builder.append(condition);
		builder.append(") ");
		builder.append(trueBody);

		if (falseBody != null) {
			builder.append(" else ");
			builder.append(falseBody);
		}
	}

	@Override
	public void interpret(Scope scope) {
		if (condition.evalBoolean(scope)) {
			trueBody.interpretNewScope(scope);
		} else if (falseBody != null) {
			falseBody.interpretNewScope(scope);
		}
	}
}