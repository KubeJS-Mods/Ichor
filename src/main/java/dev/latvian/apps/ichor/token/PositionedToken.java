package dev.latvian.apps.ichor.token;

import dev.latvian.apps.ichor.Special;
import dev.latvian.apps.ichor.error.ParseError;
import dev.latvian.apps.ichor.error.ParseErrorMessage;

public class PositionedToken implements TokenPosSupplier {
	public static final PositionedToken NONE = new PositionedToken(Special.NOT_FOUND, TokenPos.UNKNOWN);

	static {
		NONE.prev = NONE;
		NONE.next = NONE;
	}

	public final Token token;
	public final TokenPos pos;
	public PositionedToken prev;
	public PositionedToken next;

	public PositionedToken(Token t, TokenPos p) {
		token = t;
		pos = p;
	}

	public boolean isName() {
		return token instanceof NameToken n && n.canBeName();
	}

	public String name(ParseErrorMessage error) {
		if (token instanceof NameToken n && n.canBeName()) {
			return n.name;
		} else {
			throw new ParseError(pos, error);
		}
	}

	@Override
	public String toString() {
		return token + " @ " + pos;
	}

	@Override
	public TokenPos getPos() {
		return pos;
	}

	public boolean exists() {
		return token != Special.NOT_FOUND;
	}

	public boolean is(Token t) {
		return token == t;
	}

	public boolean is(Token[] tokens) {
		for (var t : tokens) {
			if (token == t) {
				return true;
			}
		}

		return false;
	}

	public String toRecursiveString() {
		StringBuilder builder = new StringBuilder();
		var t = this;

		while (t.exists()) {
			builder.append(t);
			t = t.next;
		}

		return builder.toString();
	}
}
