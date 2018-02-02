package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;

public class AppBrandServiceChattingUI$b implements OnCreateContextMenuListener {
    private a yqa;

    public AppBrandServiceChattingUI$b(a aVar) {
        this.yqa = aVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "menuListener onCreateCotextMenuListener");
        if (view != null) {
            ar arVar = (ar) view.getTag();
            if (arVar != null) {
                int i = arVar.position;
                au auVar = (au) this.yqa.ysf.getItem(i);
                if (auVar == null) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "msg is null!");
                    return;
                }
                if (auVar.cjg()) {
                    contextMenu.add(i, 102, 0, this.yqa.getMMString(R.l.dQK));
                    contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eEC));
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                    if (g.R(this.yqa.getContext(), auVar.getType())) {
                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                    }
                }
                if (auVar.cje()) {
                    com.tencent.mm.z.ar.Hg();
                    if (c.isSDCardAvailable()) {
                        contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEC));
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                        b dhVar = new dh();
                        dhVar.frQ.fqm = auVar.field_msgId;
                        com.tencent.mm.sdk.b.a.xef.m(dhVar);
                        if (dhVar.frR.frp || g.R(this.yqa.getContext(), auVar.getType())) {
                            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                        }
                        e eVar = null;
                        if (auVar.field_msgId > 0) {
                            eVar = o.Pw().bi(auVar.field_msgId);
                        }
                        if (d.OQ("photoedit") && r1.status != -1) {
                            int width;
                            int height;
                            MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRk));
                            int[] iArr = new int[2];
                            if (view != null) {
                                width = view.getWidth();
                                height = view.getHeight();
                                view.getLocationInWindow(iArr);
                            } else {
                                height = 0;
                                width = 0;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                            add.setIntent(intent);
                        }
                    }
                }
                if (auVar.aNc()) {
                    contextMenu.add(i, 111, 0, this.yqa.getMMString(R.l.eEC));
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
                        if (fT == null) {
                            return;
                        }
                        if (fT.type == 5) {
                            contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                        }
                    } else {
                        return;
                    }
                }
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
                contextMenu.add(i, 122, 0, this.yqa.getMMString(R.l.dRK));
            }
        }
    }
}
