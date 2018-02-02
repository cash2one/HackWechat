package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i$a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class t {
    SharedPreferences gZO;
    public LinearLayout lHZ = null;
    long lPM = -1;
    Context mContext;
    public String puq;
    String pur;
    String pus;
    public ChatFooterCustom yub;
    public FrameLayout yuc;
    public FrameLayout yud;
    public TextView yue;
    public ImageView yuf;
    a yug = a.yur;
    public int yuh = -1;
    public boolean yui;
    String yuj = null;
    public String yuk;
    public OnClickListener yul = new 1(this);
    public OnClickListener yum = new 2(this);
    private i$a yun = new 7(this);

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Intent puJ;
        final /* synthetic */ t yuo;

        AnonymousClass5(t tVar, Intent intent) {
            this.yuo = tVar;
            this.puJ = intent;
        }

        public final void run() {
            g.a(this.yuo.mContext, this.puJ, this.yuo.mContext.getString(R.l.dQs), null, null);
        }
    }

    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] yuq = new int[a.values().length];

        static {
            try {
                yuq[a.yuu.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yuq[a.yut.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yuq[a.yus.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yuq[a.yuv.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                yuq[a.yuw.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static /* synthetic */ void a(t tVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        h.a(tVar.mContext, a.ac(tVar.mContext, R.l.dQo), "", a.ac(tVar.mContext, R.l.dQk), null);
    }

    static /* synthetic */ void b(t tVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        e.post(new 6(tVar), "QQMailDownloadUrlAndMD5");
    }

    public t(ChatFooterCustom chatFooterCustom) {
        this.mContext = chatFooterCustom.getContext();
        this.yub = chatFooterCustom;
    }

    public final void crV() {
        if (this.yug == a.yuv) {
            this.yuf.setImageResource(R.k.dAm);
        } else {
            this.yuf.setImageResource(R.k.dAn);
        }
    }

    public final void crW() {
        a aVar;
        if (!p.m(this.mContext, "com.tencent.androidqqmail")) {
            this.gZO = this.mContext.getSharedPreferences("QQMAIL", 4);
            this.lPM = this.gZO.getLong("qqmail_downloadid", -1);
            if (this.lPM >= 0) {
                FileDownloadTaskInfo bY = f.aAd().bY(this.lPM);
                int i = bY.status;
                this.yuj = bY.path;
                switch (i) {
                    case 1:
                        aVar = a.yut;
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.bO(this.yuj)) {
                            if (!bh.ov(this.puq)) {
                                aVar = a.yus;
                                break;
                            } else {
                                aVar = a.yuw;
                                break;
                            }
                        }
                        aVar = a.yuu;
                        break;
                    default:
                        if (!bh.ov(this.puq)) {
                            aVar = a.yus;
                            break;
                        } else {
                            aVar = a.yuw;
                            break;
                        }
                }
            }
            aVar = bh.ov(this.puq) ? a.yuw : a.yus;
        } else {
            aVar = a.yuv;
        }
        this.yug = aVar;
        crV();
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[]{this.yug.toString()});
        switch (AnonymousClass8.yuq[this.yug.ordinal()]) {
            case 1:
                this.yue.setText(R.l.dQl);
                return;
            case 2:
                this.yue.setText(R.l.dQj);
                return;
            case 3:
            case 4:
            case 5:
                i.a(this.yun);
                return;
            default:
                i.a(this.yun);
                return;
        }
    }

    public final void crX() {
        if (this.yuh == 0) {
            this.yue.setText(R.l.dQs);
        } else if (this.yuh > 99) {
            this.yue.setText(R.l.dQr);
        } else {
            this.yue.setText(String.format(a.ac(this.mContext, R.l.dQq), new Object[]{Integer.valueOf(this.yuh)}));
        }
    }
}
