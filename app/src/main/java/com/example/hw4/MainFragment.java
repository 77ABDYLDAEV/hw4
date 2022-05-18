package com.example.hw4;


import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentTransaction;



import com.example.hw4.databinding.FragmentMainBinding;


public class MainFragment extends BaseFragment<FragmentMainBinding> {
    private  NotesAdapter adapter;


    @Override
    protected FragmentMainBinding getBinding() {
        return FragmentMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupUI() {
        initAdapter();
        listenNoteData();
    }

    @Override
    protected void setupObservers() {
        openAddFragment();
    }

    private void openAddFragment() {
        binding.btnOpenAddFragment.setOnClickListener(view1 -> {
            FragmentManager manager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment_container, new AddNoteFragment());
            transaction.addToBackStack("AddNoteFragment");
            transaction.commit();
        });
    }

    public void listenNoteData(){
        requireActivity().getSupportFragmentManager().setFragmentResultListener
                ("addNote", this, (requestKey, result) -> {
            if(requestKey.equals("addNote")){
                adapter.addNote(new NotesModel(result.getString("title"),
                   result.getString("description"), result.getString("date")));
            }
        });
    }
private void initAdapter(){
    adapter= new NotesAdapter();
    binding.rvNotes.setAdapter(adapter);
}

}

