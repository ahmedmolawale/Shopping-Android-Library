package ng.shoppi.androidfrontend.genericformhandler;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import ng.shoppi.androidfrontend.listeners.RegistrationOnClickListener;
import ng.shoppi.androidfrontend.models.User;
import ng.shoppi.androidfrontend.util.Utility;


/**
 * A Generic Registration Form Handler for any form.<br/>
 * To be initialised via the constructor. See the constructor for details.<br/>
 * Also see the demo app for usage details
 *
 * @author Olawale
 * @version 1.0.0
 */
public class RegistrationHandler {

    private EditText editTextFirstname;
    private EditText editTextLastname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private EditText editTextPhone;
    private View signIn;
    private View register;
    private boolean emailValidation;
    private ProgressBar progressBar;
    private RegistrationOnClickListener registrationOnClickListener;

    /**
     * Use to initialize the Registration Form Handler
     *
     * @param firstName               {@link EditText}   The first name field.
     * @param lastName                {@link EditText}    The last name field.
     * @param username                {@link EditText}     The user id field.
     * @param password                {@link EditText}     The password field
     * @param editTextConfirmPassword {@link EditText} The confirm password field
     * @param editTextPhone           {@link EditText}       Phone number field.
     * @param emailValidation         boolean     Pass true if you want email validation, false if the user id is not an email.
     */
    public RegistrationHandler(EditText firstName, EditText lastName, EditText username,
                               EditText password, EditText editTextConfirmPassword,
                               EditText editTextPhone, boolean emailValidation) {

        this.editTextFirstname = firstName;
        this.editTextLastname = lastName;
        this.editTextEmail = username;
        this.editTextPassword = password;
        this.editTextConfirmPassword = editTextConfirmPassword;
        this.editTextPhone = editTextPhone;
        this.emailValidation = emailValidation;
        setUp();
    }

    /**
     * Use to initialize the Registration Form Handler
     *
     * @param firstName               {@link EditText}   The first name field.
     * @param lastName                {@link EditText}    The last name field.
     * @param username                {@link EditText}     The user id field.
     * @param password                {@link EditText}     The password field
     * @param editTextConfirmPassword {@link EditText} The confirm password field
     * @param editTextPhone           {@link EditText}       Phone number field.
     * @param register                {@link View}         The Register in Button or TextView as the case may be.
     * @param signIn                  {@link View}        The Sign in Button or TextView as the case may be.
     * @param emailValidation         boolean      Pass true if you want email validation, false if the user id is not an email
     */
    public RegistrationHandler(EditText firstName, EditText lastName, EditText username,
                               EditText password, EditText editTextConfirmPassword, EditText editTextPhone, View register, View signIn,
                               ProgressBar progressBar, boolean emailValidation) {

        this.editTextFirstname = firstName;
        this.editTextLastname = lastName;
        this.editTextEmail = username;
        this.editTextPassword = password;
        this.editTextConfirmPassword = editTextConfirmPassword;
        this.editTextPhone = editTextPhone;
        this.signIn = signIn;
        this.register = register;
        this.progressBar = progressBar;
        this.emailValidation = emailValidation;
        setUp();
    }


    private void setUp() {
        Context context = editTextEmail.getContext();
        registrationOnClickListener = (RegistrationOnClickListener) context;
        if (signIn != null) {
            signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registrationOnClickListener.onSignInClick();
                }
            });
        }
        if (register != null) {
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registrationOnClickListener.onRegisterClick();
                }
            });
        }
    }


    /**
     * This method validates the form field details.<br/>
     * To be called on {@link RegistrationHandler} object
     *
     * @return true if the input fields are valid and false if otherwise.
     */
    public boolean validateInput() {
        return Utility.validateInput(editTextFirstname, editTextLastname, editTextEmail, editTextPassword, editTextConfirmPassword, editTextPhone, emailValidation);
    }

    /**
     * This method shows a progress dialog based on the param provided.<br/>
     * To be called on {@link RegistrationHandler} object
     *
     * @param show a boolean to indicate whether the progress bar is to be shown or not.
     */
    public void showProgressBar(final boolean show) {
        if (progressBar != null)
            Utility.showProgressBar(show, progressBar);
    }

    /**
     * Call this method to get a {@link User} object after input validation.<br/>
     * To be called on {@link RegistrationHandler} object
     *
     * @return a user object containing the user information i.e firstname, lastname, email, password etc
     */
    public User getUser() {
        return new User(editTextFirstname.getText().toString(),
                editTextLastname.getText().toString(),
                editTextEmail.getText().toString(), editTextPassword.getText().toString(),
                editTextPhone.getText().toString());
    }
}
