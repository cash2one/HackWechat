package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class OpenFileChooserUI$4 implements Runnable {
    final /* synthetic */ int jqP;
    final /* synthetic */ Intent kvq;
    final /* synthetic */ OpenFileChooserUI twU;

    OpenFileChooserUI$4(OpenFileChooserUI openFileChooserUI, Intent intent, int i) {
        this.twU = openFileChooserUI;
        this.kvq = intent;
        this.jqP = i;
    }

    public final void run() {
        List<String> stringArrayListExtra = this.kvq.getStringArrayListExtra("CropImage_OutputPath_List");
        boolean booleanExtra = this.kvq.getBooleanExtra("isTakePhoto", false);
        boolean booleanExtra2 = this.kvq.getBooleanExtra("CropImage_Compress_Img", true);
        ArrayList arrayList = new ArrayList();
        for (String Ol : stringArrayListExtra) {
            WebViewJSSDKFileItem Ol2 = WebViewJSSDKFileItem.Ol(Ol);
            String str = Ol2.fus;
            Ol2.iLy = booleanExtra2;
            f.bRB().b(Ol2);
            x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[]{Ol, str});
            arrayList.add(str);
        }
        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{ai.X(arrayList)});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_callback_local_ids", Ol);
        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(this.twU));
        this.twU.setResult(this.jqP, intent);
        this.twU.finish();
    }
}
