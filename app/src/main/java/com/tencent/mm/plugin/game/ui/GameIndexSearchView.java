package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;

public class GameIndexSearchView extends LinearLayout {
    LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private Context mContext;

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nlX;
        final /* synthetic */ GameIndexSearchView nrm;

        AnonymousClass1(GameIndexSearchView gameIndexSearchView, int i) {
            this.nrm = gameIndexSearchView;
            this.nlX = i;
        }

        public final void onClick(View view) {
            int p;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a aPR = b.aPR();
                if (aPR.fDt == 2) {
                    p = c.p(this.nrm.mContext, aPR.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(this.nrm.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    this.nrm.mContext.startActivity(intent);
                    p = 6;
                }
            } else {
                p = c.p(this.nrm.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ap.a(this.nrm.mContext, 14, 1401, 1, p, 0, null, this.nlX, 0, null, null, null);
        }
    }

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        this.mContext = context;
    }
}
