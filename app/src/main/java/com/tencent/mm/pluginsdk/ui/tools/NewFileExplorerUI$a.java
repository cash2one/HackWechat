package com.tencent.mm.pluginsdk.ui.tools;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class NewFileExplorerUI$a extends BaseAdapter {
    private File vwM;
    File[] vwN = new File[0];
    final /* synthetic */ NewFileExplorerUI vxQ;
    private File vxR;
    private boolean vxS = false;
    private ArrayList<File> vxT = new ArrayList();

    private class a {
        File file;
        long time;
        final /* synthetic */ NewFileExplorerUI$a vxU;
        String vxV;

        private a(NewFileExplorerUI$a newFileExplorerUI$a) {
            this.vxU = newFileExplorerUI$a;
        }
    }

    public NewFileExplorerUI$a(NewFileExplorerUI newFileExplorerUI) {
        this.vxQ = newFileExplorerUI;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.vwN[i];
    }

    public final void c(File file, boolean z) {
        this.vxR = file;
        this.vxS = z;
    }

    public final void a(File file, List<String> list) {
        this.vwM = file;
        int i;
        if (this.vwM != null && this.vwM.canRead() && this.vwM.isDirectory()) {
            this.vwN = this.vwM.listFiles(new FileFilter(this) {
                final /* synthetic */ NewFileExplorerUI$a vxU;

                {
                    this.vxU = r1;
                }

                public final boolean accept(File file) {
                    if (file.isHidden()) {
                        return false;
                    }
                    if (this.vxU.vxS && file.isDirectory()) {
                        return false;
                    }
                    return true;
                }
            });
            if (this.vwN == null) {
                this.vwN = new File[0];
            }
            if (this.vwN.length > 0) {
                File[] fileArr = this.vwN;
                if (fileArr != null && fileArr.length != 0) {
                    List<a> arrayList = new ArrayList();
                    List<a> arrayList2 = new ArrayList();
                    for (File file2 : fileArr) {
                        a aVar = new a();
                        aVar.file = file2;
                        aVar.time = file2.lastModified();
                        if (file2.isDirectory()) {
                            aVar.vxV = c.ol(file2.getName()).toUpperCase();
                            arrayList.add(aVar);
                        } else {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList, new 2(this));
                    Collections.sort(arrayList2, new Comparator<a>(this) {
                        final /* synthetic */ NewFileExplorerUI$a vxU;

                        {
                            this.vxU = r1;
                        }

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            a aVar = (a) obj;
                            a aVar2 = (a) obj2;
                            if (aVar.time == aVar2.time) {
                                return 0;
                            }
                            return aVar.time > aVar2.time ? -1 : 1;
                        }
                    });
                    i = 0;
                    for (a aVar2 : arrayList) {
                        fileArr[i] = aVar2.file;
                        i++;
                    }
                    for (a aVar22 : arrayList2) {
                        fileArr[i] = aVar22.file;
                        i++;
                    }
                }
            }
        } else if (list != null) {
            this.vwN = new File[list.size()];
            for (i = 0; i < list.size(); i++) {
                this.vwN[i] = new File((String) list.get(i));
                this.vxT.add(this.vwN[i]);
            }
        }
    }

    public final int bkT() {
        Iterator it = this.vxT.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((File) it.next()).length() + ((long) i));
        }
        return i;
    }

    public final ArrayList<String> ccB() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.vxT.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!(SN(file.getName()) || aa(file.getName()))) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final ArrayList<String> ccC() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.vxT.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (SN(file.getName())) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final ArrayList<String> ccD() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.vxT.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (aa(file.getName())) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final File ccE() {
        if (this.vwM.hashCode() == this.vxR.hashCode()) {
            return null;
        }
        return this.vwM.getParentFile();
    }

    public final int getCount() {
        return this.vwN.length;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Bitmap bitmap = null;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.i.dim, null);
            b bVar = new b(this, (byte) 0);
            bVar.vxW = (FrameLayout) view.findViewById(R.h.crL);
            bVar.vxX = (CheckBox) bVar.vxW.findViewById(R.h.crK);
            bVar.jCP = (ImageView) view.findViewById(R.h.cry);
            bVar.iiq = (TextView) view.findViewById(R.h.crT);
            bVar.prT = (TextView) view.findViewById(R.h.crN);
            bVar.ldK = (TextView) view.findViewById(R.h.crR);
            bVar.vxW.setOnClickListener(new 4(this));
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        File file = this.vwN[i];
        bVar2.iiq.setText(file.getName());
        if (file.isDirectory()) {
            bVar2.jCP.setImageResource(R.k.dvk);
            bVar2.vxW.setVisibility(4);
            bVar2.prT.setVisibility(0);
            bVar2.ldK.setVisibility(8);
            String[] list = file.list(new FilenameFilter(this) {
                final /* synthetic */ NewFileExplorerUI$a vxU;

                {
                    this.vxU = r1;
                }

                public final boolean accept(File file, String str) {
                    if (str.startsWith(".")) {
                        return false;
                    }
                    return true;
                }
            });
            int length = list != null ? list.length : 0;
            bVar2.prT.setText(this.vxQ.getString(R.l.ehg, new Object[]{Integer.valueOf(length)}));
        } else {
            bVar2.vxW.setVisibility(0);
            bVar2.prT.setVisibility(0);
            bVar2.ldK.setVisibility(0);
            bVar2.prT.setText(bh.bx(file.length()));
            bVar2.ldK.setText(n.c(this.vxQ, file.lastModified(), true));
            if (SN(file.getName())) {
                String path = file.getPath();
                Cursor query = this.vxQ.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{path}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(query.getColumnIndex("_id"));
                        query.close();
                        bitmap = Thumbnails.getThumbnail(this.vxQ.getContentResolver(), (long) i2, 3, null);
                    } else {
                        query.close();
                    }
                }
                if (bitmap != null) {
                    bVar2.jCP.setImageBitmap(bitmap);
                } else {
                    bVar2.jCP.setImageResource(SM(file.getName()));
                }
            } else {
                bVar2.jCP.setImageResource(SM(file.getName()));
            }
        }
        bVar2.vxX.setChecked(this.vxT.contains(file));
        bVar2.vxW.setTag(Integer.valueOf(i));
        return view;
    }

    private static int SM(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.dvE;
        }
        if (SN(toLowerCase)) {
            return R.g.byV;
        }
        toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvv;
        }
        toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvw;
        }
        if (bh.ou(toLowerCase).toLowerCase().endsWith(".pdf")) {
            return R.k.dvr;
        }
        toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvt;
        }
        toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvh;
        }
        toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".mp3") || toLowerCase2.endsWith(".wma")) {
            obj = 1;
        }
        if (obj != null) {
            return R.k.dvn;
        }
        if (aa(toLowerCase)) {
            return R.k.dvA;
        }
        if (bh.ou(toLowerCase).toLowerCase().endsWith(".html")) {
            return R.k.dvD;
        }
        if (bh.ou(toLowerCase).toLowerCase().endsWith(".key")) {
            return R.k.dvl;
        }
        if (bh.ou(toLowerCase).toLowerCase().endsWith(".number")) {
            return R.k.dvp;
        }
        if (bh.ou(toLowerCase).toLowerCase().endsWith(".pages")) {
            return R.k.dvq;
        }
        return R.k.dvx;
    }

    private static boolean SN(String str) {
        String toLowerCase = bh.ou(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    static boolean aa(String str) {
        String toLowerCase = bh.ou(str).toLowerCase();
        return toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
