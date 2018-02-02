package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class o {
    private static final f<String, SpannableString> vvh = new f(500);
    String iKB;
    private TextView kO;
    private Context mContext;
    private ArrayList<k> vvi;
    private ArrayList<a> vvj;
    private ArrayList<p> vvk;
    boolean vvl;
    boolean vvm;
    boolean vvn;
    boolean vvo;
    boolean vvp;
    boolean vvq;
    boolean vvr;
    boolean vvs;
    boolean vvt;
    boolean vvu;
    boolean vvv;
    int vvw;
    private int vvx;
    boolean vvy;
    Object vvz;

    class a {
        int end;
        int start;
        final /* synthetic */ o vvA;

        a(o oVar, int i, int i2) {
            this.vvA = oVar;
            this.start = i;
            this.end = i2;
        }
    }

    public o(Context context) {
        this.vvi = new ArrayList();
        this.vvj = new ArrayList();
        this.vvk = new ArrayList();
        this.kO = null;
        this.vvl = false;
        this.vvm = false;
        this.vvn = false;
        this.vvo = true;
        this.vvp = true;
        this.vvq = false;
        this.vvr = false;
        this.vvs = false;
        this.vvt = false;
        this.vvu = false;
        this.vvv = true;
        this.vvw = 0;
        this.vvx = 0;
        this.mContext = null;
        this.vvy = false;
        this.vvi = new ArrayList();
        this.vvj = new ArrayList();
        this.vvk = new ArrayList();
        this.mContext = context;
    }

    public final o j(TextView textView) {
        this.kO = textView;
        if (textView != null) {
            this.mContext = this.kO.getContext();
        }
        return this;
    }

    public final SpannableString a(CharSequence charSequence, int i, boolean z) {
        if (charSequence == null) {
            return new SpannableString("");
        }
        int i2;
        CharSequence charSequence2;
        CharSequence spannableString;
        Iterator it;
        k kVar;
        Iterator it2;
        p pVar;
        Drawable drawable;
        int i3;
        this.vvx = i;
        String str = charSequence + "@" + this.vvx + "@" + this.vvl + "@" + this.vvn + "@" + this.vvo + "@" + this.vvp + "@" + this.vvw + "@" + this.vvy + "@" + this.vvs + "@" + this.vvt + "@" + this.vvu;
        if (z) {
            SpannableString spannableString2 = (SpannableString) vvh.get(str);
            if (spannableString2 != null) {
                e(spannableString2);
                f(spannableString2);
                ccs();
                return spannableString2;
            }
        }
        this.vvi = new ArrayList();
        if (this.vvx <= 0) {
            if (this.kO != null) {
                this.vvx = (int) this.kO.getTextSize();
            } else {
                this.vvx = com.tencent.mm.bv.a.aa(this.mContext, c.bvK);
            }
        }
        if (this.vvi == null) {
            this.vvi = new ArrayList();
        }
        if (this.vvj == null) {
            this.vvj = new ArrayList();
        }
        this.vvi.clear();
        this.vvj.clear();
        if (charSequence != null) {
            if (q.gGe.gER == 1) {
                i2 = 1;
            } else if (VERSION.SDK_INT == 16 && bh.az(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
                i2 = 1;
            }
            if (i2 != 0 && this.vvv && com.tencent.mm.pluginsdk.ui.d.d.a.vuq != null && (com.tencent.mm.pluginsdk.ui.d.d.a.vuq.x(charSequence) || com.tencent.mm.pluginsdk.ui.d.d.a.vuq.w(charSequence))) {
                charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
            if (this.vvl) {
                charSequence = charSequence.toString().contains("data-miniprogram-appid") ? E(charSequence) : D(charSequence);
            }
            if (this.vvs) {
                charSequence = B(charSequence);
            }
            if (this.vvu) {
                charSequence = C(charSequence);
            }
            if (this.vvv || com.tencent.mm.pluginsdk.ui.d.d.a.vuq == null) {
                charSequence2 = charSequence;
            } else {
                charSequence2 = com.tencent.mm.pluginsdk.ui.d.d.a.vuq.b(this.mContext, charSequence, this.vvx);
            }
            if (this.vvo) {
                this.vvj.addAll(F(charSequence2));
            }
            if (this.vvl) {
                this.vvj.addAll(G(charSequence2));
            }
            if (this.vvm) {
                this.vvj.addAll(H(charSequence2));
            }
            if (this.vvr) {
                this.vvj.addAll(L(charSequence2));
            }
            if (this.vvp) {
                this.vvj.addAll(I(charSequence2));
            }
            if (this.vvn) {
                this.vvj.addAll(J(charSequence2));
            }
            if (this.vvq) {
                this.vvj.addAll(K(charSequence2));
            }
            spannableString = charSequence2 instanceof Spannable ? (SpannableString) charSequence2 : new SpannableString(charSequence2);
            if (this.vvy) {
                it = this.vvi.iterator();
                while (it.hasNext()) {
                    kVar = (k) it.next();
                    kVar.iKB = this.iKB;
                    if (bh.ov(kVar.url)) {
                        spannableString.setSpan(new ForegroundColorSpan(kVar.linkColor), kVar.start, kVar.end, 33);
                    } else if (kVar.start <= spannableString.length() && kVar.end <= spannableString.length()) {
                        spannableString.setSpan(new m(this.vvw, kVar), kVar.start, kVar.end, 33);
                    }
                }
            }
            it2 = this.vvk.iterator();
            while (it2.hasNext()) {
                pVar = (p) it2.next();
                if (pVar.start <= spannableString.length() && pVar.end <= spannableString.length()) {
                    drawable = this.mContext.getResources().getDrawable(pVar.id);
                    if (pVar.width > 0 || pVar.height <= 0) {
                        if (this.kO != null) {
                            i3 = (int) (((float) this.vvx) * 1.3f);
                        } else {
                            i3 = (int) (this.kO.getTextSize() * 1.3f);
                        }
                        drawable.setBounds(0, 0, i3, i3);
                    } else {
                        drawable.setBounds(0, 0, com.tencent.mm.bv.a.fromDPToPix(this.mContext, pVar.width), com.tencent.mm.bv.a.fromDPToPix(this.mContext, pVar.height));
                    }
                    e eVar = new e(drawable, 1);
                    eVar.zsZ = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 2);
                    spannableString.setSpan(eVar, pVar.start, pVar.start + 1, 18);
                }
            }
            f(spannableString);
            ccs();
            if (z) {
                vvh.l(str, new SpannableString(spannableString));
            }
            return spannableString;
        }
        i2 = 0;
        charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
        if (this.vvl) {
            if (charSequence.toString().contains("data-miniprogram-appid")) {
            }
        }
        if (this.vvs) {
            charSequence = B(charSequence);
        }
        if (this.vvu) {
            charSequence = C(charSequence);
        }
        if (this.vvv) {
        }
        charSequence2 = charSequence;
        if (this.vvo) {
            this.vvj.addAll(F(charSequence2));
        }
        if (this.vvl) {
            this.vvj.addAll(G(charSequence2));
        }
        if (this.vvm) {
            this.vvj.addAll(H(charSequence2));
        }
        if (this.vvr) {
            this.vvj.addAll(L(charSequence2));
        }
        if (this.vvp) {
            this.vvj.addAll(I(charSequence2));
        }
        if (this.vvn) {
            this.vvj.addAll(J(charSequence2));
        }
        if (this.vvq) {
            this.vvj.addAll(K(charSequence2));
        }
        if (charSequence2 instanceof Spannable) {
        }
        if (this.vvy) {
            it = this.vvi.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                kVar.iKB = this.iKB;
                if (bh.ov(kVar.url)) {
                    spannableString.setSpan(new ForegroundColorSpan(kVar.linkColor), kVar.start, kVar.end, 33);
                } else {
                    spannableString.setSpan(new m(this.vvw, kVar), kVar.start, kVar.end, 33);
                }
            }
        }
        it2 = this.vvk.iterator();
        while (it2.hasNext()) {
            pVar = (p) it2.next();
            drawable = this.mContext.getResources().getDrawable(pVar.id);
            if (pVar.width > 0) {
            }
            if (this.kO != null) {
                i3 = (int) (this.kO.getTextSize() * 1.3f);
            } else {
                i3 = (int) (((float) this.vvx) * 1.3f);
            }
            drawable.setBounds(0, 0, i3, i3);
            e eVar2 = new e(drawable, 1);
            eVar2.zsZ = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 2);
            spannableString.setSpan(eVar2, pVar.start, pVar.start + 1, 18);
        }
        f(spannableString);
        ccs();
        if (z) {
            vvh.l(str, new SpannableString(spannableString));
        }
        return spannableString;
    }

    private static void e(Spannable spannable) {
        int i = 0;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            if (!((spans[i] instanceof e) || (spans[i] instanceof m))) {
                spannable.removeSpan(spans[i]);
            }
            i++;
        }
    }

    private CharSequence B(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuv.matcher(charSequence.toString());
        while (matcher.find()) {
            CharSequence replace;
            if (this.vvt) {
                replace = charSequence.toString().replace(matcher.group(0), "");
            } else {
                replace = charSequence.toString().replace(matcher.group(0), "  ");
                String group = matcher.group(1);
                int start = matcher.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    p pVar = new p(start, i, identifier);
                    if (!bh.ov(group) && "original_label".equals(group)) {
                        pVar.height = 15;
                        pVar.width = 35;
                    }
                    this.vvk.add(pVar);
                } else {
                    x.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vus.matcher(replace);
            charSequence = replace;
        }
        return charSequence;
    }

    private CharSequence C(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vut.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            int parseColor;
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Object group4 = matcher.group(3);
            CharSequence replace = charSequence2.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                charSequence2 = replace;
            } else {
                try {
                    parseColor = Color.parseColor(group2);
                } catch (Exception e) {
                    x.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group2);
                    parseColor = 0;
                }
                k kVar;
                if (bh.ov(group3)) {
                    kVar = new k(start, length);
                    kVar.linkColor = parseColor;
                    this.vvi.add(kVar);
                    this.vvj.add(new a(this, start, length));
                } else {
                    kVar = a.a(this.mContext, group3, start, length, parseColor, parseColor & -1711276033);
                    if (kVar != null) {
                        if (this.vvz != null) {
                            kVar.data = this.vvz;
                        }
                        this.vvi.add(kVar);
                        this.vvj.add(new a(this, start, length));
                    }
                }
                charSequence2 = replace;
                matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vut.matcher(replace);
                i = 1;
            }
        }
        if (i == 0) {
            Matcher matcher2 = com.tencent.mm.pluginsdk.ui.d.h.a.vuu.matcher(charSequence);
            while (matcher2.find()) {
                CharSequence group5 = matcher2.group(0);
                String group6 = matcher2.group(1);
                Object group7 = matcher2.group(2);
                if (group6.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group5, group7);
                    int start2 = matcher2.start(0);
                    parseColor = group7.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        W(group6, start2, parseColor);
                        matcher2 = com.tencent.mm.pluginsdk.ui.d.h.a.vut.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence D(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vus.matcher(charSequence.toString());
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            Object group3 = matcher.group(2);
            if (group2.length() >= 2) {
                charSequence2 = charSequence2.toString().replace(group, group3);
                int start = matcher.start(0);
                int length = group3.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    W(group2, start, length);
                    matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vus.matcher(charSequence2);
                }
            }
        }
        return charSequence2;
    }

    private CharSequence E(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vus.matcher(charSequence.toString());
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map y = bi.y(group.replace(group2, " ").replace(group3, " "), "a");
            if (y == null) {
                x.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                int i;
                CharSequence replace;
                String str = (String) y.get(".a.$data-miniprogram-appid");
                String str2 = (String) y.get(".a.$data-miniprogram-path");
                int i2 = !bh.ov(group2) ? 1 : 0;
                if (bh.ov(str)) {
                    i = 0;
                } else {
                    i = 1;
                }
                int start;
                int length;
                if (i2 == 0 || i != 0) {
                    if (i == 0) {
                        x.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.vvt) {
                        replace = charSequence2.toString().replace(group, group3);
                        start = matcher.start(0);
                        length = group3.length() + start;
                        k kVar = new k(group2, 45, null);
                        kVar.start = start;
                        kVar.end = length;
                        this.vvi.add(kVar);
                    } else {
                        Object obj = "    " + group3;
                        String replace2 = charSequence2.toString().replace(group, obj);
                        int start2 = matcher.start(0);
                        i2 = obj.length() + start2;
                        this.vvk.add(new p(start2 + 1, start2 + 3, g.iym));
                        k kVar2 = new k(str, 45, str2);
                        kVar2.start = start2 + 4;
                        kVar2.end = i2;
                        this.vvi.add(kVar2);
                        Object obj2 = replace2;
                    }
                } else if (group2.length() >= 2) {
                    replace = charSequence2.toString().replace(group, group3);
                    start = matcher.start(0);
                    length = group3.length() + start;
                    if (start < 0 || length > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                        charSequence2 = replace;
                    } else {
                        W(group2, start, length);
                    }
                }
                charSequence2 = replace;
                matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vus.matcher(replace);
            }
        }
        return charSequence2;
    }

    private ArrayList<a> F(CharSequence charSequence) {
        int i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        ArrayList<a> arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.d.h.a.vuz;
        if (charSequence.length() <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            k kVar = new k(matcher.group(), 24, null);
            kVar.start = start;
            kVar.end = end;
            if (!a(this.vvj, new a(this, start, end))) {
                this.vvi.add(kVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> G(CharSequence charSequence) {
        Matcher matcher;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuy.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vux.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vvj, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                k kVar = new k(charSequence2.substring(start, end), 1, this.vvz);
                kVar.start = start;
                kVar.end = end;
                this.vvi.add(kVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> H(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 200) {
            Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuE.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.vvj, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                    k kVar = new k(charSequence2.substring(start, end), 44, this.vvz);
                    kVar.start = start;
                    kVar.end = end;
                    this.vvi.add(kVar);
                    arrayList.add(new a(this, start, end));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<a> I(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuB.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vvj, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                k kVar = new k(charSequence2.substring(start, end), 28, null);
                kVar.start = start;
                kVar.end = end;
                this.vvi.add(kVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> J(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuA.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Object group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains(group)) && i < 24 && !a(this.vvj, new a(this, start, end))) {
                k kVar = new k(group, 25, this.vvz);
                kVar.start = start;
                kVar.end = end;
                this.vvi.add(kVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> K(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = a.bc(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            a aVar = new a(this, kVar.start, kVar.end);
            if (!a(this.vvj, aVar)) {
                this.vvi.add(kVar);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a> L(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuD.matcher(charSequence2);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            a aVar = new a(this, start, end);
            if (!a(this.vvj, aVar) && start >= 0 && end <= charSequence2.length()) {
                k kVar = new k(charSequence2.substring(start, end), 30, null);
                kVar.start = start;
                kVar.end = end;
                this.vvi.add(kVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vuC.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(this, start, end);
                if (!a(this.vvj, aVar) && start >= 0 && end <= charSequence2.length()) {
                    kVar = new k(charSequence2.substring(start, end), 30, null);
                    kVar.start = start;
                    kVar.end = end;
                    this.vvi.add(kVar);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean W(String str, int i, int i2) {
        k a = a.a(this.mContext, str, i, i2);
        if (a == null) {
            return false;
        }
        if (this.vvz != null) {
            a.data = this.vvz;
        }
        this.vvi.add(a);
        this.vvj.add(new a(this, i, i2));
        return true;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            a aVar2 = (a) it.next();
            if (aVar2.end <= aVar.start || aVar.end <= aVar2.start) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void f(Spannable spannable) {
        if (this.kO != null && !bh.ov(spannable.toString())) {
            if (r.idS) {
                this.kO.setText(spannable, BufferType.SPANNABLE);
            } else {
                this.kO.setText(spannable);
            }
        }
    }

    private void ccs() {
        if (this.kO != null) {
            OnTouchListener lVar = new l();
            lVar.iKB = this.iKB;
            this.kO.setOnTouchListener(lVar);
        }
    }

    public static void clearCache() {
        vvh.clear();
    }
}
