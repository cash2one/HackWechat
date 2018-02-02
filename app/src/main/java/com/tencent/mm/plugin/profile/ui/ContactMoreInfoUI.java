package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.k.g;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

public class ContactMoreInfoUI extends MMActivity implements k {
    private String gAb;
    private af handler = new af(Looper.getMainLooper());
    q kZS;
    private x lFr;
    private String lbf;
    boolean lbx = false;
    private String nzw;
    private ProfileNormalItemView pie;
    private ProfileNormalItemView pif;
    private ProfileNormalItemView pig;
    private ProfileNormalItemView pih;
    private ProfileNormalItemView pii;
    private ProfileNormalItemView pij;
    private ProfileNormalItemView pik;
    private String pil;
    private String pim;
    private String pio;
    private long pip;
    private String piq;
    String pir = null;

    protected final int getLayoutId() {
        return R.i.deM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjs();
        initView();
    }

    protected final void initView() {
        ProfileNormalItemView profileNormalItemView;
        boolean z = false;
        super.initView();
        this.pie = (ProfileNormalItemView) findViewById(R.h.csX);
        this.pif = (ProfileNormalItemView) findViewById(R.h.cnM);
        this.pig = (ProfileNormalItemView) findViewById(R.h.cEm);
        this.pij = (ProfileNormalItemView) findViewById(R.h.cOx);
        this.pij.uS(R.l.dWw);
        this.pij.pfl.setSingleLine(false);
        this.pik = (ProfileNormalItemView) findViewById(R.h.ckc);
        this.pik.uS(R.l.dWZ);
        this.pii = (ProfileNormalItemView) findViewById(R.h.cZr);
        this.pih = (ProfileNormalItemView) findViewById(R.h.bWI);
        setBackBtn(new 1(this));
        bjs();
        ar.Hg();
        this.kZS = c.Fh().hD(this.lbf);
        String value = g.zY().getValue("LinkedinPluginClose");
        boolean z2 = bh.ov(value) || Integer.valueOf(value).intValue() == 0;
        boolean z3;
        if (!z2 || bh.ov(this.lFr.fWA)) {
            this.pie.setVisibility(8);
            z3 = false;
        } else {
            this.pie.setVisibility(0);
            if (bh.ov(this.pil)) {
                this.pil = this.lFr.fWB;
            }
            profileNormalItemView = this.pie;
            profileNormalItemView.pkW = this.pil;
            profileNormalItemView.pkX = new 3(this);
            z3 = profileNormalItemView.uU(getResources().getColor(R.e.bty)).bjL();
        }
        this.pif.setVisibility(0);
        profileNormalItemView = this.pif;
        profileNormalItemView.pkW = this.nzw;
        boolean bjL = profileNormalItemView.bjL();
        ar.Hg();
        int e = bh.e((Integer) c.CU().get(9, null));
        this.pip = getIntent().getLongExtra("Contact_Uin", 0);
        this.piq = getIntent().getStringExtra("Contact_QQNick");
        boolean z4;
        if (this.pip == 0 || e == 0) {
            this.pig.setVisibility(8);
            z4 = false;
        } else {
            if (this.piq == null || this.piq.length() == 0) {
                ad be = com.tencent.mm.modelfriend.af.OI().be(this.pip);
                if (be == null) {
                    be = null;
                }
                if (be != null) {
                    this.piq = be.getDisplayName();
                }
            }
            CharSequence charSequence = bh.ou(this.piq) + " " + new o(this.pip).longValue();
            this.pig.setVisibility(0);
            ProfileNormalItemView profileNormalItemView2 = this.pig;
            profileNormalItemView2.pkW = charSequence;
            profileNormalItemView2.pkX = new 4(this);
            z4 = profileNormalItemView2.bjL();
        }
        profileNormalItemView = this.pij;
        profileNormalItemView.pkW = i.a(this, this.lFr.signature);
        boolean bjL2 = profileNormalItemView.bjL();
        switch (this.lFr.getSource()) {
            case 1:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWR);
                    break;
                } else {
                    this.pik.uT(R.l.dWS);
                    break;
                }
            case 3:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWT);
                    break;
                } else {
                    this.pik.uT(R.l.dWU);
                    break;
                }
            case 4:
            case 12:
                this.pik.uT(R.l.eie);
                break;
            case 8:
            case 14:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWG);
                    break;
                } else {
                    this.pik.uT(R.l.dWH);
                    break;
                }
            case 10:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWX);
                    break;
                } else {
                    this.pik.uT(R.l.dWY);
                    break;
                }
            case 13:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWX);
                    break;
                } else {
                    this.pik.uT(R.l.dWY);
                    break;
                }
            case 15:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWP);
                    break;
                } else {
                    this.pik.uT(R.l.dWQ);
                    break;
                }
            case 17:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWD);
                    break;
                } else {
                    this.pik.uT(R.l.dWF);
                    break;
                }
            case 18:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWJ);
                    break;
                } else {
                    this.pik.uT(R.l.dWK);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWV);
                    break;
                } else {
                    this.pik.uT(R.l.dWW);
                    break;
                }
            case 25:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWB);
                    break;
                } else {
                    this.pik.uT(R.l.dWC);
                    break;
                }
            case 30:
                if (this.lFr.AS() <= Constants.MAX_BUFFER_SIZE) {
                    this.pik.uT(R.l.dWM);
                    break;
                } else {
                    this.pik.uT(R.l.dWN);
                    break;
                }
            case 34:
                this.pik.uT(R.l.dWA);
                break;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                this.pik.uT(R.l.dWO);
                break;
            case 58:
            case 59:
            case 60:
                this.pik.uT(R.l.enp);
                break;
            case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                this.pik.uT(R.l.dWL);
                break;
            default:
                this.pik.pkW = null;
                break;
        }
        boolean bjL3 = this.pik.bjL();
        boolean G = G(this.lFr);
        if (!this.lFr.field_username.equals(com.tencent.mm.z.q.FS())) {
            com.tencent.mm.g.b.af afVar = this.lFr;
            if (afVar.field_username.equals(com.tencent.mm.z.q.FS())) {
                this.pih.setVisibility(8);
            } else {
                if (afVar.fWf == 1) {
                    this.pih.uS(R.l.dUK);
                } else if (afVar.fWf == 2) {
                    this.pih.uS(R.l.dUJ);
                } else {
                    this.pih.uS(R.l.dUM);
                }
                this.pih.bjL();
                com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                gVar.fDj = afVar.field_username;
                gVar.mLZ = this;
                gVar.handler = this.handler;
                gVar.mLR = 5;
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
                z = true;
            }
        }
        if (!bjL2 && !bjL3 && !G && !r1 && !bjL && !r3 && !r2) {
            finish();
        }
    }

    private boolean G(x xVar) {
        String str;
        CharSequence optString;
        if (com.tencent.mm.z.q.FS().equals(xVar.field_username)) {
            ar.Hg();
            str = (String) c.CU().get(a.xpK, null);
        } else {
            str = xVar.fWD;
        }
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.pir = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (bh.ov(this.pir)) {
                this.pii.setVisibility(0);
                this.pii.pkW = optString;
                this.pii.uU(getResources().getColor(R.e.bty));
                ProfileNormalItemView profileNormalItemView = this.pii;
                profileNormalItemView.pkX = new 2(this);
                profileNormalItemView.bjL();
                return true;
            }
            this.pii.setVisibility(8);
            return false;
        }
        optString = null;
        if (bh.ov(this.pir)) {
            this.pii.setVisibility(8);
            return false;
        }
        this.pii.setVisibility(0);
        this.pii.pkW = optString;
        this.pii.uU(getResources().getColor(R.e.bty));
        ProfileNormalItemView profileNormalItemView2 = this.pii;
        profileNormalItemView2.pkX = new 2(this);
        profileNormalItemView2.bjL();
        return true;
    }

    private void bjs() {
        this.lbx = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lbf = getIntent().getStringExtra("Contact_ChatRoomId");
        this.gAb = getIntent().getStringExtra("Contact_User");
        ar.Hg();
        this.lFr = c.EY().WO(this.gAb);
        this.pil = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.pim = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.nzw = getIntent().getStringExtra("verify_gmail");
        this.pio = getIntent().getStringExtra("profileName");
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            int intValue = ((Integer) ((j) hVar.mMc.get(0)).userData).intValue();
            this.pih.pkW = getString(R.l.dUL, new Object[]{Integer.valueOf(intValue)});
            this.pih.pkX = new 5(this, intValue);
        } else {
            this.pih.pkW = getString(R.l.dUL, new Object[]{Integer.valueOf(0)});
        }
        this.pih.bjL();
    }
}
