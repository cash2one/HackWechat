package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.plugin.sns.ui.bb.5;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

class bb$5$1 implements OnDragListener {
    final /* synthetic */ 5 rLn;

    bb$5$1(5 5) {
        this.rLn = 5;
    }

    public final boolean onDrag(View view, DragEvent dragEvent) {
        int i = 0;
        switch (dragEvent.getAction()) {
            case 1:
            case 2:
            case 4:
            case 5:
                x.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                return true;
            case 3:
                x.i("MicroMsg.SnsActivity", "ACTION_DROP");
                ClipData clipData = dragEvent.getClipData();
                if (clipData == null) {
                    return true;
                }
                int itemCount = clipData.getItemCount();
                ArrayList arrayList = new ArrayList();
                while (i < itemCount) {
                    Item itemAt = clipData.getItemAt(i);
                    if (itemAt == null) {
                        x.e("MicroMsg.SnsActivity", "item == null");
                    } else if (itemAt.getIntent() != null) {
                        bb.a(this.rLn.rLm).startActivity(itemAt.getIntent());
                    } else if (itemAt.getUri() != null) {
                        l lVar = new l(bb.a(this.rLn.rLm), itemAt.getUri());
                        if (lVar.fileType != 0 && lVar.filePath != null) {
                            switch (lVar.fileType) {
                                case 3:
                                    arrayList.add(lVar.filePath);
                                    break;
                                default:
                                    break;
                            }
                        }
                        x.e("MicroMsg.SnsActivity", "get file path failed");
                    }
                    i++;
                }
                if (arrayList.size() < 0) {
                    x.e("MicroMsg.SnsActivity", "no image file available");
                    return true;
                }
                Intent intent = new Intent(bb.a(this.rLn.rLm), SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bh.Wo());
                intent.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
                intent.setAction("android.intent.action.SEND");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("android.intent.extra.TEXT", "");
                intent.putExtra("Ksnsupload_empty_img", true);
                if (bb.b(this.rLn.rLm)) {
                    intent.putExtra("Ksnsupload_source", 11);
                }
                intent.setType("image/*");
                bb.a(this.rLn.rLm).startActivity(intent);
                return true;
            default:
                x.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                return false;
        }
    }
}
