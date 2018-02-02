package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceAppUI extends MMPreference implements e {
    private f ilB;
    private ServicePreference rXN;
    private ServicePreference rXO;
    private PreferenceTitleCategory rXP;
    private PreferenceTitleCategory rXQ;
    private List<com.tencent.mm.pluginsdk.model.app.f> rXR = new ArrayList();
    private List<com.tencent.mm.pluginsdk.model.app.f> rXS = new ArrayList();
    private OnItemClickListener rXT;
    private OnItemClickListener rXU;
    private String talker;

    static /* synthetic */ void a(ServiceAppUI serviceAppUI, com.tencent.mm.pluginsdk.model.app.f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ServiceAppUI", "app is null");
            return;
        }
        g.pQN.h(10923, new Object[]{Integer.valueOf(13), fVar.field_appId, Integer.valueOf(1)});
        if (fVar.fQZ == 2 && !bh.ov(fVar.fQY)) {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = serviceAppUI.getSharedPreferences(ac.cfs(), 0);
            ActionBarActivity actionBarActivity = serviceAppUI.mController.xIM;
            String d = w.d(sharedPreferences);
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (s.eV(serviceAppUI.talker)) {
                ar.Hg();
                q hD = c.Fh().hD(serviceAppUI.talker);
                if (hD != null) {
                    size = hD.Ms().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    bundle.putString("sendAppMsgToUserName", serviceAppUI.talker);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("forceHideShare", true);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fQY, Integer.valueOf(size), d}));
                    d.b(serviceAppUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                    serviceAppUI.finish();
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            bundle.putString("sendAppMsgToUserName", serviceAppUI.talker);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("forceHideShare", true);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fQY, Integer.valueOf(size), d}));
            d.b(serviceAppUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
            serviceAppUI.finish();
        } else if (fVar.fQZ == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("service_app_package_name", fVar.field_packageName);
            intent2.putExtra("service_app_openid", fVar.field_openId);
            intent2.putExtra("service_app_appid", fVar.field_appId);
            serviceAppUI.setResult(-1, intent2);
            serviceAppUI.finish();
        } else if (fVar.fQZ == 1) {
            b.ifs.n(serviceAppUI.mController.xIM, fVar.fQY);
            serviceAppUI.finish();
        }
    }

    public final int XB() {
        return R.o.fcc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.rXN != null) {
            this.rXN.onResume();
        }
        if (this.rXO != null) {
            this.rXO.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.rXN != null) {
            this.rXN.onPause();
        }
        if (this.rXO != null) {
            this.rXO.onPause();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eKg);
        this.talker = getIntent().getStringExtra("service_app_talker_user");
        setBackBtn(new 1(this));
        this.rXR.clear();
        this.rXS.clear();
        Cursor df = s.eV(this.talker) ? an.bin().df(0, 2) : s.gF(this.talker) ? an.bin().df(0, 4) : an.bin().df(0, 1);
        if (df != null) {
            if (df.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.b(df);
                    if (fVar.field_serviceAppType == 1) {
                        this.rXR.add(fVar);
                    } else if (fVar.field_serviceAppType == 2) {
                        this.rXS.add(fVar);
                    }
                } while (df.moveToNext());
            }
            df.close();
        }
        if (this.rXT == null) {
            this.rXT = new 2(this);
        }
        if (this.rXU == null) {
            this.rXU = new 3(this);
        }
        this.ilB = this.yjd;
        this.ilB.removeAll();
        if (this.rXR.size() > 0) {
            this.rXN = new ServicePreference(this);
            this.rXN.qjF = this.rXR;
            if (this.rXT != null) {
                this.rXN.rXE = this.rXT;
            }
            if (this.rXP == null) {
                this.rXP = new PreferenceTitleCategory(this);
                this.rXP.setTitle(R.l.eYI);
            }
            this.ilB.a(this.rXP);
            this.ilB.a(this.rXN);
        }
        if (this.rXS.size() > 0) {
            this.rXO = new ServicePreference(this);
            this.rXO.qjF = this.rXS;
            if (this.rXU != null) {
                this.rXO.rXE = this.rXU;
            }
            if (this.rXQ == null) {
                this.rXQ = new PreferenceTitleCategory(this);
                this.rXQ.setTitle(R.l.dMm);
            }
            this.ilB.a(this.rXQ);
            this.ilB.a(this.rXO);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
