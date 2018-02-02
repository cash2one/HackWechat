package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ae.g;
import com.tencent.mm.ae.k;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.a;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.q$j;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t$a;
import com.tencent.mm.z.ar;

final class p implements h, j, m, o {
    p() {
    }

    public final void um() {
        q.Qc().id(7);
    }

    public final void ep(int i) {
        x.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[]{Integer.valueOf(i)});
        q.Qc().id(i);
    }

    public final g un() {
        return new a(ac.getContext());
    }

    public final String s(String str, int i) {
        if (com.tencent.mm.pluginsdk.model.app.g.cQ(str, i) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.cQ(str, i).field_packageName;
        }
        return "";
    }

    public final String cy(String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.aZ(str, false) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.aZ(str, false).field_packageName;
        }
        return "";
    }

    public final String l(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.l(context, str);
    }

    public final boolean cz(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cz(str);
    }

    public final boolean m(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.m(context, str);
    }

    public final String f(Context context, String str, String str2) {
        return com.tencent.mm.pluginsdk.model.app.p.f(context, str, str2);
    }

    public final String A(String str, String str2) {
        return com.tencent.mm.pluginsdk.model.app.p.A(str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        q$j com_tencent_mm_pluginsdk_q_j = com.tencent.mm.pluginsdk.q.a.vcu;
        if (com_tencent_mm_pluginsdk_q_j != null) {
            com_tencent_mm_pluginsdk_q_j.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
        }
    }

    public final void a(Context context, String str, String str2, String str3, long j) {
        q$j com_tencent_mm_pluginsdk_q_j = com.tencent.mm.pluginsdk.q.a.vcu;
        if (com_tencent_mm_pluginsdk_q_j != null) {
            com_tencent_mm_pluginsdk_q_j.a(str, str2, 2, 4, str3, j);
        }
    }

    public final void uo() {
        b rjVar = new rj();
        rjVar.fJh.fJj = true;
        com.tencent.mm.sdk.b.a.xef.m(rjVar);
    }

    public final k aH(boolean z) {
        if (z) {
            r.QH().ij(4);
        }
        k kVar = new com.tencent.mm.az.k(4);
        ar.CG().a(kVar, 0);
        return kVar;
    }

    public final boolean cA(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cA(str);
    }

    public final boolean a(Context context, int i, int i2, String str) {
        return t$a.a(context, i, i2, str, 4);
    }

    public final boolean b(Context context, int i, int i2, String str) {
        return t$a.a(context, i, i2, str, 7);
    }

    public final void up() {
        MMAppMgr.up();
    }

    public final boolean d(Activity activity) {
        if (f.ze()) {
            com.tencent.mm.pluginsdk.ui.tools.k.R(activity);
            return true;
        }
        u.fI(activity);
        return false;
    }

    public final void aq(Context context) {
        MMAppMgr.ft(context);
    }

    public final void e(Activity activity) {
        MMAppMgr.a(activity, null);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return null;
        }
        String b;
        switch (i) {
            case 2:
                if (intent == null) {
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.gHB + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.gHB, 4);
                return null;
            case 3:
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(activity.getApplicationContext(), intent, e.gHB);
                if (b == null) {
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.gHB + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", b);
                activity.startActivityForResult(intent3, 4);
                return null;
            case 4:
                if (intent == null) {
                    return null;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                if (b == null) {
                    x.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    return null;
                }
                x.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[]{b});
                return d.UN(b);
            default:
                return null;
        }
    }

    public final Intent uq() {
        Intent intent = new Intent(ac.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        return intent;
    }

    public final k a(com.tencent.mm.ae.f fVar) {
        if (com.tencent.mm.modelmulti.m.PZ()) {
            return new com.tencent.mm.modelmulti.g(fVar);
        }
        q.Qc().id(4);
        return null;
    }

    public final boolean a(com.tencent.mm.storage.x xVar) {
        return com.tencent.mm.modelmulti.a.a(xVar);
    }

    public final void a(com.tencent.mm.ag.d dVar, Activity activity, com.tencent.mm.storage.x xVar, boolean z, Runnable runnable) {
        com.tencent.mm.ui.tools.b.a(dVar, activity, xVar, z, runnable, 0);
    }

    public final void a(com.tencent.mm.ag.d dVar, Activity activity, com.tencent.mm.storage.x xVar) {
        com.tencent.mm.ui.tools.b.a(dVar, activity, xVar, false);
    }

    public final boolean ur() {
        return com.tencent.mm.pluginsdk.ui.d.p.ur();
    }

    public final void a(Intent intent, bem com_tencent_mm_protocal_c_bem, int i) {
        c.a(intent, com_tencent_mm_protocal_c_bem, i);
    }

    public final void us() {
        com.tencent.mm.booter.o.us();
    }

    public final void a(Context context, au.a aVar, Bundle bundle) {
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
    }

    public final void a(Context context, com.tencent.mm.storage.x xVar, au.a aVar, Bundle bundle, String str) {
        com.tencent.mm.ui.contact.e.a(context, xVar, aVar, true, true, bundle, str);
    }

    public final void a(Intent intent, String str) {
        com.tencent.mm.ui.contact.e.a(intent, str);
    }

    public final void cB(String str) {
        q.Qd().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
    }

    public final void a(arp com_tencent_mm_protocal_c_arp, String str) {
        ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(com_tencent_mm_protocal_c_arp, str, null, true, false);
    }

    public final boolean ut() {
        return com.tencent.mm.modelmulti.m.PZ();
    }
}
