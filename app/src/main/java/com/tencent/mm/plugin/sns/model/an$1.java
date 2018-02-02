package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qa;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.Date;

class an$1 extends c<qa> {
    final /* synthetic */ an qXu;

    an$1(an anVar) {
        this.qXu = anVar;
        this.xen = qa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return bvX();
    }

    private boolean bvX() {
        int minutes;
        int i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        an anVar = this.qXu;
        try {
            if (anVar.bvW()) {
                Date date = new Date();
                minutes = date.getMinutes() + (date.getHours() * 60);
                if (minutes >= anVar.qXp && minutes <= anVar.qXq) {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[]{Integer.valueOf(minutes), Integer.valueOf(anVar.qXp), Integer.valueOf(anVar.qXq)});
                    return false;
                }
            }
        } catch (Exception e) {
        }
        int i2 = g.zY().getInt("SnsImgPreLoadingSmallImage", 1);
        int i3 = g.zY().getInt("SnsImgPreLoadingBigImage", 1);
        int i4 = g.zY().getInt("SnsPreLoadingVideo", 1);
        minutes = g.zY().getInt("SnsImgPreLoadingInterval", TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        x.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes)});
        if (i2 > 0 || i3 > 0 || i4 > 0) {
            if (minutes > 0) {
                i = minutes;
            }
            if (anVar.hUF || anVar.hUG || bh.by(anVar.qXn) < ((long) r0)) {
                x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[]{Boolean.valueOf(anVar.hUF), Boolean.valueOf(anVar.hUG)});
            } else if (x.Kc("@__weixintimtline")) {
                com.tencent.mm.kernel.g.Dk();
                if (!com.tencent.mm.kernel.g.Di().gPJ.a(new s(), 0)) {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                    x.Kd("@__weixintimtline");
                }
                anVar.qXn = bh.Wo();
            } else {
                x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
            }
        }
        return false;
    }
}
