package com.tencent.mm.ui.chatting.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bh;

public final class j {
    public p fhr;
    public c ywd;
    public n ywe;
    public boolean yzM = false;
    public boolean yzN = false;
    public String yzO;
    public String yzP;
    public int yzQ = a.yzR;

    public j(p pVar) {
        this.fhr = pVar;
    }

    public final void ctB() {
        if (this.fhr.csi() != null) {
            ChatFooter csB;
            if (!bh.ov(this.yzO) && this.fhr.csB() != null) {
                boolean z = this.fhr.csB().vql == 1 && bh.ov(this.ywe.yAi);
                if (!z) {
                    ctC();
                } else if (this.fhr.csB() != null) {
                    csB = this.fhr.csB();
                    csB.showVKB();
                    csB.lh(true);
                }
                if (this.fhr.csd() && this.yzM) {
                    this.yzM = false;
                    String str = this.fhr.csB().vqg.vrf;
                    if (!bh.ov(str)) {
                        int i = this.fhr.csB().vqg.vrg;
                        if (i > this.yzO.length()) {
                            i = this.yzO.length();
                        }
                        String str2 = this.yzO.substring(0, i) + str + ' ' + this.yzO.substring(i, this.yzO.length());
                        i = (i + str.length()) + 1;
                        this.fhr.csB().Sx(str2);
                        this.fhr.csB().p(str2, i, false);
                        this.fhr.csB().Sw(null);
                        this.fhr.csq().showVKB();
                    }
                } else {
                    this.fhr.csB().Sx(this.yzO);
                    this.fhr.csB().Sy(this.yzO);
                    if (!bh.ov(this.yzO) && bh.ov(this.ywe.yAi)) {
                        this.ywe.ctO();
                    }
                }
                this.ywe.ctJ();
            } else if (this.fhr.csB() == null) {
            } else {
                if (this.fhr.csl()) {
                    this.fhr.csB().Sy(this.yzO);
                    csB = this.fhr.csB();
                    CharSequence mMString = this.fhr.csq().getMMString(R.l.dTo);
                    if (csB.okv != null) {
                        csB.okv.setHint(mMString);
                    }
                } else if (this.fhr.csB().vlJ) {
                    this.ywe.ctJ();
                } else {
                    ctC();
                }
            }
        }
    }

    private void ctC() {
        if (this.fhr.csB() != null) {
            boolean z = this.yzQ == a.yzS;
            View csB = this.fhr.csB();
            bh.hideVKB(csB);
            csB.lh(z);
        }
    }
}
