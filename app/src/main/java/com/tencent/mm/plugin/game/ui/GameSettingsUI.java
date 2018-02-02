package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.c.az;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.at;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Map;

public class GameSettingsUI extends MMActivity implements e, t {
    private String appId;
    private ProgressDialog iln = null;
    private int ndn = 0;
    private ImageView nkH;
    private TextView nkI;
    private f nlG;
    private TextView nvO;
    private TextView nvP;
    private CheckBox nvQ;
    private View nvR;
    private View nvS;
    private CheckBox nvT;
    private AuthorizationInfoLayout nvU;
    private ArrayList<String> nvV;
    private boolean nvW;

    static /* synthetic */ void a(GameSettingsUI gameSettingsUI, boolean z) {
        gameSettingsUI.g(new x(2, z ? new aj(gameSettingsUI.appId, 0, "1") : new aj(gameSettingsUI.appId, 0, "0")));
    }

    static /* synthetic */ void b(GameSettingsUI gameSettingsUI, boolean z) {
        int i = 0;
        if (!z) {
            i = 1;
        }
        gameSettingsUI.nvW = z;
        gameSettingsUI.g(new at(gameSettingsUI.appId, 1, i));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aRi().a(2, this);
        ar.CG().a(1221, (e) this);
        this.appId = getIntent().getStringExtra("game_app_id");
        if (bh.ov(this.appId)) {
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.GameSettingsUI", "appid is null or nill");
        } else {
            this.nlG = g.aZ(this.appId, true);
        }
        initView();
        g(new at(this.appId));
    }

    protected final int getLayoutId() {
        return R.i.daE;
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aRi().b(2, this);
        ar.CG().b(1221, (e) this);
    }

    protected final void initView() {
        int i = 0;
        this.nkH = (ImageView) findViewById(R.h.cml);
        this.nkI = (TextView) findViewById(R.h.cmV);
        this.nvO = (TextView) findViewById(R.h.clW);
        this.nvU = (AuthorizationInfoLayout) findViewById(R.h.ckF);
        if (this.nlG != null) {
            Bitmap b = g.b(this.nlG.field_appId, 1, a.getDensity(this));
            if (b == null) {
                this.nkH.setImageResource(R.g.byX);
            } else {
                this.nkH.setImageBitmap(d.a(b, true, 5.0f));
            }
            if (!bh.ov(this.nlG.field_appName)) {
                this.nkI.setText(g.a(this, this.nlG, null));
            }
            if (!bh.ov(this.nlG.fQD)) {
                this.nvO.setText(this.nlG.fQD);
            }
            String str = this.nlG.fQC;
            if (!bh.ov(str)) {
                Map y = bi.y(str, "ScopeList");
                if (y != null && y.size() > 0) {
                    int i2 = bh.getInt((String) y.get(".ScopeList.Count"), 0);
                    if (i2 > 0) {
                        this.nvV = new ArrayList();
                        while (i < i2) {
                            Object obj;
                            StringBuilder stringBuilder = new StringBuilder(".ScopeList.List.item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            String stringBuilder2 = stringBuilder.append(obj).append(".Scope").toString();
                            if (!bh.ov((String) y.get(stringBuilder2))) {
                                this.nvV.add(y.get(stringBuilder2));
                            }
                            i++;
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GameSettingsUI", "auth info is null :" + this.nlG.field_appName + ", " + this.appId);
                    }
                }
                if (this.nvV == null || this.nvV.size() <= 0) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GameSettingsUI", "this game's authinfo is null " + this.appId);
                    this.nvU.setVisibility(8);
                } else {
                    this.nvU.C(this.nvV);
                }
            }
        }
        this.nvP = (TextView) findViewById(R.h.ccf);
        this.nvP.setOnClickListener(new 1(this));
        this.nvQ = (CheckBox) findViewById(R.h.bIm);
        this.nvQ.setChecked(g.RA(this.appId));
        this.nvR = findViewById(R.h.bIe);
        this.nvR.setOnClickListener(new 2(this));
        this.nvT = (CheckBox) findViewById(R.h.cOf);
        this.nvS = findViewById(R.h.cOe);
        this.nvS.setOnClickListener(new 3(this));
        setMMTitle(R.l.enb);
        setBackBtn(new 4(this));
    }

    private void g(k kVar) {
        ar.CG().a(kVar, 0);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 5(this, kVar));
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (!cF(i, i2)) {
            aj ajVar = (aj) wVar;
            if (ajVar.cmdId == 0) {
                boolean RA = g.RA(this.appId);
                if (this.nvQ != null) {
                    this.nvQ.setChecked(RA);
                }
                if (RA) {
                    ap.a(this.mController.xIM, 10, 1008, AuthorizedGameListUI.nkR, 20, 1, this.appId, this.ndn, 0, null, null, null);
                } else {
                    ap.a(this.mController.xIM, 10, 1008, AuthorizedGameListUI.nkR, 21, 1, this.appId, this.ndn, 0, null, null, null);
                }
            } else if (ajVar.cmdId == 1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GameSettingsUI", "relieve app authorization ok");
                Intent intent = new Intent();
                intent.putExtra("game_app_id", this.appId);
                setResult(-1, intent);
                finish();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!cF(i, i2)) {
            switch (kVar.getType()) {
                case 1221:
                    int i3 = ((az) ((at) kVar).lMW.hmg.hmo).nhu;
                    ba baVar = (ba) ((at) kVar).lMW.hmh.hmo;
                    Object obj = (baVar == null || (baVar.nhv & 1) <= 0) ? null : 1;
                    switch (i3) {
                        case 0:
                            this.nvT.setChecked(obj == null);
                            return;
                        case 1:
                            ap.a(this.mController.xIM, 10, 1008, AuthorizedGameListUI.nkS, this.nvW ? 20 : 21, 1, this.appId, this.ndn, 0, null, null, null);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    private boolean cF(int i, int i2) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        Toast.makeText(this, getString(R.l.emq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
