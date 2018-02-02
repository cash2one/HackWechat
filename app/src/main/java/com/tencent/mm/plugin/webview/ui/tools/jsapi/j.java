package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class j implements a {
    WeakReference<Context> fqH;
    com.tencent.mm.modelgeo.c hpO = null;
    com.tencent.mm.modelgeo.b nVX = null;
    boolean tJJ = false;
    int tJK;
    e tJL;
    e tJM;
    String tJN;
    d tJO;
    com.tencent.mm.modelgeo.b.a tJP = null;
    com.tencent.mm.modelgeo.b.a tJQ = null;
    com.tencent.mm.modelgeo.a.a tJR = null;
    final Runnable tJS = new 1(this);
    int ttB;

    private static final class b extends f {
        private b() {
            super((byte) 0);
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.vde.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.vde.getPackage();
        }
    }

    private static final class c extends f {
        private c() {
            super((byte) 0);
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.vdb.getPackage();
        }
    }

    interface d {
        void Bc(int i);

        void Bd(int i);

        void pQ(int i);

        void vb(int i);
    }

    private static final class e {
        double latitude;
        double longitude;
        String tJV;

        private e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.tJV = null;
        }
    }

    public final void b(int i, int i2, Intent intent) {
        Context context = (Context) this.fqH.get();
        if (!(this.tJO == null || context == null)) {
            if (!this.tJJ) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[]{Integer.valueOf(i)});
                this.tJO.pQ(this.ttB);
            } else if (i2 == 4097 || i2 == 0) {
                this.tJO.Bc(this.ttB);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (bh.ov(stringExtra)) {
                    x.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.tJO.pQ(this.ttB);
                } else {
                    f cVar = com.tencent.mm.pluginsdk.model.a.a.vdb.getPackage().equals(stringExtra) ? new c() : com.tencent.mm.pluginsdk.model.a.a.vdd.getPackage().equals(stringExtra) ? new a((byte) 0) : com.tencent.mm.pluginsdk.model.a.a.vdc.getPackage().equals(stringExtra) ? new g((byte) 0) : com.tencent.mm.pluginsdk.model.a.a.vde.getPackage().equals(stringExtra) ? new b() : new h((byte) 0);
                    cVar.a(context, this.tJL, this.tJM, this.tJN);
                    this.tJO.vb(this.ttB);
                }
            } else {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[]{Integer.valueOf(i2)});
                this.tJO.pQ(this.ttB);
            }
        }
        if (this.tJJ && this.tJO != null) {
            this.tJO.Bd(this.ttB);
        }
        this.tJJ = false;
        this.tJK = com.tencent.mm.pluginsdk.model.a.a.vda.code;
        this.tJL = null;
        this.tJM = null;
        this.fqH = null;
        this.tJO = null;
        this.tJN = null;
        this.tJP = null;
        this.tJQ = null;
        if (!(this.hpO == null || this.tJR == null)) {
            this.hpO.c(this.tJR);
        }
        this.hpO = null;
        this.tJR = null;
        if (this.nVX != null) {
            if (this.tJP != null) {
                this.nVX.a(this.tJP);
            }
            if (this.tJQ != null) {
                this.nVX.a(this.tJQ);
            }
        }
        this.nVX = null;
        this.tJP = null;
        this.tJQ = null;
    }

    j() {
    }

    final void bUO() {
        Context context = null;
        this.tJR = null;
        this.tJP = null;
        this.tJQ = null;
        if (this.fqH != null) {
            context = (Context) this.fqH.get();
        }
        if (context != null) {
            Intent intent = new Intent(context, AppChooserUI.class);
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.vda.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.vdb.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.vdc.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.vdd.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.vde.getPackage());
            intent.putStringArrayListExtra("targetwhitelist", arrayList);
            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.tJM.latitude), Double.valueOf(this.tJM.longitude)})));
            intent.putExtra("targetintent", intent2);
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_map_app", this.tJK);
            bundle.putParcelable("key_target_intent", intent2);
            intent.putExtra("key_recommend_params", bundle);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 2);
            intent.putExtra("title", context.getString(R.l.eta));
            ((MMActivity) context).b(this, intent, 33);
        }
    }
}
