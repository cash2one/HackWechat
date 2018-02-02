package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public TextView kTq;
    public View ltB;
    public String ltJ;
    public ImageView ltK;
    public ImageView ltL;
    public Context mContext;

    public b(Context context, int i) {
        this.mContext = context;
        this.ltB = v.fv(this.mContext).inflate(i, null);
        aAC();
    }

    public b(Context context, View view) {
        this.mContext = context;
        this.ltB = view;
        aAC();
    }

    private void aAC() {
        if (this.ltB == null) {
            x.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            return;
        }
        this.ltK = (ImageView) this.ltB.findViewById(R.h.cry);
        this.kTq = (TextView) this.ltB.findViewById(R.h.crT);
        this.ltL = (ImageView) this.ltB.findViewById(R.h.crw);
    }
}
