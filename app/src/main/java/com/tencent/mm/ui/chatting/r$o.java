package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.chatting.viewitems.q.b;
import com.tencent.mm.z.c;
import java.util.Map;

public class r$o extends d {
    public r$o(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        x.d("MicroMsg.WebViewClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
        if (!e.a(arVar.fLC, aVar.getContext(), null, aVar.crz())) {
            String str = arVar.userName;
            String str2 = arVar.yOE;
            if (str != null && !str.equals("")) {
                int i;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("shortUrl", str);
                intent.putExtra("webpageTitle", str2);
                Bundle bundle = new Bundle();
                if (auVar != null) {
                    if (auVar.cjc()) {
                        Map y = bi.y(auVar.field_content, "msg");
                        if (y != null) {
                            b ay = b.ay(y);
                            if (!t.ov(ay.hcc)) {
                                intent.putExtra("KTemplateId", ay.hcc);
                                x.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", ay.hcc, arVar.fGz);
                                g.pQN.h(11608, ay.hcc, arVar.fGz, Integer.valueOf(0));
                            }
                        }
                    }
                    com.tencent.mm.z.ar.Hg();
                    af WO = c.EY().WO(auVar.field_talker);
                    if (WO == null || !WO.cia()) {
                        i = 0;
                    } else {
                        i = 4;
                        x.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", WO.field_username);
                    }
                    intent.putExtra("msg_id", auVar.field_msgId);
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    intent.putExtra("pre_username", auVar.field_talker);
                    intent.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    intent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, arVar.ypn, aVar.ywd.vnK));
                    intent.putExtra("preChatName", aVar.crz());
                    intent.putExtra("preChatTYPE", com.tencent.mm.z.t.N(com.tencent.mm.ui.chatting.viewitems.b.a(auVar, arVar.ypn, aVar.ywd.vnK), aVar.crz()));
                    intent.putExtra("preMsgIndex", arVar.ttg);
                    Bundle bundle2 = arVar.yOK;
                    if (bundle2 != null) {
                        intent.putExtras(bundle2);
                    }
                } else {
                    i = 0;
                }
                bundle.putInt("snsWebSource", i);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("geta8key_username", aVar.crz());
                if (!t.ov(arVar.fGz)) {
                    intent.putExtra("srcUsername", arVar.fGz);
                    intent.putExtra("srcDisplayname", arVar.fGA);
                    intent.putExtra("mode", 1);
                }
                intent.putExtra("message_id", arVar.ttf);
                intent.putExtra("message_index", arVar.ttg);
                intent.putExtra("from_scence", 1);
                com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                if (!t.ov(aVar.crz())) {
                    com.tencent.mm.z.ar.Hg();
                    if (c.EY().WO(aVar.crz()).fWx == 1) {
                        com.tencent.mm.z.ar.Hg();
                        c.Fd().Xc(aVar.crz());
                    }
                }
            }
        }
    }
}
