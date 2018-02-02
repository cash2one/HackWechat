package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.r;
import java.util.Timer;

public final class f extends d {
    private Timer bnp;
    private boolean mIsMute = false;
    private TextView nNS;
    private int slY = 1;
    private Button sqN;
    private OnClickListener srD = new 1(this);
    private OnClickListener srE = new 3(this);
    private Runnable srJ = new 10(this);
    private View srQ;
    private ImageView srR;
    private TextView srS;
    private TextView srT;
    private TextView srU;
    private TextView srV;
    private View srW;
    private RelativeLayout srX;
    private MMCheckBox srY;
    private TextView srZ;
    private boolean srq = false;
    private boolean srs = false;
    private RelativeLayout ssa;
    private MMCheckBox ssb;
    private TextView ssc;
    private TextView ssd;
    private TextView sse;
    private VoipBigIconButton ssf;
    private VoipBigIconButton ssg;
    private VoipBigIconButton ssh;
    private VoipBigIconButton ssi;
    private VoipSmallIconButton ssj;
    private OnClickListener ssk = new 4(this);
    private OnClickListener ssl = new 5(this);
    private OnClickListener ssm = new 6(this);
    private OnClickListener ssn = new OnClickListener(this) {
        final /* synthetic */ f ssq;

        {
            this.ssq = r1;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(5)});
            if (this.ssq.spN != null && this.ssq.spN.get() != null && ((c) this.ssq.spN.get()).bGN()) {
                this.ssq.ssg.setEnabled(false);
                this.ssq.ssf.setEnabled(false);
                this.ssq.co(this.ssq.getString(R.l.eVH), -1);
                if (this.ssq.sqg != null) {
                    this.ssq.sqg.D(true, false);
                }
            }
        }
    };
    private OnClickListener sso = new 8(this);
    private OnClickListener ssp = new OnClickListener(this) {
        final /* synthetic */ f ssq;

        {
            this.ssq = r1;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (this.ssq.spN != null && this.ssq.spN.get() != null && ((c) this.ssq.spN.get()).bGQ()) {
                this.ssq.co(this.ssq.getString(R.l.eUu), -1);
                this.ssq.ssi.setEnabled(false);
            }
        }
    };

    public final void onDestroy() {
        this.srq = false;
        super.onDestroy();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        x.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.sqc = (RelativeLayout) layoutInflater.inflate(R.i.dtO, viewGroup, false);
        } else {
            this.sqc = (RelativeLayout) layoutInflater.inflate(R.i.dtN, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.sqc.findViewById(R.h.cIj)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
            }
        }
        this.sqd = (ImageView) this.sqc.findViewById(R.h.cXk);
        this.srQ = this.sqc.findViewById(R.h.cYb);
        this.srR = (ImageView) this.sqc.findViewById(R.h.cYn);
        a.b.a(this.srR, this.gAb, 0.0375f, true);
        this.srS = (TextView) this.sqc.findViewById(R.h.cYo);
        this.srS.setText(i.b(getActivity(), r.gu(this.gAb), this.srS.getTextSize()));
        this.srT = (TextView) this.sqc.findViewById(R.h.cYt);
        this.srU = (TextView) this.sqc.findViewById(R.h.cYf);
        this.srV = (TextView) this.sqc.findViewById(R.h.cYh);
        this.srW = this.sqc.findViewById(R.h.cYg);
        this.ssd = (TextView) this.sqc.findViewById(R.h.cYc);
        this.sse = (TextView) this.sqc.findViewById(R.h.cYp);
        this.nNS = (TextView) this.sqc.findViewById(R.h.cXE);
        b(this.srV, getResources().getString(R.l.eVN));
        this.ssa = (RelativeLayout) this.sqc.findViewById(R.h.cYj);
        this.ssb = (MMCheckBox) this.sqc.findViewById(R.h.cYi);
        this.ssb.setChecked(this.mIsMute);
        this.ssc = (TextView) this.sqc.findViewById(R.h.cYk);
        this.ssc.setText(R.l.eVx);
        this.srX = (RelativeLayout) this.sqc.findViewById(R.h.cYr);
        this.srY = (MMCheckBox) this.sqc.findViewById(R.h.cYq);
        this.srZ = (TextView) this.sqc.findViewById(R.h.cYs);
        this.srZ.setText(R.l.eVL);
        bIi();
        this.ssf = (VoipBigIconButton) this.sqc.findViewById(R.h.cYa);
        this.ssf.setOnClickListener(this.ssm);
        this.ssg = (VoipBigIconButton) this.sqc.findViewById(R.h.cYm);
        this.ssg.setOnClickListener(this.ssn);
        this.ssh = (VoipBigIconButton) this.sqc.findViewById(R.h.cYe);
        this.ssh.setOnClickListener(this.sso);
        this.ssi = (VoipBigIconButton) this.sqc.findViewById(R.h.cYd);
        this.ssi.setOnClickListener(this.ssp);
        this.srs = com.tencent.mm.plugin.voip.b.d.ok("VOIPBlockIgnoreButton") == 0;
        this.ssj = (VoipSmallIconButton) this.sqc.findViewById(R.h.cXC);
        this.ssj.setOnClickListener(this.srE);
        if (!this.srs) {
            this.ssj.setVisibility(8);
        }
        this.srY.setOnClickListener(this.ssk);
        this.ssb.setOnClickListener(this.ssl);
        this.sqN = (Button) this.sqc.findViewById(R.h.bPf);
        this.sqN.setOnClickListener(this.srD);
        int fK = u.fK(getActivity());
        x.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + fK);
        F(this.sqN, fK);
        if (this.slT && 2 == this.slY) {
            co(getString(R.l.eUc), 10000);
        }
        this.bnp = new Timer();
        dQ(this.sqf, this.mStatus);
        return this.sqc;
    }

    public final void dQ(int i, int i2) {
        super.dQ(i, i2);
        x.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.yP(i2));
        if (this.sqc == null) {
            x.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 1:
                this.srQ.setVisibility(0);
                this.srT.setVisibility(8);
                this.srU.setText(R.l.eVF);
                this.sqh.a(this.srV, sqb);
                this.srW.setVisibility(0);
                this.ssf.setVisibility(8);
                this.ssg.setVisibility(8);
                this.ssh.setVisibility(8);
                this.ssi.setVisibility(0);
                this.ssj.setVisibility(8);
                this.ssa.setVisibility(0);
                this.ssb.setEnabled(false);
                this.ssb.setBackgroundResource(R.g.bHP);
                this.ssc.setTextColor(1728053247);
                this.sse.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sse.setVisibility(0);
                    this.sse.setText(d.bGj().smq);
                }
                bIi();
                this.ssb.setChecked(this.mIsMute);
                this.srX.setVisibility(0);
                if (2 == this.slY) {
                    co(getString(R.l.eUc), 10000);
                }
                bIe();
                return;
            case 3:
                this.srQ.setVisibility(0);
                this.srT.setVisibility(8);
                this.srU.setText(R.l.eVu);
                this.sqh.a(this.srV, sqb);
                this.srW.setVisibility(0);
                this.ssf.setVisibility(8);
                this.ssg.setVisibility(8);
                this.ssh.setVisibility(8);
                this.ssi.setVisibility(0);
                this.ssj.setVisibility(8);
                this.ssa.setVisibility(0);
                this.ssb.setEnabled(false);
                this.ssb.setBackgroundResource(R.g.bHP);
                this.ssc.setTextColor(1728053247);
                bIi();
                this.ssb.setChecked(this.mIsMute);
                this.srX.setVisibility(0);
                if (i != 4097 && 2 == this.slY) {
                    co(getString(R.l.eUc), 10000);
                }
                bIe();
                this.sse.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sse.setVisibility(0);
                    this.sse.setText(d.bGj().smq);
                    return;
                }
                return;
            case 5:
                this.srU.setText(R.l.eWb);
                this.sqh.a(this.srV, sqb);
                this.ssf.setVisibility(8);
                this.ssg.setVisibility(8);
                this.ssh.setVisibility(0);
                this.ssi.setVisibility(8);
                this.ssj.setVisibility(8);
                return;
            case 7:
            case 261:
                this.ssi.setVisibility(8);
                this.ssf.setVisibility(8);
                this.ssg.setVisibility(8);
                this.ssj.setVisibility(8);
                this.srW.setVisibility(8);
                this.sqh.bIg();
                this.ssh.setVisibility(0);
                this.srT.setVisibility(0);
                this.ssa.setVisibility(0);
                this.srX.setVisibility(0);
                this.srQ.setVisibility(0);
                this.sqN.setVisibility(0);
                this.ssb.setEnabled(true);
                this.ssb.setBackgroundResource(R.g.bHK);
                this.ssc.setTextColor(-1);
                bIi();
                this.ssb.setChecked(this.mIsMute);
                if (2 == this.slY) {
                    co(getString(R.l.eUc), 10000);
                }
                bIe();
                if (!(this.bnp == null || this.srq)) {
                    if (-1 == this.spP) {
                        this.spP = bh.Wo();
                    }
                    this.srq = true;
                    this.bnp.schedule(new 2(this), 50, 1000);
                }
                this.sse.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sse.setVisibility(0);
                    this.sse.setText(d.bGj().smq);
                    return;
                }
                return;
            case 8:
            case 262:
                this.sqh.bIg();
                this.ssh.setEnabled(false);
                this.ssi.setEnabled(false);
                this.ssf.setEnabled(false);
                this.ssg.setEnabled(false);
                this.ssj.setEnabled(false);
                return;
            case 257:
                this.srQ.setVisibility(0);
                this.srW.setVisibility(0);
                this.srU.setText(R.l.eVv);
                this.sqh.a(this.srV, sqb);
                bIi();
                this.ssf.setVisibility(0);
                this.ssg.setVisibility(0);
                this.ssh.setVisibility(8);
                this.ssi.setVisibility(8);
                if (this.srs) {
                    this.ssj.setVisibility(0);
                }
                co(getString(R.l.eUd), 10000);
                bIe();
                this.sse.setVisibility(8);
                if (d.bGj().smq != null) {
                    this.sse.setVisibility(0);
                    this.sse.setText(d.bGj().smq);
                    return;
                }
                return;
            case 259:
                this.srQ.setVisibility(0);
                this.srW.setVisibility(0);
                this.srU.setText(R.l.eWb);
                this.sqh.a(this.srV, sqb);
                this.ssf.setVisibility(8);
                this.ssg.setVisibility(8);
                this.ssh.setVisibility(0);
                this.ssi.setVisibility(8);
                this.ssj.setVisibility(8);
                co(getString(R.l.eUd), 10000);
                bIe();
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
    }

    public final void uninit() {
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
        super.uninit();
    }

    protected final void MD(String str) {
        if (this.sse != null) {
            this.sse.setVisibility(0);
            this.sse.setText(str);
        }
    }

    protected final void co(String str, int i) {
        if (this.ssd != null) {
            this.ssd.setText(bh.ou(str));
            this.ssd.setVisibility(0);
            this.ssd.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.ssd.setBackgroundResource(R.g.bHM);
            this.ssd.setCompoundDrawables(null, null, null, null);
            this.ssd.setCompoundDrawablePadding(0);
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

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.ssb != null && this.ssc != null) {
            this.ssb.setChecked(z);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void b(int i, int i2, int[] iArr) {
    }

    public final void bGZ() {
    }

    public final void yL(int i) {
        this.slY = i;
        bIi();
    }

    private void bIi() {
        boolean z = false;
        if (this.srY == null || this.srZ == null) {
            x.e("MicroMsg.VoipVoiceFragment", "speaker is null");
        } else if (4 == this.slY || 3 == this.slY) {
            this.srY.setEnabled(false);
            this.srZ.setTextColor(1728053247);
            this.srY.setBackgroundResource(R.g.bHJ);
        } else {
            if (this.slY == 1) {
                z = true;
            }
            this.srY.setBackgroundResource(R.g.bHL);
            this.srY.setEnabled(true);
            this.srZ.setTextColor(-1);
            this.srY.setChecked(z);
        }
    }
}
