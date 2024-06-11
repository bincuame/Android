package fpoly.hai.assimentandroid.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fpoly.hai.assimentandroid.R;
import fpoly.hai.assimentandroid.models.NhanVien;

public class NhanVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NhanVien> nhanVienArrayList;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> nhanVienArrayList) {
        this.context = context;
        this.nhanVienArrayList = nhanVienArrayList;
    }

    @Override
    public int getCount() {
        if (nhanVienArrayList != null)
            return nhanVienArrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view_nhanvien,parent,false);

        TextView tvMaNhanVien = convertView.findViewById(R.id.tvMaNhanVien);
        TextView tvTenNhanVien = convertView.findViewById(R.id.tvTenNhanVien);
        TextView tvPhongBanNhanVien = convertView.findViewById(R.id.tvPhongBanNhaVien);
        ImageView imgDeleteNhanVien = convertView.findViewById(R.id.imgDeleteNhanVien);
        ImageView imgCreateNhanVien = convertView.findViewById(R.id.imgCreateNhanVien);

        NhanVien nhanVien = nhanVienArrayList.get(position);
        tvMaNhanVien.setText("Ma NV: " + nhanVien.getMaNhanVien());
        tvTenNhanVien.setText("Ho va Ten NV: " + nhanVien.getTenNhanVien());
        tvPhongBanNhanVien.setText("Phong Ban: " + nhanVien.getTenPhongBanNhanVien());

        imgDeleteNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDetail(position);
            }
        });

        return convertView;
    }

    private void showDeleteDetail(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Ban co chac muon xoa nhan vien nay???");
        builder.setPositiveButton("Yes",(dialog, which) -> {
            nhanVienArrayList.remove(index);
            FileDocVaGhiNhanVien fileDocVaGhiNhanVien = new FileDocVaGhiNhanVien(context);
            fileDocVaGhiNhanVien.fileGhi(nhanVienArrayList,"nhanvien.txt");
            notifyDataSetChanged();
            Toast.makeText(context,"Da Xoa",Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }
}
