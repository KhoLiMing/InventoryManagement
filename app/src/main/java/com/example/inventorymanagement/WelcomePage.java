package com.example.inventorymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.mongodb.lang.NonNull;
import com.mongodb.stitch.android.core.auth.StitchUser;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential;


public class WelcomePage extends AppCompatActivity {
    StitchAppClient stitchClient = null;
    Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        welcome=findViewById(R.id.welcome);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainpage= new Intent(getBaseContext(),View_Items.class);
                startActivity(mainpage);
            }
        });


        this.stitchClient = Stitch.getDefaultAppClient();
        

        Log.d("stitch", "logging in anonymously");
        stitchClient.getAuth().loginWithCredential(new AnonymousCredential()
        ).continueWithTask(new Continuation<StitchUser, Task<Void>>() {
            @Override
            public Task<Void> then(@NonNull Task<StitchUser> task) throws Exception {
                if (task.isSuccessful()) {
                    Log.d("stitch", "logged in anonymously as user " + task.getResult());
                } else {
                    Log.e("stitch", "failed to log in anonymously", task.getException());
                }

                return null;

            }


        });
    }


    }


