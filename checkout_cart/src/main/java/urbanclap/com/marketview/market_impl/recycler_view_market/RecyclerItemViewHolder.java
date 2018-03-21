package urbanclap.com.marketview.market_impl.recycler_view_market;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import urbanclap.com.marketview.frame_work.cart.CartCallback;
import urbanclap.com.marketview.frame_work.market.interfaces.IItemViewHolder;


/**
 * @author : Adnaan 'Zohran' Ahmed <adnaanahmed@urbanclap.com>
 * @version : 1.0.0
 * @since : 13 Mar 2018 3:39 PM
 */


@SuppressWarnings("unused")
public abstract class RecyclerItemViewHolder<T, CT> extends RecyclerView.ViewHolder
        implements IItemViewHolder<T> {

    @Nullable
    private CartCallback<CT> cartCallback;

    public RecyclerItemViewHolder(View itemView) {
        super(itemView);
    }

    void setCartCallback(@Nullable CartCallback<CT> cartCallback) {
        this.cartCallback = cartCallback;
    }

    protected boolean increment(@NonNull String uuid, CT item) {
        return cartCallback != null && cartCallback.incrementInCart(uuid, item);
    }

    protected boolean decrement(@NonNull String uuid) {
        return cartCallback != null && cartCallback.decrementInCart(uuid);
    }
}
