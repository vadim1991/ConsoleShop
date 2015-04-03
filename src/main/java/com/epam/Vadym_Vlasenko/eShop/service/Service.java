package com.epam.Vadym_Vlasenko.eShop.service;

import com.epam.Vadym_Vlasenko.eShop.data.advertising.Advertisement;
import com.epam.Vadym_Vlasenko.eShop.data.advertising.IAdvertisement;
import com.epam.Vadym_Vlasenko.eShop.data.cart.CartImpl;
import com.epam.Vadym_Vlasenko.eShop.data.cart.ICart;
import com.epam.Vadym_Vlasenko.eShop.data.ordersJournal.Journal;
import com.epam.Vadym_Vlasenko.eShop.data.ordersJournal.JournalImpl;
import com.epam.Vadym_Vlasenko.eShop.data.store.ShopStore;
import com.epam.Vadym_Vlasenko.eShop.data.store.Store;
import com.epam.Vadym_Vlasenko.eShop.dataLoader.StoreLoader;
import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.ui.localization.Localizator;
import com.epam.Vadym_Vlasenko.eShop.util.input.ConsoleInput;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;
import com.epam.Vadym_Vlasenko.eShop.util.input.InputType;
import com.epam.Vadym_Vlasenko.eShop.util.input.RandomInput;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Service implements IService {

    private Inputer input;

    private ICart cart;

    private Store store;

    private IAdvertisement advertisement;

    private Journal orders;

    private StoreLoader storeLoader;

    private Localizator localizator;

    public Service() {
        cart = new CartImpl();
        store = new ShopStore();
        advertisement = new Advertisement();
        orders = new JournalImpl();
        storeLoader = new StoreLoader();
    }

    @Override
    public List<Product> getAllProduct() {
        return store.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return store.getProductById(id);
    }

    @Override
    public void addToCart(Product product, Integer amont) {
        cart.add(product, amont);
        advertisement.add(product);
    }

    @Override
    public List<Product> getLastFiveProduct() {
        return advertisement.getContent();
    }

    @Override
    public void addNewProduct(Product product) {
        store.addProduct(product);
    }

    public void initStore(String fileName) {
        store = storeLoader.loadFromFile(fileName);
    }

    @Override
    public Map<Integer, Integer> getCartContent() {
        return cart.getAll();
    }

    @Override
    public void makeOrder() {
        orders.add(new Order(cart.getAll()));
        cart.clear();
    }

    @Override
    public int sumAllOrders() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : cart.getAll().entrySet()) {
            sum += getProductById(entry.getKey()).getPrice() * entry.getValue();
        }
        return sum;
    }

    @Override
    public Map<Date, Order> getAllOrders() {
        return Collections.unmodifiableMap(orders.getAllOrders());
    }

    @Override
    public Order getNearestOrder(Date date) {
        return orders.getNearestOrder(date);
    }

    @Override
    public List<Order> getAllFromPeriod(Date min, Date max) {
        return orders.getAllFromPeriod(min, max);
    }

    public Inputer getInput() {
        return input;
    }

    @Override
    public void setLocalizator(Localizator localizator) {
        this.localizator = localizator;
    }

    @Override
    public Localizator getLocalizator() {
        return localizator;
    }

    @Override
    public void exit() {
        storeLoader.saveStoreToFile("src\\main\\resources\\store.txt", store);
        System.exit(0);
    }

    public void setInput(int inputType) {
        InputType input = InputType.chooseInput(inputType);
        if (input == InputType.Console) {
            this.input = new ConsoleInput();
        } else {
            this.input = new RandomInput();
        }
    }
}
