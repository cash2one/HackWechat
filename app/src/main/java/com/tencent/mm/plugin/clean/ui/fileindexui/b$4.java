package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$4 implements OnItemClickListener {
    final /* synthetic */ b lgr;

    b$4(b bVar) {
        this.lgr = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
        i ol = this.lgr.ol(i);
        Intent intent = new Intent();
        switch (ol.type) {
            case 1:
                intent.putExtra("key_title", b.e(this.lgr).getString(R.l.dTF));
                intent.putExtra("show_menu", false);
                intent.putExtra("key_image_path", FileOp.bO(ol.filePath) ? ol.filePath : ol.fvC);
                d.a(b.e(this.lgr), ".ui.tools.ShowImageUI", intent);
                return;
            case 3:
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(ol.filePath)), "video/*");
                try {
                    b.e(this.lgr).startActivity(Intent.createChooser(intent, b.e(this.lgr).getString(R.l.eTt)));
                    return;
                } catch (Exception e) {
                    return;
                }
            case 4:
                intent.putExtra("app_msg_id", ol.fpG);
                d.a(b.e(this.lgr), ".ui.chatting.AppAttachDownloadUI", intent);
                return;
            default:
                return;
        }
    }
}
