package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.tools.l;

public class SnsSingleTextViewUI extends MMActivity {
    private String fus;
    private ClipboardManager mxl;
    private p$d onK = new 5(this);
    private m qYs;
    private TextView rGE;
    private boolean rGF = false;
    private SnsTranslateResultView rGG;
    private c rGH = new 1(this);
    private c rGI = new 2(this);
    private c rGJ = new 3(this);
    protected int requestType = 0;
    private String text;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mxl = (ClipboardManager) getSystemService("clipboard");
        setMMTitle(j.qKh);
        setBackBtn(new 4(this));
        this.text = getIntent().getStringExtra("sns_text_show");
        this.fus = bh.az(getIntent().getStringExtra("sns_local_id"), "");
        this.qYs = ae.bvv().Lm(this.fus);
        if (bh.ov(this.text)) {
            this.text = "";
        }
        this.rGE = (TextView) findViewById(f.qFx);
        this.rGE.setText(this.text, BufferType.SPANNABLE);
        i.f(this.rGE, 2);
        this.rGE.setOnTouchListener(new ab());
        new l(this).a(this.rGE, this, this.onK);
        this.rGG = (SnsTranslateResultView) findViewById(f.qFD);
        this.rGG.az(this.rGE.getTextSize());
        if (this.qYs != null && ao.cc(this.qYs.bxW(), 8)) {
            b Kr = ao.Kr(this.qYs.bxW());
            if (Kr != null && Kr.hik) {
                this.rGG.setVisibility(0);
                this.rGG.a(null, 1, Kr.result, Kr.hqd, false);
                this.rGF = true;
            }
        }
        a.xef.b(this.rGH);
        a.xef.b(this.rGI);
        a.xef.b(this.rGJ);
    }

    protected void onDestroy() {
        super.onDestroy();
        a.xef.c(this.rGH);
        a.xef.c(this.rGI);
        a.xef.c(this.rGJ);
    }

    protected final int getLayoutId() {
        return i$g.qHS;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(j.dEs));
            if (d.OQ("favorite")) {
                contextMenu.add(0, 1, 0, getString(j.eeE));
            }
            contextMenu.add(0, 6, 1, getString(j.qJs));
            if (this.rGF) {
                ao.b(contextMenu, true);
            } else {
                ao.a(contextMenu, true);
            }
        }
    }
}
