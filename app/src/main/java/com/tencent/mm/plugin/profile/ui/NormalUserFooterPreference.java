package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements a {
    private MMActivity fmM;
    protected k<e, String> hkZ = new 1(this);
    public ProgressDialog iln = null;
    private x jLe;
    private String kvB = null;
    private boolean lRB;
    private String mOi = "";
    private Button okw;
    private boolean phD;
    private int phF;
    private int piQ = 0;
    private long pjS = 0;
    private int pji;
    private String pjq = "";
    private boolean pjw = false;
    private boolean pke = false;
    private boolean pkf;
    private boolean pkg;
    private boolean pkh = false;
    private boolean pki = false;
    private a pkj;
    private View pkk;
    private Button pkl;
    private Button pkm;
    private Button pkn;
    private View pko;
    private Button pkp;
    private View pkq;
    private Button pkr;
    private Button pks;
    private Button pkt;
    private Button pku;
    private Button pkv;
    private Button pkw;
    private TextView pkx;
    private boolean pky = false;
    public boolean pkz = false;

    class h extends a {
        final /* synthetic */ NormalUserFooterPreference pkA;

        public h(NormalUserFooterPreference normalUserFooterPreference) {
            this.pkA = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void bjF() {
        }

        protected final void bjD() {
            this.pkA.pkk.setVisibility(8);
            this.pkA.okw.setVisibility(0);
            if (this.pkA.bjA() || this.pkA.jLe.field_username.equals(q.FS()) || s.hn(this.pkA.jLe.field_username) || s.hg(this.pkA.jLe.field_username)) {
                this.pkA.pku.setVisibility(8);
            } else {
                this.pkA.pku.setVisibility(0);
            }
            this.pkA.okw.setText(R.l.dWq);
            this.pkA.pkt.setVisibility(8);
            this.pkA.pkq.setVisibility(8);
            this.pkA.pkx.setVisibility(8);
        }
    }

    class i extends c implements e {
        private ProgressDialog iln;
        final /* synthetic */ NormalUserFooterPreference pkA;

        public i(NormalUserFooterPreference normalUserFooterPreference) {
            this.pkA = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected void bjD() {
            onDetach();
            onStop();
            ar.CG().a(30, (e) this);
            super.bjD();
        }

        final void onStop() {
            ar.CG().b(30, (e) this);
        }

        protected void onDetach() {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (this.pkA.pkk != null) {
                this.pkA.pkk.setVisibility(8);
            }
            if (this.pkA.pkq != null) {
                this.pkA.pkq.setVisibility(0);
            }
            if (this.pkA.okw != null) {
                this.pkA.okw.setVisibility(8);
            }
            if (this.pkA.pkw != null) {
                this.pkA.pkw.setVisibility(8);
            }
            if (this.pkA.pku != null) {
                this.pkA.pku.setVisibility(8);
            }
            if (this.pkA.pkt != null) {
                this.pkA.pkt.setVisibility(8);
            }
            if (this.pkA.pkx != null) {
                this.pkA.pkx.setVisibility(8);
            }
            onStop();
        }

        protected void bjJ() {
            if (this.pkA.pkj != null) {
                this.pkA.pkj.onDetach();
            }
            this.pkA.pkj = new c(this.pkA);
            this.pkA.pkj.EI();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
            x xVar = null;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (kVar.getType() == 30) {
                onStop();
                if (this.iln != null) {
                    this.iln.dismiss();
                    this.iln = null;
                }
                if (!bh.bF(this.pkA.mContext)) {
                    return;
                }
                int i3;
                if (i == 0 && i2 == 0) {
                    i3 = ((o) kVar).fuL;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = " + i3);
                    if (i3 == 1 || i3 == 3) {
                        List<String> list = ((o) kVar).vdy;
                        if (list != null && list.contains(this.pkA.jLe.field_username)) {
                            this.pkA.pky = true;
                            NormalUserFooterPreference normalUserFooterPreference = this.pkA;
                            ar.Hg();
                            com.tencent.mm.l.a WO = c.EY().WO(this.pkA.jLe.field_username);
                            if (WO == null || ((int) WO.gJd) == 0) {
                                af a = this.pkA.jLe;
                                ar.Hg();
                                if (c.EY().Q(a)) {
                                    ar.Hg();
                                    WO = c.EY().WO(this.pkA.jLe.field_username);
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + a.field_username);
                                    normalUserFooterPreference.jLe = xVar;
                                    if (this.pkA.jLe != null) {
                                        s.p(this.pkA.jLe);
                                    }
                                    bjJ();
                                    for (String aT : list) {
                                        b.aT(aT, this.pkA.phF);
                                    }
                                    ar.getNotification().wY();
                                }
                            }
                            com.tencent.mm.l.a aVar = WO;
                            normalUserFooterPreference.jLe = xVar;
                            if (this.pkA.jLe != null) {
                                s.p(this.pkA.jLe);
                            }
                            bjJ();
                            while (r1.hasNext()) {
                                b.aT(aT, this.pkA.phF);
                            }
                            ar.getNotification().wY();
                        }
                    }
                } else if (i == 4 && i2 == -302) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((o) kVar).fuL));
                    if (((o) kVar).fuL == 3) {
                        com.tencent.mm.ui.base.h.a(this.pkA.fmM, this.pkA.fmM.getString(R.l.dXf), this.pkA.fmM.getString(R.l.dGO), this.pkA.fmM.getString(R.l.dDK), this.pkA.fmM.getString(R.l.dEn), new OnClickListener(this) {
                            final /* synthetic */ i pkT;

                            {
                                this.pkT = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.pkT.bjI();
                            }
                        }, null);
                    }
                } else if (i == 4 && i2 == -24 && !bh.ov(str)) {
                    Toast.makeText(this.pkA.fmM, str, 1).show();
                } else {
                    switch (i) {
                        case 1:
                            if (!ar.CG().Kn()) {
                                if (!ab.bC(this.pkA.mContext)) {
                                    i3 = 0;
                                    break;
                                }
                                com.tencent.mm.pluginsdk.ui.k.eo(this.pkA.mContext);
                                i3 = 1;
                                break;
                            }
                            ar.CG().getNetworkServerIp();
                            new StringBuilder().append(i2);
                            i3 = 1;
                            break;
                        case 2:
                            Toast.makeText(this.pkA.mContext, this.pkA.mContext.getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 3000).show();
                            i3 = 1;
                            break;
                        case 4:
                            if (i2 == -100) {
                                com.tencent.mm.ui.base.h.a(this.pkA.mContext, ar.Ci(), com.tencent.mm.bv.a.ac(this.pkA.mContext, R.l.dGO), new 1(this), new OnCancelListener(this) {
                                    final /* synthetic */ i pkT;

                                    {
                                        this.pkT = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        this.pkT.onStop();
                                        Intent intent = new Intent();
                                        intent.putExtra("Intro_Switch", true).addFlags(67108864);
                                        com.tencent.mm.plugin.profile.a.ifs.s(intent, this.pkT.pkA.mContext);
                                    }
                                });
                                i3 = 1;
                                break;
                            }
                            CharSequence string = (i == 4 && i2 == -34) ? this.pkA.fmM.getString(R.l.eik) : (i == 4 && i2 == -94) ? this.pkA.fmM.getString(R.l.eil) : this.pkA.fmM.getString(R.l.eKc);
                            Toast.makeText(this.pkA.fmM, string, 1).show();
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                    if (i3 == 0) {
                    }
                }
            }
        }
    }

    class j extends i implements e {
        final /* synthetic */ NormalUserFooterPreference pkA;

        public j(NormalUserFooterPreference normalUserFooterPreference) {
            this.pkA = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void bjF() {
            if (this.pkA.jLe == null || !com.tencent.mm.l.a.fZ(this.pkA.jLe.field_type)) {
                v(false, true);
            } else {
                bjE();
            }
        }

        protected final void bjD() {
            super.bjD();
            this.pkA.pkk.setVisibility(0);
            this.pkA.pkt.setVisibility(8);
            this.pkA.okw.setVisibility(8);
            this.pkA.pkw.setVisibility(8);
            this.pkA.pku.setVisibility(8);
            this.pkA.pkv.setVisibility(8);
            this.pkA.pkq.setVisibility(8);
            this.pkA.pkx.setVisibility(8);
            switch (this.pkA.phF) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 18:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 34:
                case 58:
                case 59:
                case 60:
                    this.pkA.pkp.setVisibility(0);
                    this.pkA.pko.setVisibility(0);
                    break;
                default:
                    this.pkA.pkp.setVisibility(8);
                    this.pkA.pko.setVisibility(8);
                    break;
            }
            if (this.pkA.jLe.AF()) {
                this.pkA.pkn.setText(this.pkA.fmM.getString(R.l.dVK));
                this.pkA.pkx.setVisibility(0);
            } else {
                this.pkA.pkn.setText(this.pkA.fmM.getString(R.l.dVH));
            }
            this.pkA.pkl.setOnClickListener(new 1(this));
            this.pkA.pkn.setOnClickListener(new 2(this));
        }

        protected final void onDetach() {
            super.onDetach();
        }

        protected final void bjJ() {
            super.bjJ();
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
            super.a(i, i2, str, kVar);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        this.fmM = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmM = (MMActivity) context;
        init();
    }

    private void init() {
        this.lRB = false;
        this.pkj = null;
    }

    private void initView() {
        if (!this.lRB || this.jLe == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lRB + " contact = " + this.jLe);
            return;
        }
        if (this.pkj != null) {
            this.pkj.EI();
        }
        bjA();
    }

    public final void onBindView(View view) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.pkk = view.findViewById(R.h.bXM);
        this.pkl = (Button) view.findViewById(R.h.bYc);
        this.pkm = (Button) view.findViewById(R.h.bXr);
        this.pkp = (Button) view.findViewById(R.h.bYe);
        this.pko = view.findViewById(R.h.bYf);
        this.pkn = (Button) view.findViewById(R.h.bYd);
        this.pkt = (Button) view.findViewById(R.h.bXm);
        this.pkq = view.findViewById(R.h.bXS);
        this.pkr = (Button) view.findViewById(R.h.bXR);
        this.pks = (Button) view.findViewById(R.h.bXT);
        this.okw = (Button) view.findViewById(R.h.bXU);
        this.pkw = (Button) view.findViewById(R.h.bXI);
        this.pku = (Button) view.findViewById(R.h.bYg);
        this.pkv = (Button) view.findViewById(R.h.bXp);
        this.pkx = (TextView) view.findViewById(R.h.bXJ);
        this.lRB = true;
        initView();
        super.onBindView(view);
        if (this.fmM.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.pkl != null) {
            this.pkl.performClick();
        }
    }

    public final boolean a(x xVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        arS();
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bh.ou(xVar.field_username).length() > 0);
        if (x.WD(q.FS()).equals(xVar.field_username)) {
            return false;
        }
        this.jLe = xVar;
        this.mOi = str;
        this.phD = z;
        this.phF = i;
        this.pji = i2;
        this.pkg = bh.a(Boolean.valueOf(s.gC(xVar.field_username)), false);
        this.pke = z4;
        this.pkf = z5;
        this.pjS = j;
        this.pjq = str2;
        this.pkz = false;
        this.pjw = xVar.field_deleteFlag == 1;
        this.pky = this.fmM.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.piQ = this.fmM.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.pkh = this.fmM.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.pki = this.fmM.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.kvB = this.fmM.getIntent().getStringExtra("lbs_ticket");
        if (!q.gr(xVar.field_username)) {
            ar.Hg();
            if (!c.Fg().has(xVar.field_username)) {
                if (x.Wx(xVar.field_username)) {
                    this.pkj = new h(this);
                } else if (s.gR(xVar.field_username)) {
                    this.pkj = new d(this);
                } else if (s.gC(xVar.field_username)) {
                    this.pkj = new g(this);
                } else if (x.Wy(xVar.field_username)) {
                    this.pkj = new f(this);
                } else if (com.tencent.mm.l.a.fZ(xVar.field_type) && !x.gy(xVar.field_username)) {
                    this.pkj = new c(this);
                    this.pkz = true;
                } else if (z2) {
                    this.pkj = new j(this);
                    this.pkz = true;
                } else if (z3 || x.gy(xVar.field_username)) {
                    this.pkj = new b(this);
                } else {
                    this.pkj = new c(this);
                    this.pkz = true;
                }
                initView();
                return true;
            }
        }
        this.pkj = new c(this);
        this.pkz = true;
        initView();
        return true;
    }

    public final boolean bjA() {
        if (this.pky && com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            this.pkw.setVisibility(0);
            return true;
        }
        this.pkw.setVisibility(8);
        return false;
    }

    public final boolean arS() {
        if (this.pkj != null) {
            this.pkj.onDetach();
        }
        this.hkZ.removeAll();
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        return true;
    }

    public final void a(String str, l lVar) {
        if (bh.ou(str).length() <= 0 || this.jLe == null) {
            return;
        }
        if (str.equals(this.jLe.field_username) || str.equals(this.jLe.field_encryptUsername)) {
            ar.Hg();
            this.jLe = c.EY().WO(this.jLe.field_username);
            ag.y(new 2(this));
        }
    }

    public final void bjB() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.RECORD_AUDIO", 82, "", "")), bh.cgy(), this.fmM);
        if (com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.RECORD_AUDIO", 82, "", "")) {
            com.tencent.mm.sdk.b.b spVar = new sp();
            spVar.fKq.fuL = 5;
            spVar.fKq.talker = this.jLe.field_username;
            spVar.fKq.context = this.fmM;
            spVar.fKq.fKl = 4;
            com.tencent.mm.sdk.b.a.xef.m(spVar);
        }
    }

    public final void bjC() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.CAMERA", 19, "", "")), bh.cgy(), this.fmM);
        if (com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.CAMERA", 19, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.RECORD_AUDIO", 19, "", "")), bh.cgy(), this.fmM);
            if (com.tencent.mm.pluginsdk.g.a.a(this.fmM, "android.permission.RECORD_AUDIO", 19, "", "")) {
                com.tencent.mm.sdk.b.b spVar = new sp();
                spVar.fKq.fuL = 5;
                spVar.fKq.talker = this.jLe.field_username;
                spVar.fKq.context = this.fmM;
                spVar.fKq.fKl = 2;
                com.tencent.mm.sdk.b.a.xef.m(spVar);
            }
        }
    }
}
