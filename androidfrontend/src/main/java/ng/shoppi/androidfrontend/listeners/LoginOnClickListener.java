package ng.shoppi.androidfrontend.listeners;

/**
 * Implement to handle click actions on login forms
 *
 * @author Olawale
 * @version 1.0.0
 */

public interface LoginOnClickListener {

    /**
     * Onclick for sign in on login form
     */
    void onSignInClick();

    /**
     * Onclick for sign up on login form
     */
    void onSignUpClick();

    /**
     * Onclick for forgot password on login form
     */
    void onForgetPasswordClick();
}
