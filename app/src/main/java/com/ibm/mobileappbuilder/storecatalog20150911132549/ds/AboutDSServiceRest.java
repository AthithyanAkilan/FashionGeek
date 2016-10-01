
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;

public interface AboutDSServiceRest{

	@GET("/app/57ed6d2cd911a30300ba6106/r/aboutDS")
	void queryAboutDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<AboutDSItem>> cb);

	@GET("/app/57ed6d2cd911a30300ba6106/r/aboutDS/{id}")
	void getAboutDSItemById(@Path("id") String id, Callback<AboutDSItem> cb);

	@DELETE("/app/57ed6d2cd911a30300ba6106/r/aboutDS/{id}")
  void deleteAboutDSItemById(@Path("id") String id, Callback<AboutDSItem> cb);

  @POST("/app/57ed6d2cd911a30300ba6106/r/aboutDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<AboutDSItem>> cb);

  @POST("/app/57ed6d2cd911a30300ba6106/r/aboutDS")
  void createAboutDSItem(@Body AboutDSItem item, Callback<AboutDSItem> cb);

  @PUT("/app/57ed6d2cd911a30300ba6106/r/aboutDS/{id}")
  void updateAboutDSItem(@Path("id") String id, @Body AboutDSItem item, Callback<AboutDSItem> cb);

  @GET("/app/57ed6d2cd911a30300ba6106/r/aboutDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}

