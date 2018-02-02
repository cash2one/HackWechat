package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.z.q;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k {
    static String vuI;

    static /* synthetic */ void a(Activity activity, String str, Bundle bundle) {
        String ou = bh.ou(bundle.getString("Contact_User"));
        if (ou == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            return;
        }
        com.tencent.mm.storage.x WO = ((h) g.h(h.class)).EY().WO(ou);
        if (WO == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            return;
        }
        int i;
        ArrayList arrayList;
        String[] split;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = WO.fWE;
        if (!bh.ov(string)) {
            if (string == str) {
                i = 0;
            } else if (!WO.AM()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!bh.ov(str2)) {
                split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, WO, ou, arrayList);
                com.tencent.mm.plugin.report.service.g.pQN.h(12040, new Object[]{WO.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size())});
            }
            Toast.makeText(activity, activity.getString(R.l.evE), 0).show();
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (bh.ov(str2)) {
            split = str2.split(",");
            while (r3 < split.length) {
                arrayList.add(add);
            }
            if (arrayList.contains(str)) {
                arrayList.remove(str);
            }
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
            Toast.makeText(activity, activity.getString(R.l.evE), 0).show();
            return;
        }
        a(activity, WO, ou, arrayList);
        com.tencent.mm.plugin.report.service.g.pQN.h(12040, new Object[]{WO.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size())});
    }

    static /* synthetic */ void bd(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (bh.k(context, intent)) {
            context.startActivity(intent);
        } else {
            com.tencent.mm.ui.base.h.a(context, R.l.dSn, R.l.dGO, new 8());
        }
    }

    static /* synthetic */ void be(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (bh.k(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void b(Context context, String str, OnDismissListener onDismissListener) {
        if (((q.Gd() & 1) == 0 ? 1 : 0) != 0) {
            com.tencent.mm.ui.base.h.a(context, str, context.getResources().getStringArray(R.c.bqP), "", new 1(onDismissListener, str, context));
        } else {
            com.tencent.mm.ui.base.h.a(context, str, new String[]{context.getResources().getString(R.l.dQM)}, "", new 2(onDismissListener, str, context));
        }
    }

    public static void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        boolean z;
        List F;
        if (!(context instanceof Activity)) {
            x.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[]{bh.cgy()});
        }
        if (g.Dh().Cy()) {
            booleanValue = ((Boolean) g.Dj().CU().get(a.xpr, Boolean.valueOf(false))).booleanValue();
        } else {
            booleanValue = false;
        }
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (ccq() || ccr()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str2;
            String[] strArr;
            if (bundle == null) {
                str2 = "";
            } else {
                str2 = bundle.getString("Contact_User");
            }
            String ou = bh.ou(str2);
            if (ou == null || ou == "" || ou.endsWith("@chatroom") || q.gr(ou)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dSx), context.getResources().getString(R.l.dSy), context.getResources().getString(R.l.dSs), context.getResources().getString(R.l.dSq)} : new String[]{context.getResources().getString(R.l.dSx), context.getResources().getString(R.l.dSs), context.getResources().getString(R.l.dSq)};
            } else {
                com.tencent.mm.storage.x WO = ((h) g.h(h.class)).EY().WO(ou);
                if (WO != null) {
                    str2 = WO.AQ();
                    vuI = context.getResources().getString(R.l.dSr, new Object[]{str2});
                    strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dSx), context.getResources().getString(R.l.dSy), vuI, context.getResources().getString(R.l.dSs), context.getResources().getString(R.l.dSq)} : new String[]{context.getResources().getString(R.l.dSx), vuI, context.getResources().getString(R.l.dSs), context.getResources().getString(R.l.dSq)};
                } else {
                    return;
                }
            }
            F = bh.F(strArr);
        } else {
            F = bh.F(new String[]{context.getResources().getString(R.l.dSx), context.getResources().getString(R.l.dSs)});
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(2)});
        if (p.ur()) {
            F.add(context.getResources().getString(R.l.dSt));
            com.tencent.mm.plugin.report.service.g.pQN.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(3)});
            if (C2Java.isNetworkConnected()) {
                x.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[]{Integer.valueOf(bh.a((Integer) g.Dj().CU().get(a.xnS, null), 3))});
                g.Dj().CU().a(a.xnS, Integer.valueOf(r0 - 1));
            }
        }
        Dialog mVar = new m(context);
        mVar.setTitle(str);
        BaseAdapter aVar = new a(F, context, onDismissListener, bundle);
        aVar.vuQ = new 5(mVar, onDismissListener);
        mVar.kPo = aVar;
        com.tencent.mm.ui.base.h.a(context, mVar);
        mVar.setOnCancelListener(new 6(onDismissListener));
        mVar.vwr = new 7(str, F, context, mVar, onDismissListener, i, bundle);
        mVar.show();
    }

    static boolean ccq() {
        Context context = ac.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        return bh.k(context, intent);
    }

    static boolean ccr() {
        return bh.k(ac.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
    }

    private static void a(Activity activity, com.tencent.mm.storage.x xVar, String str, ArrayList<String> arrayList) {
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_asc = new asc();
        com_tencent_mm_protocal_c_asc.wzx = str;
        axa com_tencent_mm_protocal_c_axa = new axa();
        com_tencent_mm_protocal_c_axa.ksO = arrayList.size();
        com_tencent_mm_protocal_c_axa.wEp = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            awz com_tencent_mm_protocal_c_awz = new awz();
            com_tencent_mm_protocal_c_awz.wEo = str2;
            com_tencent_mm_protocal_c_axa.wEp.add(com_tencent_mm_protocal_c_awz);
        }
        com_tencent_mm_protocal_c_asc.wzt = com_tencent_mm_protocal_c_axa;
        ((h) g.h(h.class)).EX().b(new e.a(60, com_tencent_mm_protocal_c_asc));
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
            Iterator it2 = arrayList.iterator();
            String str3 = "";
            while (it2.hasNext()) {
                str3 = (str3 + ((String) it2.next())) + ",";
            }
            xVar.dC(str3);
            ((h) g.h(h.class)).EY().Q(xVar);
        }
        Toast.makeText(activity, activity.getString(R.l.eQl), 0).show();
    }
}
