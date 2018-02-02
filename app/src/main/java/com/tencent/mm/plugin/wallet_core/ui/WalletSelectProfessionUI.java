package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private f ilB;
    private Profession[] sIM = null;

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setMMTitle(i.uWE);
        this.ilB = this.yjd;
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this.mController.xIM);
        preferenceTitleCategory.setTitle(getString(i.uWD));
        preferenceTitleCategory.setKey("title_category");
        this.ilB.a(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.sIM = new Profession[parcelableArrayExtra.length];
            for (int i2 = 0; i2 < this.sIM.length; i2++) {
                this.sIM[i2] = (Profession) parcelableArrayExtra[i2];
            }
        }
        if (this.sIM != null) {
            Profession[] professionArr = this.sIM;
            int length = professionArr.length;
            int i3 = 0;
            while (i < length) {
                Profession profession = professionArr[i];
                if (!(profession == null || bh.ov(profession.sKd))) {
                    Preference preference = new Preference(this.mController.xIM);
                    preference.setTitle(profession.sKd);
                    preference.setKey("index_" + i3);
                    this.ilB.a(preference);
                }
                i3++;
                i++;
            }
        }
        setBackBtn(new 1(this));
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.startsWith("index_")) {
            String[] split = preference.ibD.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.sIM[bh.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                x.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", new Object[]{preference.ibD, preference.getTitle()});
                setResult(0);
            }
            finish();
        }
        return true;
    }
}
