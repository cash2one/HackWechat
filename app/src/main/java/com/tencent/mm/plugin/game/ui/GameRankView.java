package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mm.R;

public class GameRankView extends FrameLayout {
    private Context mContext;
    ListView nuv;
    View nuw;
    s nux;
    private GameRankFooter nuy;

    public GameRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nuv = (ListView) findViewById(R.h.cnd);
        this.nuy = (GameRankFooter) View.inflate(this.mContext, R.i.dlc, null);
        GameRankFooter gameRankFooter = this.nuy;
        gameRankFooter.nuk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameRankView nuz;

            {
                this.nuz = r1;
            }

            public final void onClick(View view) {
                s a = this.nuz.nux;
                if (a.ntV.size() > a.ntX) {
                    if (a.ntX + 25 >= a.ntV.size()) {
                        a.ntX = a.ntV.size();
                        a.nua.aRL();
                        a.nuc = true;
                    } else {
                        a.ntX += 25;
                        a.nua.aRK();
                    }
                    a.ntW = a.ntV.subList(0, a.ntX);
                    if (a.nub || a.nud <= a.ntX) {
                        a.nua.aRM();
                    } else if (a.ntZ != null) {
                        a.nua.a(a.ntZ);
                    } else {
                        a.nua.aRM();
                    }
                    a.notifyDataSetChanged();
                }
            }
        });
        this.nuv.addFooterView(this.nuy);
        this.nux = new s(this.mContext, this.nuy);
        this.nuw = findViewById(R.h.cnb);
    }
}
