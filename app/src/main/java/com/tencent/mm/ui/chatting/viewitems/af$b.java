package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingTranslateView;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.z.u;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import com.tencent.wcdb.FileUtils;

public class af$b extends b implements b {
    private static final int yNk = R.h.bUr;
    private static final int yNl = R.h.bUq;
    private af$d yNm;
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public boolean aj(int i, boolean z) {
        if (z && (i == 1 || i == 11 || i == 21 || i == 31 || i == 36 || i == 301989937)) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddN);
        view.setTag(new af$e().q(view, false));
        return view;
    }

    public void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        boolean z;
        boolean z2;
        int i2 = 8;
        this.yqa = aVar2;
        aVar = (af$e) aVar;
        aVar.yNq.setTag(yNk, Long.valueOf(auVar.field_msgId));
        aVar.yNq.setTag(yNl, Boolean.valueOf(true));
        if (b.cvy()) {
            if (aVar.psA != null) {
                aVar.psA.setVisibility(8);
            }
            if (auVar.field_status == 1 || auVar.field_status == 5) {
                if (aVar.yJk != null) {
                    aVar.yJk.setVisibility(8);
                }
                aVar.yNq.setBackgroundResource(R.g.bBu);
                auVar.xze = true;
            } else {
                aVar.yNq.setBackgroundResource(R.g.bBt);
                if (aVar.yJk != null) {
                    if (b.a(aVar2.ysf, auVar.field_msgId)) {
                        if (auVar.xze) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            aVar.yNq.startAnimation(alphaAnimation);
                            auVar.xze = false;
                        }
                        aVar.yJk.setVisibility(0);
                    } else {
                        aVar.yJk.setVisibility(8);
                    }
                }
            }
        } else if (aVar.psA != null) {
            ProgressBar progressBar = aVar.psA;
            if (auVar.field_status < 2) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
        CharSequence charSequence = auVar.field_content;
        if (bh.ov(charSequence)) {
            x.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
        }
        if (com.tencent.mm.app.plugin.b.uA()) {
            aVar.yJZ.mG(false);
            if (auVar.cjr()) {
                if (auVar.cjw()) {
                    aVar.yJZ.Zc(auVar.field_transBrandWording);
                    z = true;
                } else {
                    aVar.yJZ.csb();
                    z = false;
                }
            } else if (aVar2.yvI.aU(auVar) == ChattingTranslateView.a.yvC) {
                aVar.yJZ.csc();
                z = false;
            } else {
                aVar.yJZ.csb();
                z = false;
            }
        } else {
            aVar.yJZ.mG(true);
            z = false;
        }
        if (auVar.gjF == null || !auVar.cjD()) {
            z2 = false;
        } else {
            z2 = true;
        }
        CharSequence charSequence2;
        CharSequence d;
        CharSequence d2;
        MMNeatTextView mMNeatTextView;
        if (z && !z2) {
            charSequence2 = " ";
            if (com.tencent.mm.storage.x.fV(aVar2.ysf.hlJ) || com.tencent.mm.storage.x.fV(aVar2.ysf.talker)) {
                Context context = aVar.yNq.getContext();
                aVar.yNq.gu.getTextSize();
                d = i.d(context, charSequence, 1);
                context = aVar.yNq.getContext();
                CharSequence charSequence3 = auVar.field_transContent;
                aVar.yNq.gu.getTextSize();
                d2 = i.d(context, charSequence3, 1);
                mMNeatTextView = aVar.yNq;
                br(auVar);
                a(mMNeatTextView, d, d2, charSequence2, auVar);
            } else {
                d = i.a(aVar.yNq.getContext(), charSequence, (int) aVar.yNq.gu.getTextSize(), 1);
                d2 = i.a(aVar.yNq.getContext(), auVar.field_transContent, (int) aVar.yNq.gu.getTextSize(), 1);
                mMNeatTextView = aVar.yNq;
                br(auVar);
                a(mMNeatTextView, d, d2, charSequence2, auVar);
            }
        } else if (z2) {
            Object obj;
            charSequence2 = " ";
            if (auVar.gjF.contains("notify@all")) {
                obj = "";
            } else {
                obj = aVar.yNq.getContext().getString(R.l.eFN, new Object[]{"@"}) + "\n";
            }
            if (z) {
                d = i.a(aVar.yNq.getContext(), obj + charSequence, (int) aVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                d2 = i.a(aVar.yNq.getContext(), auVar.field_transContent, (int) aVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                mMNeatTextView = aVar.yNq;
                br(auVar);
                a(mMNeatTextView, d, d2, charSequence2, auVar);
            } else {
                aVar.yNq.V(i.a(aVar.yNq.getContext(), obj + charSequence, (int) aVar.yNq.gu.getTextSize(), Integer.valueOf(31), br(auVar)));
            }
        } else {
            CharSequence a = i.a(aVar.yNq.getContext(), charSequence, (int) aVar.yNq.gu.getTextSize(), null, br(auVar));
            if (aVar2.yvY.gd(auVar.field_msgId)) {
                aVar.yNq.V(f.a(com.tencent.mm.plugin.fts.d.b.a.a(a, aVar2.yvY.yAL, com.tencent.mm.plugin.fts.d.b.a.a.mQe, d.a.mOD)).mQk);
            } else {
                aVar.yNq.V(a);
            }
            for (m type : (m[]) a.getSpans(0, a.length(), m.class)) {
                if (type.getType() == 44) {
                    g.pQN.h(12809, Integer.valueOf(6), "");
                    break;
                }
            }
        }
        aVar.yNq.setTag(ar.b(auVar, aVar2.ypn, i));
        MMNeatTextView mMNeatTextView2 = aVar.yNq;
        if (this.yNm == null) {
            this.yNm = new af$d(this.yqa);
        }
        mMNeatTextView2.setOnClickListener(this.yNm);
        aVar.yNq.setOnLongClickListener(s(aVar2));
        aVar.yNq.zLw = this;
        aVar.yNq.ztX = new MMNeatTextView.a(this) {
            final /* synthetic */ af$b yNp;

            public final void T(CharSequence charSequence) {
                if (((Boolean) aVar.yNq.getTag(af$b.yNl)).booleanValue()) {
                    com.tencent.mm.ui.chatting.f.a.a.cvt();
                    com.tencent.mm.ui.chatting.f.a.a.cvu().a(charSequence, ((Long) aVar.yNq.getTag(af$b.yNk)).longValue());
                }
            }
        };
        a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
    }

    private void a(MMNeatTextView mMNeatTextView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, au auVar) {
        Object spannableStringBuilder = new SpannableStringBuilder();
        if (this.yqa.yvY.gd(auVar.field_msgId)) {
            spannableStringBuilder.append(f.a(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.yqa.yvY.yAL, com.tencent.mm.plugin.fts.d.b.a.a.mQe, d.a.mOD)).mQk);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence3);
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence2);
        int length = charSequence.length() + 1;
        int length2 = charSequence3.length();
        if (TextUtils.isEmpty(mMNeatTextView.mText)) {
            mMNeatTextView.V(spannableStringBuilder);
            mMNeatTextView.measure(0, 0);
        }
        Drawable drawable = this.yqa.getResources().getDrawable(R.g.bHa);
        drawable.setBounds(0, 0, (mMNeatTextView.getMeasuredWidth() - mMNeatTextView.getPaddingLeft()) - mMNeatTextView.getPaddingRight(), 2);
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length, (length + length2) + 1, 33);
        spannableStringBuilder.setSpan(imageSpan, length, length2 + length, 33);
        mMNeatTextView.V(spannableStringBuilder);
    }

    private String br(au auVar) {
        if (auVar == null) {
            return null;
        }
        String hz = u.hz(auVar.field_msgSvrId);
        u.b t = u.GK().t(hz, true);
        t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
        t.o("preUsername", a(this.yqa, auVar));
        t.o("preChatName", b.b(this.yqa, auVar));
        return hz;
    }

    public boolean a(ContextMenu contextMenu, View view, au auVar) {
        boolean z;
        if (auVar.gjF == null || !auVar.gjF.contains("announcement@all")) {
            z = false;
        } else {
            z = true;
        }
        if (auVar.cjg() || auVar.ciZ()) {
            int i = ((ar) view.getTag()).position;
            if (auVar.cjg()) {
                contextMenu.add(i, 102, 0, view.getContext().getString(R.l.dRE));
            }
            contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eEC));
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
            }
            if (com.tencent.mm.bm.d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
            }
            if (com.tencent.mm.pluginsdk.model.app.g.R(this.yqa.getContext(), auVar.getType())) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
            }
            if (!z && !auVar.ciV() && auVar.cjg() && ((auVar.field_status == 2 || auVar.gjJ == 1) && b.a(auVar, this.yqa) && b.Zq(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
            }
            if (com.tencent.mm.app.plugin.b.uA()) {
                if (auVar.cjr() && auVar.cjw()) {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dRV));
                } else {
                    contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dRX));
                }
            }
            if (auVar.cjg() && com.tencent.mm.ag.f.LL()) {
                this.yqa.csV();
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }

    public final boolean dF(View view) {
        return this.yqa.ysf.ysX.do(view);
    }
}
