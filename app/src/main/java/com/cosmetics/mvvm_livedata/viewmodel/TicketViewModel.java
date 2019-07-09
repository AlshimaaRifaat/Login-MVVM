package com.cosmetics.mvvm_livedata.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cosmetics.mvvm_livedata.model.LoginData;
import com.cosmetics.mvvm_livedata.remote.RetroClass;

public class TicketViewModel extends ViewModel {
    private LoginData loginData;
    private RetroClass retroClass=new RetroClass();
    private LiveData<LoginData> ticketLiveData;

    public LiveData<LoginData> getTicketLiveDataVal(String email,String pass,String lang) {
       if (ticketLiveData==null)
        {
            ticketLiveData=retroClass.getTicketLiveData(email,pass,lang);
        }
        return ticketLiveData;
    }
}
