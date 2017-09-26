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
     * @param position int The position of the lib_shopping_recycler_item_1 clicked.
     */
    void onItemClick(int position);

    /**
     * OnLongClick for items in the recycler view.
     *
     * @param position int The position of the lib_shopping_recycler_item_1 long-clicked.
     */
    boolean onItemLongClick(int position);

    /**
     * Onclick for the image on items in the recycler view.
     *
     * @param position int The position of the image clicked.
     */
    void onImageClick(int position);
}
