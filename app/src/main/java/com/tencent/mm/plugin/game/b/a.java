package com.tencent.mm.plugin.game.b;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    protected final void AX() {
        if (AY()) {
            t(-103, 2);
        }
    }

    protected final String getTableName() {
        return "Game";
    }

    public final String getName() {
        return "FTS5GameStorage";
    }

    public final int getType() {
        return 16;
    }

    public final int getPriority() {
        return 16;
    }

    protected final boolean AY() {
        return !cB(-103, 2);
    }
}
