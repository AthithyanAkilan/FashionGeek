
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.storecatalog20150911132549.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "AboutDSService" REST Service implementation
 */
public class AboutDSService extends RestService<AboutDSServiceRest>{

    public static AboutDSService getInstance(){
          return new AboutDSService();
    }

    private AboutDSService() {
        super(AboutDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "TNSxEBcz";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ed6d2cd911a30300ba6106",
                path,
                "apikey=TNSxEBcz");
    }

}

