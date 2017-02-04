package com.kamran.rxdagger.service;

import com.kamran.rxdagger.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Kamran ALi on 2/2/2017.
 */

public interface FloweService {
    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>>  getFlowerListResponse();
}
