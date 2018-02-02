package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class i {
    Bitmap bitmap = null;
    private View contentView = null;
    Context context;
    ImageView fyg = null;
    SharedPreferences gZO;
    View nVo;
    View rno;
    private h vrs;
    g vrt;
    q vru;
    boolean vrv = true;
    com.tencent.mm.pluginsdk.ui.chat.h.a vrw;
    a vrx;

    public interface a {
        void SB(String str);
    }

    public i(Context context, View view, View view2, a aVar) {
        this.context = context;
        this.rno = view;
        this.nVo = view2;
        this.vrs = new h(this.context);
        this.gZO = context.getSharedPreferences(ac.cfs(), 0);
        this.vrx = aVar;
        this.contentView = View.inflate(this.context, R.i.dda, null);
        this.fyg = (ImageView) this.contentView.findViewById(R.h.cGk);
        this.vru = new q(this.contentView, -2, -2, true);
        this.vru.setBackgroundDrawable(new ColorDrawable(0));
        this.vru.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new 1(this));
    }

    public final synchronized String cca() {
        String str;
        g gVar;
        if (this.vrs == null) {
            x.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList cbZ = this.vrs.cbZ();
            if (cbZ == null || cbZ.size() == 0) {
                x.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                gVar = (g) cbZ.get(0);
                if (gVar != null) {
                    if ((bh.by(gVar.mRg) < 0 ? 1 : null) != null) {
                        x.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[]{gVar.vrr});
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.vrr == null || !gVar.vrr.contains(e.bnE)) {
                    if (gVar != null) {
                        if ((bh.by(gVar.mRg) <= 30 ? 1 : null) != null) {
                            if (this.gZO.getString("chattingui_recent_shown_image_path", "").equals(gVar.vrr)) {
                                x.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(addDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(gVar == null);
                    x.d(str2, str3, objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.vrt = gVar;
        if (this.vrt == null) {
            str = null;
        } else {
            str = this.vrt.fvC;
            if (this.vrt.fvC == null) {
                str = this.vrt.vrr;
            }
        }
        return str;
    }

    final float Cp(int i) {
        return TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
    }
}
