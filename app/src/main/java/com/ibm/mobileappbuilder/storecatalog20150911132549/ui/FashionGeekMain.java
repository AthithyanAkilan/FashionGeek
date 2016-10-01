package com.ibm.mobileappbuilder.storecatalog20150911132549.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import com.ibm.mobileappbuilder.storecatalog20150911132549.R;

public class FashionGeekMain extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
                sectionFragments.append(R.id.entry0, StoreCatalogScreen1Fragment.class);
            sectionFragments.append(R.id.entry1, ContactFragment.class);
            sectionFragments.append(R.id.entry2, AboutFragment.class);
            sectionFragments.append(R.id.entry3, LogoutFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}

