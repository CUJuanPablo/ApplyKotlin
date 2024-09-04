package com.zigmab.first.Acivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.zigmab.first.Adapters.StoraAdapter
import com.zigmab.first.DB.StoreAplication
import com.zigmab.first.Entidades.StoreEntity
import com.zigmab.first.Entidades.User
import com.zigmab.first.Intefaces.OnClickListener
import com.zigmab.first.R
import com.zigmab.first.databinding.ActivityStoresBinding
import java.util.concurrent.LinkedBlockingQueue

class StoresActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityStoresBinding

    private lateinit var madapter: StoraAdapter
    private lateinit var ly: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoresBinding.inflate( layoutInflater )
        setContentView( binding.root )

        binding.btnsave.setOnClickListener{
            val store = StoreEntity(
                NAME = binding.txtnombre.text.toString().trim()
            )

            //SQLITE
            Thread{
                StoreAplication.database.storeDao().AddStore( store )
            }.start()


            madapter.add(store)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        madapter = StoraAdapter( mutableListOf() , this )

        ly = GridLayoutManager( this, 2)

        Thread{
            GetStores()
        }.start()

        binding.rystores.apply {
            setHasFixedSize( true )
            layoutManager = ly
            adapter = madapter
        }

    }

    private fun GetStores(){
        val queue = LinkedBlockingQueue<MutableList<StoreEntity>>()

        Thread{
            val stores = StoreAplication.database.storeDao().GetAllStores()
            queue.add( stores )
        }.start()


        madapter.setStores( queue.take() )
    }

    override fun OnClick(user: User) { }

    override fun OnClickTienda(store: StoreEntity) {
        TODO("Not yet implemented")
    }
}