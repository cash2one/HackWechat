package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.v;
import java.io.File;

public class e$a {
    public OnDismissListener jWl;
    public Context mContext;
    public i pyk;
    public final i$a vnq;
    String vnr = null;

    public e$a(Context context) {
        this.mContext = context;
        this.vnq = new i$a(this.mContext);
        this.vnq.mi(false);
        this.vnq.mj(false);
        this.vnq.a(new 1(this));
    }

    public final e$a bS(Object obj) {
        e.a(this.mContext, this.vnq, obj);
        this.vnq.mh(true);
        return this;
    }

    public final e$a caS() {
        this.vnq.xZs.xXj = 2;
        return this;
    }

    public final e$a Sp(String str) {
        int fromDPToPix = a.fromDPToPix(this.mContext, (int) (14.0f * a.eu(this.mContext)));
        if (!bh.ov(str)) {
            this.vnq.Q(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, str.toString(), (float) fromDPToPix));
        }
        return this;
    }

    public final e$a Sq(String str) {
        this.vnq.xZs.fvC = str;
        return this;
    }

    public final e$a caT() {
        this.vnq.xZs.xXm = 8;
        return this;
    }

    public final e$a a(Bitmap bitmap, int i) {
        this.vnq.a(bitmap, true, i);
        this.vnq.mh(false);
        this.vnq.a(new e$8(bitmap));
        return this;
    }

    public final e$a Sr(String str) {
        Context context = this.mContext;
        i$a com_tencent_mm_ui_base_i_a = this.vnq;
        View inflate = v.fv(context).inflate(R.i.dnn, null);
        MMAnimateView mMAnimateView = (MMAnimateView) inflate.findViewById(R.h.cbZ);
        if (mMAnimateView == null) {
            x.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
        } else if (bh.ov(str)) {
            x.e("MicroMsg.MMConfirmDialog", "Error , emoji msg path is null !!");
        } else {
            EmojiInfo yc = ((c) g.k(c.class)).getEmojiMgr().yc(str);
            if (str.indexOf(File.separatorChar) == -1) {
                d emojiMgr = ((c) g.k(c.class)).getEmojiMgr();
                com.tencent.mm.plugin.emoji.d.aAm();
                str = emojiMgr.ck("", str);
            }
            if (yc == null || (yc.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                mMAnimateView.Cq(str);
            } else {
                mMAnimateView.g(((c) g.k(c.class)).getEmojiMgr().a(yc), "");
            }
            com_tencent_mm_ui_base_i_a.dk(inflate);
            com_tencent_mm_ui_base_i_a.EB(1);
        }
        this.vnq.mh(false);
        return this;
    }

    public final e$a a(i$a.a aVar) {
        this.vnq.xZs.xWS = aVar;
        return this;
    }

    public final e$a da(View view) {
        this.vnq.dk(view);
        return this;
    }

    public final e$a f(Boolean bool) {
        this.vnq.xZs.xWL = bool.booleanValue();
        if (bool.booleanValue()) {
            this.vnq.YH(this.mContext.getString(R.l.dUb));
        }
        return this;
    }

    public final e$a Ss(String str) {
        this.vnq.YH(str);
        return this;
    }

    public final e$a caU() {
        this.vnq.mh(false);
        return this;
    }

    public final e$a BW(int i) {
        this.vnr = this.mContext.getResources().getString(i);
        return this;
    }

    public final e$a a(o.a aVar) {
        this.pyk = this.vnq.akx();
        if (this.jWl != null) {
            this.pyk.setOnDismissListener(this.jWl);
        }
        e.a(this.mContext, this.pyk, this.vnr, null, aVar, aVar);
        return this;
    }
}
