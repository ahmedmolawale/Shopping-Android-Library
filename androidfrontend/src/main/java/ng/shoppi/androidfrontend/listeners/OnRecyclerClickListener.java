package ng.shoppi.androidfrontend.listeners;

/**
 * Implement to handle click actions on the provided custom recycler adapters.
 *
 * @author Olawale
 * @version 1.0.0
 */
public interface OnRecyclerClickListener {
    /**
     * Onclick for items in the recycler view.
     *
     * @param position int The position of the item clicked.
     */
    void onItemClick(int position);

    /**
     * OnLongClick for items in the recycler view.
     *
     * @param position int The position of the item long-clicked.
     */
    boolean onItemLongClick(int position);

    /**
     * Onclick for the image on items in the recycler view.
     *
     * @param position int The position of the image clicked.
     */
    void onImageClick(int position);
}
