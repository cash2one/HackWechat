package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMHorList;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private af mHandler;
    private final int nTF = a.fromDPToPix(null, 58);
    private String nTT;
    private final int scv = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private final int scw = 5;
    private MMHorList scx;
    a scy;
    private ak scz;

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.i.dsV, this);
        this.scx = (MMHorList) findViewById(R.h.coG);
        this.scx.ybK = true;
        this.scx.ybJ = true;
        this.scx.ybL = this.nTF;
        this.scy = new a(getContext());
        this.scx.setAdapter(this.scy);
        this.mHandler = new af(Looper.getMainLooper());
        this.scx.ybu = new 1(this);
        this.scz = new ak(new 2(this), false);
    }

    public final void Mt(String str) {
        if (this.scx != null) {
            if (!bh.ov(this.nTT) || !bh.ov(str)) {
                if (bh.ov(this.nTT) || !this.nTT.equals(str)) {
                    this.nTT = str;
                    aVf();
                }
            }
        }
    }

    private void aVf() {
        this.scy.nTT = this.nTT;
        if (bh.ov(this.nTT)) {
            this.scy.notifyDataSetChanged();
        } else if (!this.scx.oNe) {
            a aVar = this.scy;
            int indexOf = aVar.scC.indexOf(this.nTT) * this.nTF;
            int i = this.scx.ybx;
            if (indexOf < i) {
                this.scx.EN(indexOf);
            } else if (indexOf > i + (this.nTF * 4)) {
                this.scx.EN(indexOf - (this.nTF * 4));
            } else {
                this.scy.notifyDataSetChanged();
            }
        }
    }
}
