package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.GameRankHeadView.1;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String noy = "gameDetailRankDataKey";
    private String appId;
    private ListView nov;
    private GameRankHeadView now;
    private j nox;

    public static class a {
        public String noA;
        public String noB;
        d noC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b hy = u.GK().hy(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (hy == null) {
            finish();
            return;
        }
        a aVar = (a) hy.get(noy);
        this.nov = (ListView) findViewById(R.h.clO);
        if (!(bh.ov(aVar.noA) || bh.ov(aVar.noB))) {
            View inflate = ((LayoutInflater) this.mController.xIM.getSystemService("layout_inflater")).inflate(R.i.dke, this.nov, false);
            this.now = (GameRankHeadView) inflate.findViewById(R.h.cnc);
            this.nov.addHeaderView(inflate);
            GameRankHeadView gameRankHeadView = this.now;
            gameRankHeadView.jpW.setText(aVar.noA);
            gameRankHeadView.nuq.setText(aVar.noB);
            gameRankHeadView.ndK = aVar.noC;
            gameRankHeadView.ndK.fFj = 1203;
            gameRankHeadView.ndK.position = 2;
            if (gameRankHeadView.noJ == null) {
                gameRankHeadView.noJ = new o(gameRankHeadView.ndK);
            }
            gameRankHeadView.noJ.cP(gameRankHeadView.getContext());
            gameRankHeadView.noJ.aQj();
            gameRankHeadView.aRz();
            if (gameRankHeadView.noH != null) {
                n.a(gameRankHeadView.noH);
            } else {
                gameRankHeadView.noH = new 1(gameRankHeadView);
                n.a(gameRankHeadView.noH);
            }
            gameRankHeadView.nof.setOnClickListener(gameRankHeadView);
        }
        this.nox = new j(this);
        this.nox.DD = R.i.djY;
        this.nov.setAdapter(this.nox);
        this.appId = aVar.noC.field_appId;
        if (bh.ov(this.appId)) {
            finish();
            return;
        }
        initView();
        ar.Dm().F(new 1(this));
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        n.b(this.now.noH);
    }

    protected final int getLayoutId() {
        return R.i.djX;
    }

    protected final void initView() {
        setMMTitle(g.l(this.mController.xIM, this.appId));
        setBackBtn(new 2(this));
    }
}
