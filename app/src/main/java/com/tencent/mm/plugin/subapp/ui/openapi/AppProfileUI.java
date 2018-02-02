package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private af handler = null;
    private f ilB;
    private com.tencent.mm.pluginsdk.model.app.f nlG;
    private AppHeaderPreference$a rXL;

    public final int XB() {
        return R.o.fbg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        super.onResume();
        an.bin().c(this);
    }

    protected void onPause() {
        an.bin().j(this);
        super.onPause();
    }

    protected final void initView() {
        boolean z = true;
        this.rXL = new AppHeaderPreference$a(this) {
            final /* synthetic */ AppProfileUI rXM;

            {
                this.rXM = r1;
            }

            public final String bEe() {
                return g.a(this.rXM.mController.xIM, this.rXM.nlG, null);
            }

            public final Bitmap bEf() {
                return g.b(this.rXM.nlG.field_appId, 1, com.tencent.mm.bv.a.getDensity(this.rXM));
            }

            public final String iS(boolean z) {
                return this.rXM.mController.xIM.getString(z ? R.l.eMy : R.l.eMF);
            }

            public final String getHint() {
                Context context = this.rXM.mController.xIM;
                com.tencent.mm.pluginsdk.model.app.f a = this.rXM.nlG;
                if (context == null || a == null) {
                    return null;
                }
                String ei = g.ei(context);
                if (ei.equalsIgnoreCase("zh_CN")) {
                    return a.field_appDiscription;
                }
                return (ei.equalsIgnoreCase("zh_TW") || ei.equalsIgnoreCase("zh_HK")) ? bh.ov(a.field_appDiscription_tw) ? a.field_appDiscription : a.field_appDiscription_tw : ei.equalsIgnoreCase("en") ? bh.ov(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en : bh.ov(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en;
            }
        };
        this.nlG = g.aZ(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.nlG == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        setMMTitle(R.l.dGp);
        this.ilB = this.yjd;
        setBackBtn(new 2(this));
        refresh();
    }

    private void refresh() {
        boolean z;
        boolean z2 = true;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbg);
        if (this.nlG.field_status == 1) {
            this.ilB.YO("app_profile_add");
        } else {
            this.ilB.YO("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.ilB.YN("app_profile_header");
        AppHeaderPreference$a appHeaderPreference$a = this.rXL;
        if (this.nlG.field_status == 1) {
            z = true;
        } else {
            z = false;
        }
        if (appHeaderPreference$a == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        appHeaderPreference.rXC = appHeaderPreference$a;
        appHeaderPreference.fJL = z;
    }

    private void bEg() {
        this.handler = new 3(this);
        this.handler.sendEmptyMessageDelayed(0, 30);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.nlG.field_status = 1;
            this.nlG.field_modifyTime = System.currentTimeMillis();
            an.bin().a(this.nlG, new String[0]);
            refresh();
            a(this.nlG, true);
            bEg();
            return true;
        } else if (!str.equals("app_profile_remove")) {
            return false;
        } else {
            this.nlG.field_status = 0;
            this.nlG.field_modifyTime = System.currentTimeMillis();
            an.bin().a(this.nlG, new String[0]);
            refresh();
            a(this.nlG, false);
            bEg();
            return true;
        }
    }

    public final void a(String str, l lVar) {
        if (str.equals(this.nlG.field_appId)) {
            initView();
        }
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        List linkedList = new LinkedList();
        linkedList.add(new i.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        ar.Hg();
        c.EX().b(new i(linkedList));
    }
}
