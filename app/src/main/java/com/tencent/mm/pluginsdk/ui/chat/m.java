package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a$e;
import com.tencent.mm.plugin.m.a$f;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.HorizontalListView$a;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m {
    private View Iv;
    private OnItemClickListener XC = new 3(this);
    private int kdN = 3;
    ArrayList<EmojiInfo> lDO = new ArrayList();
    Context mContext;
    af mHandler = new 1(this);
    a vqr;
    int vrC;
    int vrD;
    q vrE;
    View vrF;
    j vrG;
    String vrH;
    public String vrI = "";
    public boolean vrJ = true;
    private HorizontalListView vrK;
    b vrL;
    private boolean vrM = true;
    private Comparator vrN = new 2(this);
    private HorizontalListView$a vrO = new 4(this);

    public m(Context context) {
        this.mContext = context;
        this.Iv = View.inflate(this.mContext, a$f.lJx, null);
        this.vrK = (HorizontalListView) this.Iv.findViewById(a$e.lJw);
        this.vrL = new b(this);
        this.vrK.setAdapter(this.vrL);
        this.vrK.setOnItemClickListener(this.XC);
        this.vrK.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ m vrP;

            {
                this.vrP = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.vrK.vrO = this.vrO;
        this.vrC = a.aa(this.mContext, c.lIV);
        this.vrD = a.aa(this.mContext, c.bvB);
        this.vrE = new q(this.Iv, this.vrC + (this.vrD * 2), this.vrC + (this.vrD * 2), true);
        this.vrE.setBackgroundDrawable(new ColorDrawable(0));
        this.vrE.setOutsideTouchable(true);
        this.vrE.setFocusable(false);
    }

    public final void ccb() {
        if (this.vrF != null) {
            int[] iArr = new int[2];
            this.vrF.getLocationOnScreen(iArr);
            this.vrE.showAtLocation(this.vrF, 0, iArr[0] - ((this.vrE.getWidth() - this.vrF.getWidth()) / 2), iArr[1] - this.vrE.getHeight());
        }
    }

    public final void hide() {
        if (this.vrE != null && this.vrE.isShowing()) {
            this.vrE.dismiss();
        }
    }

    public final boolean ch(String str) {
        try {
            if (!bh.ov(str)) {
                ArrayList yg = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().yg(str);
                if (!(yg == null || yg.isEmpty())) {
                    this.vrH = str.replaceAll(",", "");
                    if (yg == null || yg.isEmpty()) {
                        return false;
                    }
                    EmojiInfo yc;
                    ArrayList arrayList = new ArrayList();
                    this.lDO.clear();
                    int size = yg.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        yc = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().yc((String) yg.get(i));
                        if (yc != null) {
                            arrayList.add(yc);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        x.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        return false;
                    }
                    if (this.vrM) {
                        yc = (EmojiInfo) Collections.max(arrayList, this.vrN);
                        this.lDO.add(yc);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                            if (!(emojiInfo.cc(yc) || this.lDO.contains(emojiInfo))) {
                                this.lDO.add(emojiInfo);
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            yc = (EmojiInfo) it2.next();
                            if (!this.lDO.contains(yc)) {
                                this.lDO.add(yc);
                            }
                        }
                    }
                    return (this.lDO == null || this.lDO.isEmpty()) ? false : true;
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.SuggestEmoticonBubble", bh.i(e));
        }
        this.vrH = "";
        return false;
    }
}
