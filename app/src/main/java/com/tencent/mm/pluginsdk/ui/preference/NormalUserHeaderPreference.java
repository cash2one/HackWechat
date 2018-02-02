package com.tencent.mm.pluginsdk.ui.preference;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.bf.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements a, g.a, b {
    MMActivity fmM;
    x jLe;
    private boolean lRB = false;
    private String mOi;
    private TextView nqD;
    private ClipboardManager oJY;
    private ImageView pho;
    private TextView phr;
    private boolean pjp;
    private boolean pjw = false;
    private boolean pky = false;
    private ImageView qqG;
    int qra;
    public String vkI;
    public String vkJ;
    private TextView vtA;
    private ImageView vtB;
    private CheckBox vtC;
    private ImageView vtD;
    private ImageView vtE;
    private LinearLayout vtF;
    private Button vtG;
    private FMessageListView vtH;
    private int vtI = 0;
    private boolean vtJ = false;
    private boolean vtK = false;
    private boolean vtL = false;
    private boolean vtM = false;
    private boolean vtN = false;
    private boolean vtO = false;
    private boolean vtP = false;
    private boolean vtQ = false;
    private String vtR;
    private ProfileMobilePhoneView vtS;
    private ProfileDescribeView vtT;
    private ProfileLabelView vtU;
    private TextView vtV;
    public OnClickListener vtW;
    public String vtX = null;
    private TextView vtu;
    private TextView vtv;
    private TextView vtw;
    private View vtx;
    private Button vty;
    private Button vtz;

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        init();
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmM = (MMActivity) context;
        init();
    }

    private void init() {
        this.lRB = false;
        this.oJY = (ClipboardManager) this.fmM.getSystemService("clipboard");
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        if (this.vtH != null) {
            this.vtH.detach();
        }
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.nqD = (TextView) view.findViewById(R.h.bXK);
        this.phr = (TextView) view.findViewById(R.h.bYb);
        this.vtA = (TextView) view.findViewById(R.h.bXl);
        this.vtu = (TextView) view.findViewById(R.h.bXq);
        this.vtv = (TextView) view.findViewById(R.h.bXL);
        this.vty = (Button) view.findViewById(R.h.bXQ);
        this.vtz = (Button) view.findViewById(R.h.bXY);
        this.vtS = (ProfileMobilePhoneView) view.findViewById(R.h.cwL);
        ProfileMobilePhoneView profileMobilePhoneView = this.vtS;
        ar.Hg();
        profileMobilePhoneView.vkS = ((Boolean) c.CU().get(w.a.xpr, Boolean.valueOf(false))).booleanValue();
        this.vtT = (ProfileDescribeView) view.findViewById(R.h.caQ);
        this.vtU = (ProfileLabelView) view.findViewById(R.h.csg);
        this.vtV = (TextView) view.findViewById(R.h.cLH);
        this.vtT.setOnClickListener(this.vtW);
        this.vtU.setOnClickListener(this.vtW);
        this.vtV.setOnClickListener(this.vtW);
        if (q.gr(this.jLe.field_username) || (!bh.ov(this.jLe.field_username) && s.hg(this.jLe.field_username))) {
            this.vtV.setVisibility(8);
            this.vtS.setVisibility(8);
            this.vtT.setVisibility(8);
            this.vtU.setVisibility(8);
        } else {
            ProfileMobilePhoneView profileMobilePhoneView2 = this.vtS;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[]{this.vkI, this.vkJ});
            profileMobilePhoneView2.vkI = r2;
            profileMobilePhoneView2.vkJ = r3;
            profileMobilePhoneView2.bjL();
            if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                this.vtS.setVisibility(0);
            } else {
                this.vtS.setVisibility(8);
            }
            boolean L = this.vtT.L(this.jLe);
            boolean L2 = this.vtU.L(this.jLe);
            if (L || L2) {
                this.vtV.setVisibility(8);
            } else {
                if (this.vtP || this.vtN) {
                    this.vtV.setVisibility(8);
                } else {
                    this.vtV.setVisibility(0);
                }
                if (this.vtX != null && (this.vtX.equals("ContactWidgetBottleContact") || this.vtX.equals("ContactWidgetQContact"))) {
                    this.vtV.setVisibility(8);
                }
            }
        }
        this.vtw = (TextView) view.findViewById(R.h.bXy);
        this.vtG = (Button) view.findViewById(R.h.bXu);
        this.vtH = (FMessageListView) view.findViewById(R.h.bXv);
        a.a aVar = new a.a();
        aVar.talker = this.jLe.field_username;
        aVar.scene = this.qra;
        aVar.mOi = this.mOi;
        aVar.vtc = this.jLe.fWF;
        aVar.type = 0;
        if (this.qra == 18) {
            aVar.type = 1;
        } else if (ba.gS(this.qra)) {
            aVar.type = 2;
        }
        this.vtH.vsW = aVar;
        a.vsW = aVar;
        this.vtx = view.findViewById(R.h.cOF);
        this.vtF = (LinearLayout) view.findViewById(R.h.coj);
        this.pho = (ImageView) view.findViewById(R.h.bXn);
        this.qqG = (ImageView) view.findViewById(R.h.bXV);
        this.vtB = (ImageView) view.findViewById(R.h.bYh);
        this.vtC = (CheckBox) view.findViewById(R.h.bXZ);
        this.vtD = (ImageView) view.findViewById(R.h.bXX);
        this.vtE = (ImageView) view.findViewById(R.h.bXW);
        this.lRB = true;
        initView();
        if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.vtH.setVisibility(8);
            if (this.vtH.getVisibility() == 8 && this.vtV.getVisibility() == 8 && this.vtU.getVisibility() == 8 && this.vtT.getVisibility() == 8 && this.vtw.getVisibility() == 8) {
                this.vtx.setVisibility(8);
            }
        } else if (this.mOi == null || this.mOi.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.qra + ", verifyTicket = " + this.mOi);
            this.vtH.setVisibility(8);
            if (this.vtH.getVisibility() == 8 && this.vtV.getVisibility() == 8 && this.vtU.getVisibility() == 8 && this.vtT.getVisibility() == 8 && this.vtw.getVisibility() == 8) {
                this.vtx.setVisibility(8);
            }
        } else {
            b[] a;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.qra);
            if (this.qra == 18) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.fmM, l.Ty().na(this.jLe.field_username));
            } else if (ba.gS(this.qra)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.fmM, l.Tz().nf(this.jLe.field_username));
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.fmM, l.Tw().mV(this.jLe.field_username));
            }
            if (a == null || a.length == 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.vtH.setVisibility(8);
                if (this.vtH.getVisibility() == 8 && this.vtV.getVisibility() == 8 && this.vtU.getVisibility() == 8 && this.vtT.getVisibility() == 8 && this.vtw.getVisibility() == 8) {
                    this.vtx.setVisibility(8);
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.fpL + ", digest = " + bVar.hef + ", addScene = " + bVar.qra);
                    }
                }
                this.vtH.setVisibility(0);
                if (this.vtH.getVisibility() == 0 || this.vtV.getVisibility() == 0 || this.vtU.getVisibility() == 0 || this.vtT.getVisibility() == 0 || this.vtw.getVisibility() == 0) {
                    this.vtx.setVisibility(0);
                }
                for (b a2 : a) {
                    this.vtH.a(a2);
                }
            }
        }
        super.onBindView(view);
    }

    private boolean bjr() {
        return this.lRB && this.jLe != null;
    }

    private void bnP() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.pho, this.jLe.field_username);
        if (this.pho != null) {
            int aa = com.tencent.mm.bv.a.aa(this.mContext, R.f.bup);
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.fmM, 88);
            if (aa <= fromDPToPix) {
                fromDPToPix = aa;
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.bv.a.ab(this.mContext, R.f.bvw), 0);
            this.pho.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        int i = 0;
        if (!bjr()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
        } else if (this.pjw) {
            this.vtA.setVisibility(0);
            this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.AP()) + " ", this.nqD.getTextSize()));
            bnP();
            this.vtG.setVisibility(8);
            this.phr.setVisibility(8);
            this.vtH.setVisibility(8);
            if (this.vtH.getVisibility() == 8 && this.vtV.getVisibility() == 8 && this.vtU.getVisibility() == 8 && this.vtT.getVisibility() == 8 && this.vtw.getVisibility() == 8) {
                this.vtx.setVisibility(8);
            }
            this.vty.setVisibility(8);
            this.vtz.setVisibility(8);
            this.vtC.setVisibility(8);
            if (this.vtU != null) {
                this.vtU.setVisibility(8);
            }
            if (this.vtS != null) {
                this.vtS.setVisibility(8);
            }
            if (this.vtT != null) {
                this.vtT.setVisibility(8);
            }
            if (this.vtV != null) {
                this.vtV.setVisibility(8);
            }
            if (this.vtv != null) {
                this.vtv.setVisibility(8);
            }
        } else {
            boolean gy = x.gy(this.jLe.field_username);
            if (gy) {
                this.nqD.setText("");
                if (x.WD(q.FS()).equals(this.jLe.field_username)) {
                    this.vtG.setVisibility(0);
                    this.vtG.setOnClickListener(new 1(this));
                }
            } else {
                this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.AP()) + " ", this.nqD.getTextSize()));
            }
            this.qqG.setVisibility(0);
            this.vtL = true;
            if (this.jLe.fWf == 1) {
                this.qqG.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.dyN));
                this.qqG.setContentDescription(this.mContext.getString(R.l.eBg));
            } else if (this.jLe.fWf == 2) {
                this.qqG.setImageDrawable(com.tencent.mm.bv.a.b(this.fmM, R.k.dyM));
                this.qqG.setContentDescription(this.mContext.getString(R.l.eBf));
            } else if (this.jLe.fWf == 0) {
                this.qqG.setVisibility(8);
                this.vtL = false;
            }
            if (this.jLe.field_verifyFlag != 0) {
                Bitmap b;
                this.vtB.setVisibility(0);
                if (ak.a.hfN != null) {
                    b = BackwardSupportUtil.b.b(ak.a.hfN.gO(this.jLe.field_verifyFlag), 2.0f);
                } else {
                    b = null;
                }
                this.vtB.setImageBitmap(b);
                this.vtI = b == null ? 0 : b.getWidth();
            }
            bnP();
            this.pho.setOnClickListener(new 2(this));
            if (x.Wz(this.jLe.field_username)) {
                this.phr.setText(this.mContext.getString(R.l.dEZ) + this.jLe.AR());
            } else if (x.Wx(this.jLe.field_username)) {
                this.phr.setText(this.mContext.getString(R.l.dFi) + this.jLe.AR());
            } else if (this.pjp) {
                if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                    cck();
                } else if (this.jLe.fWr == null || this.jLe.fWr.equals("")) {
                    this.phr.setText(R.l.dEJ);
                } else {
                    this.phr.setText(this.jLe.fWr);
                }
            } else if (gy) {
                this.phr.setText((bh.ou(r.gw(this.jLe.getProvince())) + " " + bh.ou(this.jLe.getCity())).trim());
            } else {
                if (!x.Wy(this.jLe.field_username) && this.fmM.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (bh.ov(this.jLe.vN()) && (x.WB(this.jLe.field_username) || s.gD(this.jLe.field_username))) {
                        this.phr.setVisibility(8);
                    } else if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                        cck();
                    }
                }
                this.phr.setVisibility(8);
            }
            if (s.hg(this.jLe.field_username)) {
                this.vtw.setVisibility(0);
            } else {
                this.vtw.setVisibility(8);
            }
            ccm();
            ccl();
            ccn();
            if (bh.ov(this.vtR)) {
                this.vtu.setVisibility(8);
            } else {
                if (!q.gr(this.jLe.field_username) && bh.ou(this.jLe.field_conRemark).length() > 0) {
                    this.phr.setVisibility(8);
                }
                this.vtu.setVisibility(0);
                this.vtu.setText(i.b(this.fmM, this.fmM.getString(R.l.dUF) + this.vtR, this.vtu.getTextSize()));
            }
            this.vty.setOnClickListener(new 3(this));
            this.vtz.setOnClickListener(new 4(this));
            if (this.vtL) {
                i = com.tencent.mm.bv.a.fromDPToPix(this.fmM, 17) + 0;
            }
            int i2 = this.vtI + i;
            if (this.vtJ) {
                i2 += com.tencent.mm.bv.a.fromDPToPix(this.fmM, 27);
            }
            if (this.vtK) {
                i2 += com.tencent.mm.bv.a.fromDPToPix(this.fmM, 27);
            }
            if (this.vtM) {
                i2 += com.tencent.mm.bv.a.fromDPToPix(this.fmM, 30);
            }
            this.nqD.setMaxWidth(this.fmM.getResources().getDisplayMetrics().widthPixels - ((com.tencent.mm.bv.a.ey(this.mContext) ? i2 + com.tencent.mm.bv.a.fromDPToPix(this.fmM, 88) : i2 + com.tencent.mm.bv.a.fromDPToPix(this.fmM, 64)) + com.tencent.mm.bv.a.fromDPToPix(this.fmM, 60)));
            this.phr.setLongClickable(true);
            this.phr.setOnLongClickListener(new 5(this));
        }
    }

    public final void cck() {
        x.chZ();
        this.phr.setVisibility(0);
        if (!bh.ov(this.jLe.vN())) {
            this.phr.setText(this.mContext.getString(R.l.dFe) + this.jLe.vN());
        } else if (x.WB(this.jLe.field_username) || s.gD(this.jLe.field_username)) {
            this.phr.setVisibility(8);
        } else {
            this.phr.setText(this.mContext.getString(R.l.dFe) + bh.ou(this.jLe.AR()));
        }
    }

    public final void bc(String str, boolean z) {
        if (str != null && str.equals(this.jLe.field_username)) {
            this.vtN = z;
        }
    }

    public final void bd(String str, boolean z) {
        if (str != null && str.equals(this.jLe.field_username)) {
            this.vtO = z;
        }
    }

    public final void a(x xVar, int i, String str) {
        boolean z;
        boolean z2 = true;
        onDetach();
        ar.Hg();
        c.EY().a(this);
        ar.Hg();
        c.EZ().a(this);
        n.Jz().d(this);
        this.jLe = xVar;
        this.qra = i;
        this.mOi = str;
        this.pjp = this.fmM.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.vtQ = this.fmM.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.vtN = this.fmM.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.vtO = this.fmM.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.vtP = this.fmM.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.pky = this.fmM.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.vtR = this.fmM.getIntent().getStringExtra("Contact_RoomNickname");
        if (xVar.field_deleteFlag == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pjw = z;
        String str2 = "initView: contact username is null";
        if (bh.ou(xVar.field_username).length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        initView();
    }

    public final void onDetach() {
        if (this.vtH != null) {
            this.vtH.detach();
        }
        if (this.vtQ) {
            l.Tx().mS(this.jLe.field_username);
        }
        this.fmM.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.vtN);
        this.fmM.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.vtO);
        ar.Hg();
        c.EY().b(this);
        n.Jz().e(this);
        ar.Hg();
        c.EZ().b(this);
    }

    private void ccl() {
        int i = 0;
        if (this.vtD != null && s.gx(this.jLe.field_username)) {
            this.vtK = this.jLe.AK();
            this.vtD.setVisibility(this.vtK ? 0 : 8);
        }
        if (this.vtE != null && s.gx(this.jLe.field_username)) {
            boolean Y;
            String str = this.jLe.field_username;
            if (com.tencent.mm.plugin.sns.b.n.qQB != null) {
                Y = com.tencent.mm.plugin.sns.b.n.qQB.Y(str, 5);
            } else {
                Y = false;
            }
            this.vtJ = Y;
            ImageView imageView = this.vtE;
            if (!this.vtJ) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private void ccm() {
        if (q.gr(this.jLe.field_username) || bh.ou(this.jLe.field_conRemark).length() <= 0) {
            this.vtv.setVisibility(8);
            this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.AP()) + " ", this.nqD.getTextSize()));
            if (this.vtP) {
                this.vty.setVisibility(0);
                this.vtV.setVisibility(8);
            } else if (this.vtN) {
                this.vty.setVisibility(0);
                this.vtV.setVisibility(8);
            } else {
                if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                    this.vty.setVisibility(8);
                }
                boolean L = this.vtT.L(this.jLe);
                boolean L2 = this.vtU.L(this.jLe);
                if (L || L2) {
                    this.vtV.setVisibility(8);
                }
            }
        } else {
            this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.field_conRemark) + " ", this.nqD.getTextSize()));
            this.vtv.setVisibility(0);
            this.vtv.setText(i.b(this.fmM, this.mContext.getString(R.l.dVL) + this.jLe.AP(), this.vtv.getTextSize()));
            this.vty.setVisibility(8);
        }
        if (this.pky && !com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            this.vtz.setVisibility(0);
        } else if (this.vtO) {
            this.vtz.setVisibility(0);
            if (com.tencent.mm.bv.a.ey(this.fmM)) {
                this.vtz.setTextSize(0, (float) this.fmM.getResources().getDimensionPixelSize(R.f.bvs));
                this.vty.setTextSize(0, (float) this.fmM.getResources().getDimensionPixelSize(R.f.bvs));
            }
        } else {
            this.vtz.setVisibility(8);
        }
        if (x.gy(this.jLe.field_username)) {
            this.nqD.setText("");
        }
        if (this.qra == 76 && this.jLe.field_username != null && this.jLe.field_username.endsWith("@stranger")) {
            this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.field_nickname) + " ", this.nqD.getTextSize()));
        }
        if (this.vtz.getVisibility() == 0 && this.vtv.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.vtv.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bvS);
            this.vtv.setLayoutParams(layoutParams);
        }
    }

    private void ccn() {
        this.vtC.setClickable(false);
        if (s.gx(this.jLe.field_username) && com.tencent.mm.l.a.fZ(this.jLe.field_type) && !q.gr(this.jLe.field_username)) {
            this.vtC.setVisibility(0);
            if (this.jLe.AH()) {
                this.vtC.setChecked(true);
                this.vtM = true;
                return;
            }
            this.vtC.setChecked(false);
            this.vtC.setVisibility(8);
            this.vtM = false;
            return;
        }
        this.vtM = false;
        this.vtC.setVisibility(8);
    }

    public final void jh(String str) {
        if (!bjr()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
        } else if (bh.ou(str).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + str);
        } else if (str.equals(this.jLe.field_username)) {
            initView();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.jLe);
        if (!bjr()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
        } else if (bh.ou(str).length() > 0 && this.jLe != null && this.jLe.field_username.equals(str)) {
            ar.Hg();
            this.jLe = c.EY().WO(str);
            ag.y(new 6(this));
        }
    }

    public final void a(bf bfVar) {
        ag.y(new 7(this, bfVar));
    }
}
