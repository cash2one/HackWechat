package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.q;

@a(17)
public class SnsCommentUI extends MMActivity implements e {
    private int fug;
    private int qQY;
    private SnsEditText rBr;
    private int rBs = 0;
    private boolean rBt = false;
    private boolean rBu = false;
    private r tipDialog = null;

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        m xo = ae.bvv().xo(snsCommentUI.qQY);
        if (xo != null) {
            snsCommentUI.rBt = true;
            if (xo.byp()) {
                al.a.a(xo, 2, str, "", snsCommentUI.fug);
            } else {
                al.a.a(xo.field_userName, 3, str, xo, snsCommentUI.fug);
            }
            snsCommentUI.aWs();
            snsCommentUI.getString(j.dGO);
            snsCommentUI.tipDialog = h.a(snsCommentUI, snsCommentUI.getString(j.dGB), true, new 1(snsCommentUI));
        }
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        if (!snsCommentUI.isFinishing()) {
            q.FS();
            aw awVar = new aw(2);
            awVar.Kz(str);
            if (snsCommentUI.rBr.rBy > com.tencent.mm.plugin.sns.c.a.qQF) {
                awVar.wM(2);
            }
            awVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qQY = getIntent().getIntExtra("sns_comment_localId", 0);
        this.rBs = getIntent().getIntExtra("sns_comment_type", 0);
        this.fug = getIntent().getIntExtra("sns_source", 0);
        g.Dk();
        g.Di().gPJ.a((int) c.CTRL_INDEX, (e) this);
        initView();
    }

    public void onPause() {
        super.onPause();
        if (this.rBr != null) {
            String trim = this.rBr.getText().toString().trim();
            g.Dk();
            g.Dj().CU().set(68408, trim);
            if (bh.ov(trim)) {
                g.Dk();
                g.Dj().CU().set(7489, Integer.valueOf(0));
                return;
            }
            g.Dk();
            g.Dj().CU().set(7489, Integer.valueOf(this.rBr.rBy));
        }
    }

    public void onResume() {
        super.onResume();
        showVKB();
    }

    public void onDestroy() {
        super.onDestroy();
        g.Dk();
        g.Di().gPJ.b((int) c.CTRL_INDEX, (e) this);
    }

    protected final void initView() {
        this.rBr = (SnsEditText) findViewById(f.content);
        this.rBr.setTextSize(1, (ac.eu(this.mController.xIM) * this.rBr.getTextSize()) / com.tencent.mm.bv.a.getDensity(this.mController.xIM));
        a(0, getString(j.dGA), new 2(this), b.xJz);
        if (this.rBs == 0) {
            setMMTitle(j.qKr);
        } else if (this.rBs == 1) {
            setMMTitle(j.qMN);
            g.Dk();
            String az = bh.az((String) g.Dj().CU().get(68408, (Object) ""), "");
            g.Dk();
            this.rBr.rBy = bh.a((Integer) g.Dj().CU().get(7489, Integer.valueOf(0)), 0);
            this.rBr.append(bh.az(az, ""));
            if (az == null || az.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.rBs == 2) {
            setMMTitle(j.qJX);
            enableOptionMenu(false);
        }
        setBackBtn(new 3(this));
        this.rBr.addTextChangedListener(new 4(this));
    }

    protected final int getLayoutId() {
        return i.g.qHl;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (kVar.getType()) {
            case c.CTRL_INDEX /*213*/:
                if (this.rBt) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        if (!this.rBu && this.rBs == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String az = bh.az(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = bh.az(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.f.h bwo = ae.bvn().bwo();
            if (bwo != null && bwo.bwp()) {
                String str2 = bwo.qZQ;
                String str3 = bwo.qZP;
                x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + az + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
                com.tencent.mm.plugin.report.service.g.pQN.h(11988, str2, str3, "", "", com.tencent.mm.plugin.sns.data.i.eq(longExtra), az, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aWs();
        finish();
        return true;
    }
}
