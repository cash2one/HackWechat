package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.chatroom.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Map;
import org.xwalk.core.R$styleable;

public class SelectMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> hdO = new f(32);
    private r jmO;
    private int kFr = 0;
    private String lbf;
    private MMLoadMoreListView ldB;
    private View ldC;
    private a ldD;
    private String ldE;
    private String mTitle;

    static /* synthetic */ void a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, long j) {
        x.i("MicroMsg.SelectMemberChattingRecordUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(j)});
        a.ifs.e(new Intent().putExtra("Chat_User", selectMemberChattingRecordUI.lbf).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), selectMemberChattingRecordUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SelectMemberChattingRecordUI", "[onCreate]");
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        this.ldE = getIntent().getStringExtra("room_member");
        x.i("MicroMsg.SelectMemberChattingRecordUI", "roomId:%s", new Object[]{this.lbf});
        this.mTitle = getIntent().getStringExtra("title");
        if (!bh.ov(this.ldE) && q.gr(this.ldE)) {
            ar.Hg();
            this.kFr = com.tencent.mm.z.c.Fa().EV(this.lbf);
        } else if (!q.gr(this.ldE)) {
            ar.Hg();
            this.kFr = com.tencent.mm.z.c.Fa().dm(this.lbf, this.ldE);
        }
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
    }

    protected final void initView() {
        super.initView();
        setMMTitle(bh.ou(this.mTitle));
        this.ldB = (MMLoadMoreListView) findViewById(R.h.cvH);
        this.ldB.cpp();
        this.ldD = new a(this, this, this.lbf, this.ldE, this.kFr);
        this.ldB.setAdapter(this.ldD);
        this.ldC = findViewById(R.h.cKW);
        if ((this.kFr == 0 ? 1 : 0) != 0) {
            this.ldC.setVisibility(0);
            this.ldB.setVisibility(8);
        }
        this.ldB.setOnItemClickListener(new 1(this));
        this.ldB.ybX = new 2(this);
        setBackBtn(new 3(this));
    }

    protected static String a(com.tencent.mm.storage.q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.gu(str);
    }

    protected final int getLayoutId() {
        return R.i.drF;
    }

    public static String a(Context context, int i, String str, String str2, int i2) {
        String str3 = "";
        g.a fT = g.a.fT(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.eCH, new Object[]{fT.title});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.eCx, new Object[]{fT.title});
            case 1:
                return str.substring(str.indexOf(":\n") + 1);
            case 3:
            case 23:
            case 33:
                return context.getString(R.l.dGj);
            case 34:
                n nVar = new n(str);
                return context.getString(R.l.eCK, new Object[]{Integer.valueOf((int) com.tencent.mm.modelvoice.q.bv(nVar.time))});
            case 37:
                if (str == null || str.length() <= 0) {
                    return str3;
                }
                d Xu = d.Xu(str);
                if (Xu.rYX == null || Xu.rYX.length() <= 0) {
                    return str3;
                }
                switch (Xu.scene) {
                    case 18:
                        return context.getString(R.l.ejd, new Object[]{Xu.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        return context.getString(R.l.ejn, new Object[]{Xu.getDisplayName()});
                    case 25:
                        return context.getString(R.l.eip, new Object[]{Xu.getDisplayName()});
                    default:
                        return context.getString(R.l.ejt, new Object[]{Xu.getDisplayName()});
                }
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                if (bh.ou(str).length() <= 0) {
                    return str3;
                }
                CharSequence hP = ba.hP(str);
                if (!TextUtils.isEmpty(hP)) {
                    CharSequence charSequence = hP;
                }
                ar.Hg();
                au.a EK = com.tencent.mm.z.c.Fa().EK(str);
                ar.Hg();
                str3 = com.tencent.mm.z.c.EY().WO(str2).AQ();
                if (s.eV(str3)) {
                    str3 = m.B(m.gm(str3));
                }
                if (i2 == 1) {
                    return context.getString(R.l.eiq, new Object[]{str3, EK.getDisplayName()});
                }
                return context.getString(R.l.eir, new Object[]{str3, EK.getDisplayName()});
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case 62:
                return context.getString(62 == i ? R.l.dGH : R.l.dGX);
            case 47:
                return context.getString(R.l.dEG);
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                ar.Hg();
                b EL = com.tencent.mm.z.c.Fa().EL(str);
                return context.getString(R.l.eCC, new Object[]{EL.label});
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                if (fT == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                }
                switch (fT.type) {
                    case 2:
                        return context.getString(R.l.dGj);
                    case 3:
                        return context.getString(R.l.eCD, new Object[]{fT.title});
                    case 4:
                        return context.getString(R.l.eCJ, new Object[]{fT.title});
                    case 5:
                        return context.getString(R.l.eCI, new Object[]{fT.getTitle()});
                    case 6:
                        return context.getString(R.l.eCB, new Object[]{fT.title});
                    case 7:
                        return str3;
                    case 8:
                        return context.getString(R.l.dEH);
                    case 15:
                    case 26:
                    case 27:
                        return context.getString(R.l.dEG);
                    case 17:
                        return context.getString(R.l.eCC, new Object[]{fT.title});
                    case 19:
                        return context.getString(R.l.eCF, new Object[]{fT.title});
                    case 24:
                        c cVar;
                        String str4 = fT.hbB;
                        if (bh.ov(str4)) {
                            x.e("MicroMsg.SelectMemberChattingRecordUI", "xml is null");
                            cVar = null;
                        } else {
                            int hashCode = str4.hashCode();
                            cVar = (c) hdO.get(Integer.valueOf(hashCode));
                            if (cVar != null) {
                                x.d("MicroMsg.SelectMemberChattingRecordUI", "get record msg data from cache");
                            } else {
                                Map y = str4.trim().startsWith("<recordinfo>") ? bi.y(str4, "recordinfo") : bi.y("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                if (y == null) {
                                    x.e("MicroMsg.SelectMemberChattingRecordUI", "values is null: %s", new Object[]{str4});
                                    cVar = null;
                                } else {
                                    c cVar2 = new c();
                                    cVar2.title = (String) y.get(".recordinfo.title");
                                    cVar2.desc = (String) y.get(".recordinfo.desc");
                                    cVar2.vCT = (String) y.get(".recordinfo.favusername");
                                    hdO.put(Integer.valueOf(hashCode), cVar2);
                                    cVar = cVar2;
                                }
                            }
                        }
                        str3 = cVar == null ? "" : cVar.desc;
                        return context.getString(R.l.eCE, new Object[]{bh.az(str3, "")});
                    case 25:
                        return context.getString(R.l.dEy);
                    default:
                        return "";
                }
            case 369098801:
            case 452984881:
                return context.getString(R.l.eCz, new Object[]{fT.title});
            case 419430449:
                str3 = context.getString(R.l.eCG);
                if (fT == null) {
                    return str3;
                }
                int i3 = i2 == 1 ? 1 : 0;
                switch (fT.hcd) {
                    case 1:
                        if (i3 != 0) {
                            return context.getString(R.l.dHg);
                        }
                        return context.getString(R.l.dHj);
                    case 3:
                        if (i3 != 0) {
                            return context.getString(R.l.dHh);
                        }
                        return context.getString(R.l.dHe);
                    case 4:
                        if (i3 != 0) {
                            return context.getString(R.l.dHi);
                        }
                        return context.getString(R.l.dHf);
                    default:
                        return bh.ou(fT.title);
                }
            case 436207665:
            case 469762097:
                if (fT == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, fT.hcB});
                } else {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, fT.hcA});
                }
            case 503316529:
                if (fT == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, fT.hcS});
                } else {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, fT.hcR});
                }
            case 520093745:
                return context.getString(R.l.eCz, new Object[]{""});
            default:
                return str3;
        }
    }
}
