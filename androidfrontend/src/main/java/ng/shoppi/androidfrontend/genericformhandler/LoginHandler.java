package ng.shoppi.androidfrontend.genericformhandler;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import ng.shoppi.androidfrontend.listeners.LoginOnClickListener;
import ng.shoppi.androidfrontend.models.User;
import ng.shoppi.androidfrontend.util.Utility;

/**
 * A Generic Login Form Handler for any form.<br/>
 * To be initialised via the constructor. See the constructor for details.<br/>
 * Also see the demo app for usage details
 *
 * @author Olawale
 * @version 1.0.0
 */
public class LoginHandler {

    private View forgotPassword;
    private View register;
    private EditText editTextPassword;
    private View signIn;
    private boolean emailValidation;
    private EditText editTextEmail;
    private ProgressBar progressBar;
    private LoginOnClickListener loginOnClickListener;

    /**
     * Use to initialize the Login Form Handler by passing in the required params.
     *
     * @param username        {@link EditText}     The id of the form. Must be an EditText or any of its subclass
     * @param password        {@link EditText}      The editTextPassword EditText. Must be an EditText or any of its subclass
     * @param signIn          {@link View}      The Sign in Button or TextView as the case may be.
     * @param emailValidation boolean  Pass true if you want email validation, false if the user id is not an email
     */
    public LoginHandler(EditText username, EditText password, View signIn, ProgressBar progressBar, boolean emailValidation) {
        this.editTextEmail = username;
        this.editTextPassword = password;
        this.signIn = signIn;
        this.progressBar = progressBar;
        this.emailValidation = emailValidation;
        setUp();
    }

    /**
     * Use to initialize the Login Form Handler.
     * This takes care of the case when the register view object is available.
     *
     * @param username        {@link EditText}    The id of the form. Must be an EditText or any of its subclass
     * @param password        {@link EditText}    The editTextPassword EditText. Must be an EditText or any of its subclass
     * @param signIn          {@link View}    The Sign in Button or TextView as the case may be.
     * @param register        {@link View}    The Sign up Button or TextView as the case may be.
     * @param emailValidation boolean Pass true if you want email validation, false if the user id is not an email
     */
    public LoginHandler(EditText username, EditText password, View signIn, ProgressBar progressBar, View register, boolean emailValidation) {
        this.editTextEmail = username;
        this.editTextPassword = password;
        this.signIn = signIn;
        this.progressBar = progressBar;
        this.register = register;
        this.emailValidation = emailValidation;
        setUp();
    }

    /**
     * Use to initialize the Login Form Handler.
     * This takes care of the case when the register view object and the forgot password view object is available.
     *
     * @param username        {@link EditText}    The id of the form. Must be an EditText or any of its subclass
     * @param password        {@link EditText}     The editTextPassword EditText. Must be an EditText or any of its subclass
     * @param signIn          {@link View}     The Sign in Button or TextView as the case may be.
     * @param emailValidation boolean Pass true if you want email validation, false if the user id is not an email
     * @param register        {@link View}  The Sign up Button or TextView as the case may be.
     * @param forgotPassword  {@link View} The Forgot Password Button or TextView as the case may be.
     */
    public LoginHandler(EditText username, EditText password, View signIn, ProgressBar progressBar, View register, View forgotPassword, boolean emailValidation) {

        this.editTextEmail = username;
        this.editTextPassword = password;
        this.signIn = signIn;
        this.progressBar = progressBar;
        this.register = register;
        this.emailValidation = emailValidation;
        this.forgotPassword = forgotPassword;
        setUp();
    }

    private void setUp() {
        Context context = editTextEmail.getContext();
        loginOnClickListener = (LoginOnClickListener) context;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginOnClickListener.onSignInClick();
            }
        });
        //check that the user provides register button in constructor
        if (register != null) {
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginOnClickListener.onSignUpClick();
                }
            });
        }

        if (forgotPassword != null) {
            forgotPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginOnClickListener.onForgetPasswordClick();
                }
            });
        }

    }

    /**
     * This method validates the form field details.<br/>
     * To be called on {@link LoginHandler} object
     *
     * @return true if the input fields are valid and false if otherwise.
     */
    public boolean validateInput() {
        return Utility.validateInput(editTextEmail, editTextPassword, emailValidation);
    }

    /**
     * This method shows a progress dialog based on the param provided.<br/>
     * To be called on {@link LoginHandler} object
     *
     * @param show a boolean to indicate whether the progress bar is to be shown or not.
     */
    public void showProgressBar(final boolean show) {
        Utility.showProgressBar(show, progressBar);
    }

    /**
     * Call this method to get a {@link User} object after input validation.<br/>
     * To be called on {@link LoginHandler} object
     *
     * @return a user object containing the user information i.e firstname, lastname, email, password etc
     */
    public User getUser() {
        return new User(editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }
}
