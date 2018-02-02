package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.mm.bm.d;
import com.tencent.mm.bx.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;

public class SmileyGrid extends GridView {
    public static int zDk = 1;
    public ListAdapter FP;
    public int irz = ChatFooterPanel.vjE;
    private OnItemClickListener kGC = new OnItemClickListener(this) {
        final /* synthetic */ SmileyGrid zDq;

        {
            this.zDq = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (this.zDq.zDl) {
                case 20:
                    if (i == this.zDq.FP.getCount() - 1) {
                        if (this.zDq.zDo != null) {
                            this.zDq.zDo.amZ();
                            return;
                        }
                        return;
                    } else if ((this.zDq.kaS * (this.zDq.zDm - 1)) + i < this.zDq.kaQ) {
                        int i2 = (this.zDq.kaS * (this.zDq.zDm - 1)) + i;
                        if (this.zDq.zDo != null) {
                            String mg;
                            if (this.zDq.zDp) {
                                mg = e.chc().mg(i2);
                            } else {
                                mg = e.chc().getText(i2);
                            }
                            this.zDq.zDo.append(mg);
                            g.pQN.h(13470, new Object[]{mg.replaceAll(",", " "), Integer.valueOf(this.zDq.irz)});
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 23:
                case 25:
                    if (this.zDq.zDl == 25 && i == 0 && this.zDq.kaS == 0 && this.zDq.irz != ChatFooterPanel.vjG) {
                        SmileyGrid.c(this.zDq);
                        return;
                    }
                    SmileyGrid.a(this.zDq, (EmojiInfo) this.zDq.FP.getItem(i));
                    return;
                default:
                    return;
            }
        }
    };
    private int kaQ;
    public int kaS;
    public j vrG;
    int zDl = 20;
    public int zDm = 0;
    private int zDn = 0;
    public a zDo;
    private boolean zDp;

    static /* synthetic */ void a(SmileyGrid smileyGrid, EmojiInfo emojiInfo) {
        if (smileyGrid.vrG == null || emojiInfo == null) {
            x.e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
        } else if (zDk != 2) {
            if (!smileyGrid.vrG.aZe()) {
                h.a(smileyGrid.getContext(), com.tencent.mm.plugin.m.a.h.lJJ, 0, new 2(smileyGrid));
            } else if (emojiInfo == null) {
            } else {
                if (emojiInfo.field_type != EmojiInfo.xAo && emojiInfo.field_type != EmojiInfo.xAp) {
                    x.i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", new Object[]{emojiInfo.Nr()});
                    EmojiInfo c = ((c) com.tencent.mm.kernel.g.k(c.class)).getProvider().c(emojiInfo);
                    if (c != null) {
                        smileyGrid.vrG.l(c);
                        x.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", new Object[]{c.Nr()});
                        return;
                    }
                    x.w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
                } else if (smileyGrid.vrG.aZd()) {
                    smileyGrid.vrG.m(emojiInfo);
                    x.d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", new Object[]{emojiInfo.Nr()});
                } else {
                    Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(com.tencent.mm.plugin.m.a.h.dSi), 0).show();
                }
            }
        } else if (emojiInfo.field_catalog == EmojiGroupInfo.xAc) {
            h.h(smileyGrid.getContext(), com.tencent.mm.plugin.m.a.h.dQH, com.tencent.mm.plugin.m.a.h.dQH).show();
        }
    }

    static /* synthetic */ void c(SmileyGrid smileyGrid) {
        g.pQN.h(11594, new Object[]{Integer.valueOf(1)});
        String value = com.tencent.mm.k.g.zY().getValue("ShowDesignerEmoji");
        x.i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", new Object[]{value});
        d.b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @TargetApi(8)
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void cAm() {
        setOnItemClickListener(this.kGC);
    }

    public final void j(int i, int i2, int i3, int i4, int i5) {
        x.v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.kaS);
        setOnItemClickListener(this.kGC);
        this.zDl = i;
        this.kaS = i2;
        this.kaQ = i3;
        this.zDm = i4;
        this.zDn = i5;
    }

    public void release() {
        this.zDo = null;
        this.vrG = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.FP = listAdapter;
    }
}
