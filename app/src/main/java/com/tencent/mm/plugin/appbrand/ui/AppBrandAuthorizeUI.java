package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.m;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.cao;
import com.tencent.mm.protocal.c.cap;
import com.tencent.mm.protocal.c.cay;
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.statusbar.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private String jKk;
    List<du> jKl = new ArrayList();
    private t jKm;
    protected f jKn;
    private boolean jKo = false;
    private boolean jKp = true;
    private boolean jKq = false;
    private b jKr = null;
    private String mAppId;

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str) {
        a aVar = new a();
        aVar.hmj = new cao();
        aVar.hmk = new cap();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.hmi = 1196;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_cao = new cao();
        com_tencent_mm_protocal_c_cao.appId = str;
        aVar.hmj = com_tencent_mm_protocal_c_cao;
        u.a(aVar.JZ(), new 7(appBrandAuthorizeUI), true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, List list) {
        LinkedList linkedList = new LinkedList();
        for (du duVar : list) {
            arg com_tencent_mm_protocal_c_arg = new arg();
            com_tencent_mm_protocal_c_arg.qgb = duVar.scope;
            com_tencent_mm_protocal_c_arg.qgc = duVar.state;
            linkedList.add(com_tencent_mm_protocal_c_arg);
        }
        a aVar = new a();
        aVar.hmj = new cay();
        aVar.hmk = new caz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar.hmi = 1188;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_cay = new cay();
        com_tencent_mm_protocal_c_cay.appId = str;
        com_tencent_mm_protocal_c_cay.xah = linkedList;
        aVar.hmj = com_tencent_mm_protocal_c_cay;
        u.a(aVar.JZ(), new 8(appBrandAuthorizeUI), true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        if (list == null || list.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeUI", "authItems is empty");
            appBrandAuthorizeUI.df(true);
            return;
        }
        appBrandAuthorizeUI.df(false);
        appBrandAuthorizeUI.runOnUiThread(new 10(appBrandAuthorizeUI, list));
    }

    public final int XB() {
        return m.iCG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandAuthorizeUI jKs;

            {
                this.jKs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jKs.aky();
                this.jKs.finish();
                return false;
            }
        });
        setMMTitle(j.iyC);
        this.jKn = this.yjd;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jKk = stringExtra;
        if (bh.ov(stringExtra)) {
            finish();
            return;
        }
        this.jKq = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.jKm = q.qN(this.jKk);
        if (this.jKm == null) {
            x.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            return;
        }
        this.mAppId = this.jKm.appId;
        c.Dm().F(new 3(this));
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jKr = new b(this);
            this.jKr.addView(childAt, new LayoutParams(-1, -1));
            b bVar = this.jKr;
            int color = getResources().getColor(d.btS);
            if (b.zfW) {
                bVar.ak(color, com.tencent.mm.ui.statusbar.d.c(bVar.mActivity.getWindow()));
            }
            getSwipeBackLayout().addView(this.jKr);
            getSwipeBackLayout().Iv = this.jKr;
        }
    }

    public final boolean a(final f fVar, final Preference preference) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", new Object[]{preference.ibD});
        if (this.jKl == null) {
            x.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
        } else {
            String str = preference.ibD;
            if (bh.ov(str)) {
                x.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
            } else {
                for (final du duVar : this.jKl) {
                    if (str.equals(bh.ou(duVar.scope))) {
                        this.jKo = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            duVar.state = 1;
                        } else if (this.jKp) {
                            this.jKp = false;
                            i.a aVar = new i.a(this);
                            aVar.YG(getString(j.iyt));
                            aVar.YI(getString(j.iys));
                            aVar.a(new OnClickListener(this) {
                                final /* synthetic */ AppBrandAuthorizeUI jKs;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    duVar.state = 2;
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                }
                            });
                            aVar.YJ(getString(j.dEn));
                            aVar.b(new 5(this, duVar, preference, fVar));
                            aVar.d(new OnCancelListener(this) {
                                final /* synthetic */ AppBrandAuthorizeUI jKs;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    duVar.state = 1;
                                    ((CheckBoxPreference) preference).tSw = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            i akx = aVar.akx();
                            akx.setCanceledOnTouchOutside(false);
                            akx.show();
                        } else {
                            duVar.state = 2;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void df(boolean z) {
        runOnUiThread(new 9(this, z));
    }

    protected void onPause() {
        if (this.jKo) {
            x.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
            ag.y(new Runnable(this) {
                final /* synthetic */ AppBrandAuthorizeUI jKs;

                {
                    this.jKs = r1;
                }

                public final void run() {
                    if (this.jKs.jKo) {
                        this.jKs.jKo = false;
                        AppBrandAuthorizeUI.a(this.jKs, this.jKs.mAppId, this.jKs.jKl);
                    }
                }
            });
        }
        super.onPause();
    }

    public void onBackPressed() {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        aky();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void aky() {
        if (this.jKq) {
            JSONArray jSONArray = new JSONArray();
            for (du duVar : this.jKl) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", duVar.scope);
                    jSONObject.put("state", duVar.state);
                    jSONObject.put("desc", duVar.vIX);
                    jSONArray.put(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", new Object[]{jSONArray});
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
        }
    }
}
