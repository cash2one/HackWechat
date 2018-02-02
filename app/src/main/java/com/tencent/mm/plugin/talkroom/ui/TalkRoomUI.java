package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements e, o {
    private List<String> fAN = new LinkedList();
    private TextView ihS;
    private r ilH;
    private TextView nLo;
    private boolean nUA = false;
    private int nUB = 0;
    private long nUC = 500;
    private long nUD = 0;
    private ak nUE = new ak(new 5(this), false);
    private ak nUF = new ak(new 1(this), false);
    private ak nUG = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ TalkRoomUI scT;

        {
            this.scT = r1;
        }

        public final boolean uF() {
            this.scT.aVZ();
            return false;
        }
    }, false);
    private final ak nUJ = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ TalkRoomUI scT;

        {
            this.scT = r1;
        }

        public final boolean uF() {
            short bEV;
            int i = 15;
            int i2 = 0;
            if (this.scT.nUB == 3) {
                bEV = b.bEC().bEV();
            } else if (bh.ov(this.scT.nUy)) {
                this.scT.bFc();
                return false;
            } else {
                bEV = b.bEC().bEW();
            }
            if (bEV <= (short) 15) {
                if (!this.scT.scL) {
                    i = 0;
                }
                this.scT.scM = this.scT.scM + 1;
                if (this.scT.scM >= 5) {
                    boolean z;
                    TalkRoomUI talkRoomUI = this.scT;
                    if (this.scT.scL) {
                        z = false;
                    } else {
                        z = true;
                    }
                    talkRoomUI.scL = z;
                    this.scT.scM = 0;
                }
            } else {
                short s = bEV;
            }
            this.scT.bFc();
            com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter.a aVar = this.scT.scI.scY;
            if (i >= 0) {
                i2 = i > aVar.max ? aVar.max : i;
            }
            aVar.value = i2;
            aVar.sdp = aVar.sde - ((aVar.sde - aVar.sdd) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
            return true;
        }
    }, true);
    private boolean nUK = true;
    private Chronometer nUP;
    private int nUQ = 0;
    private boolean nUw = true;
    private String nUx;
    private String nUy;
    private float nVD = -1.0f;
    private TextView scE;
    private ImageButton scF;
    private Button scG;
    private ImageView scH;
    private TalkRoomVolumeMeter scI;
    private TalkRoomAvatarsFrame scJ;
    private a scK;
    private boolean scL = true;
    private int scM = 0;
    private AlphaAnimation scN;
    private AlphaAnimation scO;
    private AlphaAnimation scP;
    private AlphaAnimation scQ;
    private float scR = -1.0f;
    private float scS = -1.0f;
    private WakeLock wakeLock;

    private abstract class a {
        float iQK;
        float iQL;
        final /* synthetic */ TalkRoomUI scT;
        long scX;

        public abstract void bFg();

        private a(TalkRoomUI talkRoomUI) {
            this.scT = talkRoomUI;
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        if (talkRoomUI.nUB == 5) {
            talkRoomUI.nUB = 3;
            b.bEC().bEy();
            talkRoomUI.nUJ.J(100, 100);
        }
    }

    static /* synthetic */ boolean a(TalkRoomUI talkRoomUI, MotionEvent motionEvent) {
        if (talkRoomUI.nVD < 0.0f) {
            talkRoomUI.nVD = (((float) talkRoomUI.scF.getWidth()) - (((float) talkRoomUI.scF.getPaddingLeft()) * 2.0f)) / 2.0f;
            talkRoomUI.scR = (((float) talkRoomUI.scF.getWidth()) * 1.0f) / 2.0f;
            talkRoomUI.scS = (((float) talkRoomUI.scF.getHeight()) * 1.0f) / 2.0f;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return Math.sqrt((double) (((x - talkRoomUI.scR) * (x - talkRoomUI.scR)) + ((y - talkRoomUI.scS) * (y - talkRoomUI.scS)))) < ((double) talkRoomUI.nVD);
    }

    private void bFc() {
        if (this.nUB == 3 || this.nUB == 5) {
            this.scI.iW(true);
        } else if (bh.ov(this.nUy)) {
            this.scI.iW(false);
        } else {
            this.scI.iW(true);
        }
    }

    public void onCreate(Bundle bundle) {
        x.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("enter_room_username");
        x.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", stringExtra);
        x.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", stringExtra);
        this.nUx = stringExtra;
        if (bh.ov(this.nUx)) {
            Mu("");
        } else {
            if (s.eV(stringExtra)) {
                List gj = m.gj(stringExtra);
                if (gj == null) {
                    com.tencent.mm.z.ak.a.hfL.Q(stringExtra, "");
                } else {
                    this.fAN = gj;
                }
            } else {
                this.fAN.clear();
                this.fAN.add(stringExtra);
                this.fAN.add(q.FS());
            }
            new af(Looper.getMainLooper()).post(new 3(this, stringExtra));
        }
        x.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(v.fv(ac.getContext()).inflate(R.i.dsU, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.ihS = (TextView) findViewById(R.h.cSu);
        this.scE = (TextView) findViewById(R.h.cvV);
        this.nLo = (TextView) findViewById(R.h.bZa);
        this.scG = (Button) findViewById(R.h.cpM);
        this.nUP = (Chronometer) findViewById(R.h.chronometer);
        this.scH = (ImageView) findViewById(R.h.csJ);
        this.scK = new a(this);
        this.scG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI scT;

            {
                this.scT = r1;
            }

            public final void onClick(View view) {
                h.a(this.scT, this.scT.getString(R.l.eQC), this.scT.getString(R.l.eQB), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 scU;

                    {
                        this.scU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.scU.scT.nUK = false;
                        b.bEC().aWa();
                        this.scU.scT.finish();
                    }
                }, null);
            }
        });
        findViewById(R.h.cTP).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI scT;

            {
                this.scT = r1;
            }

            public final void onClick(View view) {
                boolean z;
                Context context = this.scT;
                ar.Hg();
                if (bh.a((Integer) c.CU().get(144641, null), 0) > 0) {
                    z = false;
                } else {
                    k kVar = new k(context, R.m.eYY);
                    LinearLayout linearLayout = (LinearLayout) v.fv(ac.getContext()).inflate(R.i.dsX, null);
                    linearLayout.setMinimumWidth(10000);
                    Button button = (Button) linearLayout.findViewById(R.h.coJ);
                    kVar.setCanceledOnTouchOutside(true);
                    kVar.setOnDismissListener(new 17(context));
                    kVar.setCancelable(false);
                    button.setOnClickListener(new 2(context, kVar));
                    kVar.setContentView(linearLayout);
                    kVar.show();
                    z = true;
                }
                if (!z) {
                    this.scT.onBackPressed();
                }
            }
        });
        this.scF = (ImageButton) findViewById(R.h.cvU);
        this.scF.setEnabled(false);
        this.scF.setImageResource(R.g.bGK);
        this.scF.setOnTouchListener(new 13(this));
        this.scI = (TalkRoomVolumeMeter) findViewById(R.h.cYv);
        findViewById(R.h.cSG).setOnTouchListener(new 15(this, new 14(this)));
        this.scJ = (TalkRoomAvatarsFrame) findViewById(R.h.bLJ);
        this.ihS.setOnClickListener(new 16(this));
        this.scN = new AlphaAnimation(0.0f, 1.0f);
        this.scN.setDuration(300);
        this.scN.setFillAfter(true);
        this.scO = new AlphaAnimation(1.0f, 0.0f);
        this.scO.setDuration(300);
        this.scO.setFillAfter(true);
        this.scP = new AlphaAnimation(0.0f, 1.0f);
        this.scP.setDuration(300);
        this.scP.setFillAfter(true);
        this.scQ = new AlphaAnimation(1.0f, 0.0f);
        this.scQ.setDuration(300);
        this.scQ.setFillAfter(true);
        ar.CG().a(364, (e) this);
        x.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.bEC().a(this);
        x.d("MicroMsg.TalkRoomUI", "onCreate end");
    }

    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.acquire();
        this.ihS.setText(i.b(this, com.tencent.mm.plugin.talkroom.model.h.aA(this, this.nUx), this.ihS.getTextSize()));
        b.bEB().saW.sbb = true;
        b.bEB();
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.bEB();
        com.tencent.mm.plugin.talkroom.model.c.bEI();
        com.tencent.mm.sdk.b.b llVar = new ll();
        llVar.fCN.fCO = true;
        com.tencent.mm.sdk.b.a.xef.a(llVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    }

    protected void onPause() {
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.release();
        this.nUJ.TG();
        b.bEB().saW.sbb = false;
        b.bEB();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.bEB().saW;
        if (cVar.nUw) {
            cVar.Mp(ac.getContext().getString(R.l.eQI));
        } else if (bh.ov(cVar.nTT)) {
            cVar.Mp(com.tencent.mm.plugin.talkroom.model.h.aA(ac.getContext(), b.bEC().sbR));
        } else {
            String string = ac.getContext().getString(R.l.eQO, new Object[]{com.tencent.mm.z.r.gu(cVar.nTT)});
            com.tencent.mm.plugin.talkroom.model.c.bEI();
            cVar.Mp(string);
        }
        com.tencent.mm.sdk.b.b llVar = new ll();
        llVar.fCN.fCO = false;
        com.tencent.mm.sdk.b.a.xef.a(llVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
    }

    protected void onDestroy() {
        b.bEC().b(this);
        ar.CG().b(364, (e) this);
        if (this.ilH != null && this.ilH.isShowing()) {
            this.ilH.cancel();
        }
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            ar.Hh().fz(3);
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            ar.Hh().fy(3);
            return true;
        }
    }

    public final void aWb() {
        this.nUw = false;
        this.scF.setEnabled(true);
        this.scF.setImageResource(R.g.bGI);
        this.scG.setVisibility(0);
        aVZ();
        bFe();
        bFd();
    }

    public final void J(String str, int i, int i2) {
        x.f("MicroMsg.TalkRoomUI", "onInitFailed %s", str);
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.nUK = false;
                finish();
                return;
            }
            str2 = getString(R.l.eQF);
        }
        Mu(str2);
    }

    public final void rN(int i) {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
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
        bFc();
        aVZ();
        com.tencent.mm.sdk.platformtools.ar.a(ac.getContext(), R.l.eQU, new 4(this));
    }

    public final void aWc() {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.nUB == 1) {
            this.nUB = 5;
            if (bh.bA(this.nUD) < this.nUC) {
                x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
                long bA = this.nUC - bh.bA(this.nUD);
                this.nUE.J(bA, bA);
                return;
            }
            aVY();
        }
    }

    private void aVY() {
        if (this.nUB == 5) {
            this.nUE.TG();
            aVZ();
            bFc();
            com.tencent.mm.sdk.platformtools.ar.b(ac.getContext(), R.l.eQR, new 6(this));
            this.nUF.J(1000, 1000);
        }
    }

    public final void j(int i, int i2, String str) {
        x.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        Mu("");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 364 && this.ilH != null && this.ilH.isShowing()) {
            this.ilH.cancel();
        }
    }

    private void Mu(String str) {
        if (this.nUK) {
            this.nUK = false;
            b.bEC().aWa();
            if (bh.ov(str)) {
                if (an.isConnected(getApplication())) {
                    str = getString(R.l.eQF);
                } else {
                    str = getString(R.l.eQG);
                }
            }
            if (!isFinishing()) {
                h.a(this, str, "", new 7(this));
                return;
            }
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void DM(String str) {
        x.d("MicroMsg.TalkRoomUI", "onCurMember %s", str);
        this.nUy = str;
        bFc();
        aVZ();
        if (bh.ov(str)) {
            this.nUJ.TG();
            return;
        }
        com.tencent.mm.sdk.platformtools.ar.b(ac.getContext(), R.l.eQS, new com.tencent.mm.sdk.platformtools.ar.a(this) {
            final /* synthetic */ TalkRoomUI scT;

            {
                this.scT = r1;
            }

            public final void vh() {
            }
        });
        this.nUJ.J(100, 100);
    }

    public final void aWd() {
        if (this.nUK) {
            this.nUK = false;
            finish();
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void aWe() {
        aVZ();
    }

    public final void aWf() {
        aVZ();
    }

    public final void aWg() {
        c(getString(R.l.eQJ), R.e.btV);
    }

    private void bFd() {
        List<bnh> aVC = b.bEC().aVC();
        List linkedList = new LinkedList();
        for (bnh com_tencent_mm_protocal_c_bnh : aVC) {
            linkedList.add(com_tencent_mm_protocal_c_bnh.ksU);
        }
        TalkRoomAvatarsFrame talkRoomAvatarsFrame = this.scJ;
        if (talkRoomAvatarsFrame.scy != null) {
            com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.a aVar = talkRoomAvatarsFrame.scy;
            aVar.scC = linkedList;
            aVar.notifyDataSetChanged();
        }
    }

    public final void df(String str, String str2) {
        x.i("MicroMsg.TalkRoomUI", "add %s,  del %s", str, str2);
        bFd();
        if (!this.nUw) {
            bFe();
            if (!bh.ov(str)) {
                cm(getString(R.l.eQw, new Object[]{com.tencent.mm.z.r.gu(str)}), R.e.btU);
                this.nUG.J(3000, 3000);
            }
            if (!bh.ov(str2)) {
                cm(getString(R.l.eQA, new Object[]{com.tencent.mm.z.r.gu(str2)}), R.e.btU);
                this.nUG.J(3000, 3000);
            }
        }
    }

    private void aVZ() {
        if (!this.nUw) {
            if (b.bEC().scf) {
                c(getString(R.l.eQH), R.e.btV);
                this.scJ.Mt(null);
                this.scH.setImageResource(R.g.bGE);
                bFf();
                return;
            }
            switch (this.nUB) {
                case 0:
                    if (bh.ov(this.nUy)) {
                        CharSequence string;
                        if (b.bEC().aVC().size() == 1) {
                            string = getString(R.l.eQQ);
                        } else {
                            string = "";
                        }
                        c(string, R.e.btU);
                        this.scJ.Mt(null);
                        this.scH.setImageResource(R.g.bGE);
                        bFf();
                        return;
                    }
                    cm(com.tencent.mm.z.r.gu(this.nUy), R.e.btU);
                    this.scJ.Mt(this.nUy);
                    this.scH.setImageResource(R.g.bGE);
                    yo(1);
                    return;
                case 1:
                    c(getString(R.l.eQv), R.e.btU);
                    this.scH.setImageResource(R.g.bGH);
                    return;
                case 2:
                    c(getString(R.l.eQK), R.e.btV);
                    this.scH.setImageResource(R.g.bGG);
                    return;
                case 3:
                case 5:
                    c(getString(R.l.eQL), R.e.btU);
                    this.scJ.Mt(q.FS());
                    this.scH.setImageResource(R.g.bGF);
                    yo(2);
                    return;
                case 4:
                    c(getString(R.l.eQN), R.e.btV);
                    this.scH.setImageResource(R.g.bGG);
                    bFf();
                    return;
                default:
                    return;
            }
        }
    }

    private void bFe() {
        x.i("MicroMsg.TalkRoomUI", "displayCount %d", Integer.valueOf(b.bEC().aVC().size()));
        this.nLo.setText(String.valueOf(r0));
    }

    private void cm(String str, int i) {
        c(i.b(this, str, this.scE.getTextSize()), i);
    }

    private void c(CharSequence charSequence, int i) {
        if (bh.ov(charSequence.toString())) {
            this.scE.startAnimation(this.scQ);
            return;
        }
        this.scE.setTextColor(getResources().getColor(i));
        this.scE.setText(charSequence);
        this.scE.startAnimation(this.scP);
    }

    private void yo(int i) {
        if (i == 0 || this.nUQ != i) {
            this.nUP.setVisibility(0);
            this.nUP.startAnimation(this.scN);
            this.nUP.setBase(bh.Wq());
            this.nUP.start();
            this.nUQ = i;
        }
    }

    private void bFf() {
        if (this.nUQ != 0) {
            this.nUP.stop();
            this.nUQ = 0;
            this.nUP.startAnimation(this.scO);
        }
    }
}
