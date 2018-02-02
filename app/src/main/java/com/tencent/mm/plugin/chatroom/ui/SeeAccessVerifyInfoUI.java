package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SeeAccessVerifyInfoUI extends MMActivity {
    private long hzJ;
    private q kZS;
    private c lcA;
    private b lcB;
    private String lcC;
    private String lcD;
    private String lcE;
    private String lcF;
    private String lcG;
    private String lcH;
    private String lcI;
    private String lcJ;
    private TextView lcK;
    private TextView lcL;
    private ImageView lcM;
    private TextView lcN;
    private TextView lcO;
    private GridView lcP;
    private r tipDialog;

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        if (bh.ov(str2)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(str);
            if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                str2 = EZ.field_conRemark;
            }
        }
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            x.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", new Object[]{seeAccessVerifyInfoUI.lcJ});
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.lcJ);
            if (seeAccessVerifyInfoUI.kZS != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.kZS.gu(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.lcH);
            ar.Hg();
            af WO = c.EY().WO(str);
            if (WO != null && ((int) WO.gJd) > 0 && a.fZ(WO.field_type)) {
                b oxVar = new ox();
                oxVar.fGO.intent = intent;
                oxVar.fGO.username = str;
                com.tencent.mm.sdk.b.a.xef.m(oxVar);
            }
            if (WO != null && WO.cia()) {
                g.pQN.k(10298, WO.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.lcH);
            com.tencent.mm.plugin.chatroom.a.ifs.d(intent, seeAccessVerifyInfoUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(R.l.dCf));
        this.hzJ = getIntent().getLongExtra("msgLocalId", 0);
        this.lcF = getIntent().getStringExtra("invitertitle");
        this.lcG = getIntent().getStringExtra("inviterusername");
        this.lcH = getIntent().getStringExtra("chatroom");
        this.lcI = getIntent().getStringExtra("invitationreason");
        this.lcJ = getIntent().getStringExtra("ticket");
        this.lcD = getIntent().getStringExtra("username");
        this.lcC = getIntent().getStringExtra("nickname");
        this.lcE = getIntent().getStringExtra("headimgurl");
        this.lcA = ar.Hg();
        this.kZS = c.Fh().hD(bh.ou(this.lcH));
        this.lcB = new b(this, this);
        initView();
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.drz;
    }

    protected final void initView() {
        CharSequence charSequence = null;
        this.lcK = (TextView) findViewById(R.h.cqn);
        this.lcL = (TextView) findViewById(R.h.cqm);
        this.lcN = (TextView) findViewById(R.h.cIs);
        this.lcM = (ImageView) findViewById(R.h.cIt);
        this.lcO = (TextView) findViewById(R.h.bIp);
        this.lcP = (GridView) findViewById(R.h.bMK);
        this.lcP.setAdapter(this.lcB);
        if (this.lcM != null) {
            this.lcM.setOnClickListener(new 2(this));
        }
        this.lcP.setOnTouchListener(new 3(this));
        this.lcP.postDelayed(new 4(this), 100);
        if (this.lcM != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.lcM, bh.ou(this.lcG));
        }
        if (this.lcN != null) {
            TextView textView = this.lcN;
            String ou = bh.ou(this.lcG);
            TextView textView2 = this.lcN;
            if (textView2 != null) {
                af WO = c.EY().WO(bh.ou(ou));
                if (WO == null) {
                    x.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    ou = !bh.ov(WO.field_conRemark) ? WO.field_conRemark : this.kZS != null ? this.kZS.gu(ou) : null;
                    if (bh.ov(ou)) {
                        ou = WO.field_conRemark;
                    }
                    if (bh.ov(ou)) {
                        ou = WO.AP();
                    }
                    charSequence = i.b(this, bh.ou(ou), textView2.getTextSize());
                }
            }
            textView.setText(charSequence);
        }
        if (this.lcK != null) {
            this.lcK.setText(i.a(this, bh.ou(this.lcF)));
        }
        if (!(this.lcL == null || bh.ov(this.lcI))) {
            this.lcL.setText(i.a(this, "\"" + bh.ou(this.lcI) + "\""));
        }
        if (this.lcO != null) {
            this.lcO.setOnClickListener(new 5(this));
        }
        if (this.lcO != null) {
            ar.Hg();
            if (c.Fa().dH(this.hzJ).cjz()) {
                this.lcO.setBackgroundResource(R.g.bAc);
                this.lcO.setTextColor(getResources().getColor(R.e.bsH));
                this.lcO.setText(getString(R.l.eoZ));
                this.lcO.setEnabled(false);
            }
        }
    }

    protected final c ck(View view) {
        c cVar = new c(this);
        cVar.iip = (ImageView) view.findViewById(R.h.cIt);
        cVar.lcV = (TextView) view.findViewById(R.h.cIs);
        return cVar;
    }
}
