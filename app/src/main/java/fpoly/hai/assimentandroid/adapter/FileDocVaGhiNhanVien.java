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

import fpoly.hai.assimentandroid.models.NhanVien;

public class FileDocVaGhiNhanVien {
    private Context context;

    public FileDocVaGhiNhanVien(Context context) {
        this.context = context;
    }
    public void fileGhi(ArrayList<NhanVien> nhanVienArrayList,String fileNane){
        File fileDir = context.getFilesDir();
        File file = new File(fileDir,fileNane);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(nhanVienArrayList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<NhanVien> fileDoc (String fileName){
        File fileDir = context.getFilesDir();
        File file = new File(fileDir,fileName);
        ArrayList<NhanVien> nhanVienArrayList = null;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                nhanVienArrayList = (ArrayList<NhanVien>) objectInputStream.readObject();
                return nhanVienArrayList;
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nhanVienArrayList;
    }
}
