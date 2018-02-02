package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f ilB;

    protected final boolean XA() {
        return false;
    }

    public final int getLayoutId() {
        return R.i.dsz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XB() {
        return R.o.fcy;
    }

    protected final void initView() {
        setMMTitle(R.l.eJX);
        this.ilB = this.yjd;
        setBackBtn(new 1(this));
        ((IconPreference) this.ilB.YN("share_micromsg_to_sina")).drawable = a.b(this, R.g.bGd);
        ar.Hg();
        c.Fg().EY("@t.qq.com");
        ar.Hg();
        IconPreference iconPreference = (IconPreference) this.ilB.YN("share_micromsg_qzone");
        if ((bh.e((Integer) c.CU().get(9, null)) != 0 ? 1 : null) == null) {
            this.ilB.c(iconPreference);
        } else {
            iconPreference.drawable = a.b(this, R.g.bFH);
        }
        iconPreference = (IconPreference) this.ilB.YN("share_micromsg_to_fuckbook");
        if (q.Gr()) {
            iconPreference.drawable = a.b(this, R.g.bGc);
        } else {
            this.ilB.c(iconPreference);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            ar.Hg();
            if (bh.e((Integer) c.CU().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                h.h(this, R.l.eJH, R.l.dGO);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        return false;
    }
}
