package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a;

public final class c extends a {
    protected final void AX() {
        if (AY()) {
            t(-104, 2);
        }
    }

    protected final String getTableName() {
        return "WeApp";
    }

    public final String getName() {
        return "FTS5WeAppStorage";
    }

    public final int getType() {
        return WXMediaMessage.TITLE_LENGTH_LIMIT;
    }

    public final int getPriority() {
        return WXMediaMessage.TITLE_LENGTH_LIMIT;
    }

    protected final boolean AY() {
        return !cB(-104, 2);
    }
}
