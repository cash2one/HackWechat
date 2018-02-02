package com.tencent.mm.pluginsdk.ui.tools;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FileExplorerUI$a extends BaseAdapter {
    String hTs;
    final /* synthetic */ FileExplorerUI vwI;
    private File vwL;
    private File vwM;
    private File[] vwN;

    private FileExplorerUI$a(FileExplorerUI fileExplorerUI) {
        this.vwI = fileExplorerUI;
    }

    public final void e(File file, File file2) {
        this.vwL = file;
        if (file2.getAbsolutePath().equalsIgnoreCase(this.hTs)) {
            this.vwL = null;
        }
        this.vwM = file2;
        if (this.vwM.canRead() && this.vwM.isDirectory()) {
            this.vwN = this.vwM.listFiles(new 1(this));
            if (this.vwN.length > 0) {
                File[] fileArr = this.vwN;
                if (fileArr != null && fileArr.length != 0) {
                    List<FileExplorerUI$b> arrayList = new ArrayList();
                    List<FileExplorerUI$b> arrayList2 = new ArrayList();
                    for (File file3 : fileArr) {
                        FileExplorerUI$b fileExplorerUI$b = new FileExplorerUI$b(this.vwI);
                        fileExplorerUI$b.file = file3;
                        fileExplorerUI$b.vwP = c.ol(file3.getName()).toUpperCase();
                        if (file3.isDirectory()) {
                            arrayList.add(fileExplorerUI$b);
                        } else {
                            arrayList2.add(fileExplorerUI$b);
                        }
                    }
                    Collections.sort(arrayList, new 2(this));
                    Collections.sort(arrayList2, new 3(this));
                    int i = 0;
                    for (FileExplorerUI$b fileExplorerUI$b2 : arrayList) {
                        fileArr[i] = fileExplorerUI$b2.file;
                        i++;
                    }
                    for (FileExplorerUI$b fileExplorerUI$b22 : arrayList2) {
                        fileArr[i] = fileExplorerUI$b22.file;
                        i++;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.vwN = new File[0];
    }

    public final int getCount() {
        int i = 0;
        if (this.vwN == null) {
            return 0;
        }
        int length = this.vwN.length;
        if (this.vwL != null) {
            i = 1;
        }
        return i + length;
    }

    public final Object getItem(int i) {
        if (this.vwL != null && i == 0) {
            return this.vwL;
        }
        x.d("FileExplorer", "pos:" + i + ", subFile length:" + this.vwN.length);
        File[] fileArr = this.vwN;
        if (this.vwL != null) {
            i--;
        }
        return fileArr[i];
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.vwI, R.i.dmR, null);
            FileExplorerUI.c cVar = new FileExplorerUI.c(this.vwI, (byte) 0);
            cVar.jCP = (ImageView) view.findViewById(R.h.chH);
            cVar.lgz = (TextView) view.findViewById(R.h.chN);
            cVar.vwQ = (TextView) view.findViewById(R.h.chQ);
            view.setTag(cVar);
        }
        FileExplorerUI.c cVar2 = (FileExplorerUI.c) view.getTag();
        File file = (File) getItem(i);
        if (file == this.vwL) {
            cVar2.lgz.setText(file.getName());
            cVar2.jCP.setImageResource(R.g.bER);
            cVar2.vwQ.setVisibility(0);
        } else {
            cVar2.jCP.setImageResource(FileExplorerUI.E(file));
            cVar2.lgz.setText(file.getName());
            cVar2.vwQ.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + bh.bx(file.length())));
        }
        return view;
    }
}
