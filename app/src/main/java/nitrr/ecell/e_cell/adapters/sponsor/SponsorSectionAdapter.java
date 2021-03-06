package nitrr.ecell.e_cell.adapters.sponsor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import nitrr.ecell.e_cell.R;
import nitrr.ecell.e_cell.model.sponsors.SponsorType;

public class SponsorSectionAdapter extends RecyclerView.Adapter<SponsorSectionAdapter.ViewHolder> {

    private List<SponsorType> sectionedSponsorTypeList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private SponsorGridAdapter gridSponsorAdapter;

    public SponsorSectionAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSectionedSponsorTypeList(List<SponsorType> sectionedSponsorTypeList) {
        this.sectionedSponsorTypeList = sectionedSponsorTypeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.itemlayout_sponsors, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SponsorType sponsorTypeData = sectionedSponsorTypeList.get(position);
        gridSponsorAdapter = new SponsorGridAdapter(context);
        holder.gridRecyclerViewSpons.setLayoutManager(new GridLayoutManager(context, 2));
        holder.gridRecyclerViewSpons.setAdapter(gridSponsorAdapter);
        holder.gridRecyclerViewSpons.setNestedScrollingEnabled(false);
        if (sponsorTypeData.getSponserslist() != null && sponsorTypeData.getSponserslist().size() != 0) {
            holder.SponsHeading.setVisibility(View.VISIBLE);
            holder.SponsHeading.setText(sponsorTypeData.getSponsortypename());
            gridSponsorAdapter.setSponsorDetailList(sponsorTypeData.getSponserslist());
            gridSponsorAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return sectionedSponsorTypeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView SponsHeading;
        RecyclerView gridRecyclerViewSpons;

        public ViewHolder(View itemView) {
            super(itemView);

            SponsHeading = (TextView) itemView.findViewById(R.id.sponstypename);
            gridRecyclerViewSpons = (RecyclerView) itemView.findViewById(R.id.recyclerview_sponsor2);

        }
    }

}
