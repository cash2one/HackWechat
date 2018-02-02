package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ay.e;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ak.d;
import com.tencent.mm.z.ar;

public final class ae {
    public p fhr;
    public boolean kCV = false;
    public d rYQ = new 1(this);
    public View yCH = null;
    public c yCI = new 2(this);
    public com.tencent.mm.ui.chatting.d ysR = null;

    public ae(p pVar) {
        this.fhr = pVar;
    }

    public final boolean AI() {
        if (this.fhr.csf()) {
            if (this.fhr.csg()) {
                return this.fhr.cso().ho(1);
            }
            return this.fhr.csp().ho(1);
        } else if ((this.fhr.csd() && this.fhr.csi().fWn == 0) || this.fhr.csi().AI()) {
            return true;
        } else {
            return false;
        }
    }

    public final void cuf() {
        if (this.fhr.csm()) {
            x.d("MicroMsg.ChattingUI.VoiceImp", "trigger title icon, in show mode");
            this.fhr.csq().showOptionMenu(2, false);
            this.fhr.csq().setTitlePhoneIconVisibility(8);
            this.fhr.csq().setTitleMuteIconVisibility(8);
            return;
        }
        int i;
        if (AI()) {
            this.fhr.csq().setTitleMuteIconVisibility(0);
        } else {
            this.fhr.csq().setTitleMuteIconVisibility(8);
        }
        ar.Hg();
        Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(26, null);
        if (bool == null) {
            this.kCV = false;
        } else {
            this.kCV = bool.booleanValue();
        }
        u csq = this.fhr.csq();
        if (this.kCV) {
            i = 0;
        } else {
            i = 8;
        }
        csq.setTitlePhoneIconVisibility(i);
    }

    public final void releaseWakeLock() {
        this.fhr.csx().setKeepScreenOn(false);
    }

    public final void mQ(boolean z) {
        if (this.ysR == null) {
            x.e("MicroMsg.ChattingUI.VoiceImp", "setForceSpeakOff error, autoPlay is null!!!");
        } else if (z) {
            this.ysR.kCS = false;
            this.kCV = true;
            ar.Hg();
            com.tencent.mm.z.c.CU().set(26, Boolean.valueOf(true));
            this.fhr.csq().setTitlePhoneIconVisibility(0);
            this.fhr.cri();
            Toast.makeText(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.ejb), 0).show();
            this.ysR.crg();
            this.fhr.csq().updateOptionMenuIcon(2, R.k.duQ);
        } else {
            if (ar.Hh().xL()) {
                x.i("MicroMsg.ChattingUI.VoiceImp", "setForceSpeakOff true but isBluetoothOn");
            } else {
                this.ysR.kCS = true;
            }
            this.kCV = false;
            ar.Hg();
            com.tencent.mm.z.c.CU().set(26, Boolean.valueOf(false));
            this.fhr.csq().setTitlePhoneIconVisibility(8);
            this.fhr.cri();
            Toast.makeText(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.ejc), 0).show();
            this.ysR.crg();
            this.fhr.csq().updateOptionMenuIcon(2, R.k.duX);
        }
    }

    public final boolean aP(au auVar) {
        if (!auVar.ciW()) {
            return false;
        }
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            if (auVar.field_msgId == this.ysR.yqm) {
                this.ysR.crh();
            }
            if (!this.fhr.csi().field_username.equals("medianote")) {
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new e(auVar.field_talker, auVar.field_msgSvrId));
            }
            af.aD(auVar);
            return true;
        }
        com.tencent.mm.ui.base.u.fI(this.fhr.csq().getContext());
        return true;
    }
}
