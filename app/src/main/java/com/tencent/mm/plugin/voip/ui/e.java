package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.util.Locale;
import java.util.Timer;

public final class e extends d {
    private Timer bnp;
    private TextView nNS;
    int[] oGZ = null;
    Bitmap oHq = null;
    private CaptureView slO;
    private OpenGlView sqA;
    private OpenGlRender sqB;
    private OpenGlRender sqC;
    private View sqD;
    private ImageView sqE;
    private TextView sqF;
    private TextView sqG;
    private TextView sqH;
    private View sqI;
    private TextView sqJ;
    private TextView sqK;
    private TextView sqL;
    private RelativeLayout sqM;
    private Button sqN;
    private VoipSmallIconButton sqO;
    private VoipSmallIconButton sqP;
    private VoipSmallIconButton sqQ;
    private VoipBigIconButton sqR;
    private VoipBigIconButton sqS;
    private VoipBigIconButton sqT;
    private VoipBigIconButton sqU;
    private VoipBigIconButton sqV;
    private VoipBigIconButton sqW;
    private TextView sqX;
    private TextView sqY;
    private TextView sqZ;
    private OpenGlView sqz;
    private OnClickListener srA = new 14(this);
    private OnClickListener srB = new 15(this);
    private OnClickListener srC = new 16(this);
    private OnClickListener srD = new 17(this);
    private OnClickListener srE = new OnClickListener(this) {
        final /* synthetic */ e srL;

        {
            this.srL = r1;
        }

        public final void onClick(View view) {
            g.pQN.h(11619, new Object[]{Integer.valueOf(2)});
            if (this.srL.spN != null && this.srL.spN.get() != null) {
                ((c) this.srL.spN.get()).bHe();
            }
        }
    };
    private OnClickListener srF = new 2(this);
    private OnClickListener srG = new 3(this);
    private OnClickListener srH = new 6(this);
    private Runnable srI = new 7(this);
    private Runnable srJ = new 8(this);
    int srK = 0;
    private TextView sra;
    private TextView srb;
    private TextView srd;
    private VoIPVideoView sre;
    private com.tencent.mm.plugin.voip.video.e srf = null;
    private Button srg = null;
    private Button srh = null;
    private boolean sri = false;
    private int srj;
    private int srk;
    private int srl;
    private int srm;
    private int srn;
    private int sro = 0;
    private boolean srp = false;
    private boolean srq = false;
    private boolean srr = false;
    private boolean srs;
    public long srt = 0;
    private Bitmap sru = null;
    private a srv;
    private OnClickListener srw = new 1(this);
    private OnClickListener srx = new 11(this);
    private OnClickListener sry = new 12(this);
    private OnClickListener srz = new OnClickListener(this) {
        final /* synthetic */ e srL;

        {
            this.srL = r1;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (an.isWifi(this.srL.getActivity()) || l.bHl()) {
                e.c(this.srL);
            } else {
                h.a(this.srL.getActivity(), R.l.eVC, R.l.eVD, new 1(this), new 2(this));
            }
        }
    };

    static /* synthetic */ void c(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(3)});
        if (eVar.spN != null && eVar.spN.get() != null && ((c) eVar.spN.get()).bGK()) {
            eVar.sqQ.setEnabled(false);
            eVar.sqT.setEnabled(false);
            eVar.sqS.setEnabled(false);
            eVar.sqG.setText(R.l.eWb);
            eVar.sqh.a(eVar.sqH, sqb);
        }
    }

    static /* synthetic */ void d(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(4)});
        if (eVar.spN != null && eVar.spN.get() != null && ((c) eVar.spN.get()).bGL()) {
            eVar.co(eVar.getString(R.l.eVH), -1);
            eVar.sqS.setEnabled(false);
            eVar.sqT.setEnabled(false);
            eVar.sqQ.setEnabled(false);
        }
    }

    static /* synthetic */ void d(e eVar, boolean z) {
        if (z) {
            eVar.getActivity().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            eVar.getActivity().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    static /* synthetic */ void e(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(1)});
        if (eVar.spN != null && eVar.spN.get() != null && ((c) eVar.spN.get()).bGM()) {
            eVar.sqT.setEnabled(false);
            eVar.sqS.setEnabled(false);
            eVar.sqQ.setEnabled(false);
            eVar.sqR.setVisibility(8);
        }
    }

    static /* synthetic */ void t(e eVar) {
        m bGj = d.bGj();
        int i = eVar.srk;
        com.tencent.mm.plugin.voip.model.g gVar = bGj.smS.siL.skg;
        gVar.siL.ske.spe = i;
        gVar.siL.ske.spf = 0;
        if (r.iee) {
            long Wo = bh.Wo();
            int i2 = (int) (Wo - eVar.srt);
            if (i2 <= 1) {
                i2 = 1;
            }
            CharSequence format = String.format(Locale.US, "Cap Fps: %d", new Object[]{Integer.valueOf(eVar.srk)});
            CharSequence format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(eVar.srj)});
            CharSequence format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(eVar.srl)});
            int i3 = d.bGj().smS.siL.skg.siL.ske.field_sendVideoLen;
            int i4 = d.bGj().smS.siL.skg.siL.ske.field_recvVideoLen;
            eVar.srm = (int) ((((double) (i3 - eVar.srm)) * 8.0d) / ((double) (i2 * 1000)));
            eVar.srn = (int) ((((double) (i4 - eVar.srn)) * 8.0d) / ((double) (i2 * 1000)));
            CharSequence format4 = String.format(Locale.US, "Send Br: %d", new Object[]{Integer.valueOf(eVar.srm)});
            CharSequence format5 = String.format(Locale.US, "Recv Br: %d", new Object[]{Integer.valueOf(eVar.srn)});
            byte[] bArr = d.bGj().smS.siL.ske.spg;
            if (bArr != null) {
                try {
                    eVar.srd.setText(new String(bArr, "UTF-8"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                }
            }
            eVar.sqX.setText(format);
            eVar.sqY.setText(format2);
            eVar.sqZ.setText(format3);
            eVar.srb.setText(format5);
            eVar.sra.setText(format4);
            eVar.srm = i3;
            eVar.srn = i4;
            eVar.srt = Wo;
        }
        eVar.srk = 0;
        eVar.srj = 0;
        eVar.srl = 0;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.sqc = (RelativeLayout) layoutInflater.inflate(R.i.dtM, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.sqc.findViewById(R.h.cIh)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
        }
        this.sqd = (ImageView) this.sqc.findViewById(R.h.cXk);
        this.sqe = (ImageView) this.sqc.findViewById(R.h.cXP);
        this.sqM = (RelativeLayout) this.sqc.findViewById(R.h.ctk);
        this.sqz = (OpenGlView) this.sqc.findViewById(R.h.bMY);
        this.sqz.dS(mScreenWidth, mScreenHeight);
        this.sqW = (VoipBigIconButton) this.sqc.findViewById(R.h.cXL);
        this.sqW.setOnClickListener(this.srH);
        this.sqV = (VoipBigIconButton) this.sqc.findViewById(R.h.cXY);
        this.sqV.setOnClickListener(this.srx);
        this.sqR = (VoipBigIconButton) this.sqc.findViewById(R.h.cXl);
        this.sqR.setOnClickListener(this.srC);
        this.sqU = (VoipBigIconButton) this.sqc.findViewById(R.h.cXA);
        this.sqU.setOnClickListener(this.srw);
        this.sqT = (VoipBigIconButton) this.sqc.findViewById(R.h.cXi);
        this.sqT.setOnClickListener(this.srA);
        this.sqQ = (VoipSmallIconButton) this.sqc.findViewById(R.h.cXj);
        this.sqQ.setOnClickListener(this.srz);
        this.sqS = (VoipBigIconButton) this.sqc.findViewById(R.h.cXI);
        this.sqS.setOnClickListener(this.srB);
        this.sqP = (VoipSmallIconButton) this.sqc.findViewById(R.h.cXM);
        this.sqP.setOnClickListener(this.sry);
        this.srs = com.tencent.mm.plugin.voip.b.d.ok("VOIPBlockIgnoreButton") == 0;
        this.sqO = (VoipSmallIconButton) this.sqc.findViewById(R.h.cXB);
        this.sqO.setOnClickListener(this.srE);
        if (!this.srs) {
            this.sqO.setVisibility(8);
        }
        this.sqJ = (TextView) this.sqc.findViewById(R.h.cXZ);
        this.sqD = this.sqc.findViewById(R.h.cXV);
        this.sqE = (ImageView) this.sqc.findViewById(R.h.cXU);
        a.b.a(this.sqE, this.gAb, 0.05882353f, true);
        this.sqF = (TextView) this.sqc.findViewById(R.h.cXW);
        this.sqG = (TextView) this.sqc.findViewById(R.h.cXR);
        this.sqH = (TextView) this.sqc.findViewById(R.h.cXT);
        this.sqI = this.sqc.findViewById(R.h.cXS);
        b(this.sqH, getResources().getString(R.l.eVN));
        this.sqK = (TextView) this.sqc.findViewById(R.h.cXQ);
        this.sqL = (TextView) this.sqc.findViewById(R.h.cXX);
        this.sqN = (Button) this.sqc.findViewById(R.h.bPf);
        this.nNS = (TextView) this.sqc.findViewById(R.h.cXE);
        if (r.iee) {
            this.sqX = (TextView) this.sqc.findViewById(R.h.cXm);
            this.sqY = (TextView) this.sqc.findViewById(R.h.cXJ);
            this.sqZ = (TextView) this.sqc.findViewById(R.h.cXG);
            this.sra = (TextView) this.sqc.findViewById(R.h.cXK);
            this.srb = (TextView) this.sqc.findViewById(R.h.cXH);
            this.srd = (TextView) this.sqc.findViewById(R.h.cez);
        }
        this.srg = (Button) this.sqc.findViewById(R.h.cXy);
        this.srh = (Button) this.sqc.findViewById(R.h.cXz);
        this.srg.setVisibility(8);
        this.srh.setVisibility(8);
        this.srg.setOnClickListener(this.srF);
        this.srh.setOnClickListener(this.srG);
        this.srf = new com.tencent.mm.plugin.voip.video.e(getActivity());
        this.sqc.addView(this.srf);
        this.srf.setVisibility(8);
        this.sqN.setOnClickListener(this.srD);
        c(this.slO);
        int fK = u.fK(getActivity());
        x.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + fK);
        F(this.sqN, fK);
        F(this.sqc.findViewById(R.h.cXO), fK);
        F(this.sqD, fK);
        this.srk = 0;
        this.srj = 0;
        this.srl = 0;
        this.srm = 0;
        this.srn = 0;
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.sqA = new MovableVideoView(getActivity().getApplicationContext());
        ((MovableVideoView) this.sqA).dR(width, height);
        this.sqA.setVisibility(8);
        this.sqB = new OpenGlRender(this.sqA, OpenGlRender.sum);
        this.sqA.a(this.sqB);
        this.sqA.setRenderMode(0);
        this.sqC = new OpenGlRender(this.sqz, OpenGlRender.sul);
        this.sqz.a(this.sqC);
        this.sqz.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sqA.setZOrderOnTop(true);
        } else {
            this.sqA.setZOrderMediaOverlay(true);
        }
        this.sqc.addView(this.sqA);
        this.sqA.setOnClickListener(new 4(this));
        this.sqF.setText(i.b(getActivity(), com.tencent.mm.z.r.gu(this.gAb), this.sqF.getTextSize()));
        if (this.slT) {
            this.jKT.postDelayed(new 5(this), 2000);
        }
        this.sre = (VoIPVideoView) this.sqc.findViewById(R.h.cXN);
        this.bnp = new Timer("VoIP_video_talking_count");
        this.srr = true;
        dQ(0, this.mStatus);
        return this.sqc;
    }

    public final void onDestroy() {
        this.srq = false;
        super.onDestroy();
    }

    private void bIh() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.sro++;
        this.jKT.postDelayed(this.srI, 10000);
    }

    public final void dQ(int i, int i2) {
        super.dQ(i, i2);
        x.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.yP(i2));
        if (this.sqc == null) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                this.sqI.setVisibility(0);
                this.sqM.setVisibility(0);
                this.sqz.setVisibility(0);
                this.sqG.setText(R.l.eVu);
                this.sqd.setVisibility(8);
                this.sqK.setVisibility(8);
                this.sqL.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sqL.setVisibility(0);
                    this.sqL.setText(d.bGj().smq);
                }
                this.sqh.a(this.sqH, sqb);
                this.sqW.setVisibility(8);
                this.sqV.setVisibility(8);
                this.sqR.setVisibility(0);
                this.sqU.setVisibility(8);
                this.sqT.setVisibility(8);
                this.sqQ.setVisibility(8);
                this.sqS.setVisibility(8);
                this.sqP.setVisibility(0);
                this.sqO.setVisibility(8);
                return;
            case 4:
            case 258:
                this.sqG.setText(R.l.eWb);
                this.sqh.a(this.sqH, sqb);
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                this.sqc.setOnClickListener(new 10(this));
                if (this.sqe != null) {
                    this.sqe.setVisibility(8);
                }
                if (this.sqA.getVisibility() != 0) {
                    if (this.slT) {
                        this.srp = !this.srp;
                        Point jm = jm(!this.srp);
                        this.sqA.dT(jm.x, jm.y);
                    } else {
                        this.srp = !this.srp;
                        this.sre.setVisibility(8);
                    }
                    if (r.iee) {
                        this.sqX.setVisibility(0);
                        this.sqY.setVisibility(0);
                        this.sqZ.setVisibility(0);
                        this.sra.setVisibility(0);
                        this.srb.setVisibility(0);
                        this.srd.setVisibility(0);
                    }
                    this.sqD.setVisibility(8);
                    this.sqz.setVisibility(0);
                    this.sqA.setVisibility(0);
                    this.sqJ.setVisibility(0);
                    this.sqN.setVisibility(0);
                    this.sqM.setVisibility(0);
                    this.sqW.setVisibility(0);
                    this.sqV.setVisibility(0);
                    this.sqR.setVisibility(8);
                    this.sqU.setVisibility(0);
                    this.sqT.setVisibility(8);
                    this.sqQ.setVisibility(8);
                    this.sqS.setVisibility(8);
                    this.sqP.setVisibility(8);
                    this.sqO.setVisibility(8);
                    Point jm2 = jm(!this.srp);
                    ((MovableVideoView) this.sqA).dR(jm2.x, jm2.y);
                    if (!(this.bnp == null || this.srq)) {
                        if (-1 == this.spP) {
                            this.spP = bh.Wo();
                        }
                        this.srt = this.spP;
                        this.srq = true;
                        this.bnp.schedule(new 9(this), 1000, 1000);
                    }
                    if (ac.cft().getBoolean("voipfaceDebug", false)) {
                        this.srg.setVisibility(0);
                        this.srh.setVisibility(0);
                    }
                    bIh();
                    return;
                }
                return;
            case 8:
            case 262:
                this.sqh.bIg();
                this.sqR.setEnabled(false);
                this.sqV.setEnabled(false);
                this.sqU.setEnabled(false);
                this.sqT.setEnabled(false);
                this.sqS.setEnabled(false);
                this.sqQ.setEnabled(false);
                this.sqW.setEnabled(false);
                this.sqP.setEnabled(false);
                this.sqO.setEnabled(false);
                switch (i) {
                    case 4105:
                        this.sqK.setVisibility(0);
                        this.sqK.setText(R.l.eVB);
                        break;
                }
                if (this.sqg != null) {
                    this.sqg.D(true, false);
                    return;
                }
                return;
            case 256:
                this.sqz.setVisibility(0);
                this.sqM.setVisibility(0);
                if (this.sqe != null) {
                    bIf();
                }
                this.sqD.setVisibility(0);
                this.sqF.setVisibility(0);
                this.sqG.setText(R.l.eVw);
                this.sqI.setVisibility(0);
                this.sqE.setVisibility(0);
                this.sqh.a(this.sqH, sqb);
                this.sqW.setVisibility(8);
                this.sqV.setVisibility(8);
                this.sqR.setVisibility(8);
                this.sqU.setVisibility(8);
                this.sqT.setVisibility(0);
                this.sqQ.setVisibility(0);
                this.sqS.setVisibility(0);
                this.sqP.setVisibility(8);
                if (this.srs) {
                    this.sqO.setVisibility(0);
                }
                this.sqL.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sqL.setVisibility(0);
                    this.sqL.setText(d.bGj().smq);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
        this.slO = captureView;
        c(this.slO);
    }

    public final void uninit() {
        this.sqA.setVisibility(4);
        if (this.slO != null) {
            this.sqc.removeView(this.slO);
            this.slO = null;
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.srv != null) {
            com.tencent.mm.sdk.f.e.remove(this.srv);
            this.srv = null;
        }
        super.uninit();
    }

    public final void setMute(boolean z) {
    }

    public final void onStop() {
        this.sqC.bIE();
        this.sqB.bIE();
        super.onStop();
    }

    public final void onStart() {
        this.sqC.stS = true;
        this.sqB.stS = true;
        super.onStart();
    }

    protected final void MD(String str) {
        if (this.sqL != null) {
            this.sqL.setVisibility(0);
            this.sqL.setText(str);
        }
    }

    protected final void co(String str, int i) {
        if (this.sqK != null) {
            this.sqK.setText(bh.ou(str));
            this.sqK.setVisibility(0);
            this.sqK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.sqK.setBackgroundResource(R.g.bHM);
            this.sqK.setCompoundDrawables(null, null, null, null);
            this.sqK.setCompoundDrawablePadding(0);
            this.jKT.removeCallbacks(this.srJ);
            if (-1 != i) {
                this.jKT.postDelayed(this.srJ, (long) i);
            }
        }
    }

    protected final void bIc() {
        if (this.nNS != null) {
            this.nNS.clearAnimation();
            this.nNS.setVisibility(0);
        }
    }

    protected final void bId() {
        if (this.nNS != null) {
            this.nNS.clearAnimation();
            this.nNS.setVisibility(8);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.srr) {
            if (OpenGlRender.suw == 1) {
                if (this.srK < i * i2) {
                    this.oGZ = null;
                }
                if (this.oGZ == null) {
                    this.srK = i * i2;
                    this.oGZ = new int[this.srK];
                }
                if (d.bGj().a(bArr, (int) j, i3 & 31, i, i2, this.oGZ, true) >= 0 && this.oGZ != null) {
                    if (this.srp) {
                        this.sqB.a(this.oGZ, i, i2, (OpenGlRender.sud + i4) + i5);
                    } else {
                        this.sqC.a(this.oGZ, i, i2, (OpenGlRender.sud + i4) + i5);
                    }
                } else {
                    return;
                }
            } else if (OpenGlRender.suw == 2) {
                if (this.srp) {
                    this.sqB.c(bArr, i, i2, (OpenGlRender.suh + i4) + i5);
                } else {
                    this.sqC.c(bArr, i, i2, (OpenGlRender.suh + i4) + i5);
                }
            }
            this.srk++;
            if (i6 > 0) {
                this.srj++;
            }
            com.tencent.mm.plugin.voip.video.e eVar = this.srf;
            eVar.stu = i;
            eVar.stv = i2;
            eVar = this.srf;
            int width = this.sqc.getWidth();
            int height = this.sqc.getHeight();
            eVar.stt = width;
            eVar.fp = height;
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        if (this.srr) {
            this.srl++;
            if (OpenGlRender.suw == 1) {
                if (this.srp) {
                    this.sqC.a(iArr, i, i2, OpenGlRender.sud + OpenGlRender.sui);
                } else {
                    this.sqB.a(iArr, i, i2, OpenGlRender.sud + OpenGlRender.sui);
                }
            } else if (this.srp) {
                this.sqC.a(iArr, i, i2, OpenGlRender.suf + OpenGlRender.sui);
            } else {
                this.sqB.a(iArr, i, i2, OpenGlRender.suf + OpenGlRender.sui);
            }
        }
    }

    public final void bGZ() {
        if (this.srr) {
            this.sqC.bIF();
            this.sqB.bIF();
        }
    }

    private void c(CaptureView captureView) {
        if (this.sqc != null && captureView != null) {
            this.sqc.removeView(this.slO);
            this.slO = null;
            this.slO = captureView;
            this.sqc.addView(captureView, new LayoutParams(1, 1));
            this.slO.setVisibility(0);
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        }
    }

    public final void onDetach() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
        super.onDetach();
    }

    public final void yL(int i) {
    }

    private Point jm(boolean z) {
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        d.bGj();
        return new Point((int) (f * m.jk(z)), height);
    }
}
