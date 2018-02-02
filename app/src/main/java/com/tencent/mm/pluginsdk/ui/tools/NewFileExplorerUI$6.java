package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class NewFileExplorerUI$6 implements a {
    final /* synthetic */ NewFileExplorerUI vxQ;

    NewFileExplorerUI$6(NewFileExplorerUI newFileExplorerUI) {
        this.vxQ = newFileExplorerUI;
    }

    public final void a(boolean z, String str, int i) {
        this.vxQ.aWs();
        if (z) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.vxQ).ccB());
            intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.vxQ).ccD());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.vxQ).ccC());
            intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.vxQ));
            intent.putExtra("with_text_content", str);
            this.vxQ.setResult(-1, intent);
            this.vxQ.finish();
        }
    }
}
