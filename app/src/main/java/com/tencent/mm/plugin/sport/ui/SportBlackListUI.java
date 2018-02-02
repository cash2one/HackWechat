package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public class SportBlackListUI extends MMPreference {
    private ContactListExpandPreference kZG;
    private List<String> rUw;
    private a rUx = new 2(this);

    static /* synthetic */ void c(SportBlackListUI sportBlackListUI) {
        String d = bh.d(sportBlackListUI.rUw, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(R.l.dDo));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.p(new int[]{s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("always_select_contact", d);
        d.a((Context) sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.sport.b.d.pY(39);
        if (this.rUw == null) {
            this.rUw = new ArrayList();
        }
        ar.Hg();
        Cursor c = c.EY().c("@werun.black.android", "", null);
        while (c.moveToNext()) {
            this.rUw.add(c.getString(0));
        }
        c.close();
        this.kZG = (ContactListExpandPreference) this.yjd.YN("black_contact_list_pref");
        this.kZG.a(this.yjd, this.kZG.ibD);
        this.kZG.la(true).lb(true);
        this.kZG.n(null, this.rUw);
        this.kZG.a(this.rUx);
        this.kZG.setSummary(R.l.edQ);
        setMMTitle(getString(R.l.edu));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SportBlackListUI rUy;

            {
                this.rUy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rUy.finish();
                return false;
            }
        });
    }

    public final int XB() {
        return R.o.fcz;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bh.ov(stringExtra)) {
                Object<String> F = bh.F(stringExtra.split(","));
                if (F != null) {
                    this.rUw.addAll(F);
                    this.kZG.n(null, this.rUw);
                    this.kZG.refresh();
                    for (String stringExtra2 : F) {
                        ar.Hg();
                        com.tencent.mm.z.s.f(c.EY().WO(stringExtra2));
                    }
                }
            }
        }
    }
}
