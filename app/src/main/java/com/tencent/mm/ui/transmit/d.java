package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.or;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.v;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.List;

public final class d implements com.tencent.mm.plugin.messenger.a.d {
    public final void A(String str, String str2, int i) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[]{str, str2});
            return;
        }
        ar.CG().a(new j(str, str2, i), 0);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        a(context, str, str2, str3, i, i2, null, false, false, str4);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, bmf com_tencent_mm_protocal_c_bmf, boolean z, boolean z2, String str4) {
        int i3 = 1;
        if (context == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio context is null");
        } else if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[]{str, str2});
        } else {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                a aVar = new a();
                context.getResources().getString(R.l.dGO);
                Dialog a = h.a(context, context.getResources().getString(R.l.dGB), true, new 1(this, aVar));
                aVar.context = context;
                aVar.fileName = str2;
                aVar.zoP = str3;
                aVar.ilS = a;
                aVar.userName = str;
                aVar.fGG = str4;
                aVar.zoS = false;
                if (62 == i) {
                    aVar.hTT = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.zol = i3;
                aVar.hVH = i2;
                aVar.zoQ = false;
                aVar.zoT = com_tencent_mm_protocal_c_bmf;
                aVar.execute(new Object[0]);
                return;
            }
            x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, R.l.evN, 1).show();
        }
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[]{str, str2});
            return;
        }
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ar.CG().a(new l(4, q.FS(), str, str2, i, null, 0, str3, str4, true, R.g.bAH), 0);
            bo.HS().c(bo.hhE, null);
            return;
        }
        x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, R.l.evN, 1).show();
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        if (str == null) {
            x.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            return;
        }
        x.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[]{str2});
        g$a fT = g$a.fT(bh.VH(str2));
        if (fT == null) {
            x.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            return;
        }
        b bVar = new b();
        x.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[]{fT.fny});
        if (!bh.ov(fT.fny)) {
            long j = bh.getLong(fT.fny, -1);
            if (j != -1) {
                an.aqd().b(j, bVar);
                if (bVar.xjy != j) {
                    bVar = an.aqd().Rz(fT.fny);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
                        bVar = null;
                    }
                    if (bVar == null) {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[]{fT.fny});
                    } else {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[]{fT.fny, Long.valueOf(bVar.xjy), bVar.field_fileFullPath});
                    }
                }
            } else {
                bVar = an.aqd().Rz(fT.fny);
                if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
                    bVar = null;
                }
                if (bVar == null) {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[]{fT.fny});
                } else {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[]{fT.fny, Long.valueOf(bVar.xjy), bVar.field_fileFullPath});
                }
            }
        }
        String str4 = "";
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
            ar.Hg();
            str4 = com.tencent.mm.pluginsdk.model.app.l.ac(c.Fu(), fT.title, fT.hbc);
            k.q(bVar.field_fileFullPath, str4, false);
            x.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[]{bVar.field_fileFullPath, str4, Integer.valueOf(e.bN(bVar.field_fileFullPath))});
        }
        g$a a = g$a.a(fT);
        a.hbe = 3;
        com.tencent.mm.pluginsdk.model.app.l.a(a, fT.appId, fT.appName, str, str4, bArr, str3);
    }

    public final void k(String str, String str2, boolean z) {
        if (z) {
            ar.CG().a(new j(bh.az(str2, ""), v.ZE(str), 42), 0);
            return;
        }
        List F = bh.F(bh.az(str2, "").split(","));
        String ZE = v.ZE(str);
        for (int i = 0; i < F.size(); i++) {
            ar.CG().a(new j((String) F.get(i), ZE, 42), 0);
        }
    }

    public final void dj(String str, String str2) {
        List<String> F = bh.F(bh.az(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : F) {
                com.tencent.mm.sdk.b.b orVar = new or();
                orVar.fGI.fGJ = str3;
                orVar.fGI.content = str;
                orVar.fGI.type = s.hp(str3);
                orVar.fGI.flags = 0;
                com.tencent.mm.sdk.b.a.xef.m(orVar);
            }
        }
    }
}
