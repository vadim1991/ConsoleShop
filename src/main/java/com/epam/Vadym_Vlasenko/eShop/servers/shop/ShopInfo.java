package com.epam.Vadym_Vlasenko.eShop.servers.shop;


import com.epam.Vadym_Vlasenko.eShop.entity.Jewel;
import com.epam.Vadym_Vlasenko.eShop.servers.Constants;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

/**
 * Created by Вадим on 02.04.2015.
 */
public class ShopInfo {

    private IService service;

    public ShopInfo(IService service) {
        this.service = service;
    }

    public int count() {
        return service.getAllProduct().size();
    }

    public String getProductById(int id, String type) {
        Jewel jewel = (Jewel) service.getProductById(id);
        String result = null;
        if (jewel != null) {
            if (Constants.HTTP_TYPE.equals(type)) {
                result = "{name:\"" + jewel.getTitle() + ", price=\"" + jewel.getPrice() + "\"}";
            } else if (Constants.OUR_TYPE.equals(type)) {
                result = jewel.getTitle() + "|" + jewel.getPrice();
            }
        } else {
            result = Constants.ERROR;
        }
        return result;
    }

}
