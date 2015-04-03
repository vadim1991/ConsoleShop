package com.epam.Vadym_Vlasenko.eShop.dataLoader;

import com.epam.Vadym_Vlasenko.eShop.data.store.ShopStore;
import com.epam.Vadym_Vlasenko.eShop.data.store.Store;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class StoreLoader {

    private static final Logger LOG = Logger.getLogger(StoreLoader.class);
    private static final String IO_EXCEPTION = "IOException";
    private static final String ClASS_NOT_FOUND = "Class not found exception in loadFromFile method";


    public Store loadFromFile(String fileName) {
        File file = new File(fileName);
        Store store = new ShopStore();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            store = (Store) ois.readObject();
        } catch (IOException e) {
            LOG.error(IO_EXCEPTION);
        } catch (ClassNotFoundException e) {
            LOG.error(ClASS_NOT_FOUND);
        }
        return store;
    }

    public void saveStoreToFile(String fileName, Store store) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(
                        new File(fileName))))) {
            ous.writeObject(store);
        } catch (IOException e) {
            LOG.error(IO_EXCEPTION);
        }
    }

    public void zipStoreToFile(String filePath, Store store, int count) throws IOException {
        try (GZIPOutputStream zOut = new GZIPOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(
                                new File(filePath))));
             ObjectOutputStream out = new ObjectOutputStream(zOut)) {
            for (int i = 0; i < count; i++) {
                out.writeObject(store);
            }
        }
    }

    public void saveStoreToFile(String fileName, Store store, int count) {
        File file = new File(fileName);
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < count; i++) {
                ous.writeObject(store);
            }
            ous.writeObject(store);
        } catch (IOException e) {
            LOG.error(IO_EXCEPTION);
        }
    }

}
