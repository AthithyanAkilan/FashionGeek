
package com.ibm.mobileappbuilder.storecatalog20150911132549.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.storecatalog20150911132549.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.storecatalog20150911132549.ds.AboutDSItem;
import com.ibm.mobileappbuilder.storecatalog20150911132549.ds.AboutDS;

public class AboutFragment extends ibmmobileappbuilder.ui.DetailFragment<AboutDSItem>  {

    private Datasource<AboutDSItem> datasource;
    private SearchOptions searchOptions;

    public static AboutFragment newInstance(Bundle args){
        AboutFragment card = new AboutFragment();
        card.setArguments(args);

        return card;
    }

    public AboutFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = AboutDS.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.about_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final AboutDSItem item, View view) {
    }

    @Override
    protected void onShow(AboutDSItem item) {
        // set the title for this fragment
        getActivity().setTitle("About");
    }

}

