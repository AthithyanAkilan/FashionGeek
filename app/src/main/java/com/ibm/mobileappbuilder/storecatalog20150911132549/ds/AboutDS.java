

package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "AboutDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class AboutDS extends AppNowDatasource<AboutDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private AboutDSService service;

    public static AboutDS getInstance(SearchOptions searchOptions){
        return new AboutDS(searchOptions);
    }

    private AboutDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = AboutDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<AboutDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<AboutDSItem>>() {
                @Override
                public void onSuccess(List<AboutDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new AboutDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getAboutDSItemById(id, new Callback<AboutDSItem>() {
                @Override
                public void success(AboutDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<AboutDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<AboutDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryAboutDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<AboutDSItem>>() {
            @Override
            public void success(List<AboutDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"about"};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(AboutDSItem item, Listener<AboutDSItem> listener) {
                          service.getServiceProxy().createAboutDSItem(item, callbackFor(listener));
          }

    private Callback<AboutDSItem> callbackFor(final Listener<AboutDSItem> listener) {
      return new Callback<AboutDSItem>() {
          @Override
          public void success(AboutDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(AboutDSItem item, Listener<AboutDSItem> listener) {
                          service.getServiceProxy().updateAboutDSItem(item.getIdentifiableId(), item, callbackFor(listener));
          }

    @Override
    public void deleteItem(AboutDSItem item, final Listener<AboutDSItem> listener) {
                service.getServiceProxy().deleteAboutDSItemById(item.getIdentifiableId(), new Callback<AboutDSItem>() {
            @Override
            public void success(AboutDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<AboutDSItem> items, final Listener<AboutDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<AboutDSItem>>() {
            @Override
            public void success(List<AboutDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<AboutDSItem> items){
        List<String> ids = new ArrayList<>();
        for(AboutDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

