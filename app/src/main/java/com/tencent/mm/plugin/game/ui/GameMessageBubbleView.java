package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private boolean mHasInit = false;
    private View ntt;
    private TextView ntu;
    private ImageView ntv;
    private t ntw;
    private final long ntx = 500;
    private long nty = 0;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.ntv = (ImageView) findViewById(R.h.cmO);
            this.ntu = (TextView) findViewById(R.h.cmN);
            this.ntt = findViewById(R.h.cmP);
            setVisibility(8);
            this.mHasInit = true;
        }
    }

    public final void aRH() {
        SubCoreGameCenter.aRe();
        this.ntw = w.aQr();
        if (this.ntw == null) {
            this.ntt.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.ntw.aQm();
        if (this.ntw.field_msgType == 100 && (bh.ov(this.ntw.ncn.gAT) || bh.ov(this.ntw.ncn.ncY) || bh.ov(this.ntw.ncn.ncZ) || !this.ntw.nco.containsKey(this.ntw.ncn.ncZ))) {
            x.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.ntt.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.ntu.setText(this.ntw.ncn.gAT);
        o.PA().a(this.ntw.ncn.ncY, this.ntv);
        this.ntt.setOnClickListener(this);
        setVisibility(0);
    }

    public final void aRI() {
        this.ntt.setOnClickListener(null);
        setVisibility(8);
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.nty > 500 && this.ntw != null) {
            SubCoreGameCenter.aRe();
            w.aQs();
            int a;
            if (this.ntw.field_msgType == 100) {
                if (!bh.ov(this.ntw.ncn.ncZ)) {
                    d dVar = (d) this.ntw.nco.get(this.ntw.ncn.ncZ);
                    if (dVar != null) {
                        a = u.a(this.mContext, this.ntw, dVar, this.ntw.field_appId, 1007);
                        if (a != 0) {
                            ap.a(this.mContext, 10, 1007, 1, a, 0, this.ntw.field_appId, 0, this.ntw.ncS, this.ntw.field_gameMsgId, this.ntw.ncT, null);
                        }
                        if (dVar.ndb != 4) {
                            this.ntw.field_isRead = true;
                            SubCoreGameCenter.aRd().c(this.ntw, new String[0]);
                        }
                    }
                }
                this.nty = System.currentTimeMillis();
                return;
            }
            if (!(this.ntw == null || this.ntw.ncq == 3)) {
                this.ntw.field_isRead = true;
                SubCoreGameCenter.aRd().c(this.ntw, new String[0]);
            }
            switch (this.ntw.ncq) {
                case 1:
                    String str = this.ntw.ncc;
                    if (!bh.ov(str)) {
                        a = c.p(this.mContext, str, "game_center_bubble");
                        break;
                    } else {
                        a = 0;
                        break;
                    }
                case 2:
                    if (!bh.ov(this.ntw.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.ntw.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        a = c.a(this.mContext, this.ntw.field_appId, null, bundle);
                        break;
                    }
                    x.e("MicroMsg.GameMessageHeaderView", "message type : " + this.ntw.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1007);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    x.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.ntw.ncq);
                    return;
            }
            ap.a(this.mContext, 10, 1007, 1, a, 0, this.ntw.field_appId, 0, this.ntw.field_msgType, this.ntw.field_gameMsgId, this.ntw.ncT, null);
            this.nty = System.currentTimeMillis();
        }
    }
}
