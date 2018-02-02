package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ay.g;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.m$a;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class m {
    public static void a(Activity activity, Runnable runnable, boolean z, int i) {
        if (com.tencent.mm.modelfriend.m.NN() == m$a.SUCC || com.tencent.mm.modelfriend.m.NN() == m$a.SUCC_UNLOAD) {
            ar.Hg();
            if (bh.c((Boolean) c.CU().get(12322, null))) {
                x.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
            } else {
                if (!z) {
                    ar.Hg();
                    if (bh.c((Boolean) c.CU().get(12323, null))) {
                        x.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
                    }
                }
                ar.Hg();
                c.CU().set(12322, Boolean.valueOf(false));
                String ou = bh.ou(bh.eZ(activity));
                if (ou.length() > 0) {
                    ar.Hg();
                    if (ou.equals(c.CU().get(6, null))) {
                        ar.Hg();
                        c.CU().set(12322, Boolean.valueOf(true));
                        x.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
                    }
                }
                h.a(activity, R.l.dKE, R.l.dGO, R.l.dHd, R.l.dFR, new 1(i, activity, runnable), new 2(runnable, activity));
                ar.Hg();
                c.CU().set(12323, Boolean.valueOf(true));
                return;
            }
        }
        x.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void k(boolean z, boolean z2) {
        int FW = q.FW();
        if (z) {
            FW &= -131073;
        } else {
            FW |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        x.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + FW);
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        FW = !z ? 1 : 2;
        ar.Hg();
        c.EX().b(new g(17, FW));
        if (z2) {
            a.ift.um();
        }
    }

    public static void or(String str) {
        aq.hfP.S("login_user_name", str);
    }

    public static void bE(Context context) {
        String string = context.getString(R.l.dDF);
        String string2 = context.getString(R.l.dDE);
        String string3 = context.getString(R.l.dUc);
        String string4 = context.getString(R.l.dUa);
        OnClickListener 3 = new 3(string2, context);
        h.a(context, string, "", string3, string4, 3, null);
    }

    public static void j(Context context, String str, String str2) {
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA != null) {
            eA.a(context, new 4(str2, context), null);
        }
    }

    public static void a(Context context, v.a aVar, int i) {
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.frP);
        intent.putExtra("KVoiceHelpUrl", aVar.hNH);
        intent.putExtra("KVoiceHelpWording", aVar.fyY);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.hNI != null) {
            intent.getExtras().putAll(aVar.hNI);
        }
        context.startActivity(intent);
    }

    public static void b(Context context, String str, int i) {
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA == null) {
            return;
        }
        if (eA.showType == 8) {
            c(context, eA.url, i);
            return;
        }
        String string = context.getString(R.l.dFU);
        String string2 = context.getString(R.l.dEn);
        OnClickListener 5 = new 5(context, eA, i);
        if (eA.showType != 1 && eA.showType != 4) {
            return;
        }
        if (bh.ov(eA.url)) {
            h.b(context, eA.desc, eA.fon, true);
            return;
        }
        h.a(context, eA.desc, eA.fon, string, string2, 5, null);
    }

    static void c(Context context, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        if (i > 0) {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent, i);
        } else {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
