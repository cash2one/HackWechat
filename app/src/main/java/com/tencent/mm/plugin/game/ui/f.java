package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.c.ai;
import com.tencent.mm.plugin.game.c.k;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a$a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class f extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private String mAppId;
    private Context mContext;
    private int ndn;

    public f(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ai aiVar, String str, int i, int i2) {
        if (aiVar == null || bh.cA(aiVar.ngS)) {
            setVisibility(8);
            return;
        }
        this.mAppId = str;
        this.ndn = i2;
        Iterator it = aiVar.ngS.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar != null) {
                e$a$a com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                TextView textView;
                TextView textView2;
                switch (kVar.nfS) {
                    case 1:
                        if (kVar.nfQ == null) {
                            break;
                        }
                        e(this);
                        View inflate = this.DF.inflate(R.i.djx, this, true);
                        textView = (TextView) inflate.findViewById(R.h.cxK);
                        textView2 = (TextView) inflate.findViewById(R.h.cxM);
                        EllipsizingTextView ellipsizingTextView = (EllipsizingTextView) inflate.findViewById(R.h.cxJ);
                        ellipsizingTextView.setMaxLines(2);
                        ImageView imageView = (ImageView) inflate.findViewById(R.h.cxL);
                        textView.setText(i.b(this.mContext, kVar.nfO, textView.getTextSize()));
                        textView2.setText(i.b(this.mContext, kVar.nfQ.fon, textView2.getTextSize()));
                        ellipsizingTextView.setText(i.b(this.mContext, kVar.nfQ.nfe, ellipsizingTextView.getTextSize()));
                        if (bh.ov(kVar.nfQ.nff)) {
                            imageView.setVisibility(8);
                        } else {
                            e.aRV().a(imageView, kVar.nfQ.nff, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                        }
                        inflate.setTag(new a(kVar.nfP, kVar.nfQ.nfg, kVar.nfK));
                        inflate.setOnClickListener(this);
                    case 2:
                        if (kVar.nfR == null) {
                            break;
                        }
                        e(this);
                        View inflate2 = this.DF.inflate(R.i.djy, this, true);
                        textView = (TextView) inflate2.findViewById(R.h.cOz);
                        textView2 = (TextView) inflate2.findViewById(R.h.cOB);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(R.h.cOA);
                        textView.setText(i.b(this.mContext, kVar.nfO, textView.getTextSize()));
                        textView2.setText(i.b(this.mContext, kVar.nfR.fon, textView2.getTextSize()));
                        if (bh.ov(kVar.nfR.nff)) {
                            imageView2.setVisibility(8);
                        } else {
                            if (kVar.nfR.nkl == 1) {
                                com_tencent_mm_plugin_game_d_e_a_a.nxt = true;
                                com_tencent_mm_plugin_game_d_e_a_a.nxw = R.g.bCE;
                            } else {
                                com_tencent_mm_plugin_game_d_e_a_a.hDY = true;
                                com_tencent_mm_plugin_game_d_e_a_a.nxw = R.g.bCD;
                            }
                            e.aRV().a(imageView2, kVar.nfR.nff, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                        }
                        inflate2.setTag(new a(kVar.nfP, kVar.nfR.nfg, kVar.nfK));
                        inflate2.setOnClickListener(this);
                    default:
                        if (i != 2) {
                            break;
                        }
                        ap.a(this.mContext, 10, 1002, kVar.nfP, str, i2, ap.BY(kVar.nfK));
                        break;
                }
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameBlockContentView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bh.ov(aVar.jumpUrl)) {
            x.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, aVar.ner, c.p(this.mContext, aVar.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.ndn, ap.BY(aVar.nbh));
    }

    private void e(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.DF.inflate(R.i.dkf, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
