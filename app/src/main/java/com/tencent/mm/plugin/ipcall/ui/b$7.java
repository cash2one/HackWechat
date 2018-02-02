package com.tencent.mm.plugin.ipcall.ui;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

class b$7 implements OnClickListener {
    final /* synthetic */ b nHy;

    b$7(b bVar) {
        this.nHy = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.nHy;
        bVar.nHn = bVar.nHe.getText().toString();
        bVar.nHo = bVar.nHf.getText().toString();
        String string;
        if (bh.ov(bVar.nHn) || bh.ov(bVar.nHo)) {
            string = ac.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bh.ov(string)) {
                bVar.nHo = bVar.cW(bVar.nHe.getText().toString().replace("+", ""), c.Dm(string));
                bVar.bv(bVar.nHo, -1);
                bVar.aUl();
                return;
            }
            return;
        }
        bVar.nHn = bVar.nHe.getText().toString().replace("+", "");
        bVar.nHp = a.ak(bVar.fmM, bVar.nHn + bVar.nHo);
        bVar.hgM = a.am(bVar.fmM, bVar.nHp);
        string = c.Dm(bVar.nHo);
        Editor edit = ac.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
        edit.putString("IPCall_LastInputPhoneNumber", string);
        edit.apply();
        String charSequence = bVar.nHe.getText().toString();
        string = bVar.nHm;
        if (!bh.ov(charSequence)) {
            if (bh.ov(string)) {
                string = "";
            }
            Editor edit2 = ac.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
            edit2.putString("IPCall_LastInputCountryName", string);
            edit2.apply();
        }
        if (bVar.nHc != null) {
            bVar.nHc.i(bVar.nHn, c.Dm(bVar.nHo), bVar.nHp, bVar.hgM);
        }
    }
}
