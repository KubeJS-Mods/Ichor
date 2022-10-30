package dev.latvian.apps.ichor.parser;

public class AstStringBuilder {
	public final StringBuilder builder = new StringBuilder();

	public void append(CharSequence string) {
		builder.append(string);
	}

	public void append(String string) {
		builder.append(string);
	}

	public void append(Object o) {
		if (o instanceof Ast ast) {
			ast.append(this);
		} else {
			builder.append(o);
		}
	}

	public void append(char c) {
		builder.append(c);
	}

	@Override
	public String toString() {
		return builder.toString();
	}
}
