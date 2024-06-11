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
import fpoly.hai.assimentandroid.models.PhongBan;

public class PhongBanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PhongBan> phongBanArrayList;

    public PhongBanAdapter(Context context, ArrayList<PhongBan> phongBanArrayList) {
        this.context = context;
        this.phongBanArrayList = phongBanArrayList;
    }

    @Override
    public int getCount() {
        if (phongBanArrayList != null)
            return phongBanArrayList.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view_phongban,parent,false);

        ImageView imgAvatarPhongBan = convertView.findViewById(R.id.imgAvatarPhongBan);
        TextView tvNamePhongBan = convertView.findViewById(R.id.tvNamePhongBan);
        ImageView imgDeletePhongBan = convertView.findViewById(R.id.imgDeletePhongBan);
        ImageView imgCreatePhongBan = convertView.findViewById(R.id.imgCreatePhongBan);

        PhongBan phongBan = phongBanArrayList.get(position);
        tvNamePhongBan.setText(phongBan.getNamePhongBan());

        imgDeletePhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteShowDetail(position);
            }
        });


        return convertView;
    }

    private void deleteShowDetail(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Ban co chac la muon xoa khong???");
        builder.setPositiveButton("Yes",(dialog, which) -> {
            phongBanArrayList.remove(index);
            FileDocVaGhiPhongBan fileDocVaGhiPhongBan =  new FileDocVaGhiPhongBan(context);
            fileDocVaGhiPhongBan.fileGhi(phongBanArrayList,"phongban.txt");
            notifyDataSetChanged();
            Toast.makeText(context,"Da xoa",Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }
}
