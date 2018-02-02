package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    float jek = 0.0f;
    public int jtA = -1;
    public int jtB = 0;
    Runnable jtC = new 1(this);
    View jtu;
    private GestureDetector jtw;
    int jty = 0;
    public float jtz = 0.0f;
    Context mContext;
    int tqo = a.tqt;
    b tqp;
    public boolean tqq;
    public boolean tqr;

    public a(Context context, View view, b bVar) {
        this.mContext = context;
        this.tqp = bVar;
        this.jtu = view;
        this.jtw = new GestureDetector(this.mContext, new 2(this));
        this.jek = c.bW(context);
    }

    public final void F(MotionEvent motionEvent) {
        if (this.tqp.bQc()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.jtz = motionEvent.getRawX();
                this.jty = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                this.jek = c.bW(this.mContext);
            }
            this.jtw.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                if (this.tqo == a.tqw) {
                    this.tqp.f(this.jtB, motionEvent.getRawX() - this.jtz);
                    this.jtA = -1;
                    this.jtB = 0;
                    this.jtz = 0.0f;
                } else if (this.tqo == a.tqu) {
                    ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                    this.tqp.agV();
                } else if (this.tqo == a.tqv) {
                    this.tqp.agW();
                }
                this.tqo = a.tqt;
                return;
            }
            return;
        }
        this.tqo = a.tqt;
    }
}
