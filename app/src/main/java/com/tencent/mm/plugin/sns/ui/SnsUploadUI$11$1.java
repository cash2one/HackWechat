package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI.11;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class SnsUploadUI$11$1 implements OnDragListener {
    final /* synthetic */ 11 rLV;

    SnsUploadUI$11$1(11 11) {
        this.rLV = 11;
    }

    public final boolean onDrag(View view, DragEvent dragEvent) {
        boolean z;
        switch (dragEvent.getAction()) {
            case 1:
            case 2:
            case 4:
            case 5:
                x.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                z = true;
                break;
            case 3:
                x.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                ClipData clipData = dragEvent.getClipData();
                if (clipData == null) {
                    z = true;
                    break;
                }
                int itemCount = clipData.getItemCount();
                List arrayList = new ArrayList();
                for (int i = 0; i < itemCount; i++) {
                    Item itemAt = clipData.getItemAt(i);
                    if (itemAt == null) {
                        x.e("MicroMsg.SnsUploadUI", "item == null");
                    } else if (itemAt.getIntent() != null) {
                        this.rLV.rLR.startActivity(itemAt.getIntent());
                    } else if (itemAt.getUri() != null) {
                        l lVar = new l(this.rLV.rLR.mController.xIM, itemAt.getUri());
                        if (lVar.fileType != 0 && lVar.filePath != null) {
                            switch (lVar.fileType) {
                                case 3:
                                    arrayList.add(lVar.filePath);
                                    break;
                                default:
                                    break;
                            }
                        }
                        x.e("MicroMsg.SnsUploadUI", "get file path failed");
                    }
                }
                if (arrayList.size() >= 0) {
                    ((ah) SnsUploadUI.f(this.rLV.rLR)).c(arrayList, 0, false);
                    z = true;
                    break;
                }
                x.e("MicroMsg.SnsUploadUI", "no image file available");
                return true;
                break;
            default:
                x.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                z = false;
                break;
        }
        return z;
    }
}
