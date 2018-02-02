package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class UnfamiliarContactDetailUI$c extends t {
    View VU;
    MaskLayout ldx;
    CheckBox mSc;
    final /* synthetic */ UnfamiliarContactDetailUI qma;
    TextView qmh;
    TextView qmi;
    ImageView qmj;
    ImageView qmk;
    LinearLayout qml;
    LinearLayout qmm;

    static /* synthetic */ void a(UnfamiliarContactDetailUI$c unfamiliarContactDetailUI$c, b bVar, int i) {
        if (bVar != null) {
            if (UnfamiliarContactDetailUI.a(unfamiliarContactDetailUI$c.qma)) {
                f.qmC++;
            } else {
                f.qmD++;
            }
            String str = bVar.gBL;
            String str2 = bVar.jLe.field_username;
            String str3 = bVar.jLe.field_nickname;
            if (bh.ov(str)) {
                ar.Hg();
                bf EZ = c.EZ().EZ(str2);
                if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                    str = EZ.field_conRemark;
                }
            }
            if (!bh.ov(str2)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.putExtra("Contact_RemarkName", str);
                intent.putExtra("Contact_Nick", str3);
                a.ifs.d(intent, unfamiliarContactDetailUI$c.qma);
                UnfamiliarContactDetailUI.a(unfamiliarContactDetailUI$c.qma, i);
            }
        }
    }

    public UnfamiliarContactDetailUI$c(UnfamiliarContactDetailUI unfamiliarContactDetailUI, View view) {
        this.qma = unfamiliarContactDetailUI;
        super(view);
        this.VU = view;
        this.ldx = (MaskLayout) view.findViewById(R.h.bXd);
        this.qmh = (TextView) view.findViewById(R.h.bYl);
        this.qmi = (TextView) view.findViewById(R.h.bXc);
        this.qmj = (ImageView) view.findViewById(R.h.bYs);
        this.qmk = (ImageView) view.findViewById(R.h.bYt);
        this.qml = (LinearLayout) view.findViewById(R.h.bVZ);
        this.mSc = (CheckBox) view.findViewById(R.h.checkbox);
        this.qmm = (LinearLayout) view.findViewById(R.h.crs);
        this.qml.setOnClickListener(new 1(this, unfamiliarContactDetailUI));
        view.setOnClickListener(new 2(this, unfamiliarContactDetailUI));
    }
}
