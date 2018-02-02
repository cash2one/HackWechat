package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.ui.chatting.a.b.b;

class g$a extends b {
    public String desc;
    public int iconRes;
    final /* synthetic */ g yHJ;
    public int yHL;
    public int yHM = 0;

    public g$a(g gVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.yHJ = gVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean Zf(String str) {
        if (str == null) {
            return false;
        }
        boolean Zf = super.Zf(str);
        if (Zf) {
            return Zf;
        }
        return this.title.contains(str);
    }

    public final int getType() {
        return this.type;
    }
}
