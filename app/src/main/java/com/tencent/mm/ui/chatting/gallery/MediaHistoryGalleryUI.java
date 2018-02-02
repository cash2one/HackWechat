package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.a.b;
import com.tencent.mm.ui.chatting.c.a.c;
import com.tencent.mm.ui.chatting.e.e;

public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, b {
    private RecyclerView Va;
    private int hEF;
    private String jRw;
    private TextView ldn;
    private ProgressDialog nAp;
    private boolean yDT = false;
    private View yDX;
    private View yDZ;
    private View yEa;
    private View yEb;
    private View yEc;
    private com.tencent.mm.ui.chatting.c.a.a yGH;
    private TextView yGI;
    private boolean yGJ;
    private boolean yGK;
    private int yGL = -1;
    private boolean yGM;
    private int yGN;
    private long yyg;

    private static class a {
        public static com.tencent.mm.ui.chatting.c.a.a al(Context context, int i) {
            switch (6.yGQ[i - 1]) {
                case 1:
                    return new e(context);
                default:
                    return null;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        com.tencent.mm.ui.chatting.c.a.a al;
        super.onCreate(bundle);
        this.yDT = true;
        Intent intent = getIntent();
        if (intent.getIntExtra("kintent_intent_source", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.yGJ = z;
        this.jRw = intent.getStringExtra("kintent_talker");
        this.yGL = intent.getIntExtra("kintent_image_index", -1);
        this.yGK = intent.getBooleanExtra("key_is_biz_chat", false);
        this.yyg = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                al = a.al(this, c.yCN);
                break;
            default:
                al = a.al(this, c.yCN);
                break;
        }
        al.a(this);
        initView();
        this.yGH.y(true, this.yGL);
    }

    protected void onResume() {
        super.onResume();
        this.yGH.onResume();
        if (this.yDT) {
            if (this.yGH.cuk()) {
                cui();
            } else {
                cuj();
            }
        }
        this.yDT = false;
    }

    protected void onPause() {
        super.onPause();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, this.hEF);
        this.hEF = 0;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.yGH.onDetach();
    }

    protected final void initView() {
        super.initView();
        this.yDX = findViewById(R.h.cxj);
        this.yEa = findViewById(R.h.cSL);
        this.yEc = findViewById(R.h.bBE);
        this.yEb = findViewById(R.h.cIE);
        this.yDZ = findViewById(R.h.cgh);
        this.yDZ.setTag(Integer.valueOf(1));
        this.yEa.setTag(Integer.valueOf(0));
        this.yEb.setTag(Integer.valueOf(3));
        this.yEc.setTag(Integer.valueOf(2));
        this.yDZ.setOnClickListener(this);
        this.yEa.setOnClickListener(this);
        this.yEb.setOnClickListener(this);
        this.yEc.setOnClickListener(this);
        this.yGI = (TextView) findViewById(R.h.bJU);
        this.ldn = (TextView) findViewById(R.h.cJR);
        this.Va = (RecyclerView) findViewById(R.h.coE);
        this.Va.setBackgroundColor(getResources().getColor(R.e.brl));
        findViewById(R.h.bYM).setBackgroundColor(getResources().getColor(R.e.brl));
        this.Va.a(this.yGH.fM(this));
        this.Va.a(this.yGH.fN(this));
        this.Va.a(this.yGH.as(this.jRw, this.yyg));
        this.Va.Ub = true;
        this.Va.UC = new 1(this);
        this.Va.a(new 2(this));
        setMMTitle(this.yGH.WW());
        setBackBtn(new 3(this));
    }

    protected final int getLayoutId() {
        return R.i.dni;
    }

    public final void mR(boolean z) {
        if (z) {
            n(true, null);
        } else {
            this.yGN = ((GridLayoutManager) this.Va.TV).fa();
        }
    }

    public final void z(boolean z, int i) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.yGL));
        if (z) {
            n(false, null);
            this.Va.fm().UR.notifyChanged();
            if (this.yGL != -1) {
                this.Va.TV.be(this.yGL);
            } else {
                this.Va.TV.be(this.Va.fm().getItemCount() - 1);
            }
            if (i <= 0) {
                this.ldn.setVisibility(0);
                this.Va.setVisibility(8);
                this.ldn.setText(getString(R.l.dSE));
                return;
            }
            this.ldn.setVisibility(8);
            this.Va.setVisibility(0);
        } else if (i > 0) {
            this.Va.fm().W(0, i);
            this.Va.fm().U(i, this.yGN + i);
        } else {
            this.Va.fm().bj(0);
        }
    }

    public final View getChildAt(int i) {
        return this.Va.getChildAt(i);
    }

    public final void FH(int i) {
        setMMTitle(getString(R.l.elE, new Object[]{Integer.valueOf(i)}));
        Gi(i);
    }

    public void onClick(View view) {
        this.yGH.FG(((Integer) view.getTag()).intValue());
    }

    public void onBackPressed() {
        super.onBackPressed();
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.yGM) {
            this.yGH.cul();
        } else {
            finish();
        }
    }

    public final void cui() {
        this.yGH.cui();
        setMMTitle(getString(R.l.elE, new Object[]{Integer.valueOf(this.yGH.cuh())}));
        this.yDX.setVisibility(0);
        this.yDX.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqo));
        Gi(this.yGH.cuh());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.ekZ), new 4(this));
    }

    public final void cuj() {
        this.yGH.cuj();
        setMMTitle(this.yGH.WW());
        this.yDX.setVisibility(8);
        this.yDX.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqm));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.ela), new 5(this));
    }

    public final void cum() {
        this.yGM = true;
        n(true, getString(R.l.epl));
    }

    public final void cul() {
        cuj();
        this.yGM = false;
        n(false, "");
    }

    public final void cun() {
        cuj();
        this.yGM = false;
        n(false, "");
        String substring = com.tencent.mm.compatible.util.e.gHu.substring(com.tencent.mm.compatible.util.e.gHu.indexOf("tencent/MicroMsg"));
        Toast.makeText(this, getString(R.l.dSF, new Object[]{substring}), 1).show();
    }

    public final void FI(int i) {
        cuj();
        n(false, "");
        if (i == 0) {
            i = R.l.elC;
        }
        if (this.yGM) {
            h.a(this, i, R.l.dGO, true, null);
        }
        this.yGM = false;
    }

    public final boolean cuo() {
        return this.yGM;
    }

    private void Gi(int i) {
        if (!this.yGH.cuk() || i <= 0) {
            this.yDZ.setEnabled(false);
            this.yEa.setEnabled(false);
            this.yEb.setEnabled(false);
            this.yEc.setEnabled(false);
            return;
        }
        this.yDZ.setEnabled(true);
        this.yEa.setEnabled(true);
        this.yEb.setEnabled(true);
        this.yEc.setEnabled(true);
    }

    private void n(boolean z, String str) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            if (str == null) {
                str = getString(R.l.ctB);
            }
            this.nAp = r.b(this, str, true, 0, null);
        } else if (this.nAp != null && this.nAp.isShowing()) {
            this.nAp.dismiss();
            this.nAp = null;
        }
    }
}
