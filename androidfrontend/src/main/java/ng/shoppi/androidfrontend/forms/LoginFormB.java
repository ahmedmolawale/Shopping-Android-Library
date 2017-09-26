
package ng.shoppi.androidfrontend.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import ng.shoppi.androidfrontend.R;
import ng.shoppi.androidfrontend.listeners.LoginOnClickListener;
import ng.shoppi.androidfrontend.models.User;
import ng.shoppi.androidfrontend.util.Utility;


/**
 * This is a view object usable in a layout file just like a TextView to simulate a typical login form.<br/><br/>
 * This form is customizable via namespace attributes highlighted below:<br/>
 * <p>
 * <i>app:user_id_label="Username"</i> - To change the user id label.<br/>
 * <i>app:sign_in_label="Log In"</i>   - To change the sign in label.<br/>
 * <i>app:sign_up_label="Register"</i> - To change the sign up label.<br/>
 * <i>app:lib_shopping_logo_1="@drawable/back4"</i>   - To change the lib_shopping_logo_1 on the login form.<br/>
 * <i>app:background_image="@drawable/background"</i> - To change the background image of the form.<br/>
 * <i>app:login_validate_email="true"</i>  - set to true/false to validate email.<br/><br/>
 * After specifying the above in the layout file, It can then be referenced in the activity file just like a normal TextView for usage.<br/>
 * See the sample app for more usage details.
 *
 * @author Olawale
 * @version 1.0.0
 */

public class LoginFormB extends RelativeLayout {

    private Button signInButton;
    private LinearLayout linearLayoutLoginForm;
    private ProgressBar progressBarSignIn;
    private CircleImageView logo;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView signUpTextView;
    private LoginOnClickListener loginOnClickListener;
    private TextView forgotPasswordTextView;
    private boolean validateEmail;

    /**
     * A constructor used internally during inflation of UI. Must not be invoked explicitly.
     *
     * @param context {@link Context}
     */
    public LoginFormB(Context context) {
        super(context);
        initView(null);
    }


    /**
     * A constructor used internally during inflation of UI. Must not be invoked explicitly.
     *
     * @param context {@link Context}
     * @param attrs   {@link AttributeSet}
     */
    public LoginFormB(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    /**
     * A constructor used internally during inflation of UI. Must not be invoked explicitly.
     *
     * @param context      {@link Context}
     * @param attrs        {@link AttributeSet}
     * @param defStyleAttr int
     */
    public LoginFormB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    /**
     * A constructor used internally during inflation of UI. Must not be invoked explicitly.
     *
     * @param context      {@link Context}
     * @param attrs        {@link AttributeSet}
     * @param defStyleAttr int
     * @param defStyleRes  int
     */
    public LoginFormB(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs);
    }

    private void initView(@Nullable AttributeSet attributeSet) {
        View view = inflate(getContext(), R.layout.lib_shopping_login_1, null);
        if (attributeSet == null) {
            addView(view);
            return;
        }
        //grab the views
        logo = view.findViewById(R.id.circle_image_olx);
        editTextEmail = view.findViewById(R.id.editTextEmail_olx);
        editTextPassword = view.findViewById(R.id.editTextPassword_olx);
        forgotPasswordTextView = view.findViewById(R.id.textViewForgotPassword_olx);
        signInButton = view.findViewById(R.id.buttonSignIn_olx);
        signUpTextView = view.findViewById(R.id.textViewRegister_olx);
        linearLayoutLoginForm = view.findViewById(R.id.linearLayoutLoginForm_olx);
        progressBarSignIn = view.findViewById(R.id.progressBarSignIn_olx);

        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.LoginFormB);
        Drawable logoDrawable = typedArray.getDrawable(R.styleable.LoginFormB_logo_b);
        String userIdLabel = typedArray.getString(R.styleable.LoginFormB_user_id_label_b);
        String signInLabel = typedArray.getString(R.styleable.LoginFormB_sign_in_label_b);
        String signUpLabel = typedArray.getString(R.styleable.LoginFormB_sign_up_label_b);
        validateEmail = typedArray.getBoolean(R.styleable.LoginFormB_login_validate_email_b, true);

        if (userIdLabel != null && !userIdLabel.equals(""))
            editTextEmail.setHint(userIdLabel);
        else
            editTextEmail.setHint("Email");

        if (signInLabel != null && !signInLabel.equals(""))
            signInButton.setText(signInLabel);

        if (signUpLabel != null && !signUpLabel.equals(""))
            signUpTextView.setText(signUpLabel);

        if (logoDrawable != null)
            logo.setImageDrawable(logoDrawable);
        addView(view);
        typedArray.recycle();
    }

    /**
     * Call this method to initialize the form lib_shopping_onboarding_fragment_image referencing it from the layout.<br/>
     * See the sample app for more usage details.
     *
     * @param context {@link Context}
     */
    public void init(Context context) {
        loginOnClickListener = (LoginOnClickListener) context;
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginOnClickListener.onSignInClick();
            }
        });
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginOnClickListener.onSignUpClick();
            }
        });
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginOnClickListener.onForgetPasswordClick();
            }
        });
    }

    /**
     * Call this method to get a {@link User} object lib_shopping_onboarding_fragment_image input validation.
     *
     * @return a user object containing the user information i.e email and password.
     */
    public User getUser() {
        return new User(editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }

    /**
     * This method validates the form field details.
     *
     * @return true if the input fields are valid and false if otherwise.
     */
    public boolean validateInput() {
        return Utility.validateInput(editTextEmail, editTextPassword, validateEmail);
    }

    /**
     * This method shows a progress dialog based on the param provided.<br/>
     *
     * @param show a boolean to indicate whether the progress bar is to be shown or not.
     */
    public void showProgressBar(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        linearLayoutLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        linearLayoutLoginForm.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                linearLayoutLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        progressBarSignIn.setVisibility(show ? View.VISIBLE : View.GONE);
        progressBarSignIn.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressBarSignIn.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });

    }
}
