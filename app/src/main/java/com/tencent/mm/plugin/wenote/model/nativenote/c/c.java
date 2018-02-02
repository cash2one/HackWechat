package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class c {
    public WXRTEditText tUK = null;
    public WXRTEditText tUL = null;
    public WXRTEditText tUM = null;

    public c(WXRTEditText wXRTEditText) {
        this.tUK = wXRTEditText;
    }

    public c(WXRTEditText wXRTEditText, WXRTEditText wXRTEditText2) {
        this.tUL = wXRTEditText;
        this.tUM = wXRTEditText2;
    }
}
