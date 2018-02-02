package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements e {
    private f ilB;
    private String qjx;
    private a[] xRk;

    public final void a(int i, int i2, String str, k kVar) {
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
        return R.i.dbj;
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).xOk;
        if (aVar == null) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("voice_verify_language", aVar.xOl);
        bundle.putString("voice_verify_code", aVar.xOn);
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
        return true;
    }

    protected final void initView() {
        aWs();
        this.qjx = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle(R.l.dLK);
        setBackBtn(new 1(this));
        this.xRk = coe();
        if (this.xRk != null && this.xRk.length > 0) {
            this.ilB.removeAll();
            this.ilB.a(new PreferenceCategory(this));
            for (a aVar : this.xRk) {
                if (aVar.xOn.equalsIgnoreCase(this.qjx)) {
                    aVar.nuE = true;
                }
                Preference languagePreference = new LanguagePreference(this);
                languagePreference.a(aVar);
                languagePreference.setKey(aVar.xOn);
                this.ilB.a(languagePreference);
            }
        }
    }

    public static String YA(String str) {
        a[] coe = coe();
        String lH = b.lH(str);
        for (a aVar : coe) {
            if (aVar.xOn.equalsIgnoreCase(lH)) {
                return aVar.xOl;
            }
        }
        return "English";
    }

    private static a[] coe() {
        String[] split = ac.getContext().getString(R.l.dLH).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        return aVarArr;
    }
}
