package com.tencent.mm.ui.bizchat;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BizChatSearchUI extends MMActivity implements p.a, BizChatSearchListView.a {
    String kGH;
    p kGa;
    private OnScrollListener nmj = new 1(this);
    private int scene;
    private String ynQ;
    private c ynR;
    BizChatSearchListView ynS;
    TextView ynT;
    private a ynU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    protected final void initView() {
        if (bh.ov(this.kGH)) {
            this.kGH = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.ynQ = getIntent().getStringExtra("biz_chat_search_text");
            if (bh.ov(this.kGH)) {
                finish();
            }
        }
        this.ynS = (BizChatSearchListView) findViewById(R.h.bNR);
        this.ynT = (TextView) findViewById(R.h.cAx);
        this.ynU = new a(this.mController.xIM, this.kGH, this.scene);
        if (a.a(this.ynU)) {
            this.ynR = new c((byte) 0);
            BizChatSearchListView bizChatSearchListView = this.ynS;
            c cVar = this.ynR;
            View inflate = View.inflate(this.mController.xIM, R.i.dmF, null);
            cVar.kFQ = inflate.findViewById(R.h.cty);
            cVar.kFR = inflate.findViewById(R.h.ctt);
            cVar.kFS = inflate.findViewById(R.h.ctA);
            cVar.kFQ.setVisibility(8);
            cVar.kFR.setVisibility(8);
            cVar.kFS.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            Fk(0);
        }
        this.ynS.setAdapter(this.ynU);
        this.ynS.setOnItemClickListener(new 2(this));
        this.ynS.ynP = this;
        if (a.a(this.ynU)) {
            this.ynS.setOnScrollListener(this.nmj);
        }
        this.kGa = new p();
        this.kGa.nu(a.b(this.ynU));
        this.kGa.a(this);
        this.kGa.vyU = false;
    }

    public final void Xs() {
    }

    public final void Xr() {
        finish();
    }

    public final void oL(String str) {
        CharSequence charSequence = null;
        if (!bh.ov(str) || this.ynQ == null) {
            a aVar = this.ynU;
            aVar.ldh = str;
            if (bh.ov(str)) {
                aVar.aaS();
                aVar.yok = false;
                aVar.yoo = false;
                aVar.mC(true);
                return;
            } else if (aVar.cqL()) {
                aVar.yok = true;
                aVar.yoo = false;
                aVar.cqN();
                aVar.bl(str, false);
                aVar.YX(str);
                return;
            } else {
                aVar.bl(str, true);
                if (aVar.ynY && aVar.yok) {
                    aVar.YX(str);
                    return;
                }
                return;
            }
        }
        String str2 = this.ynQ;
        this.ynQ = null;
        if (!str2.equals("")) {
            this.kGa.ZR(str2);
        }
        p pVar = this.kGa;
        if (a.b(this.ynU)) {
            charSequence = this.mController.xIM.getResources().getString(R.l.dMw);
        } else if (a.a(this.ynU)) {
            charSequence = this.mController.xIM.getResources().getString(R.l.dMA);
        } else if (a.d(this.ynU)) {
            charSequence = this.mController.xIM.getResources().getString(R.l.dMt);
        }
        pVar.setHint(charSequence);
        this.kGa.clearFocus();
    }

    public final boolean oK(String str) {
        aWs();
        return true;
    }

    public final void ass() {
        aWs();
    }

    public final void ast() {
    }

    protected void onPause() {
        super.onPause();
        this.kGa.cancel();
        this.kGa.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dgu;
    }

    public final boolean asu() {
        aWs();
        return false;
    }

    public final void Fk(int i) {
        if (this.ynR != null) {
            c cVar = this.ynR;
            switch (i) {
                case 1:
                    cVar.q(true, false);
                    return;
                case 2:
                    cVar.q(false, true);
                    return;
                default:
                    cVar.q(false, false);
                    return;
            }
        }
    }
}
