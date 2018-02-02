package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsPluginsUI extends MMPreference {
    private static int qkr = 1;
    private static HashMap<String, Integer> qks = new 1();
    private f ilB;
    private boolean qkt;
    private boolean qku;

    public final int XB() {
        return R.o.fct;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
        g.pQN.h(14098, new Object[]{Integer.valueOf(5)});
        g.pQN.h(12846, new Object[]{Integer.valueOf(qkr)});
        a.hfL.Q("gh_43f2581f6fd6", "");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eMs);
        setBackBtn(new 2(this));
    }

    public void onResume() {
        PluginPreference pluginPreference;
        boolean z = false;
        super.onResume();
        this.ilB.removeAll();
        this.ilB.a(new PreferenceSmallCategory(this));
        List<Preference> arrayList = new ArrayList();
        List<Preference> arrayList2 = new ArrayList();
        boolean Gz = q.Gz();
        if (!Gz) {
            Gz = bh.getInt(com.tencent.mm.k.g.zY().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Gz) {
            x.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (Gz && d.OQ("qqmail")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.IZ("qqmail")) {
                pluginPreference.setTitle(pluginPreference.qhl);
                if ((q.Gd() & 1) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.PR()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.OQ("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.IZ("newsapp")) {
                pluginPreference.setTitle(pluginPreference.qhl);
                if ((q.Gd() & SQLiteGlobal.journalSizeLimit) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.PR()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.IZ("facebookapp")) {
            pluginPreference.setTitle(pluginPreference.qhl);
            if ((q.Gd() & 8192) == 0) {
                arrayList.add(pluginPreference);
            } else if (b.PQ()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (d.OQ("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.IZ("masssendapp")) {
                pluginPreference.setTitle(pluginPreference.qhl);
                if ((q.Gd() & 65536) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        d.ccW();
        if (!b.PP()) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.IZ("voiceinputapp")) {
                pluginPreference.setTitle(pluginPreference.qhl);
                if ((q.Gd() & 33554432) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        String string = getString(R.l.edR);
        pluginPreference.qhk = "gh_43f2581f6fd6";
        pluginPreference.qhl = string;
        pluginPreference.setKey("settings_plugins_list_#" + pluginPreference.qhk);
        pluginPreference.setTitle(pluginPreference.qhl);
        if (((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).bDd()) {
            arrayList.add(pluginPreference);
        } else {
            arrayList2.add(pluginPreference);
        }
        this.qku = com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hId);
        pluginPreference.qhp = this.qku;
        String value = com.tencent.mm.k.g.zY().getValue("LinkedinPluginClose");
        if (bh.ov(value) || Integer.valueOf(value).intValue() == 0) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.IZ("linkedinplugin")) {
                pluginPreference2.setTitle(pluginPreference2.qhl);
                boolean z2 = (q.Gd() & 16777216) == 0;
                ar.Hg();
                if (!bh.ov((String) c.CU().get(286721, null))) {
                    z = true;
                }
                if (z2 && r1) {
                    arrayList.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Preference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.yjA = R.k.dAA;
            pluginTextPreference.Fg(R.l.eMz);
            this.ilB.a(pluginTextPreference);
        }
        ar.Hg();
        value = (String) c.CU().get(w.a.xvi, "");
        Preference preference = null;
        for (Preference preference2 : arrayList) {
            preference2.mkA = 255;
            if (value.contains(preference2.qhk)) {
                preference2.qhp = true;
                if (preference == null) {
                    preference = preference2;
                }
            }
            this.ilB.a(preference2);
        }
        this.ilB.a(new PreferenceSmallCategory(this));
        Preference preference22 = new PluginTextPreference(this);
        preference22.yjA = R.k.dAB;
        preference22.Fg(R.l.eMG);
        this.ilB.a(preference22);
        if (arrayList2.isEmpty()) {
            this.ilB.a(new PluginEmptyTextPreference(this, R.l.eMt));
        }
        for (Preference preference222 : arrayList2) {
            preference222.mkA = h.CTRL_INDEX;
            if (value.contains(preference222.qhk)) {
                preference222.qhp = true;
                if (preference == null) {
                    preference = preference222;
                }
            }
            this.ilB.a(preference222);
        }
        this.ilB.a(new PreferenceSmallCategory(this));
        if (preference != null) {
            setSelection(this.ilB.YP(preference.ibD));
        }
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str != null && str.equals("display_in_addr_book")) {
            boolean isChecked = ((CheckBoxPreference) fVar.YN(str)).isChecked();
            ar.Hg();
            c.CU().set(35, Boolean.valueOf(isChecked));
            return true;
        } else if (!(preference instanceof PluginPreference)) {
            return false;
        } else {
            str = ((PluginPreference) preference).qhk;
            if ("feedsapp".equals(str) && this.qkt) {
                ar.Hg();
                c.CU().set(-2046825369, Boolean.valueOf(false));
            }
            if ("gh_43f2581f6fd6".equals(str) && this.qku) {
                com.tencent.mm.plugin.x.a.bfm();
                com.tencent.mm.aw.d.ih(com.tencent.mm.aw.b.hId);
            }
            d.b(this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
            g.pQN.h(12846, new Object[]{qks.get(str)});
            x.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[]{str, qks.get(str)});
            return true;
        }
    }
}
