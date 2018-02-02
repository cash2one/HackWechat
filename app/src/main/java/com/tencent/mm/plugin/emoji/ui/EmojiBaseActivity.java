package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    a lBv;
    b lBw;
    private HandlerThread mHandlerThread;

    private class a extends af {
        final /* synthetic */ EmojiBaseActivity lBx;

        a(EmojiBaseActivity emojiBaseActivity, Looper looper) {
            this.lBx = emojiBaseActivity;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.lBx.k(message);
        }
    }

    public abstract void k(Message message);

    public abstract void l(Message message);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandlerThread = e.Wf("EmojiBaseActivity_handlerThread");
        this.mHandlerThread.start();
        this.lBv = new a(this, this.mHandlerThread.getLooper());
        this.lBw = new b(this, getMainLooper());
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.lBv == null || this.lBv.getLooper() == null)) {
            this.lBv.getLooper().quit();
        }
        this.mHandlerThread = null;
        this.lBv = null;
        this.lBw = null;
    }

    public final void cp(int i, int i2) {
        if (this.lBw != null) {
            this.lBw.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    public final void m(Message message) {
        if (this.lBw != null) {
            this.lBw.sendMessage(message);
        }
    }

    public final void aCI() {
        if (this.lBw != null) {
            this.lBw.removeMessages(131074);
        }
    }
}
