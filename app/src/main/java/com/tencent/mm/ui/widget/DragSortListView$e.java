package com.tencent.mm.ui.widget;

import android.os.Environment;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class DragSortListView$e {
    File iFl = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    StringBuilder mBuilder = new StringBuilder();
    int zsC = 0;
    int zsD = 0;
    boolean zsE = false;
    final /* synthetic */ DragSortListView zsq;

    public DragSortListView$e(DragSortListView dragSortListView) {
        this.zsq = dragSortListView;
        if (!this.iFl.exists()) {
            try {
                this.iFl.createNewFile();
                x.d("mobeta", "file created");
            } catch (IOException e) {
                x.w("mobeta", "Could not create dslv_state.txt");
                x.d("mobeta", e.getMessage());
            }
        }
    }

    public final void flush() {
        FileWriter fileWriter;
        Throwable th;
        if (this.zsE) {
            FileWriter fileWriter2 = null;
            boolean z = true;
            try {
                if (this.zsD == 0) {
                    z = false;
                }
                fileWriter = new FileWriter(this.iFl, z);
                try {
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    this.zsD++;
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileWriter2 = fileWriter;
                    th = th3;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
                throw th;
            }
        }
    }
}
