package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    ToneGenerator kEa;
    long kEb = -1;
    Toast kEc;
    private Vibrator kEd;
    final ak kEu = new ak(new 1(this), true);
    final ak kEv = new ak(new 4(this), true);
    private final a kEy = new 2(this);
    MassSendMsgUI ond;
    ChatFooter one;
    a onf;
    private String ong;
    private List<String> onh;
    private boolean oni;
    private final com.tencent.mm.ae.h.b onj = new 3(this);
    r tipDialog = null;

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        this.ond = massSendMsgUI;
        this.one = chatFooter;
        this.ong = str;
        this.onh = list;
        this.oni = z;
        this.onf = new a(this, massSendMsgUI);
        this.onf.a(this.kEy);
        this.onf.a(this.onj);
        this.kEa = new ToneGenerator(1, 60);
        this.kEd = (Vibrator) massSendMsgUI.getSystemService("vibrator");
    }

    public final boolean aYF() {
        this.kEu.TG();
        this.kEv.TG();
        this.kEb = -1;
        if (this.onf.vo()) {
            aYG();
            this.one.aJO();
        } else {
            this.one.cbr();
        }
        ar.ux().wA();
        return false;
    }

    final void aYG() {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.omN = this.ong;
        aVar.omO = this.onh.size();
        aVar.filename = this.onf.fileName;
        aVar.msgType = 34;
        aVar.omP = this.onf.flB;
        k fVar = new f(aVar, this.oni);
        ar.CG().a(fVar, 0);
        Context context = this.ond;
        this.ond.getString(R.l.dGO);
        this.tipDialog = h.a(context, this.ond.getString(R.l.eKe), true, new 5(this, fVar));
    }

    public final boolean aYH() {
        this.kEu.TG();
        this.kEv.TG();
        this.kEb = -1;
        this.one.aJO();
        a aVar = this.onf;
        aVar.vo();
        q.nZ(aVar.fileName);
        ar.ux().wA();
        return false;
    }

    public final boolean aYI() {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            this.kEa.startTone(24);
            new af().postDelayed(new 6(this), 200);
            this.kEd.vibrate(50);
            this.kEu.J(100, 100);
            this.kEv.J(200, 200);
            this.one.Cj(this.ond.getResources().getDisplayMetrics().heightPixels - this.one.getHeight());
            this.onf.cJ("_USER_FOR_THROWBOTTLE_");
            this.onf.a(this.onj);
            this.onf.a(this.kEy);
            ar.ux().wB();
        } else {
            u.fI(this.ond);
        }
        return false;
    }

    public final boolean Eg(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        MassSendMsgUI.Ek(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.omN = this.ong;
        aVar.omO = this.onh.size();
        aVar.filename = str;
        aVar.msgType = 1;
        k fVar = new f(aVar, this.oni);
        ar.CG().a(fVar, 0);
        Context context = this.ond;
        this.ond.getString(R.l.dGO);
        this.tipDialog = h.a(context, this.ond.getString(R.l.eKe), true, new 7(this, fVar));
        return true;
    }

    public final void aYJ() {
    }

    public final void aYK() {
    }

    public final void aYL() {
    }

    public final void release() {
        this.kEa.release();
    }

    public final void onPause() {
        this.kEu.TG();
        this.kEv.TG();
        this.kEb = -1;
        this.onf.vo();
        ar.ux().wA();
    }

    public final void gx(boolean z) {
    }
}
