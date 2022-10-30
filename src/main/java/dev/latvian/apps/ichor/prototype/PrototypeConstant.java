package dev.latvian.apps.ichor.prototype;

import dev.latvian.apps.ichor.Scope;
import org.jetbrains.annotations.Nullable;

public record PrototypeConstant(Object value) implements PrototypeMember {
	@Override
	public Object get(Scope scope, @Nullable Object self) {
		return value;
	}
}
