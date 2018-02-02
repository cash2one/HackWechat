package com.google.android.exoplayer2.b;

public abstract class a {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean iX() {
        return cb(Integer.MIN_VALUE);
    }

    public final boolean iY() {
        return cb(4);
    }

    public final boolean iZ() {
        return cb(1);
    }

    public final void ca(int i) {
        this.flags |= i;
    }

    protected final boolean cb(int i) {
        return (this.flags & i) == i;
    }
}
