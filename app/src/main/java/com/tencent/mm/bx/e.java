package com.tencent.mm.bx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a$a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;

public class e {
    private static e xkQ = null;
    private String[] xkR;
    private String[] xkS;
    private String[] xkT;
    private ArrayList<s> xkU = new ArrayList();
    private SparseArray<s> xkV = new SparseArray();

    public e(Context context) {
        this.xkR = context.getResources().getStringArray(a$a.bqU);
        this.xkS = context.getResources().getStringArray(a$a.bqV);
        this.xkT = context.getResources().getStringArray(a$a.isw);
        this.xkU.clear();
        this.xkV.clear();
        chb();
    }

    private void chb() {
        int i = 0;
        if (this.xkR != null && this.xkS != null) {
            int length = this.xkR.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                s sVar = new s(i3, this.xkR[i2]);
                this.xkU.add(sVar);
                this.xkV.put(i3, sVar);
                i2++;
                i3++;
            }
            i2 = this.xkS.length;
            while (i < i2) {
                s sVar2 = new s(i3, this.xkS[i]);
                this.xkU.add(sVar2);
                this.xkV.put(i3, sVar2);
                i++;
                i3++;
            }
        }
    }

    public int anl() {
        x.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.xkU.clear();
        ArrayList aAX = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aAX();
        if (aAX == null || aAX.isEmpty()) {
            chb();
            x.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            return -1;
        }
        ArrayList aAW = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aAW();
        int size = aAX.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            s sVar = (s) aAX.get(i);
            String str = sVar.field_key;
            if (!str.startsWith("[") || aAW.contains(str)) {
                this.xkU.add(sVar);
                this.xkV.put(i2, sVar);
                i3 = i2 + 1;
            } else {
                x.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[]{str});
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return 0;
    }

    public int anm() {
        return this.xkU == null ? 0 : this.xkU.size();
    }

    public static e chc() {
        if (xkQ == null) {
            synchronized (e.class) {
                xkQ = new e(ac.getContext());
            }
        }
        return xkQ;
    }

    public Drawable mf(int i) {
        if (this.xkV == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            return null;
        }
        s sVar = (s) this.xkV.get(i);
        if (sVar == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            return null;
        }
        Drawable mf;
        q Wm = f.chd().Wm(sVar.field_key);
        int i2;
        if (Wm != null) {
            f.chd();
            i2 = Wm.field_position;
            mf = i2 >= 0 ? b.cgX().mf(i2) : f.Wl(Wm.field_fileName);
        } else {
            c cVar;
            b cgX = b.cgX();
            String str = sVar.field_key;
            if (bh.ov(str)) {
                x.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                cVar = cgX.Dk(i2) != null ? cgX.Dk(i2) : cgX.eH(i2, 0);
            }
            mf = b.cgX().a(cVar);
        }
        return mf;
    }

    public String getText(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.xkU.get(i);
        if (sVar == null) {
            return "";
        }
        q Wm = f.chd().Wm(sVar.field_key);
        if (Wm != null) {
            if (w.cff() && !bh.ov(Wm.field_cnValue)) {
                return Wm.field_cnValue;
            }
            if (w.cfg() && !bh.ov(Wm.field_twValue)) {
                return Wm.field_twValue;
            }
        }
        return sVar.field_key;
    }

    public String mh(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.xkU.get(i);
        if (sVar != null) {
            return sVar.field_key;
        }
        return "";
    }

    public String mg(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            return "";
        }
        b hdVar = new hd();
        a.xef.m(hdVar);
        if ((hdVar.fxp.fqT == 1 ? 1 : 0) == 0) {
            return chc().xkS[i];
        }
        String[] split = chc().xkS[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        return stringBuilder.toString();
    }
}
