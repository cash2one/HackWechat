package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private acb lCN;
    private EmojiStoreV2RewardBannerView lGt;
    private View lGu;
    private MMCopiableTextView lGv;
    private TextView lGw;
    private TextView lGx;
    private AnimationDrawable lGy;
    private String lyx;
    private af mHandler = new 1(this);

    protected final int getLayoutId() {
        return R.i.dfZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lyx = getIntent().getStringExtra("extra_id");
        initView();
        this.lCN = i.aBE().lwQ.Yb(this.lyx);
        if (this.lCN == null) {
            this.lGt.setBackgroundDrawable(getResources().getDrawable(R.g.bBW));
            this.lGt.setImageDrawable(this.lGy);
            this.lGt.setScaleType(ScaleType.CENTER);
            this.lGy.start();
        } else if (this.lCN.wkV == null || bh.ov(this.lCN.wkV.waS)) {
            this.lGt.setBackgroundDrawable(getResources().getDrawable(R.g.bBW));
            this.lGt.setImageDrawable(this.lGy);
            this.lGt.setScaleType(ScaleType.CENTER);
            this.lGy.start();
        } else {
            final String str = this.lCN.wkV.waT;
            ar.Hg();
            final String G = EmojiLogic.G(c.Fp(), this.lyx, str);
            if (e.bO(G)) {
                this.lGt.cR(G, null);
                this.lGt.setScaleType(ScaleType.FIT_XY);
                if (this.lGy != null && this.lGy.isRunning()) {
                    this.lGy.stop();
                }
            } else {
                o.PA().a(str, this.lGt, f.g(this.lyx, str, new Object[0]), new com.tencent.mm.aq.a.c.i(this) {
                    final /* synthetic */ EmojiStoreV2RewardThanksUI lGz;

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (!bh.ov(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = G;
                            this.lGz.mHandler.sendMessage(message);
                        }
                    }
                });
                this.lGt.setBackgroundDrawable(getResources().getDrawable(R.g.bBW));
                this.lGt.setImageDrawable(this.lGy);
                this.lGt.setScaleType(ScaleType.CENTER);
                this.lGy.start();
            }
        }
        if (this.lCN == null || this.lCN.wkV == null) {
            this.lGu.setVisibility(8);
            return;
        }
        this.lGu.setVisibility(0);
        bh.ov(this.lCN.wkV.waV);
        this.lGv.setVisibility(0);
        this.lGv.setText(R.l.eaQ);
        this.lGw.setVisibility(8);
        this.lGx.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.lGy != null && this.lGy.isRunning()) {
            this.lGy.stop();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eaP);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardThanksUI lGz;

            {
                this.lGz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lGz.finish();
                return false;
            }
        });
        this.lGt = (EmojiStoreV2RewardBannerView) findViewById(R.h.cQK);
        this.lGt.gr = 1.0f;
        this.lGu = findViewById(R.h.cuB);
        this.lGv = (MMCopiableTextView) findViewById(R.h.cuD);
        this.lGw = (TextView) findViewById(R.h.cuA);
        this.lGx = (TextView) findViewById(R.h.cuC);
        this.lGy = (AnimationDrawable) getResources().getDrawable(R.g.bBN);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
