package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.h;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private int ilp = -1;
    private ListView oOC;
    private TextView psF;
    private boolean zcA;
    private LinkedList<wh> zcz = new LinkedList();
    private b zdo;
    private LinkedList<ate> zdp = new LinkedList();
    private boolean zdq = false;

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        for (int i = 0; i < recommendFriendUI.zdo.cwU().length; i++) {
            ar.Hg();
            c.EX().b(new h(recommendFriendUI.zdo.cwU()[i], recommendFriendUI.ilp));
            q qVar = new q();
            qVar.username = recommendFriendUI.zdo.cwU()[i];
            qVar.hwn = recommendFriendUI.ilp;
            qVar.hpd = (int) bh.Wo();
            af.OH().a(qVar);
        }
        com.tencent.mm.ui.base.h.a(recommendFriendUI.mController.xIM, R.l.epV, R.l.dGO, new 6(recommendFriendUI));
    }

    protected final int getLayoutId() {
        return R.i.dlM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilp = bh.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.zcA = false;
        ar.CG().a(a.CTRL_INDEX, this);
        initView();
    }

    protected final void initView() {
        this.psF = (TextView) findViewById(R.h.ces);
        if (this.ilp == 1) {
            setMMTitle(R.l.eML);
            this.psF.setText(R.l.eMN);
        } else if (this.ilp == 2) {
            setMMTitle(R.l.eMK);
            this.psF.setText(R.l.eMM);
        } else {
            setMMTitle(R.l.eLy);
            this.psF.setText(R.l.eMO);
        }
        this.zdo = new b(getLayoutInflater());
        this.oOC = (ListView) findViewById(R.h.cqp);
        this.oOC.setOnItemClickListener(new 1(this));
        this.oOC.setAdapter(this.zdo);
        addTextOptionMenu(0, getString(R.l.epU), new 2(this));
        showOptionMenu(false);
        this.zdq = true;
        k pVar = new p(this.ilp);
        ar.CG().a(pVar, 0);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(context, getString(R.l.epX), true, new 5(this, pVar));
        setBackBtn(new 3(this));
        4 4 = new 4(this);
    }

    private void goBack() {
        if (this.ilp != 0) {
            finish();
        } else if (this.zcA || this.zdq) {
            finish();
        } else {
            cwW();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        ar.CG().b(a.CTRL_INDEX, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 0 && i2 == 0 && kVar.getType() == a.CTRL_INDEX) {
            this.zdp = ((atb) ((p) kVar).gJQ.hmh.hmo).nfM;
            this.zcz = ((atb) ((p) kVar).gJQ.hmh.hmo).vHz;
            this.zdq = false;
            if (this.zdp.size() <= 0) {
                cwV();
                return;
            } else if (this.ilp == 0 && this.zcz.size() <= 0) {
                cwV();
                return;
            } else if (this.ilp != 0) {
                Gv(-1);
                return;
            } else {
                cwW();
                return;
            }
        }
        cwV();
    }

    private void cwV() {
        this.psF.setVisibility(0);
        this.oOC.setVisibility(8);
    }

    private void Gv(int i) {
        x.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.zdp.size());
        this.zdo.h(this.zdp, i);
        this.oOC.setAdapter(this.zdo);
        this.zcA = false;
        if (this.ilp == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.zcz.size()) {
                String str2;
                if (i == ((wh) this.zcz.get(i2)).wgF) {
                    str2 = ((wh) this.zcz.get(i2)).wgG;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            setMMTitle(str);
        }
        this.zdo.zcA = this.zcA;
        this.zdo.notifyDataSetChanged();
    }

    private void cwW() {
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.ilp == 0);
        x.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.zcz.size());
        this.zdo.zcz = this.zcz;
        this.oOC.setAdapter(this.zdo);
        showOptionMenu(false);
        this.zcA = true;
        setMMTitle(R.l.eLy);
        this.zdo.zcA = this.zcA;
        this.zdo.notifyDataSetChanged();
    }
}
