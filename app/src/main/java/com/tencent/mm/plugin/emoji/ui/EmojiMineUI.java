package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private View lBF;
    private TextView lBG;
    private ViewGroup lCq;
    private ViewGroup lCr;
    private ViewGroup lCs;
    private ViewGroup lCt;
    private TextView lCu;

    protected final int getLayoutId() {
        return R.i.dfM;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        g.pQN.k(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        x.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[]{Integer.valueOf(r0)});
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.eaf), new 2(this));
        ar.Hg();
        if (!((Boolean) c.CU().get(a.xnk, Boolean.valueOf(false))).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.es(true);
        }
        g.pQN.a(406, 3, 1, false);
        g.pQN.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected final void initView() {
        setMMTitle(R.l.eLn);
        super.initView();
        this.lBF = findViewById(R.h.cPZ);
        this.lBG = (TextView) this.lBF.findViewById(R.h.cPY);
        this.lBG.setText(R.l.ebr);
        if (i.aBB().lzq.lzG) {
            i.aBB();
            if (BKGLoaderManager.aCc()) {
                this.lBF.setVisibility(0);
                cp(8001, 3000);
                this.Fv.setOnScrollListener(null);
            }
        }
        this.lBF.setVisibility(8);
        this.Fv.setOnScrollListener(null);
    }

    public void onClick(View view) {
        Intent intent;
        if (view == this.lCr) {
            intent = new Intent();
            intent.setClass(this, EmojiCustomUI.class);
            startActivity(intent);
        } else if (view == this.lCs) {
            intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
        }
    }

    protected final boolean aCn() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aCj() {
        return new com.tencent.mm.plugin.emoji.a.c(this.mController.xIM);
    }

    protected final int aCq() {
        return 8;
    }

    protected final int aCs() {
        return 2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i - 1, j);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aCI();
            cp(131074, 50);
        }
    }

    public final void g(String str, int i, int i2, String str2) {
    }

    protected final boolean aCz() {
        return false;
    }

    protected final void aCk() {
        this.lCt = (ViewGroup) View.inflate(this.mController.xIM, R.i.dfG, null);
        this.lCu = (TextView) this.lCt.findViewById(16908310);
        this.lCu.setText(R.l.eLo);
        this.lCt.setVisibility(8);
        this.lCu.setVisibility(8);
        this.Fv.addHeaderView(this.lCt, null, false);
        this.lCq = (ViewGroup) View.inflate(this.mController.xIM, R.i.dfF, null);
        this.lCr = (ViewGroup) this.lCq.findViewById(R.h.cvX);
        ((TextView) this.lCr.findViewById(16908310)).setText(R.l.dfB);
        this.lCs = (ViewGroup) this.lCq.findViewById(R.h.cvY);
        ((TextView) this.lCs.findViewById(16908310)).setText(R.l.dZX);
        this.lCs.findViewById(R.h.content).setBackgroundResource(R.g.bBy);
        this.lCr.setOnClickListener(this);
        this.lCs.setOnClickListener(this);
        this.Fv.addFooterView(this.lCq, null, false);
    }

    protected final boolean aCy() {
        return true;
    }

    protected final boolean aCv() {
        boolean z = true;
        if (this.lxL != null) {
            this.lxL.notifyDataSetChanged();
            this.lAQ = true;
            this.kgl.setVisibility(8);
        } else {
            z = false;
        }
        aCA();
        return z;
    }

    protected final void c(abz com_tencent_mm_protocal_c_abz) {
        super.c(com_tencent_mm_protocal_c_abz);
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
    }

    protected final boolean aCm() {
        return false;
    }

    public final void l(Message message) {
        if (message.what == 8001 && this.lBF != null) {
            this.lBF.setVisibility(8);
        }
        super.l(message);
    }

    public final void aCA() {
        if (this.lCt == null) {
            return;
        }
        if (this.lxL == null || this.lxL.isEmpty()) {
            this.lCt.setVisibility(8);
            this.lCu.setVisibility(8);
            return;
        }
        this.lCt.setVisibility(0);
        this.lCu.setVisibility(0);
    }

    protected final int aCh() {
        return 24;
    }

    protected final int aCi() {
        return 7;
    }
}
