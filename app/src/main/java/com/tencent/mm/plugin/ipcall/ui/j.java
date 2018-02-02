package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.b.d.1;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class j implements a, e {
    ImageView ihQ;
    TextView ihV;
    DialPad nHd;
    String nJA;
    String nJB;
    String nJC;
    int nJD;
    int nJE;
    String nJz;
    Bitmap nNC;
    EditText nNL;
    TextView nNM;
    ImageView nNN;
    IPCallFuncButton nNO;
    IPCallFuncButton nNP;
    IPCallFuncButton nNQ;
    ImageButton nNR;
    public TextView nNS;
    public View nNT;
    ImageButton nNU;
    int nNV = -1;
    String nNW;
    IPCallTalkUI nNX;
    c nNY;
    a nNZ;
    private long nOa;
    long nOb = -1;
    boolean nOc = false;
    boolean nOd = false;
    private AudioManager nOe = null;
    boolean nOf = false;
    private boolean nOg = true;
    boolean nOh = false;
    String nlp;

    static /* synthetic */ void b(j jVar) {
        jVar.nNY.cI(0, 0);
        ar.getNotification().cancel(42);
        jVar.nNX.finish();
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        this.nNX = iPCallTalkUI;
        this.nNY = i.aTC();
        this.nNY.nBY = this;
    }

    private void d(String str, String str2, int i, String str3) {
        String str4;
        aUI();
        if (!bh.ov(str)) {
            str4 = str;
        } else if (bh.ov(str3)) {
            str4 = this.nNX.getString(R.l.eqx);
        } else {
            str4 = str3;
        }
        if (2 == i && str2 != null) {
            this.ihV.setText(str2);
        } else if (1 == i && str2 != null) {
            h.a(this.nNX, str2, str4, this.nNX.getString(R.l.eqy), false, new 7(this));
        }
    }

    final void aUG() {
        i.aTA().fmM = this.nNX;
        Object aTA = i.aTA();
        aTA.nEm.nED = aTA;
        d dVar = aTA.nEm;
        if (!dVar.kCP.xic) {
            dVar.kCP.a(dVar);
            if (dVar.kCT.O(new 1(dVar))) {
                dVar.kCU = 0;
            } else {
                dVar.kCU = -1;
            }
        }
        i.aTA().nEq = this;
        i.aTA().a(this);
    }

    final void aUH() {
        this.nNL.setKeyListener(null);
        this.nNL.setHorizontallyScrolling(true);
        this.nHd.setVisibility(4);
        DialPad dialPad = this.nHd;
        dialPad.nGV = true;
        for (DialNumberButton gc : dialPad.nGY.values()) {
            gc.gc(true);
        }
        for (View view : dialPad.nHa.values()) {
            if (dialPad.nGV) {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.btW));
            } else {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.bsb));
            }
        }
        if (!bh.ov(this.nNW)) {
            CY(this.nNW);
        }
        if (com.tencent.mm.compatible.util.d.fM(16)) {
            this.nNL.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nNM.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!bh.ov(this.nJA)) {
            this.nNC = com.tencent.mm.plugin.ipcall.b.a.f(this.nNX, this.nJA, true);
        }
        if (this.nNC == null && !bh.ov(this.nJz) && com.tencent.mm.plugin.ipcall.b.a.NQ()) {
            this.nNC = com.tencent.mm.plugin.ipcall.b.a.ao(this.nNX, this.nJz);
        }
        if (this.nNC == null && !bh.ov(this.nJC)) {
            this.nNC = b.c(this.nJC, 480, 480, 4);
        }
        if (this.nNC == null) {
            this.nNN.setVisibility(0);
            this.ihQ.setVisibility(8);
        }
        if (this.nNC != null) {
            this.nNN.setVisibility(8);
            this.ihQ.setVisibility(0);
            this.ihQ.setImageBitmap(this.nNC);
        }
        this.nNU.setOnClickListener(new 8(this));
        this.nNQ.nKD = new 9(this);
        this.nNO.nKD = new 10(this);
        this.nNP.nKD = new 11(this);
        this.nNR.setOnClickListener(new 12(this));
        this.nHd.nHb = new DialPad.a(this) {
            final /* synthetic */ j nOi;

            {
                this.nOi = r1;
            }

            public final void CI(String str) {
                String obj = this.nOi.nNL.getText().toString();
                if (bh.ov(obj)) {
                    this.nOi.nOb = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.nOi.nOb >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                this.nOi.nOb = currentTimeMillis;
                this.nOi.cY(obj, "");
                c.Cz(str);
                g.pQN.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }

            public final void CJ(String str) {
            }
        };
    }

    final void CY(String str) {
        if (bh.ov(this.nlp)) {
            cY(com.tencent.mm.plugin.ipcall.b.a.Di(str), "");
        } else {
            cY(this.nlp, com.tencent.mm.plugin.ipcall.b.a.Di(str));
        }
    }

    final void cY(String str, String str2) {
        this.nNL.setText(str);
        if (!bh.ov(str)) {
            this.nNL.setSelection(this.nNL.getText().length() - 1);
        }
        this.nNM.setText(str2);
    }

    public final void rG(int i) {
        switch (i) {
            case 3:
                int i2 = i.aTx().nCP.nDN;
                Context context = ac.getContext();
                r0 = ((i2 & 1) <= 0 || (i2 & 2) > 0) ? (i2 & 8) > 0 ? context.getString(R.l.esm) + " " : "" : context.getString(R.l.esl) + " ";
                if (this.nNV != -1) {
                    String rH = com.tencent.mm.plugin.ipcall.b.a.rH(this.nNV);
                    this.ihV.setText(r0 + this.nNX.getString(R.l.err, new Object[]{rH}));
                    return;
                }
                this.ihV.setText(r0 + this.nNX.getString(R.l.erq));
                return;
            case 5:
                this.ihV.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.nOa / 60), Long.valueOf(this.nOa % 60)}));
                return;
            case 10:
                this.ihV.setText(R.l.ert);
                return;
            default:
                return;
        }
    }

    public final void aSP() {
        int i = 0;
        x.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.aTx().nCP.nDZ;
        String str2 = i.aTx().nCP.nEa;
        if (!(bh.ov(str) || bh.ov(str2) || str.equals(str2))) {
            x.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[]{str, str2});
            CY(str2);
        }
        x.i("MicroMsg.TalkUIController", "callFlag:" + i.aTx().nCP.nDN);
        int i2 = i.aTx().nCP.nDN;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.TalkUIController", "isNotFree");
            h.a(this.nNX, R.l.erz, R.l.erA, R.l.ery, R.l.erx, true, null, new 3(this));
        }
        rG(3);
    }

    public final void aSQ() {
        x.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.aTB().aTs()) {
            this.nOc = this.nNQ.isChecked();
            this.nOd = this.nNQ.isChecked();
            i.aTA().fW(this.nNQ.isChecked());
        }
    }

    public final void aTe() {
        x.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.aTB().aTs()) {
            this.nOc = this.nNQ.isChecked();
            this.nOd = this.nNQ.isChecked();
            i.aTA().fW(this.nNQ.isChecked());
        }
        if (i.aTB().aTt()) {
            i.aTA().nEl.setMute(this.nNO.isChecked());
        }
    }

    public final void aTf() {
        x.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        aUI();
        rG(10);
        ar.getNotification().cancel(42);
        if (this.nNZ != null) {
            this.nNZ.gh(true);
        }
    }

    public final void d(int i, String str, String str2, int i2) {
        x.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == 1) {
            this.nOg = false;
        }
        if (i == 8) {
            if (i2 == 1) {
                String string;
                if (bh.ov(str)) {
                    string = this.nNX.getString(R.l.eqx);
                } else {
                    string = str;
                }
                h.a(this.nNX, str2, string, this.nNX.getString(R.l.eqy), false, new 4(this));
            } else {
                d(str, str2, i2, this.nNX.getString(R.l.eqw));
            }
        } else if (i != 10) {
            d(str, str2, i2, null);
        } else {
            d(str, str2, i2, null);
        }
        ar.getNotification().cancel(42);
        if (this.nNZ != null && !this.nOh) {
            this.nNZ.gh(this.nOg);
        }
    }

    public final void fZ(boolean z) {
        x.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aTB().aTs()) {
            return;
        }
        if (z) {
            i.aTA();
            this.nOc = com.tencent.mm.plugin.ipcall.a.b.a.xQ();
            i.aTA().fW(false);
            this.nNQ.ge(false);
            return;
        }
        i.aTA().fW(this.nOc);
        this.nNQ.ge(true);
        this.nNQ.setChecked(this.nOc);
    }

    public final void ga(boolean z) {
        x.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aTB().aTs()) {
            return;
        }
        if (z) {
            i.aTA();
            this.nOd = com.tencent.mm.plugin.ipcall.a.b.a.xQ();
            i.aTA().fW(false);
            this.nNQ.ge(false);
            return;
        }
        i.aTA().fW(this.nOd);
        this.nNQ.ge(true);
        this.nNQ.setChecked(this.nOd);
    }

    public final void aTh() {
        this.nOa = (long) i.aTC().aTa();
        rG(5);
    }

    public final void aTg() {
        this.nNX.finish();
    }

    public final void aUI() {
        if (this.nNS != null) {
            this.nNS.setVisibility(4);
        }
        if (this.nNT != null) {
            this.nNT.setVisibility(4);
        }
    }
}
