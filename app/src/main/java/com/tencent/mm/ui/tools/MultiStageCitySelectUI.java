package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI extends MMPreference implements e {
    private static List<Region> zlW;
    private String countryCode = null;
    private int fBs = 0;
    private a gyF = new 1(this);
    private String hEx = null;
    private af handler = new af(Looper.getMainLooper());
    private String hhw = null;
    private String hhx = null;
    private c hpO;
    private f ilB;
    private p lcZ = new p(true, true);
    private String zlL = null;
    private String zlM = null;
    private boolean zlN = false;
    private int zlO = -1;
    private Region[] zlP;
    private boolean zlQ = false;
    private boolean zlR = true;
    private boolean zlS = true;
    private boolean zlT = false;
    private boolean zlU = false;
    private ZoneRecommandPreference zlV;
    private String zlX;
    private Runnable zlY = new 4(this);

    static /* synthetic */ void g(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (multiStageCitySelectUI.zlN) {
            multiStageCitySelectUI.fBs = 3;
        } else if (multiStageCitySelectUI.countryCode == null) {
            multiStageCitySelectUI.fBs = 0;
        } else if (multiStageCitySelectUI.hhx == null) {
            multiStageCitySelectUI.fBs = 1;
        } else {
            multiStageCitySelectUI.fBs = 2;
        }
    }

    static /* synthetic */ void k(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (!bh.ov(multiStageCitySelectUI.zlX)) {
            Preference preferenceTitleCategory;
            ArrayList arrayList = new ArrayList();
            List<Region> arrayList2 = new ArrayList();
            List<Region> arrayList3 = new ArrayList();
            List<Region> arrayList4 = new ArrayList();
            for (Region region : zlW) {
                if (region.getName() != null && region.getName().contains(multiStageCitySelectUI.zlX)) {
                    if ("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()) || ((region.getParent() == null || !region.hasChildren()) && (region.getParent() == null || region.hasChildren()))) {
                        if (region.getParent() == null || !("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()))) {
                            if (!(region.getParent() == null && ("HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode())))) {
                                arrayList2.add(region);
                            }
                        } else if (region.hasChildren() && region.getParent() != null) {
                            arrayList3.add(region);
                        } else if (!(region.hasChildren() || region.getParent() == null)) {
                            arrayList4.add(region);
                        }
                    }
                }
            }
            if (arrayList4.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eKJ);
                multiStageCitySelectUI.ilB.a(preferenceTitleCategory);
                for (Region region2 : arrayList4) {
                    Preference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.a(region2);
                    multiStageCitySelectUI.ilB.b(zonePreference);
                }
            }
            if (arrayList3.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eKL);
                multiStageCitySelectUI.ilB.a(preferenceTitleCategory);
                for (Region region22 : arrayList3) {
                    Preference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.a(region22);
                    multiStageCitySelectUI.ilB.b(zonePreference2);
                }
            }
            if (arrayList2.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eKK);
                multiStageCitySelectUI.ilB.a(preferenceTitleCategory);
                for (Region region222 : arrayList2) {
                    Preference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.a(region222);
                    multiStageCitySelectUI.ilB.b(zonePreference3);
                }
            }
            multiStageCitySelectUI.ilB.notifyDataSetChanged();
            multiStageCitySelectUI.zlO = multiStageCitySelectUI.fBs;
            multiStageCitySelectUI.fBs = 4;
        }
    }

    public final void cxR() {
        Region[] XG;
        int i;
        if (this.fBs == 3) {
            XG = RegionCodeDecoder.cjP().XG("CN");
        } else if (bh.ov(this.countryCode)) {
            XG = RegionCodeDecoder.cjP().cjR();
            if (this.zlT) {
                List arrayList = new ArrayList();
                if (XG != null) {
                    for (Region region : XG) {
                        if (!("CN".equalsIgnoreCase(region.getCode()) || "HK".equalsIgnoreCase(region.getCode()) || "TW".equalsIgnoreCase(region.getCode()) || "MO".equalsIgnoreCase(region.getCode()))) {
                            arrayList.add(region);
                        }
                    }
                }
                XG = new Region[arrayList.size()];
                arrayList.toArray(XG);
            }
        } else {
            XG = bh.ov(this.hhx) ? RegionCodeDecoder.cjP().XG(this.countryCode) : RegionCodeDecoder.cjP().fF(this.countryCode, this.hhx);
        }
        this.zlP = XG;
        if (this.zlP == null || this.zlP.length <= 0) {
            x.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            return;
        }
        this.ilB.removeAll();
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(12324, null);
        ar.Hg();
        String str2 = (String) com.tencent.mm.z.c.CU().get(12325, null);
        ar.Hg();
        String str3 = (String) com.tencent.mm.z.c.CU().get(12326, null);
        this.zlS = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        i = 0;
        while (i < this.zlP.length) {
            if (!(this.zlP[i] == null || bh.ov(this.zlP[i].getCode()) || bh.ov(this.zlP[i].getName()))) {
                Preference zonePreference = new ZonePreference(this);
                zonePreference.a(this.zlP[i]);
                if (!this.zlS) {
                    this.ilB.a(zonePreference);
                } else if (this.fBs == 0 && this.zlP[i].getCode().equalsIgnoreCase(str)) {
                    this.ilB.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eKM);
                } else if (this.fBs == 1 && this.zlP[i].getCode().equalsIgnoreCase(str2)) {
                    this.ilB.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eKM);
                } else if (this.fBs == 2 && this.zlP[i].getCode().equalsIgnoreCase(str3)) {
                    this.ilB.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eKM);
                } else {
                    this.ilB.a(zonePreference);
                }
            }
            i++;
        }
        if (this.fBs == 3) {
            Preference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(R.l.eKI);
            zoneSelectOtherCountryPreference.znG = new 2(this);
            this.ilB.a(zoneSelectOtherCountryPreference);
        }
        this.ilB.a(new PreferenceCategory(this.mController.xIM));
        if (this.fBs == 0 || this.fBs == 3) {
            if (this.zlR) {
                zoneSelectOtherCountryPreference = new PreferenceTitleCategory(this);
                zoneSelectOtherCountryPreference.setTitle(R.l.eKG);
                this.ilB.a(zoneSelectOtherCountryPreference, 0);
                this.zlV = new ZoneRecommandPreference(this);
                this.zlV.setKey("current_location");
                this.ilB.a(this.zlV, 1);
                x.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    cxS();
                }
            }
            zoneSelectOtherCountryPreference = new PreferenceTitleCategory(this);
            zoneSelectOtherCountryPreference.setTitle(R.l.eKF);
            if (this.zlR) {
                this.ilB.a(zoneSelectOtherCountryPreference, 2);
            } else {
                this.ilB.a(zoneSelectOtherCountryPreference, 0);
            }
        }
    }

    private void cxS() {
        if (this.hpO == null) {
            this.hpO = c.OP();
        }
        this.hpO.a(this.gyF, true);
    }

    private void cxT() {
        switch (this.fBs) {
            case 0:
                this.countryCode = null;
                return;
            case 1:
                this.hhx = null;
                return;
            case 2:
                this.hhw = null;
                return;
            default:
                return;
        }
    }

    private static List<Region> cxU() {
        String str;
        InputStream openRead;
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        InputStream inputStream;
        Reader reader2 = null;
        RegionCodeDecoder cjP = RegionCodeDecoder.cjP();
        cjP.xzS = w.cfi();
        String cjQ = cjP.cjQ();
        if (bh.ov(cjQ)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + cjP.xzS);
            str = null;
        } else {
            str = RegionCodeDecoder.xzR + cjQ;
        }
        if (bh.ov(str)) {
            return null;
        }
        List<Region> arrayList = new ArrayList();
        try {
            openRead = FileOp.openRead(str);
            try {
                inputStreamReader = new InputStreamReader(openRead);
            } catch (Exception e2) {
                e = e2;
                reader = null;
                inputStream = openRead;
                try {
                    x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                    if (inputStream != null) {
                        com.tencent.mm.a.e.c(inputStream);
                    }
                    if (reader != null) {
                        com.tencent.mm.a.e.a(reader);
                    }
                    if (reader2 != null) {
                        com.tencent.mm.a.e.a(reader2);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    e = th;
                    openRead = inputStream;
                    inputStreamReader = reader;
                    reader = reader2;
                    if (openRead != null) {
                        com.tencent.mm.a.e.c(openRead);
                    }
                    if (inputStreamReader != null) {
                        com.tencent.mm.a.e.a(inputStreamReader);
                    }
                    if (reader != null) {
                        com.tencent.mm.a.e.a(reader);
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                reader = null;
                inputStreamReader = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.c(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader != null) {
                    com.tencent.mm.a.e.a(reader);
                }
                throw e;
            }
            try {
                reader = new BufferedReader(inputStreamReader);
                Region region = null;
                while (true) {
                    try {
                        String readLine = reader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("\\|");
                        Region region2 = new Region();
                        if (split.length == 2) {
                            region2.setName(split[1]);
                            split = split[0].split("_");
                            String str2 = split[0];
                            region2.setCountryCode(str2);
                            if (bh.ov(str2)) {
                                continue;
                            } else {
                                if (split.length == 1) {
                                    region2.setCode(str2);
                                    region2.setProvince(false);
                                    region2.setCity(false);
                                    region2.setCountry(true);
                                    region = region2;
                                } else if (split.length == 2) {
                                    region2.setCode(split[1]);
                                    region2.setProvince(true);
                                    region2.setCountry(false);
                                    region2.setCity(false);
                                    if (region != null && region.getCountryCode().equals(region2.getCountryCode())) {
                                        region.setHasChildren(true);
                                        region2.setParent(region);
                                    }
                                    r1 = region2;
                                } else if (split.length == 3) {
                                    region2.setCode(split[2]);
                                    region2.setCity(true);
                                    region2.setCountry(false);
                                    region2.setProvince(false);
                                    region2.setHasChildren(false);
                                    if (r1 != null && r1.getCode().equals(split[1])) {
                                        region2.setParent(r1);
                                        r1.setHasChildren(true);
                                    }
                                }
                                arrayList.add(region2);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        reader2 = reader;
                        reader = inputStreamReader;
                        inputStream = openRead;
                    } catch (Throwable th3) {
                        e = th3;
                    }
                }
                if (openRead != null) {
                    com.tencent.mm.a.e.c(openRead);
                }
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
            } catch (Exception e4) {
                e = e4;
                reader = inputStreamReader;
                inputStream = openRead;
                x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
                if (reader != null) {
                    com.tencent.mm.a.e.a(reader);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                return arrayList;
            } catch (Throwable th4) {
                e = th4;
                reader = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.c(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader != null) {
                    com.tencent.mm.a.e.a(reader);
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            reader = null;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
            if (inputStream != null) {
                com.tencent.mm.a.e.c(inputStream);
            }
            if (reader != null) {
                com.tencent.mm.a.e.a(reader);
            }
            if (reader2 != null) {
                com.tencent.mm.a.e.a(reader2);
            }
            return arrayList;
        } catch (Throwable th5) {
            e = th5;
            reader = null;
            inputStreamReader = null;
            openRead = null;
            if (openRead != null) {
                com.tencent.mm.a.e.c(openRead);
            }
            if (inputStreamReader != null) {
                com.tencent.mm.a.e.a(inputStreamReader);
            }
            if (reader != null) {
                com.tencent.mm.a.e.a(reader);
            }
            throw e;
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(665, this);
        this.ilB = this.yjd;
        initView();
        if (this.zlU) {
            if (zlW == null || zlW.size() <= 0) {
                long Wq = bh.Wq();
                Region[] cjR = RegionCodeDecoder.cjP().cjR();
                if (cjR != null && cjR.length > 0 && (zlW == null || zlW.size() <= 0)) {
                    List cxU = cxU();
                    zlW = cxU;
                    if (cxU != null) {
                        x.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(zlW.size())});
                    }
                }
            }
            a(this.lcZ);
            this.lcZ.zms = new 3(this);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ar.CG().b(665, this);
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
        super.onDestroy();
    }

    public final int XB() {
        return R.i.dul;
    }

    protected final void initView() {
        setMMTitle(R.l.ewX);
        setBackBtn(new 5(this));
        this.zlQ = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.hhx = getIntent().getStringExtra("Provice");
        this.hEx = getIntent().getStringExtra("CountryName");
        this.zlL = getIntent().getStringExtra("ProviceName");
        this.zlR = getIntent().getBooleanExtra("IsAutoPosition", !bh.PT());
        this.zlN = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.zlT = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.zlU = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        x.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.hhx + " city = " + this.hhw + " " + this.hEx + " " + this.zlL + " " + this.zlN + " " + this.zlT);
        if (this.zlN) {
            this.fBs = 3;
        } else if (this.countryCode == null) {
            this.fBs = 0;
            this.hhx = null;
            this.hhw = null;
        } else if (this.hhx == null) {
            this.fBs = 1;
            this.hhw = null;
        } else {
            this.fBs = 2;
        }
        cxR();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = null;
        String str2;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).zny;
            if (region == null || bh.ov(region.getCode())) {
                Object valueOf;
                str = "MicroMsg.MultiStageCitySelectUI";
                StringBuilder stringBuilder = new StringBuilder("onPreferenceTreeClick error item, code:");
                if (region == null) {
                    valueOf = Integer.valueOf(-1);
                } else {
                    valueOf = region.getCode();
                }
                stringBuilder = stringBuilder.append(valueOf).append(" ,name:");
                if (region == null) {
                    str2 = "null";
                } else {
                    str2 = region.getName();
                }
                x.e(str, stringBuilder.append(str2).toString());
                return false;
            }
            if (this.fBs == 3) {
                this.countryCode = "CN";
                this.hhx = region.getCode();
                this.zlL = region.getName();
            }
            if (this.fBs == 0) {
                this.countryCode = region.getCode();
                this.hEx = region.getName();
            } else if (this.fBs == 1) {
                this.hhx = region.getCode();
                this.zlL = region.getName();
            } else if (this.fBs == 2) {
                this.hhw = region.getCode();
                this.zlM = region.getName();
                if ("CN".equalsIgnoreCase(this.countryCode) || "HK".equalsIgnoreCase(this.countryCode) || "MO".equalsIgnoreCase(this.countryCode) || "TW".equalsIgnoreCase(this.countryCode)) {
                    this.hEx = null;
                } else {
                    this.zlL = null;
                }
            } else if (this.fBs == 4) {
                if (region.getParent() != null && !region.hasChildren()) {
                    this.hhw = region.getCode();
                    this.zlM = region.getName();
                    this.hhx = region.getParent().getCode();
                    this.zlL = region.getParent().getName();
                    this.countryCode = region.getCountryCode();
                    this.hEx = null;
                } else if (!region.hasChildren() || region.getParent() == null) {
                    this.countryCode = region.getCode();
                    this.hEx = region.getName();
                    this.hhx = null;
                    this.zlL = null;
                    this.hhw = null;
                    this.zlM = null;
                } else {
                    this.hhx = region.getCode();
                    this.zlL = region.getName();
                    this.countryCode = region.getCountryCode();
                    this.hEx = null;
                }
            }
            if (region.hasChildren()) {
                Intent intent = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.countryCode);
                bundle.putString("Provice", this.hhx);
                bundle.putString("CountryName", this.hEx);
                bundle.putString("ProviceName", this.zlL);
                bundle.putBoolean("GetAddress", this.zlQ);
                bundle.putBoolean("ShowSelectedLocation", this.zlS);
                if (this.zlN) {
                    str2 = region.getCountryCode();
                    if (bh.ov(str2)) {
                        str2 = this.countryCode;
                    }
                    if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                        bundle.putBoolean("IsNeedShowSearchBar", true);
                    }
                }
                intent.putExtras(bundle);
                aWs();
                startActivityForResult(intent, 1);
            } else {
                if (!this.zlQ) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(12324, this.countryCode);
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(12325, this.hhx);
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(12326, this.hhw);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CountryName", this.hEx);
                intent2.putExtra("ProviceName", this.zlL);
                intent2.putExtra("CityName", this.zlM);
                intent2.putExtra("Country", this.countryCode);
                intent2.putExtra("Contact_Province", this.hhx);
                intent2.putExtra("Contact_City", this.hhw);
                aWs();
                setResult(-1, intent2);
                finish();
            }
            return true;
        }
        if (preference.ibD.equals("current_location")) {
            if (this.zlV.status == 1) {
                ZoneRecommandPreference zoneRecommandPreference = this.zlV;
                Region[] regionArr = new Region[]{zoneRecommandPreference.znB, zoneRecommandPreference.znC, zoneRecommandPreference.znD};
                ar.Hg();
                com.tencent.mm.z.c.CU().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                ar.Hg();
                com.tencent.mm.z.c.CU().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                ar.Hg();
                com.tencent.mm.z.c.CU().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                str2 = regionArr[0] == null ? null : regionArr[0].getCode();
                String name = regionArr[0] == null ? null : regionArr[0].getName();
                String code = regionArr[1] == null ? null : regionArr[1].getCode();
                String name2 = regionArr[1] == null ? null : regionArr[1].getName();
                if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                    name = null;
                } else {
                    name2 = null;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CountryName", name);
                intent3.putExtra("ProviceName", name2);
                intent3.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent3.putExtra("Country", str2);
                intent3.putExtra("Contact_Province", code);
                str2 = "Contact_City";
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent3.putExtra(str2, str);
                aWs();
                setResult(-1, intent3);
                finish();
            }
        }
        return false;
    }

    public void onBackPressed() {
        cxT();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Region region = null;
        int i3 = 0;
        if (i != 0 || i2 != 0) {
            cxV();
        } else if (kVar.getType() == 665) {
            Region region2;
            Region region3;
            ZoneRecommandPreference zoneRecommandPreference;
            n nVar = (n) kVar;
            x.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[]{nVar.country, nVar.fWp, nVar.fWq});
            for (Region region4 : RegionCodeDecoder.cjP().cjR()) {
                if (region4.getCode().equalsIgnoreCase(r2)) {
                    for (Region region22 : RegionCodeDecoder.cjP().XG(region4.getCode())) {
                        if (region22.getCode().equalsIgnoreCase(r5)) {
                            Region[] fF = RegionCodeDecoder.cjP().fF(region4.getCode(), region22.getCode());
                            int length = fF.length;
                            while (i3 < length) {
                                region3 = fF[i3];
                                if (region3.getCode().equalsIgnoreCase(r6)) {
                                    region = region22;
                                    region22 = region4;
                                    break;
                                }
                                i3++;
                            }
                            region3 = null;
                            region = region22;
                            region22 = region4;
                            if (region22 != null && region == null && region3 == null) {
                                if (this.zlV != null) {
                                    this.zlV.cyf();
                                    return;
                                }
                                return;
                            } else if (this.zlV == null) {
                                zoneRecommandPreference = this.zlV;
                                zoneRecommandPreference.status = 1;
                                zoneRecommandPreference.znB = region22;
                                zoneRecommandPreference.znC = region;
                                zoneRecommandPreference.znD = region3;
                                zoneRecommandPreference.cye();
                            }
                        }
                    }
                    region3 = null;
                    region22 = region4;
                    if (region22 != null) {
                    }
                    if (this.zlV == null) {
                        zoneRecommandPreference = this.zlV;
                        zoneRecommandPreference.status = 1;
                        zoneRecommandPreference.znB = region22;
                        zoneRecommandPreference.znC = region;
                        zoneRecommandPreference.znD = region3;
                        zoneRecommandPreference.cye();
                    }
                }
            }
            region3 = null;
            region22 = null;
            if (region22 != null) {
            }
            if (this.zlV == null) {
                zoneRecommandPreference = this.zlV;
                zoneRecommandPreference.status = 1;
                zoneRecommandPreference.znB = region22;
                zoneRecommandPreference.znC = region;
                zoneRecommandPreference.znD = region3;
                zoneRecommandPreference.cye();
            }
        }
    }

    private void cxV() {
        if (this.zlV != null) {
            this.zlV.cyf();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MultiStageCitySelectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0 && this.zlV != null) {
                    cxS();
                    return;
                } else if (this.zlV != null) {
                    this.zlV.cyf();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
