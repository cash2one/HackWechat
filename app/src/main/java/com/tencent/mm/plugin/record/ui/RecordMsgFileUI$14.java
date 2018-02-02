package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.List;

class RecordMsgFileUI$14 implements Runnable {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ String mpC;
    final /* synthetic */ RecordMsgFileUI pGq;
    final /* synthetic */ List pGr;

    RecordMsgFileUI$14(RecordMsgFileUI recordMsgFileUI, List list, String str, Runnable runnable) {
        this.pGq = recordMsgFileUI;
        this.pGr = list;
        this.mpC = str;
        this.fgd = runnable;
    }

    public final void run() {
        File file = new File(h.c(RecordMsgFileUI.a(this.pGq), RecordMsgFileUI.b(this.pGq)));
        for (String str : this.pGr) {
            if (file.exists()) {
                String m = RecordMsgFileUI.m(this.pGq);
                x.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), m});
                if (RecordMsgFileUI.c(this.pGq) == 15) {
                    f.aZh().a(this.pGq.mController.xIM, str, file.getAbsolutePath(), m, 62, RecordMsgFileUI.a(this.pGq).duration, "");
                } else {
                    f.aZh().a(this.pGq.mController.xIM, str, file.getAbsolutePath(), m, 1, RecordMsgFileUI.a(this.pGq).duration, "");
                }
            } else {
                String str2 = RecordMsgFileUI.a(this.pGq).wcQ;
                if (!bh.ov(str2)) {
                    IMediaObject wXVideoObject = new WXVideoObject();
                    wXVideoObject.videoUrl = str2;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                    str2 = bh.az(RecordMsgFileUI.a(this.pGq).title, this.pGq.mController.xIM.getResources().getString(R.l.egS));
                    wXMediaMessage.mediaObject = wXVideoObject;
                    wXMediaMessage.title = str2;
                    wXMediaMessage.description = RecordMsgFileUI.a(this.pGq).desc;
                    wXMediaMessage.thumbData = bh.readFromFile(h.f(RecordMsgFileUI.a(this.pGq), RecordMsgFileUI.b(this.pGq)));
                    if (wXMediaMessage.thumbData == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        ar.Hg();
                        wXMediaMessage.thumbData = bh.readFromFile(stringBuilder.append(c.Fw()).append("web/").append(g.s(bh.az(RecordMsgFileUI.a(this.pGq).fqf, "").getBytes())).toString());
                    }
                    l.a(wXMediaMessage, "", "", str, 3, null);
                }
            }
            f.aZh().dj(this.mpC, str);
        }
        ag.y(this.fgd);
    }

    public final String toString() {
        return super.toString() + "|onActivityResult1";
    }
}
