package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Map;

public class x$c extends d {
    private b yMC;

    public x$c(a aVar, b bVar) {
        super(aVar);
        this.yMC = bVar;
    }

    public final void a(View view, a aVar, au auVar) {
        e eVar;
        Map y;
        e a;
        String str;
        a aVar2;
        g.a fS;
        ar arVar = (ar) view.getTag();
        b.hPA.w(arVar.fEJ);
        cf cfVar = arVar.fEJ;
        com.tencent.mm.modelstat.a.a(cfVar, com.tencent.mm.modelstat.a.a.hPx);
        int[] iArr = new int[2];
        int i = 0;
        int i2 = 0;
        if (view != null) {
            view.getLocationInWindow(iArr);
            i = view.getWidth();
            i2 = view.getHeight();
        }
        if (cfVar.field_isSend == 1) {
            e bi = o.Pw().bi(cfVar.field_msgId);
            if (bi.hzP != 0) {
                eVar = bi;
                y = bi.y(cfVar.field_content, "msg");
                if (y != null) {
                    bh.getLong((String) y.get(".msg.img.$hdlength"), 0);
                }
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    u.fI(this.yqa.getContext());
                } else if (cfVar.field_isSend == 1) {
                    if (com.tencent.mm.a.e.bO(o.Pw().m(f.c(eVar), "", ""))) {
                        if (com.tencent.mm.a.e.bO(o.Pw().m(eVar.hzQ, "", ""))) {
                            a(cfVar.field_msgId, cfVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                        } else {
                            a(this.yqa, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                        }
                    } else {
                        a(this.yqa, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                    }
                } else if (eVar.Pd()) {
                    if (eVar.status == -1) {
                        x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[]{Long.valueOf(eVar.hzP)});
                        eVar.eQ(0);
                        eVar.fDt = 256;
                        o.Pw().a(Long.valueOf(eVar.hzP), eVar);
                    }
                    a(cfVar.field_msgId, cfVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                } else {
                    String str2 = eVar.hzQ;
                    if (eVar.Pe()) {
                        a = f.a(eVar);
                        if (a != null && a.hzP > 0 && a.Pd() && com.tencent.mm.a.e.bO(o.Pw().m(a.hzQ, "", ""))) {
                            str = a.hzQ;
                            aVar2 = this.yqa;
                            o.Pw().m(str, "", "");
                            a(aVar2, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                        }
                    }
                    str = str2;
                    aVar2 = this.yqa;
                    o.Pw().m(str, "", "");
                    a(aVar2, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                }
                fS = g.a.fS(auVar.field_content);
                if (fS != null && !bh.ov(fS.appId) && this.yMC != null) {
                    com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fS.appId, false);
                    if (aZ != null && aZ.Yz()) {
                        b.a(aVar, fS, this.yMC instanceof x.a ? b.c(aVar, auVar) : q.FS(), aZ, auVar.field_msgSvrId);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        eVar = o.Pw().bh(cfVar.field_msgSvrId);
        y = bi.y(cfVar.field_content, "msg");
        if (y != null) {
            bh.getLong((String) y.get(".msg.img.$hdlength"), 0);
        }
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            u.fI(this.yqa.getContext());
        } else if (cfVar.field_isSend == 1) {
            if (com.tencent.mm.a.e.bO(o.Pw().m(f.c(eVar), "", ""))) {
                if (com.tencent.mm.a.e.bO(o.Pw().m(eVar.hzQ, "", ""))) {
                    a(cfVar.field_msgId, cfVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                } else {
                    a(this.yqa, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                }
            } else {
                a(this.yqa, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
            }
        } else if (eVar.Pd()) {
            if (eVar.status == -1) {
                x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[]{Long.valueOf(eVar.hzP)});
                eVar.eQ(0);
                eVar.fDt = 256;
                o.Pw().a(Long.valueOf(eVar.hzP), eVar);
            }
            a(cfVar.field_msgId, cfVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
        } else {
            String str22 = eVar.hzQ;
            if (eVar.Pe()) {
                a = f.a(eVar);
                str = a.hzQ;
                aVar2 = this.yqa;
                o.Pw().m(str, "", "");
                a(aVar2, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
            }
            str = str22;
            aVar2 = this.yqa;
            o.Pw().m(str, "", "");
            a(aVar2, cfVar, eVar.hzX, eVar.fFo, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
        }
        fS = g.a.fS(auVar.field_content);
        if (fS != null) {
        }
    }

    private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(this.yqa.getContext(), ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("show_search_chat_content_result", this.yqa.yvY.ysa);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("key_is_biz_chat", this.yqa.ywd.vnK);
        intent.putExtra("key_biz_chat_id", this.yqa.ywd.cti());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", this.yqa.yvY.yAI);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.x.fV(str));
        String crz = this.yqa.crz();
        Bundle bundle2 = new Bundle();
        if (this.yqa.ysk) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (s.gF(crz)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", crz);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        this.yqa.startActivity(intent);
        this.yqa.overridePendingTransition(0, 0);
    }

    public static void a(a aVar, au auVar, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(aVar.getContext(), ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("show_search_chat_content_result", aVar.yvY.ysa);
        intent.putExtra("key_is_biz_chat", aVar.ywd.vnK);
        intent.putExtra("key_biz_chat_id", aVar.ywd.cti());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", aVar.yvY.yAI);
        intent.putExtra("img_gallery_enter_PhotoEditUI", z);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.x.fV(str));
        String crz = aVar.crz();
        if (auVar.field_isSend == 1) {
            str = aVar.ysf.hlJ;
        }
        Bundle bundle2 = new Bundle();
        if (aVar.ysk) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (s.gF(crz)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", crz);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        aVar.startActivity(intent);
        aVar.overridePendingTransition(0, 0);
    }
}
