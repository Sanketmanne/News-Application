package com.my.dailynews;

import android.content.Context;
import android.widget.Toast;

import com.my.dailynews.Model.NewsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitRequest {
    Context context;
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

          public void getDataHead(OnDataFetch listener,String category,String query)
          {
              callApi callApi=retrofit.create(callApi.class);
              Call<NewsApi> call=callApi.callHeadline("in", category,query,context.getString(R.string.api_key));

              try
              {
                call.enqueue(new Callback<NewsApi>() {
                    @Override
                    public void onResponse(Call<NewsApi> call, Response<NewsApi> response) {
                        if (!response.isSuccessful())
                        {
                            Toast.makeText(context, "Pass values", Toast.LENGTH_SHORT).show();
                        }
                      listener.onFetchData(response.body().getArticles(), response.message());
                    }

                    @Override
                    public void onFailure(Call<NewsApi> call, Throwable t) {
                    listener.OnError("Request Failed");
                    }
                });
              }
              catch (Exception e)
              {
                  e.getStackTrace();
              }
          }


    public RetrofitRequest(Context context) {
        this.context = context;
    }
    public interface callApi
    {
        @GET("top-headlines")
        Call<NewsApi>  callHeadline(

                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key

        );
    }
}
