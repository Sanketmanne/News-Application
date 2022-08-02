package com.my.dailynews;

import com.my.dailynews.Model.NewsHeadlines;

import java.util.List;

import retrofit2.Call;

public interface OnDataFetch<NewsApi> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void OnError(String message);
}
