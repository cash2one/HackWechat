package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.m.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String fAP;
    private String fFh;
    private int hcn;
    private String hco;
    private RelativeLayout kRC;
    private RelativeLayout kRD;
    private ImageView kRE;
    private TextView kRF;
    private TextView kRG;
    private ImageView kRH;
    private Button kRI;
    private LinearLayout kRJ;
    private TextView kRK;
    private LinearLayout kRL;
    private TextView kRM;
    private ImageView kRN;
    private ImageView kRO;
    private RelativeLayout kRP;
    private ag kRQ;
    private q kRR;
    private r tipDialog = null;

    protected final int getLayoutId() {
        return R.i.dbY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hco = getIntent().getStringExtra("key_order_id");
        this.hcn = getIntent().getIntExtra("key_biz_uin", -1);
        this.fFh = getIntent().getStringExtra("key_from_user_name");
        this.fAP = getIntent().getStringExtra("key_chatroom_name");
        x.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[]{this.hco, Integer.valueOf(this.hcn), this.fFh});
        if (this.hcn == -1) {
            x.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
        } else if (this.hco == null) {
            x.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
        } else {
            if (!bh.ov(this.fFh)) {
                g.pQN.h(13866, new Object[]{Integer.valueOf(1), this.hco, o.getString(this.hcn), this.fFh});
            }
            initView();
            ar.CG().a(1171, this);
            ar.CG().a(1136, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1171, this);
        ar.CG().b(1136, this);
    }

    protected final void initView() {
        this.kRC = (RelativeLayout) findViewById(R.h.bQz);
        this.kRD = (RelativeLayout) findViewById(R.h.bQG);
        this.kRE = (ImageView) findViewById(R.h.bQI);
        this.kRF = (TextView) findViewById(R.h.bQJ);
        this.kRG = (TextView) findViewById(R.h.bQE);
        this.kRH = (ImageView) findViewById(R.h.crZ);
        this.kRI = (Button) findViewById(R.h.bQL);
        this.kRK = (TextView) findViewById(R.h.bQF);
        this.kRM = (TextView) findViewById(R.h.bQH);
        this.kRP = (RelativeLayout) findViewById(R.h.bQK);
        this.kRN = (ImageView) findViewById(R.h.bQD);
        this.kRO = (ImageView) findViewById(R.h.cKu);
        this.kRJ = (LinearLayout) findViewById(R.h.cBZ);
        this.kRL = (LinearLayout) findViewById(R.h.cKv);
        this.kRP.setOnClickListener(this);
        this.kRC.setOnClickListener(this);
        this.kRD.setOnClickListener(this);
        this.kRJ.setOnClickListener(this);
        this.kRL.setOnClickListener(this);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = h.a(this.mController.xIM, getString(R.l.ctB), true, new 1(this));
        ar.CG().a(new ag(this.hcn, this.hco, this.fAP), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    private static Drawable b(Drawable drawable, ColorStateList colorStateList) {
        Drawable h = android.support.v4.b.a.a.h(drawable);
        android.support.v4.b.a.a.a(h, colorStateList);
        return h;
    }

    private void ce(int i, int i2) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.kRI.setBackground(gradientDrawable);
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bQL || view.getId() == R.h.cBZ) {
            if (this.kRI.getVisibility() == 0) {
                int ba = bh.ba(this.kRQ.kMj, getResources().getColor(R.e.brN));
                ce(ba, ba);
                this.kRI.setTextColor(getResources().getColor(R.e.white));
            }
            avU();
            if (!bh.ov(this.fFh)) {
                g.pQN.h(13866, new Object[]{Integer.valueOf(2), this.hco, o.getString(this.hcn), this.fFh});
            }
        } else if (view.getId() == R.h.bQK) {
            finish();
        } else if (view.getId() == R.h.bQz) {
            finish();
        } else if (view.getId() == R.h.cKv) {
            ar.CG().a(new q(this.hcn, this.hco, this.fAP, Boolean.valueOf(true)), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (kVar instanceof ag) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            } else if (kVar instanceof q) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            }
        } else if (kVar instanceof ag) {
            this.kRQ = (ag) kVar;
            x.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[]{Boolean.valueOf(this.kRQ.kMh)});
            if (this.kRQ.kMh) {
                x.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                avU();
                return;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (this.kRQ == null) {
                x.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                MarginLayoutParams marginLayoutParams;
                this.kRG.setText(this.kRQ.content);
                this.kRF.setText(i.b(this, this.kRQ.fFh, this.kRF.getTextSize()));
                if (this.kRQ.status == 0) {
                    if (bh.ov(this.kRQ.kMg)) {
                        this.kRI.setVisibility(0);
                        this.kRI.setText(getResources().getString(R.l.dOh));
                        this.kRI.setOnClickListener(this);
                    } else {
                        this.kRI.setVisibility(0);
                        this.kRI.setText(this.kRQ.kMg);
                        this.kRI.setOnClickListener(this);
                    }
                } else if (this.kRQ.status == 1 || this.kRQ.status != 2) {
                    this.kRI.setVisibility(8);
                    this.kRI.setOnClickListener(null);
                } else if (bh.ov(this.kRQ.kMg)) {
                    this.kRI.setVisibility(8);
                    this.kRI.setOnClickListener(null);
                } else {
                    this.kRI.setVisibility(0);
                    this.kRI.setBackgroundDrawable(null);
                    this.kRI.setText(this.kRQ.kMg);
                    this.kRI.setTextColor(getResources().getColor(R.e.black));
                    this.kRI.setTextSize(1, 17.0f);
                    this.kRI.setOnClickListener(null);
                }
                if (!bh.ov(this.kRQ.kMk)) {
                    this.kRI.setVisibility(8);
                    this.kRL.setVisibility(8);
                    this.kRJ.setVisibility(0);
                    this.kRK.setText(this.kRQ.kMk);
                }
                if (!bh.ov(this.kRQ.kMl)) {
                    this.kRJ.setVisibility(8);
                    this.kRL.setVisibility(0);
                    this.kRM.setText(this.kRQ.kMl);
                }
                if (!bh.ov(this.kRQ.kMf)) {
                    fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this, 15);
                    c.a aVar = new c.a();
                    aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                    com.tencent.mm.aq.o.PB();
                    aVar.hDW = null;
                    aVar.hDC = m.wk(this.kRQ.kMf);
                    aVar.hDA = true;
                    aVar.hDY = true;
                    aVar.hDZ = (float) fromDPToPix;
                    aVar.hDy = true;
                    aVar.hDP = R.g.bDT;
                    com.tencent.mm.aq.o.PA().a(this.kRQ.kMf, this.kRE, aVar.PK());
                }
                if (!bh.ov(this.kRQ.kMi)) {
                    com.tencent.mm.aq.o.PA().a(this.kRQ.kMi, this.kRH);
                }
                if (!bh.ov(this.kRQ.kMj) && this.kRI.getVisibility() == 0) {
                    fromDPToPix = bh.ba(this.kRQ.kMj, getResources().getColor(R.e.brN));
                    ce(fromDPToPix, getResources().getColor(R.e.brM));
                    this.kRI.setTextColor(fromDPToPix);
                }
                if (!bh.ov(this.kRQ.kMj) && this.kRK.getVisibility() == 0) {
                    this.kRK.setTextColor(bh.ba(this.kRQ.kMj, getResources().getColor(R.e.brN)));
                    fromDPToPix = getResources().getColor(R.e.brN);
                    if (!bh.ov(this.kRQ.kMj)) {
                        fromDPToPix = bh.ba(this.kRQ.kMj, fromDPToPix);
                    }
                    this.kRN.setImageDrawable(b(this.kRN.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                }
                if (!bh.ov(this.kRQ.kMj) && this.kRM.getVisibility() == 0) {
                    this.kRM.setTextColor(bh.ba(this.kRQ.kMj, getResources().getColor(R.e.brN)));
                    fromDPToPix = getResources().getColor(R.e.brN);
                    if (!bh.ov(this.kRQ.kMj)) {
                        fromDPToPix = bh.ba(this.kRQ.kMj, fromDPToPix);
                    }
                    this.kRO.setImageDrawable(b(this.kRO.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                    marginLayoutParams = (MarginLayoutParams) this.kRI.getLayoutParams();
                    marginLayoutParams.topMargin -= com.tencent.mm.bv.a.fromDPToPix(this, 20);
                    this.kRI.setLayoutParams(marginLayoutParams);
                }
                if (this.kRI.getVisibility() == 0 && this.kRL.getVisibility() == 8) {
                    marginLayoutParams = (MarginLayoutParams) this.kRI.getLayoutParams();
                    marginLayoutParams.bottomMargin += com.tencent.mm.bv.a.fromDPToPix(this, 28);
                    this.kRI.setLayoutParams(marginLayoutParams);
                }
            }
            View view = this.kRD;
            Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new 3(view, scaleAnimation2));
            if (view != null) {
                view.startAnimation(scaleAnimation);
            }
            this.mController.contentView.setVisibility(0);
        } else if (kVar instanceof q) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            x.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.kRR = (q) kVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.hco);
            intent.putExtra("key_biz_uin", this.hcn);
            intent.putExtra("key_gift_into", this.kRR.kLQ);
            intent.putExtra("key_from_group_chat_room", !bh.ov(this.fAP));
            startActivity(intent);
            finish();
        }
    }

    private void avU() {
        ar.CG().a(new q(this.hcn, this.hco, this.fAP, Boolean.valueOf(false)), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
