package com.tencent.mm.plugin.nearlife.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String oRi = (w.gZK + "poi_categories");
    private ListView Fv;
    private OnMenuItemClickListener oRd = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectPoiCategoryUI oRn;

        {
            this.oRn = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.oRn.setResult(0, null);
            this.oRn.finish();
            return true;
        }
    };
    private a oRj;
    private ArrayAdapter<String> oRk;
    private List<String> oRl;
    private OnItemClickListener oRm = new 1(this);

    protected final int getLayoutId() {
        return R.i.drI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oRl = new ArrayList();
        initView();
        this.oRj = new a(this);
        a.xef.b(this.oRj);
        this.oRj.oRo = this;
        ar.CG().a(new k(17), 0);
    }

    protected final void initView() {
        setMMTitle(R.l.exZ);
        setBackBtn(this.oRd);
        this.oRk = new ArrayAdapter(this, R.i.dpk);
        this.Fv = (ListView) findViewById(R.h.bSx);
        this.Fv.setAdapter(this.oRk);
        this.Fv.setOnItemClickListener(this.oRm);
        if (!GD(oRi + "/lastest_poi_categories.dat")) {
            try {
                o(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                x.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        bfk();
    }

    private boolean o(InputStream inputStream) {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        if (inputStream == null) {
            return false;
        }
        this.oRl.clear();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.oRl.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            try {
                x.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e22) {
                        x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                    }
                }
                inputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                        throw th;
                    }
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            throw th;
        }
        return true;
    }

    private boolean GD(String str) {
        boolean z = false;
        if (!bh.ov(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    z = o(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    x.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[]{str, e.getMessage()});
                }
            }
        }
        return z;
    }

    protected void onDestroy() {
        super.onDestroy();
        a.xef.c(this.oRj);
    }

    final void aC(byte[] bArr) {
        String[] split = new String(bArr).split("\n");
        this.oRl.clear();
        for (String trim : split) {
            this.oRl.add(trim.trim());
        }
    }

    final void bfk() {
        this.oRk.clear();
        for (int i = 0; i < this.oRl.size(); i++) {
            this.oRk.add(this.oRl.get(i));
        }
        this.oRk.notifyDataSetChanged();
    }
}
