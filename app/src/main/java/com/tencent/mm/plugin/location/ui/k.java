package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.VolumeMeter.1;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.q.n;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public final class k implements e, o {
    private Activity activity;
    private List<String> fAN = new LinkedList();
    boolean nUA = false;
    int nUB = 0;
    private long nUC = 500;
    long nUD = 0;
    ak nUE = new ak(new 1(this), false);
    ak nUF = new ak(new 2(this), false);
    private ak nUG = new ak(new 3(this), false);
    public n nUH;
    public a nUI;
    final ak nUJ = new ak(new 5(this), true);
    private boolean nUK = true;
    Button nUt;
    public VolumeMeter nUu;
    RelativeLayout nUv;
    private boolean nUw = true;
    private String nUx;
    String nUy;
    private String nUz;

    static /* synthetic */ void a(k kVar) {
        if (kVar.nUB == 5) {
            kVar.nUB = 3;
            kVar.nUH.bEy();
            kVar.nUJ.J(100, 100);
        }
    }

    public k(Activity activity, Button button) {
        this.activity = activity;
        this.nUt = button;
        this.nUv = (RelativeLayout) this.activity.findViewById(R.h.cYu);
        this.nUv.setVisibility(8);
        this.nUu = (VolumeMeter) this.nUv.findViewById(R.h.cYv);
        this.nUu.nVo = this.nUt;
        VolumeMeter volumeMeter = this.nUu;
        if (volumeMeter.nVr == null) {
            com.tencent.mm.sdk.f.e.d(new 1(volumeMeter), "VolumeMeter_handler", 1).start();
        }
        this.nUH = a.vcq;
        if (this.nUH == null) {
            x.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
    }

    public final void aVX() {
        this.nUz = this.activity.getIntent().getStringExtra("map_talker_name");
        this.nUH.a(this);
        x.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[]{this.nUz});
        String str = this.nUz;
        this.nUx = str;
        if (!bh.ov(this.nUx)) {
            if (s.eV(str)) {
                List gj = m.gj(str);
                if (gj == null) {
                    com.tencent.mm.z.ak.a.hfL.Q(str, "");
                } else {
                    this.fAN = gj;
                }
            } else {
                this.fAN.clear();
                this.fAN.add(str);
                this.fAN.add(q.FS());
            }
            new af(Looper.getMainLooper()).post(new 6(this, str));
            this.nUt.setOnTouchListener(new 7(this));
        }
    }

    final void aVY() {
        if (this.nUB == 5) {
            this.nUE.TG();
            aVZ();
            ar.b(ac.getContext(), R.l.eQR, new ar.a(this) {
                final /* synthetic */ k nUL;

                {
                    this.nUL = r1;
                }

                public final void vh() {
                    this.nUL.nUF.TG();
                    k.a(this.nUL);
                }
            });
            this.nUF.J(1000, 1000);
        }
    }

    final void aVZ() {
        if (!this.nUw) {
            if (a.vcq.bEX()) {
                x.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
                if (this.nUI != null) {
                    this.nUI.DK(null);
                    this.nUI.aVV();
                }
            }
            switch (this.nUB) {
                case 0:
                    x.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[]{this.nUy});
                    if (this.nUI == null) {
                        return;
                    }
                    if (bh.ov(this.nUy)) {
                        this.nUI.DK(null);
                        return;
                    } else {
                        this.nUI.DK(this.nUy);
                        return;
                    }
                case 1:
                    x.d("MicroMsg.TalkMgr", "seize, state seizing");
                    if (this.nUI != null) {
                        this.nUI.aVW();
                        return;
                    }
                    return;
                case 2:
                    x.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[]{this.nUy});
                    if (this.nUI != null && !bh.ov(this.nUy)) {
                        this.nUI.DL(this.nUy);
                        return;
                    }
                    return;
                case 3:
                case 5:
                    x.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                    if (this.nUI != null) {
                        this.nUI.aVU();
                        return;
                    }
                    return;
                case 4:
                    x.d("MicroMsg.TalkMgr", "seize time out");
                    return;
                default:
                    return;
            }
        }
    }

    public static void aWa() {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        f.xG().setMode(0);
    }

    public final void aWb() {
        this.nUw = false;
        this.nUt.setEnabled(true);
        aVZ();
    }

    public final void J(String str, int i, int i2) {
        x.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[]{str});
        l.aVu().rM(3);
        this.activity.finish();
    }

    public final void aWc() {
        if (this.nUB == 1) {
            this.nUB = 5;
            if (bh.bA(this.nUD) < this.nUC) {
                x.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
                long bA = this.nUC - bh.bA(this.nUD);
                this.nUE.J(bA, bA);
                return;
            }
            aVY();
        }
    }

    public final void rN(int i) {
        x.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
        if (i == 340) {
            if (this.nUB == 3) {
                this.nUB = 4;
            } else {
                return;
            }
        } else if (this.nUB == 1) {
            this.nUB = 2;
        } else {
            return;
        }
        aVZ();
        ar.a(ac.getContext(), R.l.eQU, null);
    }

    public final void DM(String str) {
        x.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[]{str});
        this.nUy = str;
        aVZ();
        if (bh.ov(str)) {
            this.nUJ.TG();
            return;
        }
        ar.H(ac.getContext(), R.l.eQS);
        this.nUJ.J(100, 100);
    }

    public final void df(String str, String str2) {
        x.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[]{str, str2});
        if (!this.nUw) {
        }
    }

    public final void j(int i, int i2, String str) {
    }

    public final void aWd() {
    }

    public final void aWe() {
        aVZ();
    }

    public final void aWf() {
        aVZ();
    }

    public final void aWg() {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
    }
}
