package ng.shoppi.androidfrontend.listeners;

/**
 * Implement to handle click actions on On-boarding views.
 *
 * @author Olawale
 * @version 1.0.0
 */

public interface OnboardingListener {
    /**
     * Onclick for skip action on On-boarding views.
     */
    void onSkipClick();

    /**
     * Onclick for ready action on On-boarding views.<br/>
     * Invoked when the user is done with the on-boarding views fragments
     */
    void onReady();
}
