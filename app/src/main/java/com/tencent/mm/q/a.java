package com.tencent.mm.q;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public final String getName() {
        return "FTS5FriendStorage";
    }

    public final int getType() {
        return 1280;
    }

    public final int getPriority() {
        return 1280;
    }

    protected final void AX() {
        if (AY()) {
            this.mJR.t(-107, 1);
        }
    }

    protected final String getTableName() {
        return "Friend";
    }

    protected final boolean AY() {
        return !cB(-107, 1);
    }
}
