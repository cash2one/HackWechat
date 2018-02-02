package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.l.a;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class i implements a {
    View kND;
    boolean kPn = false;
    TextView kUA;
    ImageView kUB;
    View kUw;
    TextView kUx;
    ImageView kUy;
    View kUz;
    MMActivity kaY;

    public i(MMActivity mMActivity, View view) {
        this.kaY = mMActivity;
        this.kND = view;
    }

    public final void a(g gVar) {
        awd();
    }

    public final void asi() {
    }

    final void awd() {
        if (am.auE().kJG <= 0 || !this.kPn) {
            this.kUw.setVisibility(8);
            if (this.kUz != null) {
                this.kUz.setVisibility(8);
                return;
            }
            return;
        }
        ar.Hg();
        String str = (String) c.CU().get(w.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
        ar.Hg();
        String str2 = (String) c.CU().get(w.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
        int dimensionPixelOffset = this.kaY.getResources().getDimensionPixelOffset(R.f.bwo);
        if (TextUtils.isEmpty(str2)) {
            this.kUy.setImageResource(R.g.bAs);
        } else {
            m.a(this.kUy, str2, dimensionPixelOffset, R.g.bAs, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.kUx.setText(this.kaY.getString(R.l.dOq, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.kUx.setText(str);
        }
        this.kUw.setVisibility(0);
        if (this.kUz != null) {
            if (TextUtils.isEmpty(str2)) {
                this.kUB.setImageResource(R.g.bAs);
            } else {
                m.a(this.kUB, str2, dimensionPixelOffset, R.g.bAs, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.kUA.setText(this.kaY.getString(R.l.dOq, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.kUA.setText(str);
            }
            this.kUz.setVisibility(0);
        }
    }
}
