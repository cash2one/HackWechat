package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

public class FileExplorerUI extends MMActivity {
    private TextView vwA;
    private TextView vwB;
    private View vwC;
    private View vwD;
    private String vwE;
    private String vwF;
    private File vwG;
    private File vwH;
    private int vwx = 0;
    private ListView vwy;
    private a vwz;

    static /* synthetic */ int E(File file) {
        return file.isDirectory() ? R.g.bES : SM(file.getName());
    }

    static /* synthetic */ void ccv() {
    }

    protected final int getLayoutId() {
        return R.i.dmQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (bh.ov(stringExtra)) {
            setMMTitle(R.l.eAD);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || a.a(this.vwz) == null) {
            if (this.vwH != null) {
                ar.Hg();
                c.CU().set(131074, this.vwH.getAbsolutePath());
            }
            if (this.vwG != null) {
                ar.Hg();
                c.CU().set(131073, this.vwG.getAbsolutePath());
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (1 == this.vwx) {
            this.vwH = a.a(this.vwz);
        } else if (this.vwx == 0) {
            this.vwG = a.a(this.vwz);
        }
        this.vwz.e(a.a(this.vwz).getParentFile(), a.a(this.vwz));
        this.vwz.notifyDataSetChanged();
        this.vwy.setSelection(0);
        return true;
    }

    protected final void initView() {
        File file;
        File externalStorageDirectory;
        t CU;
        File file2;
        TextView textView;
        boolean z;
        TextView textView2;
        boolean z2 = true;
        Object obj = null;
        this.vwy = (ListView) findViewById(R.h.cEV);
        this.vwA = (TextView) findViewById(R.h.cIy);
        this.vwC = findViewById(R.h.cIz);
        this.vwB = (TextView) findViewById(R.h.cJi);
        this.vwD = findViewById(R.h.cJj);
        setBackBtn(new 1(this));
        this.vwE = getString(R.l.eAB);
        this.vwF = getString(R.l.eAC);
        File rootDirectory = h.getRootDirectory();
        if (rootDirectory.canRead()) {
            file = rootDirectory;
        } else {
            rootDirectory = h.getDataDirectory();
            if (rootDirectory.canRead()) {
                this.vwE = rootDirectory.getName();
                file = rootDirectory;
            } else {
                file = null;
            }
        }
        ar.Hg();
        if (c.isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
        } else {
            rootDirectory = h.getDownloadCacheDirectory();
            if (rootDirectory.canRead()) {
                this.vwF = rootDirectory.getName();
                externalStorageDirectory = rootDirectory;
            } else {
                externalStorageDirectory = null;
            }
        }
        ar.Hg();
        String str = (String) c.CU().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file3 = new File(str);
            if (file3.exists()) {
                rootDirectory = file3;
                this.vwG = rootDirectory;
                ar.Hg();
                CU = c.CU();
                if (externalStorageDirectory != null) {
                    obj = externalStorageDirectory.getAbsolutePath();
                }
                str = (String) CU.get(131074, obj);
                if (!(str == null || externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().equals(str))) {
                    file2 = new File(str);
                    if (file2.exists()) {
                        rootDirectory = file2;
                        this.vwH = rootDirectory;
                        this.vwz = new a(this, (byte) 0);
                        if (externalStorageDirectory == null) {
                            Cz(1);
                            this.vwz.hTs = externalStorageDirectory.getPath();
                            this.vwz.e(this.vwH.getParentFile(), this.vwH);
                        } else if (file == null) {
                            Cz(0);
                            this.vwz.hTs = file.getPath();
                            this.vwz.e(this.vwG.getParentFile(), this.vwG);
                        } else {
                            x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                            return;
                        }
                        textView = this.vwA;
                        if (file == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textView.setEnabled(z);
                        textView2 = this.vwB;
                        if (externalStorageDirectory == null) {
                            z2 = false;
                        }
                        textView2.setEnabled(z2);
                        this.vwy.setAdapter(this.vwz);
                        this.vwz.notifyDataSetChanged();
                        this.vwy.setOnItemClickListener(new 2(this));
                        this.vwA.setOnClickListener(new 3(this, file));
                        this.vwB.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FileExplorerUI vwI;

                            public final void onClick(View view) {
                                this.vwI.Cz(1);
                                this.vwI.vwz.hTs = externalStorageDirectory.getPath();
                                this.vwI.vwz.e(this.vwI.vwH.getParentFile(), this.vwI.vwH);
                                this.vwI.vwz.notifyDataSetInvalidated();
                                this.vwI.vwz.notifyDataSetChanged();
                                this.vwI.vwy.setSelection(0);
                            }
                        });
                    }
                }
                rootDirectory = externalStorageDirectory;
                this.vwH = rootDirectory;
                this.vwz = new a(this, (byte) 0);
                if (externalStorageDirectory == null) {
                    Cz(1);
                    this.vwz.hTs = externalStorageDirectory.getPath();
                    this.vwz.e(this.vwH.getParentFile(), this.vwH);
                } else if (file == null) {
                    x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                    return;
                } else {
                    Cz(0);
                    this.vwz.hTs = file.getPath();
                    this.vwz.e(this.vwG.getParentFile(), this.vwG);
                }
                textView = this.vwA;
                if (file == null) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setEnabled(z);
                textView2 = this.vwB;
                if (externalStorageDirectory == null) {
                    z2 = false;
                }
                textView2.setEnabled(z2);
                this.vwy.setAdapter(this.vwz);
                this.vwz.notifyDataSetChanged();
                this.vwy.setOnItemClickListener(new 2(this));
                this.vwA.setOnClickListener(new 3(this, file));
                this.vwB.setOnClickListener(/* anonymous class already generated */);
            }
        }
        rootDirectory = file;
        this.vwG = rootDirectory;
        ar.Hg();
        CU = c.CU();
        if (externalStorageDirectory != null) {
            obj = externalStorageDirectory.getAbsolutePath();
        }
        str = (String) CU.get(131074, obj);
        file2 = new File(str);
        if (file2.exists()) {
            rootDirectory = file2;
            this.vwH = rootDirectory;
            this.vwz = new a(this, (byte) 0);
            if (externalStorageDirectory == null) {
                Cz(1);
                this.vwz.hTs = externalStorageDirectory.getPath();
                this.vwz.e(this.vwH.getParentFile(), this.vwH);
            } else if (file == null) {
                Cz(0);
                this.vwz.hTs = file.getPath();
                this.vwz.e(this.vwG.getParentFile(), this.vwG);
            } else {
                x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                return;
            }
            textView = this.vwA;
            if (file == null) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            textView2 = this.vwB;
            if (externalStorageDirectory == null) {
                z2 = false;
            }
            textView2.setEnabled(z2);
            this.vwy.setAdapter(this.vwz);
            this.vwz.notifyDataSetChanged();
            this.vwy.setOnItemClickListener(new 2(this));
            this.vwA.setOnClickListener(new 3(this, file));
            this.vwB.setOnClickListener(/* anonymous class already generated */);
        }
        rootDirectory = externalStorageDirectory;
        this.vwH = rootDirectory;
        this.vwz = new a(this, (byte) 0);
        if (externalStorageDirectory == null) {
            Cz(1);
            this.vwz.hTs = externalStorageDirectory.getPath();
            this.vwz.e(this.vwH.getParentFile(), this.vwH);
        } else if (file == null) {
            x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            return;
        } else {
            Cz(0);
            this.vwz.hTs = file.getPath();
            this.vwz.e(this.vwG.getParentFile(), this.vwG);
        }
        textView = this.vwA;
        if (file == null) {
            z = false;
        } else {
            z = true;
        }
        textView.setEnabled(z);
        textView2 = this.vwB;
        if (externalStorageDirectory == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.vwy.setAdapter(this.vwz);
        this.vwz.notifyDataSetChanged();
        this.vwy.setOnItemClickListener(new 2(this));
        this.vwA.setOnClickListener(new 3(this, file));
        this.vwB.setOnClickListener(/* anonymous class already generated */);
    }

    private void Cz(int i) {
        if (1 == i) {
            this.vwx = 1;
            this.vwB.setTextColor(getResources().getColor(R.e.bui));
            this.vwA.setTextColor(getResources().getColor(R.e.btv));
            this.vwC.setVisibility(4);
            this.vwD.setVisibility(0);
            return;
        }
        this.vwx = 0;
        this.vwA.setTextColor(getResources().getColor(R.e.bui));
        this.vwB.setTextColor(getResources().getColor(R.e.btv));
        this.vwC.setVisibility(0);
        this.vwD.setVisibility(4);
    }

    public static int SM(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bh.ou(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.dvE;
        }
        if (SN(toLowerCase)) {
            return R.g.bET;
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
            obj = 1;
        }
        if (obj != null) {
            return R.k.dvh;
        }
        return R.k.dvx;
    }

    public static boolean SN(String str) {
        String toLowerCase = bh.ou(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    public static boolean SO(String str) {
        String toLowerCase = bh.ou(str).toLowerCase();
        return toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
