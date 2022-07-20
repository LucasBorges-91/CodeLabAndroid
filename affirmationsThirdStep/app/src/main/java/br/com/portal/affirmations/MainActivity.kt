package br.com.portal.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.portal.affirmations.adapter.ItemAdapter
import br.com.portal.affirmations.data.Datasource
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataSet = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>( R.id.affirmations_rv )
        recyclerView.adapter = ItemAdapter( this, myDataSet )
        recyclerView.setHasFixedSize( true )
    }
}