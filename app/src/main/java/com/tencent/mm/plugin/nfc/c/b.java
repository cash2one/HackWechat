package com.tencent.mm.plugin.nfc.c;

import android.nfc.Tag;

public abstract class b {
    public Tag oRT;
    public byte[] oRU = null;

    public boolean a(Tag tag) {
        this.oRT = tag;
        if (tag != null) {
            this.oRU = tag.getId();
        }
        return true;
    }
}
