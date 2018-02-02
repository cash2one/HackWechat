package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import java.util.List;

class VideoSegmentUI$8 implements Runnable {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$8(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void run() {
        List<FileEntry> F = FileOp.F(CaptureMMProxy.getInstance().getAccVideoPath(), false);
        if (F != null && F.size() != 0) {
            for (FileEntry fileEntry : F) {
                if (fileEntry.name != null && ((fileEntry.name.contains("vsg_output_") && !fileEntry.name.contains(VideoSegmentUI.g(this.ozX))) || (fileEntry.name.contains("vsg_thumb_") && !fileEntry.name.contains(VideoSegmentUI.l(this.ozX))))) {
                    b.deleteFile(fileEntry.name);
                }
            }
        }
    }
}
