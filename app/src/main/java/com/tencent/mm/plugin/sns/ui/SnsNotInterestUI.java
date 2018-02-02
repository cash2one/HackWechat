package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements e {
    private static final String[] rEb = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] rEc = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] rEg = new int[]{j.qKE, j.qKI, j.qKJ, j.qKD, j.qKC, j.qKG, j.qKF};
    private f jKn;
    private r jmO = null;
    private String pnG = null;
    private HashMap<String, Boolean> rEd = new HashMap(rEb.length);
    private HashMap<Integer, Boolean> rEe = new HashMap(rEc.length);
    private HashMap<String, Integer> rEf = new HashMap(rEc.length);
    private TextView rEh;
    private EditText rEi;
    private ListView rEj;
    private LinearLayout rEk;
    private int rEl;
    private int rEm;
    private long rEn;
    private boolean rEo = false;
    private boolean rEp = false;
    q rEq = null;

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        snsNotInterestUI.rEm = 0;
        for (Integer intValue : snsNotInterestUI.rEe.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.rEe.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.rEm == 0) {
                    snsNotInterestUI.rEm = intValue2;
                } else {
                    snsNotInterestUI.rEm |= intValue2;
                }
            }
        }
        if (snsNotInterestUI.rEn != 0 && snsNotInterestUI.rEl != 0) {
            Context context = snsNotInterestUI.mController.xIM;
            snsNotInterestUI.getString(j.dGO);
            snsNotInterestUI.jmO = h.a(context, snsNotInterestUI.getString(j.dHc), true, new 4(snsNotInterestUI));
            x.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", Long.valueOf(snsNotInterestUI.rEn), Integer.valueOf(snsNotInterestUI.rEl), Integer.valueOf(snsNotInterestUI.rEm), Boolean.valueOf(snsNotInterestUI.rEp));
            snsNotInterestUI.rEq = new q(snsNotInterestUI.rEn, snsNotInterestUI.rEl, snsNotInterestUI.rEm, snsNotInterestUI.rEp ? snsNotInterestUI.rEi.getText().toString() : null);
            g.Dk();
            g.Di().gPJ.a(snsNotInterestUI.rEq, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rEl = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.rEn = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.rEn != 0) {
            String str = ae.bvv().eR(this.rEn).field_userName;
            if (str != null) {
                g.Dk();
                af WN = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WN(str);
                if (WN.fWf == 2) {
                    rEg[1] = j.qKH;
                } else if (WN.fWf == 1) {
                    rEg[1] = j.qKI;
                }
            }
        }
        g.Dk();
        g.Di().gPJ.a(218, (e) this);
        bBn();
        initView();
    }

    private void bBn() {
        int i = 0;
        for (Object put : rEb) {
            this.rEd.put(put, Boolean.valueOf(false));
        }
        for (int valueOf : rEc) {
            this.rEe.put(Integer.valueOf(valueOf), Boolean.valueOf(false));
        }
        while (i < rEc.length) {
            this.rEf.put(rEb[i], Integer.valueOf(rEc[i]));
            i++;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        bBn();
        g.Dk();
        g.Di().gPJ.b(218, (e) this);
        b geVar = new ge();
        geVar.fwl.fwm = this.rEo;
        geVar.fwl.fwn = this.rEn;
        a.xef.m(geVar);
    }

    protected final void initView() {
        super.initView();
        setMMTitle(j.qKM);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI rEr;

            {
                this.rEr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rEr.finish();
                return true;
            }
        });
        this.rEh = (TextView) findViewById(i.f.qEu);
        this.rEi = (EditText) findViewById(i.f.qEv);
        this.rEj = (ListView) findViewById(16908298);
        this.rEk = (LinearLayout) findViewById(i.f.qCd);
        this.rEk.setOnClickListener(new 2(this));
        this.rEi.setVisibility(8);
        this.rEh.setVisibility(8);
        this.jKn = this.yjd;
        if (this.jKn == null) {
            x.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.jKn.YN("sns_expose_desc") == null) {
                Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(j.qKA);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.jKn.a(preferenceTitleCategory);
            }
            for (int i = 0; i < rEb.length; i++) {
                String str = rEb[i];
                int i2 = rEg[i];
                if (this.jKn.YN(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i2);
                    preference.setKey(str);
                    preference.setLayoutResource(i.g.dnt);
                    preference.setWidgetLayoutResource(i.g.qGB);
                    this.jKn.a(preference);
                }
            }
        }
        a(0, getString(j.qJv), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI rEr;

            {
                this.rEr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.b(this.rEr);
                return true;
            }
        }, p.b.xJz);
        enableOptionMenu(0, false);
    }

    protected final int getLayoutId() {
        return i.g.qHm;
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference == null) {
            return false;
        }
        String str = preference.ibD;
        if (!this.rEd.containsKey(str)) {
            return false;
        }
        boolean z;
        boolean booleanValue = ((Boolean) this.rEd.get(str)).booleanValue();
        if (booleanValue) {
            preference.setWidgetLayoutResource(i.g.qGB);
        } else {
            preference.setWidgetLayoutResource(i.g.qGA);
        }
        fVar.notifyDataSetChanged();
        if (booleanValue) {
            z = false;
        } else {
            z = true;
        }
        this.rEd.put(str, Boolean.valueOf(z));
        this.rEe.put(Integer.valueOf(((Integer) this.rEf.get(str)).intValue()), Boolean.valueOf(z));
        x.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", str, Integer.valueOf(r0), Boolean.valueOf(z));
        for (Boolean booleanValue2 : this.rEd.values()) {
            if (booleanValue2.booleanValue()) {
                booleanValue = true;
                break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            enableOptionMenu(0, true);
        } else {
            enableOptionMenu(0, false);
        }
        if (z && str.equals("sns_expose_reason_other")) {
            this.rEi.setVisibility(0);
            this.rEh.setVisibility(0);
            this.rEi.requestFocus();
            this.rEp = true;
            showVKB();
        } else if (((Boolean) this.rEd.get("sns_expose_reason_other")).booleanValue()) {
            this.rEj.requestFocus();
            aWs();
        } else {
            this.rEi.setVisibility(8);
            this.rEh.setVisibility(8);
            this.rEj.requestFocus();
            this.rEp = false;
            aWs();
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (kVar.getType() == 218) {
            this.jmO.dismiss();
            this.jmO = null;
            if (((q) kVar).type != 9) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.rEo = true;
                Toast.makeText(this, j.qKL, 1).show();
                finish();
                return;
            }
            this.rEo = false;
            Toast.makeText(this, j.qKB, 1).show();
        }
    }
}
