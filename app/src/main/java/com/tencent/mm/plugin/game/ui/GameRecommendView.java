package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.c.ag;

public class GameRecommendView extends LinearLayout implements OnClickListener {
    private ag nqz;

    public GameRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onClick(View view) {
        if (this.nqz != null) {
            this.nqz.ngN.nfN.get(((Integer) view.getTag()).intValue());
        }
    }
}
