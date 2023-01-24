package dev.latvian.apps.ichor.util;

import dev.latvian.apps.ichor.Context;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.ast.expression.AstClassFunction;

public class ClassFunctionInstance extends FunctionInstance {

	public ClassFunctionInstance(AstClassFunction function, Context evalContext, Scope evalScope) {
		super(function, evalContext, evalScope);
	}

	/*
	@Override
	public String getPrototypeName() {
		if (functionName == null) {
			functionName = "<class " + type.name().toLowerCase() + " function>";
		}

		return functionName;
	}
	 */

	@Override
	public Object call(Context cx, Scope callScope, Object[] args, boolean hasNew) {
		if (function == ((AstClassFunction) function).owner.constructor) {
			return super.call(cx, callScope, args, false);
		} else {
			return super.call(cx, callScope, args, hasNew);
		}
	}
}
