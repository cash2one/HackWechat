package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t$d;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class GameMessageUI extends GameCenterActivity implements OnItemClickListener, e {
    private int gAd = 0;
    private int kFm;
    private OnScrollListener nmj = new 4(this);
    private ListView ntA;
    private o ntB;
    private TextView ntC;
    private View ntD;
    private int ntE = 1;
    private boolean ntF = false;
    private boolean ntG = false;
    private String ntH = "";
    private OnClickListener ntI;
    private OnClickListener ntJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(573, this);
        this.gAd = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.ntH = getIntent().getStringExtra("game_manage_url");
        initView();
        SubCoreGameCenter.aRe();
        w.aQs();
    }

    protected void onResume() {
        super.onResume();
        this.ntB.notifyDataSetChanged();
        if (this.ntG && this.ntD != null) {
            this.ntA.removeHeaderView(this.ntD);
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dkS);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dEo), new 2(this));
        this.kFm = getIntent().getIntExtra("game_report_from_scene", 0);
        this.ntA = (ListView) findViewById(R.h.cmT);
        this.ntA.setOnItemClickListener(this);
        if (this.gAd > 20) {
            if (getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true)) {
                this.ntD = View.inflate(this, R.i.dkV, null);
                this.ntD.setOnClickListener(new 5(this));
                this.ntA.addHeaderView(this.ntD);
                this.ntD.setVisibility(0);
                getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
            } else if (this.ntD != null) {
                this.ntD.setVisibility(8);
            }
        }
        t tVar = new t();
        tVar.ncW = true;
        this.ntB = new o(this, tVar, this.kFm);
        this.ntB.lU(true);
        ra(8);
        this.ntB.xIi = new 3(this);
        this.ntA.setOnScrollListener(this.nmj);
        this.ntA.setAdapter(this.ntB);
        ap.a(this.mController.xIM, 13, 1300, 0, 1, 0, null, this.kFm, 0, null, null, null);
    }

    private void ra(int i) {
        if (this.ntC == null) {
            this.ntC = (TextView) findViewById(R.h.cmR);
        }
        this.ntC.setVisibility(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        SubCoreGameCenter.aRd().aQw();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dkS;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.ntB != null) {
            this.ntB.aUn();
        }
        ar.CG().b(573, this);
        boolean fx = SubCoreGameCenter.aRd().fx("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        x.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[]{Boolean.valueOf(fx), r1});
        SubCoreGameCenter.aRd().aQw();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar = (t) adapterView.getAdapter().getItem(i);
        if (tVar == null) {
            x.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[]{Integer.valueOf(i)});
            return;
        }
        tVar.aQm();
        int a;
        if (tVar.field_msgType == 100) {
            if (!bh.ov(tVar.ncI)) {
                t$d com_tencent_mm_plugin_game_model_t_d = (t$d) tVar.nco.get(tVar.ncI);
                if (com_tencent_mm_plugin_game_model_t_d != null) {
                    a = u.a(this, tVar, com_tencent_mm_plugin_game_model_t_d, tVar.field_appId, 1301);
                    if (a != 0) {
                        ap.a(this.mController.xIM, 13, 1301, 4, a, 0, tVar.field_appId, this.kFm, tVar.ncS, tVar.field_gameMsgId, tVar.ncT, null);
                    }
                }
            }
        } else if (tVar.ncU == 0) {
            switch (tVar.field_msgType) {
                case 2:
                case 5:
                    if (!g.m(this, tVar.field_appId)) {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", tVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, tVar.field_appId, null, r0);
                        break;
                    }
                    com.tencent.mm.plugin.game.model.g.Y(this, tVar.field_appId);
                    a = 3;
                    break;
                case 6:
                    if (!bh.ov(tVar.ncD)) {
                        a = c.ac(this, tVar.ncD);
                        break;
                    }
                    return;
                case 10:
                case 11:
                    if (!bh.ov(tVar.ncb)) {
                        a = c.ac(this, tVar.ncb);
                        break;
                    }
                    return;
                default:
                    return;
            }
            ap.a(this.mController.xIM, 13, 1301, 4, a, 0, tVar.field_appId, this.kFm, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
        } else {
            switch (tVar.ncU) {
                case 1:
                    if (bh.ov(tVar.field_appId)) {
                        x.e("MicroMsg.GameMessageUI", "appid is null");
                        return;
                    }
                    r0 = new Bundle();
                    r0.putCharSequence("game_app_id", tVar.field_appId);
                    r0.putInt("game_report_from_scene", 1301);
                    ap.a(this.mController.xIM, 13, 1301, 4, c.a(this, tVar.field_appId, null, r0), 0, tVar.field_appId, this.kFm, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                case 2:
                    if (g.m(this, tVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.g.Y(this, tVar.field_appId);
                        a = 3;
                    } else {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", tVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, tVar.field_appId, null, r0);
                    }
                    ap.a(this.mController.xIM, 13, 1301, 4, a, 0, tVar.field_appId, this.kFm, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                case 3:
                    if (bh.ov(tVar.ncV)) {
                        x.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        return;
                    }
                    ap.a(this.mController.xIM, 13, 1301, 4, c.ac(this, tVar.ncV), 0, tVar.field_appId, this.kFm, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                default:
                    x.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + tVar.ncU);
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 573) {
                ra(8);
                this.ntB.a(null, null);
            }
        } else if (this.ntB.getCount() > 0) {
            x.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        } else if (!a.ift.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eml, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public final int aRr() {
        return 13;
    }

    public final int aRs() {
        return 1300;
    }

    public final int aRt() {
        return this.kFm;
    }
}
