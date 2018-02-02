package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.a.b.b;

class f$a extends b {
    public String appId;
    public String bhd;
    public int iconRes;
    public String imagePath;
    final /* synthetic */ f yHG;

    public f$a(f fVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.yHG = fVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean Zf(String str) {
        if (str == null) {
            return false;
        }
        Object toLowerCase = str.toLowerCase();
        if (Zg(toLowerCase)) {
            if (!bh.ov(this.bhd) && this.bhd.toLowerCase().contains(toLowerCase)) {
                return true;
            }
        } else if (!bh.ov(this.bhd) && fN(toLowerCase, this.bhd.toLowerCase())) {
            return true;
        }
        return super.Zf(toLowerCase);
    }

    public final int getType() {
        return 3;
    }
}
