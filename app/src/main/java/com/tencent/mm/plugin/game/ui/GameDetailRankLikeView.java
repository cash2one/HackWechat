package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.game.c.ed;
import com.tencent.mm.plugin.game.c.ee;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ag.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String mAppId;
    int ndn;
    ag noi;
    a noj;
    private Drawable nok;
    private Drawable nol;
    private Animation nom;
    private ImageView non;
    private TextView noo;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nok = getContext().getResources().getDrawable(R.g.bCH);
        this.nol = getContext().getResources().getDrawable(R.g.bCG);
        this.nom = AnimationUtils.loadAnimation(getContext(), R.a.bqr);
        inflate(getContext(), R.i.djZ, this);
        setOnClickListener(this);
        this.non = (ImageView) findViewById(R.h.csT);
        this.noo = (TextView) findViewById(R.h.csU);
    }

    final void aRy() {
        if (this.noj != null) {
            if (this.noj.ndA) {
                this.non.setImageDrawable(this.nok);
            } else {
                this.non.setImageDrawable(this.nol);
            }
            int i = this.noj.ndz;
            if (i > 99) {
                this.noo.setText("99+");
                return;
            } else if (i == 0) {
                this.noo.setText("");
                return;
            } else {
                this.noo.setText(String.valueOf(i));
                return;
            }
        }
        setVisibility(8);
    }

    public void onClick(View view) {
        if (q.FS().equals(this.noj.fDC)) {
            if (this.noj.ndz > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                getContext().startActivity(intent);
            }
        } else if (!this.noj.ndA) {
            this.noj.ndA = true;
            a aVar = this.noj;
            aVar.ndz++;
            this.noi.aQI();
            String str = this.mAppId;
            String str2 = this.noj.fDC;
            b.a aVar2 = new b.a();
            aVar2.hmj = new ed();
            aVar2.hmk = new ee();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.hmi = 1330;
            b JZ = aVar2.JZ();
            ed edVar = (ed) JZ.hmg.hmo;
            edVar.nfn = str;
            edVar.nko = str2;
            u.a(JZ, new u.a(this) {
                final /* synthetic */ GameDetailRankLikeView nop;

                {
                    this.nop = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (!(i == 0 && i2 == 0)) {
                        x.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                    return 0;
                }
            });
            ap.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.ndn, null);
            aRy();
            this.non.startAnimation(this.nom);
        }
    }
}
