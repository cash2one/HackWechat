package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class GameFeedSocialInfoView extends LinearLayout {
    public TextView lkn;
    public LinearLayout nxX;
    public GameSmallAvatarList nxY;
    public TextView nxZ;
    public LinearLayout nya;

    public GameFeedSocialInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nxX = (LinearLayout) findViewById(R.h.bLM);
        this.nxY = (GameSmallAvatarList) findViewById(R.h.bLN);
        this.nxZ = (TextView) findViewById(R.h.bLI);
        this.nya = (LinearLayout) findViewById(R.h.caP);
        this.lkn = (TextView) findViewById(R.h.caR);
    }
}
