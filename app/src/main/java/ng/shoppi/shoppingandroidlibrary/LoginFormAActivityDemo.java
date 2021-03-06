package ng.shoppi.shoppingandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ng.shoppi.androidfrontend.forms.LoginFormA;
import ng.shoppi.androidfrontend.listeners.LoginOnClickListener;
import ng.shoppi.androidfrontend.listeners.OnboardingListener;
import ng.shoppi.androidfrontend.models.User;
import ng.shoppi.androidfrontend.onboarding.OnboardingViews;
import ng.shoppi.androidfrontend.util.ShoppingUtility;

public class LoginFormAActivityDemo extends AppCompatActivity implements LoginOnClickListener, OnboardingListener {

    private LoginFormA loginFormA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_a_demo);
        loginFormA = (LoginFormA) findViewById(R.id.form_a);
        loginFormA.init(this);
    }

    @Override
    public void onSignInClick() {
        //Toast.makeText(getBaseContext(),"Handle Sign In Activity!!!",Toast.LENGTH_LONG).show();
        if(loginFormA.validateInput()){
            //grab the input: Email and Password
            User user = loginFormA.getUser();
            Toast.makeText(getBaseContext(),"User's name: "+user.getEmail() + " Password "+user.getPassword(),Toast.LENGTH_LONG).show();
            //Testing the on-boarding views
            OnboardingViews.init(this, new int[]{R.layout.lib_shopping_onboarding_fragment_1,R.layout.lib_shopping_onboarding_fragment_1,
                    R.layout.lib_shopping_onboarding_fragment_1,R.layout.lib_shopping_onboarding_fragment_1,R.layout.lib_shopping_onboarding_fragment_1,
                    R.layout.lib_shopping_onboarding_fragment_1,R.layout.lib_shopping_onboarding_fragment_1});
        }
    }

    @Override
    public void onSignUpClick() {
        Toast.makeText(getBaseContext(),"Trigger Sign Up Activity!!!",Toast.LENGTH_LONG).show();
        //Testing the Recycler View
        startActivity(new Intent(LoginFormAActivityDemo.this, RecylcerListDemo.class));
    }

    @Override
    public void onForgetPasswordClick() {
        Toast.makeText(getBaseContext(),"Handle Forgot Password!!!",Toast.LENGTH_SHORT).show();
        //Testing the Permission Utility
        if(ShoppingUtility.isOnline(this)){
            if(ShoppingUtility.hasCameraPermission(this)){
                Toast.makeText(getBaseContext(),"We have Camera Permission",Toast.LENGTH_LONG).show();
            }else{
                ShoppingUtility.requestCameraPermission(this);
            }

        }else{
            Toast.makeText(getBaseContext(),"No Internet",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case ShoppingUtility.REQUEST_CAMERA_PERMISSION:
                if(ShoppingUtility.permissionGranted(grantResults)){
                    Toast.makeText(getBaseContext(),"Permission granted!!!",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginFormAActivityDemo.this,GenericLoginHandlerDemo.class));
                }else{
                    Toast.makeText(getBaseContext(),"Permission was not granted!!!",Toast.LENGTH_LONG).show();

                }
                break;
            case ShoppingUtility.REQUEST_RECEIVE_WAP_PUSH_PERMISSION:
                if(ShoppingUtility.permissionGranted(grantResults)){
                    Toast.makeText(getBaseContext(),"Permission granted!!!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(),"Permission was not granted!!!",Toast.LENGTH_LONG).show();

                }
        }
    }

    @Override
    public void onSkipClick() {
        Toast.makeText(getBaseContext(),"Handle Skip !!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onReady() {
        //A simulation of when the onboarding fragments is done
        Toast.makeText(getBaseContext(),"Handle Ready !!!",Toast.LENGTH_LONG).show();

    }
    }