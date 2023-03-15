package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Networking;

import android.content.Context;
import android.widget.Toast;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.Utility;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.BaseURL;

// created by Milan Vadgama  :)

public class Api {

    // Singleton objects
    public static Retrofit retrofitApi = null;

    // Common Variables
    private static int TimeOut = 20;


    // Create Api
    public static ApiInterface CreateApi(Context context) {
        OkHttpClient okHttpClient = Build(context).build();
        if (retrofitApi == null)
            retrofitApi = new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        return retrofitApi.create(ApiInterface.class);
    }

    private static OkHttpClient.Builder Build(final Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TimeOut, TimeUnit.SECONDS).writeTimeout(TimeOut, TimeUnit.SECONDS).readTimeout(TimeOut, TimeUnit.SECONDS).addInterceptor(logging);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (Utility.NetworkAvailable(context)) {
                    try {
                        Request request = chain.request().newBuilder().build();
                        Response response = chain.proceed(request);
                        return response;
                    } catch (SocketTimeoutException exception) {
                        new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Server not responding.. Please try after sometimes", Toast.LENGTH_LONG).show();
                            }
                        };
                        return null;
                        //throw new TimeOutException();
                    }
                } else {
                    new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "internet not Available", Toast.LENGTH_LONG).show();
                        }
                    };
                    return null;
                    //throw new NoConnectivityException();
                }
            }
        });
        return builder;
    }

    // Network Error Exception
//    public static class NoConnectivityException extends IOException {
//        @Override
//        public String getMessage() {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {}
//            });
//            return super.getMessage();
//        }
//    }

//    public static class TimeOutException extends IOException {
//        @Override
//        public String getMessage() {
//
//            return super.getMessage();
//        }
//    }

}