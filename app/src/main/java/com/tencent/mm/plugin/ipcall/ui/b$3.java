package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class b$3 implements DialPad$a {
    final /* synthetic */ b nHy;

    b$3(b bVar) {
        this.nHy = bVar;
    }

    public final void CI(String str) {
        this.nHy.nHo = this.nHy.nHf.getText().toString();
        if (this.nHy.nHs) {
            this.nHy.nHn += str;
            this.nHy.nHe.setText(this.nHy.nHn);
            if (a.Df(this.nHy.nHn.replace("+", "")) || this.nHy.nHn.replace("+", "").length() >= 4) {
                g.pQN.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                this.nHy.nHs = false;
                this.nHy.nHm = a.Dc(this.nHy.nHn.replace("+", ""));
                this.nHy.nHo = this.nHy.cW(this.nHy.nHn.replace("+", ""), this.nHy.nHo);
                this.nHy.bv(this.nHy.nHo, -1);
                return;
            }
            return;
        }
        String replace = this.nHy.nHe.getText().toString().replace("+", "");
        if (this.nHy.nHv) {
            StringBuffer stringBuffer = new StringBuffer(this.nHy.nHo);
            stringBuffer.insert(this.nHy.nHf.getSelectionStart(), str);
            this.nHy.nHo = stringBuffer.toString();
        } else {
            this.nHy.nHo += str;
        }
        if (this.nHy.nHo.equals("00")) {
            this.nHy.nHe.setText("+");
            this.nHy.nHs = true;
            this.nHy.nHn = "+";
            this.nHy.nHo = "";
        }
        if (a.Df(this.nHy.nHn.replace("+", "") + this.nHy.nHo)) {
            this.nHy.nHe.setText("+" + this.nHy.nHn.replace("+", "") + this.nHy.nHo);
            this.nHy.nHm = a.Dc(this.nHy.nHn.replace("+", ""));
            this.nHy.nHs = false;
            this.nHy.nHn = this.nHy.nHn.replace("+", "") + this.nHy.nHo;
            this.nHy.nHo = "";
        }
        String str2 = this.nHy.nHo;
        this.nHy.nHo = this.nHy.cW(replace, this.nHy.nHo);
        if (!this.nHy.nHv) {
            this.nHy.bv(this.nHy.nHo, -1);
        } else if (str2.length() < this.nHy.nHo.length()) {
            this.nHy.bv(this.nHy.nHo, this.nHy.nHf.getSelectionEnd() + 2);
        } else if (str2.length() == this.nHy.nHo.length()) {
            this.nHy.bv(this.nHy.nHo, this.nHy.nHf.getSelectionEnd() + 1);
        } else if (str2.length() > this.nHy.nHo.length()) {
            this.nHy.bv(this.nHy.nHo, (this.nHy.nHf.getSelectionEnd() + 1) - (str2.length() - this.nHy.nHo.length()));
        }
        this.nHy.nHr = System.currentTimeMillis();
        if (this.nHy.nHo.length() > a.nOj && !bh.ov(this.nHy.nHn + this.nHy.nHo)) {
            this.nHy.aUl();
        }
    }

    public final void CJ(String str) {
        if (str.equals("0")) {
            this.nHy.nHe.setText("+");
            this.nHy.nHs = true;
            this.nHy.nHn = "+";
        }
    }
}
