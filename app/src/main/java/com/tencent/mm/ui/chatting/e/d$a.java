package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.ui.chatting.a.b.b;

class d$a extends b {
    public String desc;
    public int iconRes;
    final /* synthetic */ d yHr;

    public d$a(d dVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.yHr = dVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean Zf(String str) {
        if (str != null) {
            return super.Zf(str.toLowerCase());
        }
        return false;
    }

    public final int getType() {
        return 6;
    }
}
