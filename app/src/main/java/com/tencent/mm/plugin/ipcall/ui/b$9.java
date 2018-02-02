package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bh;

class b$9 implements TextWatcher {
    final /* synthetic */ b nHy;

    b$9(b bVar) {
        this.nHy = bVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence Dm = bh.Dm(charSequence.toString());
        if (Dm.contains(" ")) {
            Dm = Dm.replace(" ", "");
            this.nHy.nHf.setText(bh.N(Dm));
        } else if ((!this.nHy.nHx.equals(Dm) || i3 > 0) && bh.ov(Dm)) {
            this.nHy.nHx = Dm;
            this.nHy.nHf.setText("");
        }
        if (a.Dg(Dm)) {
            String De = a.De(Dm);
            if (!bh.ov(De)) {
                this.nHy.nHe.setText("+" + De);
                this.nHy.nHf.setText(a.Dj(Dm));
            }
        } else if (!Dm.equals(this.nHy.nHx)) {
            this.nHy.nHx = Dm;
            this.nHy.nHf.setText(Dm);
            if (bh.ov(this.nHy.nHe.getText().toString())) {
                this.nHy.nHe.setText("+" + a.aUL());
            }
        }
        if (this.nHy.nHc != null) {
            this.nHy.nHc.CM(this.nHy.nHf.getText().toString());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
