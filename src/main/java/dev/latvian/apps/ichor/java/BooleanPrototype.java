package dev.latvian.apps.ichor.java;

import dev.latvian.apps.ichor.Context;
import dev.latvian.apps.ichor.Scope;
import dev.latvian.apps.ichor.prototype.Prototype;
import dev.latvian.apps.ichor.util.IchorUtils;

public class BooleanPrototype extends Prototype<Boolean> {
	public BooleanPrototype(Context cx) {
		super(cx, Boolean.class);
	}

	@Override
	public Object call(Context cx, Scope scope, Object[] args, boolean hasNew) {
		return args.length == 0 ? Boolean.FALSE : cx.asBoolean(scope, args[0]);
	}

	@Override
	public Number asNumber(Context cx, Scope scope, Boolean self) {
		return self ? IchorUtils.ONE : IchorUtils.ZERO;
	}

	@Override
	public Boolean asBoolean(Context cx, Scope scope, Boolean self) {
		return self;
	}
}
