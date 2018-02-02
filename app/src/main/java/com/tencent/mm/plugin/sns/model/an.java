package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qa;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class an {
    boolean hUF = false;
    boolean hUG = false;
    long qXn = 0;
    private boolean qXo = false;
    int qXp = 0;
    int qXq = 1440;
    c<qa> qXr = new 1(this);
    c qXs = new 2(this);
    c qXt = new 3(this);

    an() {
    }

    final boolean bvW() {
        String value = g.zY().getValue("SnsImgPreLoadingTimeLimit");
        x.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", value);
        if (bh.ov(value)) {
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(":");
            this.qXp = bh.VI(split2[1]) + (bh.VI(split2[0]) * 60);
            split = split[1].split(":");
            this.qXq = bh.VI(split[1]) + (bh.VI(split[0]) * 60);
            x.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", Integer.valueOf(this.qXp), Integer.valueOf(this.qXq));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
