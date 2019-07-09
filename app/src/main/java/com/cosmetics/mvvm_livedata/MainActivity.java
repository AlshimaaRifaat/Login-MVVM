package com.cosmetics.mvvm_livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cosmetics.mvvm_livedata.model.LoginData;
import com.cosmetics.mvvm_livedata.presenter.Presenter;
import com.cosmetics.mvvm_livedata.viewmodel.TicketViewModel;

public class MainActivity extends AppCompatActivity implements Presenter {
private TicketViewModel ticketViewModel;
 EditText username,userpass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ticketViewModel= ViewModelProviders.of(this).get(TicketViewModel.class);
        //ticketViewModel.getTicketLiveDataVal();
    }

    private void init() {
        username = findViewById(R.id.username);
        userpass = findViewById(R.id.userpass);
        login = findViewById(R.id.login);
    }

    public void getTokenView(View view) {
       /* String ticketidval=ticketViewModel.getTicketLiveDataVal().getValue().get().toString();
        ticketid.setText(ticketidval);

        String ticketnameval=ticketViewModel.getTicketLiveDataVal().getValue().getTicketname().toString();
        ticketname.setText(ticketnameval);

        String ticketdescval=ticketViewModel.getTicketLiveDataVal().getValue().getTicketdesc().toString();
        ticketdesc.setText(ticketdescval);*/
        ticketViewModel.getTicketLiveDataVal(username.getText().toString()
                ,userpass.getText().toString(),"en");
        Toast.makeText(this, username.getText().toString()+" "+userpass.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginData(LoginData loginData) {
        Toast.makeText(this, loginData.getUserToken(), Toast.LENGTH_SHORT).show();
    }
}
