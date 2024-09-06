package com.zigmab.first.Acivities.Stores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.zigmab.first.R
import com.zigmab.first.databinding.FragmentStoreBinding


class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding
    private var Mactivity: StoresActivity? = null

    override fun onCreateView(   inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        binding = FragmentStoreBinding.inflate( inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Mactivity = activity as? StoresActivity
        Mactivity?.supportActionBar?.setDisplayHomeAsUpEnabled( true )
        Mactivity?.supportActionBar?.title = "Add store"

        setHasOptionsMenu( true )


        binding.btnsave.setOnClickListener{
            Snackbar.make(
                binding.root,
                "Saved",
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_servers, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }


    override fun onDestroyView() {
        super.onDestroyView()

        // Opcional: Restablecer la barra de acción cuando se destruye el fragmento
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            title = "Mi Actividad Principal" // Restablecer el título original
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        /*return  when ( item.itemId ){
            android.R.id.action_settings -> {
                //Mactivity?.OnBackPresseDispatcher?.onBackPressed()
                Mactivity?.onBackPressed()
                true
            }
        }*/

        return super.onOptionsItemSelected(item)
    }

}