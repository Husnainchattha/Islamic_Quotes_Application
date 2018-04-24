package com.example.hussnain.islamicquotes.AyatPakage;

import android.support.annotation.NonNull;

import com.example.hussnain.islamicquotes.NobelPakage.NobelQuot;
import com.example.hussnain.islamicquotes.NobelPakage.RandomQuote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class ApiHandler {
    private static ApiHandler instance;
    private EndPoints endPoints;
    private ApiHandler() {
        endPoints = new Retrofit.Builder()
                .baseUrl("http://example.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EndPoints.class);
    }
    public void getTodayAyah(int todayAyatNumber,final MyCallback completion) {
        String url = "http://api.alquran.cloud/ayah/" + todayAyatNumber;
        Call<BaseResponse> call = endPoints.getTodayAyah(url);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call,
                                   @NonNull Response<BaseResponse> response) {
                BaseResponse body = response.body();
                if (body != null) {
                    completion.onSuccess(body);
                }
            }
            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                completion.onError(t.getMessage());
                t.printStackTrace();
            }
        });
    }
    public void getTodayNoble(final MyCallback1 completion ) {

        String url = "https://quotes.rest/qod.json";

        Call<NobelQuot> call = endPoints.getTodayNoble(url);

        call.enqueue(new Callback<NobelQuot>() {

            @Override
            public void onResponse(@NonNull Call<NobelQuot> call,
                                   @NonNull Response<NobelQuot> response) {
                NobelQuot body = response.body();
                if (body != null) {
                    completion.onSuccess(body);
                }
            }
            @Override
            public void onFailure(@NonNull Call<NobelQuot> call, @NonNull Throwable t) {
                completion.onError(t.getMessage());
                t.printStackTrace();
            }
        });
    }
    public void getRandomQuote(final MyCallback2 completion){
        String url = "https://talaikis.com/api/quotes/random/";

        Call<RandomQuote> call = endPoints.getRandomQuote(url);

        call.enqueue(new Callback<RandomQuote>() {

            @Override
            public void onResponse(@NonNull Call<RandomQuote> call,
                                   @NonNull Response<RandomQuote> response) {
                RandomQuote body = response.body();
                if (body != null) {
                    completion.onSuccess(body);
                }
            }
            @Override
            public void onFailure(@NonNull Call<RandomQuote> call, @NonNull Throwable t) {
                completion.onError(t.getMessage());
                t.printStackTrace();
            }
        });
    }
    public static ApiHandler getInstance() {
        if (instance == null) {
            instance = new ApiHandler();
        }
        return instance;
    }
    public interface EndPoints{
        @GET
        Call<BaseResponse> getTodayAyah(@Url String url);
        @GET
        Call<NobelQuot>getTodayNoble(@Url String url);
        @GET
        Call<RandomQuote>getRandomQuote(@Url String url);

    }
    public interface MyCallback1 {
        void onSuccess(NobelQuot nobelQuot);
        void onError(String message);
    }
    public interface MyCallback {
        void onSuccess(BaseResponse baseResponse);
        void onError(String message);
    }
    public interface MyCallback2{
        void onSuccess(RandomQuote randomQuote);
        void onError(String message);
    }


}
