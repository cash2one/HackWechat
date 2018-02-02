package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.sdk.platformtools.x;

public class GameInfoView extends RelativeLayout implements OnClickListener {
    private int gzM = 0;
    Context mContext;
    int ndn = 0;
    String nrA = "";
    String nrB = "";
    String nrC = "";
    ImageView nrD;
    String nrE = "";
    private int nrF = 1;
    private int nrG = 2;
    private int nrH = 3;
    int nrI = 4;
    String nrJ;
    FrameLayout nrp;
    ImageView nrq;
    private TextView nrr;
    FrameLayout nrs;
    ImageView nrt;
    ImageView nru;
    ImageView nrv;
    RelativeLayout nrw;
    ImageView nrx;
    TextView nry;
    ImageView nrz;

    public GameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nrw = (RelativeLayout) findViewById(R.h.ckN);
        this.nrw.setOnClickListener(this);
        this.nrx = (ImageView) findViewById(R.h.cDM);
        this.nry = (TextView) findViewById(R.h.cDW);
        this.nrz = (ImageView) findViewById(R.h.bMq);
        this.nrp = (FrameLayout) findViewById(R.h.cmS);
        this.nrp.setOnClickListener(this);
        this.nrq = (ImageView) findViewById(R.h.cvT);
        this.nrr = (TextView) findViewById(R.h.cmU);
        this.nrs = (FrameLayout) findViewById(R.h.cmh);
        this.nrs.setOnClickListener(this);
        this.nrt = (ImageView) findViewById(R.h.cnE);
        this.nru = (ImageView) findViewById(R.h.cnF);
        this.nrD = (ImageView) findViewById(R.h.cJB);
        this.nrv = (ImageView) findViewById(R.h.cJH);
        this.nrv.setOnClickListener(this);
        x.i("MicroMsg.GameInfoView", "initView finished");
    }

    public final void aRC() {
        this.gzM = SubCoreGameCenter.aRd().aQx();
        if (this.gzM > 0 && this.gzM <= 99) {
            this.nrr.setVisibility(0);
            this.nrr.setText(this.gzM);
        } else if (this.gzM > 99) {
            this.nrr.setVisibility(0);
            this.nrr.setText("99+");
            this.nrr.setTextSize(1, 9.0f);
        } else {
            this.nrr.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.ckN) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                ap.a(this.mContext, 10, 1001, this.nrI, c.p(this.mContext, (String) view.getTag(), "game_center_profile"), this.ndn, this.nrJ);
            }
        } else if (id == R.h.cmS) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                r0 = b.aPR();
                if (r0.fDt == 2) {
                    r4 = c.p(this.mContext, r0.url, "game_center_msgcenter");
                } else {
                    r0 = new Intent(this.mContext, GameMessageUI.class);
                    r0.putExtra("game_report_from_scene", 1001);
                    r0.putExtra("game_unread_msg_count", this.gzM);
                    r0.putExtra("game_manage_url", this.nrE);
                    this.mContext.startActivity(r0);
                    r4 = 6;
                }
            } else {
                r4 = c.p(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            if (this.nrr.getVisibility() == 0) {
                r11 = ap.cL("resource", "5");
            } else {
                r11 = null;
            }
            ap.a(this.mContext, 10, 1001, this.nrG, r4, 0, null, this.ndn, 0, null, null, r11);
        } else if (id == R.h.cmh) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                r4 = c.p(this.mContext, (String) view.getTag(), "game_center_giftcenter");
                if (this.nru.getVisibility() == 0) {
                    r11 = ap.cL("resource", "5");
                } else {
                    r11 = null;
                }
                ap.a(this.mContext, 10, 1001, this.nrH, r4, 0, null, this.ndn, 0, null, null, r11);
            }
        } else if (id == R.h.cJH) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                r0 = b.aPR();
                if (r0.fDt == 2) {
                    r4 = c.p(this.mContext, r0.url, "game_center_msgcenter");
                } else {
                    r0 = new Intent(this.mContext, GameSearchUI.class);
                    r0.putExtra("game_report_from_scene", 1001);
                    this.mContext.startActivity(r0);
                    r4 = 6;
                }
            } else {
                r4 = c.p(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ap.a(this.mContext, 14, 1401, 1, r4, 0, null, this.ndn, 0, null, null, null);
        }
    }
}
