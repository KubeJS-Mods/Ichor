package dev.latvian.apps.ichor.parser.statement;

import dev.latvian.apps.ichor.Evaluable;
import dev.latvian.apps.ichor.Interpretable;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.parser.AstStringBuilder;

public class AstWhile extends AstStatement {
	public final Evaluable condition;
	public final Interpretable body;

	public AstWhile(Evaluable condition, Interpretable body) {
		this.condition = condition;
		this.body = body;
	}

	@Override
	public void append(AstStringBuilder builder) {
		builder.append("while (");
		builder.append(condition);
		builder.append(") ");
		builder.append(body);
	}

	@Override
	public void interpret(Scope scope) {
		while (condition.evalBoolean(scope)) {
			try {
				body.interpretNewScope(scope);
			} catch (AstBreak.BreakException ex) {
				break;
			} catch (AstContinue.ContinueException ignored) {
			}
		}
	}
}