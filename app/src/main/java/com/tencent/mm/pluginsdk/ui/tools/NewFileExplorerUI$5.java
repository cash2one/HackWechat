package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.ui.base.i.a.a;

class NewFileExplorerUI$5 implements a {
    final /* synthetic */ NewFileExplorerUI vxQ;

    NewFileExplorerUI$5(NewFileExplorerUI newFileExplorerUI) {
        this.vxQ = newFileExplorerUI;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.setClass(this.vxQ.mController.xIM, NewFileExplorerUI.class);
        intent.putExtra("explorer_mode", 1);
        intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.vxQ).ccB());
        intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.vxQ).ccD());
        intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.vxQ).ccC());
        intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.vxQ));
        this.vxQ.startActivityForResult(intent, 0);
    }
}
