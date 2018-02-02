package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.z.ba;
import java.lang.ref.WeakReference;

public class m extends ClickableSpan implements a {
    private WeakReference<View> fq = null;
    String iKB;
    private int jjf;
    boolean mEnable = true;
    public boolean ozA = false;
    private Context vuY = null;
    private int vvd;
    g vve = null;
    private k vvf = null;

    public m(int i, k kVar) {
        int i2;
        int i3 = 0;
        if (kVar != null) {
            i2 = kVar.linkColor;
            i3 = kVar.backgroundColor;
        } else {
            i2 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            zs(i);
        } else {
            eA(i2, i3);
        }
        this.vve = new g();
        this.vvf = kVar;
    }

    public void zs(int i) {
        Context context = ac.getContext();
        switch (i) {
            case 1:
                eA(context.getResources().getColor(b.lnG), -5908174);
                return;
            case 2:
                eA(context.getResources().getColor(b.btd), context.getResources().getColor(b.lnH));
                return;
            case 3:
                eA(context.getResources().getColor(b.lnI), context.getResources().getColor(b.lnH));
                return;
            default:
                return;
        }
    }

    public final void eA(int i, int i2) {
        this.vvd = i;
        this.jjf = i2;
    }

    public final void lo(boolean z) {
        this.ozA = z;
    }

    public final int getType() {
        return this.vvf == null ? Integer.MAX_VALUE : this.vvf.type;
    }

    public void onClick(View view) {
        if (this.vve != null && this.vvf != null && this.mEnable) {
            this.vve.mContext = this.vuY != null ? this.vuY : view.getContext();
            g gVar = this.vve;
            k kVar = this.vvf;
            if (System.currentTimeMillis() - gVar.sJl <= ((long) gVar.sJk)) {
                x.e("MicroMsg.MMSpanClickListener", "process pass");
            } else {
                gVar.sJl = System.currentTimeMillis();
                if (kVar == null) {
                    x.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
                } else {
                    x.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(kVar.type));
                    if (gVar.mContext == null) {
                        x.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
                    } else {
                        f fVar;
                        String str;
                        if (i.vuF == null || i.vuF.size() <= 0) {
                            fVar = null;
                        } else {
                            int size = i.vuF.size();
                            f fVar2 = (f) i.vuF.getLast();
                            x.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
                            fVar = fVar2;
                        }
                        if (view != null && (view.getTag() instanceof c)) {
                            cf cfVar = ((c) view.getTag()).fEJ;
                            if (cfVar != null) {
                                str = cfVar.field_talker;
                                if (str.endsWith("@chatroom")) {
                                    str = ba.hP(cfVar.field_content);
                                }
                                kVar.username = str;
                                if (!TextUtils.isEmpty(gVar.iKB)) {
                                    kVar.iKB = gVar.iKB;
                                }
                                b.a.vuo.a(gVar.mContext, kVar, fVar);
                                kVar.iKB = null;
                            }
                        }
                        str = null;
                        kVar.username = str;
                        if (TextUtils.isEmpty(gVar.iKB)) {
                            kVar.iKB = gVar.iKB;
                        }
                        b.a.vuo.a(gVar.mContext, kVar, fVar);
                        kVar.iKB = null;
                    }
                }
            }
            this.vve.mContext = null;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.vvd);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.vvd;
        if (this.ozA) {
            textPaint.bgColor = this.jjf;
        } else {
            textPaint.bgColor = 0;
        }
    }

    public final void setContext(Context context) {
        this.vuY = context;
        this.vve.mContext = context;
    }
}
