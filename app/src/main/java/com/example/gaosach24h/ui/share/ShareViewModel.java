package com.example.gaosach24h.ui.share;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bước 1: Lựa chọn sản phẩm phù hợp với gia đình bạn");
        mText= new MutableLiveData<>();
        mText.setValue("Bước 2: Thêm sản phẩm vào giỏ hàng. Lựa chọn số lượng, địa chỉ giao hàng, phương thức thanh toán, nhập mã khuyến mãi(nếu có)");
        mText= new MutableLiveData<>();
        mText.setValue("Bước 3: Xác nhận đặt hàng. Bấm đặt hàng và chờ xác nhận đơn hàng của bạn.");
        mText= new MutableLiveData<>();
        mText.setValue( "Bước 4: Nhận hàng và thanh toán.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}