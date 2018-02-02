package com.tencent.mm.ui.chatting.b;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.k.1;
import com.tencent.mm.z.q;

class k$1$1 implements OnDragListener {
    final /* synthetic */ 1 yzV;

    k$1$1(1 1) {
        this.yzV = 1;
    }

    public final boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_STARTED");
                return true;
            case 2:
                x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_LOCATION");
                return true;
            case 3:
                x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DROP");
                ClipData clipData = dragEvent.getClipData();
                if (clipData == null) {
                    return true;
                }
                int itemCount = clipData.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    Item itemAt = clipData.getItemAt(i);
                    if (itemAt == null) {
                        x.e("MicroMsg.ChattingUI.DragDropMgr", "item == null");
                    } else if (itemAt.getIntent() != null) {
                        this.yzV.yzU.fhr.csq().startActivity(itemAt.getIntent());
                    } else if (itemAt.getUri() != null) {
                        l lVar = new l(this.yzV.yzU.fhr.csq().getContext(), itemAt.getUri());
                        if (lVar.fileType != 0 && lVar.filePath != null) {
                            switch (lVar.fileType) {
                                case 3:
                                    String str = lVar.filePath;
                                    this.yzV.yzU.yvT.u(q.a(str, this.yzV.yzU.fhr.crz(), true) ? 1 : 0, 0, str);
                                    break;
                                case 4:
                                    Intent intent = new Intent();
                                    intent.setData(itemAt.getUri());
                                    this.yzV.yzU.yvS.al(intent);
                                    break;
                                default:
                                    this.yzV.yzU.ywa.a(lVar);
                                    break;
                            }
                        }
                        x.e("MicroMsg.ChattingUI.DragDropMgr", "get file path failed");
                    } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                        this.yzV.yzU.ywb.dm(itemAt.getText().toString(), 0);
                    }
                }
                return true;
            case 4:
                x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_ENDED");
                return true;
            case 5:
                x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_ENTERED");
                return true;
            default:
                x.e("MicroMsg.ChattingUI.DragDropMgr", "Unknown action type received by OnDragListener.");
                return false;
        }
    }
}
