package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ae.u;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.y.g$a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Map;

final class a implements com.tencent.mm.plugin.appbrand.compat.a.a {
    a() {
    }

    public final void J(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra("title", context.getString(R.l.dDY));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 3);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final void K(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra("title", context.getString(R.l.dDV));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 4);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final Intent bK(Context context) {
        Intent QM = ((f) g.h(f.class)).QM();
        QM.setClass(context, AppBrandSearchUI.class);
        QM.putExtra("key_trust_url", true);
        QM.putExtra("title", context.getString(R.l.dDU));
        QM.putExtra("searchbar_tips", context.getString(R.l.dDU));
        QM.putExtra("KRightBtn", true);
        QM.putExtra("ftsneedkeyboard", true);
        QM.putExtra("ftsType", 64);
        QM.putExtra("ftsbizscene", 201);
        Map abK = ((f) g.h(f.class)).abK();
        String IU = b.IU();
        abK.put("WASessionId", IU);
        QM.putExtra("rawUrl", ((f) g.h(f.class)).r(abK));
        QM.putExtra("key_load_js_without_delay", true);
        QM.addFlags(67108864);
        QM.putExtra("key_session_id", IU);
        String str = "key_search_input_hint";
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xtF, null);
        String str2 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
        QM.putExtra(str, str2);
        return QM;
    }

    public final void a(g$a com_tencent_mm_y_g_a, String str, String str2, String str3, byte[] bArr) {
        l.a(com_tencent_mm_y_g_a, str, str2, str3, null, bArr);
    }

    public final Intent k(Context context, String str, String str2) {
        Parcelable intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), str2);
        Intent intent2 = new Intent(context, AppChooserUI.class);
        intent2.putExtra(DownloadSettingTable$Columns.TYPE, 0);
        intent2.putExtra("title", context.getResources().getString(R.l.dTx));
        intent2.putExtra("mimetype", str2);
        intent2.putExtra("targetintent", intent);
        return intent2;
    }

    public final View c(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.i.dmx, viewGroup, false);
    }

    public final String bL(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        return context.getString(R.l.eMA);
    }

    public final String bM(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        return context.getString(R.l.eMw);
    }

    public final String bN(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        return context.getString(R.l.eMy);
    }

    public final String bO(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        return context.getString(R.l.eMF);
    }

    public final int abt() {
        com.tencent.mm.sdk.b.b hlVar = new hl();
        com.tencent.mm.sdk.b.a.xef.m(hlVar);
        return hlVar.fxN.fxO;
    }

    public final void a(com.tencent.mm.plugin.appbrand.compat.a.a.a aVar) {
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new aig();
        aVar2.hmk = new aih();
        aVar2.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        aVar2.hmi = 1926;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        u.a(aVar2.JZ(), new 1(this, aVar), true);
    }
}
