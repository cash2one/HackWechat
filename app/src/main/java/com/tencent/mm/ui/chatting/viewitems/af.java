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
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.u;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import com.tencent.wcdb.FileUtils;

public final class af {

    public static class a extends b implements b {
        private static final int yNk = R.h.bUr;
        private static final int yNl = R.h.bUq;
        private d yNm;
        private com.tencent.mm.ui.chatting.ChattingUI.a yqa;

        public final boolean aXj() {
            return false;
        }

        public boolean aj(int i, boolean z) {
            if (z || (i != 1 && i != 11 && i != 21 && i != 31 && i != 36 && i != 301989937)) {
                return false;
            }
            return true;
        }

        public View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddi);
            view.setTag(new e().q(view, true));
            return view;
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return aVar.ypn;
        }

        public void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            CharSequence trim;
            CharSequence charSequence;
            Object obj;
            Object obj2;
            Object obj3;
            CharSequence charSequence2;
            CharSequence d;
            MMNeatTextView mMNeatTextView;
            CharSequence a;
            MMNeatTextView mMNeatTextView2;
            this.yqa = aVar2;
            e eVar = (e) aVar;
            String str2 = auVar.field_content;
            String str3 = auVar.field_transContent;
            String str4 = aVar2.ysf.talker;
            eVar.yNq.setTag(yNk, Long.valueOf(auVar.field_msgId));
            eVar.yNq.setTag(yNl, Boolean.valueOf(true));
            Object obj4 = null;
            if (com.tencent.mm.app.plugin.b.uA()) {
                eVar.yJZ.mG(false);
                if (auVar.cjr()) {
                    if (auVar.cjw()) {
                        eVar.yJZ.Zc(auVar.field_transBrandWording);
                        obj4 = 1;
                    } else {
                        eVar.yJZ.csb();
                    }
                } else if (aVar2.yvI.aU(auVar) == com.tencent.mm.ui.chatting.ChattingTranslateView.a.yvC) {
                    eVar.yJZ.csc();
                } else {
                    eVar.yJZ.csb();
                }
            } else {
                eVar.yJZ.mG(true);
            }
            if (aVar2.ypn && !aVar2.ywd.vnK) {
                int hO = ba.hO(str2);
                if (hO != -1) {
                    String trim2 = str2.substring(0, hO).trim();
                    if (trim2 == null || trim2.length() <= 0) {
                        trim2 = str4;
                    }
                    str2 = str2.substring(hO + 1).trim();
                    if (obj4 != null) {
                        str3 = trim2;
                        trim = str3.substring(hO + 1).trim();
                        charSequence = str2;
                    } else {
                        obj = str2;
                        String str5 = str3;
                        str3 = trim2;
                        obj2 = str5;
                    }
                    a(eVar, aVar2, auVar, str3);
                    a(eVar, aVar2, str3, auVar);
                    if (auVar.gjF == null && auVar.cjD()) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (obj4 == null && obj3 == null) {
                        charSequence2 = " ";
                        if (x.fV(aVar2.ysf.hlJ) || x.fV(aVar2.ysf.talker)) {
                            Context context = eVar.yNq.getContext();
                            eVar.yNq.gu.getTextSize();
                            charSequence = i.d(context, charSequence, 1);
                            context = eVar.yNq.getContext();
                            trim = auVar.field_transContent;
                            eVar.yNq.gu.getTextSize();
                            d = i.d(context, trim, 1);
                            mMNeatTextView = eVar.yNq;
                            br(auVar);
                            a(mMNeatTextView, charSequence, d, charSequence2, auVar);
                        } else {
                            charSequence = i.a(eVar.yNq.getContext(), charSequence, (int) eVar.yNq.gu.getTextSize(), 1);
                            d = i.a(eVar.yNq.getContext(), trim, (int) eVar.yNq.gu.getTextSize(), 1);
                            mMNeatTextView = eVar.yNq;
                            br(auVar);
                            a(mMNeatTextView, charSequence, d, charSequence2, auVar);
                        }
                    } else if (obj3 == null) {
                        a = i.a(eVar.yNq.getContext(), charSequence, (int) eVar.yNq.gu.getTextSize(), null, br(auVar));
                        if (aVar2.yvY.gd(auVar.field_msgId)) {
                            eVar.yNq.V(a);
                        } else {
                            eVar.yNq.V(f.a(com.tencent.mm.plugin.fts.d.b.a.a(a, aVar2.yvY.yAL, com.tencent.mm.plugin.fts.d.b.a.a.mQe, com.tencent.mm.plugin.fts.d.d.a.mOC)).mQk);
                        }
                        for (m type : (m[]) a.getSpans(0, a.length(), m.class)) {
                            if (type.getType() == 44) {
                                g.pQN.h(12809, new Object[]{Integer.valueOf(7), ""});
                                break;
                            }
                        }
                    } else if (obj3 != null) {
                        charSequence2 = " ";
                        if (auVar.gjF.contains("notify@all")) {
                            obj3 = eVar.yNq.getContext().getString(R.l.eFN, new Object[]{"@"}) + "\n";
                        } else {
                            obj3 = "";
                        }
                        if (obj4 == null) {
                            charSequence = i.a(eVar.yNq.getContext(), obj3 + charSequence, (int) eVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                            d = i.a(eVar.yNq.getContext(), trim, (int) eVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                            mMNeatTextView = eVar.yNq;
                            br(auVar);
                            a(mMNeatTextView, charSequence, d, charSequence2, auVar);
                        } else {
                            eVar.yNq.V(i.a(eVar.yNq.getContext(), obj3 + charSequence, (int) eVar.yNq.gu.getTextSize(), Integer.valueOf(31), br(auVar)));
                        }
                    }
                    eVar.yNq.setTag(ar.b(auVar, aVar2.ypn, i));
                    mMNeatTextView2 = eVar.yNq;
                    if (this.yNm == null) {
                        this.yNm = new d(this.yqa);
                    }
                    mMNeatTextView2.setOnClickListener(this.yNm);
                    eVar.yNq.setOnLongClickListener(s(aVar2));
                    eVar.yNq.zLw = this;
                    eVar.yNq.setTag(yNk, Long.valueOf(auVar.field_msgId));
                    eVar.yNq.ztX = new 1(this, eVar);
                }
            }
            obj2 = str3;
            str3 = str4;
            obj = str2;
            a(eVar, aVar2, auVar, str3);
            a(eVar, aVar2, str3, auVar);
            if (auVar.gjF == null) {
            }
            obj3 = null;
            if (obj4 == null) {
            }
            if (obj3 == null) {
                a = i.a(eVar.yNq.getContext(), charSequence, (int) eVar.yNq.gu.getTextSize(), null, br(auVar));
                if (aVar2.yvY.gd(auVar.field_msgId)) {
                    eVar.yNq.V(a);
                } else {
                    eVar.yNq.V(f.a(com.tencent.mm.plugin.fts.d.b.a.a(a, aVar2.yvY.yAL, com.tencent.mm.plugin.fts.d.b.a.a.mQe, com.tencent.mm.plugin.fts.d.d.a.mOC)).mQk);
                }
                while (r1 < r2) {
                    if (type.getType() == 44) {
                        g.pQN.h(12809, new Object[]{Integer.valueOf(7), ""});
                        break;
                    }
                }
            } else if (obj3 != null) {
                charSequence2 = " ";
                if (auVar.gjF.contains("notify@all")) {
                    obj3 = eVar.yNq.getContext().getString(R.l.eFN, new Object[]{"@"}) + "\n";
                } else {
                    obj3 = "";
                }
                if (obj4 == null) {
                    eVar.yNq.V(i.a(eVar.yNq.getContext(), obj3 + charSequence, (int) eVar.yNq.gu.getTextSize(), Integer.valueOf(31), br(auVar)));
                } else {
                    charSequence = i.a(eVar.yNq.getContext(), obj3 + charSequence, (int) eVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                    d = i.a(eVar.yNq.getContext(), trim, (int) eVar.yNq.gu.getTextSize(), br(auVar), Integer.valueOf(31));
                    mMNeatTextView = eVar.yNq;
                    br(auVar);
                    a(mMNeatTextView, charSequence, d, charSequence2, auVar);
                }
            }
            eVar.yNq.setTag(ar.b(auVar, aVar2.ypn, i));
            mMNeatTextView2 = eVar.yNq;
            if (this.yNm == null) {
                this.yNm = new d(this.yqa);
            }
            mMNeatTextView2.setOnClickListener(this.yNm);
            eVar.yNq.setOnLongClickListener(s(aVar2));
            eVar.yNq.zLw = this;
            eVar.yNq.setTag(yNk, Long.valueOf(auVar.field_msgId));
            eVar.yNq.ztX = new 1(this, eVar);
        }

        private void a(MMNeatTextView mMNeatTextView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, au auVar) {
            Object spannableStringBuilder = new SpannableStringBuilder();
            if (this.yqa.yvY.gd(auVar.field_msgId)) {
                spannableStringBuilder.append(f.a(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.yqa.yvY.yAL, com.tencent.mm.plugin.fts.d.b.a.a.mQe, com.tencent.mm.plugin.fts.d.d.a.mOC)).mQk);
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
            Drawable drawable = this.yqa.getResources().getDrawable(R.g.bGZ);
            drawable.setBounds(0, 0, (mMNeatTextView.getMeasuredWidth() - mMNeatTextView.getPaddingLeft()) - mMNeatTextView.getPaddingRight(), 2);
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), length, length + length2, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length, (length2 + length) + 1, 33);
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
            t.o("preChatName", b(this.yqa, auVar));
            return hz;
        }

        protected boolean cvx() {
            return false;
        }

        public boolean a(ContextMenu contextMenu, View view, au auVar) {
            if (auVar.cjg() || auVar.ciZ()) {
                int i = ((ar) view.getTag()).position;
                if (auVar.cjg()) {
                    contextMenu.add(i, 102, 0, view.getContext().getString(R.l.dRE));
                }
                contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eEC));
                if (d.OQ("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                }
                if (com.tencent.mm.pluginsdk.model.app.g.R(this.yqa.getContext(), auVar.getType())) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                }
                if (auVar.cjg() && com.tencent.mm.ag.f.LL()) {
                    this.yqa.csV();
                }
                if (!this.yqa.csV()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
                }
                if (com.tencent.mm.app.plugin.b.uA()) {
                    if (auVar.cjr() && auVar.cjw()) {
                        contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dRV));
                    } else {
                        contextMenu.add(i, 124, 0, view.getContext().getString(R.l.dRX));
                    }
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean dF(View view) {
            return this.yqa.ysf.ysX.do(view);
        }
    }
}
