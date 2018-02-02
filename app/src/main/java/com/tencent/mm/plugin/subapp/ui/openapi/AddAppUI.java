package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI extends MMPreference implements e {
    private f ilB;
    private AppPreference rXx;
    private AppPreference rXy;

    static /* synthetic */ void a(AddAppUI addAppUI, String str) {
        Intent intent = new Intent(addAppUI, AppProfileUI.class);
        intent.putExtra("AppProfileUI_AppId", str);
        addAppUI.startActivity(intent);
    }

    static /* synthetic */ void f(com.tencent.mm.pluginsdk.model.app.f fVar) {
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        an.bin().a(fVar, new String[0]);
    }

    public final int XB() {
        return R.o.fbf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.rXx != null) {
            this.rXx.onResume();
        }
        if (this.rXy != null) {
            this.rXy.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.rXx != null) {
            this.rXx.onPause();
        }
        if (this.rXy != null) {
            this.rXy.onPause();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dCC);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddAppUI rXz;

            {
                this.rXz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rXz.finish();
                return true;
            }
        });
        this.ilB = this.yjd;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbf);
        this.rXx = (AppPreference) this.ilB.YN("addapp_added");
        this.rXx.rXB = 1;
        this.rXx.rXE = new 2(this);
        this.rXx.rXF = new 3(this);
        this.rXy = (AppPreference) this.ilB.YN("addapp_available");
        this.rXy.rXB = 0;
        this.rXy.rXE = new 4(this);
    }

    public final boolean a(f fVar, Preference preference) {
        if (!preference.ibD.equals("addapp_recommend")) {
            return false;
        }
        SharedPreferences sharedPreferences = this.mController.xIM.getSharedPreferences(ac.cfs(), 0);
        ActionBarActivity actionBarActivity = this.mController.xIM;
        String d = w.d(sharedPreferences);
        String string = getString(R.l.dCD, new Object[]{Integer.valueOf(d.vAz), d, w.cfh()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
