package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.d.d;
import com.tencent.mm.ui.conversation.d.g;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a extends d {
    List<String> gIW;
    private Paint iYm = new Paint();
    private String username;
    private HashMap<String, Boolean> yVH;
    private HashMap<String, String> yVI;
    private c<ky> ypS;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a(Context context, String str, a aVar) {
        super(context, aVar);
        this.username = str;
        this.yVH = new HashMap();
        this.yVI = new HashMap();
        this.gIW = new ArrayList();
        this.ypS = new c<ky>(this) {
            final /* synthetic */ AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a yVJ;

            {
                this.yVJ = r2;
                this.xen = ky.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                boolean z = false;
                ky kyVar = (ky) bVar;
                if (kyVar.fCh.fnl != null) {
                    x.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", new Object[]{kyVar.fCh.fnl, Integer.valueOf(kyVar.fCh.fCi)});
                    if ((kyVar.fCh.fCi & 2) > 0) {
                        z = true;
                    }
                    this.yVJ.yVH.remove(kyVar.fCh.fnl);
                    this.yVJ.yVH.put(kyVar.fCh.fnl, Boolean.valueOf(z));
                    this.yVJ.notifyDataSetChanged();
                } else {
                    x.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                }
                return true;
            }
        };
        com.tencent.mm.sdk.b.a.xef.b(this.ypS);
    }

    public final void Xy() {
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fd().c(s.hfp, this.kiU, this.username));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    protected final void a(String str, g gVar) {
        boolean z;
        Boolean bool = (Boolean) this.yVH.get(str);
        if (bool == null) {
            WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str);
            z = qK != null && (qK.field_appOpt & 2) > 0;
            this.yVH.put(str, bool);
        } else {
            z = bool.booleanValue();
        }
        if (z) {
            gVar.ynz.setVisibility(0);
            gVar.ynz.setImageResource(R.k.dxo);
        } else {
            gVar.ynz.setVisibility(8);
        }
        CharSequence charSequence = (String) this.yVI.get(str);
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = com.tencent.mm.ui.appbrand.b.YC(com.tencent.mm.ui.appbrand.b.YB(str));
            if (!TextUtils.isEmpty(charSequence)) {
                this.yVI.put(str, charSequence);
            }
        }
        LayoutParams layoutParams;
        if (TextUtils.isEmpty(charSequence)) {
            layoutParams = (LayoutParams) gVar.ynw.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.weight = 0.0f;
            gVar.ynw.setLayoutParams(layoutParams);
        } else {
            int i;
            int dimensionPixelOffset;
            int dimensionPixelOffset2;
            float f;
            float f2;
            float f3;
            gVar.yXn.setVisibility(0);
            gVar.yXn.setText(this.context.getString(R.l.dEm, new Object[]{charSequence}));
            if (this.context.getResources().getDisplayMetrics() != null) {
                i = this.context.getResources().getDisplayMetrics().widthPixels;
            } else {
                i = 0;
            }
            if (com.tencent.mm.bv.a.ey(this.context)) {
                dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.bvE);
                dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.buD);
            } else {
                dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.bvF);
                dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.buE);
            }
            int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.f.bvv);
            int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.f.bvJ);
            d dVar = (d) this.yns.get(str);
            String charSequence2 = (dVar == null || dVar.nickName == null) ? "" : dVar.nickName.toString();
            if (charSequence2 == null) {
                f = 0.0f;
            } else {
                this.iYm.setTextSize(this.ynp);
                f = this.iYm.measureText(charSequence2);
            }
            float f4 = 48.0f + f;
            int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.f.buE);
            int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.f.bvz);
            x.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2)});
            f = 0.0f;
            if (i > 0) {
                f = (float) ((((i - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
            }
            if (f4 > f || f4 >= f || f <= 0.0f) {
                f2 = 0.6f;
                f3 = 0.4f;
            } else {
                f3 = Math.min(f4 / f, (((f - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f);
                f2 = f3;
                f3 = 1.0f - f3;
            }
            layoutParams = (LayoutParams) gVar.ynw.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = f2;
            gVar.ynw.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) gVar.yXn.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = f3;
            gVar.yXn.setLayoutParams(layoutParams);
        }
        com.tencent.mm.pluginsdk.ui.a.b.o(gVar.iip, str);
        if (!this.gIW.contains(str)) {
            this.gIW.add(str);
        }
    }

    public final void detach() {
        this.yVH = null;
        com.tencent.mm.sdk.b.a.xef.c(this.ypS);
    }
}
