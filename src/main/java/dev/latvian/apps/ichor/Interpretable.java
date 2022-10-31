package dev.latvian.apps.ichor;

public interface Interpretable {
	Interpretable[] EMPTY_INTERPRETABLE_ARRAY = new Interpretable[0];

	void interpret(Scope scope);

	default void interpretNewScope(Scope scope) {
		try {
			interpret(scope.push());
		} finally {
			scope.pop();
		}
	}
}