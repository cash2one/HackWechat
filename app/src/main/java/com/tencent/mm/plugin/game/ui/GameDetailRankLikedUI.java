package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.game.c.by;
import com.tencent.mm.plugin.game.c.bz;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog jLV;
    private ListView noq;
    private a nor;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (bh.ov(stringExtra)) {
            finish();
            return;
        }
        a aVar = new a();
        aVar.hmj = new by();
        aVar.hmk = new bz();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.hmi = 1331;
        b JZ = aVar.JZ();
        ((by) JZ.hmg.hmo).nfn = stringExtra;
        u.a(JZ, new 2(this));
    }

    protected final int getLayoutId() {
        return R.i.dkb;
    }

    protected final void initView() {
        setMMTitle(R.l.ema);
        setBackBtn(new 1(this));
        this.noq = (ListView) findViewById(R.h.clN);
        this.nor = new a(this);
        this.noq.setAdapter(this.nor);
        this.jLV = c.cR(this.mController.xIM);
        this.jLV.show();
    }
}
