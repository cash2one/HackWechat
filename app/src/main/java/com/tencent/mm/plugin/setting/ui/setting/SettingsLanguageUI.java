package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.LanguagePreference;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e$b;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] qjv = v.qjv;
    private f ilB;
    private List<a> qjw;
    private String qjx;
    private boolean qjy = false;

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        Locale UX = w.UX(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                UX = w.xfc;
                Locale.setDefault(UX);
            } else {
                UX = Locale.getDefault();
            }
        }
        w.a(settingsLanguageUI.getSharedPreferences(ac.cfs(), 0), str);
        w.a(settingsLanguageUI, UX);
        bd.setProperty("system_property_key_locale", str);
        ac.a(com.tencent.mm.bw.a.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            com.tencent.mm.plugin.setting.a.ifs.s(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            return;
        }
        ar.CG().a(new com.tencent.mm.z.bd(new 3(settingsLanguageUI)), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ac.getContext().sendBroadcast(intent);
        intent = new Intent();
        intent.setComponent(new ComponentName(e$b.xEj, "com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver"));
        intent.putExtra("exdevice_process_action_code_key", "action_reload_resources");
        intent.putExtra("exdevice_language", str);
        ac.getContext().sendBroadcast(intent);
        FontSelectorView.brk();
        g.zZ().gIc.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        com.tencent.mm.plugin.setting.a.ifs.s(intent, settingsLanguageUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XB() {
        return -1;
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(R.l.eLB);
        setBackBtn(new 1(this));
        a(0, getString(R.l.eLA), new 2(this), b.xJz);
        this.qjy = getIntent().getBooleanExtra("not_auth_setting", false);
        this.ilB.removeAll();
        String[] stringArray = getResources().getStringArray(R.c.bqS);
        this.qjx = w.e(getSharedPreferences(ac.cfs(), 0));
        this.qjw = new ArrayList();
        while (i < qjv.length) {
            String str = qjv[i];
            this.qjw.add(new a(stringArray[i], "", str, this.qjx.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.qjw) {
            Preference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.ilB.a(languagePreference);
        }
        this.ilB.a(new PreferenceCategory(this));
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).xOk;
        if (aVar == null) {
            return false;
        }
        this.qjx = aVar.xOn;
        for (a aVar2 : this.qjw) {
            aVar2.nuE = false;
        }
        aVar.nuE = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
