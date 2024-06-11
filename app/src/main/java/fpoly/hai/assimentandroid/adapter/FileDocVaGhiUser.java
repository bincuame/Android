package fpoly.hai.assimentandroid.adapter;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fpoly.hai.assimentandroid.models.User;

public class FileDocVaGhiUser {
    private Context context;

    public FileDocVaGhiUser(Context context) {
        this.context = context;
    }

    public void fileGhi(ArrayList<User> userArrayList, String fileName){
        File fileDir = context.getFilesDir();
        File file = new File(fileDir,fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userArrayList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> fileDoc(String fileName){
        File filesDir = context.getFilesDir();
        File file = new File(filesDir,fileName);
        ArrayList<User> userArrayList = null;
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    userArrayList = (ArrayList<User>) objectInputStream.readObject();
                    objectInputStream.close();
                    return userArrayList;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        return userArrayList;
    }

}
