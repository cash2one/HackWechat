package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.y.g;
import java.net.URLDecoder;

public class f$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 503316529) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dec);
        view.setTag(new f.a().q(view, false));
        return view;
    }

    private static String Zr(String str) {
        try {
            g.a fT = g.a.fT(str);
            if (fT != null) {
                return URLDecoder.decode(fT.content, "UTF-8");
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[]{e.getMessage()});
        }
        return "";
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        int i2 = 8;
        this.yqa = aVar2;
        f.a aVar3 = (f.a) aVar;
        if (cvy()) {
            if (aVar3.psA != null) {
                aVar3.psA.setVisibility(8);
            }
            if (auVar.field_status == 1 || auVar.field_status == 5) {
                if (aVar3.yJk != null) {
                    aVar3.yJk.setVisibility(8);
                }
                aVar3.yJY.setBackgroundResource(R.g.bBu);
                auVar.xze = true;
            } else {
                aVar3.yJY.setBackgroundResource(R.g.bBt);
                if (aVar3.yJk != null) {
                    if (a(aVar2.ysf, auVar.field_msgId)) {
                        if (auVar.xze) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            aVar3.yJY.startAnimation(alphaAnimation);
                            auVar.xze = false;
                        }
                        aVar3.yJk.setVisibility(0);
                    } else {
                        aVar3.yJk.setVisibility(8);
                    }
                }
            }
        } else if (aVar3.psA != null) {
            ProgressBar progressBar = aVar3.psA;
            if (auVar.field_status < 2) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
        CharSequence Zr = Zr(auVar.field_content);
        if (bh.ov(Zr)) {
            x.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId)});
        }
        aVar3.yJZ.mG(true);
        aVar3.yJY.setMinWidth(0);
        aVar3.yJY.setText(Zr);
        TextView textView = aVar3.yJY;
        int type = auVar.getType();
        String crz = aVar2.crz();
        if (type != 301989937) {
            i.a(textView, crz);
        }
        textView.getText();
        aVar3.yJY.setTag(ar.b(auVar, aVar2.ypn, i));
        aVar3.yJY.setOnLongClickListener(s(aVar2));
        aVar3.yJY.yxa = aVar2.ysf.ysX;
        a(i, aVar3, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRH));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }
}
