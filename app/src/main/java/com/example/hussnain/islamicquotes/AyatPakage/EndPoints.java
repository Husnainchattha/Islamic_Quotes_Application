package com.example.hussnain.islamicquotes.AyatPakage;

import com.example.hussnain.islamicquotes.NobelPakage.NobelQuot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface EndPoints {
        @GET
        Call<BaseResponse> getTodayAyah(@Url String url);
    @GET
    Call<NobelQuot>getTodayNoble(@Url String url);

    }