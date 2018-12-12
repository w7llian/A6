package com.example.w7495.facturacion;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class AdaptadorTabla extends BaseAdapter {

    ArrayList<E_Articulos> itemList=new ArrayList<E_Articulos>();
    Context context;

    public AdaptadorTabla(Context c, ArrayList<E_Articulos> arrayArticulos){
        context=c;
        itemList=arrayArticulos;
    }

    @Override
    public int getCount(){
        return itemList.size();
    }

    @Override
    public Object getItem(int position){
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View arg1, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.items_tabla,parent,false);
        TextView lblCodigo = (TextView)itemView.findViewById(R.id.lblCodigo);
        TextView lblNombre = (TextView)itemView.findViewById(R.id.lblNombre);
        TextView lblFecha = (TextView)itemView.findViewById(R.id.lblFecha);
        TextView lblTotal = (TextView)itemView.findViewById(R.id.lblTotal);
        lblCodigo.setText(""+itemList.get(position).getCodigo());
        lblNombre.setText(itemList.get(position).getNombre());
        lblFecha.setText(""+itemList.get(position).getFecha());
        lblTotal.setText(""+itemList.get(position).getTotal());
        if(position%2==0){
            itemView.setBackgroundColor(Color.argb(255,248,248,248));
        }else{
            itemView.setBackgroundColor(Color.argb(255,255,255,255));
        }
        return itemView;
    }

}
