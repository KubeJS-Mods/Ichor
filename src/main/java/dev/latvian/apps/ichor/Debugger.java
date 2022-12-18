package dev.latvian.apps.ichor;

import dev.latvian.apps.ichor.ast.expression.AstCall;

public interface Debugger {
	Debugger DEFAULT = new Debugger() {
	};

	default void pushScope(Scope scope) {
	}

	default void pushSelf(Scope scope, Object self) {
	}

	default void get(Scope scope, Object object, Object returnValue) {
	}

	default void set(Scope scope, Object object, Object value) {
	}

	default void delete(Scope scope, Object object) {
	}

	default void call(Scope scope, AstCall call, Object returnValue) {
	}

	default void assignNew(Scope scope, Object object, Object value) {
	}

	default void assignSet(Scope scope, Object object, Object value) {
	}

	default void exit(Scope scope, Object value) {
	}

	default void debuggerStatement(Scope scope) {
	}
}
