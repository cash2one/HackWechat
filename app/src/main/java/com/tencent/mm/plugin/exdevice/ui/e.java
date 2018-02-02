package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e {
    int aac;
    d lZj;
    int lZk;

    private e(int i, int i2, String str, String str2, d dVar) {
        this.aac = i;
        this.lZk = i2;
        if (i == 0) {
            return;
        }
        if (dVar != null) {
            this.lZj = dVar;
            return;
        }
        d dVar2 = new d();
        dVar2.field_username = str2;
        dVar2.field_appusername = str;
        dVar2.field_ranknum = 0;
        dVar2.field_selfLikeState = 0;
        dVar2.field_rankID = "";
        dVar2.field_likecount = 0;
        dVar2.field_score = 0;
        this.lZj = dVar2;
    }

    public final String toString() {
        String str = "{ view type: " + this.aac + " display flag: " + this.lZk;
        if (this.lZj != null) {
            str = str + this.lZj.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        return str + "}";
    }
}
